package com.esri.sm.myesri.myorganization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;

/**
 * This is the MY Esri site My Organizations tab - Transactions page class to
 * perform actions
 * 
 * @author Rizwan
 *
 */
public class TransactionsPageFeatures extends PageObjects {

	private TransactionsPageObjects myOrganizationsPageObjects;

	public TransactionsPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		myOrganizationsPageObjects = new TransactionsPageObjects(driver);
	}

	public List<String> myOrganizationSubTabs() {
		List<String> subLinksNames = new ArrayList<String>();
		for (int i = 0; i < myOrganizationsPageObjects.myEsriSubLinks.size(); i++) {
			subLinksNames.add(myOrganizationsPageObjects.myEsriSubLinks.get(i).getText());
		}
		return subLinksNames;
	}

	public int transactionOverviewSubTabs() {
		return getSize(myOrganizationsPageObjects.transactionOverviewSubLinks);
	}
	
	/**
	 * This method performs click event for Transaction Overview elements
	 * 
	 * @return String
	 */
	public void clickOnTransactionsOverviewSubLink(int index) {
		clickAfterScroll(myOrganizationsPageObjects.transactionOverviewSubLinks.get(index));
	}
	
	/**
	 * This method performs click event for My Organization
	 * 
	 * @return String
	 */
	public void clickOnMyOrganizationHeaderLabel() {
		waitForPageToLoad(5);
		scrollIntoViewByElement(myOrganizationsPageObjects.myOrganizationsLink);
		click(myOrganizationsPageObjects.myOrganizationsLink);
	}

	/**
	 * This method performs click event for My Organization and retrieve My
	 * Organizations Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationHeaderLabel() {
		waitForPageToLoad(5);
		return getText(myOrganizationsPageObjects.myOrganizationCommonHeaderLabel);
	}

	/**
	 * This method performs click event for My Organization
	 * 
	 * @return String
	 */
	public void clickOnTransactionsLink() {
		scrollIntoViewByElement(myOrganizationsPageObjects.TransactionsLink);
		click(myOrganizationsPageObjects.TransactionsLink);
	}
	
	/**
	 * This method performs click event for My Organization
	 * 
	 * @return String
	 */
	public void clickOnTransactionOverviewLink() {
		clickAfterScroll(myOrganizationsPageObjects.TransactionOverviewLink);
	}
	
	/**
	 * This method performs click event for Transaction sub menu and retrieve
	 * Transaction Overview Header Label
	 * 
	 * @return String
	 */
	public String retrieveTransactionOverviewHeaderLabel() {
		waitForPageToLoad();
		return getText(myOrganizationsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Order History
	 * 
	 * @return String
	 */
	public void clickOnOrderHistoryHeaderLabel() {
		clickAfterScroll(myOrganizationsPageObjects.orderHistoryButton);
	}

	/**
	 * This method performs click event for Order History and retrieve the
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveOrderHistoryHeaderLabel() {
		waitForPageToLoad();
		return getText(myOrganizationsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Order History
	 * 
	 * @return String
	 */
	public void clickOnMaintenanceQuotesHeaderLabel() {
		isElementAvailable(myOrganizationsPageObjects.transactionsOverviewfromOrderHistoryLink, Integer.toString(4));
		clickAfterScroll(myOrganizationsPageObjects.transactionsOverviewfromOrderHistoryLink);
		isElementAvailable(myOrganizationsPageObjects.maintenanceQuotesButton, Integer.toString(4));
		clickAfterScroll(myOrganizationsPageObjects.maintenanceQuotesButton);
	}

	/**
	 * This method performs click event for Order History
	 * 
	 * @return String
	 */
	public String retrieveMaintenanceQuotesHeaderLabel() {
		return getText(myOrganizationsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Order History
	 * 
	 * 
	 */
	public void clickOnOrderHistoryHeaderLabelFromLeftPanel() {
		scrollIntoViewByElement(myOrganizationsPageObjects.orderHistoryLink);
		click(myOrganizationsPageObjects.orderHistoryLink);
	}

	/**
	 * Retrieve the Header Label of Order History header label
	 * 
	 * @return String
	 */
	public String retrieveOrderHistoryHeaderLabelFromLeftPanel() {
		return getText(myOrganizationsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * Performing the click event for More Information and validate the
	 * information
	 * 
	 * 
	 * @return String
	 */
	public String isMoreInformationDataAvailable() {
		click(myOrganizationsPageObjects.moreInformationLink);
		return getText(myOrganizationsPageObjects.moreInformationLink);
	}
	
	/**
	 * Performing the click event for More Information and validate the
	 * information
	 * 
	 * 
	 * @return String
	 */
	public String isMoreInformationDataAvailableForTV() {
		click(myOrganizationsPageObjects.moreInfoPanelHeaderText);
		return getText(myOrganizationsPageObjects.moreInfoPanelHeaderText);
	}

	/**
	 * Click on cookies popup
	 */
	public void clickOnCookiesPopup() {
		waitForPageToLoad();
		if (isElementAvailable(myOrganizationsPageObjects.acceptCookiesButton)) {
			click(myOrganizationsPageObjects.acceptCookiesButton);
		} else {
			Log.info("Accept Cookies popup is not available");
		}
	}

	/**
	 * Performing the click event for Maintenance Quotes More Information and
	 * validate the information
	 * 
	 * 
	 * @return String
	 */
	public String isMaintenanceQuotesMoreInformationLinkDataAvailable() {
		clickAfterScroll(myOrganizationsPageObjects.maintenanceQuotesMoreInformationLink);
		return getText(myOrganizationsPageObjects.moreInfoPanel);
	}

	/**
	 * This method performs click event for Reports and retrieve the Header
	 * Label
	 * 
	 * @return boolean
	 */
	public String retrieveMyEsriReportsHeaderLabel() {
		clickAfterScroll(myOrganizationsPageObjects.orderReportsLink);
		return getText(myOrganizationsPageObjects.myEsriReportsHeaderLabel);
	}

	/**
	 * This method performs click event for Exit Reports and retrieve the Header
	 * Label
	 * 
	 * @return String
	 */
	public String retrieveExitReportsHeaderLabel() {
		scrollIntoViewByElement(myOrganizationsPageObjects.exitReportsButton);
		click(myOrganizationsPageObjects.exitReportsButton);
		return getText(myOrganizationsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Order History and retrieve the
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveMaintenanceQuotesHeaderLabelFromLeftPanel() {
		clickAfterScroll(myOrganizationsPageObjects.maintenanceQuotesLink);
		return getText(myOrganizationsPageObjects.myOrganizationHeaderLabel);
	}

}
