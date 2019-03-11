package com.esri.sm.myesri.myorganization;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This is the MY Esri.com My Organizations web page class to identify the
 * objects within the page
 * 
 * @author Rizwan
 *
 */

public class TransactionsPageObjects {
	
	@FindBy(css ="a.cookie-banner-action.esri-cookie-banner__button-two.button")
	public WebElement acceptCookiesButton;

	@FindBy(xpath = "//nav[@class='sub-nav-list phone-hide']/a[contains(text(), 'My Organizations')]")
	protected WebElement myOrganizationsLink;

	@FindBy(xpath = "//nav[@class='column-24']/a[@class='third-nav-link ng-binding']")
	protected List<WebElement> myEsriSubLinks;
	
	@FindBy(xpath = "//button[@class='btn btn-clear btn-wrap btn-fill leader-half ng-binding']")
	protected List<WebElement> transactionOverviewSubLinks;

	@FindBy(id = "appTitle")
	protected WebElement myOrganizationHeaderLabel;

	@FindBy(css = "#appHeader > div.right > a")
	protected WebElement moreInformationLink;

	@FindBy(xpath = "//div[@class='panel panel-white trailer-1']")
	protected WebElement moreInfoPanel;
	
	@FindBy(xpath = "//*[@id='appHeader']/div[2]/div[2]/button")
	protected WebElement moreInfoPanelHeaderText;

	@FindBy(css = "a.crumb.ng-binding.ng-scope")
	protected WebElement myOrganizationCommonHeaderLabel;

	@FindBy(xpath = "//a[@class='third-nav-link ng-binding'][contains(text(), 'Transactions')]")
	protected WebElement TransactionsLink;
	
	@FindBy(xpath = "//*[@id='left-nav']/aside[7]/div[1]/nav/a[1]")
	protected WebElement TransactionOverviewLink;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope is-active']")
	protected WebElement transactionsOverviewLink;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Transactions Overview')]")
	protected WebElement transactionsOverviewfromOrderHistoryLink;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Order History')]")
	protected WebElement orderHistoryLink;

	@FindBy(css = "a.btn.btn-transparent.btn-small.ng-binding")
	protected WebElement maintenanceQuotesMoreInformationLink;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Maintenance Quotes')]")
	protected WebElement maintenanceQuotesLink;

	@FindBy(xpath = "//button[@class='btn btn-clear btn-wrap btn-fill leader-half ng-binding'][contains(text(), 'Order History')]")
	protected WebElement orderHistoryButton;

	@FindBy(css = "#appTitle")
	protected WebElement headerLabel;

	@FindBy(css = "a.btn.btn-green.ng-binding.ng-scope")
	protected WebElement orderReportsLink;

	@FindBy(xpath = "//div[@class='grid-container']/div[2]//h3")
	protected WebElement myEsriReportsHeaderLabel;

	@FindBy(xpath = "//button[@class='btn btn-clear'][contains(text(), 'Exit Reports')]")
	protected WebElement exitReportsButton;

	@FindBy(xpath = "//a[@class='side-nav-link ng-binding ng-isolate-scope'][contains(text(), 'Maintenance Quotes')]")
	protected WebElement maintenanceQuotesButton;

	/**
	 * Initialize the PageObject for MY Esri.com site My Organizations tab -
	 * Overview web page
	 * 
	 * @param driver
	 *
	 */
	public TransactionsPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
