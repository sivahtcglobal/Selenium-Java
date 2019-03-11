package com.esri.support.modules.esri;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.esri.qa.ui.PageObjects;

/**
 * 
 * This is the Site-Core Esri.com webpage class to identify the objects within
 * the page
 * 
 * @author thenmozhi
 *
 */
public class EsriPageObjects extends PageObjects {

	@FindBy(css = "#mega-menu-sign-in")
	protected WebElement homePageSignInButton;

	@FindBy(id = "user_username")
	protected WebElement usernameText;

	@FindBy(id = "user_password")
	protected WebElement passwordText;

	@FindBy(id = "signIn")
	protected WebElement signInButton;

	@FindBy(css = "#logged-out-navigation > a")
	protected WebElement signIn;

	@FindBy(css = "#topper_v_align > h1")
	protected WebElement signInHeader;

	@FindBy(css = "#mega-menu-account-username")
	protected WebElement accountUsername;

	@FindBy(xpath = "//div[@id='header-logo']/a")
	protected WebElement esriLogo;

	@FindBy(css = "#mega-menu-items>li:nth-child(1)")
	protected WebElement industriesMegaMenu;

	@FindBy(css = "#mega-menu-items>li:nth-child(2)")
	protected WebElement productsMegaMenu;

	@FindBy(css = "#mega-menu-items>li:nth-child(3)")
	protected WebElement supportAndServicesMegaMenu;

	@FindBy(css = "#mega-menu-items>li:nth-child(4)")
	protected WebElement aboutMegaMenu;

	@FindBy(css = "#mega-menu-items>li:nth-child(5)")
	protected WebElement communityMegaMenu;

	@FindBy(xpath = "//div[@id='mega-menu-drop-down']/ul/li/h2/a")
	protected List<WebElement> firstLevelLinksList;

	@FindBy(css = "#section-1 > div > div.grid-100 > div > div > div > div.grid-100 > h1")
	protected WebElement firstLevelLinksHeader;

	@FindBy(xpath = "//div[@id='mega-menu-drop-down']/ul/li/ul/li/a")
	protected List<WebElement> secondLevelLinksList;

	@FindBy(css = "#section-0 > div > div.grid-66 > div.section-header-full > h1")
	protected WebElement secondLevelLinksHeader;

	@FindBy(css = "#main-content > div.main-intro > div > div > div.column-10.padding-leader-3.phone-padding-leader-3.padding-trailer-3.tablet-padding-trailer-0 > h2")
	protected WebElement smartCommunitiesHeader;

	@FindBy(css = "#feature-content > div.grid-55.alpha > h1")
	protected WebElement additionalIndustriesHeader;
	
	@FindBy(css = "#bannerContent-novideo > div > div > h1")
	protected WebElement industriesEducationHeader;
	
	// footer
	@FindBy(xpath = "//div[@class='footerBG2']/ul/li/ul/li/a")
	protected List<WebElement> fatFooterList;

	@FindBy(xpath = "//div[@class='footerSmall']/a")
	protected List<WebElement> footerSmallList;

	@FindBy(css = "#prod-desc > h1")
	protected WebElement whatsGISHeader;

	@FindBy(css = "#topper_v_align > h2")
	protected WebElement mapBookHeader;

	@FindBy(css = "#e360 > div.banner > div.grid-container.hide-tablet > div > div.video-info-wrapper > h1")
	protected WebElement videoHeader;

	@FindBy(css = "#Form1 > section > div:nth-child(1) > article > header > div > h1")
	protected WebElement scienceOfWhereHeader;

	@FindBy(css = "#Form1 > section > div:nth-child(1) > article > header > div > h1")
	protected WebElement aboutEsriHeader;

	@FindBy(css = "body > div > div.topper-outer.m-slide > div.topper-mod.section-container > div.topper-hgroup > h1")
	protected WebElement careersHeader;

	@FindBy(css = "#site-title > a")
	protected WebElement insiderBlogHeader;

	@FindBy(css = "#main-content > section.hero > div.grid-container > div > div > div:nth-child(2) > h1")
	protected WebElement userConferencHeader;

