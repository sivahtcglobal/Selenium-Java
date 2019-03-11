package com.esri.support.modules.ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommerceCommonPageObjects {
	
	@FindBy(css ="a.cookie-banner-action.esri-cookie-banner__button-two.button")
	public WebElement acceptCookiesButton;
	
	@FindBy(xpath ="//button[@class='esri-cookie__button'][contains(text(), 'Accept Cookies')]")
	public WebElement acceptCookiesButtonNow;

	@FindBy(xpath ="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[4]/a")
	public WebElement cartButton;

	@FindBy(xpath = "//*[@id='optionTypeLabel5090692600-new-0']/input")
	public WebElement createNewSubscriptionButton;

	@FindBy(css = "h3#subtotal")
	public WebElement cartTotalAmountText;

	@FindBy(xpath = ".//*[@id='checkout-button']")
	public WebElement proceedToCheckOutButton;

	@FindBy(xpath = ".//*[@id='dr_priceTotal']/td[3]")
	public WebElement priceDetailsInCheckoutText;

	@FindBy(css = "tr#dr_priceTotal > td.dr_price.dr_totals")
	public WebElement totalPriceInCheckoutText;

	@FindBy(xpath = "//*[@id='dr_cartTbl']/tbody/tr[1]/td[2]/div/input")
	public WebElement licenseCheckBox;

	@FindBy(xpath = "//*[@id='dr_cartTbl']/tbody/tr[2]/td[2]/div/input")
	public WebElement licenseTraingVocherCheckBox;

	@FindBy(xpath = "//*[@id='dr_cartTbl']/tbody/tr[1]/td[2]/div/a")
	public WebElement licenseAgreementLink;

	@FindBy(xpath = "//*[@id='ccMethod']")
	public WebElement paymentOptionDropDown;

	@FindBy(xpath = "//*[@id='ccNickName']")
	public WebElement cNickNameTextBox;

	@FindBy(xpath = "//*[@id='ccNum']")
	public WebElement creditCardNumberTextBox;

	@FindBy(xpath = "//*[@id='ccMonth']")
	public WebElement expirationDateOfMonthDropDown;

	@FindBy(xpath = "//*[@id='ccYear']")
	public WebElement expirationDateOfYearDropDown;

	@FindBy(xpath = "//*[@id='cardSecurityCode']")
	public WebElement cardSecurityCodeTextBox;

	@FindBy(xpath = "//*[@id='checkoutButton']")
	public WebElement continueCheckOutButton;

	@FindBy(xpath = ".//*[text()='Please select your country']")
	public WebElement countryErrorMessageText;

	@FindBy(xpath = "//*[@id='dr_billing']/div[4]/div[4]/label[2]")
	public WebElement swizCountryErrorMessageText;

	@FindBy(xpath = "//*[@id='billingState']")
	public WebElement billingStateDropDown;

	@FindBy(xpath = "//*[@id='billingState']/option[2]")
	public WebElement billingStateNotApplicableDropDownValue;
	
	@FindBy(xpath="//*[@id='billingState']/optgroup/option[1]")
	public WebElement billingStateDropDownValue;

	@FindBy(xpath = ".//*[@id='billingCountry']")
	public WebElement countryDropDown;

	@FindBy(xpath = ".//*[@id='billingCountry']/option[2]")
	public WebElement countryDropDownValue;
	
	@FindBy(xpath = ".//*[@id='billingCountry']/option[14]")
	public WebElement romaniaCountryDropDownValue;
	
	@FindBy(xpath = ".//*[@id='billingCountry']/option[5]")
	public WebElement colombiaCountryDropDownValue;

	@FindBy(xpath = ".//*[@id='billingCountry']/option[7]")
	public WebElement germanyCountryDropDownValue;
	
	@FindBy(xpath = ".//*[@id='billingCountry']/option[13]")
	public WebElement panamaCountryDropDownValue;
	
	@FindBy(xpath = ".//*[@id='billingCountry']/option[16]")
	public WebElement swizCountryDropDownValue;
	
	@FindBy(xpath = "//*[@id='rtav_overlay']")
	public WebElement addressPopUp;

	@FindBy(xpath = "//*[@id='rtavContinueButton']")
	public WebElement useSelectedButton;
	
	@FindBy(xpath = "//*[@name='cardSecurityCode']")
	public WebElement cardsecuritycode;

	@FindBy(xpath = "//*[@id='vr_skipregistration']")
	public WebElement skipRegistrationButton;

	@FindBy(xpath = "//*[@id='dr_orderNumber']")
	public WebElement referenceNumber;

	@FindBy(xpath = "//*[@id='dr_bcQuickBuyConfirmOrder']")
	public WebElement verifyOrderText;

	@FindBy(xpath = "//*[@id='tosAccepted']")
	public WebElement acceptedCheckBox;

	@FindBy(xpath = "//*[@id='submitBottom']")
	public WebElement submitOrderButton;

	@FindBy(xpath = "//*[@id='dr_orderNumber']")
	public WebElement orderNumber;

	@FindBy(xpath = "//*[@id='dr_siteButtons']/a")
	public WebElement viewInvoiceButton;

	@FindBy(xpath = ".//*[@id='dr_priceTotal']/td[3]")
	public WebElement totalPriceInInvoiceText;

	@FindBy(xpath = "//*[@id='dr_siteButtons']/input")
	public WebElement returnbutton;

	@FindBy(xpath = "//*[@id='dr_ThankYou']/h1")
	public WebElement thankYouText;

	@FindBy(xpath = "//*[@id='ProductInformation']/div[3]/div[2]/div[1]/div[3]/h5")
	public WebElement referenceNumberFromFulfillmentText;

	@FindBy(xpath = "//*[@id='ProductInformation']/div[3]/div[2]/div[1]/div[4]/h5")
	public WebElement customerNumberFromFulfillmentText;

	@FindBy(xpath = "//*[@id='ProductInformation']//table/tbody/tr[1]/td[3]/button")
	public WebElement getStartedButton;

	@FindBy(xpath="(//*[@class='btn ng-binding' ])[2]")
	public WebElement activeSubscriptionButton;
	
	@FindBy(xpath = "//*[@id='ProductInformation']/div[3]/div[2]/div[2]/table/tbody[3]/tr[2]/td/div/div/div/div/a")
	public WebElement trailActiveSubscriptionButton;
	
	@FindBy(xpath = "//*[@id='ProductInformation']/div[3]/div[2]/div[2]/table/tbody[2]/tr[2]/td/div/div/p[2]/a")
	public WebElement trailGoToDownloadButton;	
	
	@FindBy(xpath = "//*[@id='ProductInformation']/div[3]/div[2]/div[2]/table/tbody/tr[2]/td/div/div/div/div/a")
	public WebElement drCartActiveSubscriptionButton;

	@FindBy(xpath = "//*[@id='ProductInformation']/div[3]/div[2]/div[2]/table/tbody/tr[2]/td/div/div/p[2]/a")
	public WebElement drCartGoToDownloadButton;
	
	@FindBy(xpath="//a[contains(@href,'#/downloads') and @class='btn ng-binding']")
	public WebElement gotoDownloadButton;

	@FindBy(xpath = "//*[@id='ProductInformation']/div[3]/div[2]/div[2]/table/tbody[1]/tr[2]/td/div/div/p[4]/a")	
	public WebElement newCustomerGoToDownloadButton;
	
	@FindBy(xpath = ".//*[text()='Enter a valid value.']")
	public WebElement stateErrorMessageText;

	/**
	 * Initialize the PageObject for ecommerce web page
	 * 
	 * @param driver
	 */
	public EcommerceCommonPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
