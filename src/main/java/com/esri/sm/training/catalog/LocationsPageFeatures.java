package com.esri.sm.training.catalog;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.config.Env;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;

/**
 * This is the Catalog Sub Menu Locations page class to perform actions
 * 
 * @author Rizwan
 *
 */
public class LocationsPageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private LocationsPageObjects locationsPageObjects;

	/**
	 * Constructor to initialize the Catalog sub menu Locations page
	 * 
	 * @param driver,
	 * @param inputData
	 */
	public LocationsPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		super.openURL(Env.get("TRAINING"));
		this.locationsPageObjects = new LocationsPageObjects(driver);
	}

	/**
	 * Performing the mouse over action to Catalog button and click on Catalog
	 * sub menu Locations
	 * 
	 */
	public void clickOnLocationsSubMenu() {
		hoverMouseOver(locationsPageObjects.CatalogButton);
		click(locationsPageObjects.locationsLink);
		waitForPageToLoad();
	}

	/**
	 * Retrieve the Locations Page header Label
	 * 
	 * @return String
	 */
	public String retrieveTrainingLabel() {
		return getText(locationsPageObjects.trainingHeaderLabel);
	}

	/**
	 * Performing click event on Broomfield card
	 * 
	 */
	public void clickOnBroomfieldCard() {
		click(locationsPageObjects.broomfieldCard);
		waitForPageToLoad();
	}

	/**
	 * Verifying the expected available classes by checking results count
	 * 
	 * @return boolean
	 */
	public boolean isSearchResultsAvailable() {
		boolean searchResults = false;
		getText(locationsPageObjects.arcGISlabel);
		if (getSize(locationsPageObjects.searchResultCount) > 0) {
			searchResults = true;
		}
		return searchResults;
	}

	/**
	 * Select the Date (From and To) range for search results
	 * 
	 */
	public void selectDateRange() {
		inputText(locationsPageObjects.toDateInputArea, inputDataMap.get(CatalogPage.TO_DATE));
	}

	/**
	 * Performing the click event for Directions & Hospitality and checking the
	 * map availability
	 * 
	 */
	public boolean isMapAvailable() {
		click(locationsPageObjects.directionsHospitalityLink);
		return isElementAvailable(locationsPageObjects.map);
	}

}
