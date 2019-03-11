package com.esri.sm.training.catalog;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the Catalog Sub Menu Event Schedule page class to identify the
 * objects
 * 
 * @author Rizwan
 *
 */
public class EventSchedulePageObjects {

	@FindBy(xpath = "//div[@class='link ng-binding'][contains(text(), 'Catalog')]")
	public WebElement catalogButton;

	@FindBy(xpath = "//div[@class='grid-container menu-bar no-print']/div/div[2]/div/ul/li/a[contains(text(),'Event Schedule')]")
	public WebElement eventScheduleLink;

	@FindBy(css = "div.search-bar > input")
	public WebElement searchInputArea;

	@FindBy(xpath = "//button[@class='search-submit icon-ui-search']")
	public WebElement searchIcon;

	@FindBy(xpath = "(//a[@class='avenir-regular font-size-0 text-blue'])[1]")
	public WebElement headerLabel;
	
	@FindBy(css = "div.k-grid-content > table > tbody > tr")
	public List<WebElement> searchResultCount;

	@FindBy(xpath = ".//*[@class='drop-box ng-binding']/span[contains(text(), 'All Learning Formats')]")
	public WebElement allLearningFormatsFilterList;

	@FindBy(css = "div.column-24.catalog-filters.margin-top-sm > div:nth-child(2) > div.drop-list > div:nth-child(1) > label")
	public WebElement foundation;
	
	@FindBy(xpath = "//*[@id='esriu']/div[2]/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/label/input")
	public WebElement instructorLedItem;
	
	@FindBy(xpath = ".//*[@class='drop-box ng-binding']/span[contains(text(), 'All Locations')]")
	public WebElement allLocationsFilterList;

	@FindBy(css = "div.column-24.catalog-filters.margin-top-sm > div:nth-child(4) > div.drop-list > div:nth-child(1) > label > input")
	public WebElement onlineItem;
	
	@FindBy(xpath = "//*[@id='esriu']/div[2]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[1]/label/input")
	public WebElement onlineItemCatalog;
	
	@FindBy(xpath = "//md-datepicker[@id='fromDatePicker']/div/input")
	public WebElement fromDateInputArea;

	@FindBy(xpath = "//md-datepicker[@id='toDatePicker']/div/input")
	public WebElement toDateInputArea;
	
	@FindBy(xpath = "//button[@class='custom-search-cancel icon-ui-close']")
	public WebElement clearSearchButton;

	@FindBy(xpath = "//*[@class='text-gray font-size--3 avenir-light ng-binding']")
	public List<WebElement> totalInstructorLedCards;
	
	@FindBy(xpath = "//a[@class='ng-binding' and .='Next →']")
	public WebElement nextButton;
	
	@FindBy(xpath = "//*[@class='text-gray font-size--3 avenir-light ng-binding']")
	public List<WebElement> totalCards;
	
	@FindBy(css = "span.icon-ui-close.remove")
	public WebElement removeFilterIcon;
	
	@FindBy(xpath = "//a[@class='avenir-regular font-size-0 link-blue ng-binding ng-scope']")
	public List<WebElement> totalOnlineCards;

	/**
	 * Initialize the PageObject for Catalog Sub Menu Event Schedule page
	 * 
	 * @param driver
	 *
	 */
	public EventSchedulePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
