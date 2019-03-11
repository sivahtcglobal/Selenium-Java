package com.esri.tests.myesri.dashboard;

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
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;

/**
 * This test class to validate the MY Esri site Dashboard tab
 * 
 * @author Rizwan
 *
 */
public class DashboardTest extends BaseTestUi {

	private DashboardPageFeatures dashboardPageFeatures;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public DashboardTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);

	}

	/**
	 * Test to validate the Login to My Esri QA
	 * 
	 * @param inputDataMap
	 * 
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriHomePage", "Regressions", "SmokeTest" }, priority = 1)
	public void ValidateMyEsriDashboardHomePage(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("MYESRI")));	
		dashboardPageFeatures.clickOnCookiesPopup();
		dashboardPageFeatures.signIn();		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveMyEsriPageHeader()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		ValidateMyEsriDashboardTab(inputDataMap);
		ValidateMyEsriHelpMenu(inputDataMap);
		closeTest();
	}

	/**
	 * Test to validate the Dashboard tab of My Esri site
	 * 
	 * @param inputDataMap
	 */
	public void ValidateMyEsriDashboardTab(Map<String, String> inputDataMap) {
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveAnnouncementsHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveCommonQuestionHeaderLabel()), ComparisonLevel.CONTENT,
				true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		int listCount = dashboardPageFeatures.retrieveCommonQuestionsCatageriousCount();
		for (int i = 0; i < listCount; i++) {
			Map<String, Boolean> results = dashboardPageFeatures
					.isCommonQuestionsAvailable(dashboardPageFeatures.retrieveCommonQuestionsCatageriousElements(), i);
			Log.info("Key and Pair results are here : " + results);
			for (String resultKey : results.keySet()) {
				Log.info("Input Data : " + resultKey + " = " + results.get(resultKey));
				reportLogger.assertTrue(results.get(resultKey),
						"Validate the " + resultKey + " Topic Common Questions are available");
			}
		}
		dashboardPageFeatures.isCommonQuestionsSearchSuccessful();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), inputDataMap.get(MyEsriUserPages.SEARCH_TEXT)), ComparisonLevel.CONTENT,
				true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		dashboardPageFeatures.clickdashboardFeedbackLink();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveFeedbackItem()), ComparisonLevel.CONTENT,
				true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		dashboardPageFeatures.clickOnFeedbackCloseIcon();
		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveContactUsHeaderLabel()), ComparisonLevel.CONTENT,
				true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		dashboardPageFeatures.clickOnSend();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.getTitle()), ComparisonLevel.CONTENT,
				true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
	}

	/**
	 * Test to validate the My Esri Help Menu from Dashboard Tab
	 * 
	 * @param inputDataMap
	 */
	public void ValidateMyEsriHelpMenu(Map<String, String> inputDataMap) {
		dashboardPageFeatures.isHelpContentPopulatedSuccessfully();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.getTitle()), ComparisonLevel.CONTENT,
				true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveHelpCommonQuestionsHeaderLabel()), ComparisonLevel.CONTENT,
				true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
	
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveGeoNetHeaderLabel()), ComparisonLevel.CONTENT,
				true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveSendFeedbackHeaderLabel()), ComparisonLevel.CONTENT,
				true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveHelpContactUsHeaderLabel()), ComparisonLevel.CONTENT,
				true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
	}

}
