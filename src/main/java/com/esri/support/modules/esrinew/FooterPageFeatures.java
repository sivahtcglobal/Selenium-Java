package com.esri.support.modules.esrinew;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.esri.qa.reporting.Log;
import com.esri.qa.ui.PageObjects;
import com.esri.support.modules.core.Constants.EsriCorePage;

/**
 * This class has the methods to interact with the esri footer links on new
 * design
 * 
 * @author thenmozhiS
 *
 */

public class FooterPageFeatures extends PageObjects {

	private FooterPageObjects siteCoreFooterObject;
	private Map<String, String> mapLinks = new HashMap<>();

	public FooterPageFeatures(WebDriver driver) {
		super(driver);
		this.siteCoreFooterObject = new FooterPageObjects(driver);
	}

	/**
	 * This method retrieves the title of the page.
	 */
	public String retrieveTitle() {
		return getTitle();
	}

	/**
	 * Trim all the spaces in the string using regex expression "\\s+" and
	 * return it.
	 *
	 * @param nameOfLink
	 *            actual name of the link.
	 * @return nameOfLink string without any spaces
	 */
	public String replaceSpace(String nameOfLink) {
		return nameOfLink.replaceAll(EsriCorePage.REGEX_EXP, "");
	}

	/**
	 * Returns the size of footer elements
	 * 
	 * @return integer.
	 */
	public List<WebElement> getMenuFooterElements() {
		return siteCoreFooterObject.esriFooterMenuLinks;
	}

	/**
	 * Returns the size of meta footers links
	 * 
	 * @return integer.
	 */
	public List<WebElement> getMetaFooterElements() {
		return siteCoreFooterObject.esriFooterMetaLinks;
	}

	/**
	 * Returns the size of list social links.
	 * 
	 * @return integer.
	 */
	public List<WebElement> getSocialElements() {
		return siteCoreFooterObject.esriSocialLinks;
	}

	/**
	 * Returns the Title of the link mapped with key.
	 * <p>
	 * Fetch the webElement using the index, retrieve its text and then click on
	 * it. retrieve the header and title of next page
	 * 
	 * @param footerLinkElement
	 *            list of webElement
	 * @param footerLinkIndex
	 *            footer link name index
	 * @return Map with the Title of all the links.
	 */
	public Map<String, String> getLinkTitle(List<WebElement> footerLinkElements, int footerLinkIndex, String linkType) {
		String linkLabelName = null;
		mapLinks.clear();
		WebElement element = footerLinkElements.get(footerLinkIndex);
		try {
			scrollIntoViewByElement(siteCoreFooterObject.subscribeButton);
			if (linkType.equals(EsriCorePage.SOCIAL_LINKS)) {
				linkLabelName = replaceSpace(getAttribute(element, "aria-label"));
			} else {
				linkLabelName = replaceSpace(getText(element));
			}
			scrollIntoViewByElement(element); 
			click(element);
			mapLinks.put(linkLabelName + EsriCorePage.LINK_TITLE, retrieveTitle());
		} catch (Exception ex) {
			Log.error(linkLabelName + " link click un-successful. ", ex);
		}
		for (Entry<String, String> entry : mapLinks.entrySet()) {
			Log.info("[ " + entry.getKey() + ": " + entry.getValue() + " ]");
		}
		return mapLinks;
	}

}
