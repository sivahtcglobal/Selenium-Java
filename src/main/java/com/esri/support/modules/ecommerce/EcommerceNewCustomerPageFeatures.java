package com.esri.support.modules.ecommerce;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.reporting.Log;
import com.esri.support.modules.core.EcommerceConstants.Ecommerce;

public class EcommerceNewCustomerPageFeatures extends EcommerceCommonFeatures {

	private Map<String, String> inputDataMap;
	private EcommerceNewCustomerPageObjects ecommerceNewCustomerPageObjects;

	public EcommerceNewCustomerPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver, inputDataMap);
		this.inputDataMap = inputDataMap;
		this.ecommerceNewCustomerPageObjects = new EcommerceNewCustomerPageObjects(driver);
	}

	/**
	 * Click on Create New Customer
	 */
	public void createNewCustomer() {
		waitForPageToLoad();
		if (isElementAvailable(ecommerceNewCustomerPageObjects.acceptButton)) {
			clickAfterScroll(ecommerceNewCustomerPageObjects.acceptButton);
		} else {
			Log.info("Manage Cookie Settings Is Not Avaialble");
		}
		getText(ecommerceNewCustomerPageObjects.selectFirstAccountButton);
		scrollToBottom();
		scrollIntoViewByElement(ecommerceNewCustomerPageObjects.createNewCustomerButton);
		click(ecommerceNewCustomerPageObjects.createNewCustomerButton);
	}

	/**
	 * Click on behalf of organization
	 */
	public void clickOnBehalfofOrganization() {
		scrollIntoViewByElement(ecommerceNewCustomerPageObjects.behalfofOrganizationButton);
		click(ecommerceNewCustomerPageObjects.behalfofOrganizationButton);
	}

	/**
	 * Enter the Required Address Details
	 */
	public void fillRequiredAddressDetails() {
		inputText(ecommerceNewCustomerPageObjects.organizationNameTextBox, Ecommerce.ORGANIZATION);
		inputText(ecommerceNewCustomerPageObjects.streetAddressTextBox, inputDataMap.get(Ecommerce.STREET_ADDRESS));
		inputText(ecommerceNewCustomerPageObjects.cityTextBox, inputDataMap.get(Ecommerce.CITY));
		selectByIndex(ecommerceNewCustomerPageObjects.stateDropDown,
				Integer.parseInt(inputDataMap.get(Ecommerce.STATE)));
		inputText(ecommerceNewCustomerPageObjects.postalCodeTextBox, inputDataMap.get(Ecommerce.POSTAL_CODE));
		scrollIntoViewByElement(ecommerceNewCustomerPageObjects.continueButton);
		click(ecommerceNewCustomerPageObjects.continueButton);
		waitForPageToLoad(30);
	}
	
	/**
	 * Click the Product Header
	 */
	public void clickProducts(){
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			Log.info("Not able to click the element due to : " + e);
		}
		scrollIntoViewByElement(ecommerceNewCustomerPageObjects.productsHeaderLink);
		hoverMouseClick(ecommerceNewCustomerPageObjects.productsHeaderLink);	
		
	}

	/**
	 * Click on ArcGIS Online and Add the items to list
	 */
	public void clickArcGISOnlineAddItemsToCart() {
		clickProducts();
		waitForPageToLoad(10);
		click(ecommerceNewCustomerPageObjects.arcGISOnlineHeaderLink);
		waitForPageToLoad(30);
		scrollIntoViewByElement(ecommerceNewCustomerPageObjects.serviceCreditsBuyNowButton);
		click(ecommerceNewCustomerPageObjects.serviceCreditsBuyNowButton);
		waitForPageToLoad(30);
		scrollIntoViewByElement(ecommerceNewCustomerPageObjects.addToCartButton);
		click(ecommerceNewCustomerPageObjects.addToCartButton);
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			Log.error("Not able to click the element due to : " + e);
		}
	}

	/**
	 * Check Whether GoToCart Button Available or not
	 * 
	 * @return boolean
	 */
	public boolean isGoToCartAvailable() {
		return isElementAvailable(ecommerceNewCustomerPageObjects.goToCartLink);
	}

	/**
	 * Click on ArcGIS Developer Subscription and Add the items to list
	 */
	public void clickOnArcGISDeveloperSubscription() {
		clickProducts();		
		hoverMouseClick(ecommerceNewCustomerPageObjects.arcGISDeveloperSubscriptionHeaderLink);
		scrollIntoViewByElement(ecommerceNewCustomerPageObjects.professionalBuyNowButton);
		hoverMouseClick(ecommerceNewCustomerPageObjects.professionalBuyNowButton);
	}

	public void clickArcGISForPersonalUse(){
		clickProducts();		
		waitForPageToLoad(10);
		click(ecommerceNewCustomerPageObjects.arcGISPersonalUseLink);
		waitForPageToLoad(30);
		scrollIntoViewByElement(ecommerceNewCustomerPageObjects.arcGISPersonalUseBuyNowButton);
		click(ecommerceNewCustomerPageObjects.arcGISPersonalUseBuyNowButton);
		waitForPageToLoad(30);
		click(ecommerceNewCustomerPageObjects.arcGISPersonalUseManualRenewal);
		waitForPageToLoad(20);
		scrollIntoViewByElement(ecommerceNewCustomerPageObjects.addToCartButton);
		click(ecommerceNewCustomerPageObjects.addToCartButton);
	}
	/**
	 * Validate the Header Text
	 * 
	 * @return
	 */
	public boolean isDeveloperHeaderAvailable() {
		boolean status = false;
		if (getText(ecommerceNewCustomerPageObjects.productContentHeaderText)
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCGIS_DEVELOPER_PROFESSIONAL))) {
			status = true;
		}
		return status;
	}

	/**
	 * Click Go To Cart
	 */
	public void clickGoToCart() {
		inputText(ecommerceNewCustomerPageObjects.quantityInputArea, Ecommerce.ARCGIS3DANALYST_CART_ITEM_COUNT);
		hitEnter(ecommerceNewCustomerPageObjects.quantityInputArea);
		click(ecommerceNewCustomerPageObjects.goToCartButton);
	}

	/**
	 * Get the List of Cart Items
	 * 
	 * @return int
	 */
	public int getCartItemsCount() {
		return getSize(ecommerceNewCustomerPageObjects.cartItemsList);
	}

	/**
	 * Remove the credit service line items
	 */
	public void removeCreditsLineItem() {
		scrollIntoViewByElement(ecommerceNewCustomerPageObjects.removeCreditLineLink);
		click(ecommerceNewCustomerPageObjects.removeCreditLineLink);
	}

	/**
	 * Check whether the offer image is available or not
	 * 
	 * @return boolean
	 */
	public boolean isILTOfferImageAvailable() {
		return isElementAvailable(ecommerceNewCustomerPageObjects.hideOfferButton);
	}

	/**
	 * Click Add To Cart for ILT offer
	 */
	public void clickAddToCartForILTOffer() {
		scrollIntoViewByElement(ecommerceNewCustomerPageObjects.iltAddToCartButton);
		click(ecommerceNewCustomerPageObjects.iltAddToCartButton);
	}

	/**
	 * Check whether show offer is available
	 * 
	 * @return boolean
	 */
	public boolean isOfferImageHidden() {
		return isElementAvailable(ecommerceNewCustomerPageObjects.showOfferButton);
	}

	/**
	 * Click Show Offer
	 */
	public void clickShowOffer() {
		scrollIntoViewByElement(ecommerceNewCustomerPageObjects.showOfferButton);
		click(ecommerceNewCustomerPageObjects.showOfferButton);
	}

	/**
	 * Click on Terms And Condition
	 */
	public void clickOnTermsAndCondition() {
		clickOnTermsAndConditionChekBox();
		clickOnTermsAndConditionForTrainingVocher();
	}

	/**
	 * Check for Error Message of ArcGIS Online Service Credits
	 */
	
	public boolean isServiceCreditsErrorMessageDisplayed(){		
		return isElementAvailable(ecommerceNewCustomerPageObjects.serviceCreditsErrorMessage); 
	}
}
