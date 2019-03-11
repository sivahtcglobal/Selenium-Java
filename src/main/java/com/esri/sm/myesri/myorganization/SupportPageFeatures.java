package com.esri.sm.myesri.myorganization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationReports;

/**
 * This is the MY Esri My Organizations Aupport page class to perform actions
 * 
 * @author Rizwan
 *
 */
public class SupportPageFeatures extends PageObjects {

	private SupportPageObjects supportPageObjects;
	private WebDriver driver;

	public SupportPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.driver = driver;
		supportPageObjects = new SupportPageObjects(driver);
	}

	public List<String> myOrganizationSubTabs() {
		List<String> subLinkNames = new ArrayList<String>();
		for (int i = 0; i < supportPageObjects.myEsriSubLinks.size(); i++) {
			subLinkNames.add(supportPageObjects.myEsriSubLinks.get(i).getText());
		}
		return subLinkNames;
	}

	public List<String> supportSubTabs() {
		List<String> overviewSubLinkNames = new ArrayList<String>();
		for (int i = 0; i < supportPageObjects.supportSubLinks.size(); i++) {
			overviewSubLinkNames.add(supportPageObjects.supportSubLinks.get(i).getText());
		}
		return overviewSubLinkNames;
	}

	/**
	 * This method performs click event for My Organization and retrieve My
	 * Organizations Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyOrganizationHeaderLabel() {
		waitForPageToLoad();
		scrollIntoViewByElement(supportPageObjects.myOrganizationsLink);
		click(supportPageObjects.myOrganizationsLink);
		return getText(supportPageObjects.myOrganizationCommonHeaderLabel);
	}

	/**
	 * This method performs click event for Overview
	 * 
	 */
	public void clickOnSupport() {
		clickAfterScroll(supportPageObjects.supportLink);
	}

	/**
	 * This method performs click event for Edit and retrieve Organization
	 * Details Header Label
	 * 
	 * @return String
	 */
	public String retrieveCasesHeaderLabel() {
		clickAfterScroll(supportPageObjects.standardCasesLink);
		return getText(supportPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Organization Contacts and retrieve
	 * Edit Maintenance Contact Header Label
	 * 
	 * @return String
	 */
	public String retrieveBugsHeaderLabel() {
		clickAfterScroll(supportPageObjects.supportOverviewLink);
		click(supportPageObjects.supportOverviewbugsLink);
		return getText(supportPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Edit Organization Details and
	 * retrieve the Header Label
	 * 
	 * @return String
	 */
	public String retrieveViewMoreActivityHeaderLabel() {
		click(supportPageObjects.supportOverviewLink);
		click(supportPageObjects.viewMoreActivityLink);
		return getText(supportPageObjects.myOrganizationHeaderLabel);
	}
	
	/**
	 * This method performs click event for Edit Organization Name and retrieve
	 * the header Label
	 * 
	 * @return String
	 */
	public String retrieveRecentActivityHeaderLabel() {
		click(supportPageObjects.recentActivityLink);
		return getText(supportPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Edit Organization Name and retrieve
	 * the header Label
	 * 
	 * @return String
	 */
	public String retrieveRecentActivityHeader() {
		return getText(supportPageObjects.recentActivityFirstItemLink);
	}
	
	/**
	 * This method performs click event for Edit Maintenance Contact and
	 * retrieve the header Label
	 * 
	 * @return String
	 */
	public String retrieveRecentActivityFirstItemHeaderLabel() {
		click(supportPageObjects.recentActivityFirstItemLink);
		return getText(supportPageObjects.recentActivityFirstItemHeaderLabel);
	}

	/**
	 * This method performs click event for Update Contact Send Request and
	 * retrieve request success message
	 * 
	 * @return String
	 */
	public String retrieveCasessHeaderLabel() {
		click(supportPageObjects.casesLink);
		return getText(supportPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Request Permission and retrieve the
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveCasesFirstItemHeader() {
		return getText(supportPageObjects.casesFirstItemLink);
	}
	
	/**
	 * This method performs click event for Request Permission and retrieve the
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveCasesFirstItemHeaderLabel() {
		click(supportPageObjects.casesFirstItemLink);
		return getText(supportPageObjects.recentActivityFirstItemHeaderLabel);
	}

	/**
	 * This method performs click event for Update Contact Send Request and
	 * retrieve request success message
	 * 
	 * @return String
	 */
	public String retrieveBugssHeaderLabel() {
		click(supportPageObjects.bugsLink);
		return getText(supportPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * This method performs click event for Request Permission and retrieve the
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveBugsFirstItemHeader() {
		return getText(supportPageObjects.bugsFirstItemLink);
	}
	
	/**
	 * This method performs click event for Request Permission and retrieve the
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveBugsFirstItemHeaderLabel() {
		click(supportPageObjects.bugsFirstItemLink);
		return getText(supportPageObjects.bugsFirstItemHeaderLabel);
	}
	
	/**
	 * This method performs click event for Request Permission and retrieve the
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveAuthorizedCallersHeaderLabel() {
		click(supportPageObjects.authorizedCallersLink);
		return getText(supportPageObjects.myOrganizationHeaderLabel);
	}

	/**
	 * Method to switch to default content
	 * 
	 */
	public void switchParentWindow(int bowserWindowNo) {
		switchToChildWindow(bowserWindowNo);
	}
	
	/**
	 * Method to switch to child window.
	 *
	 * @param bowserWindowNo
	 */
	public void switchChildWindow(int bowserWindowNo) {
		List<String> browserWindows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(browserWindows.get(bowserWindowNo - 1));
	}
	
	/**
	 * This method performs click event for Request Permission and retrieve the
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveLearnMoreAboutPremiumSupportTitle() {
		click(supportPageObjects.learnMoreAboutPremiumSupportLink);
		switchToChildWindow(2);
		waitForPageToLoad();
		inputText(supportPageObjects.userName, MyEsriUserPages.ARCGIS_USERNAME);
		inputText(supportPageObjects.passWord, MyEsriUserPages.ARCGIS_PASSWORD);
		clickAfterScroll(supportPageObjects.signIn);
		waitForPageToLoad();
		String title = getTitle();
		switchToParentWindow(1);
		return title;
	}
	
	/**
	 * This method performs click event for Request Permission and retrieve the
	 * header label
	 * 
	 * @return boolean
	 */
	public boolean isAuthorizaedCallersSearchResultsAreAvailable() {
		boolean searchResults = false;
		inputText(supportPageObjects.AuthorizedCallersSearchInputArea, MyOrganizationReports.AUTHORIZED_CALLER_SEARCH_TEXT);
		if(getSize(supportPageObjects.AuthorizedCallersSearchResultsList) > 0) {
			searchResults = true;
		} else {
			Log.info("Search Results are not available for Authorizaed Callers");
		}
		return searchResults;
	}
	
	/**
	 * This method performs click event for Request Permission and retrieve the
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveEsriSupportTitle() {
		clickAfterScroll(supportPageObjects.visitSupportEsriComLink);
		switchToChildWindow(2);
		waitForPageToLoad();
		String title = getTitle();
		switchToParentWindow(1);
		return title;
	}
	
	/**
	 * This method performs click event for Request Permission and retrieve the
	 * header label
	 * 
	 * @return String
	 */
	public String retrieveTalkToTheCommunityTitle() {
		click(supportPageObjects.talkToTheCommunityLink);
		switchToChildWindow(2);
		waitForPageToLoad(45);
		String title = getTitle();
		switchToParentWindow(1);
		return title;
	}

}
