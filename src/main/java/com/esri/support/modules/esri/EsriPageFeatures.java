package com.esri.support.modules.esri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.esri.qa.config.Env;
import com.esri.qa.reporting.Log;
import com.esri.qa.ui.FeatureAutomationException;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.Constants.SiteCoreHomePage;

/**
 * This class has all the Esri.com features methods.
 * 
 * @author thenmozhiS
 *
 */
public class EsriPageFeatures extends PageObjects {

	private Map<String, String> inputDataMap;
	private WebDriver driver;
	private EsriPageObjects siteCoreObjects;
	private String linkLabelName;
	public Map<String, String> mapLinks = new HashMap<>();
	private Map<String, WebElement> headersElements = new HashMap<>();

	public EsriPageFeatures(WebDriver driver, Map<String, String> inputDataMap) {
		super(driver);
		this.driver = driver;
		this.inputDataMap = inputDataMap;
		this.siteCoreObjects = new EsriPageObjects(driver);
	}

	/**
	 * This method performs sign in action. After launching the url, click on
	 * sign in button at the top of the page, which navigates to "Esri Accounts"
	 * page then switch to "OAuthframe" and pass the inputs of username and
	 * password and click on "Sign in" button.
	 */
	public void signIn() {
		click(siteCoreObjects.homePageSignInButton);
		Log.info(getText(siteCoreObjects.signInHeader));
		driver.switchTo().frame("oAuthFrame");
		inputText(siteCoreObjects.usernameText, inputDataMap.get(SiteCoreHomePage.USERNAME));
		inputText(siteCoreObjects.passwordText, inputDataMap.get(SiteCoreHomePage.PASSWORD));
		click(siteCoreObjects.signInButton);
		driver.switchTo().defaultContent();
	}

	/**
	 * This method performs sign out action. Click on the username at the top of
	 * the page, and the from the list of dropdown options select "Sign out"
	 * button.
	 */
	public void signOut() {
		click(siteCoreObjects.accountUsername);
		click(siteCoreObjects.signOutButton);
	}

	/**
	 * Retrieve and returns the username present at the top of the page.
	 */
	public String getAccountName() {
		return siteCoreObjects.accountUsername.getText();
	}

	public String retriveTitle() {
		return getTitle();
	}

	public void openUrl() {
		openURL(Env.get("ESRI"));
	}

	/**
	 * clicks "Esri Logo" icon present in the page otherwise navigates to
	 * Esri.com homepage.
	 */
	public void clickEsriLogo() {
		if (isElementAvailable(siteCoreObjects.esriLogo)) {
			click(siteCoreObjects.esriLogo);
		} else {
			openUrl();
		}
		Log.info("Navigated back to Esri Home Page");
	}

	/**
	 * clicks the "Industries" MegaMenu otherwise close the alert present in the
	 * page and click on the "Industries" MegaMenu.
	 */
	public void clickIndustriesMegaMenu() {
		closeFeedbackAlertIfPresent();
		click(siteCoreObjects.industriesMegaMenu);
		Log.info("Industries Megamenu clicked successfully ");
	}

	/**
	 * clicks the "Products" MegaMenu otherwise close the alert present in the
	 * page and click on the "Products" MegaMenu.
	 */
	public void clickProductsMegaMenu() {
		closeFeedbackAlertIfPresent();
		click(siteCoreObjects.productsMegaMenu);
		Log.info("Products Megamenu clicked successfully ");
	}

	/**
	 * clicks the "Support And Services" MegaMenu otherwise close the alert
	 * present in the page and click on the "SupportAndServices" MegaMenu.
	 */
	public void clickSupportAndServicesMegaMenu() {
		closeFeedbackAlertIfPresent();
		click(siteCoreObjects.supportAndServicesMegaMenu);
		Log.info("Support And Services Megamenu clicked successfully ");
	}

