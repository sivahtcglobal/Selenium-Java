package com.esri.sm.myesri.myorganization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationDownloads;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationReports;

/**
 * This is the MY Esri site My Organizations - Licensing page class to perform
 * actions
 * 
 * @author Rizwan
 *
 */
public class LicensingPageFeatures extends PageObjects {

	private LicensingPageObjects licensingPageObjects;
	private Map<String, String> inputDataMap;

	public LicensingPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		licensingPageObjects = new LicensingPageObjects(driver);
	}

	public List<String> myOrganizationSubTabs() {
		List<String> subLinkNames = new ArrayList<String>();
		for (int i = 0; i < licensingPageObjects.myEsriSubLinks.size(); i++) {
			subLinkNames.add(licensingPageObjects.myEsriSubLinks.get(i).getText());
		}
		return subLinkNames;
	}

	public List<String> licensingSubTabs() {
		List<String> licensingSubLinkNames = new ArrayList<String>();
		for (int i = 0; i < licensingPageObjects.licensingSubLinks.size(); i++) {
			licensingSubLinkNames.add(licensingPageObjects.licensingSubLinks.get(i).getText());
		}
		return licensingSubLinkNames;
	}

	/**
	 * This method performs click event for My Organization and retrieve My
	 * Organizations Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationHeaderLabel() {
		waitForPageToLoad();
		click(licensingPageObjects.myOrganizationsLink);
		return getText(licensingPageObjects.myOrganizationCommonHeaderLabel);
	}

	/**
	 * This method returns true if user contains Licensing sub tab
	 * 
	 * @return boolean
	 */
	public boolean isLicensingTabAvailable() {
		return isElementAvailable(licensingPageObjects.licensingLink);
	}

	/**
	 * This method performs click event for Licensing Link and retrieve Header
	 * Label
	 * 
	 * @return String
	 */
	public String retrieveLicensingOverviewHeaderLabel() {
		click(licensingPageObjects.cutomerIDDropDown);
		waitForPageToLoad();
		click(licensingPageObjects.licensingLink);
		isElementAvailable(licensingPageObjects.myOrganizationHeaderLabel, Integer.toString(4));
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * Click on Licensing Overview links and Returns the Title of the Licensing
	 * Overview Links.
	 * 
	 * @param licensingOverviewElements
	 *            list of webElement
	 * @param linkIndex
	 *            link name index
	 * 
	 */
	public Map<String, String> retrieveLicensingOverviewLinksHeaderLabel(List<WebElement> licensingOverviewElements,
			int linkIndex) {
		Map<String, String> mapLinks = new HashMap<>();
		String linkLabelName = null;
		WebElement element = licensingOverviewElements.get(linkIndex);
		int sequence = linkIndex + 1;
		linkLabelName = MyOrganizationDownloads.LICENSING_OVERVIEW_TITLE + sequence;
		click(element);
		waitForPageToLoad();
		String headerLabel = getText(licensingPageObjects.myOrganizationHeaderLabel);
		mapLinks.put(linkLabelName, headerLabel);
		click(licensingPageObjects.licensingOverviewLink);
		return mapLinks;
	}

	/**
	 * This method retrieve the Licensing Overview Labels Header Label
	 * 
	 * 
	 * @return List<WebElement>
	 */
	public List<WebElement> retrieveLicensingOverviewWebElements() {
		return licensingPageObjects.licensingOverviewLinks;
	}

	/**
	 * This method returns Licensing Overview count
	 * 
	 * @return int
	 */
	public int retrieveLicensingOverviewLabelsCount() {
		return getSize(licensingPageObjects.licensingOverviewLinks);
	}

	/**
	 * This method performs click event for View License Term Summary and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveViewLicenseTermSummaryHeaderLabel() {
		click(licensingPageObjects.viewLicenseTermSummaryLeftLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for View License Term Summary Reports
	 * and validate reports availability
	 * 
	 * @return boolean
	 */
	public boolean isViewLicenseTermSummaryReportsAvailable() {
		boolean reportsData = false;
		click(licensingPageObjects.viewLicenseTermSummaryReportsLink);
		waitForPageToLoad(45);
		getText(licensingPageObjects.exitReport);
		if (getSize(licensingPageObjects.reportsCount) > 0) {
			reportsData = true;
			Log.info("Its inside");
		} else {
			Log.error("Reports data is not available");
		}
		return reportsData;
	}

	/**
	 * This method performs click event for Exit Reports
	 * 
	 */
	public void clickOnExitReports() {
		waitForPageToLoad();
		click(licensingPageObjects.exitReport);
	}

	/**
	 * This method performs click event for Expand All and validate content
	 * availability
	 * 
	 * @return boolean
	 */
	public boolean isExpandAllSuccessfull() {
		boolean expandData = false;
		click(licensingPageObjects.expandAllLink);
		if (isElementAvailable(licensingPageObjects.termStandardLinkAfterExpand)) {
			expandData = true;
		} else {
			Log.error("Reports data is not available");
		}
		return expandData;
	}

	/**
	 * This method performs click event for Expand All and validate content
	 * availability
	 * 
	 * @return boolean
	 */
	public boolean isSearchResultsAvailable() {
		boolean searchData = false;
		if(inputDataMap.get(MyOrganizationDownloads.USERNAME).contains("EsriTestAutomation4")) {
			inputText(licensingPageObjects.quickSearchInputArea, "ESRI");
		} else {
		inputText(licensingPageObjects.quickSearchInputArea, inputDataMap.get(MyOrganizationDownloads.SEARCH_TEXT));
		}
		if (getSize(licensingPageObjects.searchResultsCount) > 0) {
			searchData = true;
		} else {
			Log.error("Search results are not available");
		}
		return searchData;
	}

	/**
	 * This method performs click event for View Authorizations and retrieve
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveViewAuthorizationsHeaderLabel() {
		click(licensingPageObjects.viewAuthorizationsLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for View Authorizations First Item
	 * Details and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveAuthorizationHeaderLabel() {
		click(licensingPageObjects.viewAuthorizationsFirstItem);
		return getText(licensingPageObjects.authorizationHeaderLabel);
	}

	/**
	 * This method performs click event for Expand All and validate content
	 * availability
	 * 
	 * @return boolean
	 */
	public boolean isProvisioningAuthorizationsDataAvailable() {
		boolean provisionData = false;
		click(licensingPageObjects.provisioningAndAuthorizationsLink);
		waitForPageToLoad();
		if (getSize(licensingPageObjects.provisioningAndAuthorizationsDataCount) > 0) {
			provisionData = true;
		} else {
			Log.error("Provisioning and Authorizations data is not available");
		}
		return provisionData;
	}

	/**
	 * This method performs click event for Back to Authorizations
	 * 
	 */
	public void clickOnBacktoAuthorizations() {
		click(licensingPageObjects.backToAuthorizations);
	}

	/**
	 * This method performs click event for Create New Provisioning File and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveCreateNewProvisioningFileHeaderLabel() {
		click(licensingPageObjects.createNewProvisioningFileLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Yes, leave the form and discard my
	 * changes button
	 * 
	 */
	public void clickOnDiscardMyChangesButton() {
		click(licensingPageObjects.createNewProvisioningFileLinkAfterClick);
	}

	/**
	 * This method performs click event for Select Provisioning Options followed
	 * by providing inputs for fields and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveSelectProductsHeaderLabel() {
		waitForPageToLoad();
		clickAfterScroll(licensingPageObjects.productTypeDropDown);
		clickAfterScroll(licensingPageObjects.dropDownItemArcGISDesktop);
		clickAfterScroll(licensingPageObjects.versionDropDown);
		if (inputDataMap.get(MyEsriUserPages.USERNAME).contains("EsriTestAutomation0")) {
			clickAfterScroll(licensingPageObjects.versionDropDownSecondItem);
		} else {
			clickAfterScroll(licensingPageObjects.versionDropDownFirstItem);
		}
		if (inputDataMap.get(MyEsriUserPages.USERNAME).contains("EsriTestAutomation2")) {
		Log.info("User no need to select License type");
		} else {
		clickAfterScroll(licensingPageObjects.licenseTypeDropDown);
		clickAfterScroll(licensingPageObjects.licenseTypeSingleUselabel);
		}
		clickAfterScroll(licensingPageObjects.provisionSecondRadioButton);
		clickAfterScroll(licensingPageObjects.selectProvisioningOptionsNextButton);
		return getText(licensingPageObjects.selectProductsHeaderLabel);
	}

	/**
	 * This method performs click event for Next buttons of step 2, 3, 4, 5 of
	 * followed by providing inputs for fields and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveReviewProvisioningFileHeaderLabel() {
		if (inputDataMap.get(MyEsriUserPages.USERNAME).contains("EsriTestAutomation0")) {
			click(licensingPageObjects.selectProductThirdCheckBox);
		} else {
			click(licensingPageObjects.selectProductFirstCheckBox);
		}
		clickAfterScroll(licensingPageObjects.selectProvisioningOptionsNextButton);
		clickAfterScroll(licensingPageObjects.populateUserFieldsFromMyProfile);
		scrollIntoViewByElement(licensingPageObjects.populateOrganizationFieldsFromMyOrganizations);
		click(licensingPageObjects.populateOrganizationFieldsFromMyOrganizations);
		scrollIntoViewByElement(licensingPageObjects.selectProvisioningOptionsNextButton);
		click(licensingPageObjects.selectProvisioningOptionsNextButton);
		click(licensingPageObjects.downloadRadioButton);
		scrollIntoViewByElement(licensingPageObjects.selectProvisioningOptionsNextButton);
		click(licensingPageObjects.selectProvisioningOptionsNextButton);
		click(licensingPageObjects.createFileButton);
		return getText(licensingPageObjects.createFileSuccessMessage);
	}

	/**
	 * This method performs click event for Manage Existing Provisioning Files
	 * and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveManageExistingProvisioningFilesHeaderLabel() {
		click(licensingPageObjects.manageExistingProvisioningFilesLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs search event and validate content availability
	 * 
	 * @return boolean
	 */
	public boolean isSearchResultsAvailableForProvising() {
		boolean searchData = false;
		inputText(licensingPageObjects.quickSearchInputArea,
				inputDataMap.get(MyOrganizationDownloads.SEARCH_TEXT_PROVISIONING));
		if (getSize(licensingPageObjects.provisioningSearchResultsCount) > 0) {
			searchData = true;
		} else {
			Log.error("Provising Search results are not available");
		}
		return searchData;
	}
	
	/**
	 * This method performs click event for Manage Existing Provisioning Files
	 * and retrieve Header Label
	 * 
	 * @return boolean
	 */
	public boolean isSearchResultsAvailableofProvising() {
		return isElementAvailable(licensingPageObjects.provisioningSearchResults);
	}

	/**
	 * This method performs click event for Manage Existing Provisioning Files
	 * and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveConvertArcGISProNamedUserLicensesHeaderLabel() {
		clickAfterScroll(licensingPageObjects.convertArcGISProNamedUserLicensesLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs search event and validate content availability
	 * 
	 * @return boolean
	 */
	public boolean isSearchResultsAvailableForConvertArcGISProNamedUserLicenses() {
		boolean searchData = false;
		inputText(licensingPageObjects.quickSearchInputArea, inputDataMap.get(MyOrganizationDownloads.SEARCH_TEXT));
		if (getSize(licensingPageObjects.licenseCount) > 0) {
			searchData = true;
		} else {
			Log.error("Convert ArcGIS Pro Named User Licenses Search results are not available");
		}
		return searchData;
	}

	/**
	 * This method performs click event for Manage Existing Provisioning Files
	 * and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveConvertLicensesHeaderLabel() {
		if (inputDataMap.get(MyOrganizationDownloads.USERNAME).contains("EsriTestAutomation0")) {
			isElementAvailable(licensingPageObjects.convertButtonPro, Integer.toString(10));
			clickAfterScroll(licensingPageObjects.convertButtonPro);
		} else {
			waitForPageToLoad();
			click(licensingPageObjects.convertButton);
		}
		waitForPageToLoad();
		return getText(licensingPageObjects.convertLicensesHeaderLabel);
	}

	/**
	 * This method performs click event for Convert Licenses Next Button and
	 * retrieve Review Header Label
	 * 
	 * @return String
	 */
	public String retrieveReviewHeaderLabel() {
		clickAfterScroll(licensingPageObjects.increaseLicenseQuantityButton);
		clickAfterScroll(licensingPageObjects.convertLicensesNextButton);
		return getText(licensingPageObjects.reviewHeaderLabel);
	}

	/**
	 * This method performs click event for Generate Portal for ArcGIS Licenses
	 * and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveGeneratePortalForArcGISLicensesHeaderLabel() {
		clickAfterScroll(licensingPageObjects.generatePortalForArcGISLicensesFileLink);
		/*if(inputDataMap.get(MyOrganizationDownloads.USERNAME).contains("EsriTestAutomation1")) {
			clickAfterScroll(licensingPageObjects.yesPopup);
		}  else {
		Log.info("User doesn't need to click on Yes Levae from this page pop up");
		}*/
		if (inputDataMap.get(MyOrganizationReports.YES_NOTE_LABEL).contains("Yes")) {
			Log.info(
					"User doesn't need to click on yes Leave The Form And Discard MyChanges Link Your Authorizatio link");
		} else {
			click(licensingPageObjects.yesLeaveTheFormAndDiscardMyChangesLink);
		}
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Manage Developer Subscriptions and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveManageDeveloperSubscriptionsHeaderLabel() {
		clickAfterScroll(licensingPageObjects.manageDeveloperSubscriptionsLink);
		return getText(licensingPageObjects.manageDeveloperSubscriptionsHeaderLabel);
	}

	/**
	 * This method performs click event for Manage Developer Subscriptions and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveSendDeveloperSubscriptionCodeRequestSuccessMessage() {
		clickAfterScroll(licensingPageObjects.sendDeveloperSubscriptionCodeFirstButton);
		inputText(licensingPageObjects.emailAddressInputArea, inputDataMap.get(MyOrganizationDownloads.EMAIL_ADDRESS));
		inputText(licensingPageObjects.firstNameInputArea, inputDataMap.get(MyOrganizationDownloads.USERNAME));
		inputText(licensingPageObjects.lastNameInputArea, inputDataMap.get(MyOrganizationDownloads.USERNAME));
		clickAfterScroll(licensingPageObjects.sendDeveloperSubscriptionCodeSendButton);
		return getText(licensingPageObjects.sendDeveloperSubscriptionCodeSentSuccessMessageText);
	}

	/**
	 * This method performs click event for Subscription Users and retrieve
	 * Manage Users Header Label
	 * 
	 * @return String
	 */
	public String retrieveManageUsersHeaderLabel() {
		clickAfterScroll(licensingPageObjects.subscriptionUsersLink);
		return getText(licensingPageObjects.manageUsersLabel);
	}

	/**
	 * This method performs click event for Recover Lost Licenses and retrieve
	 * Manage Users Header Label
	 * 
	 * @return String
	 */
	public String retrieveRecoverLostLicensesHeaderLabel() {
		clickAfterScroll(licensingPageObjects.recoverLostLicensesLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Online Deauthorization ArcGIS
	 * Desktop And ArcGIS Engine Link and retrieve page title Label
	 * 
	 * @return String
	 */
	public String retrieveOnlineSupportTitleLabel() {
		clickAfterScroll(licensingPageObjects.onlineDeauthorizationArcGISDesktopAndArcGISEngineLink);
		switchToChildWindow(1);
		String onlineTitle = getTitle();
		switchToParentWindow(0);
		return onlineTitle;
	}

	/**
	 * This method performs click event for Offline Deauthorization ArcGIS
	 * Desktop And ArcGIS Engine Link and retrieve page title Label
	 * 
	 * @return String
	 */
	public String retrieveOfflineSupportTitleLabel() {
		clickAfterScroll(licensingPageObjects.offlineDeauthorizationArcGISDesktopAndArcGISEngineLink);
		switchToChildWindow(1);
		String offlineTitle1 = getTitle();
		switchToParentWindow(0);
		return offlineTitle1;
	}

	/**
	 * This method performs click event for Find Your Machine and filled further
	 * forms and retrieve Recover Lost Licenses Success Message
	 * 
	 * 
	 * @return String
	 */
	public String retrieveRecoverLostLicensesRequestSuccessMessageLabel() {
		clickAfterScroll(licensingPageObjects.findYourMachineFirstRadioButton);
		clickAfterScroll(licensingPageObjects.findYourMachineNextButton);
		clickAfterScroll(licensingPageObjects.coreProductNameDropDown);
		clickAfterScroll(licensingPageObjects.arcGISDesktopAdvancedDropDownItem);
		clickAfterScroll(licensingPageObjects.recoverLicenseTypeDropDown);
		clickAfterScroll(licensingPageObjects.recoverLicenseTypeDropDownSecondItem);
		clickAfterScroll(licensingPageObjects.searchForMachineByProductSearchButton);
		clickAfterScroll(licensingPageObjects.searchResultsFirstSelectButton);
		clickAfterScroll(licensingPageObjects.reviewSelectedMachineNextButton);
		clickAfterScroll(licensingPageObjects.acceptTermsAndConditionsCheckBox);
		clickAfterScroll(licensingPageObjects.reviewSelectedMachineNextButton);
		clickAfterScroll(licensingPageObjects.processReturnButton);
		return getText(licensingPageObjects.recoverLostLicensesSuccessMessageText);
	}

	/**
	 * This method performs click event for Additional Licensing Forms and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveAdditionalLicensingFormsHeaderLabel() {
		clickAfterScroll(licensingPageObjects.additionalLicensingFormsLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Developer Subscription Registration
	 * and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveDeveloperSubscriptionRegistrationHeaderLabel() {
		clickAfterScroll(licensingPageObjects.developerSubscriptionRegistrationLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for ArcSDE 10 & ArcIMS 10 Authorizations
	 * and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveArcSDE10ArcIMS10AuthorizationsHeaderLabel() {
		clickAfterScroll(licensingPageObjects.additionalLicensingFormsLink);
		clickAfterScroll(licensingPageObjects.ArcSDE10ArcIMS10AuthorizationsLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for ArcSDE 10 & ArcIMS 10 Authorizations
	 * and retrieve your Authorization Header Label
	 * 
	 * @return String
	 */
	public String retrieveYourAuthorizationHeaderLabel() {
		clickAfterScroll(licensingPageObjects.populateUserFieldsFromMyProfile);
		scrollIntoViewByElement(licensingPageObjects.populateOrganizationFieldsFromMyOrganizations);
		click(licensingPageObjects.populateOrganizationFieldsFromMyOrganizations);
		scrollIntoViewByElement(licensingPageObjects.selectProvisioningOptionsNextButton);
		click(licensingPageObjects.selectProvisioningOptionsNextButton);
		return getText(licensingPageObjects.yourAuthorizationHeaderLabel);
	}

	/**
	 * This method performs click event for Single Use Product Registration and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveSingleUseProductRegistrationHeaderLabel() {
		clickAfterScroll(licensingPageObjects.additionalLicensingFormsLink);
		clickAfterScroll(licensingPageObjects.singleUseProductRegistrationLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Single Use Product Registration and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveSingleUseProductRegistrationHeader() {
		clickAfterScroll(licensingPageObjects.additionalLicensingFormsLink);
		clickAfterScroll(licensingPageObjects.singleUseProductRegistrationLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Single Use Product Registration and
	 * retrieve Product Registration Header Label
	 * 
	 * @return String
	 */
	public String retrieveProductRegistrationHeaderLabel() {
		clickAfterScroll(licensingPageObjects.populateUserFieldsFromMyProfile);
		clickAfterScroll(licensingPageObjects.populateOrganizationFieldsFromMyOrganizations);
		clickAfterScroll(licensingPageObjects.contactInformationNextButton);
		clickAfterScroll(licensingPageObjects.contactInformationNextButton);
		return getText(licensingPageObjects.yourAuthorizationHeaderLabel);
	}

	/**
	 * This method performs click event for Single Use Product Registration and
	 * retrieve Product Registration Header Label
	 * 
	 * @return String
	 */
	public String retrieveReasonForLicenseRequestHeaderLabel() {
		scrollIntoViewByElement(licensingPageObjects.populateUserFieldsFromMyProfile);
		click(licensingPageObjects.populateUserFieldsFromMyProfile);
		clickAfterScroll(licensingPageObjects.populateOrganizationFieldsFromMyOrganizations);
		scrollIntoViewByElement(licensingPageObjects.contactInformationNextButton);
		click(licensingPageObjects.contactInformationNextButton);
		return getText(licensingPageObjects.yourAuthorizationHeaderLabel);
	}

	/**
	 * This method performs click event for License File Request and retrieve
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveLicenseFileRequestHeaderLabel() {
		clickAfterScroll(licensingPageObjects.additionalLicensingFormsLink);
		click(licensingPageObjects.licenseFileRequestLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Secure Site Operations and retrieve
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveSecureSiteOperationsHeaderLabel() {
		scrollIntoViewByElement(licensingPageObjects.additionalLicensingFormsLink);
		click(licensingPageObjects.additionalLicensingFormsLink);
		click(licensingPageObjects.secureSiteOperationsLink);
		return getText(licensingPageObjects.myOrganizationHeaderLabel);
	}

}
