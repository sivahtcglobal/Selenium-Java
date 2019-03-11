package com.esri.sm.myesri.myorganization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationPage;

/**
 * This is the MY Esri site My Organization Users page class to perform actions
 * 
 * @author Rizwan
 *
 */
public class UsersPageFeatures extends PageObjects {

	private UsersPageObjects usersPageObjects;
	private Map<String, String> inputDataMap;

	public UsersPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		usersPageObjects = new UsersPageObjects(driver);
	}

	public List<String> myOrganizationSubTabs() {
		List<String> subLinkNames = new ArrayList<String>();
		for (int i = 0; i < usersPageObjects.myEsriSubLinks.size(); i++) {
			subLinkNames.add(usersPageObjects.myEsriSubLinks.get(i).getText());
		}
		return subLinkNames;
	}

	public List<String> usersSubTabs() {
		List<String> usersSubLinkNames = new ArrayList<String>();
		for (int i = 0; i < usersPageObjects.usersSubLinks.size(); i++) {
			usersSubLinkNames.add(usersPageObjects.usersSubLinks.get(i).getText());
		}
		return usersSubLinkNames;
	}

	/**
	 * This method performs click event for My Organization and retrieve My
	 * Organizations Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationHeaderLabel() {
		waitForPageToLoad();
		scrollIntoViewByElement(usersPageObjects.myOrganizationsLink);
		click(usersPageObjects.myOrganizationsLink);
		return getText(usersPageObjects.myOrganizationCommonHeaderLabel);
	}

	/**
	 * This method performs click event for Overview
	 * 
	 */
	public void clickOnUsers() {
		scrollIntoViewByElement(usersPageObjects.usersLink);
		click(usersPageObjects.usersLink);
	}

	/**
	 * This method performs click event for Users and retrieve Manage Users
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveManageUsersHeaderLabel() {
		waitForPageToLoad();
		return getText(usersPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click search event for Manage Users and retrieve
	 * Results count
	 * 
	 * @return boolean
	 */
	public boolean isManageUsersSearchResultsAreAvailable() {
		boolean searchResults = false;
		if (getSize(usersPageObjects.searchResultsCount) > 0) {
			searchResults = true;
		} else {
			Log.info("No search results are found");
		}
		return searchResults;
	}

	/**
	 * This method performs filter search event for Manage Users and retrieve
	 * Results count
	 * 
	 * @return boolean
	 */
	public boolean isManageUsersFilterResultsAreAvailable() {
		boolean sortByResults = false;
		scrollIntoViewByElement(usersPageObjects.manageUsersSortByDropDown);
		click(usersPageObjects.manageUsersSortByDropDown);
		waitForPageToLoad();
		click(usersPageObjects.manageUsersSortByDropDownItem);
		if (getSize(usersPageObjects.searchResultsCount) > 0) {
			sortByResults = true;
		} else {
			Log.info("No filter results are found");
		}
		return sortByResults;
	}

	/**
	 * This method performs click event for Invite Users side navigation link
	 * and retrieve the header Label
	 * 
	 * @return String
	 */
	public String retrieveInviteUsersHeaderLabel() {
		scrollIntoViewByElement(usersPageObjects.inviteUsersLink);
		click(usersPageObjects.inviteUsersLink);
		return getText(usersPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Edit Organization Name and retrieve
	 * the header Label
	 * 
	 * @return boolean
	 */
	public boolean isProvideEmailAddressesToInviteSuccess() {
		boolean emailAddress = false;
		inputText(usersPageObjects.emailAddressInputArea,
				inputDataMap.get(MyOrganizationPage.REPLACE_CONTACT_EMAIL_ID));
		scrollIntoViewByElement(usersPageObjects.moreInformationLink);
		click(usersPageObjects.moreInformationLink);
		scrollIntoViewByElement(usersPageObjects.emailAddressNextButton);
		click(usersPageObjects.emailAddressNextButton);
		if (getSize(usersPageObjects.emailAddressCount) > 0) {
			emailAddress = true;
		}
		return emailAddress;
	}

	/**
	 * This method performs click event for Send Invitation button and retrieve
	 * request success message
	 * 
	 * @return String
	 */
	public String retrieveSendInvitationSuccessMessage() {
		waitForPageToLoad();
		inputText(usersPageObjects.emailAddressInputArea,
				inputDataMap.get(MyOrganizationPage.REPLACE_CONTACT_EMAIL_ID));
		scrollIntoViewByElement(usersPageObjects.moreInformationLink);
		click(usersPageObjects.moreInformationLink);
		scrollIntoViewByElement(usersPageObjects.emailAddressNextButton);
		click(usersPageObjects.emailAddressNextButton);
		scrollIntoViewByElement(usersPageObjects.nextButton);
		click(usersPageObjects.nextButton);
		scrollIntoViewByElement(usersPageObjects.sendInvitationButton);
		click(usersPageObjects.sendInvitationButton);
		return getText(usersPageObjects.thankYouMessage);
	}

	/**
	 * This method performs click event for Request Permission and retrieve the
	 * header label
	 * 
	 * @return String
	 */
	public void deleteUserFromOrg() {
		scrollIntoViewByElement(usersPageObjects.manageUsersLink);
		click(usersPageObjects.manageUsersLink);
		scrollIntoViewByElement(usersPageObjects.discardMyChangesButton);
		click(usersPageObjects.discardMyChangesButton);
		scrollIntoViewByElement(usersPageObjects.deleteUser);
		click(usersPageObjects.deleteUser);
		scrollIntoViewByElement(usersPageObjects.disconnectButton);
		click(usersPageObjects.disconnectButton);
		waitForPageToLoad();
		scrollIntoViewByElement(usersPageObjects.connectUsersLink);
		click(usersPageObjects.connectUsersLink);
	}

	/**
	 * This method performs click event for Request Permission and retrieve the
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveConnectUsersHeaderLabel() {
		scrollIntoViewByElement(usersPageObjects.connectUsersLink);
		click(usersPageObjects.connectUsersLink);
		return getText(usersPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs delete user if contains on manage users
	 * 
	 * @return String
	 */
	public void checkUserAvailability() {
		inputText(usersPageObjects.userNameInputArea, inputDataMap.get(MyEsriUserPages.USERNAME));
		scrollIntoViewByElement(usersPageObjects.moreButton);
		click(usersPageObjects.moreButton);
		if (isElementAvailable(usersPageObjects.removeUnverifiedUserNamesLink)) {
			deleteUserFromOrg();
		} else {
			scrollIntoViewByElement(usersPageObjects.userRemoveIcon);
			click(usersPageObjects.userRemoveIcon);
			Log.info("We are able to add the provided user");
		}
	}

	/**
	 * This method performs click event for Connect Users button and retrieve
	 * request success message
	 * 
	 * @return String
	 */
	public String retrieveConnectUsersSuccessMessage() {
		inputText(usersPageObjects.userNameInputArea, inputDataMap.get(MyEsriUserPages.USERNAME));
		scrollIntoViewByElement(usersPageObjects.moreButton);
		click(usersPageObjects.moreButton);
		scrollIntoViewByElement(usersPageObjects.userNameNextButton);
		click(usersPageObjects.userNameNextButton);
		scrollIntoViewByElement(usersPageObjects.nextButton);
		click(usersPageObjects.nextButton);
		scrollIntoViewByElement(usersPageObjects.connectUsersButton);
		click(usersPageObjects.connectUsersButton);
		scrollIntoViewByElement(usersPageObjects.connectUsersSuccessMessageLabel);
		return getText(usersPageObjects.connectUsersSuccessMessageLabel);
	}

	/**
	 * This method performs click event for Manage Requests button and retrieve
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveManageRequestsHeaderLabel() {
		scrollIntoViewByElement(usersPageObjects.manageRequestsLink);
		click(usersPageObjects.manageRequestsLink);
		isElementAvailable(usersPageObjects.myOrganizationHeaderLabel, Integer.toString(3));
		return getText(usersPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Permissions Report button and
	 * retrieve header label
	 * 
	 * @return String
	 */
	public String retrievePermissionsReportHeaderLabel() {
		scrollIntoViewByElement(usersPageObjects.permissionsReportLink);
		click(usersPageObjects.permissionsReportLink);
		return getText(usersPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Edit Organization Name and retrieve
	 * the header Label
	 * 
	 * @return boolean
	 */
	public boolean isPermissionsReportExpandResultsAreAvailable() {
		boolean reports = false;
		clickAfterScroll(usersPageObjects.expandCollapseAllButton);
		if (getSize(usersPageObjects.expandAllresultsCount) > 0) {
			reports = true;
		}
		return reports;
	}

	/**
	 * This method performs click event for Permissions Log button and retrieve
	 * header label
	 * 
	 * @return String
	 */
	public String retrievePermissionsLogHeaderLabel() {
		scrollIntoViewByElement(usersPageObjects.permissionsLogLink);
		click(usersPageObjects.permissionsLogLink);
		isElementAvailable(usersPageObjects.myOrganizationHeaderLabel, Integer.toString(3));
		return getText(usersPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs Search event for Performance Log and retrieve
	 * Results count
	 * 
	 * @return boolean
	 */
	public boolean isPermissionsLogSearchResultsAreAvailable() {
		boolean plResults = false;
		getText(usersPageObjects.permissionLogSearchResultsText);
		int i = getSize(usersPageObjects.permissionLogSearchResultsCount);
		if (i > 0) {
			plResults = true;
		} else {
			Log.info("No Search results are found");
		}
		return plResults;
	}

	/**
	 * This method performs click event for Manage Tags button and retrieve
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveManageTagsHeaderLabel() {
		scrollIntoViewByElement(usersPageObjects.manageTagsLink);
		click(usersPageObjects.manageTagsLink);
		waitForPageToLoad();
		return getText(usersPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs Search event for Manage Tags and retrieve Results
	 * count
	 * 
	 * @return boolean
	 */
	public boolean isManageTagsSearchResultsAreAvailable() {
		boolean mtResults = false;
		inputText(usersPageObjects.quickSearchInputArea, inputDataMap.get(MyOrganizationPage.ORGANIZATION_NEW_NAME));
		if (getSize(usersPageObjects.manageTagsSearchResultsCount) > 0) {
			mtResults = true;
		} else {
			Log.info("No Search results are found");
		}
		return mtResults;
	}

	/**
	 * This method performs click event for Permissions Bulk Update side
	 * navigation and retrieve header label
	 * 
	 * @return String
	 */
	public String retrievePermissionsBulkUpdateHeaderLabel() {
		scrollIntoViewByElement(usersPageObjects.permissionsBulkUpdateLink);
		click(usersPageObjects.permissionsBulkUpdateLink);
		return getText(usersPageObjects.permissionsBulkUpdateHeaderLabel);
	}

	/**
	 * This method performs Permissions Bulk Update events and retrieve the
	 * request success message
	 * 
	 * @return String
	 */
	public String retrievePermissionsBulkUpdateSuccessMessageLabel() {
		clickAfterScroll(usersPageObjects.grantASinglePermissionRadioButton);
		if (inputDataMap.get(MyEsriUserPages.USERNAME).contains("EsriTestAutomation0")) {
			Log.info("User no need to select permission drop down");
		} else {
			clickAfterScroll(usersPageObjects.assignPermissionsDropDown);
			clickAfterScroll(usersPageObjects.assignPermissionsDropDownList);
			click(usersPageObjects.performTransactionTasksDropDownItem);
		}
		scrollIntoViewByElement(usersPageObjects.nextButton);
		click(usersPageObjects.nextButton);
		clickAfterScroll(usersPageObjects.firstUserCheckbox);
		scrollIntoViewByElement(usersPageObjects.nextButton);
		click(usersPageObjects.nextButton);
		scrollIntoViewByElement(usersPageObjects.permissionsMessageandLogNoteNextButton);
		click(usersPageObjects.permissionsMessageandLogNoteNextButton);
		scrollIntoViewByElement(usersPageObjects.updatePermissionsButton);
		click(usersPageObjects.updatePermissionsButton);
		return getText(usersPageObjects.permissionsBulkUpdateSuccessMessageLabel);
	}

	/**
	 * This method performs click event for Permissions Bulk Update side
	 * navigation and retrieve header label
	 * 
	 * @return String
	 */
	public String retrievePermissionsGridHeaderLabel() {
		scrollIntoViewByElement(usersPageObjects.permissionsGridLink);
		click(usersPageObjects.permissionsGridLink);
		waitForPageToLoad();
		return getText(usersPageObjects.permissionsGridHeaderLabel);
	}

}
