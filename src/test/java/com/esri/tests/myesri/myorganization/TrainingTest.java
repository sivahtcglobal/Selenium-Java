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
import com.esri.sm.myesri.myorganization.TrainingPageFeatures;
import com.esri.sm.myesri.myorganization.TransactionsPageFeatures;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationPage;

/**
 * This test class to validate the MY Esri site My Organization - Training test
 * cases
 * 
 * @author Rizwan
 *
 */
public class TrainingTest extends BaseTestUi {

	private TrainingPageFeatures trainingPageFeatures;
	private DashboardPageFeatures dashboardPageFeatures;
	private List<String> trainingSubLinkNames;
	private AppliCompareData p_AData;
	private TransactionsPageFeatures transactionsPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public TrainingTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
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
	@Test(dataProvider = "csv", groups = { "MyEsriSite", "Regressions", "Training" }, priority = 1)
	public void ValidateTrainingOverview(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("MYESRI")));
		trainingPageFeatures = new TrainingPageFeatures(driver, inputDataMap);
		transactionsPageFeatures = new TransactionsPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.signIn();
		dashboardPageFeatures.clickOnCookiesPopup();

		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), trainingPageFeatures.retrieveMyOrganizationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		if (trainingPageFeatures.isTrainingTabAvailable()) {
			trainingPageFeatures.clickOnTrainingTab();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							trainingPageFeatures.retrieveMyOrganizationHeader()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			dashboardPageFeatures.clickdashboardFeedbackLink();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveFeedbackItem()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			
			dashboardPageFeatures.clickOnFeedbackCloseIcon();

			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							trainingPageFeatures.isMoreInformationDataAvailable()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							trainingPageFeatures.retrieveMyEsriReportsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			transactionsPageFeatures.retrieveExitReportsHeaderLabel();
			
			/*p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							trainingPageFeatures.retrieveTrainingRecordsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							trainingPageFeatures.retrieveVirtualCampusAnnualUserLicensesHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);*/
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains Organization List Tab. Permission check passed");
		}

		//ValidateTrainngRecords(inputDataMap);
		//ValidateVirtualCampusAnnualUserLicenses(inputDataMap);
		closeTest();
	}

	/**
	 * Test to validate the Training Records of Training
	 * 
	 * @param inputDataMap
	 */
	public void ValidateTrainngRecords(Map<String, String> inputDataMap) {
		trainingSubLinkNames = trainingPageFeatures.trainingSubTabs();
		if (trainingSubLinkNames.contains(inputDataMap.get(MyOrganizationPage.TRAINING_RECORDS_HEADER_LABEL))) {

			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							trainingPageFeatures.retrieveTrainingRecordsSideNavHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), trainingPageFeatures.isMoreInformationDataAvailable()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							trainingPageFeatures.retrieveReportsTrainingRecordsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			trainingPageFeatures.clickOnExitReportButton();
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Training Records. Permission check passed");
		}
	}

	/**
	 * Test to validate the Training Records of Training
	 * 
	 * @param inputDataMap
	 */
	public void ValidateVirtualCampusAnnualUserLicenses(Map<String, String> inputDataMap) {
		trainingSubLinkNames = trainingPageFeatures.trainingSubTabs();
		if (trainingSubLinkNames.contains(inputDataMap.get(MyOrganizationPage.TRAINING_RECORDS_HEADER_LABEL))) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							trainingPageFeatures.retrieveVirtualCampusAnnualUserLicensesSideHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), trainingPageFeatures.isMoreInformationDataAvailable()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains side navigation link - Virtual Campus Annual User Licenses. Permission check passed");
		}
	}

}
