package com.esri.tests.esri;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
public class EsriHomePageSupportMegamenuTest extends BaseTestUi {

	private Map<String, String> results;
	public EsriPageFeatures esriPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EsriHomePageSupportMegamenuTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Support And Services MegaMenu and Its Sub-menus
	 * 
	 * @param inputDatamap
	 */
	@Test(dataProvider = "csv", enabled = true)
	public void ValidateSupportAndServicesMegaMenuAndItsDropDowns(Map<String, String> inputDatamap) {
		esriPageFeatures = new EsriPageFeatures(driver, inputDatamap);
		esriPageFeatures.openUrl();
		esriPageFeatures.signIn();
		List<String> linkNames = esriPageFeatures.getFirstLevelLinksNameList(SiteCoreHomePage.SUPPORT_MENU);
		reportLogger.info("Total First Level Support Menu links to validate: " + linkNames.size());
		for (int i = 0; i < linkNames.size(); i++) {
			results = esriPageFeatures.getFirstLevelLinkValues(SiteCoreHomePage.SUPPORT_MENU, i);
			for (String resultKey : results.keySet()) {
				if (inputDatamap.containsKey(resultKey)) {
					Log.info("Result " + resultKey + "Sheet" + inputDatamap.get(resultKey));
					reportLogger.assertEquals(results.get(resultKey), inputDatamap.get(resultKey), "Validate the "
							+ resultKey + " of " + SiteCoreHomePage.SUPPORT_MENU + " megamenu is correct.");
				} else {
					reportLogger
							.error("First level Support menu link doesn't exist in input data sheet - " + resultKey);
				}
			}
		}

		// second level links
		linkNames = esriPageFeatures.getSecondLevelLinksNameList(SiteCoreHomePage.SUPPORT_MENU);
		reportLogger.info("Total Second Level Support Menu links to validate: " + linkNames.size());
		for (int i = 0; i < linkNames.size(); i++) {

			// list linknames contains empty strings for the first level links,
			// those can't be clicked using second level webelement links,
			// by pass them when the string is empty and move to next element.
			if (StringUtils.isBlank(linkNames.get(i))) {
				i++;
			}
			results = esriPageFeatures.getSecondLevelLinkValues(SiteCoreHomePage.SUPPORT_MENU, i);
			for (final String resultKey : results.keySet()) {
				if (inputDatamap.containsKey(resultKey)) {
					if (resultKey.equals(SiteCoreHomePage.START_CHAT_TITLE)) {
						reportLogger.assertTrue(results.get(resultKey).contains(inputDatamap.get(resultKey)),
								"Validate the " + resultKey + " of " + SiteCoreHomePage.SUPPORT_MENU
										+ " megamenu is correct.");
					} else {
						reportLogger.assertEquals(results.get(resultKey), inputDatamap.get(resultKey), "Validate the "
								+ resultKey + " of " + SiteCoreHomePage.SUPPORT_MENU + " megamenu is correct.");
					}
				} else {
					reportLogger
							.error("Second level Support menu link doesn't exist in input data sheet - " + resultKey);
				}
			}
		}
		closeTest();
	}

}
