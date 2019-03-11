package com.esri.support.modules.ecommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommerceDRCartPageObjects {

	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/a")
	public WebElement productsHeaderLink;
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[4]/a")
	public WebElement arcGISForPersonalUseHeaderText;

	@FindBy(xpath = ".//*[@id='children']/div[2]/div/div[2]/div/div/a")
	public WebElement arcGISPersonalUseBuyNowButton;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[2]")
	public WebElement manualRenewalLabel;
	
	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[2]/a")
	public WebElement signinseeprice;	

	@FindBy(xpath = ".//*[@id='myButton']")
	public WebElement addToCartButton;

	@FindBy(xpath = ".//*[@id='cartItems']")
	public WebElement cartItemsInHeaderText;

	@FindBy(xpath = ".//*[@id='cart']/div[12]")
	public List<WebElement> itemList;

	/**
	 * Initialize the PageObject for ecommerce web page
	 * 
	 * @param driver
	 */
	public EcommerceDRCartPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
