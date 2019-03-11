package com.esri.support.modules.core;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;
import com.esri.support.modules.core.SignInPageObjects;

/**
 * This is the Esri Site Core Sign in Page feature class.
 * 
 * @author Rizwan
 */
public class SignInPageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private WebDriver driver;
	private SignInPageObjects signInPageObjects;

	/**
	 * Constructor to initialize the Training site My Learning Menu page
	 * 
	 * @param driver,
	 * @param inputDataMap
	 */
	public SignInPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.driver = driver;
		this.inputDataMap = inputDataMap;
		this.signInPageObjects = new SignInPageObjects(driver);
	}

	/**
	 * This method performs sign in action. After launching the url, switch to
	 * login frame and inputs of username and password and click on "Sign in"
	 * button.
	 */
	public void signIn() {
		switchToFrame(signInPageObjects.oAuthFrame);
		inputText(signInPageObjects.userName, inputDataMap.get(MyEsriUserPages.USERNAME));
		inputText(signInPageObjects.password, inputDataMap.get(MyEsriUserPages.PASSWORD));
		click(signInPageObjects.commonSignInButton);
		driver.switchTo().defaultContent();
	}
}
