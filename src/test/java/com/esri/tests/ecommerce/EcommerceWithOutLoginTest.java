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
import com.esri.support.modules.ecommerce.EcommerceAfterLoginPageFeatures;
import com.esri.support.modules.ecommerce.EcommerceCommonFeatures;
import com.esri.support.modules.ecommerce.PurchaseOrderPageFeatures;

public class EcommerceWithOutLoginTest extends BaseTestUi {

	private EcommerceAfterLoginPageFeatures afterloginPageFeatures;
	private EcommerceCommonFeatures commonPageFeatures;
	private PurchaseOrderPageFeatures purchaseOrderPageFeatures;
	private AppliCompareData p_AData;
	private String beforeClickArticleHeaderLabel = null;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EcommerceWithOutLoginTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);

	}

	/**
	 * Test Method to validate functionalities After login
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "AfterLogin", "Regressions" }, priority = 1)
	public void ValidateWithoutLogin(Map<String, String> inputDataMap) {
		Log.info("Validate Ecommerce Site After Login");
		afterloginPageFeatures = new EcommerceAfterLoginPageFeatures(driver, inputDataMap);
		purchaseOrderPageFeatures = new PurchaseOrderPageFeatures(driver, inputDataMap);
		commonPageFeatures = new EcommerceCommonFeatures(driver, inputDataMap);
		purchaseOrderPageFeatures = new PurchaseOrderPageFeatures(driver, inputDataMap);
		driver.manage().deleteAllCookies();
		commonPageFeatures.openBaseURL();
		purchaseOrderPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(
				driver, inputDataMap.get("TestCaseName"), String.format("%s - %s",
						commonPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		afterloginPageFeatures.clickProducts();
		purchaseOrderPageFeatures.waitForPageToLoad();
		int Produlistcount = afterloginPageFeatures.getproductList1();
		Log.info("Product:" + Produlistcount);
		for (int prodCount = 0; prodCount < Produlistcount - 3; prodCount++) {
			String productname = afterloginPageFeatures.producttext(prodCount);

			if (productname.contains("ArcGIS For Personal Use")) {
				afterloginPageFeatures.clickProductLinks(prodCount);
				purchaseOrderPageFeatures.waitForPageToLoad();
				afterloginPageFeatures.clickbuynow();
				p_AData = new AppliCompareData(driver,
						inputDataMap.get("TestCaseName"), String.format("%s - %s",
								commonPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
						ComparisonLevel.CONTENT, false, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
			} else if (productname.trim().contains("ArcGIS For Student Use")) {
				afterloginPageFeatures.clickProductLinks(prodCount);
				purchaseOrderPageFeatures.waitForPageToLoad();
				afterloginPageFeatures.clickbuynow();
				p_AData = new AppliCompareData(driver,
						inputDataMap.get("TestCaseName"), String.format("%s - %s",
								commonPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
						ComparisonLevel.CONTENT, false, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
			} else {
				afterloginPageFeatures.clickProductLinks(prodCount);
				Log.info("Productname:" + productname);
				Log.info("Buynowcount:" + afterloginPageFeatures.getBuyNowList());

				for (int list = 0; list < afterloginPageFeatures.getBuyNowList(); list++) {
					purchaseOrderPageFeatures.waitForPageToLoad();
					afterloginPageFeatures.clickBuynow(list);
					afterloginPageFeatures.waitForPageToLoad();
					p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
							String.format("%s - %s", commonPageFeatures.baseUrl,
									afterloginPageFeatures.getTitle()),
							ComparisonLevel.CONTENT, false, ViewPortSize.MAX);
					AppliCompareImage(p_AData);
					afterloginPageFeatures.waitForPageToLoad();
					afterloginPageFeatures.clickProducts();
					afterloginPageFeatures.clickProductLinks(prodCount);
				}
			}

			afterloginPageFeatures.clickProducts();
		}
		purchaseOrderPageFeatures.clickArgGISDesktoplink();
		int productlist = afterloginPageFeatures.getproductList();
		Log.info("Productlist:" + productlist);
		for (int listCount = 0; listCount < productlist - 3; listCount++) {
			Log.info("Productlist:" + afterloginPageFeatures.getproductList());
			afterloginPageFeatures.scrolltoArticle(listCount);
			beforeClickArticleHeaderLabel = afterloginPageFeatures.getheaderList(listCount);
			afterloginPageFeatures.clickBuynowLinks(listCount);
			p_AData = new AppliCompareData(driver,
					inputDataMap.get("TestCaseName"), String.format("%s - %s",
							commonPageFeatures.baseUrl, afterloginPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, false, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			afterloginPageFeatures.closebuynow();
			reportLogger.info("Compare Article Screenshots: " + beforeClickArticleHeaderLabel);
		}
		closeTest();
	}

}