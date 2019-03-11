package com.esri.tests.training.catalog;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.ui.BaseTestUi;
import com.esri.sm.training.catalog.EventSchedulePageFeatures;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;

/**
 * This test class to validate Catalog sub menu Event Schedule Page
 * 
 * @author Rizwan
 *
 */

public class EventSchedulePageTest extends BaseTestUi {

	private EventSchedulePageFeatures eventSchedulePageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EventSchedulePageTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**		
	 * Test to validate Catalog Sub Menu Find Training page
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "EventSchedule", "Regressions" }, priority = 1)
	public void ValidateCatalogSubMenuEventSchedulePage(Map<String, String> inputDataMap) {
		eventSchedulePageFeatures = new EventSchedulePageFeatures(driver, inputDataMap);
		reportLogger.assertEquals(eventSchedulePageFeatures.getTitle(), inputDataMap.get(CatalogPage.HOME_PAGE_TITLE),
				"Validate if the Training Home Page title is correct.");
		eventSchedulePageFeatures.clickOnEventScheduleSubMenu();
		reportLogger.assertTrue(eventSchedulePageFeatures.retrieveSearchBoxDefaultText(),
				"Validate if the Catalog Sub Menu Event Schedule Page is loaded successfully.");
		reportLogger.assertEquals(eventSchedulePageFeatures.getTitle(),
				inputDataMap.get(CatalogPage.EVENT_SCHEDULE__PAGE_TITLE),
				"Validate if the Catalog Sub Menu Event Schedule Page title is correct.");
		
		ValidateCatalogSubMenuFindTrainingSearchFunctionality(inputDataMap);
		ValidateInstructorLedFilterCardsHasInstructorLedContext(inputDataMap);
		ValidateOnlineFilterCardsHasOnlineContext(inputDataMap);
		closeTest();
	}

	/**
	 * Test to validate Catalog Sub Menu Event Schedule Page Search and Filters
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateCatalogSubMenuFindTrainingSearchFunctionality(Map<String, String> inputDataMap) {
		eventSchedulePageFeatures.search();
		eventSchedulePageFeatures = new EventSchedulePageFeatures(driver, inputDataMap);
		reportLogger.assertTrue(eventSchedulePageFeatures.isSearchResultsAvailable(),
				"Validate if the Search results are correct.");
		eventSchedulePageFeatures.selectTheFiltersForCatalog();
		reportLogger.assertTrue(eventSchedulePageFeatures.isSearchResultsAvailable(),
				"Validate if the Search Filter results are correct.");
		eventSchedulePageFeatures.selectDateRange();
		reportLogger.assertTrue(eventSchedulePageFeatures.isSearchResultsAvailable(),
				"Validate if the Date Range Filter results are correct.");
	}

	/**
	 * Test to validate 'Instructor-Led' context is present in all the cards.
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateInstructorLedFilterCardsHasInstructorLedContext(Map<String, String> inputDataMap) {
		eventSchedulePageFeatures.clickClearSearchButton();
		eventSchedulePageFeatures.clickOnRemoveFilters();
		eventSchedulePageFeatures.clickOnEventScheduleSubMenu();
		eventSchedulePageFeatures.clickAllLearningFormatsFilterAndSelectInstructorLed();
		boolean isAllTheCardsHasInstructorLedContext = eventSchedulePageFeatures
				.isExpectedContextPresent(CatalogPage.INSTRUCTOR_LED_FORMAT);
		int totalInstructorLedCards = eventSchedulePageFeatures.getTotalCards();
		reportLogger.info("Total " + CatalogPage.INSTRUCTOR_LED_FORMAT + " cards present in the page are : "
				+ totalInstructorLedCards);
		reportLogger.assertTrue(isAllTheCardsHasInstructorLedContext,
				"Validate if the 'Instructor-Led' Learning Format context is present in all " + totalInstructorLedCards
						+ " cards after filtering 'Instructor-Led'.");
	}

	/**
	 * Test to validate 'Online' Location context is present in all the cards.
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateOnlineFilterCardsHasOnlineContext(Map<String, String> inputDataMap) {
		eventSchedulePageFeatures.clickOnRemoveFilters();
		eventSchedulePageFeatures.clickAllLocationsFilterAndSelectOnline();
		boolean isAllTheCardsHasOnlineLink = eventSchedulePageFeatures
				.isExpectedContextPresent(CatalogPage.ONLINE_LOCATIONS);
		int totalOnlineCards = eventSchedulePageFeatures.getTotalCards();
		reportLogger
				.info("Total " + CatalogPage.ONLINE_LOCATIONS + " cards present in the page are : " + totalOnlineCards);
		reportLogger.assertTrue(isAllTheCardsHasOnlineLink,
				"Validate if the 'Online' Location context is present all the " + totalOnlineCards
						+ " cards after filtering 'Online'.");
	}

}
