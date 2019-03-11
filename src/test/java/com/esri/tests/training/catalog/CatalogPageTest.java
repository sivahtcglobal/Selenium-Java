package com.esri.tests.training.catalog;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.ui.BaseTestUi;
import com.esri.sm.training.catalog.CatalogPageFeatures;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;

/**
 * This test class to validate the Training Site Catalog Page
 * 
 * @author Rizwan
 *
 */

public class CatalogPageTest extends BaseTestUi {

	private CatalogPageFeatures catalogPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public CatalogPageTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate catalog Page
	 * 
	 * @param inputDataMap
	 * @throws InterruptedException 
	 * 
	 */
	@Test(dataProvider = "csv", groups = { "Catalog", "Regressions" }, priority = 2)
	public void ValidateCatalogPage(Map<String, String> inputDataMap) throws InterruptedException {
		catalogPageFeatures = new CatalogPageFeatures(driver, inputDataMap);
		catalogPageFeatures.clickOnCatalogButton();
		reportLogger.assertEquals(catalogPageFeatures.getTitle(), inputDataMap.get(CatalogPage.CATALOG_PAGE_TITLE),
				"Validate if the Catalog Page Title is correct.");
		reportLogger.assertEquals(catalogPageFeatures.retrieveFindTrainingLabel(),
				inputDataMap.get(CatalogPage.CATALOG_PAGE_HEADER_LABEL),
				"Validate if the Catalog Page header label is correct.");
		
		ValidateCatalogPageSearchFunctinality(inputDataMap);
		Validate3DAnalysisOfSurfacesandFeaturesUsingArcGISCoursePage(inputDataMap);
		ValidateSignIn(inputDataMap);
		ValidateAddAndRemoveCourseToWishList(inputDataMap);
		ValidateSoftwareAndSkillsetsButton(inputDataMap);
		ValidateSignOut(inputDataMap);
		
		closeTest();
	}

	/**
	 * Test to validate Catalog Page Search
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateCatalogPageSearchFunctinality(Map<String, String> inputDataMap) {
		catalogPageFeatures.search();
		reportLogger.assertTrue(catalogPageFeatures.isSearchResultsAvailable(),
				"Validate if the Search results are available");
	}

	/**
	 * Test to validate 3D Analysis of Surfaces and Features Using ArcGIS course
	 * page
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void Validate3DAnalysisOfSurfacesandFeaturesUsingArcGISCoursePage(Map<String, String> inputDataMap) {
		catalogPageFeatures.clickOnAnalysisOfSurfaces();
		reportLogger.assertEquals(catalogPageFeatures.getTitle(),
				inputDataMap.get(CatalogPage.ANALYSIS_OF_SURFACES_PAGE_TITLE),
				"Validate if the 3D Analysis of Surfaces and Features Using ArcGIS Page Title is correct.");
		reportLogger.assertEquals(catalogPageFeatures.retrieveAnalysisOfSurfacesArcGISLabel(),
				inputDataMap.get(CatalogPage.ANALYSIS_OF_SURFACES_PAGE_HEADER),
				"Validate if the 3D Analysis of Surfaces and Features Using ArcGIS Page header label is correct.");
	}

	/**
	 * Sign in
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateSignIn(Map<String, String> inputDataMap) {
		catalogPageFeatures.SignIn();
		reportLogger.assertEquals(catalogPageFeatures.retrieveAnalysisOfSurfacesArcGISLabel(),
				inputDataMap.get(CatalogPage.ANALYSIS_OF_SURFACES_PAGE_HEADER),
				"After login validate if the 3D Analysis of Surfaces and Features Using ArcGIS Page header label is correct.");
	}

	/**
	 * Add and remove from wish list
	 * 
	 * @param inputDataMap
	 * @throws InterruptedException 
	 * 
	 */
	public void ValidateAddAndRemoveCourseToWishList(Map<String, String> inputDataMap) throws InterruptedException {
		reportLogger.assertEquals(catalogPageFeatures.retrieveAddedToWishListLabel(),
				inputDataMap.get(CatalogPage.ADD_TO_WISH_LIST_TEXT),
				"Validate if the Item is Added to the Wish List is correct.");
		reportLogger.assertEquals(catalogPageFeatures.clickOnRemoveWishFromList(),
				inputDataMap.get(CatalogPage.REMOVE_FROM_WISH_LIST_TEXT),
				"Validate if the Item is Removed from the Wish List is correct.");
	}

	/**
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateSoftwareAndSkillsetsButton(Map<String, String> inputDataMap) {
		catalogPageFeatures.clickOnSoftwareButton();
		reportLogger.assertEquals(catalogPageFeatures.retrieveArcGISAnalystLabel(),
				inputDataMap.get(CatalogPage.ARCGIS_3D_ANALYST),
				"Validate if the Software ArcGIS 3D Analyst content label is correct.");
		catalogPageFeatures.clickOnSuggestedSkillsButton();
		reportLogger.assertEquals(catalogPageFeatures.retrieveEssentialWorkflowsLabel(),
				inputDataMap.get(CatalogPage.ESSENTIAL_WORKFLOWS),
				"Validate if the Suggested Skills content label is correct.");
		catalogPageFeatures.clickOnHowToAccessButton();
		reportLogger.assertEquals(catalogPageFeatures.getTitle(), inputDataMap.get(CatalogPage.E_LEARNING_PAGE_TITLE),
				"Validate if the E-Learning Page Title is correct.");
		reportLogger.assertEquals(catalogPageFeatures.retrieveGetStartedWithELearningLabel(),
				inputDataMap.get(CatalogPage.E_LEARNING_PAGE_HEADER),
				"Validate if the E-Learning Page header label is correct.");
	}

	/**
	 * Test to validate SignOut
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateSignOut(Map<String, String> inputDataMap) {
		catalogPageFeatures.clickOnSignOutLink();
		reportLogger.assertEquals(catalogPageFeatures.retrievePageTitle(),
				inputDataMap.get(CatalogPage.ANALYSIS_OF_SURFACES_PAGE_TITLE),
				"Validate if the E-Learning Page Title is correct.");
	}

}
