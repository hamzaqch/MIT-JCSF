package info.steps.common;

import info.pom.AbstractPage;
import io.cucumber.java.en.Then;

public class ConfigurationSteps extends AbstractPage {

	/**
	 * Step to print configuration
	 */
	@Then("^I print configuration$")
	public void print_config() {
		config_Obj.printDesktopConfiguration();
	}

}
