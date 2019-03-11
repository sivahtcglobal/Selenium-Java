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

public class ProgramsPageObjects {

    @FindBy(xpath = "//nav[@class='sub-nav-list phone-hide']/a[contains(text(), 'My Organizations')]")
    protected WebElement myOrganizationsLink;

    @FindBy(id = "appTitle")
    protected WebElement myOrganizationHeaderLabel;

    @FindBy(xpath = "//nav[@class='column-24']/a[@class='third-nav-link ng-binding']")
    protected List<WebElement> myEsriSubLinks;

    @FindBy(css = "a.crumb.ng-binding.ng-scope")
    protected WebElement myOrganizationCommonHeaderLabel;

    @FindBy(xpath = "//a[@class='third-nav-link ng-binding'][contains(text(), 'Programs')]")
    protected WebElement programsLink;

    @FindBy(css="a#eeap-object-1")
    protected WebElement TrainingLink;
        
    @FindBy(css=".tab-section.js-tab-section.ng-scope.is-active > div:nth-child(1) >div > form > div > input")
    protected WebElement trainingQuickSearchInputArea;
        
    @FindBy(css="article.tab-section.js-tab-section.ng-scope.is-active")
    protected WebElement trainingSearchData;
        
    @FindBy(css="a#eeap-object-2")
    protected WebElement additionalServicesLink;
        
    @FindBy(css = "a#eeap-object-0")
	protected WebElement consultingLink;

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
    public ProgramsPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}