	@FindBy(css = "#skip-to-content > header > div > div:nth-child(1) > div > div.sdk-home-banner-content > h1")
	protected WebElement trustArcGISHeader;

	@FindBy(css = "body > div.wrapper > div.home-page-banner > div > div.column-12.tablet-column-6.phone-column-6.left > div > a")
	protected WebElement supportHeader;

	@FindBy(css = "#esriu > div:nth-child(4) > div.landing-header.no-print.ng-scope > div > div > div > h1")
	protected WebElement trainingHeader;

	@FindBy(css = "#main-content > section.hero > div > div > h1")
	protected WebElement consultingHeader;

	@FindBy(css = "#main-content > section.hero > div > div > h1")
	protected WebElement managedCloudHeader;

	@FindBy(css = "#main-content > section.hero > div > div > h1")
	protected WebElement enterpriseAdvantageHeader;

	@FindBy(css = "#topperAlign > h1")
	protected WebElement learnAboutPartnersHeader;

	@FindBy(css = "#topperText > h2")
	protected WebElement partnerDirectoryHeader;

	@FindBy(css = "#bodyColumnSingle > div.container_12 > div.grid_12 > h1")
	protected WebElement hardwarePromotionsHeader;

	@FindBy(css = "#ctl3 > div > div.grid-100.top-section > h1")
	protected WebElement esriSplProgramsHeader;

	@FindBy(css = "#npo > div.grid-90.intro-copy > h1")
	protected WebElement nonProfitHeader;

	@FindBy(css = "#section-0 > div > div.grid-66 > div.section-header-full > h1")
	protected WebElement educationHeader;

	@FindBy(css = "#section-0 > div > div.grid-66 > div.section-header-full > h1")
	protected WebElement disasterHeader;

	@FindBy(css = "#accelerate-career > div > div.grid-100 > h2")
	protected WebElement personalUseHeader;

	@FindBy(css = "#main-content > section:nth-child(4) > div > div > div > h1")
	protected WebElement navySeaPortHeader;

	@FindBy(css = "#ctl3 > div > div.container > div.page-section.top.clearfix > div > div > h1")
	protected WebElement conservationHeader;
	// Social Links
	@FindBy(xpath = "//div[@class='socialLinks']/ul/li/a")
	protected List<WebElement> socialLinksList;

	@FindBy(css = ".topper_v_align")
	protected WebElement newsRoomHeader;

	@FindBy(css = "#react-root > section > main > article > header > div._de9bg > div._8mm5v > h1")
	protected WebElement instagramHeader;

	@FindBy(css = "#page-container > div.AppContainer > div > div > div.Grid-cell.u-size1of3.u-lg-size1of4 > div > div > div > div.ProfileHeaderCard > h1 > a")
	protected WebElement twitterHeader;

	@FindBy(css = "#react-root > section > main > article > header > div._de9bg > div._8mm5v > h1")
	protected WebElement linkedinHeader;

	@FindBy(css = "#feedTitleText")
	protected WebElement newsFeedHeader;

	@FindBy(css = "#main-content > div.ind-case_study.collapse-top > div > div.ind-case_study-details > h3")
	protected WebElement petroleumHeader;

	@FindBy(css = "#section-1 > div > div.grid-100 > div > div > div > div.grid-100 > h1")
	protected WebElement tranportationGISHeader;

	@FindBy(css = "#section-1 > div > div.grid-100 > div > div > div > div.grid-100 > h1")
	protected WebElement publicSafetyHeader;

	@FindBy(css = "#topper_v_align > h1")
	protected WebElement seeAllIndustriesHeader;
	
	// products
	@FindBy(css = "#main-content > section.hero.scrollable.pos1 > div.banner > div.left.animation-wrapper > div > h1")
	protected WebElement aboutArcGISHeader;

	@FindBy(css = "#main-content > section.hero.scrollable.pos1 > div.banner > div.left.animation-wrapper > div > h1")
	protected WebElement capabilitiesHeader;

	@FindBy(css = "#products-gateway > div > div.grid-100 > div > h1")
	protected WebElement productsHeader;

