package com.esri.support.modules.ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyEsriRenewalPageObjects {

	@FindBy(xpath = ".//*[@id='hero']/div[3]/div[1]/p/a[1]")
	public WebElement signInLink;
	
	@FindBy(xpath = "//iframe[@id='oAuthFrame']")
	public WebElement oAuthFrame;

	@FindBy(id = "user_username")
	public WebElement usernameText;

	@FindBy(id = "user_password")
	public WebElement passwordText;

	@FindBy(id = "signIn")
	protected WebElement signInButton;
	
	@FindBy(xpath="//*[@id='topperBannerContainer']/nav/a[3]")
	public WebElement MyOrganizationsLink;
	
	@FindBy(xpath="//*[@id='header-content']/header[2]/div/div/nav[3]/a[1]")
	public WebElement organizationListLink;
	
	@FindBy(xpath="//*[@id='quickSearch']")
	public WebElement quickSearchBox;
	
	@FindBy(xpath="//*[@id='customerSelection']/div[2]/div/div/div[2]/div/div/div/div[2]/div[3]/div[3]/button")
	public WebElement customerSelectButton;
	
	@FindBy(xpath="//a[text()='Transactions']")
	public WebElement transactionsLink;
	
	@FindBy(xpath="//*[@id='orgTransactions']/div[2]/div[4]/div/button")
	public WebElement renewStorePurchasesButton;
	
	@FindBy(xpath="//*[@id='orgTransactions']/div[2]/div[5]/div/button")
	public WebElement manageAutoRenewalsButton;
	
	@FindBy(xpath="//*[@id='consumer_table']/table/tbody/tr/td[1]/input")
	public WebElement licenseList;
	
	@FindBy(xpath="//*[@id='consumer_table']/table/tbody/tr[1]/td[3]/div/div/span[1]")
	public WebElement autoRenewalYesButton;
	
	@FindBy(xpath="//*[@id='ManageAutoRenewals']/div[3]/div/div[3]/div/div/button")
	public WebElement okButton;
	
	@FindBy(xpath="//*[@id='renewStoreProducts']/div[5]/div[2]/button[2]")
	public WebElement nextButton;
	
	@FindBy(xpath="//*[@id='renewStoreProducts']/div[5]/div[2]/button[3]")
	public WebElement proceedToCheckOutButton;
	
	@FindBy(xpath="//*[@id='renewStoreProducts']/div[5]/div[2]/button[3]")
	public WebElement renewStoreProductsproceedToCheckOutButton;	
	
	@FindBy(xpath="//*[@id='consumer_table']/table/tbody/tr[1]/td[1]/div")
	public WebElement autoRenewalMessage;
	
	@FindBy(xpath="//*[@id='ManageAutoRenewals']/div[3]/div/div[1]/div/div/table[2]/tbody/tr/td/h5")
	public WebElement noRecourdFoundMessage;
	
	@FindBy(xpath="//*[@id='cookie-accept']")
	public WebElement acceptButton;
	
	/**
	 * Initialize the PageObject for ecommerce web page
	 * 
	 * @param driver
	 */
	public MyEsriRenewalPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
