package com.esri.sm.training.catalog;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the Catalog Sub Menu Learning plans page class to identify the
 * objects
 * 
 * @author Rizwan
 *
 */
public class LearningPlansPageObjects {

	@FindBy(xpath = "//div[@class='link ng-binding'][contains(text(), 'Catalog')]")
	public WebElement CatalogButton;

	@FindBy(xpath = "//div[@class='grid-container menu-bar no-print']/div/div[2]/div/ul/li/a[contains(text(),'Learning Plans')]")
	public WebElement learningPlansLink;

	@FindBy(css = "div.column-8.ng-scope.ng-isolate-scope")
	public List<WebElement> learningPlansCount;
	
	@FindBy(css = "div.grid-container.catalog-search > div:nth-child(4) > div > div:nth-child(1) > div > div.header.ng-scope > a > div > span")
	public WebElement learningPlansHeaderLabel;
	
	/**
	 * Initialize the Page Object for Catalog Sub Menu Learning plans page
	 * 
	 * @param driver
	 *
	 */
	public LearningPlansPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
