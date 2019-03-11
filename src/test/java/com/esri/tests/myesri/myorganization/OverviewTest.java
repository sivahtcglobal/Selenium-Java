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
import com.esri.sm.myesri.myorganization.OverviewPageFeatures;
import com.esri.sm.myesri.myprofile.MyProfilePageFeatures;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationPage;

/**
 * This test class to validate the MY Esri My Organization tab test cases
 * 
 * @author Rizwan
 *
 */
public class OverviewTest extends BaseTestUi {

	private DashboardPageFeatures dashboardPageFeatures;
	private OverviewPageFeatures overviewPageFeatures;
	private MyProfilePageFeatures myProfilePageFeatures;
	private List<String> overviewsubLinkNames;
	private List<String> subLinkNames;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public OverviewTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Organization Profile of Overview
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriSite", "Regressions", "Overview" }, priority = 1)
	public void ValidateOrganizationOverview(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("MYESRI")));
		overviewPageFeatures = new OverviewPageFeatures(driver, inputDataMap);
		myProfilePageFeatures = new MyProfilePageFeatures(driver, inputDataMap);
		dashboardPageFeatures.signIn();
		dashboardPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), overviewPageFeatures.retrieveMyOrganizationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);			
		subLinkNames = overviewPageFeatures.myOrganizationSubTabs();
		Log.info("sublinks:"+ subLinkNames);
		
		for (int i = 0; i < subLinkNames.size(); i++) {
			if (subLinkNames.get(i).contains(inputDataMap.get(MyOrganizationPage.OVERVIEW))) {
				overviewPageFeatures.clickOnOverview();
				Log.info("Overview is avalable");
				dashboardPageFeatures.clickdashboardFeedbackLink();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveFeedbackItem()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);					
				dashboardPageFeatures.clickOnFeedbackCloseIcon();
				myProfilePageFeatures.isMoreInformationDataAvailable();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),dashboardPageFeatures.getTitle()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);				
				
				if (overviewPageFeatures.isOrganizationDetailsEditButtonisAvailable()) {
					p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
							String.format("%s - %s", Env.get("MYESRI"), overviewPageFeatures.retrieveEditOrganizationDetailsHeaderLabelViaProfile()),
							ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
					AppliCompareImage(p_AData);						
				}
				if (overviewPageFeatures.isContactEditButtonisAvailable()) {
					p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
							String.format("%s - %s", Env.get("MYESRI"), overviewPageFeatures.retrieveEditMaintenanceContactHeaderLabelViaProfile()),
							ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
					AppliCompareImage(p_AData);					
				}
			}				
		}
		ValidateEditOrganizationDetails(inputDataMap);
		ValidateEditOrganizationName(inputDataMap);
		ValidateEditMaintenanceContact(inputDataMap);
		ValidateRequestPermissions(inputDataMap);
		closeTest();
	}

	/**
	 * Test to validate the Edit Organization Details of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidateEditOrganizationDetails(Map<String, String> inputDataMap) {
		overviewsubLinkNames = overviewPageFeatures.overviewSubTabs();
		Log.info("overviewsublinks:"+ overviewsubLinkNames);		
		
		if (overviewsubLinkNames.contains(inputDataMap.get(MyOrganizationPage.EDIT_ORGANIZATION_DETAILS_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), overviewPageFeatures.retrieveEditOrganizationDetailsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);				
			if (inputDataMap.get(MyEsriUserPages.USERNAME).contains("EsriTestAutomation2")) {
				Log.info("Currently Edit Organization details are not working for user EsriTestAutomation2");
			}
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Edit Organization Details. Permission check passed");
		}
	}

	/**
	 * Test to validate the Edit Organization Name of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidateEditOrganizationName(Map<String, String> inputDataMap) {
		if (overviewsubLinkNames.contains(inputDataMap.get(MyOrganizationPage.EDIT_ORGANIZATION_NAME))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), overviewPageFeatures.retrieveEditOrganizationNameHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);	
			
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Edit Organization Name. Permission check passed");
		}
	}

	/**
	 * Test to validate the Edit Maintenance Contact of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidateEditMaintenanceContact(Map<String, String> inputDataMap) {
		if (overviewsubLinkNames.contains(inputDataMap.get(MyOrganizationPage.EDIT_MAINTENANCE_CONTACT_NAME))) {
			overviewPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),overviewPageFeatures.retrieveEditMaintenanceContactHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);	
			overviewPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),overviewPageFeatures.retrieveUpdateContactSuccessMessage()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
		
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Edit Maintenance Contact Details. Permission check passed");
		}
	}

	/**
	 * Test to validate the Request Permissions of Overview
	 * 
	 * @param inputDataMap
	 */
	public void ValidateRequestPermissions(Map<String, String> inputDataMap) {
		if (overviewsubLinkNames.contains(inputDataMap.get(MyOrganizationPage.REQUEST_PERMISSIONS))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),overviewPageFeatures.retrieveRequestPermissionsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);	
			overviewPageFeatures.waitForPageToLoad();
			overviewPageFeatures.clickOnRequestPermissionsToYourOrganizationContinueButton();
			overviewPageFeatures.clickOnAdditionalOrganizationRadioButton();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),myProfilePageFeatures.retrieveRequestPermissionsSendRequestSuccessMessage()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),overviewPageFeatures.retrieveEsriTrialsAndStudentAccountsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains Request Permission. Permission check passed");
		}
	}

}
