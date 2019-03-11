package com.esri.support.modules.ecommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitOrderPageObjects {
	
	@FindBy(xpath=" //*[@id='esri-cookie-banner']/div/div/div[2]/a[2]")
	public WebElement acceptButton;
	
	@FindBy(xpath="//*[@id='navigation']/div/div[2]/nav/div/div/ul/li[1]/a")
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
	
	@FindBy(xpath = "//iframe[@id='oAuthFrame']")
	protected WebElement oAuthFrame;

	@FindBy(id = "user_username")
	protected WebElement usernameText;

	@FindBy(id = "user_password")
	protected WebElement passwordText;

	@FindBy(id = "signIn")
	protected WebElement signInButton;
	
	@FindBy(xpath = ".//*[@id='main-content']/div/div[6]/div[2]/div[1]/div/div[2]/button")
	public WebElement selectFirstAccountButton;
	
	@FindBy(css = "#main-content > div > div:nth-child(7) > div:nth-child(2) > div.row > button")
	public WebElement createNewCustomerButton;
	
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

	@FindBy(xpath = ".//*[@id='license2-label']")
	public WebElement termLicenseLabel;
	
	@FindBy(xpath = "//*[@id='createOrder']/div[12]/div/div[2]/button")
	public WebElement AlertOkay;
	
	@FindBy(xpath = ".//*[@id='myButton']")
	public WebElement addToCartButton;
	
	@FindBy(xpath="//*[@class='fieldset-radio']/label[2]")
	public WebElement submitPurchaseOrderOption;
	
	@FindBy(xpath="//*[@id='update0']/div/input")
	public WebElement submitPurchaseOrderQuantity;
	
	@FindBy(xpath="//*[@class='fieldset-radio']/label[1]")
	public WebElement CreditCardPayPalorWireTransfer;
	
	@FindBy(xpath="//*[@class='fieldset-radio']/label[1]/input")
	public WebElement CreditCardPayPalorWireTransferRadioButton;
	
	@FindBy(xpath="//*[@class='fieldset-radio']/label[2]/input")
	public WebElement submitPurchaseOrderRadioButton;
	
	@FindBy(xpath="//*[@class='error-description']/h2")
	public WebElement  CreditCardPayPalorWireTransferErrorPage;
	
	@FindBy(xpath="//*[@id='purchaseOrder-submit']")
	public WebElement agreeAndContinueButton;
	
	@FindBy(xpath="//*")
	public WebElement pageEnter;	
	
	@FindBy(xpath="//*[@id='createOrder']/div[4]/div/div[3]/p[2]/button")
	public WebElement estimatedSalesTaxIcon;
	
	@FindBy(xpath="//*[@id='createOrder']/div[9]/div")
	public WebElement estimatedSalesTaxPopup; 
	
	@FindBy(xpath="//*[@id='createOrder']/div[9]/div/h3")
	public WebElement estimatedSalesTaxLabel;
	
	@FindBy(xpath="//*[@id='createOrder']/div[9]/div/div/button")
	public WebElement okButton;
	
	@FindBy(xpath="//*[@id='POSteps']/div[2]/div[2]/div/h3/button")
	public WebElement endUserContactIcon;
	
	@FindBy(xpath="//*[@id='createOrder']/div[8]/div")
	public WebElement endUserContactPopup; 	
	
	@FindBy(xpath="//*[@id='createOrder']/div[8]/div/h3")
	public WebElement endUseContactLabel;
	
	@FindBy(xpath="//*[@id='createOrder']/div[8]/div/div/button")
	public WebElement endUserContactOkButton;
	
	@FindBy(xpath="//*[@id='POSteps']/div[2]/div[2]/div/p[1]")
	public WebElement endUserName;
	
	@FindBy(xpath="//*[@id='POSteps']/div[2]/div[2]/div/p[2]")
	public WebElement endUserEmailId;
	
	@FindBy(xpath="//*[@id='POSteps']/div[2]/div[2]/div/p[3]")
	public WebElement endUserPhoneNumber;
	
	@FindBy(xpath="//*[@id='POSteps']/div[3]/div[2]/div/p[1]")
	public WebElement endUserStreetAddress;
	
	@FindBy(xpath="//*[@id='POSteps']/div[3]/div[2]/div/p[3]")
	public WebElement endUserCity;
	
	@FindBy(xpath="//*[@id='POSteps']/div[3]/div[2]/div/p[4]")
	public WebElement endUserCountry;
	
	@FindBy(xpath="//*[@id='stepTwo']/div[3]/div/h3/input")
	public WebElement sameEndUserAddressCheckBox;
	
	@FindBy(xpath="//*[@id='stepTwo']/div[3]/div/h3")
	public WebElement sameEndUserAddressText;
	
	@FindBy(xpath ="//*[@id='stepOne']/div[2]/div[3]/p[2]")
	public WebElement purchaseorderno;
	
	@FindBy(xpath="//*[text()='Purchase Order Information']")
	public WebElement purchaseOrderInformationHeaderText;
		
	@FindBy(xpath="//*[@id='purchaseOrderNumber']")
	public WebElement purchaseOrderNumberText;
	
	@FindBy(xpath="//*[@class='fieldset-radio']/label[3]/input")
	public WebElement iAmTaxExemptRadioButton;
	
	@FindBy(xpath="//*[@id='taxAttachments']/div[1]/div/p/button")
	public WebElement attachFileButton;
	
	@FindBy(xpath = "//*[@id='taxFileUpload']")
	public WebElement uploadFilesLink;
	
	@FindBy(xpath="//*[@class='modifier-class table-striped']")
	public WebElement fileUploadedTable;
	
	@FindBy(xpath="//*[@id='taxAttachmentItems']/tr/td[1]")
	public WebElement uploadedFileName;
	
	@FindBy(xpath="//*[@id='reviewOrderBtn']")
	public WebElement reviewOrderButton;
	
	@FindBy(xpath="//*[@id='stepOne']/div[1]/h3/button")
	public WebElement reviewOrderEditLink;
	
	@FindBy(xpath="//*[@id='stepOne']/div[2]/div[2]/p[1]/button")
	public WebElement billToEditLink;
	
	@FindBy(xpath="//*[@id='stepOne']/div[2]/div[3]/p[1]/button")
	public WebElement purchaseToEditLink;
	
	@FindBy(xpath="//*[@id='agreeTerms']")
	public WebElement termsAndConditionCheckBox;
	
	@FindBy(xpath="//*[@id='createOrderSubmitBtn']")
	public WebElement submitOrderButton;
	
	@FindBy(xpath="//*[@id='createOrder']/div[7]/div[1]/div/div[1]/p")
	public WebElement thankYouText;
	
	@FindBy(xpath="//*[@id='createOrder']/div[7]/div[1]/div/div[1]/div/p[1]")
	public WebElement orderCompleteTextMessage;	
	
	@FindBy(xpath="//*[@id='dr_ShoppingCart']/div[1]/h1")
	public WebElement checkOutLabelText;
   
	@FindBy(xpath="//button[@class='esri-cookie__button']")
	public WebElement acceptcookies;	
	
	/**
	 * Initialize the PageObject for ecommerce web page
	 * 
	 * @param driver
	 */
	public SubmitOrderPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
