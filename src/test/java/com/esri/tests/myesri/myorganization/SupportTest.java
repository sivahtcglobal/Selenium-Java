package com.esri.tests.myesri.myorganization;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.config.Env;
import com.esri.qa.ui.AppliCompareData;
import com.esri.qa.ui.BaseTestUi;
import com.esri.qa.ui.ComparisonLevel;
import com.esri.qa.ui.ViewPortSize;
import com.esri.sm.myesri.dashboard.DashboardPageFeatures;
import com.esri.sm.myesri.myorganization.SupportPageFeatures;
import com.esri.sm.myesri.myprofile.MyProfilePageFeatures;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationReports;

/**
 * This test class to validate the MY Esri My Organization tab test cases
 * 
 * @author Rizwan
 *
 */
public class SupportTest extends BaseTestUi {

	private DashboardPageFeatures dashboardPageFeatures;
	private SupportPageFeatures supportPageFeatures;
	private MyProfilePageFeatures myProfilePageFeatures;
	private List<String> supportsubLinkNames;
	private List<String> subLinkNames;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public SupportTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Organization Profile of Overview
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriSite", "Regressions", "Support" }, priority = 1)
	public void ValidateSupportOverview(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("MYESRI")));
		supportPageFeatures = new SupportPageFeatures(driver, inputDataMap);
		myProfilePageFeatures = new MyProfilePageFeatures(driver, inputDataMap);
		dashboardPageFeatures.signIn();
		dashboardPageFeatures.clickOnCookiesPopup();
		dashboardPageFeatures.waitForPageToLoad();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), supportPageFeatures.retrieveMyOrganizationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		subLinkNames = supportPageFeatures.myOrganizationSubTabs();
		if (subLinkNames.contains(MyOrganizationReports.SUPPORT_LABEL)) {
			supportPageFeatures.clickOnSupport();
			supportPageFeatures.waitForPageToLoad();
			dashboardPageFeatures.clickdashboardFeedbackLink();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveFeedbackItem()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			dashboardPageFeatures.clickOnFeedbackCloseIcon();
			supportPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), supportPageFeatures.retrieveCasesHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			supportPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), supportPageFeatures.retrieveBugsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			if (inputDataMap.get(MyOrganizationReports.YES_HEADER_LABEL).contains("Yes")) {
				supportPageFeatures.waitForPageToLoad();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								supportPageFeatures.retrieveViewMoreActivityHeaderLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);

			}
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains Support Link. Permission check passed");
		}

		ValidateRecentActivity(inputDataMap);
		ValidateCases(inputDataMap);
		ValidateBugs(inputDataMap);
		ValidateAuthorizedCallers(inputDataMap);
		closeTest();
	}

	/**
	 * Test to validate the Recent Activity of Support
	 * 
	 * @param inputDataMap
	 */
	public void ValidateRecentActivity(Map<String, String> inputDataMap) {
		supportsubLinkNames = supportPageFeatures.supportSubTabs();
		if (supportsubLinkNames.contains(inputDataMap.get(MyOrganizationReports.RECENT_ACTIVITY_HEADER_LABEL))) {
			supportPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							supportPageFeatures.retrieveRecentActivityHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Recent Activity Details. Permission check passed");
		}
	}

	/**
	 * Test to validate the Cases of Support
	 * 
	 * @param inputDataMap
	 */
	public void ValidateCases(Map<String, String> inputDataMap) {
		if (supportsubLinkNames.contains(inputDataMap.get(MyOrganizationReports.CASES_HEADER_LABEL))) {
			supportPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), supportPageFeatures.retrieveCasessHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			myProfilePageFeatures.isMoreInformationDataAvailable();
			supportPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), supportPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Cases. Permission check passed");
		}
	}

	/**
	 * Test to validate the Bugs of Support
	 * 
	 * @param inputDataMap
	 */
	public void ValidateBugs(Map<String, String> inputDataMap) {
		if (supportsubLinkNames.contains(inputDataMap.get(MyOrganizationReports.BUGS_HEADER_LABEL))) {
			supportPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), supportPageFeatures.retrieveBugssHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			myProfilePageFeatures.isMoreInformationDataAvailable();
			supportPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), supportPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Bugs. Permission check passed");
		}
	}

	/**
	 * Test to validate the Authorized Callers of Support
	 * 
	 * @param inputDataMap
	 */
	public void ValidateAuthorizedCallers(Map<String, String> inputDataMap) {
		if (supportsubLinkNames.contains(inputDataMap.get(MyOrganizationReports.AUTHORIZED_CALLERS_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							supportPageFeatures.retrieveAuthorizedCallersHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			myProfilePageFeatures.isMoreInformationDataAvailable();
			supportPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), supportPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			supportPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							supportPageFeatures.retrieveLearnMoreAboutPremiumSupportTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			/*
			 * reportLogger.assertTrue(supportPageFeatures.
			 * isAuthorizaedCallersSearchResultsAreAvailable(),
			 * "Validate if the Authorized Callers search results are available"
			 * );
			 */
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), supportPageFeatures.retrieveEsriSupportTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			supportPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), supportPageFeatures.retrieveTalkToTheCommunityTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Authorized Callers. Permission check passed");
		}
	}

}
