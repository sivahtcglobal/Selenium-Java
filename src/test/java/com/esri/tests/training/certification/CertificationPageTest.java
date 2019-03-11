package com.esri.tests.training.certification;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.ui.BaseTestUi;
import com.esri.sm.training.certification.CertificationPageFeatures;
import com.esri.support.modules.core.TrainingConstants.CertificationPage;

/**
 * This is the Esri Traning - MyLearning and its submenus page tests.
 * 
 * @author Thenmozhi
 */
public class CertificationPageTest extends BaseTestUi {

	private CertificationPageFeatures certificationPageFeature;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public CertificationPageTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Certification OverView Submenu Page.
	 * 
	 * @param inputDatamap
	 */
	@Test(dataProvider = "csv", groups = { "TrainingSite", "Regressions" }, priority = 1, enabled=false)
	public void ValidateCertificationMenu(Map<String, String> inputDataMap) {
		certificationPageFeature = new CertificationPageFeatures(driver, inputDataMap);
		certificationPageFeature.navigateToHomePage();
		certificationPageFeature.clickCertificationSubmenuCertificationOverview();
		reportLogger.assertEquals(certificationPageFeature.retrieveTitle(),
				inputDataMap.get(CertificationPage.CERTIFICATION_OVERVIEW_TITLE),
				"Validate if the title of the 'Certification Overview' sub menu Page is correct.");
		String getStartedHeader = certificationPageFeature.retrieveGetStartedPageHeader();
		reportLogger.assertEquals(getStartedHeader, inputDataMap.get(CertificationPage.GET_STARTED_HEADER),
				"Validate if the header of the 'Get Started' Page is correct.");
		certificationPageFeature.navigateToCertificationPage();
		String registerNowHeader = certificationPageFeature.retrieveRegisterNowPageHeader();
		reportLogger.assertEquals(registerNowHeader, inputDataMap.get(CertificationPage.REGISTER_NOW_HEADER),
				"Validate if the header of the 'Register Now' Page is correct.");
		certificationPageFeature.navigateToCertificationPage();
		String manageCertificationHeader = certificationPageFeature.retrieveManageCertificationPageHeader();
		reportLogger.assertEquals(manageCertificationHeader, inputDataMap.get(CertificationPage.MANAGE_CERT_HEADER),
				"Validate if the header of the 'Manage Certification' Page is correct.");
		certificationPageFeature.navigateToCertificationPage();
		String directoryHeader = certificationPageFeature.retrieveDirectoryPageHeader();
		reportLogger.assertEquals(directoryHeader, inputDataMap.get(CertificationPage.DIRECTORY_HEADER),
				"Validate if the header of the 'Directory' Page is correct.");
		certificationPageFeature.navigateToCertificationPage();
		
		ValidateCertificationSubMenuCertificationExamsPage(inputDataMap);
		ValidateCertificationSubMenuTakingAnExamPage(inputDataMap);
		ValidateCertificationSubMenuManageCertificationsPage(inputDataMap);
		ValidateCertificationSubMenuDirectoryPage(inputDataMap);
		
		closeTest();
	}

	/**
	 * Test to validate the Certification Exams Submenu Page.
	 * 
	 * @param inputDatamap
	 */
	public void ValidateCertificationSubMenuCertificationExamsPage(Map<String, String> inputDataMap) {
		certificationPageFeature = new CertificationPageFeatures(driver, inputDataMap);
		certificationPageFeature.navigateToHomePage();
		certificationPageFeature.clickCertificationSubmenuCertificationExams();
		reportLogger.assertEquals(certificationPageFeature.retrieveTitle(),
				inputDataMap.get(CertificationPage.CERTIFICATION_EXAMS_TITLE),
				"Validate if the title of the 'Certifications Exams' sub menu Page is correct.");
	}

