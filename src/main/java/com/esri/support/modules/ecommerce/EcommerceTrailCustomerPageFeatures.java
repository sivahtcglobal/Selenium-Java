package com.esri.support.modules.ecommerce;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.esri.qa.reporting.Log;
import com.esri.support.modules.core.EcommerceConstants.Ecommerce;

public class EcommerceTrailCustomerPageFeatures extends EcommerceCommonFeatures {

	private EcommerceTrailCustomerPageObjects ecommerceTrailCustomerPageObjects;
	private Map<String, String> inputDataMap;
	private WebDriver driver;
	
	public EcommerceTrailCustomerPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver, inputDataMap);
		this.inputDataMap = inputDataMap;
		this.driver =driver;
		this.ecommerceTrailCustomerPageObjects = new EcommerceTrailCustomerPageObjects(driver);
	}

	/**
	 * get the header list
	 * 
	 * @return String
	 */
	public String getPageTitle() {
		waitForPageToLoad();
		return getTitle();
	}

	/**
	 * Click on sign In To See Price link under ArcGIS Desktop Basic
	 * 
	 * @return boolean
	 */
	public boolean isDistributorLogoDisplayed() {
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.arcGISDesktopLink);
		click(ecommerceTrailCustomerPageObjects.arcGISDesktopLink);
		boolean logoDisplayed = false;
		if (isDisplayed(ecommerceTrailCustomerPageObjects.distributorLogo)) {
			logoDisplayed = true;
		} else {
			Log.error("Distributor logo is not displayed");
		}
		return logoDisplayed;
	}

	/**
	 * Click on sign In To See Price link under ArcGIS Desktop Basic
	 * 
	 * @return
	 */
	public void clickOnsignInToSeePrice() {
		clickProducts();
		waitForPageToLoad(10);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.arcGISDesktopLink);
		hoverMouseClick(ecommerceTrailCustomerPageObjects.arcGISDesktopLink);
		waitForPageToLoad(10);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.basicBuyNowButton);
		click(ecommerceTrailCustomerPageObjects.basicBuyNowButton);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.signInToSeePriceLink);
		click(ecommerceTrailCustomerPageObjects.signInToSeePriceLink);	
		waitForPageToLoad();
	}

	/**
	 * Click on Create new customer and will click on confirm your information
	 * continue
	 * 
	 * @return
	 */
	public void clickCreateNewCustomer() {
		waitForPageToLoad();
		String customer = null;
		getText(ecommerceTrailCustomerPageObjects.selectFirstAccountButton);
		customer = inputDataMap.get(Ecommerce.CUSTOMER);
		Log.info("customer" + customer);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.createNewCustomerNumberButton);
		click(ecommerceTrailCustomerPageObjects.createNewCustomerNumberButton);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.IAmPurchasingForMyselfAsAnIndividualButton);
		click(ecommerceTrailCustomerPageObjects.IAmPurchasingForMyselfAsAnIndividualButton);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.confirmYourAddressContinueButton);
		click(ecommerceTrailCustomerPageObjects.confirmYourAddressContinueButton);
	}
	
	/**
	 * Click the Product Header
	 */
	public void clickProducts(){
		waitForPageToLoad(10);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.productsHeaderLink);
		hoverMouseClick(ecommerceTrailCustomerPageObjects.productsHeaderLink);	
		
	}

	/**
	 * This method will return ArcGIS Desktop Basic Header Label
	 * 
	 * @return String
	 */
	public String retrieveArcGISDesktopBasicHeaderLabel() {
		try {
			Thread.sleep(7000);
		} catch (Exception e) {
			Log.info("The exception rcGISDesktopBasicHeader : " + e);
		}
		return getText(ecommerceTrailCustomerPageObjects.arcGISDesktopBasicHeaderLabel);
	}

	/**
	 * This method will perform click event for Add to cart under ArcGIS Desktop
	 * Basic and will return the cart count
	 * 
	 * @return String
	 */
	public String retrieveArcGISDesktopBasicCartCountText() {
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.perpetualLink);
		click(ecommerceTrailCustomerPageObjects.perpetualLink);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.addToCartButton);
		click(ecommerceTrailCustomerPageObjects.addToCartButton);
		try {
			Thread.sleep(7000);
		} catch (Exception e) {
			Log.error("The exception ArcGISDesktopBasicCartCount : " + e);
		}
		return getText(ecommerceTrailCustomerPageObjects.cartCountText);
	}

	/**
	 * This method will perform click event for Add to cart under ArcGIS 3D
	 * Analyst and will return the cart count
	 * 
	 * @return String
	 */
	public String retrieveArcGISDesktopBasicArcGIS3DAnalystCartCountText() {	
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				 ecommerceTrailCustomerPageObjects.arcGIS3DAnalystaddToCart);
         ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");
        click(ecommerceTrailCustomerPageObjects.arcGIS3DAnalystaddToCart);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.termButton);
		click(ecommerceTrailCustomerPageObjects.termButton);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.arcGIS3DAnalystAddToCartFrame);
		click(ecommerceTrailCustomerPageObjects.arcGIS3DAnalystAddToCartFrame);
		waitForPageToLoad();
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.arcGIS3DAnalystBuyNowPopUpCloseButton);
		click(ecommerceTrailCustomerPageObjects.arcGIS3DAnalystBuyNowPopUpCloseButton);
		return getText(ecommerceTrailCustomerPageObjects.cartCountText);
	}

	/**
	 * This method will return ArcGIS Online First Buy Now Header Label
	 * 
	 * @return String
	 */
	public String retrieveArcGISOnlineFirstBuyNowHeaderLabel() {
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			Log.error("The exception is : " + e);
		}
		 scrollToTop();
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				 ecommerceTrailCustomerPageObjects.arcGISOnlineLink);
         ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");
         clickProducts();
        click(ecommerceTrailCustomerPageObjects.arcGISOnlineLink);
        waitForPageToLoad();	
		return getText(ecommerceTrailCustomerPageObjects.arcGISOnlineFirstBuyNowHeaderLabel);
	}

	/**
	 * This method will perform click event for Add to cart under ArcGIS 3D
	 * Analyst and will return the cart count
	 * 
	 * @return String
	 */
	public String retrieveArcGISOnlineNamedUserCartCountText() {
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.basicBuyNowButton);
		click(ecommerceTrailCustomerPageObjects.basicBuyNowButton);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.levelUser2);
		click(ecommerceTrailCustomerPageObjects.levelUser2);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.addToCartButton);
		click(ecommerceTrailCustomerPageObjects.addToCartButton);
		return getText(ecommerceTrailCustomerPageObjects.cartCountText);
	}

	/**
	 * This method will perform click event on Add to cart and will return the
	 * cart error message
	 * 
	 * @return boolean
	 */
	public boolean isCartErrorMessageDisplayed() {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			Log.error("The exception is : " + e);
		}
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.cartLink);
		click(ecommerceTrailCustomerPageObjects.cartLink);
		boolean errorMessage = false;
		if (isElementAvailable(ecommerceTrailCustomerPageObjects.cartErrorMessage)) {
			errorMessage = true;
		}
		return errorMessage;
	}

	/**
	 * This method will return the list of item count in cart page
	 * 
	 * @return int
	 */
	public int retrieveCartItemCount() {
		return getSize(ecommerceTrailCustomerPageObjects.cartItemList);
	}

	/**
	 * This method remove 3D Analyst term from cart and will return the list of
	 * item count in cart page
	 * 
	 * @return String
	 */
	public String retrieveCartItemCountAfterRemovingArcGIS3DAnalyst() {
		waitForPageToLoad(10);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.arcGIS3DAnalystTermLineRemoveLink);
		click(ecommerceTrailCustomerPageObjects.arcGIS3DAnalystTermLineRemoveLink);
		int i = getSize(ecommerceTrailCustomerPageObjects.cartItemList);
		return Integer.toString(i);
	}

	/**
	 * This method add the 3 more items from offer to the cart and will return
	 * the cart count
	 * 
	 * @return String
	 */
	public String retrieveCartItemCountAfterAddingOfferToTheCart() {
		inputText(ecommerceTrailCustomerPageObjects.arcGISDesktopBasicNumberOfDaysInputArea,
				Ecommerce.ARCGIS3DANALYST_CART_ITEM_COUNT);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.arcGISDesktopBasicNumberOfDaysAddToCartButton);
		click(ecommerceTrailCustomerPageObjects.arcGISDesktopBasicNumberOfDaysAddToCartButton);
		waitForPageToLoad();
		return getText(ecommerceTrailCustomerPageObjects.cartCountText);
	}

	/**
	 * This method will perform click event for Add to cart under ArcGIS 3D
	 * Analyst and will return the cart count
	 * 
	 * @return string
	 */
	public void retrieveOrderSummaryHeaderLabel() {
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.arcGISDesktopBasicSubscriptionDropDownList);
		click(ecommerceTrailCustomerPageObjects.arcGISDesktopBasicSubscriptionDropDownList);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.arcGISDesktopBasicSubscriptionDropDownFirstItem);
		click(ecommerceTrailCustomerPageObjects.arcGISDesktopBasicSubscriptionDropDownFirstItem);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.Level2SubscriptionDropDownList);
		click(ecommerceTrailCustomerPageObjects.Level2SubscriptionDropDownList);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.Level2SubscriptionDropDownFirstItem);
		click(ecommerceTrailCustomerPageObjects.Level2SubscriptionDropDownFirstItem);
	}

	/**
	 * This method will perform click event for T&C of billing page for 3 items
	 */
	public void clickonTCOfBillingPage() {
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.arcGIS3DAnalystTCCheckbox);
		click(ecommerceTrailCustomerPageObjects.arcGIS3DAnalystTCCheckbox);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.arcGISDesktopBasicTCCheckbox);
		click(ecommerceTrailCustomerPageObjects.arcGISDesktopBasicTCCheckbox);
		if (getSize(ecommerceTrailCustomerPageObjects.orderItemsListSize) == 2) {
			Log.info("We have only 2 items in the cart");
		} else {
			scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.level2UserTCCheckBox);
			click(ecommerceTrailCustomerPageObjects.level2UserTCCheckBox);
		}
	}

	/**
	 * This method will perform click event for Add to cart under ArcGIS 3D
	 * Analyst and will return the cart count
	 * 
	 * @return String
	 */
	public String retrieveVerifyOrderHeaderLabel() {
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.proceedToCheckoutButton);
		click(ecommerceTrailCustomerPageObjects.proceedToCheckoutButton);
		inputText(ecommerceTrailCustomerPageObjects.cvvNumberInputArea,
				inputDataMap.get(Ecommerce.ARCGIS_ONLINE_QUANTITY));
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.paymentDetailsContinueButton);
		click(ecommerceTrailCustomerPageObjects.paymentDetailsContinueButton);
		return getText(ecommerceTrailCustomerPageObjects.orderSummaryHeaderText);
	}

	/**
	 * This method will return the total order amount
	 * 
	 * @return String
	 */
	public String retrieveOrderTotalAmount() {
		return getText(ecommerceTrailCustomerPageObjects.orderTotalLabel);
	}

	/**
	 * This method will perform click event for Submit order and will return the
	 * order complete header text
	 * 
	 * @return String
	 */
	public String retrieveOrderTotalAmountAfterOrderSuccess() {
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.verifyOrderTCCheckBox);
		click(ecommerceTrailCustomerPageObjects.verifyOrderTCCheckBox);
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.orderSubmitButton);
		click(ecommerceTrailCustomerPageObjects.orderSubmitButton);
		return getText(ecommerceTrailCustomerPageObjects.totalOrderAmountTextAfterOrderCompletion);
	}

	/**
	 * This method will perform click event for Submit order and will return the
	 * order complete header text
	 * 
	 * @return String
	 */
	public String retrieveViewInvoiceTotalAmount() {
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.viewInvoiceLink);
		click(ecommerceTrailCustomerPageObjects.viewInvoiceLink);
		return getText(ecommerceTrailCustomerPageObjects.totalOrderAmountText);
	}

	/**
	 * This method will perform the click event for instructor Led Training
	 * Voucher Get Started Button
	 */
	public void clickOninstructorLedTrainingVoucherGetStartedButton() {
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.instructorLedTrainingVoucherGetStartedButton);
		click(ecommerceTrailCustomerPageObjects.instructorLedTrainingVoucherGetStartedButton);
	}

	/**
	 * This method will perform the click event for Level2 User Get Started
	 * Button
	 */
	public void clickOnLevel2UserGetStartedButton() {	
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.level2UserGetStartedButton);
		click(ecommerceTrailCustomerPageObjects.level2UserGetStartedButton);
	}

	/**
	 * This method will perform the click event for ArcGIS Desktop Basic Get
	 * Started Button
	 */
	public void clickOnArcGISDesktopBasicGetStartedButton() {
		scrollIntoViewByElement(ecommerceTrailCustomerPageObjects.arcGISDesktopBasicGetStartedButton);
		click(ecommerceTrailCustomerPageObjects.arcGISDesktopBasicGetStartedButton);
	}

}
