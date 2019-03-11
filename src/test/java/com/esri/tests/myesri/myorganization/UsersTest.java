package com.esri.tests.myesri.myorganization;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.config.Env;
import com.esri.qa.reporting.Log;
import com.esri.qa.ui.AppliCompareData;
import com.esri.qa.ui.BaseTestUi;
import com.esri.qa.ui.ComparisonLevel;
import com.esri.qa.ui.ViewPortSize;
import com.esri.sm.myesri.dashboard.DashboardPageFeatures;
import com.esri.sm.myesri.myorganization.UsersPageFeatures;
import com.esri.sm.myesri.myprofile.MyProfilePageFeatures;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationPage;

/**
 * This test class to validate the MY Esri site My Organization - Users test
 * cases
 * 
 * @author Rizwan
 *
 */
public class UsersTest extends BaseTestUi {

	private DashboardPageFeatures dashboardPageFeatures;
	private UsersPageFeatures usersPageFeatures;
	private MyProfilePageFeatures myProfilePageFeatures;
	private List<String> usersSubLinkNames;
	private List<String> subLinkNames;
	private int i;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public UsersTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Manage Users of Overview
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriSite", "Regressions", "Users" }, priority = 1)
	public void ValidateUsers(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("MYESRI")));
		usersPageFeatures = new UsersPageFeatures(driver, inputDataMap);
		myProfilePageFeatures = new MyProfilePageFeatures(driver, inputDataMap);
		dashboardPageFeatures.signIn();
		dashboardPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.retrieveMyOrganizationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		subLinkNames = usersPageFeatures.myOrganizationSubTabs();
		for (i = 0; i < subLinkNames.size(); i++) {
			if (subLinkNames.get(i).contains(inputDataMap.get(MyOrganizationPage.USERS))) {
				usersPageFeatures.clickOnUsers();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.retrieveManageUsersHeaderLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
				usersPageFeatures.waitForPageToLoad();
				dashboardPageFeatures.clickdashboardFeedbackLink();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveFeedbackItem()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
				usersPageFeatures.waitForPageToLoad();
				dashboardPageFeatures.clickOnFeedbackCloseIcon();
				myProfilePageFeatures.isMoreInformationDataAvailable();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.getTitle()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);

				usersPageFeatures.isManageUsersSearchResultsAreAvailable();

				usersPageFeatures.isManageUsersFilterResultsAreAvailable();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.getTitle()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
			}

		}
		ValidateInviteUsers(inputDataMap);
		ValidateConnectUsers(inputDataMap);
		ValidateManageRequest(inputDataMap);
		ValidatePermissionsReport(inputDataMap);
		ValidatePermissionsLog(inputDataMap);
		ValidateManageTags(inputDataMap);
		ValidatePermissionsBulkUpdate(inputDataMap);
		ValidatePermissionsGrid(inputDataMap);
		closeTest();
	}

	/**
	 * Test to validate the Invite Users of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidateInviteUsers(Map<String, String> inputDataMap) {
		usersSubLinkNames = usersPageFeatures.usersSubTabs();
		if (usersSubLinkNames.contains(inputDataMap.get(MyOrganizationPage.INVITE_USERS_HEADER_LABEL))) {
			usersPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.retrieveInviteUsersHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			myProfilePageFeatures.isMoreInformationDataAvailable();
			usersPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.getTitle()), ComparisonLevel.CONTENT,
					true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),String.format("%s - %s", Env.get("MYESRI"),usersPageFeatures.retrieveSendInvitationSuccessMessage()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Invite Users. Permission check passed");
		}
	}

	/**
	 * Test to validate the Connect Users of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidateConnectUsers(Map<String, String> inputDataMap) {
		if (usersSubLinkNames.contains(inputDataMap.get(MyOrganizationPage.CONNECT_USERS_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.retrieveConnectUsersHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Connect Users. Permission check passed");
		}
	}

	/**
	 * Test to validate the Manage Request of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidateManageRequest(Map<String, String> inputDataMap) {
		if (usersSubLinkNames.contains(inputDataMap.get(MyOrganizationPage.MANAGE_REQUESTS_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.retrieveManageRequestsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			myProfilePageFeatures.isMoreInformationDataAvailable();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.getTitle()), ComparisonLevel.CONTENT,
					true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Manage Requests. Permission check passed");
		}
	}

	/**
	 * Test to validate the Permissions Report of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidatePermissionsReport(Map<String, String> inputDataMap) {
		if (usersSubLinkNames.contains(inputDataMap.get(MyOrganizationPage.PERMISSIONS_REPORT_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							usersPageFeatures.retrievePermissionsReportHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			usersPageFeatures.waitForPageToLoad();
			usersPageFeatures.isPermissionsReportExpandResultsAreAvailable();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.getTitle()), ComparisonLevel.CONTENT,
					true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Permissions Report. Permission check passed");
		}
	}

	/**
	 * Test to validate the Permissions Log of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidatePermissionsLog(Map<String, String> inputDataMap) {
		if (usersSubLinkNames.contains(inputDataMap.get(MyOrganizationPage.PERMISSIONS_LOG_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.retrievePermissionsLogHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			usersPageFeatures.isPermissionsLogSearchResultsAreAvailable();

			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.getTitle()), ComparisonLevel.CONTENT,
					true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Permissions Log. Permission check passed");
		}
	}

	/**
	 * Test to validate the Manage Tags of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidateManageTags(Map<String, String> inputDataMap) {
		if (usersSubLinkNames.contains(inputDataMap.get(MyOrganizationPage.MANAGE_TAGS_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.retrieveManageTagsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			usersPageFeatures.isManageTagsSearchResultsAreAvailable();

			myProfilePageFeatures.isMoreInformationDataAvailable();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.getTitle()), ComparisonLevel.CONTENT,
					true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Manage Tags. Permission check passed");
		}
	}

	/**
	 * Test to validate the Permissions Bulk Update of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidatePermissionsBulkUpdate(Map<String, String> inputDataMap) {
		if (usersSubLinkNames.contains(inputDataMap.get(MyOrganizationPage.PERMISSIONS_BULK_UPDATE_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							usersPageFeatures.retrievePermissionsBulkUpdateHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			if (inputDataMap.get(MyEsriUserPages.PERMISSIONS_NOTE_LABEL).contains("No")) {
				Log.info("User no need to perform Permissions Bulk Update functionality");
			} else {
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								usersPageFeatures.retrievePermissionsBulkUpdateSuccessMessageLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);

			}
			myProfilePageFeatures.isMoreInformationDataAvailable();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.getTitle()), ComparisonLevel.CONTENT,
					true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Permissions Bulk Update. Permission check passed");
		}
	}

	/**
	 * Test to validate the Permissions Bulk Update of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidatePermissionsGrid(Map<String, String> inputDataMap) {
		if (usersSubLinkNames.contains(inputDataMap.get(MyOrganizationPage.PERMISSIONS_GRID_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), usersPageFeatures.retrievePermissionsGridHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Permissions Grid. Permission check passed");
		}
	}

}
