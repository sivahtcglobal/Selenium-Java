package com.esri.sm.training.help;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.config.Env;
import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;

/**
 * This is the Training site Help page class to perform actions
 * 
 * @author Rizwan
 *
 */
public class HelpPageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private HelpPageObjects helpPageObjects;

	/**
	 * Constructor to initialize the Training site Help page
	 * 
	 * @param driver,
	 * @param inputData
	 */
	public HelpPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		super.openURL(Env.get("TRAINING"));
		helpPageObjects = new HelpPageObjects(driver);
	}

	/**
	 * * Retrieve the Page title
	 * 
	 * @return String
	 */
	public String retrieveTitle() {
		waitForPageToLoad();
		Log.info("Title is : " + getTitle());
		return getTitle();
	}

	/**
	 * Retrieve the Training Page header Label
	 * 
	 * @return String
	 */
	public String retrieveTrainingLabel() {
		return getText(helpPageObjects.trainingHeaderLabel);
	}

	/**
	 * Performing the click event for Help Link
	 * 
	 */
	public void clickOnHelpPageLink() {
		click(helpPageObjects.helpLink);
	}

	/**
	 * Retrieve the Help page Header
	 * 
	 * @return String
	 */
	public String retrieveHelpPageHeader() {
		return getText(helpPageObjects.helpPageHeader);
	}

	/**
	 * Performing the search operation by entering input data
	 * 
	 */
	public void search() {
		inputText(helpPageObjects.searchInputArea, inputDataMap.get(CatalogPage.FIND_TRAINING_SEARCH_TEXT));
		click(helpPageObjects.searchIcon);
	}

	/**
	 * Verifying the expected search results by checking results count
	 * 
	 * @return boolean
	 */
	public boolean isSearchResultsAvailable() {
		boolean searchResults = false;
		if (getSize(helpPageObjects.searchResultCount) > 0) {
			searchResults = true;
		}
		return searchResults;
	}

	/**
	 * Select the search filter Training Pass
	 */
	public void selectTheTrainingPassFilter() {
		click(helpPageObjects.clearSearchIcon);
		click(helpPageObjects.allCategoriesFilter);
		click(helpPageObjects.trainingPassFilterItem);
	}
	
}
