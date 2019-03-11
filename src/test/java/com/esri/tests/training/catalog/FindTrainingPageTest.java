package com.esri.tests.training.catalog;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.ui.BaseTestUi;
import com.esri.sm.training.catalog.FindTrainingPageFeatures;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;

/**
 * This test class to validate Catalog sub menu Find Training Page
 * 
 * @author Rizwan
 *
 */

public class FindTrainingPageTest extends BaseTestUi {

	private FindTrainingPageFeatures findTrainingPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public FindTrainingPageTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate Catalog Sub Menu Find Training page
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "FindTraining", "Regressions" }, priority = 1)
	public void ValidateCatalogSubMenuFindTrainingPage(Map<String, String> inputDataMap) {
		findTrainingPageFeatures = new FindTrainingPageFeatures(driver, inputDataMap);
		reportLogger.assertEquals(findTrainingPageFeatures.retrieveTitle(),
				inputDataMap.get(CatalogPage.HOME_PAGE_TITLE), "Validate if the Training Home Page title is correct.");
		findTrainingPageFeatures.clickOnFindTrainingSubMenu();
		reportLogger.assertEquals(findTrainingPageFeatures.retrieveTitle(),
				inputDataMap.get(CatalogPage.FIND_TRAINING_PAGE_TITLE),
				"Validate if the Catalog Sub Menu Find Training Page title is correct.");
		
		ValidateCatalogSubMenuFindTrainingSearchFunctionality(inputDataMap);
		ValidateLearningFormatFilters(inputDataMap);
		ValidateInstructorLedFilterCardsHasInstructorLedContext(inputDataMap);
		ValidateBooksFilterCardsHasBooksContext(inputDataMap);
		ValidateFreeTrainingFilterCardsHasFREEContext(inputDataMap);
		ValidateCourseIsAddedToWishist(inputDataMap);
		closeTest();
	}

	/**
	 * Test to validate Catalog Sub Menu Find Training Page Search and Filters
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateCatalogSubMenuFindTrainingSearchFunctionality(Map<String, String> inputDataMap) {
		findTrainingPageFeatures.search();
		reportLogger.assertTrue(findTrainingPageFeatures.isSearchResultsAvailable(),
				"Validate if the Search results are available.");
		reportLogger.assertTrue(findTrainingPageFeatures.isListViewSuccessful(),
				"Validate if the Search results List View is correct.");
		reportLogger.assertTrue(findTrainingPageFeatures.isGridViewSuccessful(),
				"Validate if the Search results Grid View is correct.");
		findTrainingPageFeatures.selectTheFilters();
		reportLogger.assertTrue(findTrainingPageFeatures.isSearchResultsAvailable(),
				"Validate if the Search Filter results are correct.");
		findTrainingPageFeatures.clickOnRemoveFilters();
		findTrainingPageFeatures.clickOnAvailableWithMaintenance();
		reportLogger.assertTrue(findTrainingPageFeatures.isSearchResultsAvailable(),
				"Validate if the Search Filter Available With Maintenance Results are correct.");
	}

	/**
	 * Test to validate Find Training Page Learning Format Filters
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateLearningFormatFilters(Map<String, String> inputDataMap) {
		findTrainingPageFeatures.selectTheWebCourseFilter();
		reportLogger.assertTrue(findTrainingPageFeatures.isSearchResultsAvailable(),
				"Validate if the Web Course Filter Search results are correct.");
		findTrainingPageFeatures.selectTheTrainingSeminarsFilter();
		reportLogger.assertTrue(findTrainingPageFeatures.isSearchResultsAvailable(),
				"Validate if the Training Seminars Filter Search results are correct.");
		findTrainingPageFeatures.selectTheVideosFilter();
		reportLogger.assertTrue(findTrainingPageFeatures.isSearchResultsAvailable(),
				"Validate if the Videos Filter Search results are correct.");
		findTrainingPageFeatures.clickClearSearchButton();
		findTrainingPageFeatures.clickOnRemoveFilters();
	}

	/**
	 * Test to validate 'Instructor-Led' is present in all the cards.
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateInstructorLedFilterCardsHasInstructorLedContext(Map<String, String> inputDataMap) {
		findTrainingPageFeatures.filterInstructorLedCoursesOnly();
		boolean isAllTheCardsHasInstructorLedContext = findTrainingPageFeatures
				.isExpectedLearningFormatContextPresent(CatalogPage.INSTRUCTOR_LED_FORMAT);
		int iTotalCards = findTrainingPageFeatures.getTotalCards();
		reportLogger
				.info("Total " + CatalogPage.INSTRUCTOR_LED_FORMAT + " cards present in the page are : " + iTotalCards);
		reportLogger.assertTrue(isAllTheCardsHasInstructorLedContext,
				"Validate if the 'Instructor-Led' context is present in all the " + iTotalCards
						+ " cards after filtering 'Instructor-Led'.");
		findTrainingPageFeatures.clickOnRemoveFilters();
	}

	/**
	 * Test to validate 'Books' is present in all the cards.
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateBooksFilterCardsHasBooksContext(Map<String, String> inputDataMap) {
		findTrainingPageFeatures.clickAllLearningFormatsFilterAndSelectBooks();
		boolean isAllTheCardsHasBooksContext = findTrainingPageFeatures
				.isExpectedLearningFormatContextPresent(CatalogPage.BOOKS_FORMAT);
		int iTotalCards = findTrainingPageFeatures.getTotalCards();
		reportLogger.info("Total " + CatalogPage.BOOKS_FORMAT + " cards present in the page are : " + iTotalCards);
		reportLogger.assertTrue(isAllTheCardsHasBooksContext,
				"Validate if the 'Book' context is present all the " + iTotalCards + " cards after filtering 'Books'.");
		findTrainingPageFeatures.clickOnRemoveFilters();
	}

	/**
	 * Test to validate 'FREE' is present in all the cards.
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateFreeTrainingFilterCardsHasFREEContext(Map<String, String> inputDataMap) {
		findTrainingPageFeatures.clickOnFreeTraining();
		boolean isAllTheCardsHasFREEContext = findTrainingPageFeatures
				.isExpectedLearningFormatContextPresent(CatalogPage.FREE_TRAINING);
		int iTotalCards = findTrainingPageFeatures.getTotalCards();
		reportLogger.info("Total " + CatalogPage.FREE_TRAINING + " cards present in the page are : " + iTotalCards);
		reportLogger.assertTrue(isAllTheCardsHasFREEContext, "Validate if the 'FREE' context is present in all the "
				+ iTotalCards + " cards after selecting 'Free Training' checkbox.");
	}

	/**
	 * Test to validate Course Added To Wishist is present in the 'Dashboard -
	 * view all wishList' page.
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateCourseIsAddedToWishist(Map<String, String> inputDataMap) {
		findTrainingPageFeatures.clickOnFreeTraining();
		findTrainingPageFeatures.selectTheWebCourseFilter();
		String courseTitle = findTrainingPageFeatures.retriveCourseTitleAndAddItToWishlist();
		reportLogger.info("Title of the Course added to wishlist is : " + courseTitle);
		boolean isCoursePresentInTheWishlistPage = findTrainingPageFeatures
				.isAddedCoursePresentInDashboardWishlistPage(courseTitle);
		reportLogger.assertTrue(isCoursePresentInTheWishlistPage,
				"Validate if the Course Added to wishlist is present in the Dashboard wishlist page. Course Title : "
						+ courseTitle);
	}

}
