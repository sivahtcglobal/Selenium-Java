package com.esri.tests.esrinew;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.config.Env;
import com.esri.qa.reporting.Log;
import com.esri.qa.ui.BaseTestUi;
import com.esri.qa.ui.FeatureAutomationException;
import com.esri.support.modules.core.Constants.EsriCorePage;
import com.esri.support.modules.core.Constants.SiteCoreHomePage;
import com.esri.support.modules.esrinew.FooterPageFeatures;

/**
 * Test Class to test Social links on esri.com
 * 
 * @author Deenesh
 *
 */
public class SocialLinksTest extends BaseTestUi {

	private FooterPageFeatures siteCoreFootersPageFeature;
	private Map<String, String> results;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public SocialLinksTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Social Links
	 * 
	 * @param inputDatamap
	 */
	@Test(dataProvider = "csv", groups = { "Where-Next-Magazine", "Regressions" }, enabled = true, priority = 5)
	public void ValidateEsriSocialLinks(Map<String, String> inputDatamap) {
		boolean facebookTitle = false;
		siteCoreFootersPageFeature = new FooterPageFeatures(driver);
		siteCoreFootersPageFeature.openURL(Env.get("WHERENEXTMAGAZINE"));
		int listCount = siteCoreFootersPageFeature.getSocialElements().size();
		reportLogger.info("Total social links to validate: " + listCount);

		// throw exception if the link list is empty
		if (listCount == 0) {
			throw new FeatureAutomationException("Social link list size is not correct");
		}

		for (int i = 0; i < listCount; i++) {
			if (i > 0) {
				siteCoreFootersPageFeature.openURL(Env.get("WHERENEXTMAGAZINE"));
			}
			results = siteCoreFootersPageFeature.getLinkTitle(siteCoreFootersPageFeature.getSocialElements(), i,
					EsriCorePage.SOCIAL_LINKS);
			for (String resultKey : results.keySet()) {
				if (inputDatamap.containsKey(resultKey)) {
					if (resultKey.equals(SiteCoreHomePage.FACEBOOK_TITLE)) {
						String actualFacebookTitle = results.get(resultKey);
						if (actualFacebookTitle.equals(inputDatamap.get(resultKey))
								|| actualFacebookTitle.equals(SiteCoreHomePage.FACEBOOK_TITLE_TEXT)) {
							Log.info("FB: " + actualFacebookTitle);
							facebookTitle = true;
						}
						reportLogger.assertTrue(facebookTitle, "Validate the " + resultKey + " of "
								+ SiteCoreHomePage.SOCIAL_LINKS + " is correct. Actual: " + results.get(resultKey));
					} else
						reportLogger.assertEquals(results.get(resultKey), inputDatamap.get(resultKey),
								"Validate the " + resultKey + " of " + EsriCorePage.SOCIAL_LINKS
										+ " is correct. Actual: " + results.get(resultKey));
				} else {
					reportLogger.error("Footer Key doesn't exist in input data sheet - " + resultKey);
				}
			}
		}
		closeTest();
	}

}
