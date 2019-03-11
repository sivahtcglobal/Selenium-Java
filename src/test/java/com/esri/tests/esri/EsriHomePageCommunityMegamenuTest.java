package com.esri.tests.esri;

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
public class EsriHomePageCommunityMegamenuTest extends BaseTestUi {

	private Map<String, String> results;
	public EsriPageFeatures esriObject;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EsriHomePageCommunityMegamenuTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Community MegaMenu and Its Sub-menus
	 * 
	 * @param inputDatamap
	 */
	@Test(dataProvider = "csv", enabled = true)
	public void ValidateESRICommunityMegaMenuAndItsDropDowns(Map<String, String> inputDatamap) {
		esriObject = new EsriPageFeatures(driver, inputDatamap);
		esriObject.openUrl();
		List<String> linkNames = esriObject.getFirstLevelLinksNameList(SiteCoreHomePage.COMMUNITY_MENU);
		reportLogger.info("Total First Level Community links to validate: " + linkNames.size());
		for (int i = 0; i < linkNames.size(); i++) {
			results = esriObject.getFirstLevelLinkValues(SiteCoreHomePage.COMMUNITY_MENU, i);
			for (final String resultKey : results.keySet()) {
				if (inputDatamap.containsKey(resultKey)) {
					Log.info("Input Data : " + resultKey + " = " + inputDatamap.get(resultKey));
					reportLogger.assertEquals(results.get(resultKey), inputDatamap.get(resultKey), "Validate the "
							+ resultKey + " of " + SiteCoreHomePage.COMMUNITY_MENU + " megamenu is correct.");
				} else {
					reportLogger.error("First Level Community link doesn't exist in input data sheet - " + resultKey);
				}
			}
		}

		// Validate second level links
		linkNames = esriObject.getSecondLevelLinksNameList(SiteCoreHomePage.COMMUNITY_MENU);
		reportLogger.info("Total Second Level Community links to validate: " + linkNames.size());
		for (int i = 0; i < linkNames.size(); i++) {
			results = esriObject.getSecondLevelLinkValues(SiteCoreHomePage.COMMUNITY_MENU, i);
			for (final String resultKey : results.keySet()) {
				if (inputDatamap.containsKey(resultKey)) {
					Log.info("Input Data : " + resultKey + " = " + inputDatamap.get(resultKey));
					reportLogger.assertEquals(results.get(resultKey), inputDatamap.get(resultKey), "Validate the "
							+ resultKey + " of " + SiteCoreHomePage.COMMUNITY_MENU + " megamenu is correct.");
				} else {
					reportLogger.error("Second level Community link doesn't exist in input data sheet - " + resultKey);
				}
			}
		}
		closeTest();
	}

}
