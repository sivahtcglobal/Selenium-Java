package com.esri.tests.adobe.analytics;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.esri.qa.adobe.analytics.AdobeAnalytics;
import com.esri.qa.adobe.analytics.ESRIAdobeAnalyticsNetworkTraffic;
import com.esri.qa.adobe.analytics.HarDataBean;
import com.esri.qa.reporting.Log;
import com.esri.qa.reporting.ReportLogger;
import com.esri.qa.testng.Data;
import com.esri.qa.testng.TestNGUtilities;
import com.esri.qa.ui.Browser;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.Constants.EsriDomainInAdobeAnalytics;

/**
 * This test class to validate the Adobe Analytics features for each domain of
 * ESRI
 * 
 * @author anushar
 */
public class EsriAdobeAnalyticsTest {

	private PageObjects pageObject;
	private ReportLogger reportLogger;
	private Browser browser;
	private ESRIAdobeAnalyticsNetworkTraffic network;

	@BeforeMethod(alwaysRun = true)
	public void initializeReport(ITestResult tr) {
		this.network = new ESRIAdobeAnalyticsNetworkTraffic();
		try {
			this.browser = new Browser(network.getHTTPPRoxy());
		} catch (UnknownHostException e) {
			Log.error("Unknown error occured");
		}
		tr.setAttribute("driver", browser.getDriver());
		this.reportLogger = new ReportLogger(browser.getDriver(), tr, false);
	}

	/**
	 * Test to validate the each ESRI domain having adobe analytics scripts
	 * 
	 * @param inputDatamap
	 */
	
	@Data(fileName = "src/test/resources/data/careers/adobeanalytics/AdobeAnalyticsTestData.csv", startRow = 1, endRow = 27)
	@Test(dataProvider = "csvAnnotatedData", groups = { "Sanity",
			"Regressions" }, dataProviderClass = TestNGUtilities.class)
	public void ValidateAvailaibilityOfAdobeAnalyticsScripts(Map<String, String> inputDatamap) {
		boolean isSuccess = false;
		pageObject = new PageObjects(browser.getDriver());
		pageObject.openURL(inputDatamap.get(EsriDomainInAdobeAnalytics.DOMAIN_URL));
		List<HarDataBean> networkTraffic = network.retrieveNetworkRequests();
		AdobeAnalytics analytics = new AdobeAnalytics(browser.getDriver());

		reportLogger.assertTrue(analytics.isFooterScriptExists(), "Validate if the Footer script is available");
		reportLogger.assertTrue(analytics.isGoogleTagScriptExists(), "Validate if the Google Tag script is available");
		reportLogger.assertTrue(analytics.isHeaderScriptExists(), "Validate if the Header script is available");
		reportLogger.assertTrue(analytics.isPardotScriptExists(), "Validate if the Pardot script is available");

		for (HarDataBean harData : networkTraffic) {
			int statusCode = harData.getStatus();
			if (statusCode == 302 || statusCode == 200) {
				isSuccess = true;
			}
			reportLogger.assertTrue(isSuccess, "The response should be either 200 or 302 for the request "
					+ harData.getEndPoint() + ":" + statusCode);
		}
		reportLogger.assertAll();
	}

	@AfterMethod
	public void tearBrowser() {
		pageObject.quitBrowser();
	}

}
