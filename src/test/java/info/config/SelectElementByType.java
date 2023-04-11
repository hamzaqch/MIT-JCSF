package info.config;

import org.openqa.selenium.By;

public class SelectElementByType {

	/**
	 * Method to get the Element
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css) 
	 * @param accessValue : String : Locator value
	 * @return WebElement
	 */
	public By getElementByType(String accessType, String accessValue) {
		switch (accessType) {
		case "id":
            return By.id(accessValue);
        case "name":
            return By.name(accessValue);
        case "class":
            return By.className(accessValue);
        case "xpath":
            return By.xpath(accessValue);
        case "css":
            return By.cssSelector(accessValue);
        case "linkText":
            return By.linkText(accessValue);
        case "partialLinkText":
            return By.partialLinkText(accessValue);
        case "tagName":
            return By.tagName(accessValue);
        default:
            return null;
		}
	}
	
}
