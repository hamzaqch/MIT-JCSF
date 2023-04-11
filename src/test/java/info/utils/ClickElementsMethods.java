package info.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import info.config.*;

import info.pom.AbstractPage;

public class ClickElementsMethods extends AbstractPage {

	private final SelectElementByType selectElementByType = new SelectElementByType();
	
	private WebElement element = null;
	
	public void click(String accessType, String accessName) {
		element = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessName)));
		element.click();
	}
	
	public void clickForcefully(String accessType, String accessName) {
        element = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessName)));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }
	
	public void doubleClick(String accessType, String accessValue) {
        element = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)));

        Actions action = new Actions(getDriver());
        action.moveToElement(element).doubleClick().perform();
    }
}
