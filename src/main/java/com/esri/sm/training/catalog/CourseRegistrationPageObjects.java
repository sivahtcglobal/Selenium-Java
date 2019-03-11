package com.esri.sm.training.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the Training Site Course Registration page class to identify the
 * objects
 * 
 * @author Rizwan
 *
 */
public class CourseRegistrationPageObjects {

	@FindBy(css = "div.grid-container.margin-top-lg.margin-bottom-xl.ng-scope > div:nth-child(1)")
	public WebElement registrationPageHeaderLabel;

	@FindBy(css = "button.btn.pull-right.ng-binding.ng-scope")
	public WebElement CourseRegistrationSignInButton;

	@FindBy(xpath = "//input[@id='user_username']")
	public WebElement userName;

	@FindBy(xpath = "//input[@id='user_password']")
	public WebElement password;

	@FindBy(xpath = "//button[@id='signIn']")
	public WebElement commonSignInButton;

	@FindBy(css = "div.bg-off-white.clearfix > button")
	public WebElement addToClassWaitlistButton;

	@FindBy(xpath = "//*[@id='esriu']/div[2]/div[2]/div[4]/form/div[2]/div[7]/div/button[2]")
	public WebElement nextStepButton;

	@FindBy(xpath = "//div[@class='margin-top-xl column-24 avenir-regular font-size-2 off-black ng-binding'][contains(text(), 'Organization Information')]")
	public WebElement organizationInformationLabel;

	@FindBy(css = "form.ng-pristine.ng-invalid.ng-invalid-required.ng-valid-email.ng-valid-pattern > div:nth-child(2) > div:nth-child(1) > input")
	public WebElement organizationNameInputArea;

	@FindBy(css = "form.ng-invalid.ng-invalid-required.ng-valid-email.ng-valid-pattern.ng-dirty.ng-valid-parse  > div:nth-child(3) > div:nth-child(1) > input")
	public WebElement addressInputArea;

	@FindBy(css = "input.form-control.full-width.ng-pristine.ng-empty.ng-invalid.ng-invalid-required.ng-touched")
	public WebElement enterDataInputArea;

	@FindBy(css = "form.ng-invalid.ng-invalid-required.ng-valid-email.ng-valid-pattern.ng-dirty.ng-valid-parse > div:nth-child(4) > div:nth-child(1) > input")
	public WebElement cityInputArea;

	@FindBy(css = "form.ng-invalid.ng-invalid-required.ng-valid-email.ng-valid-pattern.ng-dirty.ng-valid-parse > div:nth-child(5) > div:nth-child(1) > select")
	public WebElement countryDropDown;

	@FindBy(css = "form.ng-invalid.ng-invalid-required.ng-valid-email.ng-valid-pattern.ng-dirty.ng-valid-parse > div:nth-child(5) > div:nth-child(1) > select > option:nth-child(105)")
	public WebElement indiaItem;

	@FindBy(css = "form.ng-invalid.ng-invalid-required.ng-valid-email.ng-valid-pattern.ng-dirty.ng-valid-parse > div:nth-child(4) > div:nth-child(2) > input")
	public WebElement stateInputArea;

	@FindBy(css = "form.ng-invalid.ng-invalid-required.ng-valid-email.ng-valid-pattern.ng-dirty.ng-valid-parse > div:nth-child(5) > div:nth-child(2) > input")
	public WebElement zipCodeInputArea;

	@FindBy(css = "form.ng-invalid.ng-invalid-required.ng-valid-email.ng-valid-pattern.ng-dirty.ng-valid-parse > div:nth-child(8) > input")
	public WebElement sameAsOrganizationInformationCheckBox;

	@FindBy(css = "form.ng-invalid.ng-invalid-required.ng-valid-email.ng-valid-pattern.ng-dirty.ng-valid-parse > div:nth-child(8) > label > span")
	public WebElement sameAsOrganizationInformationText;

	@FindBy(xpath = "//div[@class='column-4 margin-top-md']/select")
	public WebElement paymentMethodDropDown;

	@FindBy(xpath = "//div[@class='column-4 margin-top-md']/select/option[contains(text(), 'Pending')]")
	public WebElement paymentMethodItem;

	@FindBy(xpath = "//div[@class='column-16 margin-top-lg ng-scope']/textarea")
	public WebElement additionalNotesInputArea;

	@FindBy(xpath = "//div[@class='column-16 text-right margin-top-md']/button[contains(text(), 'Review Summary')]")
	public WebElement reviewSummaryButton;

	@FindBy(xpath = "//div[@class='column-4 ng-binding ng-scope'][contains(text(), 'Training')]")
	public WebElement firstNameText;

	@FindBy(css = "input#acceptTsCs")
	public WebElement acceptTermsAndConditionsCheckBox;

	@FindBy(xpath = "(//button[@class='btn ng-binding'][contains(text(), 'Submit Registration')])[2]")
	public WebElement submitRegistrationButton;

	@FindBy(xpath = "//div[@class='esriu-dark-green avenir-regular font-size-2 margin-top-xl column-24 ng-binding']")
	public WebElement successMessageText;
	
	@FindBy(css = ".btn.btn-large")
	protected WebElement registerButton;
	
	/**
	 * Initialize the PageObject for Training Site Course Registration page
	 * 
	 * @param driver
	 *
	 */
	public CourseRegistrationPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
