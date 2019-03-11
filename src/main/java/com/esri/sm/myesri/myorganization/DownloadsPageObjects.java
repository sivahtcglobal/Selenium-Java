package com.esri.sm.myesri.myorganization;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This is the MY Esri.com My Organizations tab Downloads web page class to
 * identify the objects within the page
 * 
 * @author Rizwan
 *
 */

public class DownloadsPageObjects {

	@FindBy(xpath = "//nav[@class='sub-nav-list phone-hide']/a[contains(text(), 'My Organizations')]")
	protected WebElement myOrganizationsLink;

	@FindBy(id = "appTitle")
	protected WebElement myOrganizationHeaderLabel;

	@FindBy(xpath = "//nav[@class='column-24']/a[@class='third-nav-link ng-binding']")
	protected List<WebElement> myEsriSubLinks;

	@FindBy(xpath = "//aside[@class='side-nav side-nav-collection is-active']/div/nav/a")
	protected List<WebElement> downloadsSubLinks;

	@FindBy(css = "a.crumb.ng-binding.ng-scope")
	protected WebElement myOrganizationCommonHeaderLabel;

	@FindBy(xpath = "//a[@class='third-nav-link ng-binding'][contains(text(), 'Downloads')]")
	protected WebElement downloadsLink;
	
	@FindBy(xpath = "//aside[@class='side-nav side-nav-collection is-active']/div/nav/a[contains(text(), 'Products')]")
	protected WebElement productsLink;
	
	@FindBy(css = "div.k-grid-content.k-auto-scrollable > table > tbody > tr")
	protected WebElement productsSearchResultsCount;
	
	@FindBy(xpath = "(//td[@class='text-center']/a)[1]")
	protected WebElement viewDownloadFirstItemLink;
	
	@FindBy(css = "a.btn.btn-transparent.btn-small.ng-binding")
	protected WebElement moreInformationLink;

	@FindBy(xpath = "//div[@class='panel panel-white trailer-1']")
	protected WebElement moreInfoPanel;
	
	@FindBy(css = "input#quickSearch")
	protected WebElement quickSearchInputArea;
	
	@FindBy(xpath = "//button[@class='btn btn-clear-search icon-ui-flush']")
	protected WebElement quickSearchClearButton;
	
	@FindBy(css = "div.k-grid-content.k-auto-scrollable > table > tbody > tr")
	protected List<WebElement> searchResultsCount;
	
	@FindBy(xpath = "(//a[@class='download-btn btn btn-clear'])[1]")
	protected WebElement viewDownloadsLink;
	
	@FindBy(xpath = "//h4[@class='ng-binding'][contains(text(), 'Download')]")
	protected WebElement downloadHeaderLabel;
	
	@FindBy(xpath = "//div[@ng-repeat='category in display.categories']")
	protected List<WebElement> downloadComponentsCount;
	
	@FindBy(xpath = "//a[@class='tab-title js-tab ng-binding']")
	protected WebElement systemRequirementsLink;
	
	@FindBy(css = "ul.leader-1.trailer-1 > li")
	protected List<WebElement> systemRequirementsDataCount;
	
	@FindBy(xpath = "//a[@class='btn btn-clear ng-binding'][contains(text(), 'Back to Downloads')]")
	protected WebElement backToDownloadsLink;
	
	@FindBy(xpath = "//aside[@class='side-nav side-nav-collection is-active']/div/nav/a[contains(text(), 'Product Components')]")
	protected WebElement productComponentsLink;
	
	@FindBy(xpath = "//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr")
	protected List<WebElement> productComponentsCount;
	
	@FindBy(css = "#downloadSorter_mn_active > span > span")
	protected WebElement sortByFilterProductsComponents;
	
	@FindBy(css = "#downloadSorter_mn_active > div > ul > li:nth-child(2) > span")
	protected WebElement sortByFilterProductsComponentsProductItem;
	
	@FindBy(xpath = "//aside[@class='side-nav side-nav-collection is-active']/div/nav/a[contains(text(), 'Data and Content')]")
	protected WebElement dataAndContentLink;
	
	@FindBy(xpath = "//aside[@class='side-nav side-nav-collection is-active']/div/nav/a[contains(text(), 'Apps')]")
	protected WebElement appsLink;
	
	@FindBy(xpath = "//aside[@class='side-nav side-nav-collection is-active']/div/nav/a[contains(text(), 'Database Support Files')]")
	protected WebElement databaseSupportFilesLink;

	@FindBy(xpath = "//aside[@class='side-nav side-nav-collection is-active']/div/nav/a[contains(text(), 'Developer Tools')]")
	protected WebElement developerToolsLink;
	
	@FindBy(xpath = "//aside[@class='side-nav side-nav-collection is-active']/div/nav/a[contains(text(), 'Language packs')]")
	protected WebElement languagePacksLink;
	
	@FindBy(xpath = "//aside[@class='side-nav side-nav-collection is-active']/div/nav/a[contains(text(), 'Download ISO Files')]")
	protected WebElement downloadISOFilesLink;
	
	@FindBy(xpath = "//aside[@class='side-nav side-nav-collection is-active']/div/nav/a[contains(text(), 'Request Media')]")
	protected WebElement requestMediaLink;
	
	@FindBy(css = "button#populateWithProfile")
	protected WebElement populateUserFieldsFromMyProfileButton;
	
	@FindBy(css = "button#populateWithOrg")
	protected WebElement populateOrganizationFieldsFromMyOrganizationButton;
	
	@FindBy(xpath = "//button[@class='btn btn-blue ng-binding']")
	protected WebElement contactAndShippingInformationNextButton;
	
	@FindBy(xpath = "(//input[@class='checkbox'])[1]")
	protected WebElement selectProductCheckBox;
	
	@FindBy(xpath = "//a[@class='btn btn-blue btn_step_next ng-binding']")
	protected WebElement selectProductNextButton;
	
	@FindBy(css = "a#btn_step3_next")
	protected WebElement selectQuantityAndLanguageNextButton;
	
	@FindBy(xpath = "(//span[@class='async-button-text'])[1]")
	protected WebElement sendRequestButton;
		
	/**
	 * Initialize the PageObject for MY Esri.com My Organizations- Organization
	 * List web page
	 * 
	 * @param driver
	 *
	 */
	public DownloadsPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
