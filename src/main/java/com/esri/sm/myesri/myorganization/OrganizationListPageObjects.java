package com.esri.sm.myesri.myorganization;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This is the MY Esri.com My Organizations tab Organization List web page class
 * to identify the objects within the page
 * 
 * @author Rizwan
 *
 */

public class OrganizationListPageObjects {

	@FindBy(xpath = "//nav[@class='sub-nav-list phone-hide']/a[contains(text(), 'My Organizations')]")
	protected WebElement myOrganizationsLink;

	@FindBy(id = "appTitle")
	protected WebElement myOrganizationHeaderLabel;

	@FindBy(css = "a.crumb.ng-binding.ng-scope")
	protected WebElement myOrganizationCommonHeaderLabel;

	@FindBy(xpath = "//a[@class='third-nav-link link-blue ng-binding ng-scope']")
	protected WebElement organizationListLink;

	@FindBy(css = "select#filterFields")
	protected WebElement filterByLink;

	@FindBy(xpath = "//select[@id='filterFields']/option[contains(text(), 'Name')]")
	protected WebElement filterDropDownItemName;
	
	@FindBy(xpath = "//select[@id='filterFields']/option[contains(text(), 'Customer Number')]")
	protected WebElement filterDropDownItemCustomerNumber;
	
	@FindBy(css = "#my-org-hook > h4")
	protected WebElement overViewHeaderLabel;

	@FindBy(css = "input#customerFilter")
	protected WebElement enterFilterInputArea;

	@FindBy(xpath = "//a[@class='btn btn-clear leader-0 inline-block ng-binding']")
	protected WebElement filterApplyLink;

	@FindBy(xpath = "(//a[@class='link-darkest-gray ng-binding'])[1]")
	protected WebElement esriLabel;

	@FindBy(css = "div.overflow-auto.organization-list-container > div > div:nth-child(2) > table > tbody > tr")
	protected List<WebElement> filterResultsCount;

	@FindBy(xpath = "(//button[@class='btn btn-clear approve large ng-binding'])[1]")
	protected WebElement selectButton;

	@FindBy(xpath = "//*[@id='customerSelection']/div[2]/div/div/div[2]/div/div[1]/div/div[2]/div/div[3]/button")
	protected WebElement selectOrganizationButton;
	
	@FindBy(xpath = "//a[@class='ng-binding']")
	protected WebElement expandCollapseAllLink;

	@FindBy(xpath = "//div[@class='panel panel-white is-active']")
	protected WebElement expandAllResults;

	@FindBy(xpath = "(//button[@class='btn btn-clear btn-small ng-binding'])[1]")
	protected WebElement selectOrgButton;
	
	@FindBy(xpath = ".//*[@id='organizationProfile']/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[4]/button")
	protected WebElement organizationButton;
	

	/**
	 * Initialize the PageObject for MY Esri.com My Organizations- Organization
	 * List web page
	 * 
	 * @param driver
	 *
	 */
	public OrganizationListPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
