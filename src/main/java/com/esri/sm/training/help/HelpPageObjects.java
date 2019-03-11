package com.esri.sm.training.help;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the Training Site Help page class to identify the objects
 * 
 * @author Rizwan
 *
 */
public class HelpPageObjects {

	@FindBy(css = "div.landing-header.no-print.ng-scope > div > div > div > h1")
	public WebElement trainingHeaderLabel;

	@FindBy(xpath = "//div[@class='link ng-binding'][contains(text(), 'Help')]")
	public WebElement helpLink;

	@FindBy(css = "span.font-size-6.ng-binding")
	public WebElement helpPageHeader;

	@FindBy(css = "div.search-bar > input")
	public WebElement searchInputArea;

	@FindBy(xpath = "//button[@class='search-submit icon-ui-search']")
	public WebElement searchIcon;

	@FindBy(css = "h4.accordion-title.ng-binding")
	public List<WebElement> searchResultCount;

	@FindBy(css = "button.custom-search-cancel.icon-ui-close")
	public WebElement clearSearchIcon;

	@FindBy(xpath = "//span[@class='ng-binding ng-scope'][contains(text(), 'All Categories')]")
	public WebElement allCategoriesFilter;

	@FindBy(xpath = "//label[@class='ng-binding'][contains(text(), 'Training Pass')]")
	public WebElement trainingPassFilterItem;

	/**
	 * Initialize the PageObject for Training Site Help page
	 * 
	 * @param driver
	 *
	 */
	public HelpPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
