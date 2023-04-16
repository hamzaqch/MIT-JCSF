package info.steps.common;

import info.pom.AbstractPage;
import io.cucumber.java.en.Then;

public class SwitchBetweenWindowsSteps extends AbstractPage {

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
	
}
