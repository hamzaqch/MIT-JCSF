package info.steps.common;

import java.io.IOException;

import info.pom.AbstractPage;
import io.cucumber.java.en.Then;

public class ScreenShotSteps extends AbstractPage {

	 @Then("^I take screenshot$")
	    public void take_screenshot() throws IOException {
		 screenShot_Obj.takeScreenShot();
	    }
	
}
