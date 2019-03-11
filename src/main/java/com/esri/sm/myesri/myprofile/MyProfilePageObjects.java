package com.esri.sm.myesri.myprofile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This is the MY Esri.com site My Profile tab web page class to identify the
 * objects within the page
 * 
 * @author Rizwan
 *
 */

public class MyProfilePageObjects {

	@FindBy(xpath = "//nav[@class='sub-nav-list phone-hide']/a[contains(text(), 'My Profile')]")
	protected WebElement myProfileLink;

	@FindBy(xpath = "//a[@class='crumb ng-binding ng-scope']")
	protected WebElement contactInfomationLabel;

	@FindBy(id = "appTitle")
	protected WebElement myProfileHeaderLabel;

	@FindBy(css = "button.btn.btn-transparent.btn-small.ng-binding")
	protected WebElement moreInformationLink;

	@FindBy(xpath = "//div[@class='panel panel-white trailer-1']")
	protected WebElement moreInfoPanel;

	@FindBy(xpath = "//a[@class='btn btn-clear btn-small right ng-binding']")
	protected WebElement profileEditLink;

	@FindBy(xpath = "//span[@class='async-button-text ng-binding']")
	protected WebElement profileUpdateButton;

	@FindBy(id = "thankyouMessage")
	protected WebElement profileUpdateSuccessMessage;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Edit Contact Information')]")
	protected WebElement editContactInformationLink;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Pending Permissions Requests')]")
	protected WebElement pendingPermissionsRequestsLink;

	@FindBy(xpath = "//button[@class='btn btn-clear btn-small ng-binding']")
	protected WebElement requestPermissionsButton;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Edit Email Settings')]")
	protected WebElement editEmailSettingsLink;

	@FindBy(css = "form#profileInfo > div:nth-child(1) > div > label:nth-child(1) > input")
	protected WebElement primaryEmailInputArea;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Change Security Question')]")
	protected WebElement changeSecurityQuestionLink;

	@FindBy(css = "form#formSecurityQuestion > label:nth-child(1) > select")
	protected WebElement securityQuestionDropDown;

	@FindBy(css = "form#formSecurityQuestion > label:nth-child(1) > select > option:nth-child(2)")
	protected WebElement bornCityDropDownItem;

	@FindBy(css = "form#formSecurityQuestion > label:nth-child(2) > input")
	protected WebElement securityAnswerInputArea;

	@FindBy(css = "span.async-button-text.ng-binding")
	protected WebElement changeSecurityQuestionButton;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Change Password')]")
	protected WebElement changePasswordLink;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Edit Language Setting')]")
	protected WebElement editLanguageSettingLink;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Connect to Your Organization')]")
	protected WebElement connectToYourOrganizationLink;

	@FindBy(css = "a.side-nav-link.ng-binding.ng-isolate-scope.is-active")
	protected WebElement connectToYourOrganizationActiveLink;

	@FindBy(xpath = "//button[@class='btn btn-clear ng-binding'][contains(text(), 'Connect with a Token')]")
	protected WebElement connectWithATokenButton;

	@FindBy(xpath = "//h4[@class='ng-binding'][contains(text(), 'Connect to Your Organization with a Token')]")
	protected WebElement connectToYourOrganizationWithATokenHeaderLabel;

	@FindBy(xpath = "//a[@class='btn btn-clear text-center ng-binding']")
	protected WebElement requestPermissionsLink;

	@FindBy(css = "input#customerName")
	protected WebElement organizationNameInputArea;

	@FindBy(css = "textarea#description")
	protected WebElement whatPermissionsDoYouNeedInputArea;

	@FindBy(xpath = "//span[@class='async-button-text'][contains(text(), 'Send Request')]")
	protected WebElement sendRequestButton;

	@FindBy(xpath = "//div[@class='alert alert-green is-active leader-1 trailer-1 ng-binding']")
	protected WebElement sendRequestSuccessMessage;

	@FindBy(xpath = "//button[@class='btn btn-clear ng-binding'][contains(text(), 'Trials and Student Accounts')]")
	protected WebElement trialsAndStudentAccountsButton;

	@FindBy(xpath = "//h4[@class='text-off-black trailer-half font-size-2 ng-binding']")
	protected WebElement trialsAndStudentAccountsHeaderLabel;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Disconnect from Your Organization')]")
	protected WebElement disconnectFromYourOrganizationLink;

	@FindBy(css = "a#feedback-link")
	protected WebElement feedbackOnThisPageLink;

	@FindBy(xpath = "//input[@class='ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required']")
	protected List<WebElement> contactUsItemList;

	@FindBy(xpath = "//input[@class='ng-pristine ng-untouched ng-not-empty ng-valid ng-valid-required']")
	protected List<WebElement> feedbackItemsCount;

	@FindBy(xpath = "//a[@class='js-modal-toggle right']")
	protected WebElement feedbackCloseIcon;

	@FindBy(css = "select#filterFields")
	protected WebElement filterByLink;

	@FindBy(xpath = "//select[@id='filterFields']/option[contains(text(), 'Name')]")
	protected WebElement filterDropDownItemName;
	
	@FindBy(xpath = "//select[@id='filterFields']/option[contains(text(), 'Customer Number')]")
	protected WebElement filterDropDownItemCustomerNumber;
	
	@FindBy(css = "#my-org-hook > h4")
	protected WebElement overViewHeaderLabel;

	@FindBy(css = "input#customerFilter")
	protected WebElement enterFilterInputArea;

	@FindBy(xpath = "//a[@class='btn btn-clear leader-0 inline-block ng-binding']")
	protected WebElement filterApplyLink;
	
	/**
	 * Initialize the PageObject for MY Esri.com site My Profile tab web page
	 * 
	 * @param driver
	 *
	 */
	public MyProfilePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
