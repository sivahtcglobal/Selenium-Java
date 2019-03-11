package com.esri.support.modules.ecommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommerceAfterLoginPageObjects {
	

	@FindBy(xpath = ".//*[@id='hero']/div[3]/div[1]/p/a[1]")
	public WebElement signInLink;

	@FindBy(xpath = ".//*[@id='main-content']/div/div[6]/div[2]/div/h5")
	public List<WebElement> customerList;

	@FindBy(xpath = ".//*[@id='appTitle']")
	public WebElement selectCustomerheaderText;

	@FindBy(xpath = ".//*[@id='main-content']/div/div[6]/div[2]/div[countvalue]/div/div[2]/button")
	public WebElement selectAccountButton;

	@FindBy(xpath = ".//*[@id='main-content']/div/div[6]/div[2]/div[1]/div/div[2]/button")
	public WebElement selectFirstAccountButton;

	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li/a")
	public List<WebElement> headerLinkList;
	
	@FindBy(xpath="//*[@class='card block']")
	public List<WebElement> productList;
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li")
	public List<WebElement> productList1;
	
	@FindBy(xpath="//*[@class='card block']/div/h4/a")
	public List<WebElement> productheaderList;
	
	@FindBy(xpath="//*[@class='card block']/div/p/a")
	public List<WebElement> productBuyNowLink;
	
	@FindBy(xpath = "//*[@id='children']/div[2]/div/div/div/div")
	public List<WebElement> BuynowList;
	
	@FindBy(xpath = "//*[@id='children']/div[2]/div/div/div/div/div/a")
	public List<WebElement> Buynowclicklist;	
	
	@FindBy(xpath="//*[@id='exampleModal']/div/a")
	public WebElement buyNowPOPupclose;
	
	@FindBy(xpath="//*[@id='exampleModal']/div/a")
	public WebElement buyNowclick;
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/a")
	public WebElement productsHeaderLink;
	
	@FindBy(xpath = ".//*[@id='description']/div[2]/h1")
	public WebElement headeraNavigationPageText;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div/div/h2")
	public List<WebElement> childCardHeaderTextList;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[1]/div/a")
	public WebElement arcGISOnlineNamedUsersBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[2]/div/a")
	public WebElement arcGISOnlineServiceCreditBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[3]/div/a")
	public WebElement arcGISOnlinePremiumFeatureBuyNow;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[1]/div/a")
	public WebElement arcGISDeveloperBuilderBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[2]/div/a")
	public WebElement arcGISDeveloperProfessionalBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[3]/div/a")
	public WebElement arcGISDeveloperPremiumBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[4]/div/a")
	public WebElement arcGISDeveloperEnterPriseBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div[2]/div/div/a")
	public WebElement arcGISForPersonalUseBuyNowButton;

	@FindBy(xpath = "//*[@id='children']/div[2]/div/div[2]/div/div/a")
	public WebElement arcGISForStudentUseBuyNowButton;
	
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

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[1]/div/a")
	public WebElement cityEngineBasicBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[2]/div/a")
	public WebElement cityEngineAdvancedBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[1]/div/a")
	public WebElement basicBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[2]/div/a")
	public WebElement standardBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[3]/div/a")
	public WebElement advancedBuyNowButton;

	@FindBy(xpath = ".//*[@id='license1-label']")
	public WebElement perpetualLicenseLabel;

	@FindBy(xpath = ".//*[@id='license2-label']")
	public WebElement termLicenseLabel;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[1]")
	public WebElement levelUser1Label;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[2]")
	public WebElement levelUser2Label;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[1]")
	public WebElement autoRenewalLabel;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[2]")
	public WebElement manualRenewalLabel;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[3]")
	public WebElement macLabel;

	@FindBy(xpath = ".//*[@id='license1-label']")
	public WebElement licenceTypePriceText;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[1]")
	public WebElement userLevelPriceText;

	@FindBy(xpath = ".//*[@id='addToCart']/div[2]")
	public WebElement correctPriceText;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[1]")
	public WebElement renewalCorrectPriceText;
	
	@FindBy(xpath = "//*[@id='addToCart']/div[1]/label[1]/a")
	public WebElement studentUseCorrectPriceText;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/div[2]")
	public WebElement arcPadCorrectPriceText;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[1]")
	public WebElement cityEngineCorrectPriceText;

	@FindBy(xpath = ".//*[@id='extension']/div[4]/div/div/div/div/div/p/a")
	public List<WebElement> assoicatedExtensionsList;

	@FindBy(xpath = ".//*[@id='extLicenseLabel1']")
	public WebElement perpetualLicensePopupLabel;

	@FindBy(xpath = ".//*[@id='extLicenseLabel2']")
	public WebElement termLicensePopUpLabel;

	@FindBy(xpath = ".//*[@id='extLicenseLabel1']")
	public WebElement correctPriceTextForInPopUp;

	@FindBy(xpath = ".//*[@id='price1']")
	public WebElement correctPriceLabel;

	@FindBy(xpath = ".//*[@id='exampleModal']/div/a")
	public WebElement closeButton;

	@FindBy(xpath = ".//*[@id='esri-header-account-control']")
	public WebElement esriHeaderAccountButton;

	@FindBy(xpath = ".//*[@id='esri-header-account-menu']/ul[2]/li[2]/button")
	public WebElement esriHeaderAccountSignOutButton;
	
	@FindBy(xpath=" //*[@id='cookie-notification']")
	public WebElement acceptButton;

	/**
	 * Initialize the PageObject for ecommerce web page
	 * 
	 * @param driver
	 */
	public EcommerceAfterLoginPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
