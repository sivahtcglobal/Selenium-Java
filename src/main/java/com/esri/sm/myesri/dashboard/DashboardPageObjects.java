package com.esri.sm.myesri.dashboard;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This is the MY Esri Dashboard Overview web page class to identify the
 * objects within the page
 * 
 * @author Rizwan
 *
 */

public class DashboardPageObjects {

	@FindBy(xpath ="//button[@class='esri-cookie__button'][contains(text(), 'Accept Cookies')]")
	public WebElement acceptCookiesButton;
	
	@FindBy(css = "#mega-menu-sign-in")
	protected WebElement homePageSignInButton;

	@FindBy(xpath = "//iframe[@id='oAuthFrame']")
	protected WebElement oAuthFrame;

	@FindBy(id = "user_username")
	protected WebElement usernameText;

	@FindBy(id = "user_password")
	protected WebElement passwordText;

	@FindBy(id = "signIn")
	protected WebElement signInButton;

	@FindBy(id = "mega-menu-account-username")
	protected WebElement accountUserName;

	@FindBy(css = "h1.sub-nav-title.text-white")
	protected WebElement myEsriHeaderLabel;

	@FindBy(xpath = "//li[@id='mega-menu-account-account-links']//a[contains(text(), 'My Esri')]")
	protected WebElement MyEsriLink;

	@FindBy(xpath = "//h4[@class='ng-binding'][contains(text(), 'Announcements')]")
	protected WebElement announcementsHeaderLabel;

	@FindBy(xpath = "//h4[@class='ng-binding'][contains(text(), 'Common Questions')]")
	protected WebElement dashboardCommonQuestionsHeaderLabel;

	@FindBy(css = "p.leader-1.trailer-0.text-center > a")
	protected WebElement ViewMoreCommonQuestionsLink;

	@FindBy(xpath = "//ul[@class='list-plain ng-scope']/li/a")
	protected List<WebElement> topicCategories;

	@FindBy(xpath = "//h4[@class='accordion-title']")
	protected List<WebElement> commonQuestionsCount;

	@FindBy(id = "feedback-link")
	protected WebElement dashboardFeedbackLink;

	@FindBy(xpath = "//input[@class='ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required']")
	protected List<WebElement> contactUsItemList;

	@FindBy(xpath = "//a[@class='js-modal-toggle right']")
	protected WebElement feedbackCloseIcon;

	@FindBy(xpath = "//div[@class='custom-third-nav-container']/div/nav[1]/a[contains(text(), 'Overview')]")
	protected WebElement overviewLink;

	@FindBy(xpath = "//div[@class='custom-third-nav-container']/div/nav[1]/a[contains(text(), 'Common Questions')]")
	protected WebElement commonQuestionsLink;

	@FindBy(xpath = "//div[@class='custom-third-nav-container']/div/nav[1]/a[contains(text(), 'Contact Us')]")
	protected WebElement contactUsLink;

	@FindBy(id = "appTitle")
	protected WebElement commonQuestionsHeaderLabel;

	@FindBy(css = "input.input-group-input.ng-pristine.ng-untouched.ng-valid.searchable.ng-empty")
	protected WebElement commonQuestionsSearchInputArea;

	@FindBy(css = "span.highlighted")
	protected List<WebElement> searchDataCount;

	@FindBy(xpath = "(//input[@id='topicmyesri'])[1]")
	protected WebElement topicMyEsriRadioButton;

	@FindBy(xpath = "(//*[@id='topicother'])[1]")
	protected WebElement topicOtherRadioButton;

	@FindBy(xpath = "//form[@class='contact-us-form ng-invalid ng-invalid-required ng-dirty ng-valid-parse']/label[1]/textarea")
	protected WebElement contactUsMessageTextArea;

	@FindBy(xpath = "(//span[@class='async-button-text'])[1]")
	protected WebElement sendButton;

	@FindBy(xpath = "//div[@class='alert alert-green is-active trailer-1 alert-full ng-binding']")
	protected WebElement contactUsSuccessMessageText;
	
	@FindBy(xpath = "//*[@id='thankyouMessage']")
	protected WebElement contactUsSuccessMessage;

	@FindBy(css = "a#help-menu--a")
	protected WebElement myEsriHelpMenuLink;

	@FindBy(xpath = "//h6[@class='trailer-0 ng-binding']")
	protected WebElement helpQuestionsHeaderLabel;

	@FindBy(xpath = "//a[@class='btn btn-clear btn-clear2 btn-fill btn-wrap ng-binding'][contains(text(), 'Common Questions')]")
	protected WebElement helpCommonQuestionsLink;

	@FindBy(xpath = "//a[@class='btn btn-clear btn-clear2 btn-fill btn-wrap ng-binding'][contains(text(), 'My Esri information on GeoNet')]")
	protected WebElement helpMyEsriInformationOnGeoNetLink;

	@FindBy(css = "#j_username")
	protected WebElement userName;
	
	@FindBy(css = "#j_password")
	protected WebElement passWord;
	
	@FindBy(css = "#submit")
	protected WebElement signIn;
	
	@FindBy(xpath = "div.geonet-banner-title > a > h1")
	protected WebElement geoNetHeaderLabel;

	@FindBy(xpath = "//a[@class='btn btn-clear btn-clear2 btn-fill btn-wrap ng-binding'][contains(text(), 'Send Feedback')]")
	protected WebElement helpSendFeedbackLink;

	@FindBy(css = "div#appHeader >div:nth-child(2) > h2")
	protected WebElement helpContactUSHeaderLabel;

	@FindBy(xpath = "//a[@class='btn btn-clear btn-clear2 btn-fill btn-wrap ng-binding'][contains(text(), 'Contact Us')]")
	protected WebElement helpContactUsLink;

	@FindBy(css = "span.k-icon.k-i-close")
	protected WebElement closeHelpMenu;

	/**
	 * Initialize the PageObject for MY Esri.com Dashboard Overview web page
	 * 
	 * @param driver
	 *
	 */
	public DashboardPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