	@FindBy(css = "#parentLink")
	protected WebElement openVisionsHeader;

	@FindBy(css = "#main-content > section.intro.leader-2.trailer-3 > div > div > h1")
	protected WebElement whatNewHeader;

	@FindBy(css = "#main-content > section.intro.leader-2.trailer-3.animation-wrapper > div > div > h1")
	protected WebElement freeTrialHeader;

	@FindBy(css = "#feature-content > div > h1")
	protected WebElement arcGISOnlineHeader;

	@FindBy(css = "body > div.wrapper > div.arcgis > div.arcgis-banner.pro > div.arcgis-banner-title > div > div.column-14.leader-6.padding-leader-2 > h1")
	protected WebElement arcGISProHeader;

	@FindBy(css = "body > div.wrapper > div.arcgis > div.arcgis-banner.pro > div.arcgis-banner-title > div > div.column-14.leader-6.padding-leader-2 > h1")
	protected WebElement arcGISEnterpriseHeader;

	@FindBy(css = "#apps-navigation > div > div > h1")
	protected WebElement arcGISAppsHeader;

	@FindBy(css = "#skip-to-content > div.homepage-banner.text-white.padding-leader-3.padding-trailer-3 > div > div > h1")
	protected WebElement arcGISDevHeader;

	@FindBy(css = "#products-gateway > div > div.grid-100 > div > h1")
	protected WebElement seeAllProductsHeader;

	@FindBy(css = "#ctl3 > div.grid-90 > h1")
	protected WebElement spatialAnalyticsHeader;

	@FindBy(css = "#ctl3 > div.grid-70 > h1")
	protected WebElement mappingAndVisualHeader;

	@FindBy(css = "#web-app-example > div > h2")
	protected WebElement threedimensionGisHeader;

	@FindBy(css = "#ctl3 > div.foot-2.clearfix > div > h1")
	protected WebElement realGISHeader;

	@FindBy(css = "#feature-content > div.grid-55.alpha > h1")
	protected WebElement imageryHeader;

	@FindBy(css = "#ctl3 > div > div.grid-60.feature > h1")
	protected WebElement dataCollectionHeader;

	@FindBy(css = "#esri-opensite-sub > div > div.openstd-intro > div > div > h1")
	protected WebElement openStandardsHeader;

	@FindBy(css = "#skip-to-content > div.panel.open-banner.panel-black.panel-no-border.padding-leader-0.padding-trailer-2 > div > div > h1")
	protected WebElement gitHubHeader;
	
	// Support & services
	@FindBy(css = "#esriu > div.container-fill.ng-scope > div > div.welcome > div.welcome-title.ng-scope")
	protected WebElement trainingservicesHeader;

	@FindBy(css = "body > div.wrapper > div.home-page-banner > div > div.column-12.tablet-column-6.phone-column-6.left > div > a")
	protected WebElement support_SearchsupportHeader;

	@FindBy(css = "#main-content > section.hero > div > div > h1")
	protected WebElement servicesHeader;

	@FindBy(css = "#esriu > div:nth-child(4) > div.container-fill.title-bar.no-print.ng-scope > div > div > h1")
	protected WebElement myLearningHeader;

	@FindBy(css = "#esriu > div:nth-child(4) > div.container-fill.title-bar.no-print.ng-scope > div > div > h2")
	protected WebElement catalogHeader;

	@FindBy(css = "#topperText > h1")
	protected WebElement esriPressHeader;

	@FindBy(css = "#appTitle")
	protected WebElement manageCasesHeader;

	@FindBy(css = "#wrapper > div.sub-page-banner > div > div:nth-child(1) > div > a")
	protected WebElement requestCasesHeader;

	@FindBy(css = "#main-content > section.hero > div > div > h1")
	protected WebElement consultingServicesHeader;
	// About
	@FindBy(css = "#what-we-do > div > figure > figcaption > h3")
	protected WebElement whatWeDoHeader;

	@FindBy(css = "#why-we-do-it > div > figure > figcaption > h3")
	protected WebElement whyWeDoItHeader;

	@FindBy(css = "#who-we-are > div > figure > figcaption > h3")
	protected WebElement whoWeAreHeader;

