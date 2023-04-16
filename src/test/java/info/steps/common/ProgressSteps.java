package info.steps.common;

import info.pom.AbstractPage;
import io.cucumber.java.en.Then;

public class ProgressSteps extends AbstractPage {

	/**
	 * Step to wait for specific period of time
	 */
	@Then("^I wait for (\\d+) sec$")
	public void wait(String time) throws NumberFormatException, InterruptedException {
		progress_Obj.wait(time);
	}

	/**
	 * Step to wait for specific element to display for specific period of time
	 */
	@Then("^I wait (\\d+) seconds for element having (.+) \"(.*?)\" to display$")
	public void wait_for_ele_to_display(String duration, String accessName, String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		progress_Obj.waitForElementToDisplay(accessName, accessValue, duration);
	}

	/**
	 * Step to wait for specific element to enable for specific period of time
	 */
	@Then("^I wait (\\d+) seconds for element having (.+) \"(.*?)\" to be enabled$")
	public void wait_for_ele_to_click(String duration, String accessName, String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		progress_Obj.waitForElementToClick(accessName, accessValue, duration);
	}

}
