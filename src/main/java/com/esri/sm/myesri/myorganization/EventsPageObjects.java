package com.esri.sm.myesri.myorganization;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * This is the MY Esri.com My Organizations tab Events web page class to
 * identify the objects within the page
 *
 * @author Rizwan
 *
 */

public class EventsPageObjects {

    @FindBy(xpath = "//nav[@class='sub-nav-list phone-hide']/a[contains(text(), 'My Organizations')]")
    protected WebElement myOrganizationsLink;

    @FindBy(id = "appTitle")
    protected WebElement myOrganizationHeaderLabel;

    @FindBy(xpath = "//nav[@class='column-24']/a[@class='third-nav-link ng-binding']")
    protected List<WebElement> myEsriSubLinks;

    @FindBy(css = "a.crumb.ng-binding.ng-scope")
    protected WebElement myOrganizationCommonHeaderLabel;

    @FindBy(xpath = "//a[@class='third-nav-link ng-binding'][contains(text(), 'Events')]")
    protected WebElement eventsLink;

    @FindBy(css = "input#quickSearch")
    protected WebElement quickSearchInputArea;

    @FindBy(xpath = "//button[@class='btn btn-clear-search icon-ui-flush']")
    protected WebElement quickSearchClearButton;

    @FindBy(css = "div.grid-placeholder.k-grid.k-widget > table > tbody > tr")
    protected List<WebElement> searchResultsCount;

    @FindBy(css = "div.grid-placeholder.k-grid.k-widget > table > tbody > tr:nth-child(1)")
    protected WebElement searchDataFirstItem;

    @FindBy(xpath = "(//li[@class='list-sort-filter ng-binding k-item k-state-default k-first k-last'])[1]")
    protected WebElement sortByLink;

    @FindBy(xpath = "//*[@id='usersSorter_mn_active']/span")
    protected WebElement productFilterItemRegistrationID;

    @FindBy(xpath = "//a[@class='btn btn-clear no-print ng-binding']")
    protected WebElement backToUserConferenceRegistrations;

    @FindBy(xpath = "(//a[@class='btn btn-clear btn-small approve'])[1]")
    protected WebElement detailsFirstItemLink;

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
    public EventsPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}