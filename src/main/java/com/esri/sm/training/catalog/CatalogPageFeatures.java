package com.esri.sm.training.catalog;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.config.Env;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.SignInPageFeatures;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;

/**
 * This is the Training site Catalog page class to perform actions
 * 
 * @author Rizwan
 *
 */
public class CatalogPageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private CatalogPageObjects catalogPageObjects;
	private SignInPageFeatures signInPageFeatures;

	/**
	 * Constructor to initialize the Training site Catalog page
	 * 
	 * @param driver,
	 * @param inputData
	 */
	public CatalogPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		super.openURL(Env.get("TRAINING"));
		this.catalogPageObjects = new CatalogPageObjects(driver);
		signInPageFeatures = new SignInPageFeatures(driver, inputDataMap);
	}

	/**
	 * Performing the SignIn operation by entering input data
	 * 
	 */
	public void SignIn() {
		click(catalogPageObjects.signInButton);
		signInPageFeatures.signIn();
	}

	/**
	 * Retrieve the Training Page header Label
	 * 
	 * @return String
	 */
	public String retrieveTrainingLabel() {
		return getText(catalogPageObjects.trainingHeaderLabel);
	}

	/**
	 * Performing the click event for Catalog Menu
	 * 
	 */
	public void clickOnCatalogButton() {
		click(catalogPageObjects.CatalogButton);
		waitForPageToLoad();
	}

	/**
	 * Retrieve the Catalog Page header Label
	 * 
	 * @return String
	 */
	public String retrieveFindTrainingLabel() {
		return getText(catalogPageObjects.findTrainingHeaderLabel);
	}

	/**
	 * Retrieve the title of the page
	 * 
	 * @return String
	 */
	public String retrievePageTitle() {
		waitForPageToLoad();
		return getTitle();
	}
	
	
	/**
	 * Performing the search operation by entering input data
	 * 
	 */
	public void search() {
		inputText(catalogPageObjects.searchInputArea, inputDataMap.get(CatalogPage.SEARCH_TEXT));
		click(catalogPageObjects.searchIcon);
		waitForPageToLoad();
	}

	/**
	 * Verifying the expected search results by checking results count
	 * 
	 * @return boolean
	 */
	public boolean isSearchResultsAvailable() {
		boolean searchResults = false;
		getText(catalogPageObjects.searchResultFirstHeadeText);
		if (getSize(catalogPageObjects.searchResultCount) > 0) {
			searchResults = true;
		}
		return searchResults;
	}

	/**
	 * Performing the click event for 3D Analysis of Surfaces and Features Using
	 * ArcGIS card
	 * 
	 */
	public void clickOnAnalysisOfSurfaces() {
		click(catalogPageObjects.analysisOfSurfacesHeaderCard);
	}

	/**
	 * Retrieve the 3D Analysis of Surfaces and Features Using ArcGIS Page
	 * header Label
	 * 
	 * @return String
	 */
	public String retrieveAnalysisOfSurfacesArcGISLabel() {
		waitForPageToLoad();
		return getText(catalogPageObjects.analysisOfSurfacesHeaderLabel);
	}

	/**
	 * Performing the mouse over event to Wish List button and click on Add to
	 * Wish List
	 * 
	 * @return String
	 * @throws InterruptedException 
	 */
	public String retrieveAddedToWishListLabel() throws InterruptedException {
		click(catalogPageObjects.wishListButton);
		Thread.sleep(5000);
		return getText(catalogPageObjects.wishListButton);
	}

	/**
	 * Performing the mouse over event to Add to Wish List and click on Remove
	 * From Wish List
	 * 
	 * @return String
	 * @throws InterruptedException 
	 */
	public String clickOnRemoveWishFromList() throws InterruptedException {
		click(catalogPageObjects.wishListButton);
		Thread.sleep(5000);
		return getText(catalogPageObjects.wishListButton);
	}

	/**
	 * Performing the click event for Software Button
	 * 
	 */
	public void clickOnSoftwareButton() {
		scrollIntoViewByElement(catalogPageObjects.softwareButton);
		click(catalogPageObjects.softwareButton);
	}

	/**
	 * Retrieve the ArcGIS 3D Analyst Label
	 * 
	 * @return String
	 */
	public String retrieveArcGISAnalystLabel() {
		return getText(catalogPageObjects.arcGIS3DAnalystText);
	}

	/**
	 * Performing the click event for Suggested Skills Button
	 * 
	 */
	public void clickOnSuggestedSkillsButton() {
		click(catalogPageObjects.suggestedSkillsButton);
	}

	/**
	 * Retrieve the ArcGIS 3D Analyst Label
	 * 
	 * @return String
	 */
	public String retrieveEssentialWorkflowsLabel() {
		return getText(catalogPageObjects.essentialWorkflowsText);
	}

	/**
	 * Performing the click event for How to Access Button
	 * 
	 */
	public void clickOnHowToAccessButton() {
		clickAfterScroll(catalogPageObjects.signInButton);
	}

	/**
	 * Retrieve the Get Started with E-Learning Label
	 * 
	 * @return String
	 */
	public String retrieveGetStartedWithELearningLabel() {
		return getText(catalogPageObjects.getStartedwithELearningHeaderLabel);
	}

	/**
	 * Performing the mouse over event for user name Training button and click
	 * on SignOut link
	 * 
	 */
	public void clickOnSignOutLink() {
		scrollIntoViewByElement(catalogPageObjects.trainingDropDown);
		click(catalogPageObjects.trainingDropDown);
		scrollIntoViewByElement(catalogPageObjects.signOutLink);
		click(catalogPageObjects.signOutLink);
		waitForPageToLoad();
	}
	
}
