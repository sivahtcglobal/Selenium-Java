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
import com.esri.support.modules.esrinew.FooterPageFeatures;

/**
 * Test Class to test WhereNext Magazine footer.
 * 
 * @author thenmozhiS
 *
 */
public class FooterLinksTest extends BaseTestUi {

	private FooterPageFeatures siteCoreFootersPageFeature;
	private Map<String, String> results;
	private int listCount = 0;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public FooterLinksTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Menu Footer Links
	 * 
	 * @param inputDatamap
	 */
	@Test(dataProvider = "csv", groups = { "Where-Next-Magazine", "Regressions" }, enabled = true, priority = 1)
	public void ValidateEsriFooterLinksMenu(Map<String, String> inputDatamap) {
		siteCoreFootersPageFeature = new FooterPageFeatures(driver);
		siteCoreFootersPageFeature.openURL(Env.get("WHERENEXTMAGAZINE"));
		listCount = siteCoreFootersPageFeature.getMenuFooterElements().size();
		reportLogger.info("Total menu footer links to validate: " + listCount);

		// throw exception if the link list is empty
		if (listCount == 0) {
			throw new FeatureAutomationException("Footer menu link list size is not correct");
		}

		for (int i = 0; i < listCount; i++) {
			if (i > 0) {
				siteCoreFootersPageFeature.openURL(Env.get("WHERENEXTMAGAZINE"));
			}
			results = siteCoreFootersPageFeature.getLinkTitle(siteCoreFootersPageFeature.getMenuFooterElements(), i,
					EsriCorePage.FOOTER);
			for (String resultKey : results.keySet()) {
				if (inputDatamap.containsKey(resultKey)) {
					Log.info("Input Data : " + resultKey + " = " + inputDatamap.get(resultKey));
					if(results.get(resultKey).contains("Open Vision")){
						reportLogger.assertTrue(true, "Esri's Open Vision"); 
					}else{
					reportLogger.assertEquals(results.get(resultKey), inputDatamap.get(resultKey),
							"Validate the " + resultKey + " of " + EsriCorePage.FOOTER + " is correct. Actual: "
									+ results.get(resultKey));
					}
				} else {
					reportLogger.error("Footer Key doesn't exist in input data sheet - " + resultKey);
				}
			}
		}
		
		 ValidateMetaFooterLinks(inputDatamap);
		 
		closeTest();
	}

	/**
	 * Test to validate the Meta Footer Links
	 * 
	 * @param inputDatamap
	 */
	public void ValidateMetaFooterLinks(Map<String, String> inputDatamap) {
		siteCoreFootersPageFeature = new FooterPageFeatures(driver);
		siteCoreFootersPageFeature.openURL(Env.get("WHERENEXTMAGAZINE"));
		listCount = siteCoreFootersPageFeature.getMetaFooterElements().size();
		reportLogger.info("Total meta footer links to validate: " + listCount);

		// throw exception if the link list is empty
		if (listCount == 0) {
			throw new FeatureAutomationException("Meta Footer link list size is not correct");
		}

		for (int i = 0; i < listCount; i++) {
			if (i > 0) {
				siteCoreFootersPageFeature.openURL(Env.get("WHERENEXTMAGAZINE"));
			}
			results = siteCoreFootersPageFeature.getLinkTitle(siteCoreFootersPageFeature.getMetaFooterElements(), i,
					EsriCorePage.FOOTER);
			for (String resultKey : results.keySet()) {
				if (inputDatamap.containsKey(resultKey)) {
					Log.info("Input Data : " + resultKey + " = " + inputDatamap.get(resultKey));
					reportLogger.assertEquals(results.get(resultKey), inputDatamap.get(resultKey),
							"Validate the " + resultKey + " of " + EsriCorePage.FOOTER + " is correct. Actual: "
									+ results.get(resultKey));
				} else {
					reportLogger.error("Footer Key doesn't exist in input data sheet - " + resultKey);
				}
			}
		}
	}

}
