package com.esri.support.modules.ecommerce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.EcommerceConstants.Ecommerce;

public class EcommerceQuantityValidationPageFeatures extends PageObjects {

	private EcommerceAfterLoginPageObjects ecommerceAfterLoginPageObjects;
	private EcommerceQuantityValidationPageObjects ecommerceQuantityValidationPageObjects;

	public EcommerceQuantityValidationPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.ecommerceAfterLoginPageObjects = new EcommerceAfterLoginPageObjects(driver);
		this.ecommerceQuantityValidationPageObjects = new EcommerceQuantityValidationPageObjects(driver);
	}

	/**
	 * get the header list
	 * 
	 * @return String
	 */
	public String getPageTitle() {
		waitForPageToLoad();
		return getTitle();
	}

	/**
	 * get the header list
	 * 
	 * @return
	 */
	public List<WebElement> getHeaderList() {
		waitForPageToLoad();
		return ecommerceQuantityValidationPageObjects.headerLinkList;
	}

	/**
	 * Click the header list
	 * 
	 * @return
	 */
	public void clickonHeaderList(int index) {
		click(ecommerceQuantityValidationPageObjects.headerLinkList.get(index));
	}
	
	/**
	 * Check whether the page quantity warning message is hide or not
	 * 
	 * @return boolean
	 */
	public boolean isQuantityWarningMessageHide() {
		boolean warningMessageHide = true;
		waitForPageToLoad(5);
		inputText(ecommerceQuantityValidationPageObjects.quantityInputArea, Ecommerce.DEFAULT_QUANTITY);
		hitEnter(ecommerceQuantityValidationPageObjects.quantityInputArea);
		if (isElementAvailable(ecommerceQuantityValidationPageObjects.warningMessageLabelHideText)) {
			warningMessageHide = false;
		}
		return warningMessageHide;
	}

	/**
	 * Check whether the page quantity warning message is displayed or not for
	 * level 1 users
	 * 
	 * @return boolean
	 */
	public boolean isQuantityWarningMessageDisplayedForNamedLevel1Users() {
		boolean warningMessage = false;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.levelUser1Label);
		click(ecommerceAfterLoginPageObjects.levelUser1Label);
		inputText(ecommerceQuantityValidationPageObjects.quantityInputArea, Ecommerce.ARCGIS_ONLINE_QUANTITY);
		hitEnter(ecommerceQuantityValidationPageObjects.quantityInputArea);
		if (isDisplayed(ecommerceQuantityValidationPageObjects.warningMessageLabel)) {
			warningMessage = true;
		}
		return warningMessage;
	}

	/**
	 * Check whether the page quantity warning message is displayed or not for
	 * ArcGIS Desktop Basic
	 * 
	 * @return boolean
	 */
	public boolean isQuantityWarningMessageDisplayedForArcGISDesktopBasic() {
		boolean warningMessage = false;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.levelUser1Label);
		click(ecommerceAfterLoginPageObjects.levelUser1Label);
		inputText(ecommerceQuantityValidationPageObjects.quantityInputArea, Ecommerce.ARCGIS_DESKTOP_QUANTITY);
		hitEnter(ecommerceQuantityValidationPageObjects.quantityInputArea);
		if (isDisplayed(ecommerceQuantityValidationPageObjects.warningMessageLabel)) {
			warningMessage = true;
		}
		return warningMessage;
	}

	/**
	 * Check whether the page quantity warning message is displayed or not for
	 * level 2 users
	 * 
	 * @return boolean
	 */
	public boolean isQuantityWarningMessageDisplayedForManualRenewal() {
		boolean warningMessage = false;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.levelUser2Label);
		click(ecommerceAfterLoginPageObjects.levelUser2Label);
		inputText(ecommerceQuantityValidationPageObjects.quantityInputArea, Ecommerce.ARCGIS_DESKTOP_QUANTITY);
		hitEnter(ecommerceQuantityValidationPageObjects.quantityInputArea);
		if (isDisplayed(ecommerceQuantityValidationPageObjects.warningMessageLabel)) {
			warningMessage = true;
		}
		return warningMessage;
	}

	/**
	 * Check whether the page quantity warning message is displayed or not for
	 * Mac users
	 * 
	 * @return boolean
	 */
	public boolean isQuantityWarningMessageDisplayedForMac() {
		boolean warningMessage = false;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.macLabel);
		click(ecommerceAfterLoginPageObjects.macLabel);
		inputText(ecommerceQuantityValidationPageObjects.quantityInputArea, Ecommerce.CITYENGINE_BASIC_QUANTITY);
		hitEnter(ecommerceQuantityValidationPageObjects.quantityInputArea);
		if (isDisplayed(ecommerceQuantityValidationPageObjects.warningMessageLabel)) {
			warningMessage = true;
		}
		return warningMessage;
	}

	/**
	 * Check whether the page quantity warning message is displayed or not for
	 * Mac users
	 * 
	 * @return boolean
	 */
	public boolean isQuantityWarningMessageDisplayedForWindows() {
		boolean warningMessage = false;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.levelUser1Label);
		click(ecommerceAfterLoginPageObjects.levelUser1Label);
		inputText(ecommerceQuantityValidationPageObjects.quantityInputArea, Ecommerce.CITYENGINE_BASIC_QUANTITY);
		hitEnter(ecommerceQuantityValidationPageObjects.quantityInputArea);
		if (isDisplayed(ecommerceQuantityValidationPageObjects.warningMessageLabel)) {
			warningMessage = true;
		}
		return warningMessage;
	}

	/**
	 * Check whether the page quantity warning message is displayed or not for
	 * Mac users
	 * 
	 * @return boolean
	 */
	public boolean isQuantityWarningMessageDisplayedForLinux() {
		boolean warningMessage = false;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.levelUser2Label);
		click(ecommerceAfterLoginPageObjects.levelUser2Label);
		inputText(ecommerceQuantityValidationPageObjects.quantityInputArea, Ecommerce.CITYENGINE_BASIC_QUANTITY);
		hitEnter(ecommerceQuantityValidationPageObjects.quantityInputArea);
		if (isDisplayed(ecommerceQuantityValidationPageObjects.warningMessageLabel)) {
			warningMessage = true;
		}
		return warningMessage;
	}

	/**
	 * Check whether the page quantity warning message is displayed or not for
	 * Developer Subscription
	 * 
	 * @return boolean
	 */
	public boolean isQuantityWarningMessageDisplayedForDeveloperSubscription() {
		boolean warningMessageHide = true;
		inputText(ecommerceQuantityValidationPageObjects.quantityInputArea,
				Ecommerce.ARCGIS_DEVELOPER_SUBSCRIPTION_QUANTITY);
		hitEnter(ecommerceQuantityValidationPageObjects.quantityInputArea);
		if (isElementAvailable(ecommerceQuantityValidationPageObjects.warningMessageLabelHideText)) {
			warningMessageHide = false;
		}
		return warningMessageHide;
	}

	/**
	 * Check whether the page quantity warning message is displayed or not for
	 * level 2 users
	 * 
	 * @return boolean
	 */
	public boolean isQuantityWarningMessageDisplayedForNamedUserAnnualSubscriptionsLevel2Users() {
		boolean warningMessage = false;
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.levelUser2Label);
		click(ecommerceAfterLoginPageObjects.levelUser2Label);
		inputText(ecommerceQuantityValidationPageObjects.quantityInputArea, Ecommerce.ARCGIS_ONLINE_QUANTITY);
		hitEnter(ecommerceQuantityValidationPageObjects.quantityInputArea);
		if (isDisplayed(ecommerceQuantityValidationPageObjects.warningMessageLabel)) {
			warningMessage = true;
		}
		return warningMessage;
	}

	/**
	 * Click on "Basic Buy Now" under BASIC and validate the quantity warning
	 * message
	 * 
	 * @return boolean
	 */
	public boolean validateBasicBuyNowQuantityWarningMessage() {
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.basicBuyNowButton);
		click(ecommerceAfterLoginPageObjects.basicBuyNowButton);
		return isQuantityWarningMessageDisplayedForArcGISDesktopBasic();
	}

	/**
	 * Click on "Standard Buy Now" under STANDARD and validate the quantity
	 * warning message
	 * 
	 * @return boolean
	 */
	public boolean validateStandardBuyNowQuantityWarningMessage() {
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.standardBuyNowButton);
		click(ecommerceAfterLoginPageObjects.standardBuyNowButton);
		return isQuantityWarningMessageDisplayedForArcGISDesktopBasic();
	}

	/**
	 * Click on "Advanced Buy Now" under ADVANCED and validate the quantity
	 * warning message
	 * 
	 * @return boolean
	 */
	public boolean validateAdvancedBuyNowQuantityWarningMessage() {
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.advancedBuyNowButton);
		click(ecommerceAfterLoginPageObjects.advancedBuyNowButton);
		return isQuantityWarningMessageDisplayedForArcGISDesktopBasic();
	}

	/**
	 * Click on ArcGIS Online followed by click on Named Users Buy Now
	 * 
	 * @return boolean
	 */
	public void clickOnArcGISOnlineNamedUsersBuyNow() {
		click(ecommerceQuantityValidationPageObjects.arcGISOnlineLink);
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.cityEngineBasicBuyNowLink);
		click(ecommerceQuantityValidationPageObjects.cityEngineBasicBuyNowLink);
	}

	/**
	 * Click on ArcGIS For Personal Use followed by click on ArcGIS For Personal
	 * Use Buy Now
	 * 
	 * @return boolean
	 */
	public void clickOnArcGISForPersonalUseBuyNow() {
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.arcGISForPersonalUseLink);
		click(ecommerceQuantityValidationPageObjects.arcGISForPersonalUseLink);
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.arcGISForPersonalUseBuyNowLink);
		click(ecommerceQuantityValidationPageObjects.arcGISForPersonalUseBuyNowLink);
	}

	/**
	 * Click on ArcGIS For Student Use followed by click on Buy Now
	 */
	public void clickOnArcGISForStudentUseBuyNow() {
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.arcGISForStudentUseLink);
		click(ecommerceQuantityValidationPageObjects.arcGISForStudentUseLink);
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.arcGISForStudentUseBuyNowLink);
		click(ecommerceQuantityValidationPageObjects.arcGISForStudentUseBuyNowLink);
	}

	/**
	 * Check whether the page quantity warning message is displayed or not for
	 * ArcGIS student use for auto renewal
	 * 
	 * @return boolean
	 */
	public boolean isQuantityWarningMessageDisplayedForArcGISStudentUseAutoRenewal() {
		boolean warningMessage = false;
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.studentUseAutoRenewalLabel);
		click(ecommerceQuantityValidationPageObjects.studentUseAutoRenewalLabel);
		inputText(ecommerceQuantityValidationPageObjects.quantityInputArea, Ecommerce.ARCGIS_DESKTOP_QUANTITY);
		hitEnter(ecommerceQuantityValidationPageObjects.quantityInputArea);
		if (isDisplayed(ecommerceQuantityValidationPageObjects.warningMessageLabel)) {
			warningMessage = true;
		}
		return warningMessage;
	}

	/**
	 * Check whether the page quantity warning message is displayed or not for
	 * ArcGIS student use for manual renewal
	 * 
	 * @return boolean
	 */
	public boolean isQuantityWarningMessageDisplayedForArcGISStudentUseManualRenewal() {
		boolean warningMessage = false;
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.studentUseManualRenewalLabel);
		click(ecommerceQuantityValidationPageObjects.studentUseManualRenewalLabel);
		inputText(ecommerceQuantityValidationPageObjects.quantityInputArea, Ecommerce.ARCGIS_DESKTOP_QUANTITY);
		hitEnter(ecommerceQuantityValidationPageObjects.quantityInputArea);
		if (isDisplayed(ecommerceQuantityValidationPageObjects.warningMessageLabel)) {
			warningMessage = true;
		}
		return warningMessage;
	}

	/**
	 * Click on Builder Buy Now and validate the quantity warning message
	 * 
	 * @return boolean
	 */
	public boolean validateBuilderBuyNowQuantityWarningMessage() {
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISDeveloperBuilderBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcGISDeveloperBuilderBuyNowButton);
		return isQuantityWarningMessageDisplayedForDeveloperSubscription();
	}

	/**
	 * Click on Professional Buy Now and validate the quantity warning message
	 * 
	 * @return boolean
	 */
	public boolean validateProfessionalBuyNowQuantityWarningMessage() {
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISDeveloperProfessionalBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcGISDeveloperProfessionalBuyNowButton);
		return isQuantityWarningMessageDisplayedForDeveloperSubscription();
	}

	/**
	 * Click on Premium Buy Now and validate the quantity warning message
	 * 
	 * @return boolean
	 */
	public boolean validatePremiumBuyNowQuantityWarningMessage() {
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISDeveloperPremiumBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcGISDeveloperPremiumBuyNowButton);
		return isQuantityWarningMessageDisplayedForDeveloperSubscription();
	}

	/**
	 * Click on Enterprise Buy Now and validate the quantity warning message
	 * 
	 * @return boolean
	 */
	public boolean validateEnterpriseBuyNowQuantityWarningMessage() {
		scrollIntoViewByElement(ecommerceAfterLoginPageObjects.arcGISDeveloperEnterPriseBuyNowButton);
		click(ecommerceAfterLoginPageObjects.arcGISDeveloperEnterPriseBuyNowButton);
		return isQuantityWarningMessageDisplayedForDeveloperSubscription();
	}

	/**
	 * Click on ArcPad with North America and Europe 2013 Buy Now and validate
	 * the quantity warning message
	 * 
	 * @return boolean
	 */
	private boolean validateNorthAmericaAndEuropeBuyNowQuantityWarningMessage() {
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.arcPadNorthAmericaAndEuropeBuyNowButton);
		click(ecommerceQuantityValidationPageObjects.arcPadNorthAmericaAndEuropeBuyNowButton);
		return isQuantityWarningMessageDisplayedForArcPad();
	}

	/**
	 * Click on ArcPad with Europe 2013 Buy Now and validate the quantity
	 * warning message
	 * 
	 * @return boolean
	 */
	private boolean validateArcPadWithEuropeBuyNowQuantityWarningMessage() {
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.arcPadEuropeBuyNowButton);
		click(ecommerceQuantityValidationPageObjects.arcPadEuropeBuyNowButton);
		return isQuantityWarningMessageDisplayedForArcPad();
	}

	/**
	 * Click on ArcPad with North America 2013 Buy Now and validate the quantity
	 * warning message
	 * 
	 * @return boolean
	 */
	private boolean validateArcPadWithNorthAmericaBuyNowQuantityWarningMessage() {
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.arcPadNorthAmericaBuyNowButton);
		click(ecommerceQuantityValidationPageObjects.arcPadNorthAmericaBuyNowButton);
		return isQuantityWarningMessageDisplayedForArcPad();
	}

	/**
	 * Click on ArcPad Buy Now and validate the quantity warning message
	 * 
	 * @return boolean
	 */
	private boolean validateArcPadBuyNowQuantityWarningMessage() {
		if (isElementAvailable(ecommerceQuantityValidationPageObjects.arcPadBuyNowOtherButton)) {
			scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.arcPadBuyNowOtherButton);
			click(ecommerceQuantityValidationPageObjects.arcPadBuyNowOtherButton);
			return isQuantityWarningMessageDisplayedForArcPad();
		} else {
			scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.arcPadBuyNowButton);
			click(ecommerceQuantityValidationPageObjects.arcPadBuyNowButton);
			return isQuantityWarningMessageDisplayedForArcPad();
		}

	}
	
	/**
	 * Check whether the page quantity warning message is displayed or not for
	 * ArcPad
	 * 
	 * @return boolean
	 */
	private boolean isQuantityWarningMessageDisplayedForArcPad() {
		boolean warningMessage = false;
		inputText(ecommerceQuantityValidationPageObjects.quantityInputArea, Ecommerce.ARCGIS_DESKTOP_QUANTITY);
		hitEnter(ecommerceQuantityValidationPageObjects.quantityInputArea);
		if (isDisplayed(ecommerceQuantityValidationPageObjects.warningMessageLabel)) {
			warningMessage = true;
		}
		return warningMessage;
	}

	/**
	 * Click on City Engine followed by click on Esri City Engine Basic Buy Now
	 */
	public void clickOnEsriCityEngineBasicBuyNow() {
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.cityEngineLink);
		click(ecommerceQuantityValidationPageObjects.cityEngineLink);
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.cityEngineBasicBuyNowLink);
		click(ecommerceQuantityValidationPageObjects.cityEngineBasicBuyNowLink);
	}

	/**
	 * Click on City Engine followed by click on Esri City Engine Advanced Buy
	 * Now
	 */
	public void clickOnEsriCityEngineAdvancedBuyNow() {
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.cityEngineLink);
		click(ecommerceQuantityValidationPageObjects.cityEngineLink);
		scrollIntoViewByElement(ecommerceQuantityValidationPageObjects.cityEngineAdvancedBuyNowLink);
		click(ecommerceQuantityValidationPageObjects.cityEngineAdvancedBuyNowLink);
	}	


	/**
	 * Select the buy now in all the headers based on selection validate the
	 * header text and validate the sign in to see available and return the text
	 * 
	 * @param linkName
	 *            buy now text
	 * @return Map with the Title of all the links.
	 */
	public Map<String, Boolean> clickBuyNow(String linkName) {
		Map<String, Boolean> mapLinks = new HashMap<>();
		try {
			switch (linkName) {
			case Ecommerce.BASIC:
				Log.info("Click Buy Now in ArcGIS Desktop Basic");
				mapLinks.put(linkName, validateBasicBuyNowQuantityWarningMessage());
				break;
			case Ecommerce.STANDARD:
				Log.info("Click Buy Now in ArcGIS Desktop Standard");
				mapLinks.put(linkName, validateStandardBuyNowQuantityWarningMessage());
				break;
			case Ecommerce.ADVANCED:
				Log.info("Click Buy Now in ArcGIS Desktop Advanced");
				mapLinks.put(linkName, validateAdvancedBuyNowQuantityWarningMessage());
				break;			
			case Ecommerce.BUILDER:
				Log.info("Click Buy Now in Builder");
				mapLinks.put(linkName, validateBuilderBuyNowQuantityWarningMessage());
				break;
			case Ecommerce.PROFESSIONAL:
				Log.info("Click Buy Now in Professional");
				mapLinks.put(linkName, validateProfessionalBuyNowQuantityWarningMessage());
				break;
			case Ecommerce.PREMIUM:
				Log.info("Click Buy Now in Premium");
				mapLinks.put(linkName, validatePremiumBuyNowQuantityWarningMessage());
				break;
			case Ecommerce.ENTERPRISE:
				Log.info("Click Buy Now in Enterprise");
				mapLinks.put(linkName, validateEnterpriseBuyNowQuantityWarningMessage());
				break;			
			case Ecommerce.ARCPAD:
				Log.info("Click Buy Element in ArcPad");
				mapLinks.put(linkName, validateArcPadBuyNowQuantityWarningMessage());
				break;
			case Ecommerce.ARCPAD_WITH_NORTH_AMERICA:
				Log.info("Click Buy Element in ArcPad with North America");
				mapLinks.put(linkName, validateArcPadWithNorthAmericaBuyNowQuantityWarningMessage());
				break;
			case Ecommerce.ARCPAD_WITH_EUROPE:
				Log.info("Click Buy Element in ArcPad with Europe");
				mapLinks.put(linkName, validateArcPadWithEuropeBuyNowQuantityWarningMessage());
				break;
			case Ecommerce.ARCPAD_WITH_EUROPE_NORTH_AMERICA:
				Log.info("Click Buy Element in ArcPad with North America and Europe");
				mapLinks.put(linkName, validateNorthAmericaAndEuropeBuyNowQuantityWarningMessage());
				break;
			default:
				break;
			}
		} catch (Exception ex) {
			Log.error(linkName + " Buy now button click un-successful for Quantity Validation. ", ex);
		}
		return mapLinks;
	}

}
