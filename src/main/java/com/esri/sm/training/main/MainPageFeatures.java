package com.esri.sm.training.main;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.config.Env;
import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.SignInPageFeatures;
import com.esri.support.modules.core.TrainingConstants.MainPage;

/**
 * This is the Esri Traning - Main sub menus page feature class.
 * 
 * @author Rizwan & Thenmozhi
 *
 */
public class MainPageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private WebDriver driver;
	private MainPageObjects mainPageObject;
	String parrentWin;
	private SignInPageFeatures signInPageFeatures;
	
	/**
	 * Constructor to initialize the Training site Main page
	 * 
	 * @param driver,
	 * @param inputDataMap
	 */
	public MainPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.driver = driver;
		this.inputDataMap = inputDataMap;
		this.mainPageObject = new MainPageObjects(driver);
		signInPageFeatures = new SignInPageFeatures(driver, inputDataMap);
	}
	
	/**
	 * Navigate to training home page.
	 */
	public void navigateToHomePage() {
		openURL(Env.get("TRAINING"));
	}

	/**
	 * * Retrieve the Page title.
	 * 
	 * @return String
	 */
	public String retrieveTitle() {
		waitForPageToLoad();
		return getTitle();
	}
	
	/**
	 * Performing the mouse over action to Main and click on Option and Formats sub menu.
	 * 
	 */
	public void clickOnOptionsFormatsSubMenu() {
		hoverMouseOver(mainPageObject.MainDropDown);
		click(mainPageObject.optionsAndFormatsSubMenuLink);
	}
	
	/**
	 * Navigate to Main menu page.
	 * 
	 */
	public void navigateToMainPage() {
		openURL(Env.get("TRAINING"));
	}

	/**
	 * Performing the browser back button click
	 * 
	 */
	public void navigateToOptionsFormatsPage() {
		openURL(inputDataMap.get(MainPage.OPTIONS_FORMATS_URL));
	}
	
	/**
	 * Performing the click event for 'View All Instructor-Led' Training Link.
	 * 
	 */
	public void clickOnViewAllInstructorLedTrainingLink() {
		click(mainPageObject.viewAllInstructorLedTrainingButton);
	}

	/**
	 * Retrieve the Location Label
	 * 
	 * @return String
	 */
	public String retrieveLocationLabel() {
		scrollIntoViewByElement(mainPageObject.locationLink);
		click(mainPageObject.locationLink);
		return getText(mainPageObject.aConvenientLocationNearYouText);
	}

	/**
	 * Retrieve the Pricing Label
	 * 
	 * @return String
	 */
	public String retrievePricingLabel() {
		click(mainPageObject.pricingLink);
		return getText(mainPageObject.pricingText);
	}
	
	/**
	 * Retrieve the Payment Label
	 * 
	 * @return String
	 */
	public String retrievePaymentLabel() {
		click(mainPageObject.paymentLink);
		return getText(mainPageObject.paymentOptionsText);
	}
	
	/**
	 * Retrieve the Benefits Label
	 * 
	 * @return String
	 */
	public String retrieveBenefitsLabel() {
		click(mainPageObject.benefitsLink);
		return getText(mainPageObject.benefitsText);
	}
	
	/**
	 * Performing the click event How to Access E-Learning
	 * 
	 */
	public void clickOnHowToAccessELearningButton() {
		click(mainPageObject.howToAccessELearningLink);
	}
	
	/**
	 * Performing the mouse over action to Main and click on Training for Individuals sub menu. 
	 * 
	 * 
	 */
	public void clickOnTrainingForIndividualSubMenu() {
		navigateToMainPage();
		hoverMouseOver(mainPageObject.MainDropDown);
		click(mainPageObject.trainingForIndividualsSubMenuLink);
	}
	
	/**
	 * Retrieve the Training for Individuals Label
	 * 
	 * @return String
	 */
	public String retrieveTrainingForIndividualsLabel() {
		return getText(mainPageObject.trainingForIndividualsHeaderLabel);
	}
	
	/**
	 * Performing the click event for Learn More About Unlimited Access. 
	 * 
	 */
	public void clickOnLearnMoreAboutUnlimitedAccessButton() {
		clickAfterScroll(mainPageObject.learnMoreAboutUnlimitedAccessButton);
		waitForPageToLoad();
	}
	
	/**
	 * Retrieve the Training for Individuals Label
	 * 
	 * @return String
	 */
	public String getTrainingPageHeader() {
		return getText(mainPageObject.pageHeader);
	}

	/**
	 * This method performs sign in action. After launching the url, click on
	 * sign in button at the top of the page, which navigates to "Esri Accounts"
	 * page then pass the inputs of username and
	 * password and click on "Sign in" button.
	 */
	public void signIn() {
		click(mainPageObject.traningPageSignInButton);
		signInPageFeatures.signIn();
	}
	
	/**
	 * This method performs sign in action. After launching the url, click on
	 * sign in button at the top of the page, which navigates to "Esri Accounts"
	 * page then pass the inputs of username and
	 * password and click on "Sign in" button.
	 */
	public void signInAfterUnlimited() {
		signInPageFeatures.signIn();
	}
	
	/**
	 * Performing the click event for Sub Menu - Training For Organizations. 
	 * 
	 */
	public void clickMenuSubmenuTrainingForOrganizations() {
		hoverMouseOver(mainPageObject.MainDropDown);
		click(mainPageObject.trainingForOrganizationsSubMenu);
	}
	
	/**
	 * Performing the click event for Sub Menu - Unlimited E-Learning. 
	 * 
	 */
	public void clickMenuSubmenuUnlimitedELearning() {
		hoverMouseOver(mainPageObject.MainDropDown);
		waitForPageToLoad();
		click(mainPageObject.unlimitedELearningSubMenu);
		this.mainPageObject = new MainPageObjects(driver);
	}

	/**
	 * Retrieve 'Contact Us  About Planning' page header.
	 * 
	 * @return sTitle
	 */
	public String retrieveContactUsAboutPlanningPageTitle() {
		scrollIntoViewByElement(mainPageObject.contactUsAboutPlanningBtn);
		click(mainPageObject.contactUsAboutPlanningBtn);
		switchToChildWindow(1);
		String sTitle=retrieveTitle();
		switchToParentWindow(0);
		return sTitle;
	}
	
	/**
	 * Retrieve 'Training Pass' Tab header.
	 * 
	 * @return String
	 */
	public String retrieveTrainingPassTabHeader() {
		return getText(mainPageObject.tabsHeader);
	}
	
	/**
	 * Retrieve 'Purchase A Training Pass' Page Title.
	 * 
	 * @return sTitle
	 */
	public String retrievePurchaseATrainingPassPageTitle() {
		scrollIntoViewByElement(mainPageObject.purchaseATrainingPassBtn);
		click(mainPageObject.purchaseATrainingPassBtn);
		switchToChildWindow(1);
		String sTitle=retrieveTitle();
		switchToParentWindow(0);
		return sTitle;
	}
	
	/**
	 * Retrieve 'Private Classes And Coaching' Tab header.
	 * 
	 * @return String
	 */
	public String retrievePrivateClassesAndCoachingHeader() {
		clickAfterScroll(mainPageObject.privateClassesAndCoachingBtn);
		return getText(mainPageObject.tabsHeader);
	}
	
	/**
	 * Retrieve 'Arrange A Training Class' Page Title.
	 * 
	 * @return sTitle
	 */
	public String retrieveArrangeATrainingClassPageTitle() {
		click(mainPageObject.arrangeATrainingClassBtn);
		switchToChildWindow(1);
		String sTitle=retrieveTitle();
		switchToParentWindow(0);
		return sTitle;
	}
	
	/**
	 * Retrieve 'Esri E-Learning In Your LMS' Tab header.
	 * 
	 * @return String
	 */
	public String retrieveEsriELearningInYourLMSHeader() {
		click(mainPageObject.esriELearningInYourLMSBtn);
		return getText(mainPageObject.tabsHeader);
	}
	
	/**
	 * Retrieve 'I Want To Learn More' Page Title.
	 * 
	 * @return sTitle
	 */
	public String retrieveIWantToLearnMorePageTitle() {
		click(mainPageObject.iWantToLearnMoreBtn);
		return retrieveTitle();
	}
	
	/**
	 * Retrieve 'Maintenance Program Details' Page Title.
	 * 
	 * @return String
	 */
	public String retrieveMaintenanceProgramDetailsTitle() {
		scrollIntoViewByElement(mainPageObject.maintenanceProgramDetailsBtn);
		click(mainPageObject.maintenanceProgramDetailsBtn);
		return retrieveTitle();
	}	

	/**
	 * Retrieve 'Access Status' content after Signing In.
	 * 
	 * @return String
	 */
	public boolean isUserAccessStatusIsCorrect() {
		boolean accessStatus = false;
		scrollIntoViewByElement(mainPageObject.signInToCheckBtn);
		click(mainPageObject.signInToCheckBtn);
		switchToFrame(mainPageObject.oAuthFrame);
		inputText(mainPageObject.usernameText, inputDataMap.get(MainPage.USERNAME));
		inputText(mainPageObject.passwordText, inputDataMap.get(MainPage.PASSWORD));
		click(mainPageObject.signInButton);
		driver.switchTo().defaultContent();
		String text = getText(mainPageObject.accessStatusContent);
		if (text.contains(inputDataMap.get(MainPage.ACCESS_STATUS_CONTENT))) {
			accessStatus = true;
		} else {
			Log.error("User Access status is wrong");
		}
		return accessStatus;
	}
	
	/**
	 * Retrieve 'Access My Esri Administrator Tools' Page Title.
	 * 
	 * @return sTitle
	 */
	public String retrieveAccessMyEsriAdministratorToolsPageTitle() {
		clickAfterScroll(mainPageObject.accessMyEsriAdministratorToolsBtn);
		switchToChildWindow(1);
		waitForPageToLoad();
		String sTitle=retrieveTitle();
		switchToParentWindow(0);
		return sTitle;
	}
	
	/**
	 * Retrieve 'View Common Questions' page header.
	 * 
	 * @return String
	 */
	public String retrieveViewCommonQuestionsPageHeader() {
		click(mainPageObject.viewCommonQuestionsBtn);
		return getText(mainPageObject.viewCommonQuestionsHeader);
	}	
	
}