	@FindBy(css = "#e360 > div.banner > div.grid-container.hide-tablet > div > div.video-info-wrapper > h1")
	protected WebElement videoEHeader;

	@FindBy(css = "#extensions > div.grid-container > div.column-24.mainContent > p")
	protected WebElement storeHeader;

	@FindBy(css = "#main-content > div:nth-child(1) > div > div:nth-child(1) > h1")
	protected WebElement partnersHeader;

	@FindBy(css = "#Form1 > div.page-section.grey-section > div > div:nth-child(1) > h1")
	protected WebElement worldWideHeader;

	@FindBy(css = "#feature-content > div.grid-55.alpha > h1")
	protected WebElement corporateResponsibilityHeader;

	@FindBy(css = "#main-content > div > div > div.grid-100 > div > h1")
	protected WebElement contactUsHeader;

	@FindBy(css = "#c-snav-title")
	protected WebElement whereNextHeader;

	@FindBy(css = "#topper_v_align > h2")
	protected WebElement overviewHeader;

	@FindBy(css = "#Form1 > div.container_12 > div.grid_12 > h1")
	protected WebElement arcPublicationsHeader;

	@FindBy(css = "#post-349 > h2")
	protected WebElement blogsHeader;

	@FindBy(css = "#bodyColumnSingle > div > h1")
	protected WebElement releasesHeader;

	@FindBy(css = "#inthenews")
	protected WebElement inTheNewsHeader;

	@FindBy(css = "#form1 > div.pg-topper.job-topper > div > h1")
	protected WebElement searchJobsHeader;

	@FindBy(css = "#form1 > div.pg-topper.job-topper > div > h1.jp-h1")
	protected WebElement recruitingEventsHeader;

	@FindBy(css = "#form1 > div.pg-topper.job-topper > div > h1")
	protected WebElement studentsAndGradsHeader;

	@FindBy(css = "body > div.iCIMS_MainWrapper.iCIMS_IntroPage > h1")
	protected WebElement loginHeader;

	@FindBy(css = "#topper_v_align > h1")
	protected WebElement eventsHeader;

	@FindBy(css = "#main-content > section.hero > div.grid-container > div > div > div:nth-child(2) > h1")
	protected WebElement userConferenceHeader;

	@FindBy(css = "#gcx-banner__boxhead > h2")
	protected WebElement geoConXHeader;

	@FindBy(css = "#epc-jack--banner-lg > div.container > div.grid-100 > div > div > div > div.font-size-8.text-white.trailer-half")
	protected WebElement partnerConferenceHeader;

	@FindBy(css = "#devsum--banner-lg > div.container > div.grid-100 > div > div > div > div.font-size-8.text-white.trailer-half")
	protected WebElement devSummitHeader;

	@FindBy(css = "#federal-body > div.container > div.grid-100 > div > div > div.column-18.text-center.pre-3.leader-3 > div.font-size-5.text-center.text-off-black")
	protected WebElement fedGISConferenceHeader;

	@FindBy(css = "#health-banner-lg > div.container > div.grid-100 > div > div > div > div.font-size-7.text-off-black.leader-2.trailer-half")
	protected WebElement healthGISConferenceHeader;

	@FindBy(css = "#Form1 > div.mainUCImage > div > div > div > h1")
	protected WebElement devMeetupsHeader;

	@FindBy(css = "#bodyColumnSingle > div > div.grid-100 > h2")
	protected WebElement seeAllEventsHeader;
	// Community
	@FindBy(xpath = ".//*[@class='jive-widget-handle']/span[contains(text(),'Ask')]")
	protected WebElement geoNetHeader;

	@FindBy(css = "#jive-body > div > div.j-column-wrap-l > div.j-column.j-column-l.j-rc5 > div.j2-base-components-global-guest-call-to-action > span")
	protected WebElement contentHeader;

	@FindBy(css = "#jive-body > div > div.j-column-wrap-l > div > div.j2-base-components-global-guest-call-to-action > span")
	protected WebElement peopleHeader;

	@FindBy(css = "#jive-body > div > div.j-column-wrap-l > div > div.j2-base-components-global-guest-call-to-action > span")
	protected WebElement placesHeader;

