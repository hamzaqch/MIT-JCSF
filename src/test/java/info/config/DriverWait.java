package info.config;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import info.utils.expectedConditions.*;


public class DriverWait {
	
	private final DriverManager driverManager;
	
	public DriverWait(DriverManager driverManager) {
		this.driverManager = driverManager;
	}
	
	/**
	 * Method to wait for WebElement to load by WebElement
	 * 
	 * @param element : WebElement
	 * @throws NoSuchFieldException
	 */
	public void waitForElementToLoad(WebElement element) throws NoSuchFieldException {
		waitForElementVisible(element);
		waitForElementClickable(element);
	}
	
	/**
	 * Method to wait for WebElement to load by Locator
	 * 
	 * @param accessType : By : Locator type (id, name, class, xpath, css)
	 * @throws NoSuchFieldException
	 */
	public void waitForElementToLoad(By accessType) throws NoSuchFieldException {
		waitForElementVisibleByLocator(accessType);
		waitForElementClickableByLocator(accessType);
	}

	public Wait<WebDriver> waitLong() {
        return new FluentWait<>(driverManager.getDriver())
                .withTimeout(Duration.ofSeconds(Constants.pollingShort))
                .pollingEvery(Duration.ofMillis(Constants.pollingLong))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }
	
	public Wait<WebDriver> waitShort() {
        return new FluentWait<>(driverManager.getDriver())
                .withTimeout(Duration.ofSeconds(Constants.timeoutShort))
                .pollingEvery(Duration.ofMillis(Constants.pollingShort))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }
	
	/**
	 * Wait for element visible WebElement
	 * 
	 * @param element : WebElement
	 */
	private void waitForElementVisible(WebElement element) {
		try {
			waitLong().until(new VisibilityOfElement(element));
		}
		catch (Exception ignored) {}
	}
	
	/**
	 * Wait for element visible by locator
	 * 
	 * @param accessType : By : Locator type (id, name, class, xpath, css)
	 */
	private void waitForElementVisibleByLocator(By accessType) {
		try {
			waitLong().until(new VisibilityOfElementByLocator(accessType));
		}
		catch (Exception ignored) {}
	}
	
	/**
	 * Wait for element Invisible WebElement
	 * 
	 * @param element : WebElement
	 */
	private void waitForElementInVisible(WebElement element) {
        try {
            new InvisibilityOfElement(element);
        } catch (Exception ignored) {
        }
    }
	
	/**
	 * Wait for element Invisible by locator
	 * 
	 * @param accessType : By : Locator type (id, name, class, xpath, css)
	 */
	private void waitForElementInVisibleBylocator(By accessType) {
        try {
            new InvisibilityOfElementByLocator(accessType);
        } catch (Exception ignored) {
        }
    }
	
	/**
	 * Wait for element clickable by WebElement
	 * 
	 * @param element
	 * @throws NoSuchFieldException
	 */
	private void waitForElementClickable(WebElement element) throws NoSuchFieldException {
        try {
            new ClickabilityOfElement(element);
        } catch (Exception ignored) {
            throw new NoSuchFieldException("could not interact with the element " + element);
        }
    }
	
	/**
	 * Wait for element clickable by locator
	 * 
	 * @param accessType : By : Locator type (id, name, class, xpath, css)
	 * @throws NoSuchFieldException
	 */
	private void waitForElementClickableByLocator(By accessType) throws NoSuchFieldException {
        try {
            new ClickabilityOfElementByLocator(accessType);
        } catch (Exception ignored) {
            throw new NoSuchFieldException("could not interact with the element by locator " + accessType);
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
