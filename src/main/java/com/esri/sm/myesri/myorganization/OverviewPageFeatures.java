package com.esri.sm.myesri.myorganization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationPage;

/**
 * This is the MY Esri My Organizations Overview page class to perform actions
 * 
 * @author Rizwan
 *
 */
public class OverviewPageFeatures extends PageObjects {

	private OverviewPageObjects overviewPageObjects;
	private Map<String, String> inputDataMap;

	public OverviewPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		overviewPageObjects = new OverviewPageObjects(driver);
	}

	public List<String> myOrganizationSubTabs() {
		List<String> subLinkNames = new ArrayList<String>();
		click(overviewPageObjects.licensingLink);
		waitForPageToLoad();
		for (int i = 0; i < overviewPageObjects.myEsriSubLinks.size(); i++) {
			subLinkNames.add(overviewPageObjects.myEsriSubLinks.get(i).getText());
		}
		return subLinkNames;
	}

	public List<String> overviewSubTabs() {
		List<String> overviewSubLinkNames = new ArrayList<String>();
		for (int i = 0; i < overviewPageObjects.overviewSubLinks.size(); i++) {
			overviewSubLinkNames.add(overviewPageObjects.overviewSubLinks.get(i).getText());
		}
		return overviewSubLinkNames;
	}

	/**
	 * This method performs click event for My Organization and retrieve My
	 * Organizations Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationHeaderLabel() {
		waitForPageToLoad();
		scrollIntoViewByElement(overviewPageObjects.myOrganizationsLink);
		click(overviewPageObjects.myOrganizationsLink);
		return getText(overviewPageObjects.myOrganizationCommonHeaderLabel);
	}

	/**
	 * This method performs click event for Overview
	 * 
	 */
	public void clickOnOverview() {
		waitForPageToLoad();
		clickAfterScroll(overviewPageObjects.overviewLink);
	}

	/**
	 * This method performs click event for Edit and retrieve Organization
	 * Details Header Label
	 * 
	 * @return String
	 */
	public String retrieveEditOrganizationDetailsHeaderLabelViaProfile() {
		clickAfterScroll(overviewPageObjects.organizationDetailsEditLink);
		waitForPageToLoad();
		getText(overviewPageObjects.myOrganizationHeaderLabel);
		return getText(overviewPageObjects.myOrganizationHeaderLabel);
	}
	
	/**
	 * This method return true if Organization Details web element is available
	 * 
	 */
	public boolean isOrganizationDetailsEditButtonisAvailable() {
		waitForPageToLoad();
		return isElementAvailable(overviewPageObjects.organizationDetailsEditLink);
	}

	/**
	 * This method return true if Organization Contacts web element is available
	 * 
	 */
	public boolean isContactEditButtonisAvailable() {
		waitForPageToLoad();
		return isElementAvailable(overviewPageObjects.organizationContactEditLink);
	}
	
	/**
	 * This method performs click event for Organization Contacts and retrieve
	 * Edit Maintenance Contact Header Label
	 * 
	 * @return String
	 */
	public String retrieveEditMaintenanceContactHeaderLabelViaProfile() {
		clickAfterScroll(overviewPageObjects.organizationProfileLink);
		clickAfterScroll(overviewPageObjects.organizationContactEditLink);
		return getText(overviewPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Edit Organization Details and
	 * retrieve the Header Label
	 * 
	 * @return String
	 */
	public String retrieveEditOrganizationDetailsHeaderLabel() {
		scrollIntoViewByElement(overviewPageObjects.editOrganizationDetailsLink);
		click(overviewPageObjects.editOrganizationDetailsLink);
		return getText(overviewPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for update Organization Details button
	 * and retrieve the success message Label
	 * 
	 * @return String
	 */
	public String retrieveUpdateOrganizationDetailsSuccessMessage() {
		String random = null;
		String randomNumber = null;
	    Random rnum = new Random();
	    random = Integer.toString(rnum.nextInt(2000000));
	    randomNumber = random + inputDataMap.get(MyOrganizationPage.STREET_ADDRESS);
		inputText(overviewPageObjects.address1InputArea, randomNumber);
		scrollIntoViewByElement(overviewPageObjects.updateOrganizationDetailsButton);
		click(overviewPageObjects.updateOrganizationDetailsButton);
		return getText(overviewPageObjects.editOrganizationNameSuccessMessage);
	}

	/**
	 * This method performs click event for Edit Organization Name and retrieve
	 * the header Label
	 * 
	 * @return String
	 */
	public String retrieveEditOrganizationNameHeaderLabel() {
		scrollIntoViewByElement(overviewPageObjects.editOrganizationNameLink);
		click(overviewPageObjects.editOrganizationNameLink);
		return getText(overviewPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method enter the New Name, select the required radio button options
	 * to rename the Organization and retrieve the request success message
	 * 
	 * 
	 * @return String
	 */
	public String retrieveEditOrganizationNameSuccessMessage() {
		inputText(overviewPageObjects.organizationNewNameInputArea,
				inputDataMap.get(MyOrganizationPage.ORGANIZATION_NEW_NAME));
		scrollIntoViewByElement(overviewPageObjects.noneCheckBox);
		click(overviewPageObjects.noneCheckBox);
		scrollIntoViewByElement(overviewPageObjects.dataEntryCorrectionCheckBox);
		click(overviewPageObjects.dataEntryCorrectionCheckBox);
		scrollIntoViewByElement(overviewPageObjects.doesPriorOrganizationStillExistRadioButton);
		click(overviewPageObjects.doesPriorOrganizationStillExistRadioButton);
		scrollIntoViewByElement(overviewPageObjects.isPriorOrganizationKeepingAnySoftwareLicensesRadioButton);
		click(overviewPageObjects.isPriorOrganizationKeepingAnySoftwareLicensesRadioButton);
		scrollIntoViewByElement(overviewPageObjects.DoesTransferorHaveARequestFormForEsriToSignRadioButton);
		click(overviewPageObjects.DoesTransferorHaveARequestFormForEsriToSignRadioButton);
		scrollIntoViewByElement(overviewPageObjects.sendEditsButton);
		click(overviewPageObjects.sendEditsButton);
		return getText(overviewPageObjects.editOrganizationNameSuccessMessage);
	}

	/**
	 * This method performs click event for Edit Maintenance Contact and
	 * retrieve the header Label
	 * 
	 * @return String
	 */
	public String retrieveEditMaintenanceContactHeaderLabel() {
		scrollIntoViewByElement(overviewPageObjects.editMaintenanceContactLink);
		click(overviewPageObjects.editMaintenanceContactLink);
		return getText(overviewPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Update Contact Send Request and
	 * retrieve request success message
	 * 
	 * @return String
	 */
	public String retrieveUpdateContactSuccessMessage() {
		//inputText(overviewPageObjects.eamilAdressInputArea, inputDataMap.get(MyOrganizationPage.EMAIL_ID));
		scrollIntoViewByElement(overviewPageObjects.sendRequestButton);
		click(overviewPageObjects.sendRequestButton);
		waitForPageToLoad();
		return getText(overviewPageObjects.updateContactInformationSuccessMessage);
	}

	/**
	 * This method performs click event for Replace Contact Send Request and
	 * retrieve request success message
	 * 
	 * @return String
	 */
	public boolean retrieveReplaceContactSuccessMessage() {
		scrollIntoViewByElement(overviewPageObjects.organizationProfileLink);
		click(overviewPageObjects.organizationProfileLink);
		scrollIntoViewByElement(overviewPageObjects.editMaintenanceContactLink);
		click(overviewPageObjects.editMaintenanceContactLink);
		scrollIntoViewByElement(overviewPageObjects.replaceContactLink);
		click(overviewPageObjects.replaceContactLink);
		inputText(overviewPageObjects.replaceFirstNameInputArea,
				inputDataMap.get(MyOrganizationPage.REPLACE_CONTACT_FIRST_NAME));
		inputText(overviewPageObjects.replaceLastNameInputArea,
				inputDataMap.get(MyOrganizationPage.REPLACE_CONTACT_LAST_NAME));
		inputText(overviewPageObjects.replaceEmailInputArea,
				inputDataMap.get(MyOrganizationPage.REPLACE_CONTACT_EMAIL_ID));
		inputText(overviewPageObjects.replacePhoneInputArea,
				inputDataMap.get(MyOrganizationPage.REPLACE_CONTACT_PHONE_NUMBER));
		scrollIntoViewByElement(overviewPageObjects.whyRadioButton);
		click(overviewPageObjects.whyRadioButton);
		scrollIntoViewByElement(overviewPageObjects.sendRequestButton);
		click(overviewPageObjects.sendRequestButton);
		return isElementAvailable(overviewPageObjects.updateContactInformationSuccessMessage);
	}

	/**
	 * This method performs click event for Request Permission and retrieve the
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveRequestPermissionsHeaderLabel() {
		clickAfterScroll(overviewPageObjects.requestPermissionsLink);
		return getText(overviewPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Request Permission to Your
	 * Organization Continue Button
	 * 
	 * 
	 */
	public void clickOnRequestPermissionsToYourOrganizationContinueButton() {
		scrollIntoViewByElement(overviewPageObjects.requestPermissionsToYourOrganizationContinueButton);
		click(overviewPageObjects.requestPermissionsToYourOrganizationContinueButton);
	}

	/**
	 * This method performs click event for Additional Organization radio button
	 * 
	 */
	public void clickOnAdditionalOrganizationRadioButton() {
		scrollIntoViewByElement(overviewPageObjects.additionalOrganizationRadioButton);
		click(overviewPageObjects.additionalOrganizationRadioButton);
	}

	/**
	 * This method performs click event for Organization Profile and Request
	 * Permissions
	 * 
	 * @return String
	 */
	public String retrieveEsriTrialsAndStudentAccountsHeaderLabel() {
		scrollIntoViewByElement(overviewPageObjects.organizationProfileLink);
		click(overviewPageObjects.organizationProfileLink);
		scrollIntoViewByElement(overviewPageObjects.requestPermissionsLink);
		click(overviewPageObjects.requestPermissionsLink);
		scrollIntoViewByElement(overviewPageObjects.studentsAccountsContinueButton);
		click(overviewPageObjects.studentsAccountsContinueButton);
		return getText(overviewPageObjects.trialsAndStudentAccountsHeaderLabel);

	}

}
