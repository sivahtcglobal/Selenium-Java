package com.esri.sm.careers.jobsearch;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobSearchPageObjects {

	@FindBy(xpath = ".//*[@class='job-search-input']")
	public WebElement jobSearchInputText;

	@FindBy(xpath = ".//*[@class='job-search-btn']")
	public WebElement searchButton;

	@FindBy(xpath = ".//*[@id='pg-content-area']/div[2]/ul/li")
	public List<WebElement> searchResultsList;

	@FindBy(xpath = ".//*[@class='pg-nav-item']")
	public List<WebElement> rightNavigationLinks;

	@FindBy(xpath = ".//*[@id='form1']/div[5]/div/ul/li/a")
	public List<WebElement> socialLinks;

	@FindBy(xpath = ".//*[@id='liCareerMarketing']")
	public WebElement jobCategoryMarketing;

	@FindBy(xpath = ".//*[@class='job-info-item job-item-team job-path']")
	public List<WebElement> jobCategorysearchResultsList;

	@FindBy(xpath = ".//*[@id='liLocationUS-CA-Redlands']")
	public WebElement jobLocation;

	@FindBy(xpath = ".//*[@class='job-info-item job-item-location job-locations job-loc']")
	public List<WebElement> jobLocationsearchResultsList;

	/**
	 * Initialize the PageObject for careers job search web page
	 * 
	 * @param driver
	 */
	public JobSearchPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
