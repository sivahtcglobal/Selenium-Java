package com.esri.tests.careers.jobsearch;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.BaseTestUi;
import com.esri.sm.careers.jobsearch.JobSearchPageFeatures;
import com.esri.support.modules.core.CareersConstants.CareersJobSearch;

/**
 * This test class to validate the Careers-Job Search
 * 
 * @author anushar
 */
public class CareersJobSearchTest extends BaseTestUi {

	private JobSearchPageFeatures jobSearchPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public CareersJobSearchTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Launch application of careers job search
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "JobSearch", "Regressions" }, priority = 1)
	public void ValidateCareersJobSearchHomePage(Map<String, String> inputDataMap) {
		jobSearchPageFeatures = new JobSearchPageFeatures(driver, inputDataMap);
		reportLogger.assertEquals(jobSearchPageFeatures.getTitle(), inputDataMap.get(CareersJobSearch.HOME_PAGE_TITLE),
				"Validate if the Careers Job Search Home Page label is correct.");
		ValidateCareersJobSearchFunctionality(inputDataMap);
		ValidateRightNavigationLinks(inputDataMap);
		ValidateJobCategorySearchFunctionality(inputDataMap);	
		ValidateJobLocationSearchFunctionality(inputDataMap);
		ValidateSocialLinks(inputDataMap);
		closeTest();
	}

	/**
	 * Test to validate the search functionality
	 *
	 * @param inputDatamap
	 * @throws Exception
	 */
	public void ValidateCareersJobSearchFunctionality(Map<String, String> inputDataMap) {
		jobSearchPageFeatures.searchDesiredTextInHomePage();
		jobSearchPageFeatures.retrieveListOfSearchResults();
		reportLogger.assertTrue(jobSearchPageFeatures.retrieveSearchTextInResults(), "Validated search functionality");
	}

	/**
	 * Test to validate right navigation list in job search page
	 * 
	 * @param inputDataMap
	 */
	public void ValidateRightNavigationLinks(Map<String, String> inputDataMap) {
		Map<String, String> results = null;
		boolean benefitsTitle = false;
		int listCount = jobSearchPageFeatures.getRightNavigationLinkElements().size();
		for (int i = 0; i < listCount; i++) {
			if (i == 2) {
				Log.info("This is Benefits PDF");
				results = jobSearchPageFeatures.getLinkTitle(jobSearchPageFeatures.getRightNavigationLinkElements(), i,
						CareersJobSearch.RIGHT_LINKS);
				String actualTitle = jobSearchPageFeatures.getDriver().getCurrentUrl();
				Log.info("actualTitle" + actualTitle);
				if (actualTitle.contains(CareersJobSearch.BENEFITS_PDF)) {
					benefitsTitle = true;
				}
				reportLogger.assertTrue(benefitsTitle, "Validated the RightNavigationLinkPageTitle3");
			} else {
				results = jobSearchPageFeatures.getLinkTitle(jobSearchPageFeatures.getRightNavigationLinkElements(), i,
						CareersJobSearch.RIGHT_LINKS);
				for (String resultKey : results.keySet()) {
					if (inputDataMap.containsKey(resultKey)) {
						Log.info("Input Data : " + resultKey + " = " + inputDataMap.get(resultKey));
						reportLogger.assertEquals(results.get(resultKey).replaceAll("[\n\r]", " "),
								inputDataMap.get(resultKey),
								"Validate the " + resultKey + " of RightNavigation link is correct.");
					} else {
						reportLogger
								.error("RightNavigation List link doesn't exist in input data sheet - " + resultKey);
					}
				}
			}
		}
	}

	/**
	 * Test to validate the search functionality based on job category
	 *
	 * @param inputDatamap
	 * @throws Exception
	 */
	public void ValidateJobCategorySearchFunctionality(Map<String, String> inputDataMap) {
		jobSearchPageFeatures.selectDesiredJobCategory();
		reportLogger.assertTrue(jobSearchPageFeatures.isSelectedJobCategory(),
				"Validated search functionality based on job category");
	}

	/**
	 * Test to validate the search functionality based on job location
	 *
	 * @param inputDatamap
	 * @throws Exception
	 */
	public void ValidateJobLocationSearchFunctionality(Map<String, String> inputDataMap) {
		jobSearchPageFeatures.selectDesiredJobLocation();
		reportLogger.assertTrue(jobSearchPageFeatures.isSelectedJobLocation(),
				"Validated search functionality based on job location");
	}

	/**
	 * Test to validate social link in job search page
	 * 
	 * @param inputDataMap
	 */
	public void ValidateSocialLinks(Map<String, String> inputDataMap) {
		Map<String, String> results = null;
		boolean instagramTitle = false;
		int listCount = jobSearchPageFeatures.getSocialLinkElements().size();
		for (int i = 0; i < listCount; i++) {
			if (i == 1) {
				Log.info("This is Instagram social link");
				results = jobSearchPageFeatures.getLinkTitle(jobSearchPageFeatures.getSocialLinkElements(), i,
						CareersJobSearch.SOCIAL_LINKS);
				String actualTitle = results.get(CareersJobSearch.SOCIAL_LINK_PAGE_TITLE_2);
				if (actualTitle.contains(CareersJobSearch.INSTAGRAM)) {
					instagramTitle = true;
				}
				reportLogger.assertTrue(instagramTitle, "Validated the socialLinkPageTitle2");
			} else {
				results = jobSearchPageFeatures.getLinkTitle(jobSearchPageFeatures.getSocialLinkElements(), i,
						CareersJobSearch.SOCIAL_LINKS);
				for (String resultKey : results.keySet()) {
					if (inputDataMap.containsKey(resultKey)) {
						if (!results.get(resultKey).equals(CareersJobSearch.FACEBOOK_TITLE_TEXT)) {
							Log.info("Input Data : " + resultKey + " = " + inputDataMap.get(resultKey));
							reportLogger.assertEquals(results.get(resultKey).replaceAll("[\n\r]", " "),
									inputDataMap.get(resultKey),
									"Validate the " + resultKey + " of social link is correct.");
						}

					} else {
						reportLogger.error("Social List link doesn't exist in input data sheet - " + resultKey);
					}
				}
			}
		}
	}

}
