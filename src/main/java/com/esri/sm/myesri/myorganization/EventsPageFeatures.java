package com.esri.sm.myesri.myorganization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationDownloads;

/**
 * This is the MY Esri site My Organizations - Events page class to perform
 * actions
 * 
 * @author Rizwan
 *
 */
public class EventsPageFeatures extends PageObjects {

	private EventsPageObjects eventsPageObjects;
	private Map<String, String> inputDataMap;

	public EventsPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		eventsPageObjects = new EventsPageObjects(driver);
	}

	public List<String> myOrganizationSubTabs() {
		List<String> subLinkNames = new ArrayList<String>();
		for (int i = 0; i < eventsPageObjects.myEsriSubLinks.size(); i++) {
			subLinkNames.add(eventsPageObjects.myEsriSubLinks.get(i).getText());
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
		click(eventsPageObjects.myOrganizationsLink);
		return getText(eventsPageObjects.myOrganizationCommonHeaderLabel);
	}

	/**
	 * This method returns true if user contains Events sub tab
	 * 
	 * @return boolean
	 */
	public boolean isEventsTabAvailable() {
		return isElementAvailable(eventsPageObjects.eventsLink);
	}

	/**
	 * This method performs click event for Events Link and retrieve Header
	 * Label
	 * 
	 * @return String
	 */
	public String retrieveUserConferenceRegistrationsHeaderLabel() {
		click(eventsPageObjects.eventsLink);
		return getText(eventsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method returns true if user contains Esri User Conference
	 * Registrations Data
	 * 
	 * @return boolean
	 */
	public boolean isEsriUserConferenceRegistrationsDataAvailable() {
		return isElementAvailable(eventsPageObjects.searchDataFirstItem);
	}

	/**
	 * This method performs search event for Esri User Conference 2017
	 * Registrations and validate the results availability
	 * 
	 * 
	 * @return boolean
	 */
	public boolean isEsriUserConferenceRegistrationsSearchResultsAreAvailabel() {
		boolean searchResults = false;
		inputText(eventsPageObjects.quickSearchInputArea, inputDataMap.get(MyOrganizationDownloads.SEARCH_TEXT));
		getText(eventsPageObjects.moreInformationLink);
		if (getSize(eventsPageObjects.searchResultsCount) > 0) {
			searchResults = true;
		} else {
			Log.error("Esri User Conference Registrations Search results are not available");
		}
		return searchResults;
	}

	/**
	 * This method performs search event for Esri User Conference 2017
	 * Registrations and validate the results availability
	 * 
	 * 
	 * @return boolean
	 */
	public boolean isEsriUserConferenceRegistrationsFilterResultsAreAvailabel() {
		boolean filterResults = false;
		clickAfterScroll(eventsPageObjects.sortByLink);
		isElementAvailable(eventsPageObjects.productFilterItemRegistrationID, Integer.toString(4));
		clickAfterScroll(eventsPageObjects.productFilterItemRegistrationID);
		getText(eventsPageObjects.moreInformationLink);
		if (getSize(eventsPageObjects.searchResultsCount) > 0) {
			filterResults = true;
		} else {
			Log.error("Esri User Conference Registrations Filter results are not available");
		}
		return filterResults;
	}

	/**
	 * This method performs click event for Events first details and retrieve
	 * Header Label
	 * 
	 * @return String
	 */
	public String retrieveRegistrationDetailsHeaderLabel() {
		waitForPageToLoad();
		click(eventsPageObjects.detailsFirstItemLink);
		return getText(eventsPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Events Link and retrieve Header
	 * Label
	 * 
	 * @return String
	 */
	public String validateBackToUserConferenceRegistrationsButton() {
		clickAfterScroll(eventsPageObjects.backToUserConferenceRegistrations);
		return getText(eventsPageObjects.myOrganizationHeaderLabel);
	}

}
