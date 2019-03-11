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
import com.esri.qa.ui.FeatureAutomationException;
import com.esri.qa.ui.ViewPortSize;
import com.esri.support.modules.core.EcommerceConstants.Ecommerce;
import com.esri.support.modules.ecommerce.EcommerceAfterLoginPageFeatures;
import com.esri.support.modules.ecommerce.EcommerceCommonFeatures;
import com.esri.support.modules.ecommerce.EcommerceQuantityValidationPageFeatures;
import com.esri.support.modules.ecommerce.PurchaseOrderPageFeatures;

public class EcommerceQuantityValidationTest extends BaseTestUi {

	private EcommerceAfterLoginPageFeatures afterloginPageFeatures;
	private EcommerceQuantityValidationPageFeatures ecommerceQuantityValidationPageFeatures;
	private EcommerceCommonFeatures commonPageFeatures;
	private AppliCompareData p_AData;
	private PurchaseOrderPageFeatures purchaseOrderPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EcommerceQuantityValidationTest(@Optional String fileName, @Optional String startRow,
			@Optional String endRow, @Optional String bType, @Optional String bVersion, @Optional String platform,
			@Optional String url, @Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test Method to validate functionalities of Quantity validations
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "ProductQuantity", "Regressions" }, priority = 1)
	public void ValidateProductQuantity(Map<String, String> inputDataMap) {
		Log.info("Validate Ecommerce Site With Qty Validation");
		boolean sCutomerStatus = false;
		int listCountSize = 0;
		afterloginPageFeatures = new EcommerceAfterLoginPageFeatures(driver, inputDataMap);
		ecommerceQuantityValidationPageFeatures = new EcommerceQuantityValidationPageFeatures(driver, inputDataMap);
		purchaseOrderPageFeatures = new PurchaseOrderPageFeatures(driver, inputDataMap);
		commonPageFeatures = new EcommerceCommonFeatures(driver, inputDataMap);
		commonPageFeatures.openBaseURL();
		purchaseOrderPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, inputDataMap.get(Ecommerce.HOME_PAGE_TITLE)),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		purchaseOrderPageFeatures.waitForPageToLoad();
		purchaseOrderPageFeatures.clickArgGISDesktopBasicBuyNow();
		purchaseOrderPageFeatures.waitForPageToLoad();
		purchaseOrderPageFeatures.clickOnsignInToSeePrice();
		purchaseOrderPageFeatures.signIn();
		purchaseOrderPageFeatures.waitForPageToLoad();
		purchaseOrderPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(
				driver, inputDataMap.get("TestCaseName"), String.format("%s - %s",
						purchaseOrderPageFeatures.getCurrentURL(), inputDataMap.get(Ecommerce.HOME_PAGE_TITLE)),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		sCutomerStatus = afterloginPageFeatures.selectCustomer();
		if (sCutomerStatus) {
			reportLogger.assertTrue(true, "Customer :" + inputDataMap.get(Ecommerce.CUSTOMER) + " " + "Available");

		} else {

			throw new SkipException("Customer :" + inputDataMap.get(Ecommerce.CUSTOMER) + " "
					+ "Not Available to perform Quantity validation");
		}
		afterloginPageFeatures.clickProducts();
		if (inputDataMap.get(Ecommerce.COUNTRY).equals("US")) {
			listCountSize = ecommerceQuantityValidationPageFeatures.getHeaderList().size();
			Log.info("Count Size for US Country::" + listCountSize);
		} else {
			listCountSize = ecommerceQuantityValidationPageFeatures.getHeaderList().size() - 1;
			Log.info("Count Size for Non US Country::" + listCountSize);
		}
		for (int headercount = 0; headercount < listCountSize; headercount++) {
			afterloginPageFeatures.clickProducts();
			if(headercount == 0){
				afterloginPageFeatures.clickProducts();
			}
			ecommerceQuantityValidationPageFeatures.clickonHeaderList(headercount);
			for (int buyNowcount = 0; buyNowcount < afterloginPageFeatures.getBuyNowElementList()
					.size(); buyNowcount++) {
				try {
					String linkName = afterloginPageFeatures.getBuyNowText(buyNowcount);
					Map<String, Boolean> mapLinks = ecommerceQuantityValidationPageFeatures.clickBuyNow(linkName);

					reportLogger.assertTrue(mapLinks.get(linkName).booleanValue(), "Validate " + " " + linkName
							+ " Buy Now Page Product Quantity warning message displayed successfully");

					p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
							String.format("%s - %s", commonPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
							ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
					AppliCompareImage(p_AData);

					reportLogger.assertTrue(ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide(),
							"Validate " + " " + linkName
									+ " Buy Now Page Product Quantity warning message hide and displayed Add to Cart successfully");

					afterloginPageFeatures.clickProducts();
					afterloginPageFeatures
							.clickStoreHeader(ecommerceQuantityValidationPageFeatures.getHeaderList().get(headercount));

				} catch (NullPointerException ex) {
					throw new FeatureAutomationException("Null pointer Exception ");
				}
			}
		}

		// Validation ArcGIS Online quantity warning message

		afterloginPageFeatures.clickProducts();
		ecommerceQuantityValidationPageFeatures.clickOnArcGISOnlineNamedUsersBuyNow();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageDisplayedForNamedLevel1Users();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, "Quantity Warning Message For Named Level1 Users"),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide();
		ecommerceQuantityValidationPageFeatures
				.isQuantityWarningMessageDisplayedForNamedUserAnnualSubscriptionsLevel2Users();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl,
						"Quantity Warning Message For Named User Annual Subscriptions Level2"),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide();

		// Validation ArcGIS for Personal Use quantity warning message
		afterloginPageFeatures.clickProducts();
		ecommerceQuantityValidationPageFeatures.clickOnArcGISForPersonalUseBuyNow();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);

		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageDisplayedForArcGISDesktopBasic();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, "Quantity Warning Message For Auto Renewal"),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide();

		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageDisplayedForManualRenewal();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, "Quantity Warning Message For Manual Renewal"),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide();

		// Validation ArcGIS for Student Use quantity warning message
		afterloginPageFeatures.clickProducts();
		ecommerceQuantityValidationPageFeatures.clickOnArcGISForStudentUseBuyNow();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);

		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageDisplayedForArcGISStudentUseAutoRenewal();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl,
						"Quantity Warning Message For ArcGIS Student Use Auto Renewal"),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide();

		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageDisplayedForArcGISStudentUseManualRenewal();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl,
						"Quantity Warning Message For ArcGIS Student Use Manual Renewal"),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide();

		// Validation City Engine quantity warning message
		afterloginPageFeatures.clickProducts();
		ecommerceQuantityValidationPageFeatures.clickOnEsriCityEngineBasicBuyNow();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);

		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageDisplayedForWindows();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, "Quantity Warning Message For Windows Basic"),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide();

		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageDisplayedForLinux();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, "Quantity Warning Message For Linux Basic"),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide();

		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageDisplayedForMac();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, "Quantity Warning Message For Mac Basic"),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide();

		afterloginPageFeatures.clickProducts();
		ecommerceQuantityValidationPageFeatures.clickOnEsriCityEngineAdvancedBuyNow();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);

		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageDisplayedForWindows();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, "Quantity Warning Message For Windows Advanced"),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide();

		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageDisplayedForLinux();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, "Quantity Warning Message For Linux Advanced"),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide();

		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageDisplayedForMac();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", commonPageFeatures.baseUrl, "Quantity Warning Message For Mac Advanced"),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ecommerceQuantityValidationPageFeatures.isQuantityWarningMessageHide();

		closeTest();
	}

}