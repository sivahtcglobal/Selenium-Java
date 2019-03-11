package com.esri.tests.ecommerce;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.BaseTestUi;
import com.esri.support.modules.core.EcommerceConstants.Ecommerce;
import com.esri.support.modules.ecommerce.EcommerceAfterLoginPageFeatures;
import com.esri.support.modules.ecommerce.EcommerceNewCustomerPageFeatures;
import com.esri.support.modules.ecommerce.EcommerceTrailCustomerPageFeatures;
import com.esri.support.modules.ecommerce.PurchaseOrderPageFeatures;

public class EcommerceTrialCustomerTest extends BaseTestUi {

	private EcommerceAfterLoginPageFeatures afterloginPageFeatures;
	private EcommerceTrailCustomerPageFeatures ecommerceTrialCustomerPageFeatures;
	private EcommerceNewCustomerPageFeatures newCustomerPageFeatures;
	private PurchaseOrderPageFeatures purchaseOrderPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EcommerceTrialCustomerTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test Method to validate functionalities Trail Customer
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "Trial", "Regressions" }, priority = 2)
	public void ValidateTrialCustomer(Map<String, String> inputDataMap) {
		Log.info("Validate Ecommerce Site With Trail Customer");
		afterloginPageFeatures = new EcommerceAfterLoginPageFeatures(driver, inputDataMap);
		purchaseOrderPageFeatures = new PurchaseOrderPageFeatures(driver, inputDataMap);
		newCustomerPageFeatures = new EcommerceNewCustomerPageFeatures(driver, inputDataMap);
		ecommerceTrialCustomerPageFeatures = new EcommerceTrailCustomerPageFeatures(driver, inputDataMap);	
		String subTotalPrice = null;
		String referanceNumber = null;
		reportLogger.assertEquals(afterloginPageFeatures.getTitle(), inputDataMap.get(Ecommerce.HOME_PAGE_TITLE),
				"Validate if the Ecommerce Home Page label is correct.");
		ecommerceTrialCustomerPageFeatures.clickOnsignInToSeePrice();
		purchaseOrderPageFeatures.signIn();
		ecommerceTrialCustomerPageFeatures.clickCreateNewCustomer();
		reportLogger.assertEquals(ecommerceTrialCustomerPageFeatures.retrieveArcGISDesktopBasicHeaderLabel(),
				inputDataMap.get(Ecommerce.HEADER_TEXT_ARCGIS_DESKTOP_BASIC),
				"Validate if the ArcGIS Desktop Basic header label is correct.");
		reportLogger.assertEquals(ecommerceTrialCustomerPageFeatures.retrieveArcGISDesktopBasicCartCountText(),
				Ecommerce.DEFAULT_QUANTITY,
				"Validate if the ArcGIS Desktop Basic item is successfully added to the Cart list.");
		reportLogger.assertEquals(
				ecommerceTrialCustomerPageFeatures.retrieveArcGISDesktopBasicArcGIS3DAnalystCartCountText(),
				Ecommerce.ARCGIS_DESKTOP_QUANTITY,
				"Validate if the ArcGIS 3D Analyst term is successfully added to the Cart list.");
		String headerName = ecommerceTrialCustomerPageFeatures.retrieveArcGISOnlineFirstBuyNowHeaderLabel();
		reportLogger.assertEquals(ecommerceTrialCustomerPageFeatures.retrieveArcGISOnlineNamedUserCartCountText(),
				Ecommerce.ARCGIS3DANALYST_CART_ITEM_COUNT,
				"Validate if the ArcGIS Online " + " " + headerName + "items are successfully added to the Cart list.");
		reportLogger.assertTrue(ecommerceTrialCustomerPageFeatures.isCartErrorMessageDisplayed(),
				"Validate if the cart displayed the error message for ArcGIS 3D Analyst");
		reportLogger.assertEquals(
				ecommerceTrialCustomerPageFeatures.retrieveCartItemCountAfterRemovingArcGIS3DAnalyst(),
				Ecommerce.ARCGIS_DESKTOP_QUANTITY,
				"Validate if the ArcGIS 3D Analyst for Desktop Single Use Term License removed from cart succesfully");
		if (Ecommerce.COUNTRY_AND_CURRENCY.contains("US")) {
			reportLogger.assertEquals(
					ecommerceTrialCustomerPageFeatures.retrieveCartItemCountAfterAddingOfferToTheCart(),
					Ecommerce.ARCGIS3DANALYST_CART_ITEM_COUNT_AFTERDAYS,
					"Validate if the Esri Store Instructor Led Training Voucher is added to the cart succesfully");
		} else {
			subTotalPrice = ecommerceTrialCustomerPageFeatures.retrievePriceAndClickonProceedToCheckout();
			if (subTotalPrice.contains(inputDataMap.get(Ecommerce.CURRENCY_SYMBOL))) {
				reportLogger.assertTrue(true, "Currency displayed correctly at checkout page ");
			}
			if (ecommerceTrialCustomerPageFeatures.retrievePriceDetails()
					.contains(inputDataMap.get(Ecommerce.CURRENCY_SYMBOL))) {
				reportLogger.assertTrue(true, "Price and Currency " + " " + inputDataMap.get(Ecommerce.CURRENCY_SYMBOL)
						+ " displayed correctly at Billing Page ");
			} else {
				reportLogger.assertTrue(false, "Price and Currency " + " " + inputDataMap.get(Ecommerce.CURRENCY_SYMBOL)
						+ " displayed incorrect at Billing Page ");
			}
			ecommerceTrialCustomerPageFeatures.clickonTCOfBillingPage();
			ecommerceTrialCustomerPageFeatures.enterPaymentInformation();
			referanceNumber = ecommerceTrialCustomerPageFeatures.clickContinueToViewOrder();
			reportLogger.assertTrue(ecommerceTrialCustomerPageFeatures.isViewOrderPageTitle(),
					"View Order Page for the referance number" + referanceNumber + "Displayed Sucessfully ");
			ecommerceTrialCustomerPageFeatures.acceptTermsAndSubmitTheOrder();
			reportLogger.assertEquals(ecommerceTrialCustomerPageFeatures.retrieveOrderNumber().trim(),
					referanceNumber.trim(), "Order Completed Page Displayed Sucessfully ");			
			if (ecommerceTrialCustomerPageFeatures.clickViewInvoiceAndRetrieveTotal().contains(inputDataMap.get(Ecommerce.CURRENCY_SYMBOL))) {
				reportLogger.assertTrue(true, "Invoice Page Displayed Sucessfully ");
			}else{
				reportLogger.assertTrue(false, "Currency " + " " + inputDataMap.get(Ecommerce.CURRENCY_SYMBOL)
				+ " Incorrect in Invoice Page ");
			}		
			reportLogger.assertEquals(ecommerceTrialCustomerPageFeatures.retrieveOrderNumber().trim(),
					referanceNumber.trim(), "Verified Order Number in Invoice Page Sucessfully ");
			ecommerceTrialCustomerPageFeatures.clickReturn();
			newCustomerPageFeatures.reviewFullfillmentPage();
			reportLogger.assertEquals(newCustomerPageFeatures.retrieveReferenceNumberFromFulfillment(), referanceNumber,
					"Verified Referance Number in fulfillment Page Sucessfully ");		
			reportLogger.assertTrue(newCustomerPageFeatures.isGoToDownloadAvailableForTrailCustomer(),
					"Customer has an access for Level2 User product Downloads");
			
		}
		closeTest();
	}

}
