package com.esri.tests.myesri.myorganization;

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
import com.esri.sm.myesri.myorganization.OrganizationListPageFeatures;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;

/**
 * This test class to validate the MY Esri site My Organization - Organization
 * List test cases
 * 
 * @author Rizwan
 *
 */
public class OrganizationListTest extends BaseTestUi {

	private OrganizationListPageFeatures organizationListPageFeatures;
	private DashboardPageFeatures dashboardPageFeatures;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public OrganizationListTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Organization List of My Organization Tab
	 * 
	 * @param inputDataMap
	 * 
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriSite", "Regressions", "Organization List" }, priority = 1)
	public void ValidateOrganizationList(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("MYESRI")));
		organizationListPageFeatures = new OrganizationListPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.signIn();
		dashboardPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrievePageTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"),
						organizationListPageFeatures.retrieveMyOrganizationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		if (organizationListPageFeatures.isOrganizationListTabAvailable()) {			
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							organizationListPageFeatures.retrieveMyOrganizationsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			dashboardPageFeatures.clickdashboardFeedbackLink();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveFeedbackItem()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			dashboardPageFeatures.clickOnFeedbackCloseIcon();
			if (inputDataMap.get(MyEsriUserPages.USERNAME).equals("EsriTestAutomation0")) {
				Log.info("User no need to click on select button");
			} else {				
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								organizationListPageFeatures.retrieveSelectMyOrganizationHeaderLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
			}
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains Organization List Tab. Permission check passed");
		}
		closeTest();
	}

}
