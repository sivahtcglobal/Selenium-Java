package com.esri.support.modules.ecommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommerceTrailCustomerPageObjects {
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/a")
	public WebElement productsHeaderLink;

	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[1]/a")
	public WebElement arcGISDesktopLink;

	@FindBy(css = "a#homelinkCanada > img")
	public WebElement distributorLogo;

	@FindBy(xpath = "//*[@id='children']/div[2]/div/div/div/div[1]/div/a")
	public WebElement basicBuyNowButton;

	@FindBy(css = "#license1-label > a")
	public WebElement signInToSeePriceLink;

	@FindBy(xpath = "/*[@id='hero']/div[3]/div[1]/p/a[1]")
	public WebElement signInLink;

	@FindBy(css = "#main-content > div > div:nth-child(7) > div:nth-child(2) > div.row > button")
	public WebElement createNewCustomerNumberButton;

	@FindBy(xpath = ".//*[@id='main-content']/div/div[6]/div[2]/div[1]/div/div[2]/button")
	public WebElement selectFirstAccountButton;

	@FindBy(css = "div.customerNumberTypeSelection > div:nth-child(1) > button")
	public WebElement IAmPurchasingForMyselfAsAnIndividualButton;

	@FindBy(css = "div#submit-btn > button")
	public WebElement confirmYourAddressContinueButton;

	@FindBy(xpath = ".//*[@id='description']/div[2]/h1")
	public WebElement arcGISDesktopBasicHeaderLabel;

	@FindBy(css = "#license1-label")
	public WebElement perpetualLink;

	@FindBy(css = "button#myButton")
	public WebElement addToCartButton;

	@FindBy(css = "span#cartItems")
	public WebElement cartCountText;

	@FindBy(xpath = "//*[@id='extension']/div[4]/div/div/div/div[9]/div/p/a")
	public WebElement arcGIS3DAnalystBuyNow;

	@FindBy(xpath = ".//*[@id='extension']/div[4]/div/div/div/div/div/p")
	public List<WebElement> assoicatedExtensions;

	@FindBy(xpath = ".//*[@id='extension']/div[4]/div/div/div/div[9]/div/p/a")
	public WebElement arcGIS3DAnalystaddToCart;
	
	@FindBy(xpath = ".//*[@id='license1-label']")
	public WebElement perpetualLicenseLabel;

	@FindBy(css = "label#extLicenseLabel2")
	public WebElement termButton;

	@FindBy(xpath = "//div[@class='js-modal modal-overlay  is-active']/div/div/p[2]/button")
	public WebElement arcGIS3DAnalystAddToCartFrame;

	@FindBy(xpath = ".//*[@id='exampleModal']/div/a")
	public WebElement arcGIS3DAnalystBuyNowPopUpCloseButton;

	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/div/ul/li[2]/a")
	public WebElement arcGISOnlineLink;

	@FindBy(css = "#children > div:nth-child(2) > div > div > div > div:nth-child(1) > div > h2")
	public WebElement arcGISOnlineFirstBuyNowHeaderLabel;

	@FindBy(xpath = ".//*[@id='addToCart']/div[1]/label[1]")
	public WebElement levelUser2;

	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[4]/a")
	public WebElement cartLink;

	@FindBy(css = "#cart > div:nth-child(12) > div")
	public List<WebElement> cartItemList;

	@FindBy(css = "span#checkout-text")
	public WebElement cartErrorMessage;

	@FindBy(xpath = "//*[@id='remove0']/p/a")
	public WebElement arcGIS3DAnalystTermLineRemoveLink;

	@FindBy(xpath = "//div[@id='recommond0-0']/div/p[3]/input[1]")
	public WebElement arcGISDesktopBasicNumberOfDaysInputArea;

	@FindBy(css = "#recommond0-0 > div > p:nth-child(4) > input.btn.btn-fill")
	public WebElement arcGISDesktopBasicNumberOfDaysAddToCartButton;

	@FindBy(xpath = "(//fieldset[@class='fieldset-radio'])[1]/label[2]/input")
	public WebElement arcGISDesktopBasicCreateNewSubscriptionRadioButton;

	@FindBy(xpath = "//div[@id='recommond0-0']/div/p[3]/input[2]")
	public WebElement arcGISOnlineLevel2NumberOfDaysInputArea;

	@FindBy(css = "fieldset.fieldset-radio > div > select")
	public List<WebElement> chooseExistingSubscriptionDropDownList;

	@FindBy(xpath = "(//select[@class='font-size-1'])[1]")
	public WebElement arcGISDesktopBasicSubscriptionDropDownList;

	@FindBy(xpath = "(//select[@class='font-size-1'])[1]/option[2]")
	public WebElement arcGISDesktopBasicSubscriptionDropDownFirstItem;

	@FindBy(xpath = "(//select[@class='font-size-1'])[2]")
	public WebElement Level2SubscriptionDropDownList;

	@FindBy(xpath = "(//select[@class='font-size-1'])[2]/option[2]")
	public WebElement Level2SubscriptionDropDownFirstItem;

	@FindBy(css = "button#checkout-button")
	public WebElement proceedToCheckoutButton;

	@FindBy(css = "ul#dr_breadcrumbTitles")
	public WebElement orderSummaryHeaderText;

	@FindBy(css = "#dr_cartTbl > tbody > tr:nth-child(1) > td.dr_productName > div > input")
	public WebElement arcGIS3DAnalystTCCheckbox;

	@FindBy(css = "#dr_cartTbl > tbody > tr:nth-child(2) > td.dr_productName > div > input")
	public WebElement arcGISDesktopBasicTCCheckbox;

	@FindBy(css = "#dr_cartTbl > tbody > tr:nth-child(3) > td.dr_productName > div > input")
	public WebElement level2UserTCCheckBox;

	@FindBy(css = "#dr_cartTbl > tbody > tr > td.dr_productName > div > input")
	public List<WebElement> orderItemsListSize;

	@FindBy(css = "input#cardSecurityCode")
	public WebElement cvvNumberInputArea;

	@FindBy(css = "input#vr_skipregistration")
	public WebElement skipRegistrationButton;

	@FindBy(css = "input#submitBottom")
	public WebElement verifyOrderBuyNowButton;

	@FindBy(css = "input#checkoutButton")
	public WebElement paymentDetailsContinueButton;

	@FindBy(css = "tr#dr_priceTotal > td.dr_price.dr_totals")
	public WebElement orderTotalLabel;

	@FindBy(css = "div #dr_confirmTbl > tbody > tr")
	public List<WebElement> verifyOrderDetailsList;

	@FindBy(css = "input#tosAccepted")
	public WebElement verifyOrderTCCheckBox;

	@FindBy(css = "input#submitBottom")
	public WebElement orderSubmitButton;

	@FindBy(css = "span#dr_orderNumber")
	public WebElement orderCompletedNumber;

	@FindBy(css = "div#dr_siteButtons > a")
	public WebElement viewInvoiceLink;

	@FindBy(css = "tr#dr_priceTotal > td.dr_price.dr_totals")
	public WebElement totalOrderAmountText;

	@FindBy(css = "div#dr_orderInformation > div > span.dr_orderTotal")
	public WebElement totalOrderAmountTextAfterOrderCompletion;

	@FindBy(css = "div#dr_siteButtons > input")
	public WebElement returnButton;

	@FindBy(css = "div#topperBannerContainer > h1")
	public WebElement myEsriHeaderText;

	@FindBy(xpath = "//*[@id='ProductInformation']/div[3]/div[2]/div[2]/table/tbody[1]/tr[1]/td[3]/button")
	public WebElement instructorLedTrainingVoucherGetStartedButton;
	
	@FindBy(xpath = "//*[@id='ProductInformation']/div[3]/div[2]/div[2]/table/tbody[1]/tr[1]/td[3]/button")
	public WebElement instructorLedTrainingVoucherHideButton;

	@FindBy(xpath = "//*[@id='ProductInformation']/div[3]/div[2]/div[2]/table/tbody[2]/tr[1]/td[3]/button")
	public WebElement level2UserGetStartedButton;

	@FindBy(xpath = "//*[@id='ProductInformation']/div[3]/div[2]/div[2]/table/tbody[3]/tr[1]/td[3]/button")
	public WebElement arcGISDesktopBasicGetStartedButton;

	@FindBy(xpath = "//table[@class='table table-plain table-gray table-bottom-border list-table has-child']/tbody")
	public List<WebElement> fullfilmentPageItemListSize;

	/**
	 * Initialize the PageObject for ecommerce web page
	 * 
	 * @param driver
	 */
	public EcommerceTrailCustomerPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}