package com.esri.support.modules.ecommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommerceWithOutLoginPageObjects {
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/a")
	public WebElement productsHeaderLink;

	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li/a")	
	public List<WebElement> headerLinkList;

	@FindBy(xpath = ".//*[@id='description']/div[2]/h1")
	public WebElement headeraNavigationPageText;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div/div/h2")
	public List<WebElement> childCardHeaderTextList;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[1]/div/a")
	public WebElement arcGISOnlineNamedUsersBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[2]/div/a")
	public WebElement arcGISOnlineServiceCreditBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[3]/div/a")
	public WebElement arcGISOnlinePremiumFeatureBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[1]/div/a")
	public WebElement arcGISDeveloperBuilderBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[2]/div/a")
	public WebElement arcGISDeveloperProfessionalBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[3]/div/a")
	public WebElement arcGISDeveloperPremiumBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[4]/div/a")
	public WebElement arcGISDeveloperEnterPriseBuyNowButton;

	@FindBy(xpath = "//a[@class='btn details btn-fill']")
	public WebElement arcGISForPersonalUseBuyNowButton;	
	
	@FindBy(xpath = "//*[@id='children']/div[2]/div/div[2]/div/div/a")
	public WebElement arcGISForStudentUseBuyNowButton;

	@FindBy(xpath = "(//a[@class='btn details btn-fill'])[1]")
	public WebElement arcPadBuyNowButton;

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

	@FindBy(xpath = ".//*[@class='sub-nav-link cart']")
	public WebElement cartHeaderLink;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[1]/div/a")
	public WebElement basicBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[2]/div/a")
	public WebElement standardBuyNowButton;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[3]/div/a")
	public WebElement advancedBuyNowButton;

	@FindBy(xpath = "//*[@class='column-14 productContent']/h1")
	public WebElement productContentHeaderText;

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

	@FindBy(xpath = ".//*[@id='license1-label']/a")
	public WebElement licenceTypeSignIntoSeePriceText;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[1]/a")
	public WebElement userLevelSignIntoSeePriceText;

	@FindBy(xpath = ".//*[@id='addToCart']/div[2]/a")
	public WebElement signIntoSeePriceText;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[1]/a")
	public WebElement renewalSignIntoSeePriceText;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/div[2]/a")
	public WebElement  arcPadsignIntoSeePriceText;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[1]/a")
	public WebElement  cityEngineSignIntoSeePriceText;

	@FindBy(xpath = ".//*[@id='extension']/div[4]/div/div/div/div/div/p")
	public List<WebElement> assoicatedExtensionsList;

	@FindBy(xpath = ".//*[@id='extLicenseLabel1']")
	public WebElement perpetualLicensePopupLabel;

	@FindBy(xpath = ".//*[@id='extLicenseLabel2']")
	public WebElement termLicensePopUpLabel;
	
	@FindBy(xpath = "//*[@id='addToCart']/div[1]/label[1]/a")
	public WebElement studentUseCorrectPriceText;

	@FindBy(xpath = ".//*[@id='extLicenseLabel1']/a")
	public WebElement signIntoSeePriceTextInPopUp;

	@FindBy(xpath = ".//*[@id='exampleModal']/div/a")
	public WebElement closeButton;
	
	@FindBy(xpath=" //*[@id='cookie-notification']")
	public WebElement acceptButton;

	/**
	 * Initialize the PageObject for ecommerce web page
	 * 
	 * @param driver
	 */
	public EcommerceWithOutLoginPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