	/**
	 * Test to validate the Taking An Exam Submenu Page.
	 * 
	 * @param inputDatamap
	 */
	public void ValidateCertificationSubMenuTakingAnExamPage(Map<String, String> inputDataMap) {
		certificationPageFeature = new CertificationPageFeatures(driver, inputDataMap);
		certificationPageFeature.navigateToHomePage();
		certificationPageFeature.signIn();
		certificationPageFeature.clickCertificationSubmenuTakingAnExam();
		reportLogger.assertEquals(certificationPageFeature.retrieveTitle(),
				inputDataMap.get(CertificationPage.TAKING_AN_EXAM_TITLE),
				"Validate if the title of the 'Taking An Exam' sub menu Page is correct.");
		String sTakingAnExamHeader = certificationPageFeature.retrieveTakingAnExamPageHeader();
		reportLogger.assertEquals(sTakingAnExamHeader, inputDataMap.get(CertificationPage.TAKING_AN_EXAM_HEADER),
				"Validate if the header of the 'Taking An Exam' Page is matching.");
		String sCheckOutHeader = certificationPageFeature.retrieveCheckoutPageHeader();
		reportLogger.assertEquals(sCheckOutHeader, inputDataMap.get(CertificationPage.CHECKOUT_HEADER),
				"Validate if the header of the 'Checkout' Page is matching.");
		String sAfterCheckOutHeader = certificationPageFeature.retrieveAfterCheckoutPageHeader();
		reportLogger.assertEquals(sAfterCheckOutHeader, inputDataMap.get(CertificationPage.AFTER_CHECKOUT_HEADER),
				"Validate if the header of the 'Checkout' Page after Checkout.");
	}

	/**
	 * Test to validate the Manage Certifications Submenu Page.
	 * 
	 * @param inputDatamap
	 */
	public void ValidateCertificationSubMenuManageCertificationsPage(Map<String, String> inputDataMap) {
		certificationPageFeature = new CertificationPageFeatures(driver, inputDataMap);
		certificationPageFeature.navigateToHomePage();
		certificationPageFeature.clickCertificationSubmenuManageCertification();
		reportLogger.assertEquals(certificationPageFeature.retrieveTitle(),
				inputDataMap.get(CertificationPage.MANAGE_CERTIFICATIONS_TITLE),
				"Validate if the title of the 'Manage Certifications' sub menu Page is correct.");
		String sManageYourCertificationHeader = certificationPageFeature.retrieveManageYourCertificationPageHeader();
		reportLogger.assertEquals(sManageYourCertificationHeader,
				inputDataMap.get(CertificationPage.MANAGE_YOUR_CERTIFICATION_HEADER),
				"Validate if the header of the 'Manage Certifications' sub menu Page is correct.");
		certificationPageFeature.clickAccessMyCertificationBtn();
		reportLogger.assertEquals(certificationPageFeature.retrieveTitle(),
				inputDataMap.get(CertificationPage.CERTIFICATION_LOGIN_TITLE),
				"Validate if the title of the 'My Certification Login' Page is correct.");
		reportLogger.assertEquals(certificationPageFeature.retrieveVerifyACertificationTitle().trim(),
				inputDataMap.get(CertificationPage.CERTIFICATION_VERIFICATION_TITLE).trim(),
				"Validate if the title of the 'Certification Verificaction' Page is correct.");
	}

	/**
	 * Test to validate the Directory Submenu Page.
	 * 
	 * @param inputDatamap
	 */
	public void ValidateCertificationSubMenuDirectoryPage(Map<String, String> inputDataMap) {
		certificationPageFeature = new CertificationPageFeatures(driver, inputDataMap);
		certificationPageFeature.navigateToHomePage();
		certificationPageFeature.clickCertificationSubmenuDirectory();
		reportLogger.assertEquals(certificationPageFeature.retrieveTitle(),
				inputDataMap.get(CertificationPage.DIRECTORY_TITLE),
				"Validate if the title of the 'Directory' sub menu Page is correct.");
		certificationPageFeature.clickCertificationRecordLink();
		reportLogger.assertEquals(certificationPageFeature.retrieveTitle(),
				inputDataMap.get(CertificationPage.CERTIFICATION_LOGIN_TITLE),
				"Validate if the title of the 'Certification Record' Link Page is correct.");
		String sVerifyTheCodeTitle = certificationPageFeature.retrieveVerifyTheCodePageTitle();
		reportLogger.assertEquals(sVerifyTheCodeTitle,
				inputDataMap.get(CertificationPage.CERTIFICATION_VERIFICATION_TITLE),
				"Validate if the title of the 'Verify The Code' link Page is correct.");
		certificationPageFeature.enterSearchText();
		certificationPageFeature.selectAllCountriesFilter();
		certificationPageFeature.selectAllCertificationsFilter();
		int iResultsCount = certificationPageFeature.retrieveItemsDisplayedCount();
		reportLogger.assertTrue(iResultsCount > 0,
				"Validate the search results count of the 'Learning Activity' page. Actual: " + "Is greater than Zero");
	}

}
