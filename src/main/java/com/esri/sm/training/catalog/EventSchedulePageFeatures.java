package com.esri.sm.training.catalog;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esri.qa.config.Env;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;

/**
 * This is the Catalog Sub Menu Event Schedule page class to perform actions
 * 
 * @author Rizwan
 *
 */
public class EventSchedulePageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private EventSchedulePageObjects eventSchedulePageObjects;
	private int totalCards;

	/**
	 * Constructor to initialize the Catalog sub menu Event Schedule page
	 * 
	 * @param driver,
	 * @param inputData
	 */
	public EventSchedulePageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		super.openURL(Env.get("TRAINING"));
		eventSchedulePageObjects = new EventSchedulePageObjects(driver);

	}

	/**
	 * Performing the mouse over action to Catalog button and click on Catalog
	 * sub menu Event Schedule
	 * 
	 */
	public void clickOnEventScheduleSubMenu() {
		hoverMouseOver(eventSchedulePageObjects.catalogButton);
		click(eventSchedulePageObjects.eventScheduleLink);
		waitForPageToLoad();
	}
	/**
	 * Performing the search operation by entering input data
	 * 
	 * @return boolean
	 */
	public boolean retrieveSearchBoxDefaultText() {
		waitForPageToLoad();
		return isElementAvailable(eventSchedulePageObjects.searchInputArea);
	}
	
	/**
	 * Performing the search operation by entering input data
	 * 
	 */
	public void search() {
		inputText(eventSchedulePageObjects.searchInputArea, inputDataMap.get(CatalogPage.EVENT_SCHEDULE_SEARCH_TEXT));
		click(eventSchedulePageObjects.searchIcon);
	}

	/**
	 * Verifying the expected search results by checking results count
	 * 
	 * @return boolean
	 */
	public boolean isSearchResultsAvailable() {
		boolean searchResults = false;
		getText(eventSchedulePageObjects.headerLabel);
		if (getSize(eventSchedulePageObjects.searchResultCount) > 0) {
			searchResults = true;
		}
		return searchResults;
	}

	/**
	 * Performing the select event for All search filters
	 * 
	 */
	public void selectTheFilters() {
		click(eventSchedulePageObjects.allLearningFormatsFilterList);
		click(eventSchedulePageObjects.foundation);
		click(eventSchedulePageObjects.allLocationsFilterList);
		click(eventSchedulePageObjects.onlineItem);
	}
	
	/**
	 * Performing the select event for All search filters
	 * 
	 */
	public void selectTheFiltersForCatalog() {
		click(eventSchedulePageObjects.allLearningFormatsFilterList);
		click(eventSchedulePageObjects.instructorLedItem);
		click(eventSchedulePageObjects.allLocationsFilterList);
		click(eventSchedulePageObjects.onlineItemCatalog);
	}
	

	/**
	 * Select the Date (From and To) range for search results
	 * 
	 */
	public void selectDateRange() {
		inputText(eventSchedulePageObjects.toDateInputArea, inputDataMap.get(CatalogPage.TO_DATE));
	}

	/**
	 * Performing the click event to clear the filters
	 * 
	 */
	public void clickOnRemoveFilters() {
		click(eventSchedulePageObjects.removeFilterIcon);
	}

	/**
	 * Select the clear search
	 * 
	 */
	public void clickClearSearchButton() {
		click(eventSchedulePageObjects.clearSearchButton);
	}

	/**
	 * select the Instructor-Led from AllLearningFormats filter
	 * 
	 */
	public void clickAllLearningFormatsFilterAndSelectInstructorLed() {
		eventSchedulePageObjects.toDateInputArea.clear();
		click(eventSchedulePageObjects.allLearningFormatsFilterList);
		click(eventSchedulePageObjects.instructorLedItem);
	}

	/**
	 * select the Instructor-Led from AllLearningFormats filter
	 * 
	 */
	public void clickAllLocationsFilterAndSelectOnline() {
		click(eventSchedulePageObjects.allLocationsFilterList);
		click(eventSchedulePageObjects.onlineItemCatalog);
	}

	/**
	 * Return the count of total cards present in the page.
	 * 
	 * @param int
	 */
	public int getTotalCardsSize() {
		getText(eventSchedulePageObjects.headerLabel);
		totalCards = totalCards + eventSchedulePageObjects.totalCards.size();
		return eventSchedulePageObjects.totalCards.size();
	}

	/**
	 * Return the count of total cards present in all the page.
	 * 
	 * @param int
	 */
	public int getTotalCards() {
		return totalCards;
	}

	/**
	 * Return text of the card.
	 * 
	 * @param String
	 */
	public String retrieveCardName(String formatType, int index) {
		WebElement element;
		waitForPageToLoad();
		if (formatType.equalsIgnoreCase(CatalogPage.ONLINE_LOCATIONS))
			element = eventSchedulePageObjects.totalOnlineCards.get(index);
		else
			element = eventSchedulePageObjects.totalInstructorLedCards.get(index);
		return getText(element);
	}

	/**
	 * This method will check the formatType value matches with the cards
	 * present in all the page.
	 * 
	 * used contains because 'Instructor-Led' formats type is suffixed with
	 * dynamic id's.
	 * 
	 * @param isCardNamePresent
	 */
	public boolean isExpectedContextPresent(String formatType) {
		boolean isCardNamePresent = false;
		totalCards = 0;
		int cardsSize = getTotalCardsSize();
		for (int i = 0; i < cardsSize; i++) {
			String cardName = retrieveCardName(formatType, i);
			if (cardName.contains(formatType))
				isCardNamePresent = true;
			else {
				isCardNamePresent = false;
				break;
			}

			if (i == cardsSize - 1 && isElementAvailable(eventSchedulePageObjects.nextButton)) {
				i = 0;
				scrollIntoViewByElement(eventSchedulePageObjects.nextButton);
				click(eventSchedulePageObjects.nextButton);
				cardsSize = getTotalCardsSize();
			}
		}
		return isCardNamePresent;
	}

}
