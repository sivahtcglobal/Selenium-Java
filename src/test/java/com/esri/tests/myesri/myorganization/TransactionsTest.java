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
import com.esri.sm.myesri.myorganization.TransactionsPageFeatures;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;
import com.esri.support.modules.core.MyEsriConstants.MyOrganizationPage;

/**
 * This test class to validate the MY Esri My Organization tab test cases
 * 
 * @author Rizwan
 *
 */
public class TransactionsTest extends BaseTestUi {

	private DashboardPageFeatures dashboardPageFeatures;
	private TransactionsPageFeatures transactionsPageFeatures;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public TransactionsTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the My Organization sub tab Transactions of My Esri site
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriSite", "Regressions", "Transactions" }, priority = 2)
	public void ValidateMyOrganizationsSubTabTransactions(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("MYESRI")));
		transactionsPageFeatures = new TransactionsPageFeatures(driver, inputDataMap);
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrievePageTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		dashboardPageFeatures.signIn();
		transactionsPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveMyEsriPageHeader()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		transactionsPageFeatures.clickOnMyOrganizationHeaderLabel();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"),
						transactionsPageFeatures.retrieveMyOrganizationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);

		List<String> subLinksNames = transactionsPageFeatures.myOrganizationSubTabs();
		for (int i = 0; i < subLinksNames.size(); i++) {
			if (subLinksNames.get(i).contains(inputDataMap.get(MyOrganizationPage.TRANSACTIONS))) {
				transactionsPageFeatures.clickOnTransactionsLink();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								transactionsPageFeatures.retrieveTransactionOverviewHeaderLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
				dashboardPageFeatures.clickdashboardFeedbackLink();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveFeedbackItem()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
				dashboardPageFeatures.clickOnFeedbackCloseIcon();

				if (inputDataMap.get(MyEsriUserPages.USERNAME).contains("EsriTestAutomation4")) {
					Log.info("User is EsriTestAutomation4");
				} else {
					for (i = 0; i < transactionsPageFeatures.transactionOverviewSubTabs(); i++) {
						transactionsPageFeatures.clickOnTransactionsOverviewSubLink(i);

						p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
								String.format("%s - %s", Env.get("MYESRI"),
										transactionsPageFeatures.retrieveMaintenanceQuotesHeaderLabel()),
								ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
						AppliCompareImage(p_AData);
						if (i == 1 || i == 2) {
							p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
									String.format("%s - %s", Env.get("MYESRI"),
											transactionsPageFeatures.isMoreInformationDataAvailable()),
									ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
							AppliCompareImage(p_AData);
						} else {
							p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
									String.format("%s - %s", Env.get("MYESRI"),
											transactionsPageFeatures.isMoreInformationDataAvailableForTV()),
									ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
							AppliCompareImage(p_AData);
						}
						transactionsPageFeatures.clickOnTransactionOverviewLink();
					}
				}
				closeTest();
			}
		}
	}

}
