package com.esri.sm.training.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the Esri Training - Main submenus page objects.
 * 
 * @author Thenmozhi & Rizwan
 *
 */
public class MainPageObjects {

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

	@FindBy(xpath = "//div[@class='link ng-binding'][contains(text(), 'Main')]")
	public WebElement MainDropDown;
	// Options And Formats SubMenu Page Objects
	@FindBy(xpath = "//a[@class='ng-binding'][contains(text(), 'Options & Formats')]")
	public WebElement optionsAndFormatsSubMenuLink;

	@FindBy(xpath = "//button[@class='ng-binding'][contains(text(), 'View All Instructor-Led Training')]")
	public WebElement viewAllInstructorLedTrainingButton;

	@FindBy(css = "div.esriu-tabs > a:nth-child(1)")
	public WebElement benefitsLink;

	@FindBy(css = "div.esriu-tabs > a:nth-child(2)")
	public WebElement locationLink;

	@FindBy(css = "div.esriu-tabs > a:nth-child(3)")
	public WebElement pricingLink;

	@FindBy(css = "div.esriu-tabs > a:nth-child(4)")
	public WebElement paymentLink;

	@FindBy(xpath = "//div[@class='title ng-binding'][contains(text(), 'Benefits')]")
	public WebElement benefitsText;

	@FindBy(xpath = "//div[@class='title ng-binding'][contains(text(), 'A Convenient Location Near You')]")
	public WebElement aConvenientLocationNearYouText;

	@FindBy(xpath = "//div[@class='title ng-binding'][contains(text(), 'Pricing')]")
	public WebElement pricingText;

	@FindBy(xpath = "//div[@class='title ng-binding'][contains(text(), 'Payment Options')]")
	public WebElement paymentOptionsText;

	@FindBy(xpath = "//a[@class='btn ng-binding'][contains(text(), 'How to Access E-Learning')]")
	public WebElement howToAccessELearningLink;
	// Training For Individuals SubMenu Page Objects
	@FindBy(xpath = "//li[@class='avenir-light font-size--2']/a[contains(text(), 'Training for Individuals')]")
	public WebElement trainingForIndividualsSubMenuLink;

	@FindBy(xpath = "//h1[@class='ng-binding'][contains(text(), 'Training for Individuals')]")
	public WebElement trainingForIndividualsHeaderLabel;

	@FindBy(css = "button.btn-clear.ng-binding")
	public WebElement learnMoreAboutUnlimitedAccessButton;

	@FindBy(xpath = ".//*[contains(@class,'dropdown-item')]/a[contains(text(),'Main')]")
	protected WebElement mainMenu;
	// Training For Organizations SubMenu Page Objects
	@FindBy(xpath = ".//*[contains(@class,'dropdown-item')]//a[contains(text(),'Training for Organizations')]")
	protected WebElement trainingForOrganizationsSubMenu;

	@FindBy(css = "div.grid-container.whiteBoxWrap > div:nth-child(3) > button")
	protected WebElement contactUsAboutPlanningBtn;

	@FindBy(xpath = ".//*[contains(@class,'esriu-tabs')]/a[1]")
	protected WebElement trainingPassBtn;

	@FindBy(xpath = ".//*[starts-with(@class,'margin-top-md btn-clear ng-binding ng-scope') and contains(text(),'Purchase a Training Pass')]")
	protected WebElement purchaseATrainingPassBtn;

	@FindBy(xpath = ".//*[contains(@class,'esriu-tabs')]/a[2]")
	protected WebElement privateClassesAndCoachingBtn;

	@FindBy(xpath = ".//*[starts-with(@class,'margin-top-md btn-clear ng-binding ng-scope') and contains(text(),'Arrange a Private Class')]")
	protected WebElement arrangeATrainingClassBtn;

	@FindBy(xpath = ".//*[contains(@class,'esriu-tabs')]/a[3]")
	protected WebElement esriELearningInYourLMSBtn;

	@FindBy(css = "div.self-paced.center.padding-top-xl.padding-bottom-xl > a > button")
	protected WebElement iWantToLearnMoreBtn;

	@FindBy(xpath = ".//*[contains(@class,'grid-container tab-content ng-scope')]//div[contains(@class,'padding-top-xl ng-binding')]")
	protected WebElement tabsHeader;

	@FindBy(xpath = "//button[@class='btn ng-binding']")
	protected WebElement maintenanceProgramDetailsBtn;
	// unlimited E-Learning SubMenu Page Objects
	@FindBy(xpath = ".//*[contains(@class,'dropdown-item')]//a[contains(text(),'Unlimited E-Learning')]")
	protected WebElement unlimitedELearningSubMenu;

	@FindBy(xpath = ".//*[starts-with(@class,'ng-binding') and contains(text(),'Sign In To Check')]")
	protected WebElement signInToCheckBtn;

	@FindBy(xpath = ".//*[contains(@class,'ng-binding') and contains(text(),'Access My Esri Administrator Tools')]")
	protected WebElement accessMyEsriAdministratorToolsBtn;

	@FindBy(xpath = ".//*[contains(@class,'ng-binding') and contains(text(),'View Common Questions')]")
	protected WebElement viewCommonQuestionsBtn;

	@FindBy(xpath = ".//*[contains(@class,'check-access')]//div[contains(text(),'Your account is not')]")
	protected WebElement accessStatusContent;

	@FindBy(xpath = ".//*[contains(@class,'padding-bottom-xl catalog-search')]//span[contains(text(),'Common Questions')]")
	protected WebElement viewCommonQuestionsHeader;
	
	@FindBy(xpath = "//iframe[@id='oAuthFrame']")
    protected WebElement oAuthFrame;

	/**
	 * Initialize the PageObject for Esri Training - Main submenu page
	 * 
	 * @param driver
	 *
	 */
	public MainPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}