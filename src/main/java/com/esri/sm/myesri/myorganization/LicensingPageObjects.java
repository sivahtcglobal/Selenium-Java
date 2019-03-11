package com.esri.sm.myesri.myorganization;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This is the MY Esri.com My Organizations tab Licensing web page class to
 * identify the objects within the page
 * 
 * @author Rizwan
 *
 */

public class LicensingPageObjects {

	@FindBy(xpath = "//nav[@class='sub-nav-list phone-hide']/a[contains(text(), 'My Organizations')]")
	protected WebElement myOrganizationsLink;

	@FindBy(id = "appTitle")
	protected WebElement myOrganizationHeaderLabel;

	@FindBy(xpath = "//nav[@class='column-24']/a[@class='third-nav-link ng-binding']")
	protected List<WebElement> myEsriSubLinks;

	@FindBy(xpath = "//aside[@class='side-nav is-active']/nav/a")
	protected List<WebElement> licensingSubLinks;

	@FindBy(css = "a.crumb.ng-binding.ng-scope")
	protected WebElement myOrganizationCommonHeaderLabel;

	@FindBy(xpath = "//a[@class='third-nav-link ng-binding'][contains(text(), 'Licensing')]")
	protected WebElement licensingLink;

	@FindBy(xpath = "//a[@class='btn btn-clear btn-fill leader-1 ng-binding'][contains(text(), 'View License Term Summary')]")
	protected WebElement viewLicenseTermSummaryLink;

	@FindBy(xpath = "//a[@class='btn btn-clear btn-fill leader-1 ng-binding']")
	protected List<WebElement> licensingOverviewLinks;

	@FindBy(xpath = "//aside[@class='side-nav is-active']/nav/a[1]")
	protected WebElement licensingOverviewLink;

	@FindBy(css = "#topperBannerContainer > nav > div > a")
	protected WebElement cutomerIDDropDown;

	@FindBy(xpath = "//*[@id='topperBannerContainer']/nav/div/nav/div/nav/div/div/h6[contains(text(), 'IST Test - Premium Support')]")
	protected WebElement adminIDLink;

	@FindBy(xpath = "(//a[@ui-sref='licenseSummary'])[1]")
	protected WebElement viewLicenseTermSummaryLeftLink;

	@FindBy(css = "a.btn.btn-green.ng-binding")
	protected WebElement viewLicenseTermSummaryReportsLink;

	@FindBy(xpath = "//div[@class='k-grid-aria-root']/table/tbody/tr")
	protected List<WebElement> reportsCount;

	@FindBy(xpath = "//button[@class='btn btn-clear'][contains(text(), 'Exit Reports')]")
	protected WebElement exitReport;

	@FindBy(xpath = "//a[@class='ng-binding']")
	protected WebElement expandAllLink;

	@FindBy(xpath = "//div[@class='accordion-section ng-scope is-active']")
	protected WebElement termStandardLinkAfterExpand;

	@FindBy(css = "input#quickSearch")
	protected WebElement quickSearchInputArea;

	@FindBy(css = "#authorizationSummaryGrid > div > table > tbody > tr:nth-child(1) > td:nth-child(1) > h5 > a")
	protected WebElement viewAuthorizationsSearchResultsHeaderText;

	@FindBy(xpath = "//*[@id='authorizationSummaryGrid']/div/table/tbody/tr")
	protected List<WebElement> searchResultsCount;

	@FindBy(xpath = "//*[@id='provisioningSummaryGrid']/div/table/tbody/tr[1]")
	protected List<WebElement> provisioningSearchResultsCount;
	
	@FindBy(xpath = "//*[@id='provisioningSummaryGrid']/div/table/tbody/tr[1]")
	protected WebElement provisioningSearchResults;

	@FindBy(xpath = "//a[@ui-sref='authorizationSummary']")
	protected WebElement viewAuthorizationsLink;

	@FindBy(css = "div.grid-placeholder.k-grid.k-widget > table > tbody > tr")
	protected List<WebElement> viewAuthorizationsSearchResultsDataCount;

	@FindBy(css = "li#authorizationSorter_mn_active > span > span")
	protected WebElement viewAuthorizationsSortByDropDown;

	@FindBy(xpath = "(//span[@class='k-link ng-binding'][contains(text(), 'Version')])[1]")
	protected WebElement versionDropDownItem;

	@FindBy(css = "div.grid-placeholder.k-grid.k-widget > table > tbody > tr:nth-child(1) > td:nth-child(1) > h5 > a")
	protected WebElement viewAuthorizationsFirstItem;

