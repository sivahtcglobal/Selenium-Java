package com.esri.tests.ecommerce;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.config.Env;
import com.esri.qa.reporting.Log;
import com.esri.qa.ui.AppliCompareData;
import com.esri.qa.ui.BaseTestUi;
import com.esri.qa.ui.ComparisonLevel;
import com.esri.qa.ui.ViewPortSize;
import com.esri.support.modules.core.EcommerceConstants.Ecommerce;
import com.esri.support.modules.ecommerce.PurchaseOrderPageFeatures;

public class PurchaseOrderTest extends BaseTestUi {

	private PurchaseOrderPageFeatures purchaseOrderPageFeatures;
	private String sheaderText = null;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public PurchaseOrderTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);

	}

	/**
	 * Test to validate the Sign Up Subscription
	 * 
	 * @param inputDatamap
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "csv", groups = { "Regressions", "PurchaseOrder" }, enabled = true, priority = 1)
	public void ValidatePurchaseOrderTest(Map<String, String> inputDataMap) throws InterruptedException {
		Log.info("Validate Purchase Order Test");
		purchaseOrderPageFeatures = new PurchaseOrderPageFeatures(driver, inputDataMap);
		purchaseOrderPageFeatures
				.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCEPURCHASEORDER")));
		purchaseOrderPageFeatures.clickOnCookiesPopup();
		purchaseOrderPageFeatures.waitForPageToLoad();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), purchaseOrderPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		purchaseOrderPageFeatures.clickArgGISDesktopStandardBuyNow();
		sheaderText = purchaseOrderPageFeatures.getHeaderText();
		purchaseOrderPageFeatures.clickOnsignInToSeePrice();
		purchaseOrderPageFeatures.signIn();
		sheaderText = purchaseOrderPageFeatures.selectCustomer(inputDataMap.get(Ecommerce.CUSTOMER));
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), sheaderText), ComparisonLevel.LAYOUT, true,
				ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		purchaseOrderPageFeatures.waitForPageToLoad(45);
		purchaseOrderPageFeatures.clickPerpetual();
		purchaseOrderPageFeatures.waitForPageToLoad(35);
		purchaseOrderPageFeatures.clickOnCart();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), purchaseOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitPurchaseOrderStatus(inputDataMap.get(Ecommerce.CUSTOMER));

		// validate the customer #233123
		validateCustomer1(inputDataMap);

		// validate the customer #552709

		validateCustomer2(inputDataMap);

		// validate the customer #6

		validateCustomer3(inputDataMap);

		// validate the customer #552888
		validateCustomer4(inputDataMap);

		closeTest();
	}

	/**
	 * Asset check for the submit purchase order available or not
	 */
	public void submitPurchaseOrderStatus(String sCustomer) {
		if (purchaseOrderPageFeatures.isSubmitPurchaseOrderOptionAvailabe()) {
			reportLogger.pass("No option available to submit a purchase order for the customer :" + " " + sCustomer);
		} else {
			reportLogger.fail("Submit a purchase order option is available for the customer :" + " " + sCustomer);
		}
	}

	/**
	 * Validate the Customer #233123
	 * 
	 * @param inputDataMap
	 */
	public void validateCustomer1(Map<String, String> inputDataMap) {
		purchaseOrderPageFeatures.clickArgGISDesktopBasicBuyNow();
		purchaseOrderPageFeatures.changeCustomer();
		sheaderText = purchaseOrderPageFeatures.selectCustomer(inputDataMap.get(Ecommerce.CUSTOMER1));
		Log.info("sCustomerText from customer" + sheaderText);
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), sheaderText), ComparisonLevel.LAYOUT, true,
				ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		purchaseOrderPageFeatures.clickArgGISDesktopAdvancedBuyNow();
		purchaseOrderPageFeatures.clickPerpetual();
		purchaseOrderPageFeatures.clickOnCart();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), purchaseOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitPurchaseOrderStatus(inputDataMap.get(Ecommerce.CUSTOMER1));
	}

	/**
	 * Validate the Customer #552709
	 * 
	 * @param inputDataMap
	 */
	public void validateCustomer2(Map<String, String> inputDataMap) {
		purchaseOrderPageFeatures.changeCustomer();
		sheaderText = purchaseOrderPageFeatures.selectCustomer(inputDataMap.get(Ecommerce.CUSTOMER2));
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), sheaderText), ComparisonLevel.LAYOUT, true,
				ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		purchaseOrderPageFeatures.clickArgGISDesktopAdvancedBuyNow();
		purchaseOrderPageFeatures.clickPerpetual();
		purchaseOrderPageFeatures.clickOnCart();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), purchaseOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitPurchaseOrderStatus(inputDataMap.get(Ecommerce.CUSTOMER2));
	}

	/**
	 * Validate the Customer #6
	 * 
	 * @param inputDataMap
	 */
	public void validateCustomer3(Map<String, String> inputDataMap) {
		purchaseOrderPageFeatures.changeCustomer();
		sheaderText = purchaseOrderPageFeatures.selectCustomer(inputDataMap.get(Ecommerce.CUSTOMER3));
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), sheaderText), ComparisonLevel.LAYOUT, true,
				ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		purchaseOrderPageFeatures.clickArgGISDesktopStandardBuyNow();
		purchaseOrderPageFeatures.clickPerpetual();
		purchaseOrderPageFeatures.clickOnCart();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), purchaseOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitPurchaseOrderStatus(inputDataMap.get(Ecommerce.CUSTOMER3));
	}

	/**
	 * Validate the Customer #552888
	 * 
	 * @param inputDataMap
	 */
	public void validateCustomer4(Map<String, String> inputDataMap) {
		purchaseOrderPageFeatures.changeCustomer();
		sheaderText = purchaseOrderPageFeatures.selectCustomer(inputDataMap.get(Ecommerce.CUSTOMER4));
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), sheaderText), ComparisonLevel.LAYOUT, true,
				ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		purchaseOrderPageFeatures.clickArcGISPersonalUseBuyNow();
		purchaseOrderPageFeatures.clickOnCart();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), purchaseOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		purchaseOrderPageFeatures.clickRemoveLink();
		purchaseOrderPageFeatures.clickArcGISStudentUseBuyNow();
		purchaseOrderPageFeatures.clickOnCart();
		purchaseOrderPageFeatures.clickArcPadBuyNow();
		purchaseOrderPageFeatures.clickOnCart();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), purchaseOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		purchaseOrderPageFeatures.clickArgGISDesktopStandardBuyNow();
		purchaseOrderPageFeatures.clickTerm();
		purchaseOrderPageFeatures.clickOnCart();
		purchaseOrderPageFeatures.removeStudentUseFromCart();
		purchaseOrderPageFeatures.removeArcPadFromCart();
		sheaderText = purchaseOrderPageFeatures.submitPurchaseOrderOption();
		Log.info("sheaderText value :" + sheaderText);
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), sheaderText), ComparisonLevel.LAYOUT, true,
				ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		reportLogger.assertEquals(sheaderText.trim(), Ecommerce.SUBMIT_PURCHASE_ORDER,
				"Submit a Purchase Order option is displayed Sucessfully for the customer :" + " "
						+ inputDataMap.get(Ecommerce.CUSTOMER4));
	}
}
