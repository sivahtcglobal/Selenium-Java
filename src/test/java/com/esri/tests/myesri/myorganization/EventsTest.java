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
import com.esri.sm.myesri.myorganization.EventsPageFeatures;
import com.esri.sm.myesri.myprofile.MyProfilePageFeatures;
import com.esri.support.modules.core.MyEsriConstants.MyEsriUserPages;

/**
 * This test class to validate the MY Esri site My Organization - Events test
 * cases
 * 
 * @author Rizwan
 *
 */
public class EventsTest extends BaseTestUi {

	private EventsPageFeatures eventsPageFeatures;
	private DashboardPageFeatures dashboardPageFeatures;
	private MyProfilePageFeatures myProfilePageFeatures;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EventsTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
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
	@Test(dataProvider = "csv", groups = { "MyEsriSite", "Regressions", "Events" }, priority = 1)
	public void ValidateEvents(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("MYESRI")));
		eventsPageFeatures = new EventsPageFeatures(driver, inputDataMap);
		myProfilePageFeatures = new MyProfilePageFeatures(driver, inputDataMap);
		dashboardPageFeatures.signIn();
		dashboardPageFeatures.clickOnCookiesPopup();
		eventsPageFeatures.waitForPageToLoad();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), eventsPageFeatures.retrieveMyOrganizationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);

		if (eventsPageFeatures.isEventsTabAvailable()) {
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"),
							eventsPageFeatures.retrieveUserConferenceRegistrationsHeaderLabel()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);

			myProfilePageFeatures.isMoreInformationDataAvailable();
			eventsPageFeatures.waitForPageToLoad();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), eventsPageFeatures.getTitle()), ComparisonLevel.CONTENT,
					true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			eventsPageFeatures.waitForPageToLoad();
			dashboardPageFeatures.clickdashboardFeedbackLink();
			p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
					String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveFeedbackItem()),
					ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
			AppliCompareImage(p_AData);
			dashboardPageFeatures.clickOnFeedbackCloseIcon();
			if (eventsPageFeatures.isEsriUserConferenceRegistrationsDataAvailable()) {
				eventsPageFeatures.waitForPageToLoad();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								eventsPageFeatures.retrieveRegistrationDetailsHeaderLabel()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
				eventsPageFeatures.waitForPageToLoad();
				p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
						String.format("%s - %s", Env.get("MYESRI"),
								eventsPageFeatures.validateBackToUserConferenceRegistrationsButton()),
						ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
				AppliCompareImage(p_AData);
			} else {
				Log.info("User doesn't contains Esri User Conference Registrations Data");
			}
		} else {
			reportLogger.assertTrue(true, "User - " + inputDataMap.get(MyEsriUserPages.USERNAME) + " "
					+ "doesn't contains Events Tab. Permission check passed");
		}
		closeTest();
	}

}
