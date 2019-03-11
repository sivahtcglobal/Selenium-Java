package com.esri.sm.myesri.dashboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;

/**
 * This is the MY Esri Dashboard Overview page class to perform actions
 * 
 * @author Rizwan
 *
 */
public class DashboardPageFeatures extends PageObjects {

	private DashboardPageObjects dashboardPageObjects;
	private Map<String, String> inputDataMap;
	private WebDriver driver;
	private List<String> contactUsItemList;

	public DashboardPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		this.driver = driver;
		dashboardPageObjects = new DashboardPageObjects(driver);
	}
	/**
	 * Accept Cookies
	 * 
	 * 
	 */
	public void clickOnCookiesPopup() {		
		if (isElementAvailable(dashboardPageObjects.acceptCookiesButton)) {
			click(dashboardPageObjects.acceptCookiesButton);
		} else {
			Log.info("Accept Cookies popup is not available");
		}
	}
	/**
	 * Retrieve the Title of the Page
	 * 
	 * @return String
	 */
	public String retrievePageTitle() {
		waitForPageToLoad();
		Log.info("Page Title is : " + getTitle());
		return getTitle();
	}

	/**
	 * Retrieve the My Esri Page Header Label
	 * 
	 * @return String
	 */
	public String retrieveMyEsriPageHeader() {
		waitForPageToLoad();
		return getText(dashboardPageObjects.myEsriHeaderLabel);
	}

	/**
	 * This method performs sign in action. After launching the url, click on
	 * sign in button at the top of the page, which navigates to "Esri Accounts"
	 * page then switch to "OAuthframe" and pass the inputs of username and
	 * password and click on "Sign in" button.
	 */
	public void signIn() {
		try {		
		driver.switchTo().frame(dashboardPageObjects.oAuthFrame);
		hoverMouseClick(dashboardPageObjects.usernameText);
		inputText(dashboardPageObjects.usernameText, inputDataMap.get(MyEsriUserPages.USERNAME));
		hoverMouseClick(dashboardPageObjects.passwordText);
		inputText(dashboardPageObjects.passwordText, inputDataMap.get(MyEsriUserPages.PASSWORD));
		Log.info("User Name is :" + inputDataMap.get(MyEsriUserPages.USERNAME));
		Log.info("Password is :" + inputDataMap.get(MyEsriUserPages.PASSWORD));
		hoverMouseClick(dashboardPageObjects.signInButton);
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		} catch (Exception e) {
			Log.info("Waited for singIn page to load",e); 
		}
	}

	/**
	 * This method return true if Help window contains the right content
	 * 
	 */
	public boolean isHelpContentPopulatedSuccessfully() {
		boolean value = false;
		scrollIntoViewByElement(dashboardPageObjects.myEsriHelpMenuLink);
		click(dashboardPageObjects.myEsriHelpMenuLink);
		String commonHeaderLabel = getText(dashboardPageObjects.helpQuestionsHeaderLabel);
		if (commonHeaderLabel.contains(getText(dashboardPageObjects.commonQuestionsHeaderLabel))) {
			value = true;
		} else {
			Log.info("Help header label doesn't match");
		}
		return value;
	}

	/**
	 * This method performs click Event for My Esri Help Menu link
	 * 
	 */
	public void clickOnMyEsriHelpMenuCloseLink() {
		scrollIntoViewByElement(dashboardPageObjects.closeHelpMenu);
		click(dashboardPageObjects.closeHelpMenu);
	}

	/**
	 * This method performs click Event for My Esri Help Menu link and retrieve
	 * Help Questions Header Label
	 * 
	 */
	public String retrieveHelpQuestionsHeaderLabel() {
		scrollIntoViewByElement(dashboardPageObjects.myEsriHelpMenuLink);
		click(dashboardPageObjects.myEsriHelpMenuLink);
		return getText(dashboardPageObjects.helpQuestionsHeaderLabel);
	}

	/**
	 * This method performs click Event for My Esri Help Menu link
	 * 
	 */
	public void clickOnMyEsriHelpMenuLink() {
		scrollIntoViewByElement(dashboardPageObjects.myEsriHelpMenuLink);
		click(dashboardPageObjects.myEsriHelpMenuLink);
	}

	/**
	 * This method performs click Event for My Esri Help Menu Common Questions
	 * and retrieve the Header Label
	 * 
	 */
	public String retrieveHelpCommonQuestionsHeaderLabel() {
		scrollIntoViewByElement(dashboardPageObjects.helpCommonQuestionsLink);
		click(dashboardPageObjects.helpCommonQuestionsLink);
		return getText(dashboardPageObjects.commonQuestionsHeaderLabel);
	}

	/**
	 * This method performs click Event for My Esri Help Menu My Esri
	 * information on GeoNet and retrieve the Header Label
	 * 
	 */
	public String retrieveGeoNetHeaderLabel() {
		clickOnMyEsriHelpMenuLink();
		scrollIntoViewByElement(dashboardPageObjects.helpMyEsriInformationOnGeoNetLink);
		click(dashboardPageObjects.helpMyEsriInformationOnGeoNetLink);
		switchToChildWindow(2);
		inputText(dashboardPageObjects.userName, MyEsriUserPages.ARCGIS_USERNAME);
		inputText(dashboardPageObjects.passWord, MyEsriUserPages.ARCGIS_PASSWORD);
		clickAfterScroll(dashboardPageObjects.signIn);
		return retrievePageTitle();
	}

	/**
	 * This method performs click Event for My Esri Help Menu Send Feedback and
	 * retrieve the Header Label
	 * 
	 */
	public String retrieveSendFeedbackHeaderLabel() {
		switchToParentWindow(1);
		clickAfterScroll(dashboardPageObjects.helpSendFeedbackLink);
		return getText(dashboardPageObjects.helpContactUSHeaderLabel);
	}

	/**
	 * This method performs click Event for My Esri Help Menu Contact Us and
	 * retrieve the Header Label
	 * 
	 */
	public String retrieveHelpContactUsHeaderLabel() {
		clickOnMyEsriHelpMenuLink();
		clickAfterScroll(dashboardPageObjects.helpContactUsLink);
		return getText(dashboardPageObjects.commonQuestionsHeaderLabel);
	}

	/**
	 * Retrieve the Announcements Header Label
	 * 
	 * @return String
	 */
	public String retrieveAnnouncementsHeaderLabel() {
		return getText(dashboardPageObjects.announcementsHeaderLabel);
	}

	/**
	 * Retrieve the Common Questions Header Label from Dashboard page
	 * 
	 * @return String
	 */
	public String retrieveDashboardCommonQuestionsHeaderLabel() {
		return getText(dashboardPageObjects.dashboardCommonQuestionsHeaderLabel);
	}

	/**
	 * Performing the click event for View More Common Questions Button and
	 * retrieve the Common Questions Header Label
	 * 
	 * @return String
	 */
	public String retrieveCommonQuestionHeaderLabel() {
		scrollIntoViewByElement(dashboardPageObjects.ViewMoreCommonQuestionsLink);
		click(dashboardPageObjects.ViewMoreCommonQuestionsLink);
		return getText(dashboardPageObjects.commonQuestionsHeaderLabel);
	}

	/**
	 * Performing the click event for View More Common Questions Button and
	 * retrieve the Common Questions Header Label
	 * 
	 * @return int
	 */
	public int retrieveCommonQuestionsCatageriousCount() {
		return dashboardPageObjects.topicCategories.size();
	}

	/**
	 * Performing the click event for View More Common Questions Button and
	 * retrieve the Common Questions Header Label
	 * 
	 * @return List<WebElement>
	 */
	public List<WebElement> retrieveCommonQuestionsCatageriousElements() {
		return dashboardPageObjects.topicCategories;
	}

	/**
	 * Retrieve the Current Topic Common Questions count
	 * 
	 * @return boolean
	 */
	public boolean isCurrentTopicCommonQuestionsAvailable() {
		boolean results = false;
		if (getSize(dashboardPageObjects.commonQuestionsCount) > 0) {
			results = true;
		} else {
			Log.error("Common Question Categories wise results are zero");
		}
		return results;
	}

	/**
	 * Returns the Title of the Common Question and availability of questions.
	 * 
	 * @param catageriousElements
	 *            list of webElement
	 * @param linkIndex
	 *            link name index
	 * 
	 */
	public Map<String, Boolean> isCommonQuestionsAvailable(List<WebElement> catageriousElements, int linkIndex) {
		Map<String, Boolean> mapLinks = new HashMap<>();
		WebElement element = catageriousElements.get(linkIndex);
		scrollIntoViewByElement(element);
		click(element);
		mapLinks.put(catageriousElements.get(linkIndex).getText(), isCurrentTopicCommonQuestionsAvailable());
		return mapLinks;
	}

	/**
	 * Performing the search operation by entering input data for Common
	 * Question
	 * 
	 * @return boolean search is success or not.
	 */
	public boolean isCommonQuestionsSearchSuccessful() {
		boolean searchResults = false;
		inputText(dashboardPageObjects.commonQuestionsSearchInputArea, inputDataMap.get(MyEsriUserPages.SEARCH_TEXT));
		if (getSize(dashboardPageObjects.searchDataCount) > 0) {
			searchResults = true;
		} else {
			Log.debug("Common Question Search Results are Zero for Profile");
		}
		return searchResults;
	}

	/**
	 * Performing the click event for Contact Us Link and retrieve Header Label
	 * 
	 */
	public String retrieveContactUsHeaderLabel() {
		scrollIntoViewByElement(dashboardPageObjects.contactUsLink);
		click(dashboardPageObjects.contactUsLink);
		waitForPageToLoad();
		return getText(dashboardPageObjects.commonQuestionsHeaderLabel);
	}

	/**
	 * Performing the click event for Send Contact Us information
	 * 
	 */
	public void clickOnSend() {
		scrollIntoViewByElement(dashboardPageObjects.topicMyEsriRadioButton);
		click(dashboardPageObjects.topicMyEsriRadioButton);
		inputText(dashboardPageObjects.contactUsMessageTextArea, inputDataMap.get(MyEsriUserPages.CONTACT_US_MESSAGE));
		scrollIntoViewByElement(dashboardPageObjects.sendButton);
		click(dashboardPageObjects.sendButton);
	}

	/**
	 * Retrieve the Contact Us Successful message Label
	 * 
	 * @return String
	 */
	public String retrieveContactUsSuccessfulMessage() {
		return getText(dashboardPageObjects.contactUsSuccessMessage);
	}

	/**
	 * Performing the click event for dashboardFeedbackLink
	 * 
	 */
	public void clickdashboardFeedbackLink() {
		clickAfterScroll(dashboardPageObjects.dashboardFeedbackLink);
	}
	
	/**
	 * Retrieve the Contact Us item
	 * 
	 * @return String
	 */
	public String retrieveFeedbackItem() {
		contactUsItemList = getSelectedValues(dashboardPageObjects.contactUsItemList);
		Log.info("Selected Items are : " + contactUsItemList.get(0));
		return contactUsItemList.get(0);
	}

	/**
	 * Performing the click event for Feedback close icon
	 * 
	 */
	public void clickOnFeedbackCloseIcon() {
		clickAfterScroll(dashboardPageObjects.feedbackCloseIcon);
	}

}
