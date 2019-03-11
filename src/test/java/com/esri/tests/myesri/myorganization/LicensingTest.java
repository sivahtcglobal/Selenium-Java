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
import com.esri.sm.myesri.myorganization.LicensingPageFeatures;
import com.esri.sm.myesri.myprofile.MyProfilePageFeatures;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationDownloads;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationReports;

/**
 * This test class to validate the MY Esri site My Organization - Licensing test
 * cases
 * 
 * @author Rizwan
 *
 */
public class LicensingTest extends BaseTestUi {

	private LicensingPageFeatures licensingPageFeatures;
	private DashboardPageFeatures dashboardPageFeatures;
	private MyProfilePageFeatures myProfilePageFeatures;
	private List<String> licensingSubLinkNames;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public LicensingTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Licensing of My Organization Tab
	 * 
	 * @param inputDataMap
	 * 
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriSite", "Regressions", "Licensing" }, priority = 1)
	public void ValidateLicensingOverview(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("MYESRI")));
		licensingPageFeatures = new LicensingPageFeatures(driver, inputDataMap);
		myProfilePageFeatures = new MyProfilePageFeatures(driver, inputDataMap);
		dashboardPageFeatures.signIn();
		dashboardPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.retrieveMyOrganizationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		if (licensingPageFeatures.isLicensingTabAvailable()) {
			if (inputDataMap.get(MyOrganizationDownloads.USERNAME).contains("EsriTestAutomation1")) {
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								licensingPageFeatures.retrieveLicensingOverviewHeaderLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);				
			dashboardPageFeatures.clickdashboardFeedbackLink();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveFeedbackItem()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.waitForPageToLoad();
			dashboardPageFeatures.clickOnFeedbackCloseIcon();
		}

		else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains Licensing Overview. Permission check passed");
		}
		}
		ValidateViewLicenseTermSummary(inputDataMap);
		ValidateViewAuthorizations(inputDataMap);
		ValidateCreateNewProvisioningFile(inputDataMap);
		ValidateManageExistingProvisioningFiles(inputDataMap);
		ValidateConvertArcGISProNamedUserLicenses(inputDataMap);
		ValidateGeneratePortalForArcGISLicenses(inputDataMap);
		ValidateManageDeveloperSubscriptions(inputDataMap);
		ValidateRecoverLostLicenses(inputDataMap);
		ValidateAdditionalLicensingForms(inputDataMap);
		closeTest();
	}

	/**
	 * Test to validate the View License Term Summary of Licensing
	 * 
	 * @param inputDataMap
	 */
	public void ValidateViewLicenseTermSummary(Map<String, String> inputDataMap) {
		licensingSubLinkNames = licensingPageFeatures.licensingSubTabs();
		if (licensingSubLinkNames.contains(inputDataMap.get(MyOrganizationDownloads.LICENSING_OVERVIEW_TITLE1))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							licensingPageFeatures.retrieveViewLicenseTermSummaryHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.waitForPageToLoad();
			myProfilePageFeatures.isMoreInformationDataAvailable();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.waitForPageToLoad();
			licensingPageFeatures.isViewLicenseTermSummaryReportsAvailable();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.clickOnExitReports();
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - View License Term Summary. Permission check passed");
		}
	}

	/**
	 * Test to validate the View Authorizations of Licensing
	 * 
	 * @param inputDataMap
	 */
	public void ValidateViewAuthorizations(Map<String, String> inputDataMap) {
		if (licensingSubLinkNames.contains(inputDataMap.get(MyOrganizationDownloads.LICENSING_OVERVIEW_TITLE2))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							licensingPageFeatures.retrieveViewAuthorizationsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.waitForPageToLoad();
			myProfilePageFeatures.isMoreInformationDataAvailable();
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			licensingPageFeatures.isViewLicenseTermSummaryReportsAvailable();
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.clickOnExitReports();
			licensingPageFeatures.waitForPageToLoad(45);
			licensingPageFeatures.isSearchResultsAvailable();
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							licensingPageFeatures.retrieveAuthorizationHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			myProfilePageFeatures.isMoreInformationDataAvailable();
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.clickOnBacktoAuthorizations();
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - View Authorizations. Permission check passed");
		}
	}

	/**
	 * Test to validate the Create New Provisioning File of Licensing
	 * 
	 * @param inputDataMap
	 */
	public void ValidateCreateNewProvisioningFile(Map<String, String> inputDataMap) {
		if (licensingSubLinkNames.contains(inputDataMap.get(MyOrganizationDownloads.LICENSING_OVERVIEW_TITLE3))) {
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							licensingPageFeatures.retrieveCreateNewProvisioningFileHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			if (inputDataMap.get(MyOrganizationReports.YESS_LABEL).contains("No")) {
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								licensingPageFeatures.retrieveSelectProductsHeaderLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
			}
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Create New Provisioning File. Permission check passed");
		}
	}

	/**
	 * Test to validate the Manage Existing Provisioning Files of Licensing
	 * 
	 * @param inputDataMap
	 */
	public void ValidateManageExistingProvisioningFiles(Map<String, String> inputDataMap) {
		if (licensingSubLinkNames.contains(inputDataMap.get(MyOrganizationDownloads.LICENSING_OVERVIEW_TITLE4))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							licensingPageFeatures.retrieveManageExistingProvisioningFilesHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			myProfilePageFeatures.isMoreInformationDataAvailable();
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.isViewLicenseTermSummaryReportsAvailable();
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.clickOnExitReports();
			licensingPageFeatures.isSearchResultsAvailableofProvising();
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.isProvisioningAuthorizationsDataAvailable();
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Manage Existing Provisioning Files. Permission check passed");
		}
	}

	/**
	 * Test to validate the Convert ArcGIS Pro Named User Licenses of Licensing
	 * 
	 * @param inputDataMap
	 */
	public void ValidateConvertArcGISProNamedUserLicenses(Map<String, String> inputDataMap) {
		if (licensingSubLinkNames.contains(inputDataMap.get(MyOrganizationDownloads.LICENSING_OVERVIEW_TITLE5))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							licensingPageFeatures.retrieveConvertArcGISProNamedUserLicensesHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.isSearchResultsAvailableForConvertArcGISProNamedUserLicenses();
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.waitForPageToLoad();
			/*p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							licensingPageFeatures.retrieveConvertLicensesHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.waitForPageToLoad();*/
			/*p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.retrieveReviewHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);*/

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Convert ArcGIS Pro Named User Licenses. Permission check passed");
		}
	}

	/**
	 * Test to validate the Generate Portal for ArcGIS Licenses of Licensing
	 * 
	 * @param inputDataMap
	 */
	public void ValidateGeneratePortalForArcGISLicenses(Map<String, String> inputDataMap) {
		if (licensingSubLinkNames.contains(inputDataMap.get(MyOrganizationDownloads.LICENSING_OVERVIEW_TITLE6))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							licensingPageFeatures.retrieveGeneratePortalForArcGISLicensesHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			myProfilePageFeatures.isMoreInformationDataAvailable();
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Generate Portal for ArcGIS Licenses. Permission check passed");
		}
	}

	/**
	 * Test to validate the Manage Developer Subscriptions of Licensing
	 * 
	 * @param inputDataMap
	 */
	public void ValidateManageDeveloperSubscriptions(Map<String, String> inputDataMap) {
		if (licensingSubLinkNames.contains(inputDataMap.get(MyOrganizationDownloads.LICENSING_OVERVIEW_TITLE7))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							licensingPageFeatures.retrieveManageDeveloperSubscriptionsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			myProfilePageFeatures.isMoreInformationDataAvailable();
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.retrieveManageUsersHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Manage Developer Subscriptions. Permission check passed");
		}
	}

	/**
	 * Test to validate the Recover Lost Licenses of Licensing
	 * 
	 * @param inputDataMap
	 */
	public void ValidateRecoverLostLicenses(Map<String, String> inputDataMap) {
		if (licensingSubLinkNames.contains(inputDataMap.get(MyOrganizationDownloads.LICENSING_OVERVIEW_TITLE8))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							licensingPageFeatures.retrieveRecoverLostLicensesHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			myProfilePageFeatures.isMoreInformationDataAvailable();
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), licensingPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Recover Lost Licenses. Permission check passed");
		}
	}

	/**
	 * Test to validate the Additional Licensing Forms of Licensing
	 * 
	 * @param inputDataMap
	 */
	public void ValidateAdditionalLicensingForms(Map<String, String> inputDataMap) {
		if (licensingSubLinkNames.contains(inputDataMap.get(MyOrganizationDownloads.ADDITIONAL_LICENSING_FORMS))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							licensingPageFeatures.retrieveAdditionalLicensingFormsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			licensingPageFeatures.waitForPageToLoad();
			if (inputDataMap.get(MyOrganizationDownloads.USERNAME).contains("EsriTestAutomation0")) {
				Log.info("User doesn't need to click on Developer Subscription Registration");
			} else {
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								licensingPageFeatures.retrieveDeveloperSubscriptionRegistrationHeaderLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);

			}
			licensingPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							licensingPageFeatures.retrieveArcSDE10ArcIMS10AuthorizationsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			if (inputDataMap.get(MyOrganizationDownloads.USERNAME).contains("EsriTestAutomation2")) {
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								licensingPageFeatures.retrieveSingleUseProductRegistrationHeader()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);

			} else {
				licensingPageFeatures.waitForPageToLoad();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								licensingPageFeatures.retrieveSingleUseProductRegistrationHeaderLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
				licensingPageFeatures.waitForPageToLoad();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								licensingPageFeatures.retrieveLicenseFileRequestHeaderLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
				licensingPageFeatures.waitForPageToLoad();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								licensingPageFeatures.retrieveSecureSiteOperationsHeaderLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);

			}
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Additional Licensing Forms. Permission check passed");
		}
	}

}
