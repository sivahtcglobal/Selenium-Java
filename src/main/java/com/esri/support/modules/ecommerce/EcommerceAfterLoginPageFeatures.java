package com.esri.support.modules.ecommerce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.EcommerceConstants.Ecommerce;

public class EcommerceAfterLoginPageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private EcommerceAfterLoginPageObjects ecommerceAfterLoginPageObjects;

	public EcommerceAfterLoginPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		this.ecommerceAfterLoginPageObjects = new EcommerceAfterLoginPageObjects(driver);
	}

	/**
	 * Get the Esri Page Title
	 */
	public String getEsriPageTitle() {
		waitForPageToLoad();
		return getTitle();
	}

	/**
	 * Click SingIn Link
	 */
	public void clickSignIn() {
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.signInLink);
		click(ecommerceAfterLoginPageObjects.signInLink);
	}

	/**
	 * Retrieve Customer Page Header text
	 * 
	 * @return String
	 */
	public String retrieveCusomerHeaderText() {
		isElementAvailable(ecommerceAfterLoginPageObjects.selectCustomerheaderText);
		return getText(ecommerceAfterLoginPageObjects.selectCustomerheaderText);
	}

	/**
	 * Select Desired Customer Number from the list of customer details
	 */
	public boolean selectCustomer() {
		String customer = null;
		boolean sCutomerstatus =false;
		try{		
		customer = inputDataMap.get(Ecommerce.CUSTOMER);	
		try {
			Thread.sleep(70000);
		} catch (Exception e) {
			Log.info("Waited for customer list to load",e); 
		}
		Log.info("customer" + customer);
		int customerSize = getSize(ecommerceAfterLoginPageObjects.customerList);
		for (int count = 0; count < customerSize; count++) {
			if (getText(ecommerceAfterLoginPageObjects.customerList.get(count))
					.contains(inputDataMap.get(Ecommerce.CUSTOMER))) {
				WebElement customerTable = convertXpathToWebElement(ecommerceAfterLoginPageObjects.selectAccountButton
						.toString().replace(Ecommerce.COUNT_VALUE, Integer.toString(count + 1)));
				Log.info(customerTable.toString());
				scrollIntoViewByElement(customerTable);
				hoverMouseClick(customerTable); 
				sCutomerstatus =true;
				waitForPageToLoad(30);
				break;
			} 
		}
		}catch(Exception ex){
			Log.info("Waited for customer to select",ex); 
		}
		return sCutomerstatus;
	}
	
	/**
	 * Retrieve the header text of the corresponding page
	 * 
	 * @return String
	 */
	public String retrieveHeaderPagetext() {
		return getText(ecommerceAfterLoginPageObjects.headeraNavigationPageText);
	}
	
	/**
	 * Click the Product Header
	 */
	public void clickProducts(){
		waitForPageToLoad();
		/*if (isElementAvailable(ecommerceAfterLoginPageObjects.acceptButton)) {
			hoverMouseClick(ecommerceAfterLoginPageObjects.acceptButton);
		} else {
			Log.info("Manage Cookie Settings Is Not Avaialble");
		}*/
		//scrollIntoViewByElement(ecommerceAfterLoginPageObjects.productsHeaderLink);
		hoverMouseClick(ecommerceAfterLoginPageObjects.productsHeaderLink);
		waitForPageToLoad(10);
	}

	/**
	 * Retrieve the BuyNow Text Size
	 * 
	 * @param countSize
	 * @return String
	 */
	public String getBuyNowText(int countSize) {
		WebElement element = ecommerceAfterLoginPageObjects.childCardHeaderTextList.get(countSize);
		return getText(element);
	}

	/**
	 * Get the header list
	 * 
	 * @return List<WebElement>
	 */
	public List<WebElement> getHeaderList() {
		return ecommerceAfterLoginPageObjects.headerLinkList;
	}
	
	public int getproductList() {
		waitForPageToLoad();
		return getSize(ecommerceAfterLoginPageObjects.productList);
	}
	
	public int getproductList1() {
		waitForPageToLoad();
		return getSize(ecommerceAfterLoginPageObjects.productList1);
	}
	
	public int getBuyNowList() {
		return getSize(ecommerceAfterLoginPageObjects.BuynowList);
	}
	
	public void scrolltoArticle(int index) {
//		scrolltoelement(whereNextMagazinePageObject.sharelink);
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.productheaderList.get(index));
	}
	public void clickBuynowLinks(int index) {
		WebElement articleText = ecommerceAfterLoginPageObjects.productBuyNowLink.get(index);
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.productBuyNowLink.get(index));
		hoverMouseClick(articleText);			
	}
	public void clickProductLinks(int index) {
		WebElement articleText = ecommerceAfterLoginPageObjects.headerLinkList.get(index);
		//scrollIntoViewByElement(ecommerceAfterLoginPageObjects.headerLinkList.get(index));
		hoverMouseClick(articleText);
		waitForPageToLoad(25);
	}
	public String producttext(int index) {		
		WebElement element = ecommerceAfterLoginPageObjects.headerLinkList.get(index);
		return getText(element);
	}
	public void clickBuynow(int index) {		
		//scrollIntoViewByElement(ecommerceAfterLoginPageObjects.Buynowclicklist.get(index));
		hoverMouseClick(ecommerceAfterLoginPageObjects.Buynowclicklist.get(index));			
	}
	public void closebuynow(){
		click(ecommerceAfterLoginPageObjects.buyNowPOPupclose);
		waitForPageToLoad(25);
	}
	public void clickbuynow(){
		click(ecommerceAfterLoginPageObjects.arcGISForPersonalUseBuyNowButton);
		waitForPageToLoad(25);
	}
	public String getheaderList(int index) {
		return getText(ecommerceAfterLoginPageObjects.productheaderList.get(index));
	}
	/**
	 * Click the Store Header
	 * 
	 * @param element
	 */
	public void clickStoreHeader(WebElement element) {
		click(element);
		waitForPageToLoad(10);	
	}

	/**
	 * Click on "Buy Now" under BASIC and check the page is displayed with
	 * Perpetual and Term options.
	 * 
	 * @return licenseOptionsForBasic
	 */
	private String validateBasicBuyNow() {
		String licenseOptionsForBasic = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.basicBuyNowButton);
		hoverMouseClick(ecommerceAfterLoginPageObjects.basicBuyNowButton);
		licenseOptionsForBasic = retrieveLicenceType();
		return licenseOptionsForBasic;
	}

	/**
	 * Click on "Buy Now" under STANDARD and check the page is displayed with
	 * Perpetual and Term options.
	 * 
	 * @return licenseOptionsForStandard
	 */
	private String validateStandardBuyNow() {
		String licenseOptionsForStandard = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.standardBuyNowButton);
		hoverMouseClick(ecommerceAfterLoginPageObjects.standardBuyNowButton);
		licenseOptionsForStandard = retrieveLicenceType();
		return licenseOptionsForStandard;
	}

	/**
	 * Click on "Buy Now" under ADVANCED and check the page is displayed with
	 * Perpetual and Term options.
	 * 
	 * @return licenseOptionsForAdvanced
	 */
	private String validateAdvancedBuyNow() {
		String licenseOptionsForAdvanced = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.advancedBuyNowButton);
		hoverMouseClick(ecommerceAfterLoginPageObjects.advancedBuyNowButton);
		licenseOptionsForAdvanced = retrieveLicenceType();
		int extentionCount = getSize(ecommerceAfterLoginPageObjects.assoicatedExtensionsList);
		for (int count = 0; count < extentionCount; count++) {
			WebElement element = ecommerceAfterLoginPageObjects.assoicatedExtensionsList.get(count);
			scrollIntoViewByElement(element);
			hoverMouseClick(element);
			if (isElementAvailable(ecommerceAfterLoginPageObjects.perpetualLicensePopupLabel)
					&& (isElementAvailable(ecommerceAfterLoginPageObjects.termLicensePopUpLabel))) {
				Log.info("Extension Available"); 
			}
			scrollIntoViewByElement(ecommerceAfterLoginPageObjects.closeButton);
			hoverMouseClick(ecommerceAfterLoginPageObjects.closeButton);
		}
		return licenseOptionsForAdvanced;
	}

	/**
	 * Returns the size of Buy Now element list
	 * 
	 * @return integer.
	 */
	public List<WebElement> getBuyNowElementList() {
		return ecommerceAfterLoginPageObjects.childCardHeaderTextList;
	}

	/**
	 * Check whether the page is displayed with Perpetual and Term options and
	 * check for Correct Price with currency
	 * 
	 * @return correctPriceForLicense
	 */
	private String retrieveLicenceType() {
		String correctPriceForLicense = null;
		if (isElementAvailable(ecommerceAfterLoginPageObjects.perpetualLicenseLabel)
				&& (isElementAvailable(ecommerceAfterLoginPageObjects.termLicenseLabel))) {
			correctPriceForLicense = checkForCorrectPriceForLicenseType();
		}
		return correctPriceForLicense;
	}

	/**
	 * Check whether the page is displayed with Level 1 and Level 2 and check
	 * for Correct Price with currency
	 * 
	 * @return correctPriceForUserLevel
	 */
	private String retrieveLevelType() {
		String correctPriceForUserLevel = null;
		if (isElementAvailable(ecommerceAfterLoginPageObjects.levelUser1Label)
				&& (isElementAvailable(ecommerceAfterLoginPageObjects.levelUser2Label))) {
			correctPriceForUserLevel = checkForCorrectPriceForUserLevelType();
		}
		return correctPriceForUserLevel;
	}

	/**
	 * Check whether the page is displayed with Auto Renewal and Manual Renewal
	 * check for Correct Price with currency
	 * 
	 * @return correctPriceForRenewelLevel
	 */
	private String retrieveRenewal() {
		String correctPriceForRenewelLevel = null;
		if (isElementAvailable(ecommerceAfterLoginPageObjects.autoRenewalLabel)
				&& (isElementAvailable(ecommerceAfterLoginPageObjects.manualRenewalLabel))) {
			correctPriceForRenewelLevel = checkForCorrectPriceForRenewal();
		}
		return correctPriceForRenewelLevel;
	}

	/**
	 * Check the correct price with currency for renewal type
	 * 
	 * @return correctPriceRenewal
	 */
	private String checkForCorrectPriceForRenewal() {
		String correctPriceRenewal = null;
		Log.info(getText(ecommerceAfterLoginPageObjects.renewalCorrectPriceText));
		if (getText(ecommerceAfterLoginPageObjects.renewalCorrectPriceText)
				.contains(inputDataMap.get(Ecommerce.CURRENCY_SYMBOL))) {
			correctPriceRenewal = getText(ecommerceAfterLoginPageObjects.renewalCorrectPriceText);
		} else {
			Log.info("Price Details Not Available For Renewal");
			correctPriceRenewal = getText(ecommerceAfterLoginPageObjects.renewalCorrectPriceText);
		}
		return correctPriceRenewal;
	}

	/**
	 * Check the correct price with currency for User level type
	 * 
	 * @return correctPriceForUserLevel
	 */
	private String checkForCorrectPriceForUserLevelType() {
		String correctPriceForUserLevel = null;
		Log.info(getText(ecommerceAfterLoginPageObjects.userLevelPriceText));
		if (getText(ecommerceAfterLoginPageObjects.userLevelPriceText)
				.contains(inputDataMap.get(Ecommerce.CURRENCY_SYMBOL))) {
			correctPriceForUserLevel = getText(ecommerceAfterLoginPageObjects.userLevelPriceText);
		} else {
			Log.info("Price Details Not Available For User Level");
			correctPriceForUserLevel = getText(ecommerceAfterLoginPageObjects.userLevelPriceText);
		}
		return correctPriceForUserLevel;
	}

	/**
	 * Check the correct price with currency for license type
	 * 
	 * @return correctPriceForLicense
	 */
	private String checkForCorrectPriceForLicenseType() {
		String correctPriceForLicense = null;
		Log.info(getText(ecommerceAfterLoginPageObjects.licenceTypePriceText));
		if (getText(ecommerceAfterLoginPageObjects.licenceTypePriceText)
				.contains(inputDataMap.get(Ecommerce.CURRENCY_SYMBOL))) {
			correctPriceForLicense = getText(ecommerceAfterLoginPageObjects.licenceTypePriceText);
		} else {
			Log.info("Price Details Not Available For License Type");
			correctPriceForLicense = getText(ecommerceAfterLoginPageObjects.licenceTypePriceText);
		}
		return correctPriceForLicense;
	}	

	/**
	 * Click on "Buy Now" under OnlineNamed Users and check the page is
	 * displayed with Level1 and Level2 options with exact price with currency
	 * 
	 * @return correctPriceForOnline
	 */
	private String validateOnlineNamedUsersBuyNow() {
		String correctPriceForOnline = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISOnlineNamedUsersBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcGISOnlineNamedUsersBuyNowButton);
		correctPriceForOnline = retrieveLevelType();
		return correctPriceForOnline;
	}

	/**
	 * Click on "Buy Now" under Service Credits and check the page is displayed
	 * with Level1 and Level2 options with exact price with currency
	 * 
	 * @return correctPriceForService
	 */
	private String validateServiceCreditsBuyNow() {
		String correctPriceForService = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISOnlineServiceCreditBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcGISOnlineServiceCreditBuyNowButton);
		correctPriceForService = getText(ecommerceAfterLoginPageObjects.correctPriceText);
		return correctPriceForService;
	}

	/**
	 * Click on "Buy Now" under Premium Feature Data Store and check the page is
	 * displayed with Level1 and Level2 options with exact price with currency
	 * 
	 * @return correctPriceForPremium
	 */
	private String validatePremiumDataStoreBuyNow() {
		String correctPriceForPremium = null;
		Log.info("validatePremiumDataStoreBuyNow");
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISOnlinePremiumFeatureBuyNow);
		click(ecommerceAfterLoginPageObjects.arcGISOnlinePremiumFeatureBuyNow);
		correctPriceForPremium = retrieveLevelType();
		return correctPriceForPremium;
	}

	/**
	 * Click on "Buy Now" under Builder and check the page is displayed with
	 * exact price with currency
	 * 
	 * @return correctPriceForBuilder
	 */
	private String validateBuilderBuyNow() {
		String correctPriceForBuilder = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISDeveloperBuilderBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcGISDeveloperBuilderBuyNowButton);
		correctPriceForBuilder = getText(ecommerceAfterLoginPageObjects.correctPriceText);
		return correctPriceForBuilder;
	}

	/**
	 * Click on "Buy Now" under Professional validate the header text and check
	 * the page is displayed with exact price with currency
	 * 
	 * @return correctPriceForProfessional
	 */
	private String validateProfessionalBuyNow() {
		String correctPriceForProfessional = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISDeveloperProfessionalBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcGISDeveloperProfessionalBuyNowButton);
		correctPriceForProfessional = getText(ecommerceAfterLoginPageObjects.correctPriceText);
		return correctPriceForProfessional;
	}

	/**
	 * Click on "Buy Now" under Premium and check the page is displayed with
	 * exact price with currency
	 * 
	 * @return correctPriceForPremium
	 */
	private String validatePremiumBuyNow() {
		String correctPriceForPremium = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISDeveloperPremiumBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcGISDeveloperPremiumBuyNowButton);
		correctPriceForPremium = getText(ecommerceAfterLoginPageObjects.correctPriceText);
		return correctPriceForPremium;
	}

	/**
	 * Click on "Buy Now" under Enterprise and check the page is displayed with
	 * exact price with currency
	 * 
	 * @return correctPriceForEnterprise
	 */
	private String validateEnterpriseBuyNow() {
		String correctPriceForEnterprise = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISDeveloperEnterPriseBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcGISDeveloperEnterPriseBuyNowButton);
		correctPriceForEnterprise = getText(ecommerceAfterLoginPageObjects.correctPriceText);
		return correctPriceForEnterprise;
	}

	/**
	 * * Click on "Buy Now" under ArcGIS Personal check the page is displayed
	 * with exact price with currency
	 * 
	 * @return correctPriceForPersonal
	 */
	public String validateArcGISPersonalUseBuyNow() {
		String correctPriceForPersonal = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISForPersonalUseBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcGISForPersonalUseBuyNowButton);
		correctPriceForPersonal = retrieveRenewal();
		return correctPriceForPersonal;
	}
	
	/**
	 * Click on "Buy Now" under Student Use and check the page is displayed with
	 * exact price with currency
	 * 
	 * @return correctPriceForStudentUse
	 */
	private String validateStudentUseBuyNow(){
		String correctPriceForStudentUse = null;
		if (isElementAvailable(ecommerceAfterLoginPageObjects.arcGISForStudentUseBuyNowButton)) {
			scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISForStudentUseBuyNowButton);
			click(ecommerceAfterLoginPageObjects.arcGISForStudentUseBuyNowButton);
			correctPriceForStudentUse = getText(ecommerceAfterLoginPageObjects.studentUseCorrectPriceText);
		}
		return correctPriceForStudentUse;
	}

	/**
	 * Click on "Buy Now" under ArcPad and check the page is displayed with
	 * exact price with currency
	 * 
	 * @return correctPriceForArcPad
	 */
	private String validateArcPadBuyNow() {
		String correctPriceForArcPad = null;
		if (isElementAvailable(ecommerceAfterLoginPageObjects.arcPadBuyNowButton)) {
			scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcPadBuyNowButton);
			click(ecommerceAfterLoginPageObjects.arcPadBuyNowButton);
			correctPriceForArcPad = getText(ecommerceAfterLoginPageObjects.arcPadCorrectPriceText);
		} else if (isElementAvailable(ecommerceAfterLoginPageObjects.arcPadBuyNowOtherButton)) {
			scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcPadBuyNowOtherButton);
			click(ecommerceAfterLoginPageObjects.arcPadBuyNowOtherButton);
			correctPriceForArcPad = getText(ecommerceAfterLoginPageObjects.arcPadCorrectPriceText);
		}
		return correctPriceForArcPad;
	}

	/**
	 * Click on "Buy Now" under ArcPad with NorthAmerica and check the page is
	 * displayed with exact price with currency
	 * 
	 * @return correctPriceForArcPadNorthAmerica
	 */
	private String validateArcPadWithNorthAmericaBuyNow() {
		String correctPriceForArcPadNorthAmerica = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcPadNorthAmericaBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcPadNorthAmericaBuyNowButton);
		correctPriceForArcPadNorthAmerica = getText(ecommerceAfterLoginPageObjects.arcPadCorrectPriceText);
		return correctPriceForArcPadNorthAmerica;
	}

	/**
	 * Click on "Buy Now" under ArcPad with Europe and check the page is
	 * displayed with exact price with currency
	 * 
	 * @return correctPriceForArcPadEurope
	 */
	private String validateArcPadWithEuropeBuyNow() {
		String correctPriceForArcPadEurope = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcPadEuropeBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcPadEuropeBuyNowButton);
		correctPriceForArcPadEurope = getText(ecommerceAfterLoginPageObjects.arcPadCorrectPriceText);
		return correctPriceForArcPadEurope;
	}

	/**
	 * Click on "Buy Now" under ArcPad with North America & Europe and check the
	 * page is displayed with exact price with currency
	 * 
	 * @return correctPriceForArcPadEurope
	 */
	private String validateNorthAmericaAndEuropeBuyNow() {
		String correctPriceForArcPadEurope = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcPadNorthAmericaAndEuropeBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcPadNorthAmericaAndEuropeBuyNowButton);
		correctPriceForArcPadEurope = getText(ecommerceAfterLoginPageObjects.arcPadCorrectPriceText);
		return correctPriceForArcPadEurope;
	}

	/**
	 * Click on "Buy Now" under Esri City Engine Basic and check the page is
	 * displayed with s with exact price with currency
	 * 
	 * @return correctPriceForCityEngineBasic
	 */
	private String validateCityEngineBasicBuyNow() {
		String correctPriceForCityEngineBasic = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.cityEngineBasicBuyNowButton);
		click(ecommerceAfterLoginPageObjects.cityEngineBasicBuyNowButton);
		correctPriceForCityEngineBasic = getText(ecommerceAfterLoginPageObjects.cityEngineCorrectPriceText);
		return correctPriceForCityEngineBasic;
	}

	/**
	 * Click on "Buy Now" under Esri City Engine Advanced and check the page is
	 * displayed with exact price with currency
	 * 
	 * @return correctPriceForCityEngineAdvanced
	 */
	private String validateCityEngineAdvancedBuyNow() {
		String correctPriceForCityEngineAdvanced = null;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.cityEngineAdvancedBuyNowButton);
		click(ecommerceAfterLoginPageObjects.cityEngineAdvancedBuyNowButton);
		correctPriceForCityEngineAdvanced = getText(ecommerceAfterLoginPageObjects.cityEngineCorrectPriceText);
		return correctPriceForCityEngineAdvanced;
	}

	/**
	 * Select the buy now in all the headers based on selection validate the
	 * header text and validate the sign in to see available and return the text
	 * 
	 * @param linkName
	 *            buy now text
	 * @return Map with the Title of all the links.
	 */
	public Map<String, String> clickBuyNow(String linkName) {
		Map<String, String> mapLinks = new HashMap<>();
		try {
			switch (linkName) {
			case Ecommerce.BASIC:
				Log.info("Click Buy Now in ArcGIS Desktop Basic");
				mapLinks.put(linkName, validateBasicBuyNow());
				break;
			case Ecommerce.STANDARD:
				Log.info("Click Buy Now in ArcGIS Desktop Standard");
				mapLinks.put(linkName, validateStandardBuyNow());
				break;
			case Ecommerce.ADVANCED:
				Log.info("Click Buy Now in ArcGIS Desktop Advanced");
				mapLinks.put(linkName, validateAdvancedBuyNow());
				break;
			case Ecommerce.ONLINE_NAMED_USER:
				Log.info("Click Buy Now in ArcGIS Online Named Users");
				mapLinks.put(linkName, validateOnlineNamedUsersBuyNow());
				break;
			case Ecommerce.ONLINE_NAMED_USERS:
				Log.info("Click Buy Now in ArcGIS Online Named User");
				mapLinks.put(linkName, validateOnlineNamedUsersBuyNow());
				break;
			case Ecommerce.ONLINE_SERVICE_CREDITS:
				Log.info("Click Buy Now in ArcGIS Service Credits");
				mapLinks.put(linkName, validateServiceCreditsBuyNow());
				break;
			case Ecommerce.ONLINE_ABONNEMANG:
				Log.info("Click Buy Now in Namngivna anvandare i");
				mapLinks.put(linkName, validateOnlineNamedUsersBuyNow());
				break;
			case Ecommerce.ONLINE_TJANSTEKREDITER:
				Log.info("Click Buy Now in janstekrediter pa ArcGIS Online");
				mapLinks.put(linkName, validateServiceCreditsBuyNow());
				break;
			case Ecommerce.ONLINE_PREMIUNM_DATA_STORE:
				Log.info("Click Buy Now in janstekrediter pa ArcGIS Online");
				mapLinks.put(linkName, validatePremiumDataStoreBuyNow());
				break;
			case Ecommerce.ONLINE_SUSCRIPCIONES:
				Log.info("Click Buy Now inUsuarios nominales de ArcGIS Online");
				mapLinks.put(linkName, validateOnlineNamedUsersBuyNow());
				break;
			case Ecommerce.ONLINE_SERVICE_CREDITS_BLOC_DE:
				Log.info("Click Buy Now Credits de service ArcGIS Online : bloc de 1 000");
				mapLinks.put(linkName, validateServiceCreditsBuyNow());
				break;
			case Ecommerce.ONLINE_SUBSCRIPTIONS:
				Log.info("Click Buy Now Utilisateurs nommés d’ArcGIS Online");
				mapLinks.put(linkName, validateOnlineNamedUsersBuyNow());
				break;
			case Ecommerce.ONLINE_ADDITIONAL_SERVICE_CREDITS:
				Log.info("Click Buy Now ArcGIS Online-Service-Credits; Block mit 1.000 Stuck");
				mapLinks.put(linkName, validateServiceCreditsBuyNow());
				break;
			case Ecommerce.ONLINE_SUBSKRIPTIONEN:
				Log.info("Click Buy Now subskriptionen ArcGIS Online");
				mapLinks.put(linkName, validateOnlineNamedUsersBuyNow());
				break;
			case Ecommerce.ONLINE_ZUSATZLICHE:
				Log.info("Click Buy Now zusatzliche ArcGIS Online");
				mapLinks.put(linkName, validateServiceCreditsBuyNow());
				break;
			case Ecommerce.ONLINE_ABONNEMENTS:
				Log.info("Click Buy Now ABONNEMENTS ArcGIS Online");
				mapLinks.put(linkName, validateOnlineNamedUsersBuyNow());
				break;
			case Ecommerce.ONLINE_SERVICE_CREDITS_SUPPLEMENTARIES:
				Log.info("Click Buy Now in ArcGIS Service Von  Credits");
				mapLinks.put(linkName, validateServiceCreditsBuyNow());
				break;
			case Ecommerce.BUILDER:
				Log.info("Click Buy Now in Builder");
				mapLinks.put(linkName, validateBuilderBuyNow());
				break;
			case Ecommerce.PROFESSIONAL:
				Log.info("Click Buy Now in Professional");
				mapLinks.put(linkName, validateProfessionalBuyNow());
				break;
			case Ecommerce.PREMIUM:
				Log.info("Click Buy Now in Premium");
				mapLinks.put(linkName, validatePremiumBuyNow());
				break;
			case Ecommerce.ENTERPRISE:
				Log.info("Click Buy Now in Enterprise");
				mapLinks.put(linkName, validateEnterpriseBuyNow());
				break;
			case Ecommerce.ARCGIS_FOR_PERSONAL_USE:
				Log.info("Click Personal Buy Now");
				mapLinks.put(linkName, validateArcGISPersonalUseBuyNow());
				break;
			case Ecommerce.ARCPAD_FOR_STUDENT_USE:
				Log.info("Click Buy Element  for student use");
				mapLinks.put(linkName, validateStudentUseBuyNow());
				break;				
			case Ecommerce.ARCPAD:
				Log.info("Click Buy Element in ArcPad");
				mapLinks.put(linkName, validateArcPadBuyNow());
				break;
			case Ecommerce.ARCPAD_WITH_NORTH_AMERICA:
				Log.info("Click Buy Element in ArcPad with North America");
				mapLinks.put(linkName, validateArcPadWithNorthAmericaBuyNow());
				break;
			case Ecommerce.ARCPAD_WITH_EUROPE:
				Log.info("Click Buy Element in ArcPad with Europe");
				mapLinks.put(linkName, validateArcPadWithEuropeBuyNow());
				break;
			case Ecommerce.ARCPAD_WITH_EUROPE_NORTH_AMERICA:
				Log.info("Click Buy Element in ArcPad with North America and Europe");
				mapLinks.put(linkName, validateNorthAmericaAndEuropeBuyNow());
				break;
			case Ecommerce.ESRI_CITY_ENGINE_BASIC:
				Log.info("Click Buy Now  in  CityEngine Basic");
				mapLinks.put(linkName, validateCityEngineBasicBuyNow());
				break;
			case Ecommerce.ESRI_CITY_ENGINE_ADVANCED:
				Log.info("Click Buy Now  in  CityEngine Advanced");
				mapLinks.put(linkName, validateCityEngineAdvancedBuyNow());
				break;
			default:
				break;
			}
		} catch (Exception ex) {
			Log.error(linkName + " Buy now button click un-successful for After login. ", ex);
		}
		return mapLinks;
	}

	/**
	 * Sign out of the application
	 */
	public void clickSingOut() {
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.esriHeaderAccountButton);
		click(ecommerceAfterLoginPageObjects.esriHeaderAccountButton);
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.esriHeaderAccountSignOutButton);
		click(ecommerceAfterLoginPageObjects.esriHeaderAccountSignOutButton);
	}

}
