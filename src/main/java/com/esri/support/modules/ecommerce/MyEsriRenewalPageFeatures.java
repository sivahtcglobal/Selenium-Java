package com.esri.support.modules.ecommerce;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;

public class MyEsriRenewalPageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private MyEsriRenewalPageObjects myEsriRenewalPageObjects;
	private WebDriver driver;

	public MyEsriRenewalPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		this.driver = driver;
		this.myEsriRenewalPageObjects = new MyEsriRenewalPageObjects(driver);
	}

	/**
	 * Click SingIn functionalities
	 */
	public void clickSignIn() {
		scrollIntoViewByElement(myEsriRenewalPageObjects.signInLink);
		click(myEsriRenewalPageObjects.signInLink);
	}

	/**
	 * This method performs sign in action. After launching the url, page then
	 * switch to "OAuthframe" and pass the inputs of user name and password and
	 * click on "Sign in" button.
	 */
	public void signIn() {
		try {
			waitForPageToLoad(10);
    		driver.switchTo().frame(myEsriRenewalPageObjects.oAuthFrame);
			hoverMouseClick(myEsriRenewalPageObjects.usernameText);
			inputText(myEsriRenewalPageObjects.usernameText, "eCommRegression1");
			hoverMouseClick(myEsriRenewalPageObjects.passwordText);
			inputText(myEsriRenewalPageObjects.passwordText, "eCommRegression12035");
			Log.info("User Name is :" + inputDataMap.get(MyEsriUserPages.USERNAME));
			Log.info("Password is :" + inputDataMap.get(MyEsriUserPages.PASSWORD));
			hoverMouseClick(myEsriRenewalPageObjects.signInButton);
			driver.switchTo().defaultContent();
			Thread.sleep(10000);
		} catch (Exception e) {
			Log.info("Waited for singIn page to load", e);
		}
	}

	/**
	 * Select the customer for quick search
	 */

	public void selectCustomerFromQuickSearch() {
		waitForPageToLoad(10);
		try {
			Thread.sleep(10000);
			scrollIntoViewByElement(myEsriRenewalPageObjects.MyOrganizationsLink);
			click(myEsriRenewalPageObjects.MyOrganizationsLink);
			click(myEsriRenewalPageObjects.organizationListLink);
			click(myEsriRenewalPageObjects.quickSearchBox);
			inputText(myEsriRenewalPageObjects.quickSearchBox, "474747");
			scrollIntoViewByElement(myEsriRenewalPageObjects.customerSelectButton);
			click(myEsriRenewalPageObjects.customerSelectButton);
		} catch (Exception e) {
			Log.info("Waited for customer list page to load", e);
		}
	}
	/**
	 * Click Proceed Checkout button
	 */
	public void transactionsLink() {
		scrollIntoViewByElement(myEsriRenewalPageObjects.transactionsLink);
		click(myEsriRenewalPageObjects.transactionsLink);
	}/**
	 * Click Proceed Checkout button
	 */
	public void renewStorePurchasesButton() {
		scrollIntoViewByElement(myEsriRenewalPageObjects.renewStorePurchasesButton);
		click(myEsriRenewalPageObjects.renewStorePurchasesButton);
	}/**
	 * Click Proceed Checkout button
	 */
	public void licenseList() {
		scrollIntoViewByElement(myEsriRenewalPageObjects.licenseList);
		click(myEsriRenewalPageObjects.licenseList);
	}/**
	 * Click Proceed Checkout button
	 */
	public void nextButton() {
		scrollIntoViewByElement(myEsriRenewalPageObjects.nextButton);
		click(myEsriRenewalPageObjects.nextButton);
	}
	/**
	 * Renew store purchase
	 */
	public void renewStorePurchase() {		
			waitForPageToLoad(30);
			scrollIntoViewByElement(myEsriRenewalPageObjects.transactionsLink);
			click(myEsriRenewalPageObjects.transactionsLink);
			waitForPageToLoad(30);						
			click(myEsriRenewalPageObjects.renewStorePurchasesButton);
			waitForPageToLoad(30);
		/*	if (isElementAvailable(myEsriRenewalPageObjects.acceptButton)) {
				clickAfterScroll(myEsriRenewalPageObjects.acceptButton);
			} else {
				Log.info("Manage Cookie Settings Is Not Avaialble");
			}*/
			scrollIntoViewByElement(myEsriRenewalPageObjects.licenseList);		
			click(myEsriRenewalPageObjects.licenseList);	
			waitForPageToLoad(10);
			scrollIntoViewByElement(myEsriRenewalPageObjects.nextButton);
			click(myEsriRenewalPageObjects.nextButton);		
			/*hoverMouseClick(myEsriRenewalPageObjects.proceedToCheckOutButton);
			if(isElementAvailable(myEsriRenewalPageObjects.proceedToCheckOutButton)) {
			hoverMouseClick(myEsriRenewalPageObjects.proceedToCheckOutButton);
			}else{
				Log.info("Proceed to check out another is not available");
			}*/
			
	}
	/**
	 * Click Proceed Checkout button
	 */
	public void proceedCheckout() {
		waitForPageToLoad(35);
		scrollIntoViewByElement(myEsriRenewalPageObjects.proceedToCheckOutButton);
		click(myEsriRenewalPageObjects.proceedToCheckOutButton);
	}
	/**
	 * Click Transaction link for Auto Renewal
	 */
	public void clickTransactionLink() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			Log.info("Page takes more time to load");
		}
		scrollIntoViewByElement(myEsriRenewalPageObjects.transactionsLink);
		click(myEsriRenewalPageObjects.transactionsLink);
		waitForPageToLoad(10);
		scrollIntoViewByElement(myEsriRenewalPageObjects.manageAutoRenewalsButton);
		click(myEsriRenewalPageObjects.manageAutoRenewalsButton);
		waitForPageToLoad(10);
	}

	/**
	 * Renew store purchase
	 * 
	 * @return boolean
	 */
	public boolean manageAutoRenewals() {
		boolean isButtonAvailableeStatus = false;
		if (!isElementAvailable(myEsriRenewalPageObjects.autoRenewalMessage)) {
			scrollIntoViewByElement(myEsriRenewalPageObjects.autoRenewalYesButton);
			click(myEsriRenewalPageObjects.autoRenewalYesButton);
			scrollIntoViewByElement(myEsriRenewalPageObjects.okButton);
			click(myEsriRenewalPageObjects.okButton);
			isButtonAvailableeStatus = true;
		}

		return isButtonAvailableeStatus;
	}

	/**
	 * Get Renewal Message
	 * 
	 * @return String
	 */
	public String getAutoRenewalMessage() {
		return getText(myEsriRenewalPageObjects.autoRenewalMessage);
	}

	/**
	 * Get Renewal Message
	 * 
	 * @return String
	 */
	public String getNoRecordFoundMessage() {
		return getText(myEsriRenewalPageObjects.noRecourdFoundMessage);
	}
}
