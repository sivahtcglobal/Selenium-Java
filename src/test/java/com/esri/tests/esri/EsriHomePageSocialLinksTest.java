package com.esri.tests.esri;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.ui.BaseTestUi;
import com.esri.support.modules.core.Constants.SiteCoreHomePage;
import com.esri.support.modules.esri.EsriPageFeatures;

/**
 * 
 * Test Class to test Esri.com features within the page *
 * 
 * @author thenmozhiS
 *
 */
public class EsriHomePageSocialLinksTest extends BaseTestUi {

	private Map<String, String> results;
	public EsriPageFeatures esriObject;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EsriHomePageSocialLinksTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Social Links
	 * 
	 * @param inputDatamap
	 */
	@Test(dataProvider = "csv")
	public void ValidateESRISocialLinks(Map<String, String> inputDatamap) {
		boolean facebookTitle = false;
		esriObject = new EsriPageFeatures(driver, inputDatamap);
		esriObject.openUrl();
		List<String> linkNames = esriObject.getSocialLinksNameList(SiteCoreHomePage.SOCIAL_LINKS);
		linkNames.removeAll(Arrays.asList("", null));
		reportLogger.info("Total footer links to validate: " + linkNames.size());

		for (int i = 0; i < linkNames.size(); i++) {
			results = esriObject.getSocialLinkValues(SiteCoreHomePage.SOCIAL_LINKS, i);
			for (String resultKey : results.keySet()) {
				if (inputDatamap.containsKey(resultKey)) {
					if (resultKey.equals(SiteCoreHomePage.FACEBOOK_TITLE)
							|| resultKey.equals(SiteCoreHomePage.LINKEDN_TITLE)) {
						String actualTitle = results.get(resultKey);
						if (actualTitle.contains(SiteCoreHomePage.LINKEDN_TITLE_TEXT)
								|| actualTitle.equals(SiteCoreHomePage.FACEBOOK_TITLE_TEXT)
								|| actualTitle.equals(inputDatamap.get(resultKey))) {
							facebookTitle = true;
						}
						reportLogger.assertTrue(facebookTitle,
								"Validate the " + resultKey + " of " + SiteCoreHomePage.SOCIAL_LINKS + " is correct.");
					} else {
						reportLogger.assertEquals(results.get(resultKey), inputDatamap.get(resultKey),
								"Validate the " + resultKey + " of " + SiteCoreHomePage.SOCIAL_LINKS + " is correct.");
					}
				} else {
					reportLogger.error("Social link Key doesn't exist in input data sheet - " + resultKey);
				}
			}
		}
		closeTest();
	}

}
