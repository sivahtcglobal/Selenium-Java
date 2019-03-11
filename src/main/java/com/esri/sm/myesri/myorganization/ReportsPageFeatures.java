package com.esri.sm.myesri.myorganization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esri.qa.ui.PageObjects;

/**
 * This is the MY Esri site My Organizations - Reports page class to perform
 * actions
 * 
 * @author Rizwan
 *
 */
public class ReportsPageFeatures extends PageObjects {

	private ReportsPageObjects reportsPageObjects;

	public ReportsPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		reportsPageObjects = new ReportsPageObjects(driver);
	}

	public List<String> myOrganizationSubTabs() {
		List<String> subLinkNames = new ArrayList<String>();
		for (int i = 0; i < reportsPageObjects.myEsriSubLinks.size(); i++) {
			subLinkNames.add(reportsPageObjects.myEsriSubLinks.get(i).getText());
		}
		return subLinkNames;
	}

	/**
	 * This method performs click event for My Organization and retrieve My
	 * Organizations Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationHeaderLabel() {
		waitForPageToLoad();
		click(reportsPageObjects.myOrganizationsLink);
		return getText(reportsPageObjects.myOrganizationCommonHeaderLabel);
	}

	/**
	 * This method returns true if user contain Reports sub tab
	 * 
	 * @return boolean
	 */
	public boolean isReportsTabAvailable() {
		return isElementAvailable(reportsPageObjects.reportsLink);
	}

	/**
	 * This method performs click event for Reports Link and retrieve Header
	 * Label
	 * 
	 * @return String
	 */
	public String retrieveReportsHeaderLabel() {
		click(reportsPageObjects.reportsLink);
		return getText(reportsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method retrieve the Reports Header Label list count
	 * 
	 * @return int
	 */
	public int retrieveReportsCount() {
		return reportsPageObjects.myOrganizationReportsTabReportsList.size();
	}
	
	/**
	 * This method retrieve the Reports Header Label 
	 * 
	 * @return String
	 */
	public String retrieveReportsCount(int index) {
		waitForPageToLoad(45);
		return getText(reportsPageObjects.myOrganizationReportsTabReportsHeaderLabelList.get(index));
	}
	
	/**
	 * This method performs click event for My Organization and retrieve My
	 * Organizations Header Label
	 * 
	 *            list of webElement
	 * @param linkIndex
	 *            link name index
	 * 
	 */
	public String retrieveReportsHeaderLabel(int linkIndex) {
		waitForPageToLoad(45);
		WebElement element = reportsPageObjects.myOrganizationReportsTabReportsList.get(linkIndex);
		clickAfterScroll(element);
		waitForPageToLoad(45);
		return getText(reportsPageObjects.myOrganizationReportsTabReportsHeaderLabel);
	}
	
	/**
	 * This method performs click event for Exit Reports
	 * 
	 */
	public void clickOnExitReports() {
		waitForPageToLoad();
		click(reportsPageObjects.exitReport);
	}
	
}
