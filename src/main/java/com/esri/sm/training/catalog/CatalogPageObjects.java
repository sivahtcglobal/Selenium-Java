package com.esri.sm.training.catalog;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the Training Site Catalog page class to identify the objects
 * 
 * @author Rizwan
 *
 */
public class CatalogPageObjects {

	@FindBy(css = "div.landing-header.no-print.ng-scope > div > div > div > h1")
	public WebElement trainingHeaderLabel;

	@FindBy(xpath = "//div[@class='link ng-binding'][contains(text(), 'Catalog')]")
	public WebElement CatalogButton;

	@FindBy(css = "div.col-sm-12.header.margin-bottom-md > h1")
	public WebElement findTrainingHeaderLabel;

	@FindBy(css = "div.spotlight-container > div:nth-child(2) > h1")
	public WebElement getStartedArcGISHeaderLabel;

	@FindBy(xpath = "//div[@class='grid-container billboard']/div[2]")
	public WebElement getStartedArcGISProHeaderLabel;

	@FindBy(xpath = "//div[@class='search-bar margin-bottom-md']/input")
	public WebElement searchInputArea;

	@FindBy(xpath = "//button[@class='search-submit icon-ui-search']")
	public WebElement searchIcon;

	@FindBy(css = "div.column-8.ng-scope.ng-isolate-scope")
	public List<WebElement> searchResultCount;
	
	@FindBy(css = "div.padding-bottom-lg.padding-top-lg.ng-scope > div:nth-child(1) > div > div.header.ng-scope > a > div > span")
	public WebElement searchResultFirstHeadeText;
	
	@FindBy(xpath = "//div[@class='padding-bottom-lg padding-top-lg ng-scope']/div[1]/div/div[2]/a/div/span")
	public WebElement analysisOfSurfacesHeaderCard;

	@FindBy(xpath = "//div[@class='pre-5 column-14 margin-top-sm avenir-light font-size-6 text-white center ng-binding']")
	public WebElement analysisOfSurfacesHeaderLabel;

	@FindBy(xpath = "//button[@class='btn-large ng-binding ng-scope']")
	public WebElement signInButton;
	
	@FindBy(xpath = "//iframe[@id='oAuthFrame']")
	protected WebElement oAuthFrame;

	@FindBy(xpath = "//input[@id='user_username']")
	public WebElement userName;

	@FindBy(xpath = "//input[@id='user_password']")
	public WebElement password;

	@FindBy(xpath = "//button[@id='signIn']")
	public WebElement commonSignInButton;

	@FindBy(xpath = ".//*[@class='text ng-binding']")
	public WebElement wishListButton;
	
	@FindBy(xpath = ".//*[@class='text ng-binding hide']")
	public WebElement addedtoWishListHeaderLabel;

	@FindBy(xpath = "//div[@class='esriu-tabs']/a[contains(text(),'Software')]")
	public WebElement softwareButton;

	@FindBy(css = "div.course-info > div > ul > li:nth-child(2)")
	public WebElement arcGIS3DAnalystText;

	@FindBy(xpath = "//div[@class='esriu-tabs']/a[contains(text(),'Suggested Skills')]")
	public WebElement suggestedSkillsButton;

	@FindBy(css = "div.course-info > div > p")
	public WebElement essentialWorkflowsText;

	@FindBy(xpath = "//div[@class='maintenance-page ng-scope']/div[1]/h1")
	public WebElement getStartedwithELearningHeaderLabel;

	@FindBy(css = "button#esri-header-account-control")
	public WebElement trainingDropDown;

	@FindBy(css = "button.esri-header-account-signin-control.-logout")
	public WebElement signOutLink;

	/**
	 * Initialize the PageObject for Training Site Catalog page
	 * 
	 * @param driver
	 *
	 */
	public CatalogPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