	@FindBy(xpath = "//h4[@class='ng-binding'][contains(text(), 'Authorization')]")
	protected WebElement authorizationHeaderLabel;

	@FindBy(xpath = "//a[@class='btn btn-clear ng-binding']")
	protected WebElement backToAuthorizations;

	@FindBy(xpath = "//a[@ui-sref='provisioning']")
	protected WebElement createNewProvisioningFileLink;

	@FindBy(css = "div.k-window-content.k-content > div.text-right > a.btn.btn-clear.tablet-trailer-half.phone-trailer-half.btn-cancel")
	protected WebElement createNewProvisioningFileLinkAfterClick;

	@FindBy(xpath = "//select[@name='typeSelector']")
	protected WebElement productTypeDropDown;

	@FindBy(xpath = "//*[@id='productOptions']/label[1]/select/option[3]")
	protected WebElement dropDownItemArcGISDesktop;

	@FindBy(css = "#productOptions > label:nth-child(1) > select > option:nth-child(4)")
	protected WebElement dropDownItemArcGISProForDesktop;

	@FindBy(xpath = "//select[@name='versionSelector']")
	protected WebElement versionDropDown;

	@FindBy(xpath = "//select[@name='versionSelector']/option[2]")
	protected WebElement versionDropDownFirstItem;

	@FindBy(xpath = "//*[@id='productOptions']/label[2]/select/option[3]")
	protected WebElement versionDropDownSecondItem;

	@FindBy(css = "#productOptions > label:nth-child(3) > select")
	protected WebElement licenseTypeDropDown;

	@FindBy(css = "#productOptions > label:nth-child(3) > select > option:nth-child(3)")
	protected WebElement licenseTypeSingleUselabel;

	@FindBy(css = "#productOptions > fieldset > label:nth-child(3) > input")
	protected WebElement provisionSecondRadioButton;

	@FindBy(xpath = "//span[@class='ng-binding']")
	protected WebElement selectProductsHeaderLabel;

	@FindBy(xpath = "//button[@class='btn btn-blue ng-binding']")
	protected WebElement selectProvisioningOptionsNextButton;

	@FindBy(xpath = "//*[@id='productsGrid']/div/table/tbody/tr[1]/td[5]/input")
	protected WebElement selectProductFirstCheckBox;

	@FindBy(css = "#productsGrid > div > table > tbody > tr:nth-child(4) > td.text-center.kendo-numeric-wrapper > input")
	protected WebElement selectProductThirdCheckBox;

	@FindBy(css = "button#populateWithProfile")
	protected WebElement populateUserFieldsFromMyProfile;

	@FindBy(css = "button#populateWithOrg")
	protected WebElement populateOrganizationFieldsFromMyOrganizations;

	@FindBy(xpath = "(//input[@class='ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required'])[1]")
	protected WebElement downloadRadioButton;

	@FindBy(xpath = "//span[@class='async-button-text'][contains(text(), 'Create File')]")
	protected WebElement createFileButton;

	@FindBy(xpath = "//div[@class='alert alert-green is-active trailer-1 ng-binding ng-scope']")
	protected WebElement createFileSuccessMessage;

	@FindBy(xpath = "//a[@ui-sref='provisioningFiles']")
	protected WebElement manageExistingProvisioningFilesLink;

	@FindBy(xpath = "//a[@class='tab-title js-tab ng-binding']")
	protected WebElement provisioningAndAuthorizationsLink;

	@FindBy(css = "div.k-widget.k-listview > div")
	protected List<WebElement> provisioningAndAuthorizationsDataCount;

	@FindBy(css = "div.k-widget.k-listview > div:nth-child(1)")
	protected WebElement provisioningAndAuthorizationsDataCountText;

	@FindBy(xpath = "//a[@ui-sref='licenseAllocation']")
	protected WebElement convertArcGISProNamedUserLicensesLink;

	@FindBy(css = "tbody#listview-core > tr")
	protected List<WebElement> licenseCount;

	@FindBy(xpath = "//*[@id='listview-core']/tr[1]/td[2]/table/tbody/tr[1]/td[4]/button")
	protected WebElement convertButton;

	@FindBy(css = "#listview-core > tr:nth-child(1) > td.no-padding > table > tbody > tr:nth-child(1) > td.text-center.print-hide > button")
	protected WebElement convertButtonPro;

	@FindBy(xpath = "//h4[@class='trailer-half ng-binding']")
	protected WebElement convertLicensesHeaderLabel;

	@FindBy(css = "span.k-link.k-link-increase")
	protected WebElement increaseLicenseQuantityButton;

