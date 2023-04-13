package info.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import info.config.Base;
import info.pom.AbstractPage;

public class NavigateMethods extends AbstractPage implements Base {

	private WebElement element = null;
	private String old_win = null;
	private String lastWinHandle;

	/**
	 * Method to open link
	 *
	 * @param url : String : URL for navigation
	 */
	public void navigateTo(String url) {
		getDriver().get(url);
	}

	/**
	 * Method to navigate back & forward
	 *
	 * @param direction : String : Navigate to forward or backward
	 */
	public void navigate(String direction) {
		if (direction.equals("back"))
			getDriver().navigate().back();
		else
			getDriver().navigate().forward();
	}

	/**
	 * Method to resize browser
	 *
	 * @param width  : int : Width for browser resize
	 * @param height : int : Height for browser resize
	 */
	public void resizeBrowser(int width, int height) {
		getDriver().manage().window().setSize(new Dimension(width, height));
	}

	/**
	 * Method to maximize browser
	 */
	public void maximizeBrowser() {
		getDriver().manage().window().maximize();
	}

	/**
	 * Method to close new window
	 */
	public void closeNewWindow() {
		getDriver().close();
	}

	/**
	 * Method to switch to new window
	 */
	public void switchToNewWindow() {
		old_win = getDriver().getWindowHandle();
		for (String winHandle : getDriver().getWindowHandles())
			lastWinHandle = winHandle;
		getDriver().switchTo().window(lastWinHandle);
	}

	/**
	 * Method to switch to old window
	 */
	public void switchToOldWindow() {
		getDriver().switchTo().window(old_win);
	}

	/**
	 * Method to switch to window by title
	 *
	 * @param windowTitle : String : Name of window title to switch
	 */
	public void switchToWindowByTitle(String windowTitle) throws Exception {
		old_win = getDriver().getWindowHandle();
		boolean winFound = false;
		for (String winHandle : getDriver().getWindowHandles()) {
			String str = getDriver().switchTo().window(winHandle).getTitle();
			if (str.equals(windowTitle)) {
				winFound = true;
				break;
			}
		}
		if (!winFound)
			throw new Exception("Window having title " + windowTitle + " not found");
	}

	/**
	 * Method to switch to default content
	 */
	public void switchToDefaultContent() {
		getDriver().switchTo().defaultContent();
	}

	/**
	 * Method to switch frame using web element frame
	 *
	 * @param accessType : String : Locator type (index, id, name, class, xpath, css)
	 * @param accessName : String : Locator value
	 */
	public void switchFrame(String accessType, String accessName) {
		if (accessType.equalsIgnoreCase("index"))
			getDriver().switchTo().frame(accessName);
		else {
			element = getDriverWait().waitShort().until(ExpectedConditions
					.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessName)));
			getDriver().switchTo().frame(element);
		}
	}

}
