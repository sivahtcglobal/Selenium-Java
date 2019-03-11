package com.esri.tests.esri;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.adobe.analytics.AdobeAnalytics;
import com.esri.qa.config.Env;
import com.esri.qa.ui.BaseTestUi;
import com.esri.qa.ui.PageObjects;

/**
 * 
 * Test Class to test Esri.com calling the adobe analytics
 * 
 * @author Deenesh
 *
 */
public class EsriHomePageAdobeAnalyticsTest extends BaseTestUi {

	
	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EsriHomePageAdobeAnalyticsTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
		this.url = url;
	}

	/**
	 * Test to validate the About MegaMenu and Its Sub-menus
	 * 
	 * @param inputDatamap
	 */
	@Test
	public void ValidateAvailaibilityOfAdobeAnalyticsScripts() {
		PageObjects pageObject = new PageObjects(driver);
		pageObject.openURL(Env.get("ADOBEANALYTICS"));
		AdobeAnalytics analytics = new AdobeAnalytics(driver);
		reportLogger.assertTrue(analytics.isFooterScriptExists(), "Validate if the Footer script is available");
		reportLogger.assertTrue(analytics.isGoogleTagScriptExists(), "Validate if the Google Tag script is available");
		reportLogger.assertTrue(analytics.isHeaderScriptExists(), "Validate if the Header script is available");
		reportLogger.assertTrue(analytics.isPardotScriptExists(), "Validate if the Pardot script is available");
		closeTest();
	}

}
