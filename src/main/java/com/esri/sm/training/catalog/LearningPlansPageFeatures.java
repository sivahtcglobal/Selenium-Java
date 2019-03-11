package com.esri.sm.training.catalog;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.config.Env;
import com.esri.qa.ui.PageObjects;

/**
 * This is the Catalog Sub Menu Learning Plans page class to perform actions
 * 
 * @author Rizwan
 *
 */
public class LearningPlansPageFeatures extends PageObjects {

	private LearningPlansPageObjects learningPlansPageObjects;

	/**
	 * Constructor to initialize the Catalog sub menu Learning Plans page
	 * 
	 * @param driver,
	 * @param inputData
	 */
	public LearningPlansPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		super.openURL(Env.get("TRAINING"));
		learningPlansPageObjects = new LearningPlansPageObjects(driver);

	}

	/**
	 * Performing the mouse over action to Catalog button and click on Catalog
	 * sub menu Event Schedule
	 * 
	 */
	public void clickOnLearningPlansSubMenu() {
		hoverMouseOver(learningPlansPageObjects.CatalogButton);
		click(learningPlansPageObjects.learningPlansLink);
	}
	
	/**
	 * This method will retrieve the page title
	 */
	public String getPageTitle() {
		waitForPageToLoad();
		return getTitle();
	}
	
	/**
	 * Verifying Learning plans are available
	 * 
	 * @return boolean
	 */
	public boolean isLearningPlansAvailable() {
		boolean searchResults = false;
		getText(learningPlansPageObjects.learningPlansHeaderLabel);
		if (getSize(learningPlansPageObjects.learningPlansCount) > 0) {
			searchResults = true;
		}
		return searchResults;
	}

}
