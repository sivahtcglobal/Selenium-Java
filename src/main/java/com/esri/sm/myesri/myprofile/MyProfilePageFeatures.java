package com.esri.sm.myesri.myprofile;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationPage;

/**
 * This is the MY Esri My Profile page class to perform actions
 * 
 * @author Rizwan
 *
 */
public class MyProfilePageFeatures extends PageObjects {

	private MyProfilePageObjects myProfilePageObjects;
	private Map<String, String> inputDataMap;
	private List<String> contactUsItemList;

	public MyProfilePageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		myProfilePageObjects = new MyProfilePageObjects(driver);
	}

	/**
	 * Retrieve the Title of the Page
	 * 
	 * @return String
	 */
	public String retrivePageTitle() {
		return getTitle();
	}

	/**
	 * Performing the click event for My Profile
	 * 
	 */
	public void clickOnMyProfileLink() {
		scrollIntoViewByElement(myProfilePageObjects.myProfileLink);
		click(myProfilePageObjects.myProfileLink);
	}

	/**
	 * Performing the click event for My Profile and retrieve the My profile
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyProfileHeaderLabel() {
		waitForPageToLoad();
		clickAfterScroll(myProfilePageObjects.myProfileLink);
		return getText(myProfilePageObjects.contactInfomationLabel);
	}

	/**
	 * Performing the click event for More Information and validate the
	 * information
	 * 
	 * 
	 * @return String
	 */
	public boolean isMoreInformationDataAvailable() {
		clickAfterScroll(myProfilePageObjects.moreInformationLink);
		boolean data;
		data = isElementAvailable(myProfilePageObjects.moreInfoPanel);
		return data;
	}

	/**
	 * Performing the click event for Profile Edit button followed by click on
	 * update and retrieve success message of update contact information
	 * 
	 * @return String
	 */
	public String retrieveUpdateContactInformationSuccesssMessage() {
		scrollIntoViewByElement(myProfilePageObjects.profileEditLink);
		click(myProfilePageObjects.profileEditLink);
		waitForPageToLoad();
		clickAfterScroll(myProfilePageObjects.profileUpdateButton);
		return getText(myProfilePageObjects.profileUpdateSuccessMessage);
	}

	/**
	 * Performing the click event for Edit Contact Information and retrieve
	 * success message of update contact information
	 * 
	 * @return String
	 */
	public String retrieveContactInformationUpdateSuccesssMessage() {
		scrollIntoViewByElement(myProfilePageObjects.profileUpdateButton);
		click(myProfilePageObjects.profileUpdateButton);
		return getText(myProfilePageObjects.profileUpdateSuccessMessage);
	}

	/**
	 * Performing the click event for Edit Contact Information and retrieve the
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveEditContactInformationHeaderLabel() {
		clickAfterScroll(myProfilePageObjects.editContactInformationLink);
		return getText(myProfilePageObjects.myProfileHeaderLabel);
	}

	/**
	 * Performing the click event for Pending Permissions Requests and retrieve
	 * the Header Label
	 * 
	 * @return String
	 */
	public String retrievePendingPermissionsRequestsHeaderLabel() {
		scrollIntoViewByElement(myProfilePageObjects.pendingPermissionsRequestsLink);
		click(myProfilePageObjects.pendingPermissionsRequestsLink);
		waitForPageToLoad();
		return getText(myProfilePageObjects.myProfileHeaderLabel);
	}

	/**
	 * Performing the click event for Request Permissions and retrieve the
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveRequestPermissionsHeaderLabel() {
		scrollIntoViewByElement(myProfilePageObjects.requestPermissionsButton);
		click(myProfilePageObjects.requestPermissionsButton);
		return getText(myProfilePageObjects.myProfileHeaderLabel);
	}

	/**
	 * Performing the click event for Edit Email Settings and retrieve the
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveEditEmailSettingsHeaderLabel() {
		scrollIntoViewByElement(myProfilePageObjects.editEmailSettingsLink);
		click(myProfilePageObjects.editEmailSettingsLink);
		waitForPageToLoad();
		return getText(myProfilePageObjects.myProfileHeaderLabel);
	}

	/**
	 * Performing the click event for Update Email Settings and retrieve the
	 * Success Message
	 * 
	 * @return String
	 */
	public String retrieveUpdateEmailSettingsHeaderLabel() {
		inputText(myProfilePageObjects.primaryEmailInputArea, inputDataMap.get(MyEsriUserPages.EMAIL_ADDRESS));
		scrollIntoViewByElement(myProfilePageObjects.profileUpdateButton);
		click(myProfilePageObjects.profileUpdateButton);
		return getText(myProfilePageObjects.profileUpdateSuccessMessage);
	}

	/**
	 * Performing the click event for Change Password and retrieve the Header
	 * Label
	 * 
	 * @return String
	 */
	public String retrieveChangePasswordHeaderLabel() {
		scrollIntoViewByElement(myProfilePageObjects.changePasswordLink);
		click(myProfilePageObjects.changePasswordLink);
		waitForPageToLoad();
		return getText(myProfilePageObjects.myProfileHeaderLabel);
	}

	/**
	 * Performing the click event for Change Security Question and retrieve the
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveChangeSecurityQuestionHeaderLabel() {
		scrollIntoViewByElement(myProfilePageObjects.changeSecurityQuestionLink);
		click(myProfilePageObjects.changeSecurityQuestionLink);
		waitForPageToLoad();
		return getText(myProfilePageObjects.myProfileHeaderLabel);
	}

	/**
	 * Performing the click event for Change Security Question button and
	 * retrieve the success message
	 * 
	 * @return String
	 */
	public String retrieveChangeSecurityQuestionSuccessMessage() {
		scrollIntoViewByElement(myProfilePageObjects.securityQuestionDropDown);
		click(myProfilePageObjects.securityQuestionDropDown);
		scrollIntoViewByElement(myProfilePageObjects.bornCityDropDownItem);
		click(myProfilePageObjects.bornCityDropDownItem);
		inputText(myProfilePageObjects.securityAnswerInputArea,
				inputDataMap.get(MyEsriUserPages.SECURITY_QUESTION_ANSWER));
		scrollIntoViewByElement(myProfilePageObjects.changeSecurityQuestionButton);
		click(myProfilePageObjects.changeSecurityQuestionButton);
		return getText(myProfilePageObjects.profileUpdateSuccessMessage);
	}

	/**
	 * Performing the click event for Edit Language Settings and retrieve the
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveEditLanguageSettingsHeaderLabel() {
		scrollIntoViewByElement(myProfilePageObjects.editLanguageSettingLink);
		click(myProfilePageObjects.editLanguageSettingLink);
		waitForPageToLoad();
		return getText(myProfilePageObjects.myProfileHeaderLabel);
	}

	/**
	 * Performing the click event for Connect to Your Organization and retrieve
	 * the Header Label
	 * 
	 * @return String
	 */
	public String retrieveConnectToYourOrganizationHeaderLabel() {
		scrollIntoViewByElement(myProfilePageObjects.connectToYourOrganizationLink);
		click(myProfilePageObjects.connectToYourOrganizationLink);
		waitForPageToLoad();
		return getText(myProfilePageObjects.myProfileHeaderLabel);
	}

	/**
	 * Performing the click event for Connect with a Token and retrieve the
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveConnectWithATokenHeaderLabel() {
		scrollIntoViewByElement(myProfilePageObjects.connectWithATokenButton);
		click(myProfilePageObjects.connectWithATokenButton);
		waitForPageToLoad();
		return getText(myProfilePageObjects.connectToYourOrganizationWithATokenHeaderLabel);
	}

	/**
	 * Performing the click event for RequestPermissions and retrieve the Header
	 * Label
	 * 
	 * @return String
	 */
	public String retrieveRequestPermissionsLabel() {
		waitForPageToLoad();
		scrollIntoViewByElement(myProfilePageObjects.requestPermissionsLink);
		click(myProfilePageObjects.requestPermissionsLink);
		return getText(myProfilePageObjects.myProfileHeaderLabel);
	}

	/**
	 * Performing the click event for Permission Send Request and retrieve the
	 * success Message
	 * 
	 * @return String
	 */
	public String retrieveRequestPermissionsSendRequestSuccessMessage() {
		inputText(myProfilePageObjects.organizationNameInputArea, inputDataMap.get(MyEsriUserPages.ORGANIZATION_NAME));
		inputText(myProfilePageObjects.whatPermissionsDoYouNeedInputArea,
				inputDataMap.get(MyEsriUserPages.PERMISSION_TYPE));
		scrollIntoViewByElement(myProfilePageObjects.sendRequestButton);
		click(myProfilePageObjects.sendRequestButton);
		return getText(myProfilePageObjects.sendRequestSuccessMessage);
	}

	/**
	 * Performing the click event for Esri Trials and Student Accounts and
	 * retrieve the Header Label
	 * 
	 * @return String
	 */
	public String retrieveEsriTrialsAndStudentAccountsHeaderLabel() {
		scrollIntoViewByElement(myProfilePageObjects.connectToYourOrganizationActiveLink);
		click(myProfilePageObjects.connectToYourOrganizationActiveLink);
		scrollIntoViewByElement(myProfilePageObjects.trialsAndStudentAccountsButton);
		click(myProfilePageObjects.trialsAndStudentAccountsButton);
		return getText(myProfilePageObjects.trialsAndStudentAccountsHeaderLabel);
	}

	/**
	 * Performing the click event for Disconnect from Your Organization and
	 * retrieve the Header Label
	 * 
	 * @return String
	 */
	public String retrieveDisconnectFromYourOrganizationHeaderLabel() {
		scrollIntoViewByElement(myProfilePageObjects.disconnectFromYourOrganizationLink);
		click(myProfilePageObjects.disconnectFromYourOrganizationLink);
		waitForPageToLoad();
		return getText(myProfilePageObjects.myProfileHeaderLabel);
	}

	/**
	 * Performing the click event for Feedback and retrieve the Contact Us item
	 * 
	 * @return String
	 */
	public String retrieveFeedbackItem() {
		scrollIntoViewByElement(myProfilePageObjects.feedbackOnThisPageLink);
		click(myProfilePageObjects.feedbackOnThisPageLink);
		contactUsItemList = getSelectedValues(myProfilePageObjects.contactUsItemList);
		Log.info("Selected Items are : " + contactUsItemList.get(0));
		return contactUsItemList.get(0);
	}

	/**
	 * Performing the click event for Feedback close icon
	 * 
	 */
	public void clickOnFeedbackCloseIcon() {
		scrollIntoViewByElement(myProfilePageObjects.feedbackCloseIcon);
		click(myProfilePageObjects.feedbackCloseIcon);
	}

	/**
	 * This method performs click event for Apply filters by selecting Customer
	 * Name 
	 * 
	 * @return string
	 * 
	 */
	public String retrieveTheOverviewAfterSelectTheOrganization() {
		scrollIntoViewByElement(myProfilePageObjects.filterByLink);
		click(myProfilePageObjects.filterByLink);
		scrollIntoViewByElement(myProfilePageObjects.filterDropDownItemCustomerNumber);
		click(myProfilePageObjects.filterDropDownItemCustomerNumber);
		inputText(myProfilePageObjects.enterFilterInputArea,
				inputDataMap.get(MyOrganizationPage.ORGANIZARION_NUMBER));
		scrollIntoViewByElement(myProfilePageObjects.filterApplyLink);
		click(myProfilePageObjects.filterApplyLink);
		return getText(myProfilePageObjects.overViewHeaderLabel);
	}
	
}
