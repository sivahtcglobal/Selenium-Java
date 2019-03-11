package com.esri.sm.myesri.myorganization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.ui.PageObjects;

/**
 * This is the MY Esri site My Organizations - Training page class to perform
 * actions
 * 
 * @author Rizwan
 *
 */
public class TrainingPageFeatures extends PageObjects {

	private TrainingPageObjects trainingPageObjects;

	public TrainingPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		trainingPageObjects = new TrainingPageObjects(driver);
	}

	public List<String> myOrganizationSubTabs() {
		List<String> subLinkNames = new ArrayList<String>();
		for (int i = 0; i < trainingPageObjects.myEsriSubLinks.size(); i++) {
			subLinkNames.add(trainingPageObjects.myEsriSubLinks.get(i).getText());
		}
		return subLinkNames;
	}

	public List<String> trainingSubTabs() {
		List<String> trainingSubLinkNames = new ArrayList<String>();
		for (int i = 0; i < trainingPageObjects.usersSubLinks.size(); i++) {
			trainingSubLinkNames.add(trainingPageObjects.usersSubLinks.get(i).getText());
		}
		return trainingSubLinkNames;
	}

	/**
	 * This method performs click event for My Organization and retrieve My
	 * Organizations Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationHeaderLabel() {
		waitForPageToLoad();
		clickAfterScroll(trainingPageObjects.myOrganizationsLink);
		return getText(trainingPageObjects.myOrganizationCommonHeaderLabel);
	}
	
	/**
	 * This method returns true if user contains Training sub tab
	 * 
	 */
	public String retrieveMyOrganizationHeader() {
		return getText(trainingPageObjects.myOrganizationCommonHeaderLabel);
	}

	/**
	 * This method returns true if user contains Training sub tab
	 * 
	 * @return boolean
	 */
	public boolean isTrainingTabAvailable() {
		return isElementAvailable(trainingPageObjects.trainingLink);
	}

	/**
	 * This method returns true if user contains Training sub tab
	 * 
	 */
	public void clickOnTrainingTab() {
		click(trainingPageObjects.trainingLink);
	}

	/**
	 * This method performs click event for Training Link and retrieve Header
	 * Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationsHeaderLabel() {
		scrollIntoViewByElement(trainingPageObjects.trainingLink);
		click(trainingPageObjects.trainingLink);
		return getText(trainingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Training Records and retrieve Header
	 * Label
	 * 
	 * @return String
	 */
	public String retrieveTrainingRecordsHeaderLabel() {
		clickAfterScroll(trainingPageObjects.trainingRecordsLink);
		return getText(trainingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Training Link and retrieve Header
	 * Label
	 * 
	 * @return String
	 */
	public String retrieveVirtualCampusAnnualUserLicensesHeaderLabel() {
		scrollIntoViewByElement(trainingPageObjects.trainingOverviewLink);
		click(trainingPageObjects.trainingOverviewLink);
		scrollIntoViewByElement(trainingPageObjects.virtualCampusAnnualUserLicensesLink);
		click(trainingPageObjects.virtualCampusAnnualUserLicensesLink);
		waitForPageToLoad();
		return getText(trainingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Training Records side navigation and
	 * retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveTrainingRecordsSideNavHeaderLabel() {
		scrollIntoViewByElement(trainingPageObjects.trainingRecordsSideLink);
		click(trainingPageObjects.trainingRecordsSideLink);
		return getText(trainingPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Report and retrieve Header Label
	 * 
	 * @return String
	 */
	public String retrieveReportsTrainingRecordsHeaderLabel() {
		scrollIntoViewByElement(trainingPageObjects.reportLink);
		click(trainingPageObjects.reportLink);
		return getText(trainingPageObjects.trainingRecordsLabel);
	}

	/**
	 * This method performs click event for Exit Report
	 * 
	 * @return String
	 */
	public void clickOnExitReportButton() {
		scrollIntoViewByElement(trainingPageObjects.exitReportButton);
		click(trainingPageObjects.exitReportButton);
	}

	/**
	 * Performing the click event for More Information and validate the
	 * information
	 * 
	 * 
	 * @return String
	 */
	public String isMoreInformationDataAvailable() {
		clickAfterScroll(trainingPageObjects.moreInformationLink);
		String data;
		data = getText(trainingPageObjects.moreInformationLink);
		return data;
	}

	/**
	 * This method performs click event for Reports and retrieve the Header
	 * Label
	 * 
	 * @return boolean
	 */
	public String retrieveMyEsriReportsHeaderLabel() {
		clickAfterScroll(trainingPageObjects.orderReportsLink);
		return getText(trainingPageObjects.myEsriReportsHeaderLabel);
	}
	
	/**
	 * This method performs click event for Training Link and retrieve Header
	 * Label
	 * 
	 * @return String
	 */
	public String retrieveVirtualCampusAnnualUserLicensesSideHeaderLabel() {
		scrollIntoViewByElement(trainingPageObjects.virtualCampusAnnualUserLicensesSideLink);
		click(trainingPageObjects.virtualCampusAnnualUserLicensesSideLink);
		return getText(trainingPageObjects.myOrganizationHeaderLabel);
	}

}
