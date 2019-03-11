package com.esri.support.modules.ecommerce;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esri.qa.reporting.Log;
import com.esri.support.modules.core.EcommerceConstants.Ecommerce;

public class PurchaseOrderPageFeatures extends EcommerceCommonFeatures {

	private Map<String, String> inputDataMap;
	private PurchaseOrderPageObjects purchaseOrderPageObjects;
	private WebDriver driver;
	
	public PurchaseOrderPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver, inputDataMap);
		this.inputDataMap = inputDataMap;
		this.driver = driver;
		this.purchaseOrderPageObjects = new PurchaseOrderPageObjects(driver);
	}
	
	/**
	 * Click the Product Header
	 */
	public void clickProducts(){
//		if (isElementAvailable(purchaseOrderPageObjects.acceptButton)) {
//			hoverMouseClick(purchaseOrderPageObjects.acceptButton);
//		} else {
//			Log.info("Manage Cookie Settings Is Not Available");
//		}
		scrollIntoViewByElement(purchaseOrderPageObjects.productsHeaderLink);
		click(purchaseOrderPageObjects.productsHeaderLink);
	}
	
	/**
	 * Click  ArcGIS Desktop Standard
	 */
	public void clickArgGISDesktopStandardBuyNow() {
		waitForPageToLoad(40);
		clickProducts();
		waitForPageToLoad(30);
		scrollIntoViewByElement(purchaseOrderPageObjects.arcGISDesktopLink);
		hoverMouseClick(purchaseOrderPageObjects.arcGISDesktopLink);
		waitForPageToLoad(30);
		scrollIntoViewByElement(purchaseOrderPageObjects.standardBuyNowButton);
		click(purchaseOrderPageObjects.standardBuyNowButton);
	}
	
	
	/**
	 * Get the header text
	 */
	public String getHeaderText(){
		return getText(purchaseOrderPageObjects.headeraNavigationPageText);
	}
	
	/**
	 * Get current URL
	 */
	public String getCurrentURL(){
		return driver.getCurrentUrl();

	}
	
	public String getproductcontentheaderText(){
		return getText(purchaseOrderPageObjects.productContentHeader);

	}
	/**
	 * Click on sign In To See Price link under ArcGIS Desktop Standard
	 * 
	 * @return
	 */
	public void  clickOnsignInToSeePrice() {		
		scrollIntoViewByElement(purchaseOrderPageObjects.signInToSeePriceLink);
		click(purchaseOrderPageObjects.signInToSeePriceLink);	
		waitForPageToLoad();
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
		driver.switchTo().frame(purchaseOrderPageObjects.oAuthFrame);
		hoverMouseClick(purchaseOrderPageObjects.usernameText);
		inputText(purchaseOrderPageObjects.usernameText, inputDataMap.get(Ecommerce.USERNAME));
		hoverMouseClick(purchaseOrderPageObjects.passwordText);
		inputText(purchaseOrderPageObjects.passwordText, inputDataMap.get(Ecommerce.PASSWORD));
		Log.info("User Name is :" + inputDataMap.get(Ecommerce.USERNAME));
		Log.info("Password is :" + inputDataMap.get(Ecommerce.PASSWORD));
		hoverMouseClick(purchaseOrderPageObjects.signInButton);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		} catch (Exception e) {
			Log.info("Waited for singIn page to load",e); 
		}
	}

	/**
	 * Select Desired Customer Number from the list of customer details
	 */
	public String selectCustomer(String customer ) {	
		try{		
		try {
			Thread.sleep(70000);
		} catch (Exception e) {
			Log.info("Waited for customer list to load",e); 
		}
		Log.info("customer" + customer);
		int customerSize = getSize(purchaseOrderPageObjects.customerList);
		for (int count = 0; count < customerSize; count++) {
			if (getText(purchaseOrderPageObjects.customerList.get(count))
					.contains(customer)) {
				WebElement customerTable = convertXpathToWebElement(purchaseOrderPageObjects.selectAccountButton
						.toString().replace(Ecommerce.COUNT_VALUE, Integer.toString(count + 1)));
				Log.info(customerTable.toString());
				scrollIntoViewByElement(customerTable);
				hoverMouseClick(customerTable); 
				//sCutomerstatus =true;
				waitForPageToLoad(40);
				break;
			} 
		}
		}catch(Exception ex){
			Log.info("Waited for customer to select",ex); 
		}
		return customer;
	}

	/**
	 * Click Perpetual from ARCGIS Desktop
	 */
	public void clickPerpetual(){
		click(purchaseOrderPageObjects.perpetualLicenseLabel);
		click(purchaseOrderPageObjects.addToCartButton);
	}
	
	/**
	 * Click  ArcGIS Desktop Basic
	 */
	public void clickArgGISDesktopBasicBuyNow() {
		clickProducts();
		waitForPageToLoad(45);
		scrollIntoViewByElement(purchaseOrderPageObjects.arcGISDesktopLink);
		hoverMouseClick(purchaseOrderPageObjects.arcGISDesktopLink);
		waitForPageToLoad(45);
		scrollIntoViewByElement(purchaseOrderPageObjects.basicBuyNowButton);
		click(purchaseOrderPageObjects.basicBuyNowButton);
	}
	public void clickArgGISDesktoplink() {		
		waitForPageToLoad(45);
		scrollIntoViewByElement(purchaseOrderPageObjects.arcGISDesktopLink);
		click(purchaseOrderPageObjects.arcGISDesktopLink);
		waitForPageToLoad(45);
		scrollIntoViewByElement(purchaseOrderPageObjects.basicBuyNowButton);
		click(purchaseOrderPageObjects.basicBuyNowButton);
	}
	
	/**
	 * Click on change link
	 */
	public void changeCustomer() {		
		scrollIntoViewByElement(purchaseOrderPageObjects.changeLink);
		hoverMouseClick(purchaseOrderPageObjects.changeLink);
		waitForPageToLoad(10);		
	}
	
	/**
	 * Click  ArcGIS Desktop Advanced
	 */
	public void clickArgGISDesktopAdvancedBuyNow() {	
		clickProducts();
		waitForPageToLoad(45);
		scrollIntoViewByElement(purchaseOrderPageObjects.arcGISDesktopLink);
		click(purchaseOrderPageObjects.arcGISDesktopLink);
		waitForPageToLoad(45);
		scrollIntoViewByElement(purchaseOrderPageObjects.advancedBuyNowButton);
		click(purchaseOrderPageObjects.advancedBuyNowButton);
	}

	/**
	 * Click  ArcGIS Personal Use
	 */
	public void clickArcGISPersonalUseBuyNow() {
		waitForPageToLoad(40);
		clickProducts();
		waitForPageToLoad(30);
		click(purchaseOrderPageObjects.arcGISForPersonalUseLink);
		hoverMouseClick(purchaseOrderPageObjects.arcGISForPersonalUseBuyNowButton);
		waitForPageToLoad(30);
		click(purchaseOrderPageObjects.autoRenewalLabel);
		click(purchaseOrderPageObjects.addToCartButton);
	}
	
	/**
	 * Click remove link from cart
	 */
	public void clickRemoveLink() {		
		click(purchaseOrderPageObjects.removeLink);
	}
	
	/**
	 * Click  ArcGIS Student Use
	 */
	public void clickArcGISStudentUseBuyNow() {
		clickProducts();
		waitForPageToLoad(10);
		click(purchaseOrderPageObjects.arcGISForStudentUseLink);
		scrollIntoViewByElement(purchaseOrderPageObjects.arcGISForStudentUseBuyNowButton);		
		click(purchaseOrderPageObjects.arcGISForStudentUseBuyNowButton);
		click(purchaseOrderPageObjects.autoRenewalLabel);
		click(purchaseOrderPageObjects.addToCartButton);
	}
	
	/**
	 * Click ArcPad Buy Now
	 */
	public void clickArcPadBuyNow(){
		clickProducts();
		waitForPageToLoad(10);
		click(purchaseOrderPageObjects.arcPadLink);
		if(isElementAvailable(purchaseOrderPageObjects.arcPadBuyNow1)) {
			hoverMouseClick(purchaseOrderPageObjects.arcPadBuyNow1);
		}else if(isElementAvailable(purchaseOrderPageObjects.arcPadBuyNow2)){
			hoverMouseClick(purchaseOrderPageObjects.arcPadBuyNow2);
		}
		click(purchaseOrderPageObjects.addToCartButton);
	}
	
	/**
	 * Click Term from ARCGIS Desktop
	 */
	public void clickTerm(){
		click(purchaseOrderPageObjects.termLicenseLabel);
		click(purchaseOrderPageObjects.addToCartButton);
	}
	
	/**
	 * Remove student use from cart
	 */
	public void removeStudentUseFromCart(){
		click(purchaseOrderPageObjects.removeStudentUseLink);
	}
	
	/**
	 * Remove student use from cart
	 */
	public void removeArcPadFromCart(){
		click(purchaseOrderPageObjects.removeArcPadLink);
	}
	
	/**
	 * Submit Purchase Order Option
	 * @return String
	 */
	public String submitPurchaseOrderOption(){		
		return getText(purchaseOrderPageObjects.submitPurchaseOrderOption);
	}
	/**
	 * click on buy now
	 */
	public void buynow(){
		click(purchaseOrderPageObjects.productbuynow);
	}
	/**
	 * Submit Purchase Order Option
	 * @return String
	 */
	public boolean isSubmitPurchaseOrderOptionAvailabe(){	
		boolean isSubmitStatus =false;
		if(!isElementAvailable(purchaseOrderPageObjects.submitPurchaseOrderOption)){
			isSubmitStatus =true;
		}else{
			isSubmitStatus =false;
		}
		return isSubmitStatus;
	}
	
}
