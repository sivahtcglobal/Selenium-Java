package com.esri.tests.isp;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.config.Env;
import com.esri.qa.ui.BaseTestUi;
import com.esri.support.modules.core.Constants.ImageSubPortalHomePage;
import com.esri.support.modules.ecommerce.EcommerceNewCustomerPageFeatures;
import com.esri.support.modules.isp.ImageSubPortalPageFeatures;

/**
 * 
 * This is the Image submission portal webpage class to identify the objects
 * within the page
 * 
 * @author deenesh
 *
 */
public class ImageSubPortalPageTest extends BaseTestUi {
	private ImageSubPortalPageFeatures imageSubPortalPageFeature;
	private EcommerceNewCustomerPageFeatures newCustomerPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public ImageSubPortalPageTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Image Submission Portal Home Page
	 * 
	 * @param inputDatamap
	 */
	@Test(dataProvider = "csv", groups = { "Image-submission-portal", "Regressions" }, priority = 1)
	public void ValidateImageSubmissionPortalTests(Map<String, String> inputDataMap) {
		imageSubPortalPageFeature = new ImageSubPortalPageFeatures(driver, inputDataMap);
		newCustomerPageFeatures = new EcommerceNewCustomerPageFeatures(driver, inputDataMap);
		imageSubPortalPageFeature.openURL(Env.get("IMAGESUBMISSION"));
		newCustomerPageFeatures.clickOnCookiesPopup();
		reportLogger.assertEquals(imageSubPortalPageFeature.getPageTitle(),
				inputDataMap.get(ImageSubPortalHomePage.PAGE_TITLE),
				"Validate if the title of the ISP home page is correct.");
		reportLogger.assertEquals(imageSubPortalPageFeature.getWelcomeLabel(),
				inputDataMap.get(ImageSubPortalHomePage.WELCOME_LABEL),
				"Validate if the welcome header of the ISP home page is correct.");
		
		// call submitting image files for conference		
		ValidateSubmittingImageFilesForConference(inputDataMap);
		
		// call submitting Video files for conference	
		ValidateSubmittingVideoFilesForConference(inputDataMap);
		
		closeTest();
	}

	/**
	 * Test to validate the uploading image files for the conference.
	 * 
	 * @param inputDatamap
	 */
	public void ValidateSubmittingImageFilesForConference(Map<String, String> inputDataMap) {
		// check first item from drop down
		imageSubPortalPageFeature.selectEvent();
		imageSubPortalPageFeature.clickNoRadioBtn();
		imageSubPortalPageFeature.clickGetStartedBtn();
		imageSubPortalPageFeature.clickIAgreeCheckBox();
		reportLogger.assertEquals(imageSubPortalPageFeature.getIAgreePageHeader(),
				inputDataMap.get(ImageSubPortalHomePage.IAGREE_PAGE_LABEL),
				"Validate if the header of the I agree page is correct.");
		imageSubPortalPageFeature.clickContinueBtn();
		reportLogger.assertEquals(imageSubPortalPageFeature.getPermissionPageHeader(),
				inputDataMap.get(ImageSubPortalHomePage.PERMISSION_PAGE_LABEL),
				"Validate if the header of the Permission page is correct.");
		imageSubPortalPageFeature.clickContinueBtn();
	}

	/**
	 * Test to validate the uploading video files for the conference.
	 * 
	 * @param inputDatamap
	 */
	public void ValidateSubmittingVideoFilesForConference(Map<String, String> inputDataMap) {
		imageSubPortalPageFeature.navigateToHomePage();
		imageSubPortalPageFeature.selectEvent();
		imageSubPortalPageFeature.clickVideoRadioBtn();
		imageSubPortalPageFeature.clickYesRadioBtn();
		imageSubPortalPageFeature.clickGetStartedBtn();
		reportLogger.assertEquals(imageSubPortalPageFeature.getVideoPageHeader(),
				inputDataMap.get(ImageSubPortalHomePage.VIDEO_PAGE_LABEL),
				"Validate if the header of the video page is correct.");
	}

}
