package com.esri.sm.training.certification;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.config.Env;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.SignInPageFeatures;
import com.esri.support.modules.core.TrainingConstants.CertificationPage;

/**
 * This is the Esri Traning - Certification sub menus page feature class.
 * 
 * @author Thenmozhi
 */
public class CertificationPageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private CertificationPageObjects certificationPageObject;
	private WebDriver driver; 
	String parrentWin;
	private SignInPageFeatures signInPageFeatures;

	/**
	 * Constructor to initialize the Training site Certification Menu page
	 * 
	 * @param driver,
	 * @param inputDataMap
	 */
	public CertificationPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		this.certificationPageObject = new CertificationPageObjects(driver);
		signInPageFeatures = new SignInPageFeatures(driver, inputDataMap);
	}

	/**
	 * Navigate to training home page.
	 */
	public void navigateToHomePage() {
		openURL(Env.get("TRAINING"));
	}

	/**
	 * Retrieve the Page title.
	 * 
	 * @return String
	 */
	public String retrieveTitle() {
		waitForPageToLoad();
		return getTitle();
	}

	/**
	 * Retrieve Training page header.
	 * 
	 * @return String
	 */
	public String getTrainingPageHeader() {
		return getText(certificationPageObject.pageHeader);
	}

	/**
	 * This method performs sign in action. After launching the url, click on
	 * sign in button at the top of the page, which navigates to "Esri Accounts"
	 * page then pass the inputs of username and password and click on "Sign in"
	 * button.
	 */
	public void signIn() {
		click(certificationPageObject.traningPageSignInButton);
		signInPageFeatures.signIn();
	}

	/**
	 * Click on the Certification Overview Submenu.
	 */
	public void clickCertificationSubmenuCertificationOverview() {
		hoverMouseOver(certificationPageObject.certificationMenu);
		click(certificationPageObject.certificationOverviewSubMenu);
		waitForPageToLoad();
	}

	/**
	 * Click on the Certification Exams Submenu.
	 */
	public void clickCertificationSubmenuCertificationExams() {
		hoverMouseOver(certificationPageObject.certificationMenu);
		click(certificationPageObject.certificationExamsSubMenu);
		waitForPageToLoad();
	}

	/**
	 * Click on the Taking An Exam Submenu.
	 */
	public void clickCertificationSubmenuTakingAnExam() {
		waitForPageToLoad();
		hoverMouseOver(certificationPageObject.certificationMenu);
		click(certificationPageObject.takingAnExamSubMenu);
		waitForPageToLoad();
	}

	/**
	 * Click on the Manage Certification Submenu.
	 */
	public void clickCertificationSubmenuManageCertification() {
		hoverMouseOver(certificationPageObject.certificationMenu);
		click(certificationPageObject.manageCertificationSubMenu);
		waitForPageToLoad();
	}

	/**
	 * Click on the Directory Submenu.
	 */
	public void clickCertificationSubmenuDirectory() {
		hoverMouseOver(certificationPageObject.certificationMenu);
		click(certificationPageObject.directorySubMenu);
		waitForPageToLoad();
	}

	/**
	 * Navigate to Certification page.
	 */
	public void navigateToCertificationPage() {
		openURL(inputDataMap.get(CertificationPage.CERTIFICATION_PAGE_URL));
	}

	/**
	 * Retrieve 'Get Started' page header.
	 * 
	 * @return String
	 */
	public String retrieveGetStartedPageHeader() {
		scrollIntoViewByElement(certificationPageObject.getStartedBtn);
		click(certificationPageObject.getStartedBtn);
		return getText(certificationPageObject.getStartedPageHeader);
	}

	/**
	 * Retrieve 'Register Now' page header.
	 * 
	 * @return String
	 */
	public String retrieveRegisterNowPageHeader() {
		scrollIntoViewByElement(certificationPageObject.registerNowBtn);
		click(certificationPageObject.registerNowBtn);
		return getText(certificationPageObject.registerNowPageHeader);
	}

	/**
	 * Retrieve 'Manage Certification' page header.
	 * 
	 * @return String
	 */
	public String retrieveManageCertificationPageHeader() {
		scrollIntoViewByElement(certificationPageObject.manageCertificationBtn);
		click(certificationPageObject.manageCertificationBtn);
		return getText(certificationPageObject.manageCertificationPageHeader);
	}

	/**
	 * Retrieve 'Directory' page header.
	 * 
	 * @return String
	 */
	public String retrieveDirectoryPageHeader() {
		scrollIntoViewByElement(certificationPageObject.directoryBtn);
		click(certificationPageObject.directoryBtn);
		return getText(certificationPageObject.directoryPageHeader);
	}

	/**
	 * Navigate to 'Register For An Exam' page.
	 */
	public void navigateToRegisterForAnExamPage() {
		openURL(inputDataMap.get(CertificationPage.REGISTER_FOR_AN_EXAM_URL));
	}

	/**
	 * Click on the 'Register For An Exam' button
	 * 
	 */
	public void clickRegisterForAnExamBtn() {
		click(certificationPageObject.registerForAnExamBtn);
		switchToChildWindow();
	}

	/**
	 * Retrieve 'Sign In' page header.
	 * 
	 * @return String
	 */
	public String retrieveSignInPageHeader() {
		clickRegisterForAnExamBtn();
		click(certificationPageObject.registerForExamSignInBtn);
		return getText(certificationPageObject.registerForExamSignInHeader);
	}

	/**
	 * Retrieve 'Create Account' page header.
	 * 
	 * @return String
	 */
	public String retrieveCreateAccountPageHeader() {
		navigateToRegisterForAnExamPage();
		scrollIntoViewByElement(certificationPageObject.registerForExamCreateAccountBtn);
		click(certificationPageObject.registerForExamCreateAccountBtn);
		String sCreateAccounHeader = getText(certificationPageObject.registerForExamCreateAccountHeader);
		switchToParentWindow();
		return sCreateAccounHeader;
	}

	/**
	 * Retrieve 'Taking An Exam' page header.
	 * 
	 * @return String
	 */
	public String retrieveTakingAnExamPageHeader() {
		return getText(certificationPageObject.takingAnExamPageHeader);
	}

	/**
	 * Retrieve 'Checkout' page header.
	 * 
	 * @return String
	 */
	public String retrieveCheckoutPageHeader() {
		click(certificationPageObject.purchaseAnExamVoucherBtn);
		if (isElementAvailable(certificationPageObject.continuePurchaseBtn)) {
			click(certificationPageObject.continuePurchaseBtn);
		}
		return getText(certificationPageObject.checkoutPageHeader);
	}

	/**
	 * Retrieve 'After Checkout' page header.
	 * 
	 * @return String
	 */
	public String retrieveAfterCheckoutPageHeader() {
		click(certificationPageObject.iAgreeChkBox);
		click(certificationPageObject.checkoutBtn);
		return getText(certificationPageObject.afterCheckoutPageHeader);
	}

	/**
	 * Retrieve 'Manage Your Certification' page header.
	 * 
	 * @return String
	 */
	public String retrieveManageYourCertificationPageHeader() {
		return getText(certificationPageObject.manageYourCertificationHeader);
	}

	/**
	 * Click on the 'Access My Certification' button
	 */
	public void clickAccessMyCertificationBtn() {
		clickAfterScroll(certificationPageObject.accessMyCertificationBtn);
		switchToChildWindow();
		waitForPageToLoad();
	}

	/**
	 * Retrieve 'Verify A Certification' page header.
	 * 
	 * @return String
	 */
	public String retrieveVerifyACertificationTitle() {
		switchToParentWindow();
		clickAfterScroll(certificationPageObject.verifyACertificationBtn);
		switchToChildWindow();
		String sCertificationVerificationTitle = retrieveTitle();
		switchToParentWindow();
		return sCertificationVerificationTitle;
	}

	/**
	 * Click on the 'Certification Record' button
	 */
	public void clickCertificationRecordLink() {
		click(certificationPageObject.certificationRecordLink);
		switchToChildWindow();
	}

	/**
	 * Retrieve 'Verify The Code' page header.
	 * 
	 * @return String
	 */
	public String retrieveVerifyTheCodePageTitle() {
		switchToParentWindow();
		scrollIntoViewByElement(certificationPageObject.verifyTheCodeLink);
		click(certificationPageObject.verifyTheCodeLink);
		switchToChildWindow();
		String sVerifyTheCodeTitle = retrieveTitle();
		switchToParentWindow();
		return sVerifyTheCodeTitle;
	}

	/**
	 * Enter search text.
	 */
	public void enterSearchText() {
		inputText(certificationPageObject.searchInput, inputDataMap.get(CertificationPage.SEARCH_KEYWORD));
		click(certificationPageObject.searchBtn);
	}

	/**
	 * Select 'United States' from AllCountries Filter.
	 */
	public void selectAllCountriesFilter() {
		click(certificationPageObject.allCountriesFilter);
		click(certificationPageObject.selectUnitedStatesOption);
	}

	/**
	 * Select 'Desktop Accociate' from AllCertifications Filter.
	 */
	public void selectAllCertificationsFilter() {
		click(certificationPageObject.allCertificationsFilter);
		click(certificationPageObject.selectDesktopAccociateOption);
	}

	/**
	 * Retrieve count of 'Items Displayed' in the page.
	 * 
	 * @return Integer
	 */
	public int retrieveItemsDisplayedCount() {
		return Integer.parseInt(getText(certificationPageObject.itemsDisplayedCount));
	}
	
	/**
	 * Switch to child window.
	 */
	public void switchToChildWindow() {
		ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
		parrentWin = tabs2.get(0);
		driver.switchTo().window(tabs2.get(1));
	}

	/**
	 * Switch to parent window.
	 */
	public void switchToParentWindow() {
		driver.close();
		driver.switchTo().window(parrentWin);
	}

}
