package com.esri.tests.training.main;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.ui.BaseTestUi;
import com.esri.sm.training.main.MainPageFeatures;
import com.esri.support.modules.core.TrainingConstants.MainPage;

/**
 * This is the Esri Traning - Main and its submenus page tests.
 * 
 * @author Rizwan & thenmozhiS
 */
public class MainPageTest extends BaseTestUi {

	private MainPageFeatures mainPageFeature;
	private String sTitle;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public MainPageTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Options And Formats Submenu Page.
	 * 
	 * @param inputDatamap
	 */
	@Test(dataProvider = "csv", groups = { "TrainingSite", "Regressions" }, priority = 1)
	public void ValidateMainMenu(Map<String, String> inputDataMap) {
		mainPageFeature = new MainPageFeatures(driver, inputDataMap);
		mainPageFeature.navigateToHomePage();
		mainPageFeature.clickOnOptionsFormatsSubMenu();
		reportLogger.assertEquals(mainPageFeature.retrieveTitle(),
				inputDataMap.get(MainPage.OPTIONS_AND_FORMATES_PAGE_TITLE),
				"Validate if the Main Sub Menu Options And Formats Page title is correct.");
		mainPageFeature.clickOnViewAllInstructorLedTrainingLink();
		reportLogger.assertEquals(mainPageFeature.retrieveTitle(), inputDataMap.get(MainPage.CATALOG_PAGE_TITLE),
				"Validate if the View All Instructor-Led Training Page title is correct.");
		mainPageFeature.navigateToOptionsFormatsPage();
		reportLogger.assertEquals(mainPageFeature.retrieveLocationLabel(), inputDataMap.get(MainPage.LOCATION_LABEL),
				"Validate if the Location Header Label is correct.");
		reportLogger.assertEquals(mainPageFeature.retrievePricingLabel(), inputDataMap.get(MainPage.PRICING_LABEL),
				"Validate if the Pricing Header Label is correct.");
		reportLogger.assertEquals(mainPageFeature.retrievePaymentLabel(), inputDataMap.get(MainPage.PAYMENT_LABEL),
				"Validate if the Payment Header Label is correct.");
		reportLogger.assertEquals(mainPageFeature.retrieveBenefitsLabel(), inputDataMap.get(MainPage.BENEFITS_LABEL),
				"Validate if the Benefits Header Label is correct.");
		mainPageFeature.clickOnHowToAccessELearningButton();
		reportLogger.assertEquals(mainPageFeature.retrieveTitle(), inputDataMap.get(MainPage.E_LEARNING_PAGE_TITLE),
				"Validate if the Get Started with E-Learning Page title is correct.");
		
		ValidateMainSubMenuTrainingForIndividualsPage(inputDataMap);
		ValidateMainSubMenuTrainingForOrganizationsPage(inputDataMap);
		ValidateMainSubMenuUnlimitedELearningPage(inputDataMap);
		
		closeTest();
	}

	/**
	 * Test to validate the Training For Individuals Submenu Page
	 * 
	 * @param inputDatamap
	 */
	public void ValidateMainSubMenuTrainingForIndividualsPage(Map<String, String> inputDataMap) {
		mainPageFeature.navigateToHomePage();
		mainPageFeature.clickOnTrainingForIndividualSubMenu();
		reportLogger.assertEquals(mainPageFeature.retrieveTitle(),
				inputDataMap.get(MainPage.TRAINING_FOR_INDIVIDUALS_PAGE_TITLE),
				"Validate if the Training for Individuals Page title is correct.");
		reportLogger.assertEquals(mainPageFeature.retrieveTrainingForIndividualsLabel(),
				inputDataMap.get(MainPage.TRAINING_FOR_INDIVIDUALS_PAGE_HEADER),
				"Validate if the Training for Individuals Page header is correct.");
		mainPageFeature.clickOnLearnMoreAboutUnlimitedAccessButton();
		reportLogger.assertEquals(mainPageFeature.retrieveTitle(), inputDataMap.get(MainPage.E_LEARNING_PAGE_TITLE),
				"Validate if the E-Learning Page title is correct.");
	}

	/**
	 * Test to validate Main Sub Menu Training For Organizations Page
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateMainSubMenuTrainingForOrganizationsPage(Map<String, String> inputDataMap) {
		mainPageFeature.navigateToHomePage();
		mainPageFeature.clickMenuSubmenuTrainingForOrganizations();
		reportLogger.assertEquals(mainPageFeature.retrieveTitle(), inputDataMap.get(MainPage.TRAINING_FOR_ORG_TITLE),
				"Validate if the title of the 'Training For Organizations' sub menu Page is correct.");
		String sHeader = mainPageFeature.retrieveTrainingPassTabHeader();
		reportLogger.assertEquals(sHeader, inputDataMap.get(MainPage.TRAINING_PASS_HEADER),
				"Validate if the header of the 'Training Pass' Page is correct.");
		sHeader = mainPageFeature.retrievePrivateClassesAndCoachingHeader();
		reportLogger.assertEquals(sHeader, inputDataMap.get(MainPage.PRIVATE_CLASSES_HEADER),
				"Validate if the header of the 'Private Classes And Coaching' Page is correct.");
		sHeader = mainPageFeature.retrieveEsriELearningInYourLMSHeader();
		reportLogger.assertEquals(sHeader, inputDataMap.get(MainPage.ESRI_ELEARNING_HEADER),
				"Validate if the header of the 'Esri E-Learning In Your LMS' Page is correct.");
		sTitle = mainPageFeature.retrieveMaintenanceProgramDetailsTitle();
		reportLogger.assertEquals(sTitle, inputDataMap.get(MainPage.MAINTENANCE_PROGRAM_TITLE),
				"Validate if the title of the 'Maintenance Program Details' Page is correct.");
	}

	/**
	 * Test to validate Main Sub Menu Unlimited E-Learning Page
	 * 
	 * @param inputDataMap
	 */
	public void ValidateMainSubMenuUnlimitedELearningPage(Map<String, String> inputDataMap) {
		mainPageFeature.navigateToHomePage();
		mainPageFeature.clickMenuSubmenuUnlimitedELearning();
		reportLogger.assertEquals(mainPageFeature.retrieveTitle(), inputDataMap.get(MainPage.UNLIMITED_ELEARNING_TITLE),
				"Validate if the title of the 'Unlimited E-Learning' sub menu Page is correct.");
		reportLogger.assertTrue(mainPageFeature.isUserAccessStatusIsCorrect(),
				"Validate if the content of the 'Access Status' after SignIn is matching.");
		reportLogger.assertTrue(
				mainPageFeature.retrieveAccessMyEsriAdministratorToolsPageTitle()
						.contains(inputDataMap.get(MainPage.ACCESS_MY_ESRI_TITLE)),
				"Validate if the title of the 'Access My Esri Administrator Tools' Page is correct.");
		String sHeader = mainPageFeature.retrieveViewCommonQuestionsPageHeader();
		reportLogger.assertEquals(sHeader, inputDataMap.get(MainPage.VIEW_COMMON_QUESTIONS_HEADER),
				"Validate if the header of the 'View Common Questions' Page is correct.");
		mainPageFeature.navigateToHomePage();
	}

}
