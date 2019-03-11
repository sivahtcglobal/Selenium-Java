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
import com.esri.sm.myesri.myorganization.ProgramsPageFeatures;
import com.esri.sm.myesri.myprofile.MyProfilePageFeatures;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;

/**
 * This test class to validate the MY Esri site My Organization - Programs test
 * cases
 * 
 * @author Rizwan
 *
 */
public class ProgramsTest extends BaseTestUi {

	private ProgramsPageFeatures programsPageFeatures;
	private DashboardPageFeatures dashboardPageFeatures;
	private MyProfilePageFeatures myProfilePageFeatures;
	private AppliCompareData p_AData;
	
	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public ProgramsTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Events of My Organization Tab
	 * 
	 * @param inputDataMap
	 * 
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriSite", "Regressions", "Programs" }, priority = 1)
	public void ValidatePrograms(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("MYESRI")));
		programsPageFeatures = new ProgramsPageFeatures(driver, inputDataMap);
		myProfilePageFeatures = new MyProfilePageFeatures(driver, inputDataMap);
		dashboardPageFeatures.signIn();
		dashboardPageFeatures.clickOnCookiesPopup();
		programsPageFeatures.waitForPageToLoad();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), programsPageFeatures.retrieveMyOrganizationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		
		if (programsPageFeatures.isProgramsTabAvailable()) {
			
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), programsPageFeatures.retrieveProgramsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			programsPageFeatures.waitForPageToLoad();
			
			myProfilePageFeatures.isMoreInformationDataAvailable();
			programsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), programsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			programsPageFeatures.waitForPageToLoad();
			dashboardPageFeatures.clickdashboardFeedbackLink();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),dashboardPageFeatures.retrieveFeedbackItem()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			
			dashboardPageFeatures.clickOnFeedbackCloseIcon();
			programsPageFeatures.waitForPageToLoad();
			programsPageFeatures.isTrainingSearchResultsAreAvailable();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), programsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			programsPageFeatures.waitForPageToLoad();
			programsPageFeatures.isAdditionalServicesSearchResultsAreAvailable();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), programsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			programsPageFeatures.waitForPageToLoad();
			programsPageFeatures.isConsultingSearchResultsAreAvailable();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), programsPageFeatures.getTitle()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains Program Tabs. Permission check passed");
		}
		closeTest();
	}

}
