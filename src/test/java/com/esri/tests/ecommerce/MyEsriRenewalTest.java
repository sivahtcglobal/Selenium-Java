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
import com.esri.support.modules.ecommerce.EcommerceNewCustomerPageFeatures;
import com.esri.support.modules.ecommerce.MyEsriRenewalPageFeatures;

public class MyEsriRenewalTest extends BaseTestUi {

	private MyEsriRenewalPageFeatures myEsriRenewalPageFeatures;
	private EcommerceNewCustomerPageFeatures newCustomerPageFeatures;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public MyEsriRenewalTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test Method to validate functionalities of My Esri Renewal
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriRenewal", "Regressions", "SmokeTest" }, priority = 1)
	public void ValidateMyEsriRenewal(Map<String, String> inputDataMap) {
		Log.info("Validate My Esri Renewal");		
		myEsriRenewalPageFeatures = new MyEsriRenewalPageFeatures(driver, inputDataMap);
		newCustomerPageFeatures = new EcommerceNewCustomerPageFeatures(driver, inputDataMap);
		driver.manage().deleteAllCookies();		
		myEsriRenewalPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("ECOMMERCERENEWAL")));
		newCustomerPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), myEsriRenewalPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		myEsriRenewalPageFeatures.signIn();	
		myEsriRenewalPageFeatures.waitForPageToLoad();
		myEsriRenewalPageFeatures.selectCustomerFromQuickSearch();
		newCustomerPageFeatures.clickOnCookiesPopup();
		myEsriRenewalPageFeatures.waitForPageToLoad();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), myEsriRenewalPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);		
		myEsriRenewalPageFeatures.transactionsLink();
		myEsriRenewalPageFeatures.waitForPageToLoad();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), myEsriRenewalPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		myEsriRenewalPageFeatures.renewStorePurchasesButton();		
		myEsriRenewalPageFeatures.waitForPageToLoad();
		myEsriRenewalPageFeatures.licenseList();		
		myEsriRenewalPageFeatures.nextButton();
		myEsriRenewalPageFeatures.waitForPageToLoad();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), myEsriRenewalPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		myEsriRenewalPageFeatures.proceedCheckout();
		myEsriRenewalPageFeatures.waitForPageToLoad();
		if (newCustomerPageFeatures.retrievePriceDetails().contains(inputDataMap.get(Ecommerce.CURRENCY))) {
			reportLogger.assertTrue(true, "Price and Currency " + " " + inputDataMap.get(Ecommerce.CURRENCY)
					+ " displayed correctly at Billing Page ");
		} else {
			reportLogger.assertTrue(false, "Price and Currency " + " " + inputDataMap.get(Ecommerce.CURRENCY)
					+ " displayed incorrect at Billing Page ");
		}		
		newCustomerPageFeatures.clickOnTermsAndCondition();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), newCustomerPageFeatures.isViewOrderPageTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		newCustomerPageFeatures.enterPaymentInformation();
		newCustomerPageFeatures.clickContinueToViewOrder();		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), newCustomerPageFeatures.isViewOrderPageTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		newCustomerPageFeatures.acceptTermsAndSubmitTheOrder();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), newCustomerPageFeatures.isViewOrderPageTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		newCustomerPageFeatures.clickViewInvoiceAndRetrieveTotal();		
		newCustomerPageFeatures.clickReturn();
		newCustomerPageFeatures.reviewFullfillmentPage();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), newCustomerPageFeatures.isViewOrderPageTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);		
		closeTest();
	}

}