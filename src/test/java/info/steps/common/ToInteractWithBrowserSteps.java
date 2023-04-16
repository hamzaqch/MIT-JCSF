package info.steps.common;

import info.pom.AbstractPage;
import io.cucumber.java.en.Then;

public class ToInteractWithBrowserSteps extends AbstractPage {

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
	
}
