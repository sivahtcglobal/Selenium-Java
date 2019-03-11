package com.esri.support.modules.ecommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPageObjects {

	@FindBy(xpath=" //*[@id='esri-cookie-banner']/div/div/div[2]/a[2]")
	public WebElement acceptButton;
	
	@FindBy(xpath="//*[@class='es-nav-sublink'][contains(text(),'Products')]")
	public WebElement productsHeaderLink;
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[1]/a")
	public WebElement arcGISDesktopLink;
	
	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[2]/div/a")
	public WebElement standardBuyNowButton;	
	
	@FindBy(css = "#license1-label > a")
	public WebElement signInToSeePriceLink;
	
	@FindBy(xpath = ".//*[@id='main-content']/div/div[6]/div[2]/div/h5")
	public List<WebElement> customerList;
	
	@FindBy(xpath = ".//*[@id='main-content']/div/div[6]/div[2]/div[countvalue]/div/div[2]/button")
	public WebElement selectAccountButton;
	
	@FindBy(xpath = "//*[@class='column-14 productContent']/h1")
	public WebElement headeraNavigationPageText;
	
	@FindBy(xpath = "//*[@id='modalTitle']")
	public WebElement productContentHeader;		
	
	
	@FindBy(xpath = "//*[@id='extension']/div[4]/div/div/div/div[3]/div/p/a")
	public WebElement productbuynow;	
	
	@FindBy(xpath = "//iframe[@id='oAuthFrame']")
	protected WebElement oAuthFrame;

	@FindBy(id = "user_username")
	protected WebElement usernameText;

	@FindBy(id = "user_password")
	protected WebElement passwordText;

	@FindBy(id = "signIn")
	protected WebElement signInButton;
	
	@FindBy(xpath = ".//*[@id='license1-label']")
	public WebElement perpetualLicenseLabel;
	
	@FindBy(xpath = ".//*[@id='myButton']")
	public WebElement addToCartButton;
	
	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[1]/div/a")
	public WebElement basicBuyNowButton;
	
	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[3]/div/a")
	public WebElement advancedBuyNowButton;
	
	@FindBy(xpath="//*[@id='change']")
	public WebElement changeLink;
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[4]/a")
	public WebElement arcGISForPersonalUseLink;
	
	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div[2]/div/div/a")
	public WebElement arcGISForPersonalUseBuyNowButton;
	
	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[1]")
	public WebElement autoRenewalLabel;
	
	@FindBy(xpath = ".//*[@id='remove0']/p/a")
	public WebElement removeLink;	
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[5]/a")
	public WebElement arcGISForStudentUseLink;
	
	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div[2]/div/div/a")
	public WebElement arcGISForStudentUseBuyNowButton;
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[7]/a")
	public WebElement arcPadLink;
	
	@FindBy(xpath="//*[@id='children']/div[2]/div/div/div/div[1]/div/a")
	public WebElement arcPadBuyNow1;
	
	@FindBy(xpath="//*[@id='children']/div[2]/div/div[2]/div/div/a")
	public WebElement arcPadBuyNow2;
	
	@FindBy(xpath = ".//*[@id='license2-label']")
	public WebElement termLicenseLabel;
	
	@FindBy(xpath = ".//*[@id='remove0']/p/a")
	public WebElement removeStudentUseLink;
	
	@FindBy(xpath = ".//*[@id='remove1']/p/a")
	public WebElement removeArcPadLink;
	
	@FindBy(xpath="//*[@class='fieldset-radio']/label[2]")
	public WebElement submitPurchaseOrderOption;
	
	/**
	 * Initialize the PageObject for ecommerce web page
	 * 
	 * @param driver
	 */
	public PurchaseOrderPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
