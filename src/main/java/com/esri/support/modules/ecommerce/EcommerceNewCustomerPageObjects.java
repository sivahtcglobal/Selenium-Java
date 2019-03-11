package com.esri.support.modules.ecommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommerceNewCustomerPageObjects {
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/a")
	public WebElement productsHeaderLink;

	@FindBy(css = "#main-content > div > div:nth-child(7) > div:nth-child(2) > div.row > button")
	public WebElement createNewCustomerButton;
	
	@FindBy(xpath = ".//*[@id='main-content']/div/div[6]/div[2]/div[1]/div/div[2]/button")
	public WebElement selectFirstAccountButton;

	@FindBy(css = "div.customerNumberTypeSelection > div:nth-child(3) > button")
	public WebElement behalfofOrganizationButton;

	@FindBy(xpath = ".//*[@id='customerInfo']/div[1]/label[5]/input")
	public WebElement organizationNameTextBox;

	@FindBy(xpath = ".//*[@id='customerInfo']/div[1]/label[7]/input")
	public WebElement streetAddressTextBox;

	@FindBy(xpath = ".//*[@id='customerInfo']/div[1]/label[9]/input")
	public WebElement cityTextBox;

	@FindBy(xpath = ".//*[@id='customerInfo']/div[1]/label[11]/select")
	public WebElement stateDropDown;

	@FindBy(xpath = ".//*[@id='customerInfo']/div[1]/label[12]/input")
	public WebElement postalCodeTextBox;

	@FindBy(xpath = ".//*[@id='submit-btn']/button")
	public WebElement continueButton;

	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[2]/a")
	public WebElement arcGISOnlineHeaderLink;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[2]/div/a")
	public WebElement serviceCreditsBuyNowButton;

	@FindBy(xpath = ".//*[@id='myButton']")
	public WebElement addToCartButton;
	
	@FindBy(xpath="(//*[@class='btn details btn-fill'])[1]")
	public WebElement goToCartButton;	
	
	@FindBy(xpath ="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[4]/a")
	public WebElement goToCartLink;

	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[3]/a")
	public WebElement arcGISDeveloperSubscriptionHeaderLink;

	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[4]/a")
	public WebElement arcGISPersonalUseLink;
	
	@FindBy(xpath="//*[@id='children']/div[2]/div/div[2]/div/div/a")
	public WebElement arcGISPersonalUseBuyNowButton;
	
	@FindBy(xpath="//*[@id='addToCart']/div[1]/label[2]")
	public WebElement arcGISPersonalUseManualRenewal;
	
	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div/div/div[2]/div/a")
	public WebElement professionalBuyNowButton;

	@FindBy(xpath = "//*[@class='column-13 productContent']/h2")
	public WebElement productContentHeaderText;

	@FindBy(css = "input#quantity")
	public WebElement quantityInputArea;

	@FindBy(xpath = "//*[@id='cart']/div[13]/div")
	public List<WebElement> cartItemsList;

	@FindBy(xpath = ".//*[@id='remove1']/p/a")
	public WebElement removeCreditLineLink;	
	
	@FindBy(xpath = ".//*[@id='hideOfferButton0-0']")
	public WebElement hideOfferButton;

	@FindBy(css = "div#recommond0-0 > div > p:nth-child(4) > input.btn.btn-fill")
	public WebElement iltAddToCartButton;

	@FindBy(xpath = ".//*[@id='showOfferButton0-0']")
	public WebElement showOfferButton;

	@FindBy(xpath = "//*[@id='cart']/div[13]/div[2]/div[2]/div/div[4]/p/span")
	public WebElement serviceCreditsErrorMessage;
	
	@FindBy(xpath="//*[@id='cookie-accept']")
	public WebElement acceptButton;
	
	/**
	 * Initialize the PageObject for ecommerce web page
	 * 
	 * @param driver
	 */
	public EcommerceNewCustomerPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
