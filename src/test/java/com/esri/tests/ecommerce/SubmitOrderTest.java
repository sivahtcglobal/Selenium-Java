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
import com.esri.support.modules.ecommerce.SubmitOrderPageFeatures;

public class SubmitOrderTest extends BaseTestUi {

	private SubmitOrderPageFeatures submitOrderPageFeatures;
	private String sheaderText = null;
	private String cartpage = null;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public SubmitOrderTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
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
	@Test(dataProvider = "csv", groups = { "Regressions", "SubmitOrder" }, enabled = true, priority = 1)
	public void ValidateSubmitOrderTest(Map<String, String> inputDataMap) throws InterruptedException {
		Log.info("Validate Submit Order Test");
		submitOrderPageFeatures = new SubmitOrderPageFeatures(driver, inputDataMap);
		submitOrderPageFeatures
				.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCESUBMITORDER")));
		submitOrderPageFeatures.clickOnCookiesPopup();
		submitOrderPageFeatures.waitForPageToLoad(45);
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.clickArgGISDesktopStandardBuyNow();
		submitOrderPageFeatures.waitForPageToLoad(45);
		submitOrderPageFeatures.clickOnsignInToSeePrice();
		submitOrderPageFeatures.waitForPageToLoad(45);
		submitOrderPageFeatures.signIn();
		submitOrderPageFeatures.createNewCustomer();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.clickOnBehalfofOrganization();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.fillRequiredAddressDetails();
		submitOrderPageFeatures.clickTermLicense();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.clickOnCart();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		// Validate submit purchase Order
		validateSubmitPurchaseOrder(inputDataMap);

		// Review end user contact information
		validateEndUserInformation(inputDataMap);

		// Review PurchaseOrder
		validatePurchaseOrderInformation(inputDataMap);

		// click Edit link next to review order
		validateEditLinkForReviewOrder(inputDataMap);

		// Clicking edit link next to Bill To
		validateEditLinkForBillTo(inputDataMap);

		// Clicking edit link next to Purchase Order Information To

		validateEditLinkForPurchaseOrderInformation(inputDataMap);

		validateSubmitTheOrderAndVerifyOrderCompletedMessage(inputDataMap);

		closeTest();
	}

	/**
	 * Validate Submit Order
	 * 
	 * @param inputDataMap
	 */
	public void validateSubmitPurchaseOrder(Map<String, String> inputDataMap) {
		submitOrderPageFeatures.selectSubmitPurchaseOrder();
		submitOrderPageFeatures.retrievePriceAndClickonProceedToCheckout();
		submitOrderPageFeatures.clickAgreeAndContinue();
		submitOrderPageFeatures.waitForPageToLoad(45);
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.waitForPageToLoad();
		submitOrderPageFeatures.estimatedSalesTaxIcon();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, false, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.clickOkButton();
		submitOrderPageFeatures.endUserContactLabelIcon();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, false, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.clickOkButtonForEndUserContact();
	}

	/**
	 * validateEndUserInformation
	 * 
	 * @param inputDataMap
	 */
	public void validateEndUserInformation(Map<String, String> inputDataMap) {
		submitOrderPageFeatures.clickSameEndUserAddress();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
	}

	/**
	 * ValidatePurchaseOrderInformation
	 * 
	 * @param inputDataMap
	 */
	public void validatePurchaseOrderInformation(Map<String, String> inputDataMap) {
		submitOrderPageFeatures.enterPurchaseOrderNumber();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, false, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		reportLogger.assertTrue(submitOrderPageFeatures.isAttachFilesButtonAvailable(),
				"Attach File Button Displayed Sucessfully");
		submitOrderPageFeatures.attachFile();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, false, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.waitForPageToLoad();
		submitOrderPageFeatures.attachinvalidFile();
		submitOrderPageFeatures.FileUploadAlertokay();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, false, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.clickReviewOrderButton();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.waitForPageToLoad();

	}

	/**
	 * ValidateEditLinkForReviewOrder
	 * 
	 * @param inputDataMap
	 */
	public void validateEditLinkForReviewOrder(Map<String, String> inputDataMap) {
		submitOrderPageFeatures.clickReviewOrderEditLink();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.quantityincrease();
		submitOrderPageFeatures.waitForPageToLoad(45);
		submitOrderPageFeatures.selectCreditCardPayPalorWireTransfer();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		cartpage = submitOrderPageFeatures.getcurrrentUrl();
		submitOrderPageFeatures.retrievePriceAndClickonProceedToCheckout();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		if (submitOrderPageFeatures.CreditCardPayPalorWireTransferError()) {
			reportLogger.assertTrue(true, "CreditCardPayPalorWireTransfer will direct Error Page sucessfully");
		} else {
			reportLogger.assertFalse(false, "CreditCardPayPalorWireTransfer will direct to payment Page sucessfully");
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
					ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
		}
		submitOrderPageFeatures.openURL(cartpage);
		submitOrderPageFeatures.selectSubmitPurchaseOrder();
		submitOrderPageFeatures.retrievePriceAndClickonProceedToCheckout();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.clickAgreeAndContinue();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.clickReviewOrderButton();
	}

	/**
	 * ValidateEditLinkForReviewOrder
	 * 
	 * @param inputDataMap
	 */
	public void validateEditLinkForBillTo(Map<String, String> inputDataMap) {
		submitOrderPageFeatures.clickBillToEditLink();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		submitOrderPageFeatures.clickReviewOrderButton();
		submitOrderPageFeatures.waitForPageToLoad();
	}

	/**
	 * ValidateEditLinkForPurchaseOrderInformation
	 * 
	 * @param inputDataMap
	 */
	public void validateEditLinkForPurchaseOrderInformation(Map<String, String> inputDataMap) {
		sheaderText = submitOrderPageFeatures.getPurchaseorderno();
		Log.info("Purchase Order Number::" + sheaderText.split(":")[1]);
		submitOrderPageFeatures.clickPurchaseToEditLink();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		Log.info("Purchase Order from edit page::" + submitOrderPageFeatures.getPurchaseeditorderno());
		reportLogger.assertEquals(submitOrderPageFeatures.getPurchaseeditorderno().trim(),
				sheaderText.split(":")[1].trim(), "Purchase Order Edit Page Navigation is sucessfully");
		submitOrderPageFeatures.clickReviewOrderButton();
		submitOrderPageFeatures.waitForPageToLoad();
		// Click terms and condition
		submitOrderPageFeatures.clickTermAndCondition();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
	}

	/**
	 * ValidateSubmitTheOrderAndVerifyOrderCompletedMessage
	 * 
	 * @param inputDataMap
	 */
	public void validateSubmitTheOrderAndVerifyOrderCompletedMessage(Map<String, String> inputDataMap) {
		// Submit the Order
		submitOrderPageFeatures.clickSubmitOrder();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCEUS"), submitOrderPageFeatures.getTitle()),
				ComparisonLevel.LAYOUT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
	}

}
