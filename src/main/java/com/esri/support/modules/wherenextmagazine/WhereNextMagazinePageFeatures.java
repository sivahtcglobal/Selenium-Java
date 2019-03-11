package com.esri.support.modules.wherenextmagazine;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.Constants.WhereNextMagazineHomePage;

/**
 * This class has all the WhereNext Magazine features methods.
 * 
 * @author thenmozhiS
 */
public class WhereNextMagazinePageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private WebDriver driver;
	private WhereNextMagazinePageObjects whereNextMagazinePageObject;
	private String expectedArticleHeader;
	private String expectedAuthorName;

	public WhereNextMagazinePageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.driver = driver;
		this.inputDataMap = inputDataMap;
		this.whereNextMagazinePageObject = new WhereNextMagazinePageObjects(driver);
	}

	/**
	 * This method retrieves the title of the page.
	 */
	public String retrieveTitle() {
		waitForPageToLoad();
		return getTitle();
	}

	/**
	 * This method performs subscription action. Click on subscribe button at
	 * the bottom of the page opens the form wherein enter the valid email id
	 * and click on submit button. After successful subscription capture the
	 * message displayed.
	 */
	public String getSubscriptionMessage() {
		waitForPageToLoad(10);
		scrollIntoViewByElement(whereNextMagazinePageObject.subscribeButton);
		click(whereNextMagazinePageObject.subscribeButton);
		driver.switchTo().frame("newsr_pardort");
		inputText(whereNextMagazinePageObject.emailTextBox, inputDataMap.get(WhereNextMagazineHomePage.EMAIL_ID));
		selectByIndex(whereNextMagazinePageObject.roleDropDown, 9); 
		selectByIndex(whereNextMagazinePageObject.industryDropDown, 17); 
		click(whereNextMagazinePageObject.yesCheckBox);
		click(whereNextMagazinePageObject.yesRadioButton);
		scrollIntoViewByElement(whereNextMagazinePageObject.submitButton);
		click(whereNextMagazinePageObject.submitButton);
		((JavascriptExecutor) driver).executeScript("scroll(0, -250);");
		scrollIntoViewByElement(whereNextMagazinePageObject.thankYouText);
		return getText(whereNextMagazinePageObject.thankYouText);
	}

	/**
	 * This method performs search action. Enter the search text in search area
	 * and click on search button. Then capture the search result header.
	 */
	public String getSearchResultHeader() {
		inputText(whereNextMagazinePageObject.searchTextBox, inputDataMap.get(WhereNextMagazineHomePage.SEARCH_KEYWORD));
		click(whereNextMagazinePageObject.searchButton);
		return getText(whereNextMagazinePageObject.searchResultHeaderText);
	}

	/**
	 * This method performs click action on an latest article.
	 */
	public void clickAnArticle() {		
		hoverMouseOver(whereNextMagazinePageObject.latestArticleLink);		
		scrollIntoViewByElement(whereNextMagazinePageObject.latestArticleText);
		expectedArticleHeader = getText(whereNextMagazinePageObject.latestArticleText);
		hoverMouseClick(whereNextMagazinePageObject.latestArticleLink);
	}
	
	public String expectedArticleTitle() {
		return expectedArticleHeader;
	}

	/**
	 * This method returns the header of an article .
	 */
	public String getArticleTitle() {
		Log.info(getText(whereNextMagazinePageObject.articleTitleText));
		return getText(whereNextMagazinePageObject.articleTitleText);
	}
	
	/**
	 * This method returns the header of an article .
	 */
	public String getArticleHeader() {
		Log.info(getText(whereNextMagazinePageObject.articleHeaderText));
		return getText(whereNextMagazinePageObject.articleHeaderText);
	}

	/**
	 * This method performs click action on an author name in the article page.
	 */
	public void clickAuthorBio() {	
		expectedAuthorName = getText(whereNextMagazinePageObject.authorNameLink);
		hoverMouseClick(whereNextMagazinePageObject.authorNameLink);
	}

	/**
	 * This method performs retrieves the author name from the article page.
	 */
	public String getExpectedAuthorName() {
		return expectedAuthorName;
	}
	
	/**
	 * This method returns the header of an Author Bio Page.
	 */
	public String getAuthorBioName() {
		return getText(whereNextMagazinePageObject.authorBioPageNameText);
	}	

}
