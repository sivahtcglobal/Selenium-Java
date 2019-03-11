package com.esri.tests.myesri.stafftools;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.config.Config;
import com.esri.qa.config.Env;
import com.esri.qa.reporting.Log;
import com.esri.qa.ui.AppliCompareData;
import com.esri.qa.ui.BaseTestUi;
import com.esri.qa.ui.ComparisonLevel;
import com.esri.qa.ui.ViewPortSize;
import com.esri.sm.myesri.dashboard.DashboardPageFeatures;
import com.esri.sm.myesri.myprofile.MyProfilePageFeatures;
import com.esri.sm.myesri.stafftools.StaffToolsPageFeatures;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;
import com.esri.support.modules.core.MyEsriConstants.StaffToolsTab;

/**
 * This test class to validate the MY Esri site Staff Tools tab
 * 
 * @author Rizwan
 *
 */
public class StaffToolsTest extends BaseTestUi {

	private DashboardPageFeatures dashboardPageFeatures;
	private StaffToolsPageFeatures staffToolsPageFeatures;
	private MyProfilePageFeatures myProfilePageFeatures;
	private List<String> staffToolsSubLinkNames = null;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public StaffToolsTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Staff Tools Overview
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriSite", "Regressions", "Staff Tools" }, priority = 1)
	public void ValidateStaffToolsOverview(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(Config.getConfigProperty(MyEsriUserPages.ENV));
		myProfilePageFeatures = new MyProfilePageFeatures(driver, inputDataMap);
		staffToolsPageFeatures = new StaffToolsPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.signIn();
		dashboardPageFeatures.clickOnCookiesPopup();
		staffToolsPageFeatures.waitForPageToLoad();
		if (staffToolsPageFeatures.isStaffToolsTabAvailable()) {
			staffToolsPageFeatures.clickOnStaffToolsLink();
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			staffToolsSubLinkNames = staffToolsPageFeatures.staffToolsSubTabs();
			Log.info("Sublinks:" + staffToolsSubLinkNames);
			if (staffToolsSubLinkNames.contains(inputDataMap.get(StaffToolsTab.STAFF_TOOLS_OVERVIEW_HEADER_LABEL))) {
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.retrieveStaffToolsOverviewHeaderLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);				
				staffToolsPageFeatures.isStaffToolsOverviewFilterResultsAreAvailable();
				staffToolsPageFeatures.waitForPageToLoad();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
				
				int staffToolsOverviewCount = staffToolsPageFeatures.retrieveStaffToolsOverviewCount();
				for (int i = 0; i < staffToolsOverviewCount; i++) {
					if (staffToolsPageFeatures.retrieveStaffToolsOverviewLabel(i)
							.contains("Distributor Notification Configuration")) {
						Log.info("Skip for Now Application Error");
					} else if (staffToolsPageFeatures.retrieveStaffToolsOverviewLabel(i)
							.contains("Distributor Permissions Bulk Update")) {
						staffToolsPageFeatures.waitForPageToLoad();
						staffToolsPageFeatures.retrieveStaffToolsOverviewHeaderLabel(i);
						staffToolsPageFeatures.waitForPageToLoad();
						p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
								String.format("%s - %s", Env.get("MYESRI"),staffToolsPageFeatures.retrieveStaffToolsHeaderLabel(i)),
								ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
						AppliCompareImage(p_AData);						
						staffToolsPageFeatures.clickOnStaffToolsLink();
						staffToolsPageFeatures.waitForPageToLoad();
						staffToolsPageFeatures.clickOnNoticeyes();
					} else {
						staffToolsPageFeatures.waitForPageToLoad();						
						p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
								String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.retrieveStaffToolsHeaderLabel(i)),
								ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
						AppliCompareImage(p_AData);
						staffToolsPageFeatures.waitForPageToLoad();
						staffToolsPageFeatures.clickOnStaffToolsLink();						
					}
				}
			}

