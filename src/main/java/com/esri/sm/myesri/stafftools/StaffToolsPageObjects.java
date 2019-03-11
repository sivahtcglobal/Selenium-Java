package com.esri.sm.myesri.stafftools;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This is the MY Esri.com Staff Tools tab
 * 
 * @author Rizwan
 *
 */

public class StaffToolsPageObjects {

	@FindBy(css = "#topperBannerContainer > nav > a:nth-child(4)")
	protected WebElement staffToolsLink;

	@FindBy(id = "appTitle")
	protected WebElement myOrganizationHeaderLabel;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope no-permission is-active']/nav/a")
	protected List<WebElement> staffToolsSubLinks;

	@FindBy(xpath = "//*[@id='toolsOverview']/div[2]/div/div[1]/div[1]/div[1]/label/select")
	protected WebElement staffToolsOverviewDistributorDropDown;

	@FindBy(xpath = "//*[@id='toolsOverview']/div[2]/div/div[1]/div[1]/div[1]/label/select/option[4]")
	protected WebElement staffToolsOverviewDistributorFilterEsriCanadaDropDownOption;

	@FindBy(xpath = "//*[@id='toolsOverview']/div[3]/div/div[1]/div[1]/div/button/h4")
	protected WebElement staffToolsOverviewDistributorFilterResults;

	@FindBy(xpath = "//*[@id='toolsOverview']/div[4]/div[2]/div/div/button")
	protected List<WebElement> staffToolsOverviewMenuButtonList;
	
	@FindBy(xpath = "//*[@class='card block trailer-half']/div/h4")
	protected List<WebElement> staffToolsOverviewlabel;
	
	@FindBy(css ="a.btn.btn-clear.tablet-trailer-half.phone-trailer-half.btn-cancel")
	protected WebElement Noticeyes;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope no-permission is-active']/nav/a[contains(text(), 'Staff Tools Overview')]")
	protected WebElement staffToolsOverviewLink;

	@FindBy(css = "#left-nav > aside.side-nav.ng-isolate-scope.no-permission.is-active > nav > a:nth-child(2)")
	protected WebElement userRequestsLink;

	@FindBy(css = "input#quickSearch")
	protected WebElement quickSearchInputArea;

	@FindBy(css = "div.k-grid-content.k-auto-scrollable > table > tbody > tr")
	protected List<WebElement> userRequestsSearchResults;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope no-permission is-active']/nav/a[contains(text(), 'User Connections')]")
	protected WebElement userConnectionsLink;

	@FindBy(css = "#filter-text1")
	protected WebElement userConnectionsFirstNameInputArea;

	@FindBy(css = "div.ng-isolate-scope > p > button.btn.btn-blue.margin-right-1.ng-binding")
	protected WebElement userConnectionsApplyButton;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope no-permission is-active']/nav/a[contains(text(), 'User Invitations')]")
	protected WebElement userInvitationsLink;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope no-permission is-active']/nav/a[contains(text(), 'Developer Subscription Connections')]")
	protected WebElement developerSubscriptionConnectionsLink;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope no-permission is-active']/nav/a[contains(text(), 'Distributor Email Configuration')]")
	protected WebElement distributorEmailConfigurationLink;

	@FindBy(css = "#distributorEmails > div.ng-scope > div:nth-child(1) > div:nth-child(2) > div.right.leader-0.trailer-half > p > button")
	protected WebElement addRecipientButton;

	@FindBy(xpath = "//*[@id='editRecipient']/label[1]/input")
	protected WebElement addRecipientEmailAddressInputArea;

	@FindBy(xpath = "//*[@id='editRecipient']/label[2]/input")
	protected WebElement addRecipientNameInputArea;

	@FindBy(css = "#editRecipient > fieldset > label:nth-child(2) > span > input")
	protected WebElement addRecipientFeedbackCheckbox;
	
	@FindBy(css = "#editRecipient > div > button.btn.btn-blue.ng-binding")
	protected WebElement addRecipientAddButton;
	
	@FindBy(css = "#emailConfigGrid > div > table > tbody > tr")
	protected List<WebElement> addRecipientResults;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope no-permission is-active']/nav/a[contains(text(), 'Distributor Notification')]")
	protected WebElement distributorNotificationLink;

	@FindBy(css = "a.btn.btn-clear.btn-small.right.ng-binding")
	protected WebElement notificationSettingsEditLink;
	
	@FindBy(xpath = "//*[@id='notificationConfiguration']/div[4]/div/div/div/ul/li[1]/span[2]")
	protected WebElement notificationSettingsLink;

	@FindBy(xpath = "//div[@class='k-content k-state-active']/div/h3")
	protected WebElement notificationSettingsHeaderLabel;
		
	@FindBy(css = "li.ng-binding.k-item.k-state-default.k-last > span.k-link")
	protected WebElement notificationLogLink;

	@FindBy(css = "#notificationHistoryGrid > div > table > thead > tr > th:nth-child(1) > a")
	protected WebElement notificationLogDetailsHeaderLabels;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope no-permission is-active']/nav/a[contains(text(), 'Distributor Site')]")
	protected WebElement distributorSiteLink;

	@FindBy(xpath = "//*[@id='siteConfig']/div[4]/div/div[1]/div/div[1]/div[3]/button")
	protected WebElement distributorSiteConfigurationFirstItemDescriptionButton;

	@FindBy(xpath = "//*[@id='siteConfig']/div[4]/div/div[1]/div/div[2]")
	protected WebElement distributorSiteConfigurationFirstItemDescriptionDetailsText;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope no-permission is-active']/nav/a[contains(text(), 'Distributor Permissions Bulk Update')]")
	protected WebElement distributorPermissionsBulkUpdateLink;

	@FindBy(css = "#panel_permissionAction > div > label > select")
	protected WebElement selectAPermissionToGrantDropDown;

	@FindBy(css = "#panel_permissionAction > div > label > select > option:nth-child(4)")
	protected WebElement viewLicensingInformationDropDownItem;

	@FindBy(css = "#container_permissions_step1 > div.action-bar.text-right.leader-2 > button")
	protected WebElement selectActionToPerformNextButton;

	@FindBy(css = "#userPermissionsGrid > div > table > tbody > tr:nth-child(1) > td:nth-child(2) > input")
	protected WebElement selectUsersFirstUserCheckbox;

	@FindBy(css = "#btn_step2_next")
	protected WebElement selectUsersNextButton;

	@FindBy(css = "#container_permissions_step3 > fieldset > label:nth-child(3) > input")
	protected WebElement sendEmailToUserNoRadioButton;

	@FindBy(css = "#container_permissions_step3 > label:nth-child(5) > textarea")
	protected WebElement noteForLogInputArea;

	@FindBy(css = "#btn_step3_next")
	protected WebElement permissionsMessageAndLogNoteNextButton;

	@FindBy(css = "#btn_step4_next")
	protected WebElement updatePermissions;

	@FindBy(css = "div.alert.alert-green.is-active.leader-0.trailer-1.ng-binding")
	protected WebElement distributorPermissionsBulkUpdateSuccessfullMessage;

	/**
	 * Initialize the PageObjects for MY Esri.com Staff Tools
	 * 
	 * @param driver
	 *
	 */
	public StaffToolsPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
