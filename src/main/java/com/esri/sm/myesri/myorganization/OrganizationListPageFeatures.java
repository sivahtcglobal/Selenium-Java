package com.esri.sm.myesri.myorganization;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationPage;

/**
 * This is the MY Esri site My Organizations - Organization List page class to
 * perform actions
 * 
 * @author Rizwan
 *
 */
public class OrganizationListPageFeatures extends PageObjects {

	private OrganizationListPageObjects organizationListPageObjects;
	private Map<String, String> inputDataMap;

	public OrganizationListPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		organizationListPageObjects = new OrganizationListPageObjects(driver);
	}

	/**
	 * This method performs click event for My Organization and retrieve My
	 * Organizations Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationHeaderLabel() {
		clickAfterScroll(organizationListPageObjects.myOrganizationsLink);
		return getText(organizationListPageObjects.myOrganizationCommonHeaderLabel);
	}

	/**
	 * This method returns true if user contains Organization List
	 * 
	 * @return boolean
	 */
	public boolean isOrganizationListTabAvailable() {
		return isElementAvailable(organizationListPageObjects.organizationListLink);
	}

	/**
	 * This method performs click event for Organization List and retrieve
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationsHeaderLabel() {
		scrollIntoViewByElement(organizationListPageObjects.organizationListLink);
		click(organizationListPageObjects.organizationListLink);
		return getText(organizationListPageObjects.myOrganizationHeaderLabel);
	}
		
	/**
	 * This method performs click event for Apply filters by selecting Filter
	 * Name and retrieve results count
	 * 
	 * @return boolean
	 * 
	 */
	public boolean isOrganizationFilterResultsAreAvailable() {
		boolean filterResults = false;
		scrollIntoViewByElement(organizationListPageObjects.filterByLink);
		click(organizationListPageObjects.filterByLink);
		scrollIntoViewByElement(organizationListPageObjects.filterDropDownItemName);
		click(organizationListPageObjects.filterDropDownItemName);
		inputText(organizationListPageObjects.enterFilterInputArea,
				inputDataMap.get(MyOrganizationPage.ORGANIZATION_NEW_NAME));
		clickAfterScroll(organizationListPageObjects.filterApplyLink);
		getText(organizationListPageObjects.esriLabel);
		if (getSize(organizationListPageObjects.filterResultsCount) > 0) {
			filterResults = true;
		} else {
			Log.info("Organization List Filter Results are not available");
		}
		return filterResults;
	}

	/**
	 * This method performs click event for Select Organization and retrieve the
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationHeaderLabelViaSelect() {
		clickAfterScroll(organizationListPageObjects.selectOrganizationButton);
		return getText(organizationListPageObjects.myOrganizationCommonHeaderLabel);
	}

	/**
	 * This method performs click event for Expand All My Organizations button
	 * and retrieve the Permissions count
	 * 
	 * @return boolean
	 */
	public boolean isExpandAllResultsAreAvailable() {
		boolean expandResults = false;
		clickAfterScroll(organizationListPageObjects.expandCollapseAllLink);
		if (isElementAvailable(organizationListPageObjects.expandAllResults)) {
			expandResults = true;
		} else {
			Log.info("Expand All Results are not available");
		}
		return expandResults;
	}

	/**
	 * This method performs click event for select Button and retrieve the My
	 * Organization header Label
	 * 
	 * @return String
	 */
	public String retrieveSelectMyOrganizationHeaderLabel() {
		if(isElementAvailable(organizationListPageObjects.organizationButton)) {
			clickAfterScroll(organizationListPageObjects.organizationButton);
		} else {
		clickAfterScroll(organizationListPageObjects.selectOrgButton);
		}
		return getText(organizationListPageObjects.myOrganizationCommonHeaderLabel);
	}

}