	/**
	 * clicks the "About" MegaMenu otherwise close the alert present in the page
	 * and click on the "About" MegaMenu.
	 */
	public void clickAboutMegaMenu() {
		closeFeedbackAlertIfPresent();
		click(siteCoreObjects.aboutMegaMenu);
		Log.info("About Megamenu clicked successfully ");
	}

	/**
	 * clicks the "Community" MegaMenu otherwise close the alert present in the
	 * page and click on the "Community" MegaMenu.
	 */
	public void clickCommunityMegaMenu() {
		closeFeedbackAlertIfPresent();
		click(siteCoreObjects.communityMegaMenu);
		Log.info("Community Megamenu clicked successfully ");
	}

	/**
	 * Trim all the spaces in the string using regex expression "\\s+" and
	 * return it.
	 *
	 * @param nameOfLink
	 *            actual name of the link.
	 * @return nameOfLink string without any spaces
	 */
	public String replaceSpace(String nameOfLink) {
		return nameOfLink.replaceAll(SiteCoreHomePage.REGEX_EXP, "");
	}

	/**
	 * Get the text of first level links in each megamenu by iterating the
	 * webelement and store it in the list.
	 *
	 * @param megaMenu
	 *            Megamenu name
	 * @return List of first level link names
	 */
	public List<String> getFirstLevelLinksNameList(String megaMenu) {
		openUrl();
		List<String> linkNames = new ArrayList<>();
		clickMegaMenu(megaMenu);
		for (int i = 0; i < siteCoreObjects.firstLevelLinksList.size(); i++) {
			WebElement element = siteCoreObjects.firstLevelLinksList.get(i);
			linkNames.add(element.getText());
		}
		clickMegaMenu(megaMenu);
		Log.info(megaMenu + " first level link names: " + linkNames);
		return linkNames;
	}

	/**
	 * Get the text of second level links in each megamenu by iterating the
	 * webelement and store it in the list.
	 *
	 * @param megaMenu
	 *            Megamenu name
	 * @return List of second level link names
	 */
	public List<String> getSecondLevelLinksNameList(String megaMenu) {
		openUrl();
		clickMegaMenu(megaMenu);
		List<String> linkNames = new ArrayList<>();
		for (int i = 0; i < siteCoreObjects.secondLevelLinksList.size(); i++) {
			WebElement element = siteCoreObjects.secondLevelLinksList.get(i);
			linkNames.add(element.getText());
		}
		clickMegaMenu(megaMenu);
		Log.info(megaMenu + linkNames);
		return linkNames;
	}

	/**
	 * Get the text of fat footer links in the homepage by iterating the
	 * webelement and store it in the list.
	 *
	 * @param megaMenu
	 *            Megamenu name
	 * @return List of footer link names
	 */
	public List<String> getFooterLinksNameList(String footer) {
		List<String> linkNames = new ArrayList<>();
		for (int i = 0; i < siteCoreObjects.fatFooterList.size(); i++) {
			linkNames.add(getText(siteCoreObjects.fatFooterList.get(i)));
		}
		Log.info(footer + linkNames);
		return linkNames;
	}

	/**
	 * Get the text of small footer links in the homepage by iterating the
	 * webelement and store it in the list.
	 *
	 * @param megaMenu
	 *            Megamenu name
	 * @return List of small footer link names
	 */
	public List<String> getSmallFooterLinksNameList(String footer) {
		List<String> linkNames = new ArrayList<>();
		for (int i = 0; i < siteCoreObjects.footerSmallList.size(); i++) {
			WebElement element = siteCoreObjects.footerSmallList.get(i);
			linkNames.add(element.getText());
		}
		Log.info(footer + linkNames);
		return linkNames;
	}

	/**
	 * Get the text of social links in the homepage by iterating the webelement
	 * and store it in the list.
	 *
	 * @param megaMenu
	 *            Megamenu name
	 * @return List of social link names
	 */
	public List<String> getSocialLinksNameList(String socialLinks) {
		List<String> linkNames = new ArrayList<>();
		for (int i = 0; i < siteCoreObjects.socialLinksList.size(); i++) {
			WebElement element = siteCoreObjects.socialLinksList.get(i);
			linkNames.add(element.getAttribute(SiteCoreHomePage.SOCIAL_LINK_ATTRIBUTE));
		}
		Log.info(socialLinks + linkNames);
		return linkNames;
	}

