package com.esri.tests.wherenextmagazine;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.config.Env;
import com.esri.qa.ui.BaseTestUi;
import com.esri.support.modules.core.Constants.WhereNextMagazineHomePage;
import com.esri.support.modules.wherenextmagazine.WhereNextMagazinePageFeatures;

/**
 * Test Class to test WhereNext Magazine features within the page
 * 
 * @author thenmozhiS
 */
public class WhereNextMagazineHomePageTests extends BaseTestUi {

	private WhereNextMagazinePageFeatures whereNextMagazinePageFeature;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension"})
	public WhereNextMagazineHomePageTests(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Sign Up Subscription
	 * 
	 * @param inputDatamap
	 */
	@Test(dataProvider = "csv", groups = { "Where-Next-Magazine", "Regressions" }, enabled = true, priority = 1)

	public void ValidateSubscription(Map<String, String> inputDataMap) {
		whereNextMagazinePageFeature = new WhereNextMagazinePageFeatures(driver, inputDataMap);		
		whereNextMagazinePageFeature.openURL(Env.get("WHERENEXTMAGAZINE"));
		reportLogger.assertEquals(whereNextMagazinePageFeature.retrieveTitle(),
				inputDataMap.get(WhereNextMagazineHomePage.PAGE_TITLE),
				"Validate that title of the WhereNext Magazine page is correct. Expected : "
						+ inputDataMap.get(WhereNextMagazineHomePage.PAGE_TITLE));
		/*reportLogger.assertEquals(whereNextMagazinePageFeature.getSubscriptionMessage(),
				inputDataMap.get(WhereNextMagazineHomePage.THANK_YOU_TEXT),
				"Validate that sign up subsription is successful. Expected : "
						+ inputDataMap.get(WhereNextMagazineHomePage.THANK_YOU_TEXT));*/
		//Search functionalities
		ValidateWhereNextSearch(inputDataMap);		
		ValidateAnArticleInWhereNextMagazine(inputDataMap);
		ValidateAuthorBioPage(inputDataMap);		
		closeTest();
	}

	/**
	 * Test to validate the Search functionality
	 * 
	 * @param inputDatamap
	 */
	public void ValidateWhereNextSearch(Map<String, String> inputDatamap) {
		whereNextMagazinePageFeature.openURL(Env.get("WHERENEXTMAGAZINE"));
		reportLogger.assertEquals(whereNextMagazinePageFeature.getSearchResultHeader(),
				inputDatamap.get(WhereNextMagazineHomePage.SEARCH_RESULT),
				"Validate that search is successful. Expected : "
						+ inputDatamap.get(WhereNextMagazineHomePage.SEARCH_RESULT));
	}

	/**
	 * Test to validate the an Article In WhereNextMagazine
	 * 
	 * @param inputDatamap
	 */
	public void ValidateAnArticleInWhereNextMagazine(Map<String, String> inputDatamap) {
		whereNextMagazinePageFeature.openURL(Env.get("WHERENEXTMAGAZINE"));
		whereNextMagazinePageFeature.clickAnArticle();
		reportLogger.assertEquals(whereNextMagazinePageFeature.getArticleTitle(),
				whereNextMagazinePageFeature.expectedArticleTitle(), "Validate an article title is correct. Expected : "
						+ whereNextMagazinePageFeature.expectedArticleTitle());

		reportLogger.assertEquals(whereNextMagazinePageFeature.getArticleHeader(),
				inputDatamap.get(WhereNextMagazineHomePage.ARTICLE_PAGE_HEADER),
				"Validate an article header is correct. Expected : "
						+ inputDatamap.get(WhereNextMagazineHomePage.ARTICLE_PAGE_HEADER));
	}

	/**
	 * Test to validate an Author Bio Page
	 * 
	 * @param inputDatamap
	 */
	public void ValidateAuthorBioPage(Map<String, String> inputDatamap) {
		whereNextMagazinePageFeature.openURL(Env.get("WHERENEXTMAGAZINE"));
		whereNextMagazinePageFeature.clickAnArticle();
		whereNextMagazinePageFeature.clickAuthorBio();		
		reportLogger.assertEquals(whereNextMagazinePageFeature.getAuthorBioName(),
				whereNextMagazinePageFeature.getExpectedAuthorName(),
				"Validate an article title is correct. Expected : "
						+ whereNextMagazinePageFeature.getExpectedAuthorName());
	}

}