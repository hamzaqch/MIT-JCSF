package info.steps.common;

import info.pom.AbstractPage;
import io.cucumber.java.en.Then;

public class ClickElementSteps extends AbstractPage {

	/**
	 * Step to click on web element
	 */
	@Then("^I click on element having (.+) \"(.*?)\"$")
	public void click(String accessName, String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		click_Obj.click(accessName, accessValue);
	}

	/**
	 * Step to Forcefully click on element
	 */
	@Then("^I forcefully click on element having (.+) \"(.*?)\"$")
	public void click_forcefully(String accessName, String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		click_Obj.clickForcefully(accessName, accessValue);
	}

	/**
	 * Step to double click on web element
	 */
	@Then("^I double click on element having (.+) \"(.*?)\"$")
	public void double_click(String accessName, String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		click_Obj.doubleClick(accessName, accessValue);
	}

	/**
	 * Steps to click on link
	 */
	@Then("^I click on link having text \"(.*?)\"$")
	public void click_link(String accessValue) {
		click_Obj.click("linkText", accessValue);
	}

	/**
	 * Step to click on partial link
	 */
	@Then("^I click on link having partial text \"(.*?)\"$")
	public void click_partial_link(String accessValue) {
		click_Obj.click("partialLinkText", accessValue);
	}
}
