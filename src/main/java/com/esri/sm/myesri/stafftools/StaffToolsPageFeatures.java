package com.esri.sm.myesri.stafftools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationReports;

/**
 * This is the MY Esri site Staff Tools tab
 * 
 * @author Rizwan
 *
 */
public class StaffToolsPageFeatures extends PageObjects {

	private StaffToolsPageObjects staffToolsPageObjects;

	public StaffToolsPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		staffToolsPageObjects = new StaffToolsPageObjects(driver);
	}

	/**
	 * public List<String> myOrganizationSubTabs() { List<String> subLinkNames =
	 * new ArrayList<String>(); for (int i = 0; i <
	 * staffToolsPageObjects.myEsriSubLinks.size(); i++) {
	 * subLinkNames.add(staffToolsPageObjects.myEsriSubLinks.get(i).getText());
	 * } return subLinkNames; }
	 */

	public List<String> staffToolsSubTabs() {
		waitForPageToLoad();
		List<String> staffToolsSubLinkNames = new ArrayList<String>();
		for (int i = 0; i < staffToolsPageObjects.staffToolsSubLinks.size()-1; i++) {
			staffToolsSubLinkNames.add(staffToolsPageObjects.staffToolsSubLinks.get(i).getText());
		}
		return staffToolsSubLinkNames;
	}

	/**
	 * This method retrieve staff tools tab availability
	 * 
	 * @return boolean
	 */
	public boolean isStaffToolsTabAvailable() {
		return isElementAvailable(staffToolsPageObjects.staffToolsLink);
	}
	
	/**
	 * This method perform click event on Staff tools link
	 * 
	 */
	public void clickOnStaffToolsLink() {
		waitForPageToLoad();
		clickAfterScroll(staffToolsPageObjects.staffToolsLink);
	}
	
	public void clickOnNoticeyes() {
		waitForPageToLoad();
		if (isElementAvailable(staffToolsPageObjects.Noticeyes)) {
			click(staffToolsPageObjects.Noticeyes);
		} else {
			Log.info("Notice popup is not available");
		}
	}	
	/**
	 * This method performs click event for Staff Tools and retrieve My Staff
	 * Tools Overview Header Label
	 * 
	 * @return String
	 */
	public String retrieveStaffToolsOverviewHeaderLabel() {
		click(staffToolsPageObjects.staffToolsLink);
		return getText(staffToolsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method returns true if user contains Distributors filter results
	 * 
	 * @return boolean
	 */
	public boolean isStaffToolsOverviewFilterResultsAreAvailable() {
		boolean staffToolsOverviewSearchResults = false;
		click(staffToolsPageObjects.staffToolsOverviewDistributorDropDown);
		click(staffToolsPageObjects.staffToolsOverviewDistributorFilterEsriCanadaDropDownOption);
		if (isElementAvailable(staffToolsPageObjects.staffToolsOverviewDistributorFilterResults)) {
			staffToolsOverviewSearchResults = true;
		} else {
			Log.info("Staff Tools Overview filter results are not available");
		}
		return staffToolsOverviewSearchResults;
	}

	/**
	 * This method retrieve the Staff Tools Overviews Header Label list count
	 * 
	 * @return int
	 */
	public int retrieveStaffToolsOverviewCount() {
		return staffToolsPageObjects.staffToolsOverviewMenuButtonList.size();
	}

	/**
	 * This method retrieve the Staff Tools Overviews Header Label
	 * 
	 * @return String
	 */
	public String retrieveStaffToolsOverviewHeaderLabel(int index) {
		return getText(staffToolsPageObjects.staffToolsOverviewMenuButtonList.get(index));
	}

	public String retrieveStaffToolsOverviewLabel(int index) {
		return getText(staffToolsPageObjects.staffToolsOverviewlabel.get(index));
	}

	/**
	 * This method performs click event for Staff Tools Overviews list and
	 * retrieve My Organizations Header Label
	 * 
	 * @param linkIndex
	 *            link name index
	 * 
	 */
	public String retrieveStaffToolsHeaderLabel(int linkIndex) {
		waitForPageToLoad();
		WebElement element = staffToolsPageObjects.staffToolsOverviewMenuButtonList.get(linkIndex);
		clickAfterScroll(element);
		return getText(staffToolsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method perform the click event for Staff tools Overview link
	 * 
	 */
	public void clickOnStaffToolsOverview() {
		click(staffToolsPageObjects.staffToolsOverviewLink);
	}

	/**
	 * This method perform click event for Users request and returns header
	 * label
	 * 
	 * @return String
	 */
	public String retrieveUsersRequestHeaderLabel() {
		click(staffToolsPageObjects.userRequestsLink);
		return getText(staffToolsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for User Request Apply button and
	 * validate results availability
	 * 
	 * @return boolean
	 */
	public boolean isUserRequestSearchResultsAreAvailable() {
		boolean searchResults = false;
		inputText(staffToolsPageObjects.quickSearchInputArea, MyOrganizationReports.PROGRAMSSEARCHTEXT);
		if (getSize(staffToolsPageObjects.userRequestsSearchResults) > 0) {
			searchResults = true;
		} else {
			Log.info("Search Results are not available for User Request");
		}
		return searchResults;
	}

	/**
	 * This method perform click event for Users Connections and returns header
	 * label
	 * 
	 * @return String
	 */
	public String retrieveUserConnectionsHeaderLabel() {
		click(staffToolsPageObjects.userConnectionsLink);
		return getText(staffToolsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for User Connections Apply button and
	 * validate results availability
	 * 
	 * @return boolean
	 */
	public boolean isUserConnectionsSearchResultsAreAvailable() {
		boolean userConnectionsData = false;
		inputText(staffToolsPageObjects.userConnectionsFirstNameInputArea, MyOrganizationReports.COMMON_SEARCH_TEXT);
		click(staffToolsPageObjects.userConnectionsApplyButton);
		waitForPageToLoad();
		if (getSize(staffToolsPageObjects.userRequestsSearchResults) > 0) {
			userConnectionsData = true;
		} else {
			Log.error("User Connections data is not available");
		}
		return userConnectionsData;
	}

	/**
	 * This method perform click event for Users Invitations and returns header
	 * label
	 * 
	 * @return String
	 */
	public String retrieveUserInvitationsHeaderLabel() {
		click(staffToolsPageObjects.userInvitationsLink);
		return getText(staffToolsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for User Invitations Apply button and
	 * validate results availability
	 * 
	 * @return boolean
	 */
	public boolean isUserInvitationsSearchResultsAreAvailable() {
		boolean userConnectionsData = false;
		inputText(staffToolsPageObjects.userConnectionsFirstNameInputArea, MyOrganizationReports.EMIAL);
		click(staffToolsPageObjects.userConnectionsApplyButton);
		if (getSize(staffToolsPageObjects.userRequestsSearchResults) > 0) {
			userConnectionsData = true;
		} else {
			Log.error("User Invitations data is not available");
		}
		return userConnectionsData;
	}

	/**
	 * This method perform click event for Developer Subscription Connections
	 * and returns header label
	 * 
	 * @return String
	 */
	public String retrieveDeveloperSubscriptionConnectionsHeaderLabel() {
		click(staffToolsPageObjects.developerSubscriptionConnectionsLink);
		return getText(staffToolsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method perform click event for Distributor Email Configuration and
	 * returns header label
	 * 
	 * @return String
	 */
	public String retrieveDistributorEmailConfigurationHeaderLabel() {
		click(staffToolsPageObjects.distributorEmailConfigurationLink);
		return getText(staffToolsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method perform click event for Add Recipient and will add the
	 * recipient
	 * 
	 * @return boolean
	 */
	public boolean isAddRecipientIsSuccess() {
		boolean recipient = false;
		String random = null;
		String emailAddress = null;
		String firstName = null;
		String test = "Test";
		Random rnum = new Random();
		random = Integer.toString(rnum.nextInt(2000000));
		emailAddress = random + MyOrganizationReports.EMIAL;
		firstName = test + random;
		int recipientCount = getSize(staffToolsPageObjects.addRecipientResults);
		click(staffToolsPageObjects.addRecipientButton);
		waitForPageToLoad();
		inputText(staffToolsPageObjects.addRecipientEmailAddressInputArea, emailAddress);
		inputText(staffToolsPageObjects.addRecipientNameInputArea, firstName);
		click(staffToolsPageObjects.addRecipientFeedbackCheckbox);
		click(staffToolsPageObjects.addRecipientAddButton);
		if (getSize(staffToolsPageObjects.addRecipientResults) > recipientCount) {
			recipient = true;
		} else {
			Log.info("Add Recipient is unsuccess");
		}
		return recipient;
	}

	/**
	 * This method perform click event for Distributor Notification
	 * Configuration and returns header label
	 * 
	 * @return String
	 */
	public String retrieveDistributorNotificationConfigurationHeaderLabel() {
		click(staffToolsPageObjects.distributorNotificationLink);
		return getText(staffToolsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method perform click event for Notification Log and returns header
	 * label
	 * 
	 * @return String
	 */
	public String retrieveNotificationLogHeaderLabel() {
		click(staffToolsPageObjects.notificationLogLink);
		return getText(staffToolsPageObjects.notificationLogDetailsHeaderLabels);
	}

	/**
	 * This method perform click event for Notification Settings and returns
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveNotificationSettingsHeaderLabel() {
		click(staffToolsPageObjects.notificationSettingsLink);
		return getText(staffToolsPageObjects.notificationSettingsHeaderLabel);
	}

	/**
	 * This method perform click event for Distributor Site Configuration and
	 * returns header label
	 * 
	 * @return String
	 */
	public String retrieveDistributorSiteConfigurationHeaderLabel() {
		click(staffToolsPageObjects.distributorSiteLink);
		return getText(staffToolsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method perform click event for Distributor Site Configuration first
	 * item description and returns description label
	 * 
	 * @return String
	 */
	public String retrieveDistributorSiteConfigurationFirstItemDescriptionHeaderLabel() {
		click(staffToolsPageObjects.distributorSiteConfigurationFirstItemDescriptionButton);
		return getText(staffToolsPageObjects.distributorSiteConfigurationFirstItemDescriptionDetailsText);
	}

	/**
	 * This method perform click event for Distributor Permissions Bulk Update
	 * and returns header label
	 * 
	 * @return String
	 */
	public String retrieveDistributorPermissionsBulkUpdateHeaderLabel() {
		click(staffToolsPageObjects.distributorPermissionsBulkUpdateLink);
		return getText(staffToolsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method perform click event for Distributor Permissions Bulk Update
	 * and returns header label
	 * 
	 * @return String
	 */
	public String retrieveDistributorPermissionsBulkUpdateSuccessMessageHeaderLabel() {
		clickAfterScroll(staffToolsPageObjects.selectAPermissionToGrantDropDown);
		clickAfterScroll(staffToolsPageObjects.viewLicensingInformationDropDownItem);
		clickAfterScroll(staffToolsPageObjects.selectActionToPerformNextButton);
		clickAfterScroll(staffToolsPageObjects.selectUsersFirstUserCheckbox);
		clickAfterScroll(staffToolsPageObjects.selectUsersNextButton);
		clickAfterScroll(staffToolsPageObjects.sendEmailToUserNoRadioButton);
		inputText(staffToolsPageObjects.noteForLogInputArea, MyOrganizationReports.COMMON_SEARCH_TEXT);
		clickAfterScroll(staffToolsPageObjects.permissionsMessageAndLogNoteNextButton);
		clickAfterScroll(staffToolsPageObjects.updatePermissions);
		return getText(staffToolsPageObjects.distributorPermissionsBulkUpdateSuccessfullMessage);
	}

}
