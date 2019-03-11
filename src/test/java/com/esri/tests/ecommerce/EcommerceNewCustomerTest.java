package com.esri.tests.ecommerce;

import java.util.Map;

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
import com.esri.support.modules.ecommerce.EcommerceNewCustomerPageFeatures;
import com.esri.support.modules.ecommerce.PurchaseOrderPageFeatures;

public class EcommerceNewCustomerTest extends BaseTestUi {

	private EcommerceAfterLoginPageFeatures afterloginPageFeatures;
	private EcommerceNewCustomerPageFeatures newCustomerPageFeatures;
	private AppliCompareData p_AData;
	private PurchaseOrderPageFeatures purchaseOrderPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EcommerceNewCustomerTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test Method to validate functionalities New Customer
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "NewCustomer", "Regressions" }, priority = 1)
	public void ValidateNewCustomer(Map<String, String> inputDataMap) {
		Log.info("Validate Ecommerce Site New Customer");
		String priceDetails = null;
		afterloginPageFeatures = new EcommerceAfterLoginPageFeatures(driver, inputDataMap);
		newCustomerPageFeatures = new EcommerceNewCustomerPageFeatures(driver, inputDataMap);
		purchaseOrderPageFeatures = new PurchaseOrderPageFeatures(driver, inputDataMap);
		newCustomerPageFeatures.openBaseURL();
		newCustomerPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", newCustomerPageFeatures.baseUrl, purchaseOrderPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		afterloginPageFeatures.clickSignIn();
		purchaseOrderPageFeatures.signIn();
		purchaseOrderPageFeatures.waitForPageToLoad();
		purchaseOrderPageFeatures.clickOnCookiesPopup();
		newCustomerPageFeatures.createNewCustomer();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", newCustomerPageFeatures.baseUrl, purchaseOrderPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		newCustomerPageFeatures.clickOnBehalfofOrganization();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", newCustomerPageFeatures.baseUrl, newCustomerPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		newCustomerPageFeatures.fillRequiredAddressDetails();
		newCustomerPageFeatures.clickArcGISOnlineAddItemsToCart();
		if (newCustomerPageFeatures.isGoToCartAvailable()) {
			reportLogger.assertTrue(true, "ArcGIS Online Items Added Sucessfully");
		} else {
			reportLogger.assertFalse(false, "ArcGIS Online Items Not Added");
		}
		newCustomerPageFeatures.clickArcGISForPersonalUse();
		newCustomerPageFeatures.clickOnCart();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", newCustomerPageFeatures.baseUrl, newCustomerPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		reportLogger.assertEquals(newCustomerPageFeatures.getCartItemsCount(), 2, "Items list added to cart");
		if (newCustomerPageFeatures.isServiceCreditsErrorMessageDisplayed()) {
			newCustomerPageFeatures.removeCreditsLineItem();
		}
		priceDetails = newCustomerPageFeatures.retrievePriceAndClickonProceedToCheckout();
		if (priceDetails.contains(inputDataMap.get(Ecommerce.CURRENCY_SYMBOL))) {
			reportLogger.assertTrue(true, "Currency displayed correctly at checkout page ");
		}
		newCustomerPageFeatures.clickOnTermsAndCondition();
		newCustomerPageFeatures.enterPaymentInformation();
		newCustomerPageFeatures.clickContinueToViewOrder();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", newCustomerPageFeatures.baseUrl, newCustomerPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		newCustomerPageFeatures.acceptTermsAndSubmitTheOrder();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", newCustomerPageFeatures.baseUrl, newCustomerPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		newCustomerPageFeatures.clickViewInvoiceAndRetrieveTotal();
		newCustomerPageFeatures.clickReturn();
		closeTest();
	}

}
