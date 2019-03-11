package com.esri.sm.myesri.myorganization;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This is the MY Esri.com My Organizations tab Users web page class to identify
 * the objects within the page
 * 
 * @author Rizwan
 *
 */

public class UsersPageObjects {

	@FindBy(xpath = "//nav[@class='sub-nav-list phone-hide']/a[contains(text(), 'My Organizations')]")
	protected WebElement myOrganizationsLink;

	@FindBy(xpath = "//nav[@class='column-24']/a[@class='third-nav-link ng-binding']")
	protected List<WebElement> myEsriSubLinks;

	@FindBy(id = "appTitle")
	protected WebElement myOrganizationHeaderLabel;

	@FindBy(css = "div#appHeader > div:nth-child(2) > div:nth-child(2) > button")
	protected WebElement moreInformationLink;

	@FindBy(xpath = "//div[@class='panel panel-white trailer-1']")
	protected WebElement moreInfoPanel;

	@FindBy(css = "a.crumb.ng-binding.ng-scope")
	protected WebElement myOrganizationCommonHeaderLabel;

	@FindBy(xpath = "//aside[@class='side-nav is-active']/nav/a[@class='side-nav-link ng-binding ng-isolate-scope']")
	protected List<WebElement> usersSubLinks;

	@FindBy(xpath = "//a[@class='third-nav-link ng-binding'][contains(text(), 'Users')]")
	protected WebElement usersLink;

	@FindBy(xpath = "//a[@class='third-nav-link ng-binding'][contains(text(), 'Licensing')]")
	protected WebElement licensingLink;

	@FindBy(css = "input#quickSearch")
	protected WebElement quickSearchInputArea;

	@FindBy(css = "#usersSorter > li")
	protected WebElement manageUsersSortByDropDown;

	@FindBy(css = "#usersSorter > li > div > ul > li:nth-child(4) > span")
	protected WebElement manageUsersSortByDropDownItem;

	@FindBy(css = "tr.k-master-row")
	protected List<WebElement> searchResultsCount;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Invite Users')]")
	protected WebElement inviteUsersLink;

	@FindBy(xpath = "//input[@id='emails']")
	protected WebElement emailAddressInputArea;

	@FindBy(xpath = "(//button[contains(text(),'Next')])[3]")
	protected WebElement emailAddressNextButton;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	protected WebElement nextButton;

	@FindBy(css = "tr.invite-status-verified")
	protected List<WebElement> emailAddressCount;

	@FindBy(xpath = "(//h2[@class='trailer-1 font-size-2 ng-binding'])[1]")
	protected WebElement sendInvitationHeaderLabel;

	@FindBy(css = "#sendButton")
	protected WebElement sendInvitationButton;

	@FindBy(css = "span#thankyouMessage")
	protected WebElement thankYouMessage;

	@FindBy(xpath = "//a[@side-nav-item='ManageUsers']")
	protected WebElement manageUsersLink;

	@FindBy(xpath = "//a[@class='btn btn-clear tablet-trailer-half phone-trailer-half btn-cancel']")
	protected WebElement discardMyChangesButton;

	@FindBy(xpath = "//a[@data-id='deen9004']")
	protected WebElement deleteUser;

	@FindBy(xpath = "//span[@class='async-button-text'][contains(text(), 'Disconnect')]")
	protected WebElement disconnectButton;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Connect Users')]")
	protected WebElement connectUsersLink;

	@FindBy(xpath = "//button[@class='btn btn-clear btn-clear2 btn-small ng-binding']")
	protected WebElement removeUnverifiedUserNamesLink;

	@FindBy(css = "div.tag-editor > label > input")
	protected WebElement userNameInputArea;
	
	@FindBy(xpath = "//input[@class='tag-input ng-valid ng-valid-maxlength ng-dirty ng-empty ng-touched']")
	protected WebElement userNameInputAreaAfterRemove;
	
	@FindBy(xpath = ".//*[@id='ConnectUser']/div[4]/div[1]/div/div/div[3]/button")
	protected WebElement userNameNextButton;

	@FindBy(css = "div#appHeader > div:nth-child(2) >a")
	protected WebElement moreButton;

	@FindBy(css = "[title='Remove']")
	protected WebElement userRemoveIcon;
	
	@FindBy(xpath = "(//h4[@class='trailer-half ng-binding'])[2]")
	protected WebElement permissionsToGrantheaderlabel;

