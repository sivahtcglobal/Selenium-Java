package com.esri.sm.training.mylearning;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.config.Env;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.TrainingConstants.MyLearningPage;

/**
 * This is the Esri Traning - My Learning sub menus page feature class.
 * 
 * @author Thenmozhi
 */
public class MylearningPageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private WebDriver driver;
	private MyLearningPageObjects myLearningPageObject;
	private String parrentWin;

	/**
	 * Constructor to initialize the Training site My Learning Menu page
	 * 
	 * @param driver,
	 * @param inputDataMap
	 */
	public MylearningPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.driver = driver;
		this.inputDataMap = inputDataMap;
		this.myLearningPageObject = new MyLearningPageObjects(driver);
	}

	/**
	 * Navigate to training home page.
	 */
	public void navigateToHomePage() {
		openURL(Env.get("TRAINING"));
	}

	/**
	 * Retrieve the Page title.
	 * 
	 * @return String
	 */
	public String retrieveTitle() {
		waitForPageToLoad();
		return getTitle();
	}

	/**
	 * Retrieve Training page header.
	 * 
	 * @return String
	 */
	public String getTrainingPageHeader() {
		return getText(myLearningPageObject.pageHeader);
	}

	/**
	 * This method performs sign in action. After launching the url, click on
	 * sign in button at the top of the page, which navigates to "Esri Accounts"
	 * page then pass the inputs of username and password and click on "Sign in"
	 * button.
	 */
	public void signIn() {
		click(myLearningPageObject.traningPageSignInButton);
		switchToFrame(myLearningPageObject.oAuthFrame);
		inputText(myLearningPageObject.usernameText, inputDataMap.get(MyLearningPage.USERNAME));
		inputText(myLearningPageObject.passwordText, inputDataMap.get(MyLearningPage.PASSWORD));
		click(myLearningPageObject.signInButton);
		driver.switchTo().defaultContent();
	}

	/**
	 * Click on the Dashboard Submenu.
	 */
	public void clickMyLearningSubmenuDashboard() {
		hoverMouseOver(myLearningPageObject.myLearningMenu);
		click(myLearningPageObject.dashboardSubMenu);
	}

	/**
	 * Click on the Learning Activity Submenu.
	 */
	public void clickMyLearningSubmenuLearningActivity() {
		hoverMouseOver(myLearningPageObject.myLearningMenu);
		click(myLearningPageObject.learningActivitySubMenu);
	}

	/**
	 * Click on the Schedule Submenu.
	 */
	public void clickMyLearningSubmenuSchedule() {
		hoverMouseOver(myLearningPageObject.myLearningMenu);
		click(myLearningPageObject.scheduleSubMenu);
	}

	/**
	 * Click on the Learning Plans Submenu.
	 */
	public void clickMyLearningSubmenuLearningPlans() {
		hoverMouseOver(myLearningPageObject.myLearningMenu);
		click(myLearningPageObject.learningPlansSubMenu);
	}

	/**
	 * Click on the WishList Submenu.
	 */
	public void clickMyLearningSubmenuWishList() {
		hoverMouseOver(myLearningPageObject.myLearningMenu);
		click(myLearningPageObject.wishListSubMenu);
	}

	/**
	 * Click on the ViewMyWishList and select "Web Course" from filters and then
	 * check the collect the "HowToAccess" button list and click the first
	 * "HowToAccess" button.
	 */
	public void accessDashboardWishListLink() {
		click(myLearningPageObject.viewMyWishListLink);
	}

	/**
	 * Enter valid search text and return the count of items displayed in the
	 * page.
	 * 
	 */
	public int learningActivitySearchFunctionality() {
		inputText(myLearningPageObject.learningActivityInputSearch,
				inputDataMap.get(MyLearningPage.LEARNING_ACTIVITY_SEARCH_KEYWORD));
		click(myLearningPageObject.learningActivitySearchBtn);
		click(myLearningPageObject.allLearningFormatDropDown);
		click(myLearningPageObject.allLearningFormatList.get(4));
		return getResultsCount();
	}
	
	/**
	 * Retrieve results count if element is available.
	 * 
	 * @return int
	 */
	public int getResultsCount() {
		int sCount=0;
		if(isElementAvailable(myLearningPageObject.learningActivitySearchResult)){
			sCount=Integer.parseInt(myLearningPageObject.learningActivitySearchResult.getText());
		}
		return sCount;
	}

	/**
	 * click on the Download Transcript button and retrieve the url of the page..
	 * 
	 * @return url
	 */
	public String getDownloadTransriptPageUrl() {
		click(myLearningPageObject.downloadTranscriptBtn);
		switchToChildWindow();
		waitForPageToLoad();
		String url = driver.getCurrentUrl();
		switchToParrentWindow();
		return url;
	}

	/**
	 * Retrieve 'Schedule Card' page Title.
	 * 
	 * @return String
	 */
	public String getTitleOfScheduleCardFormat() {
		return getText(myLearningPageObject.firstScheduleCardFormatText);
	}

	/**
	 * Retrieve 'Schedule Card' page Header.
	 * 
	 * @return String
	 */
	public String getHeaderOfScheduleCardPage() {
		click(myLearningPageObject.firstScheduleCard);
		return getText(myLearningPageObject.firstScheduleCardPageHeader);
	}

	/**
	 * Retrieve 'Learning Plans' page Title.
	 * 
	 * @return String
	 */
	public String getLearningPlansTypeHeader() {
		return getText(myLearningPageObject.firstLearningPlansCardFormatText);
	}

	/**
	 * Retrieve 'Learning Plans' page Header.
	 * 
	 * @return String
	 */
	public String getHeaderOfLearningPlansCardPage() {
		click(myLearningPageObject.firstLearningPlansCard);
		return getText(myLearningPageObject.firstLearningPlansCardPageHeader);
	}

	/**
	 * Retrieve 'WishList Filter' label name.
	 * 
	 * @return String
	 */
	public String getWishListFilterName() {
		click(myLearningPageObject.allLearningFormatDropDown);
		String filterName = getText(myLearningPageObject.allLearningFormatList.get(1));
		click(myLearningPageObject.allLearningFormatList.get(1));
		return filterName;
	}

	/**
	 * After filtering collect the "How To Access" button list and click the
	 * first "HowToAccess" button.
	 */
	public void clickHowToAccessBtnInWishListPage() {
		for (int i = 0; i < myLearningPageObject.howToAccessButton.size(); i++) {
			if (getText(myLearningPageObject.howToAccessButton.get(i)).equalsIgnoreCase(MyLearningPage.HOWTOACCESS_BTN)
					&& !getText(myLearningPageObject.howToAccessButton.get(i)).isEmpty()) {
				click(myLearningPageObject.howToAccessButton.get(i));
				break;
			}
		}
	}

	/**
	 * Switch to child window.
	 */
	public void switchToChildWindow() {
		ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
		parrentWin = tabs2.get(0);
		driver.switchTo().window(tabs2.get(1));
	}

	/**
	 * Switch to parent window.
	 */
	public void switchToParrentWindow() {
		driver.close();
		driver.switchTo().window(parrentWin);
	}

}
