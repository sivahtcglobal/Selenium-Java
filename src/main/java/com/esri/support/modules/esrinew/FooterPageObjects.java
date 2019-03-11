package com.esri.support.modules.esrinew;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.esri.qa.ui.PageObjects;

/**
 * 
 * This is the WhereNext Magazine PageObjects class to identify the Footer objects
 * within the page
 * 
 * @author thenmozhiS
 *
 */
public class FooterPageObjects extends PageObjects {

  @FindBy(xpath="//a[@class='esri-footer-menu-link--sub']")
	public List<WebElement> esriFooterMenuLinks;
	
	@FindBy(xpath="//a[@class='esri-footer-info-link']")
	public List<WebElement> esriFooterMetaLinks;
	
	@FindBy(xpath = "//*[@class='esri-footer-social']/ul/li/a")
	public List<WebElement> esriSocialLinks;
	
	@FindBy(xpath = "//button[@class='n-subscribe-action']")
	public WebElement subscribeButton;
	
	/**
	* Initialize the page Object for WhereNext Magazine Footer 
    * 
    * @author thenmozhiS
    * @param driver
    * @return instance of pagefactory
    */
	public FooterPageObjects(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
}
