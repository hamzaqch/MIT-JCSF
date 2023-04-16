package info.steps.common;

import info.pom.AbstractPage;
import io.cucumber.java.en.Then;

public class NavigationSteps extends AbstractPage {

	/**
	 * Step to navigate to specified URL
	 * 
	 * @param link : String : url
	 */
	@Then("^I navigate to \"([^\"]*)\"$")
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

}
