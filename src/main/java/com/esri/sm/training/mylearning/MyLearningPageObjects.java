package com.esri.sm.training.mylearning;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the Esri Training - My Learning submenus page objects.
 * 
 * @author Thenmozhi
 *
 */
public class MyLearningPageObjects {

	@FindBy(css = "div.esri-header-account > button")
	protected WebElement traningPageSignInButton;

	@FindBy(id = "user_username")
	protected WebElement usernameText;

	@FindBy(id = "user_password")
	protected WebElement passwordText;

	@FindBy(id = "signIn")
	protected WebElement signInButton;

	@FindBy(css = "#topper_v_align > h1")
	protected WebElement signInHeader;

	@FindBy(css = ".title>h1")
	protected WebElement pageHeader;

	@FindBy(xpath = "//div[@class='link ng-binding'][contains(text(), 'My Learning')]")
	protected WebElement myLearningMenu;

	@FindBy(xpath = ".//*[contains(text(),'Dashboard')]")
	protected WebElement dashboardSubMenu;

	@FindBy(xpath = ".//*[contains(text(),'Learning Activity')]")
	protected WebElement learningActivitySubMenu;

	@FindBy(xpath = ".//*[starts-with(@class,'ng-binding') and contains(@href,'/training/my-schedule/')]")
	protected WebElement scheduleSubMenu;

	@FindBy(xpath = ".//*[starts-with(@class,'ng-binding') and contains(@ui-sref,'myLearningPlans')]")
	protected WebElement learningPlansSubMenu;

	@FindBy(xpath = ".//*[contains(text(),'Wish List')]")
	protected WebElement wishListSubMenu;

	@FindBy(xpath = ".//*[contains(@class,'right')]/a[contains(text(),'View My Wish List')]")
	protected WebElement viewMyWishListLink;

	@FindBy(xpath = ".//*[contains(@class,'drop-box ng-binding')]/span[contains(text(),'All Learning Formats')]")
	protected WebElement allLearningFormatDropDown;

	@FindBy(xpath = ".//*[contains(@class,'drop-list')]/div/label")
	protected List<WebElement> allLearningFormatList;

	@FindBy(xpath = ".//*[contains(@class,'header bg-white')]/div[contains(@class,'actions')]/div/span[3]/wish-button/div/button")
	protected List<WebElement> listOfWishList;

	@FindBy(xpath = ".//*[contains(@class,'header bg-white')]/div[contains(@class,'actions')]/div/span[3]/wish-button/div/button")
	protected List<WebElement> howToAccessButton;

	@FindBy(css = "div.search-bar > input")
	protected WebElement learningActivityInputSearch;

	@FindBy(xpath = ".//*[contains(@class,'search-submit')]")
	protected WebElement learningActivitySearchBtn;

	@FindBy(xpath = ".//*[@class='items-displayed']/span[3]/strong")
	protected WebElement learningActivitySearchResult;

	@FindBy(xpath = ".//*[starts-with(@class,'btn-clear') and contains(@ng-click,'downloadTranscript()')] ")
	protected WebElement downloadTranscriptBtn;

	@FindBy(xpath = "//div[@class='schedule-items grid-container padding-top-lg padding-bottom-xl ng-scope']//a[1]")
	protected WebElement firstScheduleCard;

	@FindBy(xpath = "//*[@class='schedule-items grid-container padding-top-lg padding-bottom-xl ng-scope']/div[1]/descendant::span[@course-type='session._LearningObject.Type']")
	protected WebElement firstScheduleCardFormatText;

	@FindBy(xpath = ".//*[starts-with(@class,'ng-binding ng-isolate-scope esriu-course-tag') and contains(@course-type,'learningObject.Type')]")
	protected WebElement firstScheduleCardPageHeader;

	@FindBy(xpath = "//*[contains(@class,'learning-plan-list')]/div[1]//*[starts-with(@class,'ng-binding') and contains(@ui-sref,'catalogDetail( { id: plan._id, name: plan.ProductTitle } )') ]")
	protected WebElement firstLearningPlansCard;

	@FindBy(xpath = "//*[@class='learning-plan-list grid-container margin-top-xl']/div[1]/span")
	protected WebElement firstLearningPlansCardFormatText;

	@FindBy(xpath = ".//*[starts-with(@class,'ng-binding ng-isolate-scope esriu-course-tag') and contains(@course-type,'learningObject.Type')]")
	protected WebElement firstLearningPlansCardPageHeader;
	
	@FindBy(xpath = "//iframe[@id='oAuthFrame']")
    protected WebElement oAuthFrame;

	/**
	 * Initialize the PageObject for Esri Training - My Learning submenu page
	 * 
	 * @param driver
	 *
	 */
	public MyLearningPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}