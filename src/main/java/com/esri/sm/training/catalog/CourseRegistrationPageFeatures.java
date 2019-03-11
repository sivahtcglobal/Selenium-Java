package com.esri.sm.training.catalog;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.SignInPageFeatures;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;

/**
 * This is the Training site Course Registration page class to perform actions
 * 
 * @author Rizwan
 *
 */
public class CourseRegistrationPageFeatures extends PageObjects {

	private WebDriver driver;
	private Map<String, String> inputDataMap;
	private CourseRegistrationPageObjects courseRegistrationPageObjects;
	private Actions actions;
	private SignInPageFeatures signInPageFeatures;

	/**
	 * Constructor to initialize the Training site Course Registration page
	 * 
	 * @param driver,
	 * @param inputData
	 */
	public CourseRegistrationPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.driver = driver;
		this.inputDataMap = inputDataMap;
		this.courseRegistrationPageObjects = new CourseRegistrationPageObjects(driver);
		signInPageFeatures = new SignInPageFeatures(driver, inputDataMap);
	}

	/**
	 * * Retrieve the Page title
	 * 
	 * @return String
	 */
	public String retrieveTitle() {
		waitForPageToLoad();
		Log.info("Title is : " + getTitle());
		return getTitle();
	}

	/**
	 * Retrieve the Course Registration Page header Label
	 * 
	 * @return String
	 */
	public String retrieveCourseRegistrationHeaderLabel() {
		return getText(courseRegistrationPageObjects.registrationPageHeaderLabel);
	}
	
	/**
	 * Click Register Button
	 * 
	 */
	public void clickRegisterButton() {
		click(courseRegistrationPageObjects.registerButton);
	}

	/**
	 * Performing the click event for Course Registration SignIn Button
	 * 
	 */
	public void clickOnCourseRegistrationSignIn() {
		click(courseRegistrationPageObjects.CourseRegistrationSignInButton);
	}

	/**
	 * Performing the SignIn operation by entering input data
	 * 
	 */
	public void signIn() {
		click(courseRegistrationPageObjects.CourseRegistrationSignInButton);
		signInPageFeatures.signIn();
		waitForPageToLoad();
	}

	/**
	 * Performing the click event for Course Registration Add To Class Waitlist
	 * Button
	 * 
	 */
	public void clickOnAddToWaitlistButton() {
		waitForPageToLoad();
		click(courseRegistrationPageObjects.addToClassWaitlistButton);
	}

	/**
	 * Performing the click event for Next Step Button and getting Organization
	 * Information Header label
	 * 
	 * @return String
	 */
	public String retrieveOrganizationInformationLabel() {
		scrollIntoViewByElement(courseRegistrationPageObjects.nextStepButton);
		click(courseRegistrationPageObjects.nextStepButton);
		return getText(courseRegistrationPageObjects.organizationInformationLabel);
	}

	/**
	 * Enter Organization Information, Purchaser / Billing Information and
	 * payment Method
	 * 
	 */
	public void enterOrganizationInformation() {
		inputText(courseRegistrationPageObjects.organizationNameInputArea,
				inputDataMap.get(CatalogPage.ORGANIZATION_NAME));
		inputText(courseRegistrationPageObjects.addressInputArea, inputDataMap.get(CatalogPage.ADDRESS));
		inputText(courseRegistrationPageObjects.cityInputArea, inputDataMap.get(CatalogPage.CITY));
		inputText(courseRegistrationPageObjects.stateInputArea, inputDataMap.get(CatalogPage.STATE));
		inputText(courseRegistrationPageObjects.zipCodeInputArea, inputDataMap.get(CatalogPage.ZIPCODE));
	}

	/**
	 * Performing the select operation for India country
	 * 
	 */
	public void selectPaymentInfo() {
		click(courseRegistrationPageObjects.countryDropDown);
		click(courseRegistrationPageObjects.indiaItem);
		getText(courseRegistrationPageObjects.sameAsOrganizationInformationText);
		actions = new Actions(driver);
		actions.moveToElement(courseRegistrationPageObjects.sameAsOrganizationInformationCheckBox).click().perform();
		scrollIntoViewByElement(courseRegistrationPageObjects.paymentMethodDropDown);
		click(courseRegistrationPageObjects.paymentMethodDropDown);
		click(courseRegistrationPageObjects.paymentMethodItem);
		inputText(courseRegistrationPageObjects.additionalNotesInputArea, inputDataMap.get(CatalogPage.ADDITINALNOTES));
		click(courseRegistrationPageObjects.reviewSummaryButton);
	}

	/**
	 * Retrieve the First Name Label
	 * 
	 * @return String
	 */
	public String retrieveFirstNameLabel() {
		return getText(courseRegistrationPageObjects.firstNameText);
	}

	/**
	 * Performing the click event for Submit Registration
	 * 
	 */
	public void clickOnSubmitRegistration() {
		scrollIntoViewByElement(courseRegistrationPageObjects.acceptTermsAndConditionsCheckBox);
		click(courseRegistrationPageObjects.acceptTermsAndConditionsCheckBox);
		click(courseRegistrationPageObjects.submitRegistrationButton);
	}

	/**
	 * Retrieve the Thank you for registering Label
	 * 
	 * @return String
	 */
	public String retrievesuccessfulMessageLabel() {
		return getText(courseRegistrationPageObjects.successMessageText);
	}

}
