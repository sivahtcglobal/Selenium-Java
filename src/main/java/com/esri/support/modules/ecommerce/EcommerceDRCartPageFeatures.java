package com.esri.support.modules.ecommerce;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public class EcommerceDRCartPageFeatures extends EcommerceCommonFeatures {

	private EcommerceDRCartPageObjects ecommerceDRCartPageObjects;

	public EcommerceDRCartPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver, inputDataMap);
		this.ecommerceDRCartPageObjects = new EcommerceDRCartPageObjects(driver);
	}
	
	/**
	 * Click the Product Header
	 */
	public void clickProducts(){
		waitForPageToLoad(25);
		scrollIntoViewByElement(ecommerceDRCartPageObjects.productsHeaderLink);
		click(ecommerceDRCartPageObjects.productsHeaderLink);			
	}


	/**
	 * Click on ArcGIS Personal Use Header
	 */
	public void clickArcGISForPersonalUse() {		
		scrollIntoViewByElement(ecommerceDRCartPageObjects.arcGISForPersonalUseHeaderText);
        click(ecommerceDRCartPageObjects.arcGISForPersonalUseHeaderText);
		waitForPageToLoad(25);
	}
   public void clickBuyNowAndclickSignintoseeprice() {
	   scrollIntoViewByElement(ecommerceDRCartPageObjects.arcGISPersonalUseBuyNowButton);
       click(ecommerceDRCartPageObjects.arcGISPersonalUseBuyNowButton);
		waitForPageToLoad(25);
		scrollIntoViewByElement(ecommerceDRCartPageObjects.signinseeprice);
		click(ecommerceDRCartPageObjects.signinseeprice);
   }

	/**
	 * Click on ArcGISPersonalUse,Select Manual Renewal and click on
	 * "Add to Cart"
	 */
	public void selectManualRenewalAndAddToCart() {		
		waitForPageToLoad(25);
		scrollIntoViewByElement(ecommerceDRCartPageObjects.manualRenewalLabel);
		click(ecommerceDRCartPageObjects.manualRenewalLabel);
		waitForPageToLoad(25);
		scrollIntoViewByElement(ecommerceDRCartPageObjects.addToCartButton);
		click(ecommerceDRCartPageObjects.addToCartButton);
	}

	public String cartItemsInHeader() {
		return getText(ecommerceDRCartPageObjects.cartItemsInHeaderText);
	}

	/**
	 * Compare the cartItems count in header matches with the list
	 * 
	 * @return String
	 */
	public String cartItemsInList() {
		return Integer.toString(getSize(ecommerceDRCartPageObjects.itemList));
	}

}
