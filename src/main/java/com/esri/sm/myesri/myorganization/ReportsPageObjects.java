package com.esri.sm.myesri.myorganization;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * This is the MY Esri.com My Organizations tab Reports web page class to
 * identify the objects within the page
 *
 * @author Rizwan
 *
 */

public class ReportsPageObjects {

    @FindBy(xpath = "//nav[@class='sub-nav-list phone-hide']/a[contains(text(), 'My Organizations')]")
    protected WebElement myOrganizationsLink;

    @FindBy(id = "appTitle")
    protected WebElement myOrganizationHeaderLabel;

    @FindBy(xpath = "//nav[@class='column-24']/a[@class='third-nav-link ng-binding']")
    protected List<WebElement> myEsriSubLinks;

    @FindBy(css = "a.crumb.ng-binding.ng-scope")
    protected WebElement myOrganizationCommonHeaderLabel;

    @FindBy(xpath = "//a[@class='third-nav-link ng-binding'][contains(text(), 'Reports')]")
    protected WebElement reportsLink;

    @FindBy(css="#reportsOverview > div.grid-container > div.ng-scope > div > div > div > p > span.right > a")
    protected List<WebElement> myOrganizationReportsTabReportsList;
    
    @FindBy(css="#reportsOverview > div.grid-container > div.ng-scope > div > div > div > h5 > a")
    protected List<WebElement> myOrganizationReportsTabReportsHeaderLabelList;
    
    @FindBy(css="#reportSelector > app-report-selection > app-calcite-dropdown > div > app-calcite-dropdown-title > button > span:nth-child(1)")
    protected WebElement myOrganizationReportsTabReportsHeaderLabel;
        
    @FindBy(xpath = "//button[@class='btn btn-clear'][contains(text(), 'Exit Reports')]")
	protected WebElement exitReport;

    @FindBy(css = "button.btn.btn-transparent.btn-small.ng-binding")
    protected WebElement moreInformationLink;

    @FindBy(xpath = "//div[@class='panel panel-white trailer-1']")
    protected WebElement moreInfoPanel;

    /**
     * Initialize the PageObject for MY Esri.com My Organizations- Events web
     * page
     * 
     * @param driver
     *
     */
    public ReportsPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}