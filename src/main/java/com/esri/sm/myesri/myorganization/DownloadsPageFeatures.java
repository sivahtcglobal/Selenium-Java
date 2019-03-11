package com.esri.sm.myesri.myorganization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationReports;

/**
 * This is the MY Esri site My Organizations - Training page class to perform
 * actions
 * 
 * @author Rizwan
 *
 */
public class DownloadsPageFeatures extends PageObjects {

	private DownloadsPageObjects downloadsPageObjects;

	public DownloadsPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		downloadsPageObjects = new DownloadsPageObjects(driver);
	}

	public List<String> myOrganizationSubTabs() {
		List<String> subLinkNames = new ArrayList<String>();
		for (int i = 0; i < downloadsPageObjects.myEsriSubLinks.size(); i++) {
			subLinkNames.add(downloadsPageObjects.myEsriSubLinks.get(i).getText());
		}
		return subLinkNames;
	}

	public List<String> downloadsSubTabs() {
		List<String> downloadsSubLinkNames = new ArrayList<String>();
		for (int i = 0; i < downloadsPageObjects.downloadsSubLinks.size(); i++) {
			downloadsSubLinkNames.add(downloadsPageObjects.downloadsSubLinks.get(i).getText());
		}
		return downloadsSubLinkNames;
	}

	/**
	 * This method performs click event for My Organization and retrieve My
	 * Organizations Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationHeaderLabel() {
		waitForPageToLoad();
		click(downloadsPageObjects.myOrganizationsLink);
		return getText(downloadsPageObjects.myOrganizationCommonHeaderLabel);
	}

	/**
	 * This method returns true if user contains Downloads sub tab
	 * 
	 * @return boolean
	 */
	public boolean isDownloadsTabAvailable() {
		return isElementAvailable(downloadsPageObjects.downloadsLink);
	}

	/**
	 * This method performs click event for Downloads Link and retrieve Header
	 * Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationsHeaderLabel() {
		click(downloadsPageObjects.downloadsLink);
		return getText(downloadsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for products first item downloads and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveViewDownloadFirstItemHeaderLabel() {
		click(downloadsPageObjects.viewDownloadFirstItemLink);
		return getText(downloadsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for System Requirements Link and
	 * retrieve data availability
	 * 
	 * @return boolean
	 */
	public boolean isSystemRequirementsDataisAvailable() {
		boolean data = false;
		click(downloadsPageObjects.systemRequirementsLink);
		if (getSize(downloadsPageObjects.systemRequirementsDataCount) > 0) {
			data = true;
		} else {
			Log.info("System Data is not available");
		}
		return data;
	}

	/**
	 * This method performs click event for Downloads Components Link and
	 * retrieve data availability
	 * 
	 * @return boolean
	 */
	public boolean isDownloadsComponentsDataisAvailable() {
		boolean data = false;
		click(downloadsPageObjects.systemRequirementsLink);
		if (getSize(downloadsPageObjects.downloadComponentsCount) > 0) {
			data = true;
		} else {
			Log.info("Downloads Components Data is not available");
		}
		return data;
	}

	/**
	 * This method perform click event for back to Downloads button
	 * 
	 */
	public void clickonBackToDownloads() {
		click(downloadsPageObjects.backToDownloadsLink);
	}

	/**
	 * This method performs click event for Products Components side navigation
	 * and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveProductComponentsSideNavHeaderLabel() {
		click(downloadsPageObjects.productComponentsLink);
		return getText(downloadsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Product Components Link and retrieve
	 * data availability
	 * 
	 * @return boolean
	 */
	public boolean isProductsComponentsDataisAvailable() {
		boolean searchData = false;
		inputText(downloadsPageObjects.quickSearchInputArea, MyOrganizationReports.SEARCH_TEXT_FOR_TRAINING);
		if (getSize(downloadsPageObjects.productComponentsCount) > 0) {
			searchData = true;
		} else {
			Log.info("Product Components Data is not available");
		}
		return searchData;
	}

	/**
	 * This method performs click event for Product Components sort by Link and
	 * retrieve data availability
	 * 
	 * @return boolean
	 */
	public boolean isProductsComponentsFilterResultsAreAvailable() {
		boolean searchData = false;
		click(downloadsPageObjects.sortByFilterProductsComponents);
		click(downloadsPageObjects.sortByFilterProductsComponentsProductItem);
		if (getSize(downloadsPageObjects.downloadComponentsCount) > 0) {
			searchData = true;
		} else {
			Log.info("Product Components filter data is not available");
		}
		return searchData;
	}

	/**
	 * This method performs click event for Data and Content side navigation and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveDataAndContentHeaderLabel() {
		click(downloadsPageObjects.dataAndContentLink);
		return getText(downloadsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Apps side navigation and retrieve
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveAppsHeaderLabel() {
		click(downloadsPageObjects.appsLink);
		return getText(downloadsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Database Support Files side
	 * navigation and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveDatabaseSupportFilesHeaderLabel() {
		click(downloadsPageObjects.databaseSupportFilesLink);
		return getText(downloadsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Developer Tools side navigation and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveDeveloperToolsHeaderLabel() {
		click(downloadsPageObjects.developerToolsLink);
		return getText(downloadsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Language Packs side navigation and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveLanguagePacksHeaderLabel() {
		click(downloadsPageObjects.languagePacksLink);
		return getText(downloadsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Download ISO Files side navigation
	 * and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveDownloadISOFilesHeaderLabel() {
		click(downloadsPageObjects.downloadISOFilesLink);
		return getText(downloadsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Request Media side navigation and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveRequestMediaHeaderLabel() {
		click(downloadsPageObjects.requestMediaLink);
		return getText(downloadsPageObjects.myOrganizationHeaderLabel);
	}

}
