package com.esri.sm.training.catalog;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the Catalog Sub Menu Find Training class to identify the objects
 * 
 * @author Rizwan
 *
 */
public class FindTrainingPageObjects {

	@FindBy(xpath = "//div[@class='link ng-binding'][contains(text(), 'Catalog')]")
	public WebElement catalogButton;

	@FindBy(xpath = "//div[@class='grid-container menu-bar no-print']/div/div[2]/div/ul/li/a[contains(text(),'Find Training')]")
	public WebElement findTrainingLink;

	@FindBy(css = "div.search-bar:nth-child(2) > input")
	public WebElement searchInputArea;

	@FindBy(xpath = "//button[@class='search-submit icon-ui-search']")
	public WebElement searchIcon;

	@FindBy(xpath = "(//span[@class='title ng-binding'])[1]")
	public WebElement mooclabel;

	@FindBy(xpath = "//span[@class='title ng-binding']")
	public List<WebElement> searchResultList;

	@FindBy(xpath = "//span[@class='view-text ng-binding']")
	public WebElement listView;

	@FindBy(xpath = "//span[@class='ng-binding ng-isolate-scope esriu-course-tag WebCourse']")
	public WebElement listViewData;

	@FindBy(xpath = "//span[@class='view-text ng-binding']")
	public WebElement gridView;

	@FindBy(xpath = "//span[@class='title ng-binding']")
	public WebElement gridViewData;

	@FindBy(css = "h1.blue.font-size-8.avenir-light")
	public WebElement trainingHeaderLabel;

	@FindBy(xpath = ".//*[@class='drop-box ng-binding']/span[contains(text(), 'All GIS Capabilities')]")
	public WebElement allGISCapabilitiesFilterList;

	@FindBy(css = "div.filter-body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > label > input")
	public WebElement foundationDropDownItem;

	@FindBy(xpath = ".//*[@class='drop-box ng-binding']/span[contains(text(), 'All Products')]")
	public WebElement allProductsFilterList;

	@FindBy(xpath = "//*[@id='esriu']/div[2]/div/div[1]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/label/input")
	public WebElement arcMapItem;

	@FindBy(xpath = ".//*[@class='dropdown-check dropdown-levels ng-isolate-scope' and @default-text='All Learning Formats']/div")
	public WebElement allLearningFormatsFilterList;

	/*
	 * @FindBy(css =
	 * "div.column-24.catalog-filters.margin-top-sm > div:nth-child(4) > div.drop-box.ng-binding"
	 * ) public WebElement learningFormatsFilterList;
	 */

	@FindBy(css = "div.column-24.catalog-filters.margin-top-sm > div:nth-child(2) > div:nth-child(3) > div:nth-child(1)")
	public WebElement learningFormatsFilterList;

	@FindBy(xpath = "//*[@id='esriu']/div[2]/div/div[1]/div/div/div[2]/div[2]/div[3]/div[2]/div[1]/label/input")
	public WebElement instructorLedItem;

	@FindBy(xpath = "//div[@class='column-8 ng-isolate-scope']")
	public List<WebElement> filterResultsCount;

	@FindBy(xpath = "//div[@class='column-12 ng-binding']/input[1]")
	public WebElement availableWithMaintenanceCheckBox;

	@FindBy(xpath = "//div[@class='font-size-2 blue avenir-regular padding-bottom-md ng-binding']")
	public WebElement availableWithMaintenanceFilterResults;

	@FindBy(xpath = "//div[@class='column-12 ng-binding']/input[2]")
	public WebElement freeTrainingCheckBox;

	@FindBy(css = "span.icon-ui-close.remove")
	public WebElement removeFilterIcon;

	@FindBy(xpath = "//*[@id='esriu']/div[2]/div/div[1]/div/div/div[2]/div[2]/div[3]/div[2]/div[2]/label")
	public WebElement eLearningLabel;

	@FindBy(xpath = "//*[@id='esriu']/div[2]/div/div[1]/div/div/div[2]/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]/label/input")
	public WebElement webCoursesDropDown;

	@FindBy(css = "div.column-8.ng-isolate-scope")
	public List<WebElement> webCoursesFilterCount;

	@FindBy(xpath = "//*[@id='esriu']/div[2]/div/div[1]/div/div/div[2]/div[2]/div[3]/div[2]/div[2]/div[2]/div[4]/label/input")
	public WebElement videosDropDown;

	@FindBy(xpath = "//*[@id='esriu']/div[2]/div/div[1]/div/div/div[2]/div[2]/div[3]/div[2]/div[2]/div[2]/div[2]/label/input")
	public WebElement trainingSeminarsDropDown;

	@FindBy(xpath = "//button[@class='custom-search-cancel icon-ui-close']")
	public WebElement clearSearchButton;

	@FindBy(xpath = "//span[@class='title ng-binding' and .='Instructor-Led']")
	public List<WebElement> totalInstructorLedCards;

	@FindBy(xpath = "//li[@class='pagination-next ng-scope']/a")
	public WebElement nextButton;

	@FindBy(xpath = "//span[@class='title ng-binding']")
	public List<WebElement> totalCards;

	@FindBy(xpath = "//div[@class='column-24 catalog-filters margin-top-sm']/div[3]/div[2]/div[4]/label/input")
	public WebElement bookItem;

	@FindBy(xpath = "//span[@class='esriu-dark-green ng-binding ng-scope']")
	public List<WebElement> totalFreeTrainingCards;

	@FindBy(xpath = "//span[@class='text ng-binding']")
	public List<WebElement> addToWishlistButton;

	@FindBy(xpath = "//div[@class='link ng-binding'][contains(text(), 'My Learning')]")
	public WebElement myLearningMenu;

	@FindBy(xpath = "//div[@class='grid-container menu-bar no-print']/div/div[3]/div/ul/li/a[contains(text(),'Dashboard')]")
	public WebElement dashboardSubmenu;

	@FindBy(xpath = ".//*[contains(@class,'right')]/a[contains(text(),'View My Wish List')]")
	protected WebElement viewMyWishListLink;

	@FindBy(xpath = ".//*[@class='list-title margin-bottom-sm']/a")
	protected List<WebElement> wishlistCardTitleList;

	@FindBy(xpath = ".//*[@class='title' ]/span[@class='ng-binding']")
	protected List<WebElement> cardContext;

	@FindBy(id = "user_username")
	protected WebElement usernameText;

	@FindBy(id = "user_password")
	protected WebElement passwordText;

	@FindBy(id = "signIn")
	protected WebElement signInButton;

	@FindBy(id = "oAuthFrame")
	protected WebElement oAuthFrame;

	@FindBy(css = ".btn-large.ng-binding")
	protected List<WebElement> cardViewDetails;

	@FindBy(css = ".btn-large.ng-binding.ng-scope")
	protected WebElement registerButton;

	/**
	 * Initialize the PageObject for Catalog Sub Menu Find Training page
	 * 
	 * @param driver
	 *
	 */
	public FindTrainingPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