			ValidateUsersRequest(inputDataMap);
			ValidateUserConnections(inputDataMap);
			ValidateUserInvitations(inputDataMap);
			ValidateDeveloperSubscriptionConnections(inputDataMap);
			ValidateDistributorEmailConfiguration(inputDataMap);
			// ValidateDistributorNotificationConfiguration(inputDataMap);
			ValidateDistributorSiteConfiguration(inputDataMap);
			ValidateDistributorPermissionsBulkUpdate(inputDataMap);
			closeTest();
		}
	}

	/**
	 * Test to validate the User Request
	 * 
	 * @param inputDataMap
	 */
	public void ValidateUsersRequest(Map<String, String> inputDataMap) {
		if (staffToolsSubLinkNames.contains(inputDataMap.get(StaffToolsTab.USER_REQUESTS_HEADER_LABEL).trim())) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							staffToolsPageFeatures.retrieveUsersRequestHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			myProfilePageFeatures.isMoreInformationDataAvailable();
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			staffToolsPageFeatures.isUserRequestSearchResultsAreAvailable();
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - User Request. Permission check passed");
		}
	}

	/**
	 * Test to validate the User Connections of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidateUserConnections(Map<String, String> inputDataMap) {
		if (staffToolsSubLinkNames.contains(inputDataMap.get(StaffToolsTab.USER_CONNECTIONS_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							staffToolsPageFeatures.retrieveUserConnectionsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			myProfilePageFeatures.isMoreInformationDataAvailable();
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			staffToolsPageFeatures.isUserConnectionsSearchResultsAreAvailable();
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Connect Users. Permission check passed");
		}
	}

	/**
	 * Test to validate the User Invitations
	 * 
	 * @param inputDataMap
	 */
	public void ValidateUserInvitations(Map<String, String> inputDataMap) {
		if (staffToolsSubLinkNames.contains(inputDataMap.get(StaffToolsTab.USER_INVITATIONS_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							staffToolsPageFeatures.retrieveUserInvitationsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			myProfilePageFeatures.isMoreInformationDataAvailable();
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - User Invitations. Permission check passed");
		}
	}

	/**
	 * Test to validate the Developer Subscription Connections
	 * 
	 * @param inputDataMap
	 */
	public void ValidateDeveloperSubscriptionConnections(Map<String, String> inputDataMap) {
		if (staffToolsSubLinkNames
				.contains(inputDataMap.get(StaffToolsTab.DEVELOPER_SUBSCRIPTION_CONNECTIONS_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							staffToolsPageFeatures.retrieveDeveloperSubscriptionConnectionsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			myProfilePageFeatures.isMoreInformationDataAvailable();
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			staffToolsPageFeatures.isUserInvitationsSearchResultsAreAvailable();
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Developer Subscription Connections. Permission check passed");
		}
	}

	/**
	 * Test to validate the Distributor Email Configuration
	 * 
	 * @param inputDataMap
	 */
	public void ValidateDistributorEmailConfiguration(Map<String, String> inputDataMap) {
		if (staffToolsSubLinkNames
				.contains(inputDataMap.get(StaffToolsTab.DISTRIBUTOR_EMAIL_CONFIGURATION_HEADER_LABEL).trim())) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							staffToolsPageFeatures.retrieveDistributorEmailConfigurationHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			myProfilePageFeatures.isMoreInformationDataAvailable();
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			staffToolsPageFeatures.isAddRecipientIsSuccess();
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Permissions Report. Permission check passed");
		}
	}

	/**
	 * Test to validate the Distributor Notification Configuration
	 * 
	 * @param inputDataMap
	 */
	public void ValidateDistributorNotificationConfiguration(Map<String, String> inputDataMap) {
		if (staffToolsSubLinkNames
				.contains(inputDataMap.get(StaffToolsTab.DISTRIBUTOR_NOTIFICATION_CONFIGURATION_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							staffToolsPageFeatures.retrieveDistributorNotificationConfigurationHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			staffToolsPageFeatures.waitForPageToLoad();
			myProfilePageFeatures.isMoreInformationDataAvailable();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							staffToolsPageFeatures.retrieveNotificationLogHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							staffToolsPageFeatures.retrieveNotificationSettingsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Permissions Log. Permission check passed");
		}
	}

	/**
	 * Test to validate the Distributor Site Configuration
	 * 
	 * @param inputDataMap
	 */
	public void ValidateDistributorSiteConfiguration(Map<String, String> inputDataMap) {
		if (staffToolsSubLinkNames
				.contains(inputDataMap.get(StaffToolsTab.DISTRIBUTOR_SITE_CONFIGURATION_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							staffToolsPageFeatures.retrieveDistributorSiteConfigurationHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			myProfilePageFeatures.isMoreInformationDataAvailable();
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							staffToolsPageFeatures
									.retrieveDistributorSiteConfigurationFirstItemDescriptionHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Distributor Site Configuration. Permission check passed");
		}
	}

	/**
	 * Test to validate the Distributor Permissions Bulk Update
	 * 
	 * @param inputDataMap
	 */
	public void ValidateDistributorPermissionsBulkUpdate(Map<String, String> inputDataMap) {
		if (staffToolsSubLinkNames
				.contains(inputDataMap.get(StaffToolsTab.DISTRIBUTOR_PERMISSIONS_BULK_UPDATE_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							staffToolsPageFeatures.retrieveDistributorPermissionsBulkUpdateHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			staffToolsPageFeatures.waitForPageToLoad();
			myProfilePageFeatures.isMoreInformationDataAvailable();
			staffToolsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), staffToolsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Distributor Permissions Bulk Update. Permission check passed");
		}
	}

}
