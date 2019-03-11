package com.esri.tests.training.catalog;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.ui.BaseTestUi;
import com.esri.sm.training.catalog.CatalogPageFeatures;
import com.esri.sm.training.catalog.LearningPlansPageFeatures;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;

/**
 * This test class to validate Catalog sub menu Learning Plans Page
 * 
 * @author Rizwan
 *
 */

public class LearningPlansPageTest extends BaseTestUi {

	private LearningPlansPageFeatures learningPlansPageFeatures;
	private CatalogPageFeatures catalogPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public LearningPlansPageTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate Catalog Sub Menu Learning Plans page
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "Plans", "Regressions" }, priority = 1)
	public void ValidateCatalogSubMenuLearningPlansPage(Map<String, String> inputDataMap) {
		catalogPageFeatures = new CatalogPageFeatures(driver, inputDataMap);
		learningPlansPageFeatures = new LearningPlansPageFeatures(driver, inputDataMap);
		reportLogger.assertEquals(catalogPageFeatures.getTitle(), inputDataMap.get(CatalogPage.HOME_PAGE_TITLE),
				"Validate if the Training Home Page title is correct.");
		reportLogger.assertEquals(catalogPageFeatures.retrieveTrainingLabel(),
				inputDataMap.get(CatalogPage.HOME_PAGE_HEADER_LABEL),
				"Validate if the Training Home Page header label is correct.");
		learningPlansPageFeatures.clickOnLearningPlansSubMenu();
		reportLogger.assertEquals(learningPlansPageFeatures.getPageTitle(),
				inputDataMap.get(CatalogPage.LEARNING_HOME_PAGE_TITLE),
				"Validate if the Catalog Sub Menu Learning Plans Page title is correct.");
		reportLogger.assertTrue(learningPlansPageFeatures.isLearningPlansAvailable(),
				"Validate if the Catalog Sub Menu Learning Plans are available.");
		closeTest();
	}

}
