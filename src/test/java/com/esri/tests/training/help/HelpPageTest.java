package com.esri.tests.training.help;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.ui.BaseTestUi;
import com.esri.sm.training.help.HelpPageFeatures;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;

/**
 * This test class to validate the Training Site Help Page
 * 
 * @author Rizwan
 *
 */

public class HelpPageTest extends BaseTestUi {

	private HelpPageFeatures helpPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public HelpPageTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Training Site Help Page
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "Help", "Regressions" }, priority = 1)
	public void ValidateHelpPage(Map<String, String> inputDataMap) {
		helpPageFeatures = new HelpPageFeatures(driver, inputDataMap);
		reportLogger.assertEquals(helpPageFeatures.retrieveTitle(), inputDataMap.get(CatalogPage.HOME_PAGE_TITLE),
				"Validate if the Training Home Page title is correct.");
		reportLogger.assertEquals(helpPageFeatures.retrieveTrainingLabel(),
				inputDataMap.get(CatalogPage.HOME_PAGE_HEADER_LABEL),
				"Validate if the Training Home Page header label is correct.");
		helpPageFeatures.clickOnHelpPageLink();
		reportLogger.assertEquals(helpPageFeatures.retrieveTitle(), inputDataMap.get(CatalogPage.HELP_PAGE_TITLE),
				"Validate if the Help Page Title is correct.");
		reportLogger.assertEquals(helpPageFeatures.retrieveHelpPageHeader(),
				inputDataMap.get(CatalogPage.HELP_PAGE_HEADER), "Validate if the Help Page header label is correct.");
		
		ValidateHelpPageSearchFunctinality(inputDataMap);
		
		closeTest();
	}

	/**
	 * Test to validate Help Page Search and Filters
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateHelpPageSearchFunctinality(Map<String, String> inputDataMap) {
		helpPageFeatures.search();
		reportLogger.assertTrue(helpPageFeatures.isSearchResultsAvailable(),
				"Validate if the Search results are correct.");
		helpPageFeatures.selectTheTrainingPassFilter();
		reportLogger.assertTrue(helpPageFeatures.isSearchResultsAvailable(),
				"Validate if the Search Filter results are correct.");
	}

}
