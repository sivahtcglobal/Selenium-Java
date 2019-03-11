package com.esri.tests.training.catalog;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.ui.BaseTestUi;
import com.esri.sm.training.catalog.CourseRegistrationPageFeatures;
import com.esri.sm.training.catalog.FindTrainingPageFeatures;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;

/**
 * This test class to validate Training Site Course Registration Page
 * 
 * @author Rizwan
 *
 */

public class CourseRegistrationPageTest extends BaseTestUi {

	private FindTrainingPageFeatures findTrainingPageFeatures;
	private CourseRegistrationPageFeatures courseRegistrationPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public CourseRegistrationPageTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate Training Site Course Registration page
	 * 
	 * @param inputDataMap
	 * 
	 */
	@Test(dataProvider = "csv", groups = { "Registration", "Regressions" }, priority = 2)
	public void ValidateCourseRegistration(Map<String, String> inputDataMap) {
		findTrainingPageFeatures = new FindTrainingPageFeatures(driver, inputDataMap);
		findTrainingPageFeatures.clickOnFindTrainingSubMenu();
		findTrainingPageFeatures.filterInstructorLedCourseOnly();
		findTrainingPageFeatures.clickFirstCardDetailsButton();
		courseRegistrationPageFeatures = findTrainingPageFeatures.clickRegisterButton();
		courseRegistrationPageFeatures.clickRegisterButton();
		courseRegistrationPageFeatures.signIn();
		courseRegistrationPageFeatures.clickOnAddToWaitlistButton();
		reportLogger.assertEquals(courseRegistrationPageFeatures.retrieveOrganizationInformationLabel(),
				inputDataMap.get(CatalogPage.ORGANIZATION_INFORMATION_PAGE_HEADER),
				"Validate if the Organization Information page is correct.");
		courseRegistrationPageFeatures.enterOrganizationInformation();
		courseRegistrationPageFeatures.selectPaymentInfo();
		reportLogger.assertEquals(courseRegistrationPageFeatures.retrieveFirstNameLabel(),
				inputDataMap.get(CatalogPage.FIRST_NAME), "Validate if the Date Range Filter results are correct.");
		courseRegistrationPageFeatures.clickOnSubmitRegistration();
		reportLogger.assertEquals(courseRegistrationPageFeatures.retrieveTitle(),
				inputDataMap.get(CatalogPage.REGISTRATION_SUCCESS_PAGE_TITLE),
				"Validate if the Course Registration is successfull.");
		closeTest();
	}

}
