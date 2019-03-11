package com.esri.support.modules.wherenextmagazine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.esri.qa.ui.PageObjects;

/**
 * This is the WhereNext Magazine PageObjects class to identify the objects
 * within the page
 * 
 * @author thenmozhiS
 */
public class WhereNextMagazinePageObjects extends PageObjects {

	@FindBy(xpath = "//*[@class='newsr-subscription--btn btn btn-large js-modal-toggle']")
	public WebElement subscribeButton;

	@FindBy(xpath = "//*[@class='form-field pd_right_col email pd-text required   ']/input")
	public WebElement emailTextBox;
	
	@FindBy(xpath="//*[@id='pardot-form']/p[3]/select")
	public WebElement roleDropDown;
	
	@FindBy(xpath="//*[@id='pardot-form']/p[4]/select")
	public WebElement industryDropDown;
	
	@FindBy(xpath="//*[@id='pardot-form']/p[36]/span/span/span")
	public WebElement yesCheckBox;
	
	@FindBy(xpath="//*[@id='pardot-form']/p[37]/span/span[1]/span")
	public WebElement yesRadioButton;

	@FindBy(xpath="//*[@id='submitForm']/span")
	public WebElement submitButton;

	@FindBy(xpath = "//*[@id='pardot-form']/p[1]")
	public WebElement thankYouText;

	@FindBy(css = "input#n-gateway-search-control")
	public WebElement searchTextBox;

	@FindBy(xpath = "//button[@class='n-gateway-search-submit']")
	public WebElement searchButton;

	@FindBy(xpath = ".//*[@id='news-results-title']")
	public WebElement searchResultHeaderText;

	//@FindBy(css = "a.n-gateway-tile:nth-child(1)")
	@FindBy(xpath = "(.//*[@class='newsr-card--heading avenir-regular font-size-1 text-off-black'])[1]")
	public WebElement latestArticleLink;
	
	//@FindBy(css = "a.n-gateway-tile:nth-child(1) > span.n-gateway-tile-content > p.n-gateway-tile-headline")
	@FindBy(xpath = "(.//*[@class='newsr-card--heading avenir-regular font-size-1 text-off-black'])[1]")
	public WebElement latestArticleText;

	@FindBy(xpath="//*[@class='newsr-art-heading--title font-size-6 avenir-light ']")
	public WebElement articleTitleText;
	
	@FindBy(xpath="//*[@class='newsr-art-heading--category']")
	public WebElement articleHeaderText;

	@FindBy(xpath="//a[@class='newsr-art--byline-link mobile-top']")
	public WebElement authorNameLink;

	@FindBy(xpath = ".//*[@id='news-profile-title']")
	public WebElement authorBioPageNameText;	
	
	@FindBy(xpath = "/html/body/section[2]/div/a")
	public WebElement contentTitleList;
	
	@FindBy(css = "a.n-gateway-tile:nth-child(countvalue) > span.n-gateway-tile-content > p.n-gateway-tile-headline")
	public WebElement latestArticleTextFromList;

	/**
	 * Initialize the page Object for WhereNext Magazine Home Page
	 * 
	 * @author thenmozhiS
	 * @param driver
	 * @return instance of pagefactory
	 */
	public WhereNextMagazinePageObjects(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
}