	/**
	 * Returns the Header and Title of the link mapped with key.
	 * <p>
	 * If condition is to check if the method is called for first time it should
	 * not click the esri logo.
	 * <p>
	 * Fetch he webelement using the index, retrieve its text and then click on
	 * it. retrieve the header and title of next page
	 * <p>
	 * 
	 * @param megaMenu
	 *            Megamenu name
	 * @param linkIndex
	 *            Index of first lvel link
	 * @return First Level Link Header and Title of each megamenu links.
	 */
	public Map<String, String> getFirstLevelLinkValues(String megaMenu, int linkIndex) {
		mapLinks.clear();
		if (linkIndex > 0) {
			clickEsriLogo();
		}
		clickMegaMenu(megaMenu);
		WebElement element = siteCoreObjects.firstLevelLinksList.get(linkIndex);
		try {
			String linkName = getText(element);
			linkLabelName = replaceSpace(linkName);
			closeFeedbackAlertIfPresent();
			click(element);
			captureTitleAndHeader(linkName, megaMenu);
		} catch (Exception ex) {
			Log.error("First level link click un-successful. ", ex);
		}
		for (Entry<String, String> entry : mapLinks.entrySet()) {
			Log.info("[ " + entry.getKey() + ": " + entry.getValue() + " ]");
		}
		return mapLinks;
	}

	/**
	 * Returns the Header and Title of the link mapped with key.
	 * <p>
	 * If condition is to check if the method is called for first time it should
	 * not click the esri back logo Fetch he webelement using the index,
	 * retrieve its text and then click on it. retrieve the header and title of
	 * next page
	 * <p>
	 * 
	 * @param megaMenu
	 *            Megamenu name
	 * @param linkIndex
	 *            Second level link index
	 * @return Second Level Link Header and Title of each megamenu links.
	 */
	public Map<String, String> getSecondLevelLinkValues(String megaMenu, int linkIndex) {
		mapLinks.clear();
		if (linkIndex > 0) {
			clickEsriLogo();
		}
		clickMegaMenu(megaMenu);
		WebElement element = siteCoreObjects.secondLevelLinksList.get(linkIndex);
		try {
			String linkName = getText(element);
			if (linkName.equalsIgnoreCase(SiteCoreHomePage.INTHENEWS_LINK)
					|| linkName.equalsIgnoreCase(SiteCoreHomePage.MAP_LINK)) {
				Log.warn(linkName + "link throws HTTP Status error, not evaluated");
			} else {
				linkLabelName = replaceSpace(linkName);
				closeFeedbackAlertIfPresent();
				click(element);
				captureTitleAndHeader(linkName, megaMenu);
			}
		} catch (Exception ex) {
			Log.error("Second level link click un-successful. ", ex);
		}

		for (Entry<String, String> entry : mapLinks.entrySet()) {
			Log.debug("[ " + entry.getKey() + ": " + entry.getValue() + " ]");
		}
		return mapLinks;
	}

	/**
	 * Returns the Title of the link mapped with key.
	 * <p>
	 * Fetch he webelement using the index, retrieve its text and then click on
	 * it. retrieve the header and title of next page
	 * 
	 * @param footer
	 *            footer
	 * @param footerLinkIndex
	 *            footer link name
	 * @return Map with the Title of all the fat footer links.
	 */
	public Map<String, String> getFooterLinkValues(String footer, int footerLinkIndex) {
		mapLinks.clear();
		if (footerLinkIndex > 0) {
			clickEsriLogo();
		}
		WebElement element = siteCoreObjects.fatFooterList.get(footerLinkIndex);
		try {
			linkLabelName = replaceSpace(getText(element));
			closeFeedbackAlertIfPresent();
			scrollIntoViewByElement(element);
			click(element);
			captureTitleAndHeader(null, footer);
		} catch (Exception ex) {
			Log.error("footer link click un-successful. ", ex);
		}
		for (Entry<String, String> entry : mapLinks.entrySet()) {
			Log.debug("[ " + entry.getKey() + ": " + entry.getValue() + " ]");
		}
		return mapLinks;
	}

