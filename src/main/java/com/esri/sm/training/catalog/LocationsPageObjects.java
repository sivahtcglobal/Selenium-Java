package com.esri.sm.training.catalog;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the Catalog Sub Menu Locations page class to identify the objects
 * 
 * @author Rizwan
 *
 */
public class LocationsPageObjects {

	@FindBy(xpath = "//div[@class='link ng-binding'][contains(text(), 'Catalog')]")
	public WebElement CatalogButton;

	@FindBy(xpath = "//div[@class='grid-container menu-bar no-print']/div/div[2]/div/ul/li/a[contains(text(),'Locations')]")
	public WebElement locationsLink;

	@FindBy(css = "h1.blue.font-size-8.avenir-light")
	public WebElement trainingHeaderLabel;

	@FindBy(xpath = "//*[@id='esriu']/div[2]/div[2]/div/div[2]/div/div/div/div/a[2]")
	public WebElement broomfieldCard;

	@FindBy(xpath = "//md-datepicker[@id='fromDatePicker']/div/input")
	public WebElement fromDateInputArea;

	@FindBy(xpath = "//md-datepicker[@id='toDatePicker']/div/input")
	public WebElement toDateInputArea;

	@FindBy(xpath = "(//a[@class='avenir-regular font-size-0 text-blue ng-binding'])[1]")
	public WebElement arcGISlabel;
	
	@FindBy(css = "div.k-grid-content > table > tbody > tr")
	public List<WebElement> searchResultCount;

	@FindBy(css = "div.esriu-tabs > a:nth-child(2)")
	public WebElement directionsHospitalityLink;

	@FindBy(css = "div#map_layers > svg")
	public WebElement map;

	@FindBy(css = "g#graphicsLayer52_layer")
	public WebElement mapView;
	
	

	/**
	 * Initialize the PageObject for Catalog Sub Menu Locations page
	 * 
	 * @param driver
	 *
	 */
	public LocationsPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