	@FindBy(xpath = "//span[contains(text(), 'Connect User(s)')]")
	protected WebElement connectUsersButton;

	@FindBy(xpath = "//div[@class='alert alert-green is-active trailer-1 ng-binding']")
	protected WebElement connectUsersSuccessMessageLabel;

	@FindBy(css = "aside.side-nav.is-active > nav >a:nth-child(4)")
	protected WebElement manageRequestsLink;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Permissions Report')]")
	protected WebElement permissionsReportLink;

	@FindBy(css = "button.btn.btn-transparent.ng-binding")
	protected WebElement expandCollapseAllButton;

	@FindBy(xpath = "//div[@class='accordion-section download-meta ng-scope is-active']")
	protected List<WebElement> expandAllresultsCount;

	@FindBy(css = "[side-nav-item = 'PermissionsLog']")
	protected WebElement permissionsLogLink;

	@FindBy(css = "#permissionLogTable > table > tbody")
	protected List<WebElement> permissionLogSearchResultsCount;
	
	@FindBy(css = "#permissionLogTable > table > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(4)")
	protected WebElement permissionLogSearchResultsText;

	@FindBy(css = "[side-nav-item='OrgTags']")
	protected WebElement manageTagsLink;

	@FindBy(xpath = "//tbody[@role='rowgroup']/tr")
	protected List<WebElement> manageTagsSearchResultsCount;

	@FindBy(xpath = "//button[@class='btn btn-blue ng-binding']")
	protected WebElement addTagButton;

	@FindBy(xpath = "//input[@class='ng-pristine ng-empty ng-invalid ng-invalid-required ng-valid-maxlength ng-touched']")
	protected WebElement tagNameInputArea;

	@FindBy(xpath = "//span[@class='async-button-text'][contains(text(), 'Add')]")
	protected WebElement addTagNameButton;

	@FindBy(xpath = "//div[@class='alert alert-green trailer-1 ng-binding is-active']")
	protected WebElement addTagNameSuccessMessage;

	@FindBy(css = "[side-nav-item='PermissionsBulkUpdate']")
	protected WebElement permissionsBulkUpdateLink;

	@FindBy(xpath = "//h2[@class='ng-binding'][contains(text(), 'Permissions Bulk Update')]")
	protected WebElement permissionsBulkUpdateHeaderLabel;

	@FindBy(xpath = "//div[@id='container_permissions_step1']//label[1]/input")
	protected WebElement grantASinglePermissionRadioButton;

	@FindBy(css = "#container_permissions_step1 > fieldset > label:nth-child(2) > input")
	protected WebElement assignPermissionsDropDown;
	
	@FindBy(css = "#panel_permissionAction > div > div:nth-child(1) > label > select")
	protected WebElement assignPermissionsDropDownList;
	
	@FindBy(css = "#panel_permissionAction > div > div:nth-child(1) > label > select > option:nth-child(5)")
	protected WebElement viewTransactionInformationDropDownItem;
	
	@FindBy(css = "#panel_permissionAction > div > div:nth-child(1) > label > select > option:nth-child(6)")
	protected WebElement performTransactionTasksDropDownItem;
	
	@FindBy(css = "#userPermissionsGrid > div > table > tbody > tr:nth-child(1) > td:nth-child(2) > input")
	protected WebElement firstUserCheckbox;

	@FindBy(css = "button#btn_step2_next")
	protected WebElement userNextButton;

	@FindBy(css = "	button#btn_step3_next")
	protected WebElement permissionsMessageandLogNoteNextButton;

	@FindBy(xpath = "//span[@class='async-button-text'][contains(text(), 'Update Permissions')]")
	protected WebElement updatePermissionsButton;

	@FindBy(xpath = "//div[@class='alert alert-green is-active leader-0 trailer-1 ng-binding']")
	protected WebElement permissionsBulkUpdateSuccessMessageLabel;

	@FindBy(css = "[side-nav-item='PermissionsGrid']")
	protected WebElement permissionsGridLink;

	@FindBy(xpath = "(//h3[@class='text-white trailer-0'])[1]")
	protected WebElement myEsriReportsHeaderLabel;

	@FindBy(xpath = "//h3[@class='leader-1 trailer-half']")
	protected WebElement permissionsGridHeaderLabel;

	/**
	 * Initialize the PageObject for MY Esri site My Organizations - Users web
	 * page
	 * 
	 * @param driver
	 *
	 */
	public UsersPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
