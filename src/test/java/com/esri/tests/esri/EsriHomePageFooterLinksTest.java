package com.esri.tests.esri;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.BaseTestUi;
import com.esri.support.modules.core.Constants.SiteCoreHomePage;
import com.esri.support.modules.esri.EsriPageFeatures;

/**
 * 
 * Test Class to test Esri.com features within the page *
 * 
 * @author thenmozhiS
 *
 */
public class EsriHomePageFooterLinksTest extends BaseTestUi {

	private Map<String, String> results;
	public EsriPageFeatures esriObject;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EsriHomePageFooterLinksTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Fat Footer Links
	 * 
	 * @param inputDatamap
	 */
	@Test(dataProvider = "csv", priority = 1, enabled = true)
	public void ValidateESRIFootersAndItsLinks(Map<String, String> inputDatamap) {
		esriObject = new EsriPageFeatures(driver, inputDatamap);
		esriObject.openUrl();
		List<String> linkNames = esriObject.getFooterLinksNameList(SiteCoreHomePage.FOOTER);
		linkNames.removeAll(Arrays.asList("", null));
		reportLogger.info("Total footer links to validate: " + linkNames.size());

		for (int i = 0; i < linkNames.size(); i++) {
			results = esriObject.getFooterLinkValues(SiteCoreHomePage.FOOTER, i);
			for (String resultKey : results.keySet()) {
				if (inputDatamap.containsKey(resultKey)) {
					Log.info("Input Data : " + resultKey + " = " + inputDatamap.get(resultKey));
					reportLogger.assertEquals(results.get(resultKey), inputDatamap.get(resultKey),
							"Validate the " + resultKey + " of " + SiteCoreHomePage.FOOTER + " is correct.");
				} else {
					reportLogger.error("Footer Key doesn't exist in input data sheet - " + resultKey);
				}
			}
		}
		ValidateSmallFootersAndItsLinks(inputDatamap);
		closeTest();
	}

	/**
	 * Test to validate the Small Footer Links
	 * 
	 * @param inputDatamap
	 */
	public void ValidateSmallFootersAndItsLinks(Map<String, String> inputDatamap) {
		esriObject = new EsriPageFeatures(driver, inputDatamap);
		esriObject.clickEsriLogo();
		List<String> linkNames = esriObject.getSmallFooterLinksNameList(SiteCoreHomePage.FOOTER);
		linkNames.removeAll(Arrays.asList("", null));
		reportLogger.info("Total Small footer links to validate: " + linkNames.size());

		for (int i = 0; i < linkNames.size(); i++) {
			results = esriObject.getFooterSmallLinksValues(SiteCoreHomePage.FOOTER, i);
			for (String resultKey : results.keySet()) {
				if (inputDatamap.containsKey(resultKey)) {
					Log.info("Input Data : " + resultKey + " = " + inputDatamap.get(resultKey));
					reportLogger.assertEquals(results.get(resultKey), inputDatamap.get(resultKey),
							"Validate the " + resultKey + " of " + SiteCoreHomePage.FOOTER + " is correct.");
				} else {
					reportLogger.error("Small Footer Key doesn't exist in input data sheet - " + resultKey);
				}
			}
		}
	}

}
