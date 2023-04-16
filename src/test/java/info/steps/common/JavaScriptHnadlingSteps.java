package info.steps.common;

import info.pom.AbstractPage;
import io.cucumber.java.en.Then;

public class JavaScriptHnadlingSteps extends AbstractPage {

	/**
	 * Step to handle java script
	 */
	@Then("^I accept alert$")
	public void handle_alert() {
		javaScriptHandling_Obj.handleAlert("accept");
	}

	/**
	 * Steps to dismiss java script
	 */
	@Then("^I dismiss alert$")
	public void dismiss_alert() {
		javaScriptHandling_Obj.handleAlert("dismiss");
	}
}
