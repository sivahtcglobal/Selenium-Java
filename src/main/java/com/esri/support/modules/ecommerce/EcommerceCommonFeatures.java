package com.esri.support.modules.ecommerce;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.config.Env;
import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.EcommerceConstants.Ecommerce;

public class EcommerceCommonFeatures extends PageObjects {

	private EcommerceCommonPageObjects commonObjects;
	private Map<String, String> inputDataMap;
	public String baseUrl;

	public EcommerceCommonFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		this.commonObjects = new EcommerceCommonPageObjects(driver);
	}

	/**
	 * This method launches the esri url.
	 */
	public void openBaseURL() {
		try {
			switch (inputDataMap.get(Ecommerce.TESTENVIRONMENT)) {
			case Ecommerce.ECOMMERCEUS:
				baseUrl = Env.get("ECOMMERCEUS");
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCEUS")));
				break;
			case Ecommerce.ECOMMERCEAUSTRALIA:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCEAUSTRALIA")));
				baseUrl = Env.get("ECOMMERCEAUSTRALIA");
				break;
			case Ecommerce.ECOMMERCEUK:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCEUK")));
				baseUrl = Env.get("ECOMMERCEUK");
				break;
			case Ecommerce.ECOMMERCEDENMARK:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCEDENMARK")));
				baseUrl = Env.get("ECOMMERCEDENMARK");
				break;
			case Ecommerce.ECOMMERCESWEDEN:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCESWEDEN")));
				baseUrl = Env.get("ECOMMERCESWEDEN");
				break;
			case Ecommerce.ECOMMERCEPANAMAENGLISH:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCEPANAMAENGLISH")));
				baseUrl = Env.get("ECOMMERCEPANAMAENGLISH");
				break;
			case Ecommerce.ECOMMERCEPANAMASPANISH:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCEPANAMASPANISH")));
				baseUrl = Env.get("ECOMMERCEPANAMASPANISH");
				break;
			case Ecommerce.ECOMMERCEGERMANYENGLISH:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCEGERMANYENGLISH")));
				baseUrl = Env.get("ECOMMERCEGERMANYENGLISH");
				break;
			case Ecommerce.ECOMMERCEGERMANYGERMAN:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCEGERMANYGERMAN")));
				baseUrl = Env.get("ECOMMERCEGERMANYGERMAN");
				break;
			case Ecommerce.ECOMMERCECOLOMBIAENGLISH:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCECOLOMBIAENGLISH")));
				baseUrl = Env.get("ECOMMERCECOLOMBIAENGLISH");
				break;
			case Ecommerce.ECOMMERCECOLOMBIASPANISH:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCECOLOMBIASPANISH")));
				baseUrl = Env.get("ECOMMERCECOLOMBIASPANISH");
				break;
			case Ecommerce.ECOMMERCEROMANIAEURO:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCEROMANIAEURO")));
				baseUrl = Env.get("ECOMMERCEROMANIAEURO");
				break;
			case Ecommerce.ECOMMERCEFRANCEEURO:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCEFRANCEEURO")));
				baseUrl = Env.get("ECOMMERCEFRANCEEURO");
				break;
			case Ecommerce.ECOMMERCESWITZERLANDENGLISH:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCESWITZERLANDENGLISH")));
				baseUrl = Env.get("ECOMMERCESWITZERLANDENGLISH");
				break;
			case Ecommerce.ECOMMERCESWITZERLANDFRENCH:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCESWITZERLANDFRENCH")));
				baseUrl = Env.get("ECOMMERCESWITZERLANDFRENCH");
				break;
			case Ecommerce.ECOMMERCESWITZERLANDGERMAN:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCESWITZERLANDGERMAN")));
				baseUrl = Env.get("ECOMMERCESWITZERLANDGERMAN");
				break;
			case Ecommerce.ECOMMERCECANADAENGLISH:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCECANADAENGLISH")));
				baseUrl = Env.get("ECOMMERCECANADAENGLISH");
				break;
			case Ecommerce.ECOMMERCECANADAFRENCH:
				super.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCECANADAFRENCH")));
				baseUrl = Env.get("ECOMMERCECANADAFRENCH");
				break;
			}
		} catch (Exception ex) {
			Log.error("TestEnvironment" + " is not available. ", ex);
		}
	}

	/**
	 * Get the price details with the currency
	 * 
	 * @return String
	 */
	public String getCurrentEnvironment() {
		return baseUrl;
	}

	/**
	 * Click on cookies popup
	 */
	public void clickOnCookiesPopup() {
		waitForPageToLoad(35);
		if (isElementAvailable(commonObjects.acceptCookiesButtonNow)) {
			click(commonObjects.acceptCookiesButtonNow);
		} else {
			Log.info("Accept Cookies popup is not available");
		}
	}

	/**
	 * Click on Cart header link
	 */
	public void clickOnCart() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			Log.info("Waiting for pop up to close" + e);
		}
		scrollIntoViewByElement(commonObjects.cartButton);
		click(commonObjects.cartButton);
	}

	/**
	 * Click on create new subscription
	 */
	public void clickOnCreateNewSubscription() {
		if (isElementAvailable(commonObjects.createNewSubscriptionButton)) {
			scrollIntoViewByElement(commonObjects.createNewSubscriptionButton);
			click(commonObjects.createNewSubscriptionButton);
		} else {
			Log.info("Create New Subscription option not avaialble");
		}
	}

	/**
	 * Click on proceed to checkout
	 * 
	 * @return totalAmount
	 */
	public String retrievePriceAndClickonProceedToCheckout() {
		String totalAmount = getText(commonObjects.cartTotalAmountText);
		scrollIntoViewByElement(commonObjects.proceedToCheckOutButton);
		click(commonObjects.proceedToCheckOutButton);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			Log.info("Waiting for checkout to load" + e);
		}
		return totalAmount;
	}

	/**
	 * Get the price details with the currency
	 * 
	 * @return String
	 */
	public String retrievePriceDetails() {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			Log.error("Not able retrievePriceDetails : " + e);
		}
		return getText(commonObjects.priceDetailsInCheckoutText);
	}

	/**
	 * Select first check box for terms and conditions
	 */
	public void clickOnTermsAndConditionChekBox() {
		scrollIntoViewByElement(commonObjects.licenseCheckBox);
		click(commonObjects.licenseCheckBox);
	}

	/**
	 * Select first check box for terms and conditions
	 */
	public void clickOnTermsAndConditionForTrainingVocher() {
		if (isElementAvailable(commonObjects.licenseTraingVocherCheckBox)) {
			scrollIntoViewByElement(commonObjects.licenseTraingVocherCheckBox);
			click(commonObjects.licenseTraingVocherCheckBox);
		} else {
			Log.info("Terms And Condition For Training Vocher Not Available");
		}
	}

	/**
	 * Click on license Agreement link Esri / Legal page will open in a new Tab
	 */
	public void clickOnLicenseAgreement() {
		scrollIntoViewByElement(commonObjects.licenseAgreementLink);
		click(commonObjects.licenseAgreementLink);
		switchToChildWindow(1);
		switchToParentWindow(1);
	}

	/**
	 * Retrieve the reference number
	 * 
	 * @return referanceNumber
	 */
	public String retrieveReferanceNumber() {
		String referanceNumber = null;
		referanceNumber = getText(commonObjects.referenceNumber);
		String[] refNum = referanceNumber.split(":");
		referanceNumber = refNum[1];
		return referanceNumber;
	}

	/**
	 * Enter the payment information
	 */
	public void enterPaymentInformation() {
		if (inputDataMap.get(Ecommerce.TEST_DESCRIPTION).equals(Ecommerce.GERMAN_GERMAN_EURO_CURRENCY)) {
			selectByIndex(commonObjects.paymentOptionDropDown, 0);
			inputText(commonObjects.cNickNameTextBox, Ecommerce.PAYMENT_METHOD_NAME);
		} else {
			selectByIndex(commonObjects.paymentOptionDropDown, 1);
		}
		inputText(commonObjects.creditCardNumberTextBox, Ecommerce.CREDIT_CARD_NUMBER);
		selectByValue(commonObjects.expirationDateOfMonthDropDown, Ecommerce.EXPIRATION_DATE_OF_MONTH);
		selectByValue(commonObjects.expirationDateOfYearDropDown, Ecommerce.EXPIRATION_DATE_OF_YEAR);
		inputText(commonObjects.cardSecurityCodeTextBox, Ecommerce.CARD_SECURITY_CODE);
	}

	/**
	 * If country not selected error message occurs ,select the country and then
	 * click continue to verify the order
	 * 
	 * @return Reference Number
	 */
	public String clickContinueToViewOrder() {
		checkForSateDropDown();
		scrollIntoViewByElement(commonObjects.continueCheckOutButton);
		click(commonObjects.continueCheckOutButton);
		checkAddressPopUpMessage();
		if (isElementAvailable(commonObjects.countryErrorMessageText)
				|| isElementAvailable(commonObjects.swizCountryErrorMessageText)) {
			scrollIntoViewByElement(commonObjects.countryDropDown);
			click(commonObjects.countryDropDown);
			scrollIntoViewByElement(commonObjects.countryDropDownValue);
			click(commonObjects.countryDropDownValue);
			scrollIntoViewByElement(commonObjects.continueCheckOutButton);
			click(commonObjects.continueCheckOutButton);
		} else {
			Log.info("Country already selected from drop down for this country");
		}
		// click(commonObjects.continueCheckOutButton);
		// checkAddressPopUpMessage();
		// checkVATRegistrationPage();
		// click(commonObjects.continueCheckOutButton);
		waitForPageToLoad(40);
		return retrieveReferanceNumber();
	}

	/**
	 * Check For State Drop Down
	 */
	private void checkForSateDropDown() {
		if (inputDataMap.get(Ecommerce.TEST_DESCRIPTION).equals(Ecommerce.CANADA_ENGLISH_CAD_CURRENCY)
				|| inputDataMap.get(Ecommerce.TEST_DESCRIPTION).equals(Ecommerce.CANADA_FRENCH_CAD_CURRENCY)
				|| inputDataMap.get(Ecommerce.TEST_DESCRIPTION).equals(Ecommerce.SWIZ_GERMAN_CHF_CURRENCY)) {
			if (isElementAvailable(commonObjects.billingStateDropDown)) {
				scrollIntoViewByElement(commonObjects.billingStateDropDown);
				click(commonObjects.billingStateDropDown);
				click(commonObjects.billingStateDropDownValue);
			} else {
				Log.info("State drop down not available");
			}
		} else {
			if (inputDataMap.get(Ecommerce.TEST_DESCRIPTION).equals(Ecommerce.ROMANIA_EURO_CURRENCY)) {
				scrollIntoViewByElement(commonObjects.countryDropDown);
				click(commonObjects.countryDropDown);
				scrollIntoViewByElement(commonObjects.romaniaCountryDropDownValue);
				click(commonObjects.romaniaCountryDropDownValue);
			} else if (inputDataMap.get(Ecommerce.TEST_DESCRIPTION).equals(Ecommerce.COLOMBIA_ENGLISH_COP_CURRENCY)
					|| inputDataMap.get(Ecommerce.TEST_DESCRIPTION).equals(Ecommerce.COLOMBIA_SPANISH_COP_CURRENCY)) {
				scrollIntoViewByElement(commonObjects.countryDropDown);
				click(commonObjects.countryDropDown);
				scrollIntoViewByElement(commonObjects.colombiaCountryDropDownValue);
				click(commonObjects.colombiaCountryDropDownValue);
			} else if (inputDataMap.get(Ecommerce.TEST_DESCRIPTION).equals(Ecommerce.GERMANY_ENGLISH_EURO_CURRENCY)) {
				scrollIntoViewByElement(commonObjects.countryDropDown);
				click(commonObjects.countryDropDown);
				scrollIntoViewByElement(commonObjects.germanyCountryDropDownValue);
				click(commonObjects.germanyCountryDropDownValue);
			} else if (inputDataMap.get(Ecommerce.TEST_DESCRIPTION).equals(Ecommerce.PANAMA_ENGLISH_USD_CURRENCY)) {
				scrollIntoViewByElement(commonObjects.countryDropDown);
				click(commonObjects.countryDropDown);
				scrollIntoViewByElement(commonObjects.panamaCountryDropDownValue);
				click(commonObjects.panamaCountryDropDownValue);
			} else if (inputDataMap.get(Ecommerce.TEST_DESCRIPTION).equals(Ecommerce.SWIZ_ENGLISH_CHF_CURRENCY)) {
				scrollIntoViewByElement(commonObjects.countryDropDown);
				click(commonObjects.countryDropDown);
				scrollIntoViewByElement(commonObjects.swizCountryDropDownValue);
				click(commonObjects.swizCountryDropDownValue);
			}
		}
	}

	/**
	 * Check Address PopUp Message available if occurs,use selected option
	 */
	private void checkAddressPopUpMessage() {
		if (isElementAvailable(commonObjects.addressPopUp)) {
			scrollIntoViewByElement(commonObjects.useSelectedButton);
			click(commonObjects.useSelectedButton);
			Log.info("Billing Address Confirmation Pop Up Displayed");
			waitForPageToLoad(10);
		} else {
			Log.info("Billing Address Confirmation Pop Up Not Displayed");
		}
	}

	/**
	 * Check the verify order page contain the page title as EsriTest 1 online
	 * 
	 * @return boolean
	 */
	public boolean isViewOrderPageTitle() {
		boolean isPageTitleStatus = false;
		waitForPageToLoad();
		if (getTitle().contains(Ecommerce.ESRI_TEST_ONLINE)) {
			isPageTitleStatus = true;
		}
		return isPageTitleStatus;
	}

	/**
	 * Select the check box and click on submit order
	 */
	public String acceptTermsAndSubmitTheOrder() {
		String totalPriceInVerifyOrder = null;
		scrollIntoViewByElement(commonObjects.acceptedCheckBox);
		click(commonObjects.acceptedCheckBox);
		totalPriceInVerifyOrder = getText(commonObjects.totalPriceInCheckoutText);
		scrollIntoViewByElement(commonObjects.submitOrderButton);
		click(commonObjects.submitOrderButton);
		return totalPriceInVerifyOrder;
	}

	/**
	 * Retrieve the Order Number
	 * 
	 * @return orderNumber
	 */
	public String retrieveOrderNumber() {
		String orderNumber = null;
		isElementAvailable(commonObjects.orderNumber);
		orderNumber = getText(commonObjects.orderNumber);
		String[] orderNum = orderNumber.split(":");
		orderNumber = orderNum[1];
		return orderNumber;
	}

	/**
	 * Click View Invoice and return the total
	 * 
	 * @return String
	 */
	public String clickViewInvoiceAndRetrieveTotal() {
		scrollIntoViewByElement(commonObjects.viewInvoiceButton);
		click(commonObjects.viewInvoiceButton);
		return getText(commonObjects.totalPriceInInvoiceText);
	}

	/**
	 * Click Return Button
	 */
	public void clickReturn() {
		scrollIntoViewByElement(commonObjects.returnbutton);
		click(commonObjects.returnbutton);
	}

	/**
	 * Retrieve Thank you text
	 */
	public String retrieveThankYou() {
		return getText(commonObjects.thankYouText);
	}

	/**
	 * Form the URL to launch the fulfillment page
	 * 
	 * @return URL
	 */
	public void reviewFullfillmentPage() {
		String fulfillmentURL = Ecommerce.FULLFILLMENT_URL + retrieveOrderNumber();
		openURL(fulfillmentURL);
	}

	/**
	 * Retrieve the reference number from fulfillment page
	 * 
	 * @return String
	 */
	public String retrieveReferenceNumberFromFulfillment() {
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			Log.error("Not able retrievePriceDetails : " + e);
		}
		return getText(commonObjects.referenceNumberFromFulfillmentText);
	}

	/**
	 * Retrieve the customer number from fulfillment page
	 * 
	 * @return String
	 */
	public String retrieveCustomerNumberFromFulfillment() {
		return getText(commonObjects.customerNumberFromFulfillmentText);
	}

	/**
	 * Click on Get Started Button in fulfillment page
	 */
	public void clickOnGetStarted() {
		scrollIntoViewByElement(commonObjects.getStartedButton);
		click(commonObjects.getStartedButton);
	}

	/**
	 * Check Active Subscription Button available after click on Get Started
	 * 
	 * @return boolean
	 */
	public boolean isActiveSubscriptionAvailable() {
		return isElementAvailable(commonObjects.activeSubscriptionButton);
	}

	/**
	 * Check GoToDownload Button available after click on Get Started
	 * 
	 * @return boolean
	 */
	public boolean isGoToDownloadAvailable() {
		return isElementAvailable(commonObjects.gotoDownloadButton);
	}

	/**
	 * Check Active Subscription Button available after click on Get Started For
	 * DR Cart
	 * 
	 * @return boolean
	 */
	public boolean isActiveSubscriptionAvailableForDRCart() {
		return isElementAvailable(commonObjects.drCartActiveSubscriptionButton);
	}

	/**
	 * Check GoToDownload Button available after click on Get Started For DR
	 * Cart
	 * 
	 * @return boolean
	 */
	public boolean isGoToDownloadAvailableForDRCart() {
		return isElementAvailable(commonObjects.drCartGoToDownloadButton);
	}

	/**
	 * CheckGoToDownload Button available after click on Get Started in New
	 * Customer
	 * 
	 * @return boolean
	 */
	public boolean isGoToDownloadAvailableForNewCustomer() {
		return isElementAvailable(commonObjects.newCustomerGoToDownloadButton);
	}

	/**
	 * Check Active Subscription Button available after click on Get Started for
	 * Trail Customer
	 * 
	 * @return boolean
	 */
	public boolean isActiveSubscriptionAvailableForTrailCustomer() {
		return isElementAvailable(commonObjects.trailActiveSubscriptionButton);
	}

	/**
	 * Check GoToDownload Button available after click on Get Started for Trail
	 * Customer
	 * 
	 * @return boolean
	 */
	public boolean isGoToDownloadAvailableForTrailCustomer() {
		return isElementAvailable(commonObjects.trailGoToDownloadButton);
	}

}
