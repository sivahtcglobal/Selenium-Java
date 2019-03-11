package com.esri.sm.myesri.myorganization;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This is the MY Esri.com My Organizations tab Overview web page class to
 * identify the objects within the page
 * 
 * @author Rizwan
 *
 */

public class OverviewPageObjects {

	@FindBy(xpath = "//nav[@class='sub-nav-list phone-hide']/a[contains(text(), 'My Organizations')]")
	protected WebElement myOrganizationsLink;

	@FindBy(xpath = "//nav[@class='column-24']/a[@class='third-nav-link ng-binding']")
	protected List<WebElement> myEsriSubLinks;

	@FindBy(xpath ="//*[@id='appTitle']")
	protected WebElement myOrganizationHeaderLabel;

	@FindBy(css = "div#appHeader > div:nth-child(2) > div:nth-child(2) > button")
	protected WebElement moreInformationLink;

	@FindBy(xpath = "//div[@class='panel panel-white trailer-1']")
	protected WebElement moreInfoPanel;

	@FindBy(css = "a.crumb.ng-binding.ng-scope")
	protected WebElement myOrganizationCommonHeaderLabel;

	@FindBy(xpath = "(//a[@class='third-nav-link ng-binding'][contains(text(), 'Overview')])[2]")
	protected WebElement overviewLink;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope is-active']/nav/a")
	protected List<WebElement> overviewSubLinks;

	@FindBy(xpath = "(//a[@title='Edit'])[1]")
	protected WebElement organizationDetailsEditLink;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope is-active']/nav/a[contains(text(), 'Organization Profile')]")
	protected WebElement organizationProfileLink;

	@FindBy(css = "#org-contact-hook > div.right.leader-0.trailer-0 > a")
	protected WebElement organizationContactEditLink;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope is-active']/nav/a[contains(text(), 'Edit Organization Details')]")
	protected WebElement editOrganizationDetailsLink;

	@FindBy(css = "a.btn.btn-clear.btn-small.ng-binding.ng-scope")
	protected WebElement editOrganizationProfileLink;

	@FindBy(xpath = "//input[@name='Department']")
	protected WebElement departmentInputArea;

	@FindBy(xpath = "(//input[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty ng-valid-pattern ng-valid-maxlength'])[2]")
	protected WebElement DivisionInputArea;

	@FindBy(xpath = "//span[@class='async-button-text'][contains(text(), 'Update')]")
	protected WebElement updateOrganizationDetailsButton;

	@FindBy(xpath = "//input[@name='Address1']")
	protected WebElement address1InputArea;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope is-active']/nav/a[contains(text(), 'Edit Organization Name')]")
	protected WebElement editOrganizationNameLink;

	@FindBy(xpath = "//input[@class='ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-valid-pattern ng-valid-maxlength']")
	protected WebElement organizationNewNameInputArea;

	@FindBy(xpath = "//span[@class='ng-binding'][contains(text(), 'None')]")
	protected WebElement noneCheckBox;

	@FindBy(xpath = "//span[@class='ng-binding'][contains(text(), 'Data entry correction')]")
	protected WebElement dataEntryCorrectionCheckBox;

	@FindBy(xpath = "(//input[@class='ng-pristine ng-untouched ng-valid ng-empty'])[2]")
	protected WebElement doesPriorOrganizationStillExistRadioButton;

	@FindBy(xpath = "(//input[@class='ng-pristine ng-untouched ng-valid ng-empty'])[2]")
	protected WebElement isPriorOrganizationKeepingAnySoftwareLicensesRadioButton;

	@FindBy(xpath = "(//input[@class='ng-pristine ng-untouched ng-valid ng-empty'])[2]")
	protected WebElement DoesTransferorHaveARequestFormForEsriToSignRadioButton;

	@FindBy(xpath = "//span[@class='async-button-text'][contains(text(), 'Send Edits')]")
	protected WebElement sendEditsButton;

	@FindBy(xpath = "//span[@id='thankyouMessage']")
	protected WebElement editOrganizationNameSuccessMessage;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope is-active']/nav/a[contains(text(), 'Edit Maintenance Contact')]")
	protected WebElement editMaintenanceContactLink;

	@FindBy(xpath = "//input[@name='FirstName']")
	protected WebElement firstNameInputArea;

	@FindBy(xpath = "//textarea[@class='form-control ng-pristine ng-valid ng-isolate-scope ng-empty ng-valid-maxlength ng-touched']")
	protected WebElement updateContactInformationNotesInputArea;

	@FindBy(xpath = "//div[@class='alert alert-green alert-full trailer-1 is-active ng-binding']")
	protected WebElement updateContactInformationSuccessMessage;

	@FindBy(css = "li.k-item.k-state-default.k-last")
	protected WebElement replaceContactLink;

	@FindBy(xpath = "(//input[@class='required ng-pristine ng-untouched ng-isolate-scope ng-valid-maxlength ng-empty ng-invalid ng-invalid-required'])[1]")
	protected WebElement replaceFirstNameInputArea;

	@FindBy(css = "div.panel.panel-white.tab-contents > label:nth-child(3) > input")
	protected WebElement replaceLastNameInputArea;

	@FindBy(css = "div.panel.panel-white.tab-contents > label:nth-child(4) > input")
	protected WebElement replaceEmailInputArea;

	@FindBy(css = "div.panel.panel-white.tab-contents > label:nth-child(5) > input")
	protected WebElement replacePhoneInputArea;

	@FindBy(xpath = "//input[@value='responsibility']")
	protected WebElement whyRadioButton;

	@FindBy(xpath = "//span[@class='async-button-text'][contains(text(), 'Send Request')]")
	protected WebElement replaceContactSendRequestButton;

	@FindBy(xpath = "(//input[@class='ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required'])[1]")
	protected WebElement replaceContactOtherInputArea;

	@FindBy(xpath = "//textarea[@class='form-control ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty ng-valid-maxlength']")
	protected WebElement changesInputArea;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope is-active']/nav/a[contains(text(), 'Request Permissions')]")
	protected WebElement requestPermissionsLink;

	@FindBy(xpath = "(//a[@class='btn ng-binding btn-clear'])[2]")
	protected WebElement studentsAccountsContinueButton;

	@FindBy(xpath = "//h4[@class='text-off-black trailer-half font-size-2 ng-binding']")
	protected WebElement trialsAndStudentAccountsHeaderLabel;

	@FindBy(xpath = "(//a[@class='btn ng-binding btn-clear'][contains(text(), 'Continue')])[1]")
	protected WebElement requestPermissionsToYourOrganizationContinueButton;

	@FindBy(xpath = "(//input[@name='requestType'])[1]")
	protected WebElement additionalOrganizationRadioButton;

	@FindBy(xpath = "//textarea[@id='description']")
	protected WebElement whatPermissionsDoYouNeedInputArea;

	@FindBy(css = "#maintenanceUpdateForm > div > div > div > label:nth-child(4) > input")
	protected WebElement eamilAdressInputArea;
	
	@FindBy(xpath = "//span[@class='async-button-text'][contains(text(), 'Send Request')]")
	protected WebElement sendRequestButton;

	@FindBy(xpath = "//div[@class='alert alert-green is-active leader-1 trailer-1 ng-binding']")
	protected WebElement requestPermissionsToYourOrganizationSuccessMessage;

	@FindBy(xpath = "//a[@class='third-nav-link ng-binding'][contains(text(), 'Licensing')]")
	protected WebElement licensingLink;

	/**
	 * Initialize the PageObject for MY Esri.com site My Organizations tab -
	 * Overview web page
	 * 
	 * @param driver
	 *
	 */
	public OverviewPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
