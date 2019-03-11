package com.esri.sm.myesri.myorganization;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * This is the MY Esri.com My Organizations tab Support web page class to
 * identify the objects within the page
 * 
 * @author Rizwan
 *
 */

public class SupportPageObjects {

	@FindBy(xpath = "//nav[@class='sub-nav-list phone-hide']/a[contains(text(), 'My Organizations')]")
	protected WebElement myOrganizationsLink;

	@FindBy(xpath = "//nav[@class='column-24']/a[@class='third-nav-link ng-binding']")
	protected List<WebElement> myEsriSubLinks;
	
	@FindBy(xpath = "//aside[@class='side-nav ng-isolate-scope is-active']/nav/a")
	protected List<WebElement> supportSubLinks;
	
	@FindBy(id = "appTitle")
	protected WebElement myOrganizationHeaderLabel;

	@FindBy(css = "div#appHeader > div:nth-child(2) > div:nth-child(2) > button")
	protected WebElement moreInformationLink;

	@FindBy(xpath = "//div[@class='panel panel-white trailer-1']")
	protected WebElement moreInfoPanel;

	@FindBy(css = "a.crumb.ng-binding.ng-scope")
	protected WebElement myOrganizationCommonHeaderLabel;

	@FindBy(xpath = "//a[@class='third-nav-link ng-binding'][contains(text(), 'Support')]")
	protected WebElement supportLink;
	
	@FindBy(xpath = "//*[@id='supportOverviewHeader']/div/div[1]/div[1]/div/a/h4/span[2]")
	protected WebElement standardCasesLink;
	
	@FindBy(xpath = "//*[@id='supportOverviewHeader']/div/div[1]/div[1]/div/a")
	protected WebElement premiumCasesLink;
	
	@FindBy(xpath = "//*[@id='supportOverviewHeader']/div/div[1]/div[3]/div/a")
	protected WebElement supportOverviewbugsLink;
	
	@FindBy(css = "#sideNavSupportOverviewItem")
	protected WebElement supportOverviewLink;
		
	@FindBy(css = "div.panel.panel-white.trailer-1 > div > h4 > a")
	protected WebElement viewMoreActivityLink;
	
	@FindBy(id = "SupportActivity")
	protected WebElement recentActivityLink;
	
	@FindBy(css = "#caseList > div:nth-child(1) > div.subject.padding-left-1 > span:nth-child(1) > span")
	protected WebElement recentActivityFirstItemLink;
	
	@FindBy(css = "#supportCaseDetails > div.ng-scope > div > h3")
	protected WebElement recentActivityFirstItemHeaderLabel;
	
	@FindBy(css = "#sideNavSupportCaseItem")
	protected WebElement casesLink;
		
	@FindBy(css = "#caseList > div:nth-child(1) > div > div:nth-child(1) > div > h5 > a")
	protected WebElement casesFirstItemLink;
	
	@FindBy(css = "#sideNavSupportBugItem")
	protected WebElement bugsLink;
	
	@FindBy(css = "#bugList > tbody:nth-child(1) > tr:nth-child(1) > td.text-left.padding-trailer-0 > h5 > a:nth-child(1)")
	protected WebElement bugsFirstItemLink;
	
	@FindBy(css = "#supportBugDetails > div.ng-scope > div > h3")
	protected WebElement bugsFirstItemHeaderLabel;
	
	@FindBy(css = "#sideNavSupportAuthorizedCallerItem")
	protected WebElement authorizedCallersLink;
		
	@FindBy(css = "a.actionText.ng-binding")
	protected WebElement learnMoreAboutPremiumSupportLink;
	
	@FindBy(css = "#j_username")
	protected WebElement userName;
	
	@FindBy(css = "#j_password")
	protected WebElement passWord;
	
	@FindBy(css = "#submit")
	protected WebElement signIn;
	
	@FindBy(css = "#quickSearch")
	protected WebElement AuthorizedCallersSearchInputArea;
	
	@FindBy(css = "#authorizedCallerGrid > div > table > tbody > tr")
	protected List<WebElement> AuthorizedCallersSearchResultsList;
	
	@FindBy(css = "#sideNavSupportLink > a")
	protected WebElement visitSupportEsriComLink;
	
	@FindBy(css = "#sideNavGeoNetLink > a")
	protected WebElement talkToTheCommunityLink;
	
	/**
	 * Initialize the PageObject for MY Esri.com site My Organizations tab -
	 * Support web page
	 * 
	 * @param driver
	 *
	 */
	public SupportPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
