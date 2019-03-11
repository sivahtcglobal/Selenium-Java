package com.esri.tests.myesri.myorganization;

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
import com.esri.sm.myesri.myorganization.ReportsPageFeatures;
import com.esri.sm.myesri.myprofile.MyProfilePageFeatures;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;

/**
 * This test class to validate the MY Esri site My Organization - Reports test
 * cases
 * 
 * @author Rizwan
 *
 */
public class ReportsTest extends BaseTestUi {

	private ReportsPageFeatures reportsPageFeatures;
	private DashboardPageFeatures dashboardPageFeatures;
	private MyProfilePageFeatures myProfilePageFeatures;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public ReportsTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Reports of My Organization Tab
	 * 
	 * @param inputDataMap
	 * 
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriSite", "Regressions", "Reports" }, priority = 1)
	public void ValidateReports(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("MYESRI")));
		reportsPageFeatures = new ReportsPageFeatures(driver, inputDataMap);
		myProfilePageFeatures = new MyProfilePageFeatures(driver, inputDataMap);
		dashboardPageFeatures.signIn();
		dashboardPageFeatures.clickOnCookiesPopup();
		reportsPageFeatures.waitForPageToLoad();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), reportsPageFeatures.retrieveMyOrganizationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);

		if (reportsPageFeatures.isReportsTabAvailable()) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), reportsPageFeatures.retrieveReportsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			reportsPageFeatures.waitForPageToLoad();
			myProfilePageFeatures.isMoreInformationDataAvailable();
			reportsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), reportsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			reportsPageFeatures.waitForPageToLoad();
			dashboardPageFeatures.clickdashboardFeedbackLink();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveFeedbackItem()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			dashboardPageFeatures.clickOnFeedbackCloseIcon();
			reportsPageFeatures.waitForPageToLoad();
			int reportsCount = reportsPageFeatures.retrieveReportsCount();

			for (int i = 0; i < reportsCount; i++) {
				reportsPageFeatures.waitForPageToLoad();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"), reportsPageFeatures.retrieveReportsHeaderLabel(i)),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
				reportsPageFeatures.clickOnExitReports();
			}
		}

		else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains Reports Tab. Permission check passed");
		}
		closeTest();
	}

}