	/**
	 * Returns the Title of the link mapped with key.
	 * <p>
	 * Fetch he webelement using the index, retrieve its text and then click on
	 * it. retrieve the header and title of next page
	 * 
	 * @param smallFooter
	 *            footer
	 * @param smallFooterLinksIndex
	 *            footer link index
	 * @return Map with the Title of all the Small footer links.
	 */
	public Map<String, String> getFooterSmallLinksValues(String smallFooter, int smallFooterLinksIndex) {
		mapLinks.clear();
		if (smallFooterLinksIndex > 0) {
			clickEsriLogo();
		}
		WebElement element = siteCoreObjects.footerSmallList.get(smallFooterLinksIndex);
		try {
			linkLabelName = replaceSpace(getText(element));
			closeFeedbackAlertIfPresent();
			scrollIntoViewByElement(element);
			click(element);
			captureTitleAndHeader(null, smallFooter);
		} catch (Exception ex) {
			Log.error("Small footer link click un-successful. ", ex);
		}
		for (Entry<String, String> entry : mapLinks.entrySet()) {
			Log.debug("[ " + entry.getKey() + ": " + entry.getValue() + " ]");
		}
		return mapLinks;
	}

	/**
	 * Returns the Title of the social links mapped with key.
	 * <p>
	 * For loop compares the footerLinkName with the iterated element text, if
	 * it returns true click on the link and capture the title of the link and
	 * store it in the mapLinks hashmap with the key of linkname suffixing
	 * title. Then set the "socialLinksCount" as loop count to break the loop.
	 * 
	 * @param socialLink
	 *            social Link
	 * @param socialLinkName
	 *            social link name
	 * @return Map with the Title of all the social links.
	 */
	public Map<String, String> getSocialLinkValues(String socialLink, int socialLinkIndex) {
		mapLinks.clear();
		openUrl();
		WebElement element = siteCoreObjects.socialLinksList.get(socialLinkIndex);
		try {
			String link = element.getAttribute(SiteCoreHomePage.SOCIAL_LINK_ATTRIBUTE);
			linkLabelName = replaceSpace(link);
			closeFeedbackAlertIfPresent();
			scrollIntoViewByElement(element);
			click(element);
			captureTitleAndHeader(null, socialLink);
		} catch (Exception ex) {
			Log.error(linkLabelName + "Social link click un-successful. ", ex);
		}
		for (Entry<String, String> entry : mapLinks.entrySet()) {
			Log.debug("[ " + entry.getKey() + ": " + entry.getValue() + " ]");
		}
		return mapLinks;
	}

	private void captureTitleAndHeader(String linkName, String menuName) {
		try {
			if (SiteCoreHomePage.LOGIN_LINK.equalsIgnoreCase(linkName)
					|| SiteCoreHomePage.FOOTER.equalsIgnoreCase(menuName)
					|| SiteCoreHomePage.SOCIAL_LINKS.equalsIgnoreCase(menuName)) {
				waitForPageToLoad(2);
				mapLinks.put(linkLabelName + SiteCoreHomePage.LINK_TITLE, retriveTitle());
			} else {
				mapLinks.put(linkLabelName + SiteCoreHomePage.LINK_HEADER, getText(headersElements.get(linkName)));
				mapLinks.put(linkLabelName + SiteCoreHomePage.LINK_TITLE, retriveTitle());
			}
		} catch (Exception ex) {
			Log.error("Unable to capture title ", ex);
		}
	}

