package com.esri.support.modules.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the Esri Site Core Sign page objects.
 * 
 * @author Rizwan
 *
 */
public class SignInPageObjects {

	@FindBy(xpath = "//iframe[@id='oAuthFrame']")
	protected WebElement oAuthFrame;

	@FindBy(xpath = "//input[@id='user_username']")
	public WebElement userName;

	@FindBy(xpath = "//input[@id='user_password']")
	public WebElement password;

	@FindBy(xpath = "//button[@id='signIn']")
	public WebElement commonSignInButton;

	/**
	 * Initialize the PageObject for Esri Training - My Learning submenu page
	 * 
	 * @param driver
	 *
	 */
	public SignInPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}