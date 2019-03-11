package com.esri.sm.myesri.myorganization;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This is the MY Esri.com My Organizations tab Training web page class to
 * identify the objects within the page
 * 
 * @author Rizwan
 *
 */

public class TrainingPageObjects {

	@FindBy(xpath = "//nav[@class='sub-nav-list phone-hide']/a[contains(text(), 'My Organizations')]")
	protected WebElement myOrganizationsLink;

	@FindBy(id = "appTitle")
	protected WebElement myOrganizationHeaderLabel;

	@FindBy(xpath = "//nav[@class='column-24']/a[@class='third-nav-link ng-binding']")
	protected List<WebElement> myEsriSubLinks;

	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope is-active']/nav/a")
	protected List<WebElement> usersSubLinks;

	@FindBy(css = "a.crumb.ng-binding.ng-scope")
	protected WebElement myOrganizationCommonHeaderLabel;

	@FindBy(xpath = "//a[@class='third-nav-link ng-binding'][contains(text(), 'Training')]")
	protected WebElement trainingLink;

	@FindBy(xpath = "(//a[@class='btn btn-clear btn-fill leader-1 ng-binding'])[1]")
	protected List<WebElement> trainingRecordsLinkFromTrainingOverview;

	@FindBy(xpath = "(//a[@class='btn btn-clear btn-fill leader-1 ng-binding'])[2]")
	protected List<WebElement> virtualCampusAnnualUserLicensesFromTrainingOverview;

	@FindBy(css = "aside#my-training-hook > nav > a:nth-child(1)")
	protected WebElement trainingOverviewLink;

	@FindBy(css = "aside#my-training-hook > nav > a:nth-child(2)")
	protected WebElement trainingRecordsSideLink;

	@FindBy(css = "aside#my-training-hook > nav > a:nth-child(3)")
	protected WebElement virtualCampusAnnualUserLicensesSideLink;

	@FindBy(xpath = "//*[@id='main-content']/div[2]/div[1]/div/a")
	protected WebElement trainingRecordsLink;

	@FindBy(xpath = "//*[@id='main-content']/div[2]/div[2]/div/a")
	protected WebElement virtualCampusAnnualUserLicensesLink;

	@FindBy(xpath = "//a[@class='tab-title js-tab ng-binding']")
	protected WebElement byPersonLink;

	@FindBy(xpath = "//a[@class='k-link'][contains(text(), 'Person')]")
	protected WebElement personLabel;

	@FindBy(xpath = ".//*[@id='appHeader']/div[2]/div[2]/a")
	protected WebElement reportLink;

	@FindBy(xpath = "//button[@class='dropdown-btn js-dropdown-toggle btn btn-transparent btn-link font-size-3']")
	protected WebElement trainingRecordsLabel;

	@FindBy(xpath = "(//button[@class='btn btn-clear'])[1]")
	protected WebElement exitReportButton;

	@FindBy(css = "button.btn.btn-transparent.btn-small.ng-binding")
	protected WebElement moreInformationLink;

	@FindBy(xpath = "//div[@class='panel panel-white trailer-1']")
	protected WebElement moreInfoPanel;
	
	@FindBy(css = "a.btn.btn-green.ng-binding")
	protected WebElement orderReportsLink;

	@FindBy(xpath = "//div[@class='grid-container']/div[2]//h3")
	protected WebElement myEsriReportsHeaderLabel;

	@FindBy(xpath = "//button[@class='btn btn-clear'][contains(text(), 'Exit Reports')]")
	protected WebElement exitReportsButton;

	/**
	 * Initialize the PageObject for MY Esri.com My Organizations- Organization
	 * List web page
	 * 
	 * @param driver
	 *
	 */
	public TrainingPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
