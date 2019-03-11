package com.esri.tests.training.mylearning;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.ui.BaseTestUi;
import com.esri.sm.training.mylearning.MylearningPageFeatures;
import com.esri.support.modules.core.TrainingConstants.MainPage;
import com.esri.support.modules.core.TrainingConstants.MyLearningPage;

/**
 * This is the Esri Traning MyLearning and its submenus page tests.
 * 
 * @author thenmozhiS
 */
public class MyLearningPageTest extends BaseTestUi {

	private MylearningPageFeatures myLearningPageFeature;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public MyLearningPageTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate Landing and Sign In Page.
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "TrainingSite", "Regressions" }, priority = 1)
	public void ValidateSignInPageAndMyLearningMenu(Map<String, String> inputDataMap) {
		myLearningPageFeature = new MylearningPageFeatures(driver, inputDataMap);
		myLearningPageFeature.navigateToHomePage();
		reportLogger.assertEquals(myLearningPageFeature.retrieveTitle(), inputDataMap.get(MyLearningPage.TITLE),
				"Validate if the Training Home Page title is correct.");
		myLearningPageFeature.signIn();
		String traningPageHeader = myLearningPageFeature.getTrainingPageHeader();
		reportLogger.assertEquals(traningPageHeader, inputDataMap.get(MainPage.HEADER),
				"Validate if the 'Sign In' label is changed to 'Training' after successful SignIn.");
		
		ValidateMyLearningSubMenuDashboardPage(inputDataMap);
		ValidateMyLearningSubMenuLearningActivityPage(inputDataMap);
		ValidateMyLearningSubMenuSchedulePage(inputDataMap);
		ValidateMyLearningSubMenuLeaningPlansPage(inputDataMap);
		ValidateMyLearningSubMenuWishListPage(inputDataMap);		
		closeTest();
	}

	/**
	 * Test to validate My Learning Sub Menu Dashboard Page. INCOMPLETE
	 * 
	 * @param inputDataMap
	 */
	public void ValidateMyLearningSubMenuDashboardPage(Map<String, String> inputDataMap) {
		myLearningPageFeature = new MylearningPageFeatures(driver, inputDataMap);
		myLearningPageFeature.clickMyLearningSubmenuDashboard();
		reportLogger.assertEquals(myLearningPageFeature.retrieveTitle(),
				inputDataMap.get(MyLearningPage.DASHBOARD_TITLE),
				"Validate if the title of the 'Dashboard' sub menu Page is correct.");
		// check for all the 4 cards that their size is not 0
		myLearningPageFeature.accessDashboardWishListLink();
		reportLogger.assertEquals(myLearningPageFeature.retrieveTitle(),
				inputDataMap.get(MyLearningPage.WISHLIST_TITLE),
				"Validate if the title of the 'Wish List' Page is correct.");
	}

	/**
	 * Test to validate My Learning Sub Menu Learning Activity Page.
	 * 
	 * @param inputDataMap
	 */
	public void ValidateMyLearningSubMenuLearningActivityPage(Map<String, String> inputDataMap) {
		myLearningPageFeature = new MylearningPageFeatures(driver, inputDataMap);
		myLearningPageFeature.navigateToHomePage();
		myLearningPageFeature.clickMyLearningSubmenuLearningActivity();
		reportLogger.assertEquals(myLearningPageFeature.retrieveTitle(),
				inputDataMap.get(MyLearningPage.LEARNING_ACTIVITY_TITLE),
				"Validate if the title of the 'Learning Activity' sub menu Page is correct.");
		int searchResultCount = myLearningPageFeature.learningActivitySearchFunctionality();
		reportLogger.assertTrue(searchResultCount > 0,
				"Validate the search results count of the 'Learning Activity' page.");
		String downloadTranscriptUrl = myLearningPageFeature.getDownloadTransriptPageUrl();
		reportLogger.assertEquals(downloadTranscriptUrl, inputDataMap.get(MyLearningPage.DOWNLOAD_SCRIPT_URL),
				"Validate if the title of the 'DownLoad Transcript' Page Url is correct.");
	}

	/**
	 * Test to validate My Learning Sub Menu Schedule Page. REDO - INCOMPLETE
	 * 
	 * @param inputDataMap
	 */
	public void ValidateMyLearningSubMenuSchedulePage(Map<String, String> inputDataMap) {
		myLearningPageFeature = new MylearningPageFeatures(driver, inputDataMap);
		myLearningPageFeature.navigateToHomePage();
		myLearningPageFeature.clickMyLearningSubmenuSchedule();
		reportLogger.assertEquals(myLearningPageFeature.retrieveTitle(),
				inputDataMap.get(MyLearningPage.SCHEDULE_TITLE),
				"Validate if the title of the 'Schedule' sub menu Page is correct.");
		/*String scheduleCardTitle = myLearningPageFeature.getTitleOfScheduleCardFormat();
		reportLogger.assertEquals(scheduleCardTitle, myLearningPageFeature.getHeaderOfScheduleCardPage(),
				"Validate if the 'Course Type' of the 'Schedule' Card is matching.");*/
	}

	/**
	 * Test to validate My Learning Sub Menu Leaning Plans Page.
	 * 
	 * @param inputDataMap
	 */
	public void ValidateMyLearningSubMenuLeaningPlansPage(Map<String, String> inputDataMap) {
		MylearningPageFeatures mylearningPageFeature = new MylearningPageFeatures(driver, inputDataMap);
		mylearningPageFeature.navigateToHomePage();
		mylearningPageFeature.clickMyLearningSubmenuLearningPlans();
		reportLogger.assertEquals(mylearningPageFeature.retrieveTitle(),
				inputDataMap.get(MyLearningPage.LEARNING_PLANS_TITLE),
				"Validate if the title of the 'Leaning Plans' sub menu Page is correct.");
		String learningPlansCardHeader = mylearningPageFeature.getLearningPlansTypeHeader();
		reportLogger.assertEquals(learningPlansCardHeader, mylearningPageFeature.getHeaderOfLearningPlansCardPage(),
				"Validate if the header of the 'Learning Plans' Card is matching.");
	}

	/**
	 * Test to validate My Learning Sub Menu WishList Page.
	 * 
	 * @param inputDataMap
	 */
	public void ValidateMyLearningSubMenuWishListPage(Map<String, String> inputDataMap) {
		MylearningPageFeatures mylearningPageFeature = new MylearningPageFeatures(driver, inputDataMap);
		mylearningPageFeature.navigateToHomePage();
		mylearningPageFeature.clickMyLearningSubmenuWishList();
		reportLogger.assertEquals(mylearningPageFeature.retrieveTitle(),
				inputDataMap.get(MyLearningPage.WISHLIST_TITLE),
				"Validate if the title of the 'WishList' sub menu Page is correct.");
		String filterName = mylearningPageFeature.getWishListFilterName();
		reportLogger.assertEquals(filterName, inputDataMap.get(MyLearningPage.WISLIST_FILTER_NAME),
				"Validate if the Filter Name 'Web Course' is correct.");
		mylearningPageFeature.clickHowToAccessBtnInWishListPage();
		reportLogger.assertEquals(mylearningPageFeature.retrieveTitle(),
				inputDataMap.get(MyLearningPage.HOWTOACCESS_PAGE_TITLE),
				"Validate if the title of the 'How To Access' Page is correct.");
	}

}