	@FindBy(css = "#tile-header-42670")
	protected WebElement geoNetHelpHeader;

	@FindBy(css = "#jive-body > div > div.j-column-wrap-l > div > div.j2-base-components-global-guest-call-to-action > span")
	protected WebElement industrySpacesHeader;

	@FindBy(css = "#jive-body > header > div.j-placeHeaderWrap > div > h1 > a")
	protected WebElement buisnessHeader;

	@FindBy(css = "#jive-body > header > div.j-placeHeaderWrap > div > h1 > a")
	protected WebElement defenseHeader;

	@FindBy(css = "#jive-body > header > div.j-placeHeaderWrap > div > h1 > a")
	protected WebElement educationGeoNetHeader;

	@FindBy(css = "#jive-body > header > div.j-placeHeaderWrap > div > h1 > a")
	protected WebElement governmentGeoNetHeader;

	@FindBy(css = "#jive-body > header > div.j-placeHeaderWrap > div > h1 > a")
	protected WebElement healthAndHumanHeader;

	@FindBy(css = "#jive-body > header > div.j-placeHeaderWrap > div > h1 > a")
	protected WebElement naturalResourcesHeader;

	@FindBy(css = "#jive-body > header > div.j-placeHeaderWrap > div > h1 > a")
	protected WebElement transportationGeoNetHeader;

	@FindBy(css = "#jive-body > header > div.j-placeHeaderWrap > div > h1 > a")
	protected WebElement publicSafetyGeoNetHeader;

	@FindBy(css = "#jive-body > header > div.j-placeHeaderWrap > div > h1 > a")
	protected WebElement utilitiesAndCommunicationsGeoNetHeader;

	@FindBy(css = "#jive-body > div > div.j-column-wrap-l > div > div.j2-base-components-global-guest-call-to-action > span")
	protected WebElement featuredSpacesGeoNetHeader;

	@FindBy(css = "#jive-body > header > div.j-placeHeaderWrap > div > h1 > a")
	protected WebElement userConferenceGeoNetHeader;

	@FindBy(css = "#devspace > div:nth-child(1) > h2")
	protected WebElement developerSpacesGeoNetHeader;

	@FindBy(css = "#gistopic > div:nth-child(1) > h2")
	protected WebElement GISGeoNetHeader;

	@FindBy(css = "#jive-body > header > div.j-placeHeaderWrap > div > h1 > a")
	protected WebElement resilienceGeoNetHeader;

	@FindBy(css = "#jive-body > header > div.j-placeHeaderWrap > div > h1 > a")
	protected WebElement discussionsLobbyGeoNetHeader;

	@FindBy(css = "#jive-body > div > div.j-column-wrap-l > div > div.j2-base-components-global-guest-call-to-action > span")
	protected WebElement allGeoNetSpacesHeader;
	// language dropdown
	@FindBy(xpath = "//div[@id='mega-menu-drop-down']/ul/li[2]/ul/li[3]/a")
	protected WebElement arcGISProDropDown;

	@FindBy(xpath = "//div[@id='header-search']/div[1]/div/a")
	protected WebElement languageDropDown;

	@FindBy(xpath = "//div[@id='header-search']/div[1]/div/div/ul/li[1]/a")
	protected WebElement optionDeutsch;

	@FindBy(css = "body > div.wrapper > div.arcgis > div.clearfix > div.image-switcher-content-wrapper.column-12.padding-leader-5 > div.column-9.pre-1 > p.font-size-5.trailer-half.text-black")
	protected WebElement arcGISProLanguageHeader;

	@FindBy(xpath = "//div[@id='mega-menu-sign-in-wrapper']/div/div/a")
	protected WebElement innerSignInButton;

	@FindBy(xpath = "//div[@id='mega-menu-sign-in-wrapper']/div/div/div/ul/li[4]/a")
	protected WebElement signOutButton;

	@FindBy(xpath = "//div[@class='sg-b-p sg-b-p-s']/div/button[1]")
	protected WebElement alertClose;

	public EsriPageObjects(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
}
