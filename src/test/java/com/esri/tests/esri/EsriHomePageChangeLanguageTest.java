package com.esri.tests.esri;

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
public class EsriHomePageChangeLanguageTest extends BaseTestUi {

	public EsriPageFeatures esriObject;

	@Parameters({ "fileName", "startRow", "endRow", "bType", "bVersion", "platform", "url", "dimension" })
	public EsriHomePageChangeLanguageTest(@Optional String fileName, @Optional String startRow, @Optional String endRow,
			@Optional String bType, @Optional String bVersion, @Optional String platform, @Optional String url,
			@Optional String dimension) {
		super(fileName, startRow, endRow, bType, bVersion, platform, url, dimension);
	}

	/**
	 * Test to validate the Language DropDown functionality
	 * 
	 * @param inputDatamap
	 */
	@Test(dataProvider = "csv")
	public void ValidateESRILanguageDropDown(Map<String, String> inputDatamap) {
		esriObject = new EsriPageFeatures(driver, inputDatamap);
		esriObject.openUrl();
		String deutschHeader = esriObject.getDeutschHeader();
		reportLogger.assertEquals(deutschHeader, inputDatamap.get(SiteCoreHomePage.DEUTSCH_HEADER),
				"Validate that Deutsch header is correct.");
		closeTest();
	}

}
