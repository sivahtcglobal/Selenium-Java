package com.esri.support.modules.ecommerce;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.esri.qa.reporting.Log;
import com.esri.support.modules.core.EcommerceConstants.Ecommerce;

public class SubmitOrderPageFeatures extends EcommerceCommonFeatures {

	private Map<String, String> inputDataMap;
	private SubmitOrderPageObjects submitOrderPageObjects;
	private WebDriver driver;

	public SubmitOrderPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver, inputDataMap);
		this.inputDataMap = inputDataMap;
		this.driver = driver;
		this.submitOrderPageObjects = new SubmitOrderPageObjects(driver);
	}

	/**
	 * Click the Product Header
	 */
	public void clickProducts() {		
		scrollIntoViewByElement(submitOrderPageObjects.productsHeaderLink);
		click(submitOrderPageObjects.productsHeaderLink);
	}

	/**
	 * Click ArcGIS Desktop Standard
	 */
	public void clickArgGISDesktopStandardBuyNow() {
		waitForPageToLoad(40);
		clickProducts();
		waitForPageToLoad(30);
		scrollIntoViewByElement(submitOrderPageObjects.arcGISDesktopLink);
		hoverMouseClick(submitOrderPageObjects.arcGISDesktopLink);
		waitForPageToLoad(45);
		scrollIntoViewByElement(submitOrderPageObjects.standardBuyNowButton);
		click(submitOrderPageObjects.standardBuyNowButton);
	}

	/**
	 * Get the header text
	 */
	public String getHeaderText() {
		return getText(submitOrderPageObjects.headeraNavigationPageText);

	}

	/**
	 * Click on sign In To See Price link under ArcGIS Desktop Standard
	 * 
	 * @return
	 */
	public void clickOnsignInToSeePrice() {		
		scrollIntoViewByElement(submitOrderPageObjects.signInToSeePriceLink);
		click(submitOrderPageObjects.signInToSeePriceLink);		
	}

	/**
	 * This method performs sign in action. After launching the url, click on
	 * sign in button at the top of the page, which navigates to "Esri Accounts"
	 * page then switch to "OAuthframe" and pass the inputs of username and
	 * password and click on "Sign in" button.
	 */
	public void signIn() {
		try {
			waitForPageToLoad();
			driver.switchTo().frame(submitOrderPageObjects.oAuthFrame);
			hoverMouseClick(submitOrderPageObjects.usernameText);
			inputText(submitOrderPageObjects.usernameText, inputDataMap.get(Ecommerce.USERNAME));
			hoverMouseClick(submitOrderPageObjects.passwordText);
			inputText(submitOrderPageObjects.passwordText, inputDataMap.get(Ecommerce.PASSWORD));
			Log.info("User Name is :" + inputDataMap.get(Ecommerce.USERNAME));
			Log.info("Password is :" + inputDataMap.get(Ecommerce.PASSWORD));
			hoverMouseClick(submitOrderPageObjects.signInButton);
			driver.switchTo().defaultContent();
			Thread.sleep(10000);
		} catch (Exception e) {
			Log.info("Waited for singIn page to load", e);
		}
	}

	/**
	 * Click on Create New Customer
	 */
	public void createNewCustomer() {
		waitForPageToLoad();
		if (isElementAvailable(submitOrderPageObjects.acceptButton)) {
			clickAfterScroll(submitOrderPageObjects.acceptButton);
		} else {
			Log.info("Manage Cookie Settings Is Not Available");
		}
		waitForPageToLoad(5);
		getText(submitOrderPageObjects.selectFirstAccountButton);
		scrollToBottom();
		scrollIntoViewByElement(submitOrderPageObjects.createNewCustomerButton);
		click(submitOrderPageObjects.createNewCustomerButton);
	}

	/**
	 * Click on behalf of organization
	 */
	public void clickOnBehalfofOrganization() {
		scrollIntoViewByElement(submitOrderPageObjects.behalfofOrganizationButton);
		click(submitOrderPageObjects.behalfofOrganizationButton);
	}

	/**
	 * Enter the Required Address Details
	 */
	public void fillRequiredAddressDetails() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Log.info(dateFormat.format(date)); // 2016/11/16 12:08:43
		String sOrganizationName = inputDataMap.get(Ecommerce.REGRESSION_ORGANIZATION) + dateFormat.format(date);
		Log.info("sOrganizationName::" + sOrganizationName);
		inputText(submitOrderPageObjects.organizationNameTextBox, sOrganizationName);
		inputText(submitOrderPageObjects.streetAddressTextBox, inputDataMap.get(Ecommerce.STREET_ADDRESS));
		inputText(submitOrderPageObjects.cityTextBox, inputDataMap.get(Ecommerce.CITY));
		selectByIndex(submitOrderPageObjects.stateDropDown, Integer.parseInt(inputDataMap.get(Ecommerce.STATE)));
		inputText(submitOrderPageObjects.postalCodeTextBox, inputDataMap.get(Ecommerce.POSTAL_CODE));
		scrollIntoViewByElement(submitOrderPageObjects.continueButton);
		click(submitOrderPageObjects.continueButton);
		waitForPageToLoad(30);
	}

	/**
	 * Click term license
	 */
	public void clickTermLicense() {
		click(submitOrderPageObjects.termLicenseLabel);
		click(submitOrderPageObjects.addToCartButton);
	}

	/**
	 * Submit Purchase Order Option
	 * 
	 * @return String
	 */
	public String submitPurchaseOrderOption() {
		return getText(submitOrderPageObjects.submitPurchaseOrderOption);
	}

	/**
	 * CreditCardPayPalorWireTransfer Option
	 * 
	 * @return String
	 */
	public String CreditCardPayPalorWireTransferOption() {

		return getText(submitOrderPageObjects.CreditCardPayPalorWireTransfer);
	}

	/**
	 * CreditCardPayPalorWireTransfer ErrorPage
	 * 
	 * @return String
	 */
	public boolean CreditCardPayPalorWireTransferError() {
		boolean isCredit = false;
		if (getTitle().contains("Checkout")) {
			isCredit = true;
		} else {
			isCredit = false;
		}
		return isCredit;
	}

	/**
	 * Submit Purchase Order Option
	 * 
	 * @return String
	 */
	public boolean isSubmitPurchaseOrderOptionAvailabe() {
		boolean isSubmitStatus = false;
		if (isElementAvailable(submitOrderPageObjects.submitPurchaseOrderOption)) {
			isSubmitStatus = true;
		} else {
			isSubmitStatus = false;
		}
		return isSubmitStatus;
	}

	/**
	 * Click submit purchase order option
	 */
	public void selectSubmitPurchaseOrder() {
		click(submitOrderPageObjects.submitPurchaseOrderRadioButton);
		waitForPageToLoad();
	}

	/**
	 * Quantity increase
	 */
	public void quantityincrease() {
		click(submitOrderPageObjects.submitPurchaseOrderQuantity);
		waitForPageToLoad();
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		myExecutor.executeScript("arguments[0].value='2';", submitOrderPageObjects.submitPurchaseOrderQuantity);
		waitForPageToLoad();
		hitEnter(submitOrderPageObjects.submitPurchaseOrderQuantity);		
	}

	/**
	 * Click CreditCardPayPalorWireTransfer option
	 */
	public void selectCreditCardPayPalorWireTransfer() {
		click(submitOrderPageObjects.CreditCardPayPalorWireTransferRadioButton);
		waitForPageToLoad();
	}

	/**
	 * Click Agree and Continue Button
	 */
	public void clickAgreeAndContinue() {
		click(submitOrderPageObjects.agreeAndContinueButton);
		waitForPageToLoad();
	}

	/**
	 * Click estimated sales tax icon
	 */
	public void estimatedSalesTaxIcon() {	
		scrollIntoViewByElement(submitOrderPageObjects.estimatedSalesTaxIcon);
		click(submitOrderPageObjects.estimatedSalesTaxIcon);
	}
			

	/**
	 * Click ok button
	 */
	public void clickOkButton() {
		click(submitOrderPageObjects.okButton);
	}

	/**
	 * Click end user contact information icon
	 */
	public void endUserContactLabelIcon() {
		waitForPageToLoad(45);
		scrollIntoViewByElement(submitOrderPageObjects.endUserContactIcon);
		click(submitOrderPageObjects.endUserContactIcon);
		
	}

	/**
	 * Click ok button for endUser contact
	 */
	public void clickOkButtonForEndUserContact() {
		click(submitOrderPageObjects.endUserContactOkButton);
	}

	/**
	 * Get end user name
	 */
	public String getEndUserName() {
		return getText(submitOrderPageObjects.endUserName);
	}

	/**
	 * Get end user email Id
	 */
	public String getEndUserEmailId() {
		return getText(submitOrderPageObjects.endUserEmailId);
	}

	/**
	 * Get end user phone number
	 */
	public String getEndUserPhoneNumber() {
		return getText(submitOrderPageObjects.endUserPhoneNumber);
	}

	/**
	 * Get end user street address
	 */
	public String getEndUserStreetAddress() {
		return getText(submitOrderPageObjects.endUserStreetAddress);
	}

	/**
	 * Get end user country
	 */
	public String getEndUserCountry() {
		return getText(submitOrderPageObjects.endUserCountry);
	}

	/**
	 * Get the Same End User Address Text
	 */
	public String getSameEndUserAddressText() {
		return getText(submitOrderPageObjects.sameEndUserAddressText);
	}

	/**
	 * Get the Purchase Order number
	 */
	public String getPurchaseorderno() {
		return getText(submitOrderPageObjects.purchaseorderno);
	}

	public String getPurchaseeditorderno() {
		return getAttribute(submitOrderPageObjects.purchaseOrderNumberText, "value");
	}

	/**
	 * Click same as end user address check box
	 */
	public void clickSameEndUserAddress() {
		click(submitOrderPageObjects.sameEndUserAddressCheckBox);
	}

	/**
	 * Get the Same End User Address Text
	 */
	public String getPurchaseOrderInformationHeaderText() {
		return getText(submitOrderPageObjects.purchaseOrderInformationHeaderText);
	}

	/**
	 * Enter purchase order number
	 */
	public void enterPurchaseOrderNumber() {
		inputText(submitOrderPageObjects.purchaseOrderNumberText, "001");
		click(submitOrderPageObjects.iAmTaxExemptRadioButton);
	}

	/**
	 * Check Attach files button available or not
	 */
	public boolean isAttachFilesButtonAvailable() {
		return isElementAvailable(submitOrderPageObjects.attachFileButton);
	}

	/**
	 * Attach file
	 */
	public void attachFile() {
		String filepath = Ecommerce.USER_DIR + Ecommerce.RESOURCE_FOLDER_PATH + inputDataMap.get(Ecommerce.FILE_NAME);
		submitOrderPageObjects.uploadFilesLink.sendKeys(filepath);
		waitForPageToLoad();
	}

	/**
	 * Attach invalidfile
	 */
	public void attachinvalidFile() {
		
		String filepath = Ecommerce.USER_DIR + Ecommerce.RESOURCE_FOLDER_PATH + inputDataMap.get(Ecommerce.FILE_NAME2);
		submitOrderPageObjects.uploadFilesLink.sendKeys(filepath);
		waitForPageToLoad();
	}

	/**
	 * Verify uploaded file name
	 */
	public String verifyUploadedFileName() {
		String sFileName = null;
		if (isElementAvailable(submitOrderPageObjects.fileUploadedTable)) {
			sFileName = getText(submitOrderPageObjects.uploadedFileName);
		}
		return sFileName;
	}

	/**
	 * Click Review Order Button
	 */
	public void clickReviewOrderButton() {
		click(submitOrderPageObjects.reviewOrderButton);
		waitForPageToLoad();
	}

	/**
	 * Click Review Order Edit Link
	 */
	public void clickReviewOrderEditLink() {
		click(submitOrderPageObjects.reviewOrderEditLink);
	}

	/**
	 * Click Review Order Edit Link
	 */
	public void clickBillToEditLink() {
		click(submitOrderPageObjects.billToEditLink);
	}

	/**
	 * Click Review Order Edit Link
	 */
	public void clickPurchaseToEditLink() {
		click(submitOrderPageObjects.purchaseToEditLink);
	}

	/**
	 * Click Review Order Edit Link
	 */
	public void clickTermAndCondition() {
		click(submitOrderPageObjects.termsAndConditionCheckBox);
	}

	/**
	 * Check Attach files button available or not
	 */
	public boolean isSubmitOrderButtonAvailable() {
		return isElementAvailable(submitOrderPageObjects.submitOrderButton);
	}

	/**
	 * Click Review Order Edit Link
	 */
	public String clickSubmitOrder() {
		click(submitOrderPageObjects.submitOrderButton);
		waitForPageToLoad();
		return getText(submitOrderPageObjects.thankYouText);
	}

	/**
	 * Retrieve order complete text message
	 */
	public String orderCompleteTextMessage() {
		return getText(submitOrderPageObjects.orderCompleteTextMessage);
	}

	/**
	 * Click Review Order Edit Link
	 */
	public void FileUploadAlertokay() {
		click(submitOrderPageObjects.AlertOkay);
	}

	/**
	 * Get Current Url
	 */
	public String getcurrrentUrl() {
		String sUrl = getDriver().getCurrentUrl();
		Log.info("Current Url" + sUrl);
		return sUrl;
	}
	/**
	 * Accept cookies
	 * @return 
	 */
	public boolean isAcceptCookiesAvailable() {
		boolean cookies = false;
		if(isElementAvailable(submitOrderPageObjects.acceptcookies)){
			cookies = true;
		} else {
			cookies = false;
		}
		return cookies;
	}

	/**
	 * Accept cookies
	 * @return 
	 */
	public void clickAcceptCookies() {
		click(submitOrderPageObjects.acceptcookies);
	}
	
	/**
	 *  Accept cookies text
	 */
	public String acceptCookiestext() {
		return getText(submitOrderPageObjects.acceptcookies);
	}
}
