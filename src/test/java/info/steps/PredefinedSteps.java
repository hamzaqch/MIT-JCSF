package info.steps;

import info.config.TestCaseFailed;
import info.pom.AbstractPage;
import io.cucumber.java.en.Then;

public class PredefinedSteps extends AbstractPage {

	// Navigation Steps //

	/**
	 * Step to navigate to specified URL
	 * 
	 * @param link : String : url
	 */
	@Then("I navigate to {string}")
	public void navigate_to(String link) {
		navigate_Obj.navigateTo(link);
	}

	/**
	 * Step to navigate forward
	 */
	@Then("^I navigate forward$")
	public void navigate_forward() {
		navigate_Obj.navigate("forward");
	}

	/**
	 * Step to navigate back
	 */
	@Then("^I navigate back$")
	public void navigate_back() {
		navigate_Obj.navigate("back");
	}

	/**
	 * steps to refresh page
	 */
	@Then("^I refresh page$")
	public void refresh_page() {
		getDriver().navigate().refresh();
	}

	// Switch between windows //

	/**
	 * Step to Close new window
	 */
	@Then("^I close new window$")
	public void close_new_window() {
		navigate_Obj.closeNewWindow();
	}

	/**
	 * Step to Switch to new window
	 */
	@Then("^I switch to new window$")
	public void switch_to_new_window() {
		navigate_Obj.switchToNewWindow();
	}

	/**
	 * Step to Switch to old window
	 */
	@Then("^I switch to previous window$")
	public void switch_to_old_window() {
		navigate_Obj.switchToOldWindow();
	}

	/**
	 * Step to Switch to new window by window title
	 * 
	 * @param windowTitle : String : window title
	 */
	@Then("^I switch to window having title \"(.*?)\"$")
	public void switch_to_window_by_title(String windowTitle) throws Exception {
		navigate_Obj.switchToWindowByTitle(windowTitle);
	}

	// Switch between frame //

	/**
	 * Step to switch to frame by web element
	 * 
	 * @param accessType  : String : Locator type (index, id, name, class, xpath,
	 *                    css)
	 * @param accessValue : String : Locator value
	 */
	@Then("^I switch to frame having (.+) \"(.*?)\"$")
	public void switch_frame_by_element(String accessType, String accessValue) {
		navigate_Obj.switchFrame(accessType, accessValue);
	}

	/**
	 * step to switch to main content
	 */
	@Then("^I switch to main content$")
	public void switch_to_default_content() {
		navigate_Obj.switchToDefaultContent();
	}

	// To interact with browser //

	/**
	 * step to resize browser
	 * 
	 * @param width  : int : Width for browser resize
	 * @param height : int : Height for browser resize
	 */
	@Then("^I resize browser window size to width (\\d+) and height (\\d+)$")
	public void resize_browser(int width, int heigth) {
		navigate_Obj.resizeBrowser(width, heigth);
	}

	/**
	 * step to maximize browser
	 */
	@Then("^I maximize browser window$")
	public void maximize_browser() {
		navigate_Obj.maximizeBrowser();
	}

	// Assertion steps //
	
	public void check_title(String present, String title) throws TestCaseFailed {
		assertion_Obj.checkTitle(title, present.isEmpty());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
