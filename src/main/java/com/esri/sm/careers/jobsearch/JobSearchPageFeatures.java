package com.esri.sm.careers.jobsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esri.qa.config.Env;
import com.esri.qa.reporting.Log;
import com.esri.qa.ui.FeatureAutomationException;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.CareersConstants.CareersJobSearch;

/**
 * This is the Careers-Job Search page class to perform actions
 * 
 * @author anushar
 */
public class JobSearchPageFeatures extends PageObjects {

	private JobSearchPageObjects jobSearchPageObjects;
	private Map<String, String> inputDataMap;
	private WebDriver driver;
	private ArrayList<String> tabs2;

	/**
	 * Constructor to initialize the careers job search page
	 * 
	 * @param driver,
	 * @param inputData
	 */
	public JobSearchPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		this.driver = driver;
		super.openURL(Env.get("CAREERS"));
		this.jobSearchPageObjects = new JobSearchPageObjects(driver);
	}

	/**
	 * Enter the text which required to search
	 */
	public void searchDesiredTextInHomePage() {
		inputText(jobSearchPageObjects.jobSearchInputText, inputDataMap.get(CareersJobSearch.SERCH_TEXT));
		click(jobSearchPageObjects.searchButton);
	}

	/**
	 * Retrieve the list of search results
	 */
	public void retrieveListOfSearchResults() {
		int searchListCount = getSize(jobSearchPageObjects.searchResultsList);
		checkListSize(searchListCount);
	}

	/**
	 * Check whether the list having a data or not
	 * 
	 * @param count
	 */
	public void checkListSize(int count) {
		if (count == 0) {
			throw new FeatureAutomationException("Search results are empty");
		}
	}

	/**
	 * Check search results has an required text or not
	 * 
	 * @return
	 */
	public boolean retrieveSearchTextInResults() {
		boolean searchResultsStatus = false;
		WebElement searchResultsText = jobSearchPageObjects.searchResultsList.get(0);
		if (searchResultsText.getText().contains(inputDataMap.get(CareersJobSearch.SEARCH_TEXT_RESULTS))) {
			searchResultsStatus = true;
		}
		return searchResultsStatus;
	}

	/**
	 * returning list of bottom list link
	 */
	public List<WebElement> getRightNavigationLinkElements() {
		return jobSearchPageObjects.rightNavigationLinks;
	}

	/**
	 * returning list of social list link
	 */
	public List<WebElement> getSocialLinkElements() {
		return jobSearchPageObjects.socialLinks;
	}

	/**
	 * Method to get the current open windows count
	 */
	public int getWindowCount() {
		tabs2 = new ArrayList<>(driver.getWindowHandles());
		return tabs2.size();
	}

	/**
	 * Method switch the focus to child window return the title
	 */
	public String retrieveChildWindowTitle() {
		driver.switchTo().window(tabs2.get(1));
		waitForPageToLoad();
		String title = getTitle();
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		return title;
	}

	/**
	 * Returns the Title of the link mapped with key.
	 * <p>
	 * Fetch the webElement using the index, retrieve its text and then click on
	 * it. retrieve the header and title of next page
	 * 
	 * @param footerLinkElement
	 *            list of webElement
	 * @param linkIndex
	 *            footer link name index
	 * @return Map with the Title of all the links.
	 */
	public Map<String, String> getLinkTitle(List<WebElement> footerLinkElements, int linkIndex, String linkType) {
		String linkLabelName = null;
		Map<String, String> mapLinks = new HashMap<>();
		if (linkIndex > 0) {
			openURL(inputDataMap.get(CareersJobSearch.HOME_URL));
		}
		WebElement element = footerLinkElements.get(linkIndex);
		int sequence = linkIndex + 1;
		try {
			switch (linkType) {
			case CareersJobSearch.RIGHT_LINKS:
				linkLabelName = CareersJobSearch.RIGHT_NAVIGATION_LINK_PAGE_TITLE + sequence;
				break;
			case CareersJobSearch.SOCIAL_LINKS:
				linkLabelName = CareersJobSearch.SOCIAL_LINK_PAGE_TITLE + sequence;
				break;
			default:
				break;
			}
			click(element);
			Log.debug("Window Counts is :" + getWindowCount());
			if (getWindowCount() > 1) {
				mapLinks.put(linkLabelName, retrieveChildWindowTitle());
			} else {
				mapLinks.put(linkLabelName, getTitle());
			}
		} catch (Exception ex) {
			Log.error(linkLabelName + " link click un-successful. ", ex);
		}
		return mapLinks;
	}

	/**
	 * This method to select the job category from list elements
	 */
	public void selectDesiredJobCategory() {
		openURL(inputDataMap.get(CareersJobSearch.HOME_URL));
		click(jobSearchPageObjects.jobCategoryMarketing);
	}

	/**
	 * This method to select the job category from list elements
	 */
	public void selectDesiredJobLocation() {
		click(jobSearchPageObjects.jobLocation);
	}

	/**
	 * Get the selected search results and check whether selected job category
	 * list or not
	 * 
	 * @return selectedResultsStatus
	 */
	public boolean isSelectedJobCategory() {
		boolean selectedResultsStatus = false;
		WebElement searchResultsText = jobSearchPageObjects.jobCategorysearchResultsList.get(0);
		if (searchResultsText.getText().contains(inputDataMap.get(CareersJobSearch.JOB_CATEGORY).toUpperCase())) {
			selectedResultsStatus = true;
		}
		return selectedResultsStatus;
	}

	/**
	 * Get the selected search results and check whether selected job location
	 * list or not
	 * 
	 * @return selectedResultsStatus
	 */
	public boolean isSelectedJobLocation() {
		boolean selectedResultsStatus = false;
		WebElement searchResultsText = jobSearchPageObjects.jobLocationsearchResultsList.get(0);
		if (searchResultsText.getText().contains(inputDataMap.get(CareersJobSearch.JOB_LOCATION).toUpperCase())) {
			selectedResultsStatus = true;
		}
		return selectedResultsStatus;
	}

}