	@FindBy(xpath = "//button[@class='btn btn-blue ng-binding ng-scope']")
	protected WebElement convertLicensesNextButton;

	@FindBy(xpath = "//h4[@class='trailer-1 ng-binding ng-scope']")
	protected WebElement reviewHeaderLabel;

	@FindBy(css = "body > div.k-widget.k-window > div.k-window-content.k-content > div.text-right > a.btn.btn-clear.tablet-trailer-half.phone-trailer-half.btn-cancel")
	protected WebElement yesPopup;

	@FindBy(xpath = "//a[@ui-sref='namedUserManagement']")
	protected WebElement generatePortalForArcGISLicensesFileLink;

	@FindBy(css = "div.k-window-content.k-content > div.text-right > a.btn.btn-clear.tablet-trailer-half.phone-trailer-half.btn-cancel")
	protected WebElement myChangesButton;

	@FindBy(xpath = "//a[@class='btn btn-clear tablet-trailer-half phone-trailer-half btn-cancel']")
	protected WebElement yesLeaveTheFormAndDiscardMyChangesLink;

	@FindBy(xpath = "(//a[@class='btn btn-clear tablet-trailer-half phone-trailer-half btn-cancel'])[2]")
	protected WebElement yesLeaveTheFormAndDiscardMyChangesLinkYourAuthorization;

	@FindBy(css = "a.btn.btn-clear.tablet-trailer-half.phone-trailer-half.btn-cancel")
	protected WebElement yesLeaveFormAndDiscardMyChangesLinkYourAuthorization;

	@FindBy(xpath = "/html/body/div[9]/div[2]/div[2]/a[1]")
	protected WebElement leaveTheFormAndDiscardMyChangesLinkYourAuthorization;

	@FindBy(css = "body > div:nth-child(26) > div.k-window-content.k-content > div.text-right > a.btn.btn-clear.tablet-trailer-half.phone-trailer-half.btn-cancel")
	protected WebElement yesLeaveTheFormAndDiscardMyChangesLinkForSingleUse;

	@FindBy(css = "body > div:nth-child(27) > div.k-window-content.k-content > div.text-right > a.btn.btn-clear.tablet-trailer-half.phone-trailer-half.btn-cancel")
	protected WebElement yesLeaveTheFormAndDiscardMyChangesLinkForSingle;

	@FindBy(xpath = "(//a[@class='btn btn-clear tablet-trailer-half phone-trailer-half btn-cancel'])[5]")
	protected WebElement yesLeaveTheFormAndDiscardMyChangesLinkForSecure;

	@FindBy(xpath = "//a[@ui-sref='developerSubscriptions']")
	protected WebElement manageDeveloperSubscriptionsLink;

	@FindBy(css = "h2.trailer-1.ng-binding")
	protected WebElement manageDeveloperSubscriptionsHeaderLabel;

	@FindBy(xpath = "(//span[@class='k-icon  k-i-arrow-60-down'])[1]")
	protected WebElement developerSubscriptionsSoryByDropDown;

	@FindBy(xpath = "(//span[@class='k-link ng-binding'][contains(text(), 'Status')])[1]")
	protected WebElement developerSubscriptionsSoryByDropDownItemStatus;

	@FindBy(xpath = "(//button[@class='btn btn-clear btn-clear2 btn-small send-code-to-user'])[1]")
	protected WebElement sendDeveloperSubscriptionCodeFirstButton;

	@FindBy(xpath = "//input[@name='email']")
	protected WebElement emailAddressInputArea;

	@FindBy(xpath = "//input[@name='firstname']")
	protected WebElement firstNameInputArea;

	@FindBy(xpath = "//input[@name='lastname']")
	protected WebElement lastNameInputArea;

	@FindBy(xpath = "(//span[@class='async-button-text'][contains(text(), 'Send')])[2]")
	protected WebElement sendDeveloperSubscriptionCodeSendButton;

	@FindBy(xpath = "//div[@ng-show='successMessageTab1']")
	protected WebElement sendDeveloperSubscriptionCodeSentSuccessMessageText;

	@FindBy(xpath = "//span[@class='k-link'][contains(text(), 'Subscription Users')]")
	protected WebElement subscriptionUsersLink;

	@FindBy(xpath = "//p[@translate='SubscriptionUsers_text']/a")
	protected WebElement manageUsersLabel;

	@FindBy(xpath = "//a[@ui-sref='licenseReturn']")
	protected WebElement recoverLostLicensesLink;