	public String getDeutschHeader() {
		String deustchHeader = null;
		try {
			click(siteCoreObjects.productsMegaMenu);
			click(siteCoreObjects.arcGISProDropDown);
			click(siteCoreObjects.languageDropDown);
			click(siteCoreObjects.optionDeutsch);
			deustchHeader = siteCoreObjects.arcGISProLanguageHeader.getText();
		} catch (Exception e) {
			Log.error("Language change functionality failed");
			throw new FeatureAutomationException("Language change functionality failed", e);
		}
		return deustchHeader;
	}

	private void closeFeedbackAlertIfPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.elementToBeClickable(siteCoreObjects.alertClose)).click();
			Log.info("****Dismissed Alert*****");
		} catch (Exception e) {
			Log.debug("Alert not present");
		}
	}

	private void clickMegaMenu(String megamenuValue) {
		headersElements.clear();
		switch (megamenuValue) {
		case SiteCoreHomePage.INDUSTRIES_MENU:
			getIndustriesSubMenuHeaders();
			clickIndustriesMegaMenu();
			break;
		case SiteCoreHomePage.PRODUCTS_MENU:
			getProductsLinkHeaders();
			clickProductsMegaMenu();
			break;
		case SiteCoreHomePage.SUPPORT_MENU:
			getSupportSubMenuHeaders();
			clickSupportAndServicesMegaMenu();
			break;
		case SiteCoreHomePage.ABOUT_MENU:
			getAboutSubMenuHeaders();
			clickAboutMegaMenu();
			break;
		case SiteCoreHomePage.COMMUNITY_MENU:
			getCommunitySubMenuHeaders();
			clickCommunityMegaMenu();
			break;
		default:
			Log.info("Accessing Footer " + megamenuValue + " Links");
		}
	}

	private void getProductsLinkHeaders() {
		headersElements.put("ArcGIS", siteCoreObjects.aboutArcGISHeader);
		headersElements.put("Products", siteCoreObjects.productsHeader);
		headersElements.put("Capabilities", siteCoreObjects.aboutArcGISHeader);
		headersElements.put("Esri's Open Vision", siteCoreObjects.openVisionsHeader);
		headersElements.put("About ArcGIS", siteCoreObjects.aboutArcGISHeader);
		headersElements.put("What's New", siteCoreObjects.whatNewHeader);
		headersElements.put("Free Trial", siteCoreObjects.freeTrialHeader);
		headersElements.put("ArcGIS Online", siteCoreObjects.arcGISOnlineHeader);
		headersElements.put("ArcGIS Pro", siteCoreObjects.arcGISProHeader);
		headersElements.put("ArcGIS Enterprise", siteCoreObjects.arcGISEnterpriseHeader);
		headersElements.put("ArcGIS Apps", siteCoreObjects.arcGISAppsHeader);
		headersElements.put("ArcGIS for Developers", siteCoreObjects.arcGISDevHeader);
		headersElements.put("See all products", siteCoreObjects.seeAllProductsHeader);
		headersElements.put("Spatial Analytics", siteCoreObjects.spatialAnalyticsHeader);
		headersElements.put("Mapping & Visualization", siteCoreObjects.mappingAndVisualHeader);
		headersElements.put("3D GIS", siteCoreObjects.threedimensionGisHeader);
		headersElements.put("Real-Time GIS", siteCoreObjects.realGISHeader);
		headersElements.put("Imagery & Remote Sensing", siteCoreObjects.imageryHeader);
		headersElements.put("Data Collection & Management", siteCoreObjects.dataCollectionHeader);
		headersElements.put("Open Standards", siteCoreObjects.openStandardsHeader);
		headersElements.put("Data Interoperability", siteCoreObjects.imageryHeader);
		headersElements.put("Open Data", siteCoreObjects.imageryHeader);
		headersElements.put("APIs and Specifications", siteCoreObjects.imageryHeader);
		headersElements.put("Open Source", siteCoreObjects.imageryHeader);
		headersElements.put("Open Community", siteCoreObjects.imageryHeader);
		headersElements.put("GitHub", siteCoreObjects.gitHubHeader);
	}

	private void getIndustriesSubMenuHeaders() {
		headersElements.put("Government", siteCoreObjects.firstLevelLinksHeader);
		headersElements.put("Business", siteCoreObjects.firstLevelLinksHeader);
		headersElements.put("Utilities & Communications", siteCoreObjects.firstLevelLinksHeader);
		headersElements.put("Natural Resources", siteCoreObjects.firstLevelLinksHeader);
		headersElements.put("Additional Industries", siteCoreObjects.additionalIndustriesHeader);
		headersElements.put("Federal", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("State", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Local", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Resilient Communities", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Smart Communities", siteCoreObjects.smartCommunitiesHeader);
		headersElements.put("Facilities", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Land Administration", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Public Works", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Architecture, Engineering, and Construction (AEC)",
				siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Economic Development", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Elections and Redistricting", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Urban and Regional Planning", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Insurance", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Retail", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Manufacturing", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Real Estate", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Banking", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Marketing", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Media and Entertainment", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Supply Chain", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Electric", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Gas", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Pipeline", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Telecommunications", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Water Utilities", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Agriculture", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Climate, Weather, and Atmosphere", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Conservation", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Environmental Management", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Forestry", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Mining", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Oceans", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Petroleum", siteCoreObjects.petroleumHeader);
		headersElements.put("Water Resources", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Defense", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Education", siteCoreObjects.industriesEducationHeader);
		headersElements.put("Intelligence", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Health and Human Services", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Mapping, Statistics, Imagery", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("Transportation", siteCoreObjects.tranportationGISHeader);
		headersElements.put("Public Safety", siteCoreObjects.publicSafetyHeader);
		headersElements.put("Sustainable Development", siteCoreObjects.secondLevelLinksHeader);
		headersElements.put("See All Industries", siteCoreObjects.seeAllIndustriesHeader);
	}

	private void getSupportSubMenuHeaders() {
		headersElements.put("Training", siteCoreObjects.trainingservicesHeader);
		headersElements.put("Support", siteCoreObjects.support_SearchsupportHeader);
		headersElements.put("Services", siteCoreObjects.servicesHeader);
		headersElements.put("My Learning", siteCoreObjects.myLearningHeader);
		headersElements.put("Catalog", siteCoreObjects.catalogHeader);
		headersElements.put("Certification", siteCoreObjects.catalogHeader);
		headersElements.put("Unlimited E-Learning", siteCoreObjects.catalogHeader);
		headersElements.put("Help", siteCoreObjects.catalogHeader);
		headersElements.put("Esri Press", siteCoreObjects.esriPressHeader);
		headersElements.put("Search Support", siteCoreObjects.support_SearchsupportHeader);
		headersElements.put("Manage Cases", siteCoreObjects.manageCasesHeader);
		headersElements.put("Request Case", siteCoreObjects.requestCasesHeader);
		headersElements.put("Start Chat", siteCoreObjects.requestCasesHeader);
		headersElements.put("Premium Support Services", siteCoreObjects.requestCasesHeader);
		headersElements.put("Contact Tech Support", siteCoreObjects.requestCasesHeader);
		headersElements.put("Consulting Services", siteCoreObjects.consultingServicesHeader);
		headersElements.put("Managed Cloud Services", siteCoreObjects.consultingServicesHeader);
		headersElements.put("Enterprise Advantage Program", siteCoreObjects.consultingServicesHeader);
	}

	private void getAboutSubMenuHeaders() {
		headersElements.put("About Esri", siteCoreObjects.aboutEsriHeader);
		headersElements.put("What We Do", siteCoreObjects.whatWeDoHeader);
		headersElements.put("Why We Do It", siteCoreObjects.whyWeDoItHeader);
		headersElements.put("Who We Are", siteCoreObjects.whoWeAreHeader);
		headersElements.put("Videos (E360)", siteCoreObjects.videoEHeader);
		headersElements.put("Store", siteCoreObjects.storeHeader);
		headersElements.put("Partners", siteCoreObjects.partnersHeader);
		headersElements.put("Esri Offices Worldwide", siteCoreObjects.worldWideHeader);
		headersElements.put("Corporate Responsibility", siteCoreObjects.corporateResponsibilityHeader);
		headersElements.put("Contact Us", siteCoreObjects.contactUsHeader);
		headersElements.put("Newsroom", siteCoreObjects.newsRoomHeader);
		headersElements.put("WhereNext Magazine", siteCoreObjects.whereNextHeader);
		headersElements.put("ArcPublications", siteCoreObjects.arcPublicationsHeader);
		headersElements.put("Blogs", siteCoreObjects.blogsHeader);
		headersElements.put("Releases", siteCoreObjects.releasesHeader);
		headersElements.put("Careers", siteCoreObjects.careersHeader);
		headersElements.put("Search Jobs", siteCoreObjects.searchJobsHeader);
		headersElements.put("Recruiting Events", siteCoreObjects.recruitingEventsHeader);
		headersElements.put("Students & Grads", siteCoreObjects.studentsAndGradsHeader);
		headersElements.put("Log in", siteCoreObjects.loginHeader);
		headersElements.put("Events", siteCoreObjects.eventsHeader);
		headersElements.put("Esri User Conference", siteCoreObjects.userConferenceHeader);
		headersElements.put("Esri GeoConX", siteCoreObjects.geoConXHeader);
		headersElements.put("Esri Partner Conference", siteCoreObjects.partnerConferenceHeader);
		headersElements.put("Esri Developer Summit", siteCoreObjects.devSummitHeader);
		headersElements.put("Esri Federal GIS Conference", siteCoreObjects.fedGISConferenceHeader);
		headersElements.put("Esri Health GIS Conference", siteCoreObjects.healthGISConferenceHeader);
		headersElements.put("GeoDev Meetups", siteCoreObjects.devMeetupsHeader);
		headersElements.put("See All Events", siteCoreObjects.seeAllEventsHeader);
	}

	private void getCommunitySubMenuHeaders() {
		headersElements.put("GeoNet", siteCoreObjects.geoNetHeader);
		headersElements.put("Content", siteCoreObjects.contentHeader);
		headersElements.put("People", siteCoreObjects.peopleHeader);
		headersElements.put("Places", siteCoreObjects.placesHeader);
		headersElements.put("GeoNet Help", siteCoreObjects.geoNetHelpHeader);
		headersElements.put("Industry Spaces", siteCoreObjects.industrySpacesHeader);
		headersElements.put("Business", siteCoreObjects.buisnessHeader);
		headersElements.put("Defense and Intelligence", siteCoreObjects.defenseHeader);
		headersElements.put("Education and Training", siteCoreObjects.educationGeoNetHeader);
		headersElements.put("Government", siteCoreObjects.governmentGeoNetHeader);
		headersElements.put("Health and Human Services", siteCoreObjects.healthAndHumanHeader);
		headersElements.put("Natural Resources", siteCoreObjects.naturalResourcesHeader);
		headersElements.put("Transportation", siteCoreObjects.transportationGeoNetHeader);
		headersElements.put("Public Safety", siteCoreObjects.publicSafetyGeoNetHeader);
		headersElements.put("Utilities and Communications", siteCoreObjects.utilitiesAndCommunicationsGeoNetHeader);
		headersElements.put("Featured Spaces", siteCoreObjects.featuredSpacesGeoNetHeader);
		headersElements.put("User Conference", siteCoreObjects.userConferenceGeoNetHeader);
		headersElements.put("Developers", siteCoreObjects.developerSpacesGeoNetHeader);
		headersElements.put("GIS", siteCoreObjects.GISGeoNetHeader);
		headersElements.put("Resilience", siteCoreObjects.resilienceGeoNetHeader);
		headersElements.put("Discussions Lobby", siteCoreObjects.discussionsLobbyGeoNetHeader);
		headersElements.put("All GeoNet Spaces", siteCoreObjects.allGeoNetSpacesHeader);
	}

}
