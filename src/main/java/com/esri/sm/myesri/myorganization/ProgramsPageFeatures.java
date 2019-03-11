package com.esri.sm.myesri.myorganization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationReports;

/**
 * This is the MY Esri site My Organizations - Reports page class to perform
 * actions
 * 
 * @author Rizwan
 *
 */
public class ProgramsPageFeatures extends PageObjects {

	private ProgramsPageObjects programsPageObjects;

	public ProgramsPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		programsPageObjects = new ProgramsPageObjects(driver);
	}

	public List<String> myOrganizationSubTabs() {
		List<String> subLinkNames = new ArrayList<String>();
		for (int i = 0; i < programsPageObjects.myEsriSubLinks.size(); i++) {
			subLinkNames.add(programsPageObjects.myEsriSubLinks.get(i).getText());
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
		click(programsPageObjects.myOrganizationsLink);
		return getText(programsPageObjects.myOrganizationCommonHeaderLabel);
	}

	/**
	 * This method returns true if user contain Programs sub tab
	 * 
	 * @return boolean
	 */
	public boolean isProgramsTabAvailable() {
		return isElementAvailable(programsPageObjects.programsLink);
	}

	/**
	 * This method performs click event for Programs Link and retrieve Header
	 * Label
	 * 
	 * @return String
	 */
	public String retrieveProgramsHeaderLabel() {
		click(programsPageObjects.programsLink);
		return getText(programsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Training Link and will return true
	 * if search results are available
	 * 
	 * @return boolean
	 */
	public boolean isTrainingSearchResultsAreAvailable() {
		clickAfterScroll(programsPageObjects.TrainingLink);
		inputText(programsPageObjects.trainingQuickSearchInputArea, MyOrganizationReports.SEARCH_TEXT_FOR_TRAINING);
		return isElementAvailable(programsPageObjects.trainingSearchData);
	}

	/**
	 * This method performs click event for Additional Services Link and will
	 * return true if search results are available
	 * 
	 * @return boolean
	 */
	public boolean isAdditionalServicesSearchResultsAreAvailable() {
		clickAfterScroll(programsPageObjects.additionalServicesLink);
		inputText(programsPageObjects.trainingQuickSearchInputArea, MyOrganizationReports.PROGRAMSSEARCHTEXT);
		return isElementAvailable(programsPageObjects.trainingSearchData);
	}

	/**
	 * This method performs click event for Consulting Link and will return true
	 * if search results are available
	 * 
	 * @return boolean
	 */
	public boolean isConsultingSearchResultsAreAvailable() {
		clickAfterScroll(programsPageObjects.consultingLink);
		inputText(programsPageObjects.trainingQuickSearchInputArea, MyOrganizationReports.PROGRAMSSEARCHTEXT);
		return isElementAvailable(programsPageObjects.trainingSearchData);
	}

}
