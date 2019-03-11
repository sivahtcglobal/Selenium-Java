package com.esri.sm.training.catalog;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esri.qa.config.Env;
import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;
import com.esri.support.modules.core.TrainingConstants.MyLearningPage;

/**
 * This is the Catalog sub menu Find Training page class to perform actions
 * 
 * @author Rizwan
 *
 */
public class FindTrainingPageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private FindTrainingPageObjects findTrainingPageObjects;
	private int totalCards;
	private WebDriver driver;

	/**
	 * Constructor to initialize the Catalog sub menu Find Training page
	 * 
	 * @param driver,
	 * @param inputData
	 */
	public FindTrainingPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.driver = driver;
		this.inputDataMap = inputDataMap;
		super.openURL(Env.get("TRAINING"));
		this.findTrainingPageObjects = new FindTrainingPageObjects(driver);
	}

	/**
	 * * Retrieve the Page title
	 * 
	 * @return String
	 */
	public String retrieveTitle() {
		Log.info("Title is : " + getTitle());
		return getTitle();
	}

	/**
	 * Performing the mouse over action to Catalog button and click on Catalog
	 * sub menu Find Training
	 * 
	 */
	public void clickOnFindTrainingSubMenu() {
		hoverMouseOver(findTrainingPageObjects.catalogButton);
		click(findTrainingPageObjects.findTrainingLink);
	}

	/**
	 * Retrieve the Find Training Page header Label
	 * 
	 * @return String
	 */
	public String retrieveTrainingLabel() {
		return getText(findTrainingPageObjects.trainingHeaderLabel);
	}

	/**
	 * Performing the search operation by entering input data
	 * 
	 */
	public void search() {
		inputText(findTrainingPageObjects.searchInputArea, inputDataMap.get(CatalogPage.FIND_TRAINING_SEARCH_TEXT));
		click(findTrainingPageObjects.searchIcon);
	}

	/**
	 * Verifying the expected search results by checking results count
	 * 
	 * @return boolean
	 */
	public boolean isSearchResultsAvailable() {
		boolean searchResults = false;
		getText(findTrainingPageObjects.mooclabel);
		if (getSize(findTrainingPageObjects.searchResultList) > 0) {
			searchResults = true;
		}
		return searchResults;
	}

	/**
	 * Performing the click event for List View and validate List View is
	 * successful
	 * 
	 * @return boolean
	 */
	public boolean isListViewSuccessful() {
		click(findTrainingPageObjects.listView);
		return isElementAvailable(findTrainingPageObjects.listViewData);
	}

	/**
	 * Performing the click event for Grid View and validate Grid View is
	 * successful
	 * 
	 * @return boolean
	 */
	public boolean isGridViewSuccessful() {
		click(findTrainingPageObjects.gridView);
		return isElementAvailable(findTrainingPageObjects.gridViewData);
	}

	/**
	 * Performing the select event for All search filters
	 * 
	 */
	public void selectTheFilters() {
		click(findTrainingPageObjects.allGISCapabilitiesFilterList);
		click(findTrainingPageObjects.foundationDropDownItem);
		click(findTrainingPageObjects.allProductsFilterList);
		click(findTrainingPageObjects.arcMapItem);
		click(findTrainingPageObjects.allLearningFormatsFilterList);
		click(findTrainingPageObjects.instructorLedItem);
	}

	/**
	 * Performing the click event to clear the filters
	 * 
	 */
	public void clickOnRemoveFilters() {
		click(findTrainingPageObjects.removeFilterIcon);
	}

	/**
	 * Select the Available with maintenance check box
	 * 
	 */
	public void clickOnAvailableWithMaintenance() {
		click(findTrainingPageObjects.availableWithMaintenanceCheckBox);
	}

	/**
	 * Select the Free Training check box
	 * 
	 */
	public void clickOnFreeTraining() {
		click(findTrainingPageObjects.availableWithMaintenanceCheckBox);
		click(findTrainingPageObjects.freeTrainingCheckBox);
		waitForPageToLoad(8);
	}

	/**
	 * Select the Web Courses filter
	 * 
	 */
	public void selectTheWebCourseFilter() {
		click(findTrainingPageObjects.learningFormatsFilterList);
		hoverMouseOver(findTrainingPageObjects.eLearningLabel);
		click(findTrainingPageObjects.webCoursesDropDown);
	}

	/**
	 * Select the Training Seminars filter
	 * 
	 */
	public void selectTheTrainingSeminarsFilter() {
		clickOnRemoveFilters();
		click(findTrainingPageObjects.learningFormatsFilterList);
		hoverMouseOver(findTrainingPageObjects.eLearningLabel);
		click(findTrainingPageObjects.trainingSeminarsDropDown);
	}

	/**
	 * Select the Videos filter
	 * 
	 */
	public void selectTheVideosFilter() {
		clickOnRemoveFilters();
		click(findTrainingPageObjects.learningFormatsFilterList);
		hoverMouseOver(findTrainingPageObjects.eLearningLabel);
		click(findTrainingPageObjects.videosDropDown);
	}

	/**
	 * Select the clear search
	 * 
	 */
	public void clickClearSearchButton() {
		click(findTrainingPageObjects.clearSearchButton);
	}

	/**
	 * Click View Details of first card
	 * 
	 */
	public void clickFirstCardDetailsButton() {
		waitForPageToLoad(5);
		click(findTrainingPageObjects.cardViewDetails.get(0));
	}

	/**
	 * Click Register Button
	 * 
	 */
	public CourseRegistrationPageFeatures clickRegisterButton() {
		click(findTrainingPageObjects.registerButton);
		return new CourseRegistrationPageFeatures(driver, inputDataMap);
	}

	/**
	 * select the Instructor-Led from AllLearningFormats filter
	 * 
	 */
	public void filterInstructorLedCoursesOnly() {
		click(findTrainingPageObjects.availableWithMaintenanceCheckBox);
		click(findTrainingPageObjects.allLearningFormatsFilterList);
		click(findTrainingPageObjects.instructorLedItem);
		waitForPageToLoad();
	}

	/**
	 * select the Instructor-Led from AllLearningFormats filter
	 * 
	 */
	public void filterInstructorLedCourseOnly() {
		click(findTrainingPageObjects.allLearningFormatsFilterList);
		click(findTrainingPageObjects.instructorLedItem);
		waitForPageToLoad();
	}

	/**
	 * select the Instructor-Led from AllLearningFormats filter
	 * 
	 */
	public void clickAllLearningFormatsFilterAndSelectBooks() {
		click(findTrainingPageObjects.allLearningFormatsFilterList);
		click(findTrainingPageObjects.bookItem);
	}

	/**
	 * This method performs sign in action. After launching the url, click on
	 * sign in button at the top of the page, which navigates to "Esri Accounts"
	 * page then pass the inputs of username and password and click on "Sign in"
	 * button.
	 */
	public void signIn() {
		switchToFrame(findTrainingPageObjects.oAuthFrame);
		inputText(findTrainingPageObjects.usernameText, inputDataMap.get(MyLearningPage.USERNAME));
		inputText(findTrainingPageObjects.passwordText, inputDataMap.get(MyLearningPage.PASSWORD));
		click(findTrainingPageObjects.signInButton);
		driver.switchTo().defaultContent();
	}

	/**
	 * Return the course title and click on "Add to wishlist" button.
	 * 
	 * @param cardContext
	 *            contains the course title
	 */
	public String retriveCourseTitleAndAddItToWishlist() {
		String courseTitle = getText(findTrainingPageObjects.cardContext.get(0));
		hoverMouseClick(findTrainingPageObjects.addToWishlistButton.get(0));
		signIn();
		return courseTitle;
	}

	/**
	 * This methods check whether the course added to wishlist from 'Find
	 * Training' page is present in the 'Dashboard - wishlist page'.
	 * 
	 * @param isCardPresentInWishlistPage
	 */
	public boolean isAddedCoursePresentInDashboardWishlistPage(String addedToWishlistContext) {
		boolean isCardPresentInWishlistPage = false;
		click(findTrainingPageObjects.myLearningMenu);
		click(findTrainingPageObjects.viewMyWishListLink);
		List<WebElement> elements = findTrainingPageObjects.wishlistCardTitleList;
		for (int i = elements.size() - 1; i >= 0; i--) {
			if (getText(elements.get(i)).equalsIgnoreCase(addedToWishlistContext)) {
				scrollIntoViewByElement(elements.get(i));
				isCardPresentInWishlistPage = true;
				break;
			}
		}
		return isCardPresentInWishlistPage;
	}

	/**
	 * Return the count of total cards present in the page.
	 * 
	 * @param int
	 */
	public int getTotalCardsSize() {
		waitForPageToLoad();
		totalCards = totalCards + findTrainingPageObjects.totalCards.size();
		return findTrainingPageObjects.totalCards.size();
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
		waitForPageToLoad(10);
		if (formatType.equalsIgnoreCase(CatalogPage.FREE_TRAINING)) {
			element = findTrainingPageObjects.totalFreeTrainingCards.get(index);
		} else {
			element = findTrainingPageObjects.totalCards.get(index);
		}
		waitForPageToLoad(10);
		return getText(element);
	}

	/**
	 * This method will check the formatType value matches with the cards
	 * present in all the page.
	 * 
	 * @param isCardNamePresent
	 */
	public boolean isExpectedLearningFormatContextPresent(String formatType) {
		boolean isCardNamePresent = false;
		totalCards = 0;
		int cardsSize = getTotalCardsSize();
		for (int i = 0; i < cardsSize; i++) {
			Log.debug("card size " + i + " " + cardsSize);
			String cardName = retrieveCardName(formatType, i);
			if (cardName.equalsIgnoreCase(formatType))
				isCardNamePresent = true;
			else {
				isCardNamePresent = false;
				break;
			}
		}
		return isCardNamePresent;
	}

}
