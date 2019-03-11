package com.esri.support.modules.isp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.esri.qa.ui.PageObjects;

/**
 * 
 * This is the Image submission portal webpage class to identify the objects
 * within the page
 * 
 * @author deenesh
 */
public class ImageSubPortalPageObjects extends PageObjects{

	@FindBy(css = ".grid-50>div>h1")
	protected WebElement welcomeHeader;

	@FindBy(css = ".form>h2")
	protected WebElement imageSubmissionFormHeader;

	@FindBy(xpath = ".//*[@class='ng-scope ng-isolate-scope']/label/span")
	protected WebElement eventsDropDown;
	
	@FindBy(xpath = "//div[@class='home-page-top-wrapper container ng-scope']/div[2]/div/div/div[1]")
	protected WebElement eventsFirstOptionButton;
	
	@FindBy(xpath = ".//*[@class='ng-scope ng-isolate-scope']/label/span/span/span/select/option[3]")
	protected WebElement eventsSecondOption;

	@FindBy(css = "[label^='For which'] .field-label")
	protected WebElement conferenceHeader;

	@FindBy(css = "[label^='What type'] .field-label")
	protected WebElement fileTypeLabel;

	@FindBy(css = "[label^='Are you'] .field-label")
	protected WebElement federalGovLabel;

	@FindBy(xpath = "//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div[2]/div/div[2]/input")
	protected WebElement getStartedBtn;
	
	@FindBy(xpath = "//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div[2]/div/div[2]/div[2]/label/span/div/label[2]/input")
	protected WebElement noRadioBtn;
	
	@FindBy(xpath = "//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div[2]/div/div[2]/div[2]/label/span/div/label[1]/input")
	protected WebElement yesRadioBtn;
	
	@FindBy(xpath = ".//*[@class='form']/div[2]/label/span/div/label[1]/input")
	protected WebElement imageRadioBtn;
	
	@FindBy(xpath = "//*[@id='bodyColumnSingle']/div/div/div/div[2]/div/div[2]/div/div[2]/div[1]/label/span/div/label[2]/input")
	protected WebElement videoRadioBtn;
	
	@FindBy(xpath = ".//*[@class='grid-100 form']/label/input")
	protected WebElement iAgreeChkBox;
	
	@FindBy(xpath = ".//*[@class='grid-100']/input[2]")
	protected WebElement continueBtn;
	
	@FindBy(css = ".grid-100>h3")
	protected WebElement iAgreePageHeader;
	
	@FindBy(css = ".grid-100>h3")
	protected WebElement permissionPageHeader;
	
	@FindBy(css = ".grid-100>h1")
	protected WebElement videoPageHeader;
	
	@FindBy(css = "[label^='Non-specific Events']")
	protected WebElement eventFirstOptionLabel;
	
	@FindBy(css = "[label^='2017 Esri User']")
	protected WebElement eventSecondOptionLabel;
	
	/**
	* Initialize the page Object for Image Submission Portal 
    * 
    * @author thenmozhiS
    * @param driver
    * @return instance of pagefactory
    */
	public ImageSubPortalPageObjects (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
