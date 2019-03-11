package com.esri.support.modules.ecommerce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.EcommerceConstants.Ecommerce;

public class EcommerceWithOutLoginPageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private EcommerceWithOutLoginPageObjects ecommerceWithOutLoginPageObjects;

	public EcommerceWithOutLoginPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
		this.ecommerceWithOutLoginPageObjects = new EcommerceWithOutLoginPageObjects(driver);
	}

	/**
	 * Retrieve the header text of the corresponding page
	 */
	public String retrieveHeaderPagetext() {
		return getText(ecommerceWithOutLoginPageObjects.headeraNavigationPageText);
	}

	/**
	 * Retrieve the BuyNow Text Size
	 * 
	 * @param countSize
	 * @return String
	 */
	public String getBuyNowText(int countSize) {
		WebElement element = ecommerceWithOutLoginPageObjects.childCardHeaderTextList.get(countSize);
		return getText(element);
	}

	/**
	 * Click the Product Header
	 */
	public void clickProducts(){
		if (isElementAvailable(ecommerceWithOutLoginPageObjects.acceptButton)) {
			hoverMouseClick(ecommerceWithOutLoginPageObjects.acceptButton);
		} else {
			Log.info("Manage Cookie Settings Is Not Avaialble");
		}
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.productsHeaderLink);
		hoverMouseClick(ecommerceWithOutLoginPageObjects.productsHeaderLink);
	}
	/**
	 * get the header list
	 * 
	 * @return List<WebElement>
	 */
	public List<WebElement> getHeaderList() {
		return ecommerceWithOutLoginPageObjects.headerLinkList;
	}

	/**
	 * Click the Store Header
	 * 
	 * @param element
	 */
	public void clickStoreHeader(WebElement element) {
		click(element);
		waitForPageToLoad(5);
	}

	/**
	 * Click on "Buy Now" under BASIC and validate the header text and check the
	 * page is displayed with Perpetual and Term options.
	 * 
	 * @return sSignInText
	 */
	private String validateBasicBuyNow() {
		String signInText = null;
			scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.basicBuyNowButton);
			click(ecommerceWithOutLoginPageObjects.basicBuyNowButton);
			if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
					.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCGIS_DESKTOP_BASIC))) {
				signInText = retrieveSignInTextFromLicenceType();
			}
		return signInText;
	}

	/**
	 * Click on "Buy Now" under STANDARD and validate the header text and check
	 * the page is displayed with Perpetual and Term options.
	 * 
	 * @return sSignInText
	 */
	private String validateStandardBuyNow() {
		String signInText = null;
			scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.standardBuyNowButton);
			click(ecommerceWithOutLoginPageObjects.standardBuyNowButton);
			if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
					.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCGIS_DESKTOP_STANDARD))) {
				signInText = retrieveSignInTextFromLicenceType();
			}
		return signInText;
	}

	/**
	 * Click on "Buy Now" under ADVANCED and validate the header text and check
	 * the page is displayed with Perpetual and Term options.
	 * 
	 * @return sSignInText
	 */
	private String validateAdvancedBuyNow() {
		String signInText = null;
			scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.advancedBuyNowButton);
			click(ecommerceWithOutLoginPageObjects.advancedBuyNowButton);
			if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
					.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCGIS_DESKTOP_ADVANCED))) {
				signInText = retrieveSignInTextFromLicenceType();
				int extentionCount = getSize(ecommerceWithOutLoginPageObjects.assoicatedExtensionsList);
				for (int count = 0; count < extentionCount; count++) {
					WebElement element = ecommerceWithOutLoginPageObjects.assoicatedExtensionsList.get(count);
					scrollIntoViewByElement(element);
					click(element);
					if (isElementAvailable(ecommerceWithOutLoginPageObjects.perpetualLicensePopupLabel)
							&& (isElementAvailable(ecommerceWithOutLoginPageObjects.termLicensePopUpLabel))) {
						getText(ecommerceWithOutLoginPageObjects.signIntoSeePriceTextInPopUp);
					}
					scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.closeButton);
					click(ecommerceWithOutLoginPageObjects.closeButton);
				}
		}
		return signInText;
	}

	/**
	 * Returns the size of Buy Now element list
	 * 
	 * @return integer.
	 */
	public List<WebElement> getBuyNowElementList() {
		return ecommerceWithOutLoginPageObjects.childCardHeaderTextList;
	}

	/**
	 * Check whether the page is displayed with Perpetual and Term options. And
	 * check In place of Price, "Sign in to see Price" is displayed
	 * 
	 * @return boolean
	 */
	private String retrieveSignInTextFromLicenceType() {
		String signIntoSeePriceText = null;
		if (isElementAvailable(ecommerceWithOutLoginPageObjects.perpetualLicenseLabel)
				&& (isElementAvailable(ecommerceWithOutLoginPageObjects.termLicenseLabel))) {
			signIntoSeePriceText = replaceUmlaute(
					getText(ecommerceWithOutLoginPageObjects.licenceTypeSignIntoSeePriceText));
		}
		return signIntoSeePriceText;
	}

	/**
	 * Check whether the page is displayed with Perpetual and Term options. And
	 * check In place of Price, "Sign in to see Price" is displayed
	 * 
	 * @return boolean
	 */
	private String retrieveSignInTextFromLevelType() {
		String signIntoSeePriceText = null;
		if (isElementAvailable(ecommerceWithOutLoginPageObjects.levelUser1Label)
				&& (isElementAvailable(ecommerceWithOutLoginPageObjects.levelUser2Label))) {
			signIntoSeePriceText = replaceUmlaute(
					getText(ecommerceWithOutLoginPageObjects.userLevelSignIntoSeePriceText));
		}
		return signIntoSeePriceText;
	}

	/**
	 * Check whether the page is displayed with manual and automate renewl
	 * options. And check In place of Price, "Sign in to see Price" is displayed
	 * 
	 * @return boolean
	 */
	private String retrieveSignInTextFromRenewal() {
		String signInTextAtRenewelLevel = null;
		if (isElementAvailable(ecommerceWithOutLoginPageObjects.autoRenewalLabel)
				&& (isElementAvailable(ecommerceWithOutLoginPageObjects.manualRenewalLabel))) {
			signInTextAtRenewelLevel = replaceUmlaute(
					getText(ecommerceWithOutLoginPageObjects.renewalSignIntoSeePriceText));
		}
		return signInTextAtRenewelLevel;
	}	

	/**
	 * Click on "Buy Now" under OnlineNamed Users and validate the header text
	 * and check the page is displayed with Level1 and Level2 options.
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validateOnlineNamedUsersBuyNow() {
		String signIntoSeePriceText = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcGISOnlineNamedUsersBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.arcGISOnlineNamedUsersBuyNowButton);
		if (replaceUmlaute(getText(ecommerceWithOutLoginPageObjects.productContentHeaderText).trim())
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCGIS_ONLINE_NAMED_USER).trim())) {
			signIntoSeePriceText = retrieveSignInTextFromLevelType();
		}
		return signIntoSeePriceText;
	}

	/**
	 * Click on "Buy Now" under Service Credits and validate the header text and
	 * check the page is displayed with Level1 and Level2 options.
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validateServiceCreditsBuyNow() {
		String signIntoSeePriceText = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcGISOnlineServiceCreditBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.arcGISOnlineServiceCreditBuyNowButton);
		if (replaceUmlaute(getText(ecommerceWithOutLoginPageObjects.productContentHeaderText))
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCGIS_ONLINE_SERVICE_CREDITS))) {
			signIntoSeePriceText = replaceUmlaute(getText(ecommerceWithOutLoginPageObjects.signIntoSeePriceText));
		}
		return signIntoSeePriceText;
	}

	/**
	 * Click on "Buy Now" under Premium Feature Data Store validate the header
	 * text and check the page is displayed with Level1 and Level2 options.
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validatePremiumDataStoreBuyNow() {
		String signIntoSeePriceText = null;
		Log.info("validatePremiumDataStoreBuyNow");
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcGISOnlinePremiumFeatureBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.arcGISOnlinePremiumFeatureBuyNowButton);
		signIntoSeePriceText = retrieveSignInTextFromLevelType();
		return signIntoSeePriceText;
	}

	/**
	 * Click on "Buy Now" under Builder validate the header text and check the
	 * page is displayed with signInText option
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validateBuilderBuyNow() {
		String signIntoSeePriceText = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcGISDeveloperBuilderBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.arcGISDeveloperBuilderBuyNowButton);
		if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCGIS_DEVELOPER_BUILDER))) {
			signIntoSeePriceText = replaceUmlaute(getText(ecommerceWithOutLoginPageObjects.signIntoSeePriceText));
		}
		return signIntoSeePriceText;
	}

	/**
	 * Click on "Buy Now" under Professional validate the header text and check
	 * the page is displayed with signInText option
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validateProfessionalBuyNow() {
		String signIntoSeePriceText = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcGISDeveloperProfessionalBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.arcGISDeveloperProfessionalBuyNowButton);
		if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCGIS_DEVELOPER_PROFESSIONAL))) {
			signIntoSeePriceText = replaceUmlaute(getText(ecommerceWithOutLoginPageObjects.signIntoSeePriceText));
		}
		return signIntoSeePriceText;
	}

	/**
	 * Click on "Buy Now" under Premium validate the header text and check the
	 * page is displayed with signInText option
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validatePremiumBuyNow() {
		String signIntoSeePriceText = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcGISDeveloperPremiumBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.arcGISDeveloperPremiumBuyNowButton);
		if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCGIS_DEVELOPER_PREMIUM))) {
			signIntoSeePriceText = replaceUmlaute(getText(ecommerceWithOutLoginPageObjects.signIntoSeePriceText));
		}
		return signIntoSeePriceText;
	}

	/**
	 * Click on "Buy Now" under Enterprise validate the header text and check
	 * the page is displayed with signInText option
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validateEnterpriseBuyNow() {
		String signIntoSeePriceText = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcGISDeveloperEnterPriseBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.arcGISDeveloperEnterPriseBuyNowButton);
		if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCGIS_DEVELOPER_ENTERPRISE))) {
			signIntoSeePriceText = replaceUmlaute(getText(ecommerceWithOutLoginPageObjects.signIntoSeePriceText));
		}
		return signIntoSeePriceText;
	}

	/**
	 * Click ArcGIS For Personal Use Buy Now
	 * 
	 * @return sSignInTextAtUserLevel
	 */
	public String validateArcGISPersonalUseBuyNow() {
		String signInTextAtUserLevel = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcGISDeveloperEnterPriseBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.arcGISForPersonalUseBuyNowButton);
		if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCGIS_PERSONAL_USE))) {
			signInTextAtUserLevel = retrieveSignInTextFromRenewal();
		}

		return signInTextAtUserLevel;
	}
	
	/**
	 * Click on "Buy Now" under Student Use and check the page is displayed with
	 * exact price with currency
	 * 
	 * @return correctPriceForStudentUse
	 */
	private String validateStudentUseBuyNow(){
		String correctPriceForStudentUse = null;
		if (isElementAvailable(ecommerceWithOutLoginPageObjects.arcGISForStudentUseBuyNowButton)) {
			scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcGISForStudentUseBuyNowButton);
			click(ecommerceWithOutLoginPageObjects.arcGISForStudentUseBuyNowButton);
			correctPriceForStudentUse = getText(ecommerceWithOutLoginPageObjects.studentUseCorrectPriceText);
		}
		return correctPriceForStudentUse;
	}

	/**
	 * Click on "Buy Now" under ArcPad and validate the header text and check
	 * the page is displayed with signInText option
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validateArcPadBuyNow() {
		String signIntoSeePriceText = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcPadBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.arcPadBuyNowButton);
		if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCPAD))) {
			signIntoSeePriceText = replaceUmlaute(getText(ecommerceWithOutLoginPageObjects.arcPadsignIntoSeePriceText));
		}
		return signIntoSeePriceText;
	}

	/**
	 * Click on "Buy Now" under ArcPad with NorthAmerica and validate the header
	 * text and check the page is displayed with signInText option
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validateArcPadWithNorthAmericaBuyNow() {
		String signIntoSeePriceText = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcPadNorthAmericaBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.arcPadNorthAmericaBuyNowButton);
		if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCPAD_NORTH_AMERICA))) {
			signIntoSeePriceText = getText(ecommerceWithOutLoginPageObjects.arcPadsignIntoSeePriceText);
		}
		return signIntoSeePriceText;
	}

	/**
	 * Click on "Buy Now" under ArcPad with Europe and validate the header text
	 * and check the page is displayed with signInText option
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validateArcPadWithEuropeBuyNow() {
		String signIntoSeePriceText = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcPadEuropeBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.arcPadEuropeBuyNowButton);
		if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCPAD_EUROPE))) {
			signIntoSeePriceText = getText(ecommerceWithOutLoginPageObjects.arcPadsignIntoSeePriceText);
		}
		return signIntoSeePriceText;
	}

	/**
	 * Click on "Buy Now" under ArcPad with North America & Europe and validate
	 * the header text and check the page is displayed with signInText option
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validateENorthAmericaAndEuropeBuyNow() {
		String signIntoSeePriceText = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.arcPadNorthAmericaAndEuropeBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.arcPadNorthAmericaAndEuropeBuyNowButton);
		if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_ARCPAD_AMERICA_EUROPE))) {
			signIntoSeePriceText = getText(ecommerceWithOutLoginPageObjects.arcPadsignIntoSeePriceText);
		}
		return signIntoSeePriceText;
	}

	/**
	 * Click on "Buy Now" under Esri City Engine Basic validate the header text
	 * and check the page is displayed with signInText option
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validateCityEngineBasicBuyNow() {
		String signIntoSeePriceText = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.cityEngineBasicBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.cityEngineBasicBuyNowButton);
		if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_CITY_ENGINE_BASIC))) {
			signIntoSeePriceText = replaceUmlaute(
					getText(ecommerceWithOutLoginPageObjects.cityEngineSignIntoSeePriceText));
		}
		return signIntoSeePriceText;
	}

	/**
	 * Click on "Buy Now" under Esri City Engine Advanced validate the header
	 * text and check the page is displayed with signInText option
	 * 
	 * @return sSignIntoSeePriceText
	 */
	private String validateCityEngineAdvancedBuyNow() {
		String signIntoSeePriceText = null;
		scrollIntoViewByElement(ecommerceWithOutLoginPageObjects.cityEngineAdvancedBuyNowButton);
		click(ecommerceWithOutLoginPageObjects.cityEngineAdvancedBuyNowButton);
		if (getText(ecommerceWithOutLoginPageObjects.productContentHeaderText)
				.equals(inputDataMap.get(Ecommerce.HEADER_TEXT_CITY_ENGINE_ADVANCED))) {
			signIntoSeePriceText = replaceUmlaute(
					getText(ecommerceWithOutLoginPageObjects.cityEngineSignIntoSeePriceText));
		}
		return signIntoSeePriceText;
	}

	/**
	 * This method will replace special character to avoid utf issue
	 * 
	 * @param orig
	 * @return String
	 */
	public String replaceUmlaute(String orig) {
		String result = orig;
		String[][] UMLAUT_REPLACEMENTS = { { new String("Logga in för att se pris"), "Logga in for att se pris" },
				{ new String("Iniciar sesión para ver el precio"), "Iniciar sesion para ver el precio" },
				{ new String("Utilisateurs nommés d’ArcGIS Online - Abonnements annuels"),
						"Utilisateurs nommes d ArcGIS Online - Abonnements annuels" },
				{ new String("ArcGIS Online-Service-Credits; Block mit 1.000 Stück"),
						"ArcGIS Online-Service-Credits; Block mit 1.000 Stuck" },
				{ new String("Tjänstekrediter på ArcGIS Online; 1000-pack"),
						"Tjanstekrediter pa ArcGIS Online; 1000-pack" },
				{ new String("Årligt abonnemang på ArcGIS Online för namngivna användare"),
						"Arligt abonnemang pa ArcGIS Online for namngivna anvandare" },
				{ new String("Named-User-Jahressubskriptionen für ArcGIS Online"),
						"Named-User-Jahressubskriptionen fur ArcGIS Online" },
				{ new String("Crédits de service ArcGIS Online : bloc de 1 000"),
						"Credits de service ArcGIS Online : bloc de 1 000" },
				{ new String("Suscripción mensual Premium Feature Data Store"),
						"Suscripcion mensual Premium Feature Data Store" },
				{ new String("Crédits de service supplémentaires"), "Credits de service supplementaires" }, };
		for (int i = 0; i < UMLAUT_REPLACEMENTS.length; i++) {
			if ("Logga in för att se pris".equals(result) || "Iniciar sesión para ver el precio".equals(result)
					|| "Crédits de service ArcGIS Online : bloc de 1 000".equals(result)
					|| "ArcGIS Online-Service-Credits; Block mit 1.000 Stück".equals(result)
					|| "Årligt abonnemang på ArcGIS Online för namngivna användare".equals(result)
					|| "Suscripción mensual Premium Feature Data Store".equals(result)
					|| "Named-User-Jahressubskriptionen für ArcGIS Online".equals(result)
					|| "Utilisateurs nommés d’ArcGIS Online - Abonnements annuels".equals(result)
					|| "Crédits de service supplémentaires".equals(result)
					|| "Tjänstekrediter på ArcGIS Online; 1000-pack".equals(result)) {
				result = result.replaceAll(UMLAUT_REPLACEMENTS[i][0], UMLAUT_REPLACEMENTS[i][1]);
			}
		}
		return result;
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
				mapLinks.put(linkName, validateENorthAmericaAndEuropeBuyNow());
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
			Log.error(linkName + " Buy now button click un-successful for with out login. ", ex);
		}
		return mapLinks;
	}

}
