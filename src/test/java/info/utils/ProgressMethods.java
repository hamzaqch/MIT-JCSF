package info.utils;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import info.config.Base;
import info.pom.AbstractPage;

public class ProgressMethods extends AbstractPage implements Base {
	
	/**
	 * Method to Explicitly wait for element to be displayed
	 * 
	 * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     * @param duration   : String : Time to wait for element to be displayed
	 */
	public void waitForElementToDisplay(String accessType, String accessName, String duration) {
		By byElement = selectElementByType.getElementByType(accessType, accessName);
		WebDriverWait wait = (new WebDriverWait(getDriver(), Duration.ofMillis(Integer.parseInt(duration))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
	}
	
	/**
     * Method to Explicitly wait for element to be enabled=click
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     * @param duration   : String : Time to wait for element to be clickable
     */
	public void waitForElementToClick(String accessType, String accessName, String duration) {
		By byElement = selectElementByType.getElementByType(accessType, accessName);
		WebDriverWait wait = (new WebDriverWait(getDriver(), Duration.ofMillis(Integer.parseInt(duration))));
		wait.until(ExpectedConditions.elementToBeClickable(byElement));
	}
	
	
}
