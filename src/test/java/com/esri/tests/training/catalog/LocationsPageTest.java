package com.esri.tests.training.catalog;

import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.esri.qa.ui.BaseTestUi;
import com.esri.sm.training.catalog.LocationsPageFeatures;
import com.esri.support.modules.core.TrainingConstants.CatalogPage;

/**
 * This test class to validate Catalog sub menu Locations Page
 * 
 * @author Rizwan
 *
 */

public class LocationsPageTest extends BaseTestUi {

	private LocationsPageFeatures locationsPageFeatures;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public LocationsPageTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate Catalog Sub Menu Locations page
	 * 
	 * @param inputDataMap
	 */
	@Test(dataProvider = "csv", groups = { "Locations", "Regressions" }, priority = 1)
	public void ValidateCatalogSubMenuLocationsPage(Map<String, String> inputDataMap) {
		locationsPageFeatures = new LocationsPageFeatures(driver, inputDataMap);
		reportLogger.assertEquals(locationsPageFeatures.getTitle(), inputDataMap.get(CatalogPage.HOME_PAGE_TITLE),
				"Validate if the Training Home Page title is correct.");
		locationsPageFeatures.clickOnLocationsSubMenu();
		reportLogger.assertEquals(locationsPageFeatures.getTitle(), inputDataMap.get(CatalogPage.LOCATIONS_PAGE_TITLE),
				"Validate if the Catalog Sub Menu Locations Page title is correct.");
		
		ValidateCatalogSubMenuLocationsBroomfieldCard(inputDataMap);
		
		closeTest();
	}

	/**
	 * Test to validate Catalog Sub Menu Locations Page BroomfieldCard and
	 * Filters
	 * 
	 * @param inputDataMap
	 * 
	 */
	public void ValidateCatalogSubMenuLocationsBroomfieldCard(Map<String, String> inputDataMap) {
		locationsPageFeatures.clickOnBroomfieldCard();
		reportLogger.assertTrue(locationsPageFeatures.isSearchResultsAvailable(),
				"Validate if the class are available");
		locationsPageFeatures.selectDateRange();
		reportLogger.assertTrue(locationsPageFeatures.isSearchResultsAvailable(),
				"Validate if the Date Range Filter results are correct.");
		reportLogger.assertTrue(locationsPageFeatures.isMapAvailable(),
				"Validate if the Driving Directions Map is available");
	}

}
