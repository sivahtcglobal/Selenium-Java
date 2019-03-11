	package com.esri.support.modules.isp;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.config.Env;

/**
 * This is the Image submission portal feature class
 * 
 * @author thenmozhi
 *
 */
public class ImageSubPortalPageFeatures extends ImageSubPortalPageObjects {

	private Map<String, String> inputDataMap;

	public ImageSubPortalPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.inputDataMap = inputDataMap;
	}

	/**
	 * This method launches the Image submission page url.
	 */
	public void navigateToHomePage() {
		super.openURL(Env.get("IMAGESUBMISSION"));
	}

	/**
	 * This method gets the title of the page.
	 * 
	 * @return String.
	 */
	public String getPageTitle() {
		return getTitle();
	}

	/**
	 * This method gets the text of the welcome header of the page.
	 * 
	 * @return String.
	 */
	public String getWelcomeLabel() {
		return getText(welcomeHeader);
	}

	/**
	 * This method gets the text of the welcome header of the page.
	 * 
	 * @return String.
	 */
	public String getImageSubmissionFormHeader() {
		return getText(imageSubmissionFormHeader);
	}

	/**
	 * This method clicks events dropdown and selects the first drown down
	 * 
	 */
	public void selectEvent() {
		//click(eventsDropDown);
		click(eventsFirstOptionButton);
	}

	/**
	 * This method clicks the Get Started button.
	 */
	public void clickGetStartedBtn() {
		click(getStartedBtn);
	}

	/**
	 * This method clicks the No radio button.
	 */
	public void clickNoRadioBtn() {
		click(noRadioBtn);
	}

	/**
	 * This method clicks the Yes radio button.
	 */
	public void clickYesRadioBtn() {
		click(yesRadioBtn);
	}

	/**
	 * This method clicks the Continue button.
	 */
	public void clickContinueBtn() {
		clickAfterScroll(continueBtn);
	}

	/**
	 * This method clicks the Video Radio button.
	 */
	public void clickVideoRadioBtn() {
		click(videoRadioBtn);
	}

	/**
	 * This method gets the video page header.
	 */
	public String getVideoPageHeader() {
		return getText(videoPageHeader);
	}

	/**
	 * This method gets the permission page header.
	 */
	public String getPermissionPageHeader() {
		return getText(permissionPageHeader);
	}

	/**
	 * This method clicks I Agree check box.
	 */
	public void clickIAgreeCheckBox() {
		click(iAgreeChkBox);
	}

	/**
	 * This method gets I Agree page header.
	 */
	public String getIAgreePageHeader() {
		return getText(iAgreePageHeader);
	}
	
}
