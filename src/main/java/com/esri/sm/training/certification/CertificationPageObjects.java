package com.esri.sm.training.certification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the Esri Training - Certification submenus page objects.
 * 
 * @author Thenmozhi
 *
 */
public class CertificationPageObjects {

	@FindBy(css = "#username")
	protected WebElement traningPageSignInButton;

	@FindBy(id = "user_username")
	protected WebElement usernameText;

	@FindBy(id = "user_password")
	protected WebElement passwordText;

	@FindBy(id = "signIn")
	protected WebElement signInButton;

	@FindBy(css = "#topper_v_align > h1")
	protected WebElement signInHeader;

	@FindBy(css = ".title>h1")
	protected WebElement pageHeader;

	@FindBy(xpath = "//div[@class='link ng-binding'][contains(text(), 'Certification')]")
	protected WebElement certificationMenu;
	
	// certification Overview SubMenu Page Objects
	@FindBy(xpath = ".//*[contains(@class,'dropdown-item')]//a[contains(text(),'Certification Overview')]")
	protected WebElement certificationOverviewSubMenu;

	@FindBy(xpath = ".//*[starts-with(@class,'ng-binding') and contains(text(),'Get Started')]")
	protected WebElement getStartedBtn;

	@FindBy(xpath = ".//*[contains(@class,'padding-top-xl padding-bottom-md ng-binding') and contains(text(),'Certification Exams')]")
	protected WebElement getStartedPageHeader;

	@FindBy(xpath = ".//*[starts-with(@class,'ng-binding') and contains(text(),'Register Now')]")
	protected WebElement registerNowBtn;

	@FindBy(css = "div.grid-container > div > div.font-size-6.blue.center.padding-bottom-md.ng-binding")
	protected WebElement registerNowPageHeader;

	@FindBy(xpath = ".//*[@ui-sref='certManage']/button")
	protected WebElement manageCertificationBtn;

	@FindBy(xpath = ".//*[contains(@class,'padding-top-xl padding-bottom-md ng-binding') and contains(text(),'Manage Your Certification')]")
	protected WebElement manageCertificationPageHeader;

	@FindBy(xpath = ".//*[@ui-sref='certDirectory']/button")
	protected WebElement directoryBtn;

	@FindBy(xpath = ".//*[@class='container-fill ng-scope']//div[contains(text(),'Directory of Esri-Certified')]")
	protected WebElement directoryPageHeader;
	
	// certification Exams SubMenu Page Objects
	@FindBy(xpath = ".//*[contains(@class,'dropdown-item')]//a[contains(text(),'Certification Exams')]")
	protected WebElement certificationExamsSubMenu;

	@FindBy(xpath = ".//*[starts-with(@class,'ng-binding') and contains(text(),'Register for an Exam')]")
	protected WebElement registerForAnExamBtn;

	@FindBy(xpath = ".//*[contains(@class,'accountLinks-btns')]//a[contains(text(),'Sign in')]")
	protected WebElement registerForExamSignInBtn;

	@FindBy(css = "#maincontent > h2")
	protected WebElement registerForExamSignInHeader;

	@FindBy(xpath = ".//*[contains(@class,'accountLinks-btns')]//a[contains(text(),'Create account')]")
	protected WebElement registerForExamCreateAccountBtn;

	@FindBy(css = "#ui-id-1")
	protected WebElement registerForExamCreateAccountHeader;
	
	// Taking An Exam SubMenu Page Objects
	@FindBy(xpath = ".//*[contains(@class,'dropdown-item')]//a[contains(text(),'Taking an Exam')]")
	protected WebElement takingAnExamSubMenu;

	@FindBy(xpath = ".//div[contains(text(),'Pricing and Payment Options')]")
	protected WebElement takingAnExamPageHeader;

	@FindBy(css = ".btn[name='addtobasket']")
	protected WebElement purchaseAnExamVoucherBtn;
	
	@FindBy(css = ".btn.ng-binding")
	protected WebElement continuePurchaseBtn;

	@FindBy(xpath = ".//*[@id='dr_ShoppingCart']//h1")
	protected WebElement checkoutPageHeader;

	@FindBy(xpath = "//*[contains(@type,'checkbox') and contains(@class,'accept-eula')]")
	protected WebElement iAgreeChkBox;

	@FindBy(xpath = "//*[contains(@class,'dr_button') and contains(text(),'checkout')]")
	protected WebElement checkoutBtn;

	@FindBy(css = "#topperBannerContainer > h1")
	protected WebElement afterCheckoutPageHeader;
	
	// Manage Certification SubMenu Page Objects
	@FindBy(xpath = ".//*[contains(@class,'dropdown-item')]//a[contains(text(),'Manage Certifications')]")
	protected WebElement manageCertificationSubMenu;

	@FindBy(xpath = ".//*[contains(@class,'padding-top-xl padding-bottom-md ng-binding') and contains(text(),'Manage Your Certification')]")
	protected WebElement manageYourCertificationHeader;

	@FindBy(xpath = "//*[@id='esriu']/div[2]/div/div[3]/div/div[3]/a/button")
	protected WebElement accessMyCertificationBtn;

	@FindBy(xpath = ".//*[starts-with(@class,'certBtn ng-binding') and contains(text(),'Verify a Certification')]")
	protected WebElement verifyACertificationBtn;
	// Directory SubMenu Page Objects
	@FindBy(xpath = ".//*[contains(@class,'dropdown-item')]//a[contains(text(),'Directory')]")
	protected WebElement directorySubMenu;

	@FindBy(xpath = ".//*[contains(text(),'certification record')]")
	protected WebElement certificationRecordLink;

	@FindBy(xpath = ".//*[contains(text(),'verify the code')]")
	protected WebElement verifyTheCodeLink;

	@FindBy(xpath = ".//*[contains(text(),'Email questions')]")
	protected WebElement emailQuestionsLink;

	@FindBy(xpath = ".//*[contains(@class,'ngdialog-close')]")
	protected WebElement emailQuestionsPopUpCloseBtn;

	@FindBy(xpath = ".//*[contains(@class,'ngdialog-content')]//h2")
	protected WebElement emailQuestionsPopUpContent;

	@FindBy(css = "div.search-bar > input")
	protected WebElement searchInput;

	@FindBy(xpath = ".//*[contains(@class,'search-submit icon-ui-search')]")
	protected WebElement searchBtn;

	@FindBy(xpath = ".//*[contains(@class,'drop-box ng-binding')]/span[contains(text(),'All Countries')]")
	protected WebElement allCountriesFilter;

	@FindBy(xpath = ".//*[contains(@class,'dropdown-title ng-scope')]/label[contains(text(),'United States')]")
	protected WebElement selectUnitedStatesOption;

	@FindBy(xpath = ".//*[contains(@class,'drop-box ng-binding')]/span[contains(text(),'All Certifications')]")
	protected WebElement allCertificationsFilter;

	@FindBy(xpath = ".//*[contains(@class,'dropdown-title ng-scope')]/label[contains(text(),'Esri Certified Desktop Associate')]")
	protected WebElement selectDesktopAccociateOption;

	@FindBy(xpath = ".//*[contains(@class,'items-displayed')]//strong")
	protected WebElement itemsDisplayedCount;

	/**
	 * Initialize the PageObject for Esri Training - Certification submenu page
	 * 
	 * @param driver
	 *
	 */
	public CertificationPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}