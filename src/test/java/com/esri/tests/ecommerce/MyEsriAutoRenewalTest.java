package com.esri.tests.ecommerce;

import java.util.Map;

import org.testng.SkipException;
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
import com.esri.support.modules.ecommerce.EcommerceCommonFeatures;
import com.esri.support.modules.ecommerce.MyEsriRenewalPageFeatures;

public class MyEsriAutoRenewalTest extends BaseTestUi {

	private MyEsriRenewalPageFeatures myEsriRenewalPageFeatures;
	private AppliCompareData p_AData;
	private EcommerceCommonFeatures commonPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public MyEsriAutoRenewalTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test Method to validate functionalities of My Esri Auto Renewal
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriAutoRenewal", "Regressions" }, priority = 1)
	public void ValidateMyEsriAutoRenewal(Map<String, String> inputDataMap) {
		Log.info("Validate My Auto Esri Renewal");
		myEsriRenewalPageFeatures = new MyEsriRenewalPageFeatures(driver, inputDataMap);
		commonPageFeatures = new EcommerceCommonFeatures(driver, inputDataMap);
		driver.manage().deleteAllCookies();
		myEsriRenewalPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url",Env.get("ECOMMERCERENEWAL")));
		commonPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), myEsriRenewalPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		myEsriRenewalPageFeatures.signIn();
		commonPageFeatures.clickOnCookiesPopup();
		myEsriRenewalPageFeatures.selectCustomerFromQuickSearch();
		commonPageFeatures.clickOnCookiesPopup();
		myEsriRenewalPageFeatures.waitForPageToLoad();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), myEsriRenewalPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		myEsriRenewalPageFeatures.clickTransactionLink();
		myEsriRenewalPageFeatures.waitForPageToLoad();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), myEsriRenewalPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		if (myEsriRenewalPageFeatures.getNoRecordFoundMessage().equals(Ecommerce.NO_RECORDS_FOUND)) {
			reportLogger.warn("No Record Found available Message displayed for Manage Auto Renewals");
			throw new SkipException("No records could be found.");
		} else {
			boolean isRenewalStatus = myEsriRenewalPageFeatures.manageAutoRenewals();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), myEsriRenewalPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			Log.info("isRenewalStatus::" + isRenewalStatus);
			if (true) {
				reportLogger.assertEquals(myEsriRenewalPageFeatures.getAutoRenewalMessage(),
						"Changes to Auto-Renewal have been submitted and will be reflected shortly.");
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), myEsriRenewalPageFeatures.getTitle()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
			}
			reportLogger.assertFalse(false, "Changes to Auto-Renewal has been submitted already");
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("ECOMMERCERENEWAL"), myEsriRenewalPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
		}
		closeTest();
	}

}
