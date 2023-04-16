package info.steps.common;

import info.pom.AbstractPage;
import io.cucumber.java.en.Then;

public class SwitchBetweenFramesSteps extends AbstractPage {

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

}
