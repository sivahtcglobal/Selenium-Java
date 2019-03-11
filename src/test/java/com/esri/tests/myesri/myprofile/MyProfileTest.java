package com.esri.tests.myesri.myprofile;

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
import com.esri.sm.myesri.myprofile.MyProfilePageFeatures;

/**
 * This test class to validate the MY Esri Dashboard Overview
 * 
 * @author Rizwan
 *
 */
public class MyProfileTest extends BaseTestUi {

	private DashboardPageFeatures dashboardPageFeatures;
	private MyProfilePageFeatures myProfilePageFeatures;
	private AppliCompareData p_AData;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public MyProfileTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the My Profile tab of My Esri site
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "MyEsriSite", "Regressions", "MyProfile", "SmokeTest" }, priority = 1)
	public void ValidateProfileOverview(Map<String, String> inputDataMap) {
		dashboardPageFeatures = new DashboardPageFeatures(driver, inputDataMap);
		dashboardPageFeatures.openURL(inputDataMap.get("url").replaceAll("base.url", Env.get("MYESRI")));
		myProfilePageFeatures = new MyProfilePageFeatures(driver, inputDataMap);
		dashboardPageFeatures.signIn();
		dashboardPageFeatures.clickOnCookiesPopup();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrievePageTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveMyProfileHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		dashboardPageFeatures.isHelpContentPopulatedSuccessfully();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		dashboardPageFeatures.clickOnMyEsriHelpMenuCloseLink();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);		
		dashboardPageFeatures.clickdashboardFeedbackLink();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.retrieveFeedbackItem()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		dashboardPageFeatures.clickOnFeedbackCloseIcon();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), dashboardPageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);
		myProfilePageFeatures.isMoreInformationDataAvailable();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveUpdateContactInformationSuccesssMessage()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);

		ValidateEditContactInformation(inputDataMap);
		ValidatePendingPermissionsRequest(inputDataMap);
		ValidateEditEmailSettings(inputDataMap);
		ValidateChangePassword(inputDataMap);
		ValidateChangeSecurityQuestion(inputDataMap);
		ValidateEditLanguageSettings(inputDataMap);
		ValidateConnectToYourOrganization(inputDataMap);
		ValidateDisconnectFromYourOrganization(inputDataMap);
		closeTest();

	}

	/**
	 * Test to validate the My Profile tab Edit Contact Information of My Esri
	 * site
	 * 
	 * @param inputDataMap
	 */
	public void ValidateEditContactInformation(Map<String, String> inputDataMap) {	 
	 p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveEditContactInformationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);		
	p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
			String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveContactInformationUpdateSuccesssMessage()),
			ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
	AppliCompareImage(p_AData);	
				
	}

	/**
	 * Test to validate the My Profile tab Pending Permissions Request of My
	 * Esri site
	 * 
	 * @param inputDataMap
	 */
	public void ValidatePendingPermissionsRequest(Map<String, String> inputDataMap) {		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrievePendingPermissionsRequestsHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);			
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveRequestPermissionsHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);	
	}

	/**
	 * Test to validate the My Profile tab Edit Email Settings of My Esri site
	 * 
	 * @param inputDataMap
	 */
	public void ValidateEditEmailSettings(Map<String, String> inputDataMap) {
		myProfilePageFeatures.clickOnMyProfileLink();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);			
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveEditEmailSettingsHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);					
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveUpdateEmailSettingsHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);	
	}

	/**
	 * Test to validate the My Profile tab Change Password of My Esri site
	 * 
	 * @param inputDataMap
	 */
	public void ValidateChangePassword(Map<String, String> inputDataMap) {		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveChangePasswordHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);	
	}

	/**
	 * Test to validate the My Profile tab Change Security Question of My Esri
	 * site
	 * 
	 * @param inputDataMap
	 */
	public void ValidateChangeSecurityQuestion(Map<String, String> inputDataMap) {		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveChangeSecurityQuestionHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);	
		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveChangeSecurityQuestionSuccessMessage()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);	
	}

	/**
	 * Test to validate the My Profile tab Edit Language Settings of My Esri
	 * site
	 * 
	 * @param inputDataMap
	 */
	public void ValidateEditLanguageSettings(Map<String, String> inputDataMap) {
		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveEditLanguageSettingsHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);	
	}

	/**
	 * Test to validate the My Profile tab Connect to Your Organization of My
	 * Esri site
	 * 
	 * @param inputDataMap
	 */
	public void ValidateConnectToYourOrganization(Map<String, String> inputDataMap) {
		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveConnectToYourOrganizationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);				
		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveConnectWithATokenHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);	
		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveRequestPermissionsLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);	
		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveRequestPermissionsSendRequestSuccessMessage()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);	
		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveEsriTrialsAndStudentAccountsHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);	
	}

	/**
	 * Test to validate the My Profile tab Disconnect from Your Organization of
	 * My Esri site
	 * 
	 * @param inputDataMap
	 */
	public void ValidateDisconnectFromYourOrganization(Map<String, String> inputDataMap) {
		
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.retrieveDisconnectFromYourOrganizationHeaderLabel()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);	
		myProfilePageFeatures.isMoreInformationDataAvailable();
		p_AData = new AppliCompareData(driver, inputDataMap.get("TestCaseName"),
				String.format("%s - %s", Env.get("MYESRI"), myProfilePageFeatures.getTitle()),
				ComparisonLevel.CONTENT, true, ViewPortSize.MAX);
		AppliCompareImage(p_AData);	
	}

}
