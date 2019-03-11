package com.esri.tests.ecommerce;

import java.util.Map;

import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.AppliCompareData;
import com.esri.qa.ui.BaseTestUi;
import com.esri.qa.ui.ComparisonLevel;
import com.esri.qa.ui.ViewPortSize;
import com.esri.support.modules.core.EcommerceConstants.Ecommerce;
import com.esri.support.modules.ecommerce.EcommerceAfterLoginPageFeatures;
import com.esri.support.modules.ecommerce.EcommerceDRCartPageFeatures;
import com.esri.support.modules.ecommerce.PurchaseOrderPageFeatures;

public class EcommerceDRCartTest extends BaseTestUi {

	private EcommerceAfterLoginPageFeatures afterloginPageFeatures;
	private EcommerceDRCartPageFeatures drCartPageFeatures;
	private AppliCompareData p_AData;
	private PurchaseOrderPageFeatures purchaseOrderPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EcommerceDRCartTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test Method to validate functionalities DR Cart
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "DRCartAndFulfillment", "Regressions" }, priority = 1)
	public void ValidateDRCartAndFulfillmentPage(Map<String, String> inputDataMap) {
		Log.info("Validate Ecommerce DR Cart And Fulfillment Page");
		String priceDetails = null;
		boolean sCutomerStatus = false;
		afterloginPageFeatures = new EcommerceAfterLoginPageFeatures(driver, inputDataMap);
		drCartPageFeatures = new EcommerceDRCartPageFeatures(driver, inputDataMap);
		purchaseOrderPageFeatures = new PurchaseOrderPageFeatures(driver, inputDataMap);
		drCartPageFeatures.openBaseURL();
		purchaseOrderPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(
				driver, inputDataMap.get("TestCaseName"), String.format("%s - %s",
						drCartPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		drCartPageFeatures.clickProducts();
		drCartPageFeatures.waitForPageToLoad();
		drCartPageFeatures.clickArcGISForPersonalUse();
		drCartPageFeatures.clickBuyNowAndclickSignintoseeprice();
		purchaseOrderPageFeatures.signIn();
		sCutomerStatus = afterloginPageFeatures.selectCustomer();
		if (sCutomerStatus) {
			reportLogger.assertTrue(true, "Customer :" + inputDataMap.get(Ecommerce.CUSTOMER) + " " + "Available");
		} else {
			throw new SkipException("Customer :" + inputDataMap.get(Ecommerce.CUSTOMER) + " " + "Not Available");
		}
		p_AData = new AppliCompareData(
				driver, inputDataMap.get("TestCaseName"), String.format("%s - %s",
						drCartPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		drCartPageFeatures.selectManualRenewalAndAddToCart();
		drCartPageFeatures.clickOnCart();
		p_AData = new AppliCompareData(
				driver, inputDataMap.get("TestCaseName"), String.format("%s - %s",
						drCartPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		drCartPageFeatures.clickOnCreateNewSubscription();
		priceDetails = drCartPageFeatures.retrievePriceAndClickonProceedToCheckout();
		if (priceDetails.contains(inputDataMap.get(Ecommerce.CURRENCY_SYMBOL))) {
			reportLogger.assertTrue(true, "Currency displayed correctly at checkout page ");
		}
		if (drCartPageFeatures.retrievePriceDetails().contains(inputDataMap.get(Ecommerce.CURRENCY_SYMBOL))
				|| drCartPageFeatures.retrievePriceDetails().contains(inputDataMap.get(Ecommerce.CURRENCY))) {
			reportLogger.assertTrue(true, "Price and Currency " + " " + inputDataMap.get(Ecommerce.CURRENCY_SYMBOL)
					+ "or " + inputDataMap.get(Ecommerce.CURRENCY) + " displayed correctly at Billing Page ");
		} else {
			reportLogger.assertTrue(false, "Price and Currency " + " " + inputDataMap.get(Ecommerce.CURRENCY_SYMBOL)
					+ "or " + inputDataMap.get(Ecommerce.CURRENCY) + " displayed incorrect at Billing Page ");
		}
		p_AData = new AppliCompareData(
				driver, inputDataMap.get("TestCaseName"), String.format("%s - %s",
						drCartPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		drCartPageFeatures.clickOnTermsAndConditionChekBox();
		drCartPageFeatures.enterPaymentInformation();
		drCartPageFeatures.clickContinueToViewOrder();
		p_AData = new AppliCompareData(
				driver, inputDataMap.get("TestCaseName"), String.format("%s - %s",
						drCartPageFeatures.baseUrl, drCartPageFeatures.isViewOrderPageTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		drCartPageFeatures.acceptTermsAndSubmitTheOrder();
		p_AData = new AppliCompareData(
				driver, inputDataMap.get("TestCaseName"), String.format("%s - %s",
						drCartPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);		
		drCartPageFeatures.clickViewInvoiceAndRetrieveTotal();		
		drCartPageFeatures.clickReturn();
		drCartPageFeatures.reviewFullfillmentPage();
		drCartPageFeatures.waitForPageToLoad();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", drCartPageFeatures.baseUrl, drCartPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);		
		closeTest();
	}

}
