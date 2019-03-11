package com.esri.support.modules.ecommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommerceQuantityValidationPageObjects {

	@FindBy(xpath = "//*[@class='es-nav-teritem']/a[contains(text(), 'ArcGIS D') or contains(text(), 'ArcPad')]")
	public List<WebElement> headerLinkList;
	
	@FindBy(xpath = "//*[@class='es-nav-teritem']/a[contains(text(), 'ArcGIS D')]")
	public List<WebElement> headerLinkListForNonUS;

	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[2]/a")
	public WebElement arcGISOnlineLink;

	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[4]/a")
	public WebElement arcGISForPersonalUseLink;
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[5]/a")
	public WebElement arcGISForStudentUseLink;
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[7]/a")
	public WebElement arcPadLink;
	
	@FindBy(xpath="//*[@id='children']/div[2]/div/div[2]/div/div/a")
	public WebElement arcGISForStudentUseBuyNowLink;	

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[1]")
	public WebElement  studentUseAutoRenewalLabel;
	
	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[2]")
	public WebElement studentUseManualRenewalLabel;

	@FindBy(css = "a.btn.details.btn-fill")
	public WebElement arcGISForPersonalUseBuyNowLink;

	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[6]/a")
	public WebElement cityEngineLink;

	@FindBy(css = "#children > div:nth-child(2) > div > div > div > div:nth-child(1) > div > a")
	public WebElement cityEngineBasicBuyNowLink;

	@FindBy(css = "#children > div:nth-child(2) > div > div > div > div:nth-child(2) > div > a")
	public WebElement cityEngineAdvancedBuyNowLink;

	@FindBy(css = "div#license > form > div:nth-child(3) > label:nth-child(4)")
	public WebElement perpetualButton;

	@FindBy(xpath="//*[@id='quantity']")
	public WebElement quantityInputArea;

	@FindBy(xpath = "//*[@id='addToCart']/div[2]/span")
	public WebElement warningMessageLabel;

	@FindBy(xpath = "//*[@id='addToCart']/div[2]/span")
	public WebElement warningMessageLabelHideText;
	
	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[1]/div/a")
	public WebElement arcPadBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div[2]/div/div/a")
	public WebElement arcPadBuyNowOtherButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[2]/div/a")
	public WebElement arcPadNorthAmericaBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[3]/div/a")
	public WebElement arcPadEuropeBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[4]/div/a")
	public WebElement arcPadNorthAmericaAndEuropeBuyNowButton;

	/**
	 * Initialize the PageObject for ecommerce web page
	 * 
	 * @param driver
	 */
	public EcommerceQuantityValidationPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