	@FindBy(xpath = "(//input[@class='ng-pristine ng-untouched ng-valid ng-empty'])[1]")
	protected WebElement findYourMachineFirstRadioButton;

	@FindBy(xpath = "//button[@class='btn btn-blue btn_step_next ng-binding']")
	protected WebElement findYourMachineNextButton;

	@FindBy(xpath = "(//select[@name='typeSelector'])[1]")
	protected WebElement coreProductNameDropDown;

	@FindBy(xpath = "//option[@label='ArcGIS Pro Advanced']")
	protected WebElement arcGISDesktopAdvancedDropDownItem;

	@FindBy(xpath = "//*[@id='licenseReturnSearch']/div[3]/div[1]/div/div[1]/div[2]/label/select")
	protected WebElement versionDropDownForRecoverLicense;

	@FindBy(xpath = "//*[@id='licenseReturnSearch']/div[3]/div[1]/div/div[1]/div[2]/label/select/option[3]")
	protected WebElement versionDropDownForRecoverLicenseSecondItem;

	@FindBy(xpath = "//select[@class='form-control full-width ng-pristine ng-untouched ng-valid ng-empty']")
	protected WebElement recoverLicenseTypeDropDown;

	@FindBy(xpath = "//select[@class='form-control full-width ng-pristine ng-untouched ng-valid ng-empty']/option[3]")
	protected WebElement recoverLicenseTypeDropDownSecondItem;

	@FindBy(xpath = "//span[@class='async-button-text'][contains(text(), 'Search')]")
	protected WebElement searchForMachineByProductSearchButton;

	@FindBy(xpath = "(//button[@class='btn btn-clear btn-clear2 btn_step_next ng-binding'])[2]")
	protected WebElement searchResultsFirstSelectButton;

	@FindBy(xpath = "//button[@class='btn btn-blue btn_step_next ng-binding']")
	protected WebElement reviewSelectedMachineNextButton;

	@FindBy(xpath = "//input[@class='ng-pristine ng-untouched ng-valid ng-empty']")
	protected WebElement acceptTermsAndConditionsCheckBox;

	@FindBy(xpath = "//span[@class='async-button-text'][contains(text(), 'Process Return')]")
	protected WebElement processReturnButton;

	@FindBy(xpath = "//div[@class='panel panel-white trailer-1']/p")
	protected WebElement recoverLostLicensesSuccessMessageText;

	@FindBy(css = "div.panel.panel-white.ng-binding > ul > li:nth-child(1) > a")
	protected WebElement onlineDeauthorizationArcGISDesktopAndArcGISEngineLink;

	@FindBy(css = "div.panel.panel-white.ng-binding > ul > li:nth-child(2) > a")
	protected WebElement offlineDeauthorizationArcGISDesktopAndArcGISEngineLink;

	@FindBy(css = "a.text-white")
	protected WebElement supportHeaderLabel;

	@FindBy(xpath = "//a[@ui-sref='activationForms']")
	protected WebElement additionalLicensingFormsLink;

	@FindBy(xpath = "//a[@class='btn btn-clear btn-fill leader-1 ng-binding'][contains(text(), 'Developer Subscription Registration')]")
	protected WebElement developerSubscriptionRegistrationLink;

	@FindBy(xpath = "//a[@class='btn btn-clear btn-fill leader-1 ng-binding'][contains(text(), 'ArcSDE 10 & ArcIMS 10 Authorizations')]")
	protected WebElement ArcSDE10ArcIMS10AuthorizationsLink;

	@FindBy(xpath = "//button[@class='btn btn-blue ng-binding']")
	protected WebElement contactInformationNextButton;

	@FindBy(xpath = "(//h4[@class='ng-binding'])[1]")
	protected WebElement yourAuthorizationHeaderLabel;

	@FindBy(xpath = "//a[@class='btn btn-clear btn-fill leader-1 ng-binding'][contains(text(), '8.x & 9.x Single Use Product Registration')]")
	protected WebElement singleUseProductRegistrationLink;

	@FindBy(xpath = "//a[@class='btn btn-clear btn-fill leader-1 ng-binding'][contains(text(), 'License File Request')]")
	protected WebElement licenseFileRequestLink;

	@FindBy(xpath = "//a[@class='btn btn-clear btn-fill leader-1 ng-binding'][contains(text(), 'Secure Site Operations')]")
	protected WebElement secureSiteOperationsLink;

	/**
	 * Initialize the PageObject for MY Esri.com My Organizations- Organization
	 * List web page
	 * 
	 * @param driver
	 *
	 */
	public LicensingPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
