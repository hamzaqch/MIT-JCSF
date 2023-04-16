package info.steps.common;

import info.config.TestCaseFailed;
import info.pom.AbstractPage;
import io.cucumber.java.en.Then;

public class AssertionSteps extends AbstractPage {

	/**
	 * Step for page title checking
	 */
	@Then("^I should\\s*((?:not)?)\\s+see page title as \"(.+)\"$")
	public void check_title(String present, String title) throws TestCaseFailed {
		assertion_Obj.checkTitle(title, present.isEmpty());
	}

	/**
	 * Step to check element partial text
	 */
	@Then("^I should\\s*((?:not)?)\\s+see page title having partial text as \"(.*?)\"$")
	public void check_partial_text(String present, String partialTextTitle) throws TestCaseFailed {
		// System.out.println("Present :" + present.isEmpty());
		assertion_Obj.checkPartialTitle(partialTextTitle, present.isEmpty());
	}

	/**
	 * Step to check element text
	 */
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have text as \"(.*?)\"$")
	public void check_element_text(String accessName, String accessValue, String present, String expectedText)
			throws Exception {
		misc_Obj.validateLocator(accessName);
		assertion_Obj.checkElementText(accessName, accessValue, expectedText, present.isEmpty());
	}

	/**
	 * Step to check element partial text
	 */
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have partial text as \"(.*?)\"$")
	public void check_element_partial_text(String accessName, String accessValue, String present, String expectedText)
			throws Exception {
		misc_Obj.validateLocator(accessName);
		assertion_Obj.checkElementPartialText(accessName, accessValue, expectedText, present.isEmpty());
	}

	/**
	 * Step to check attribute value
	 */
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have attribute \"(.*?)\" with value \"(.*?)\"$")
	public void check_element_attribute(String accessName, String accessValue, String present, String attrbName,
			String attrValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		assertion_Obj.checkElementAttribute(accessName, accessValue, attrbName, attrValue, present.isEmpty());
	}

	/**
	 * Step to check element enabled or not
	 */
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+be (enabled|disabled)$")
	public void check_element_enable(String accessName, String accessValue, String present, String elementState)
			throws Exception {
		misc_Obj.validateLocator(accessName);
		boolean flag = elementState.equals("enabled");
		if (!present.isEmpty()) {
			flag = !flag;
		}
		assertion_Obj.checkElementEnable(accessName, accessValue, flag);
	}

	/**
	 * Step to check element present or not
	 */
	@Then("^element having (.+) \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
	public void check_element_presence(String accessName, String accessValue, String present) throws Exception {
		misc_Obj.validateLocator(accessName);
		assertion_Obj.checkElementPresence(accessName, accessValue, present.isEmpty());
	}

	/**
	 * Step to assert checkbox is checked or unchecked
	 */
	@Then("^checkbox having (.+) \"(.*?)\" should be (checked|unchecked)$")
	public void is_checkbox_checked(String accessName, String accessValue, String elementState) throws Exception {
		misc_Obj.validateLocator(accessName);
		boolean flag = elementState.equals("checked");
		assertion_Obj.isCheckboxChecked(accessName, accessValue, flag);
	}

	/**
	 * Steps to assert radio button checked or unchecked
	 */
	@Then("^radio button having (.+) \"(.*?)\" should be (selected|unselected)$")
	public void is_radio_button_selected(String accessName, String accessValue, String elementState) throws Exception {
		misc_Obj.validateLocator(accessName);
		boolean flag = elementState.equals("selected");
		assertion_Obj.isRadioButtonSelected(accessName, accessValue, flag);
	}

	/**
	 * Steps to assert option by text from radio button group selected/unselected
	 */
	@Then("^option \"(.*?)\" by (.+) from radio button group having (.+) \"(.*?)\" should be (selected|unselected)$")
	public void is_option_from_radio_button_group_selected(String option, String optionValue, String accessName,
			String accessValue, String elementState) throws Exception {
		misc_Obj.validateLocator(accessName);
		boolean flag = elementState.equals("selected");
		assertion_Obj.isOptionFromRadioButtonGroupSelected(accessName, accessValue, option, optionValue, flag);
	}

	/**
	 * Steps to check link presence
	 */
	@Then("^link having text \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
	public void check_element_presence(String accessValue, String present) throws TestCaseFailed, Exception {
		assertion_Obj.checkElementPresence("linkText", accessValue, present.isEmpty());
	}

	/**
	 * Steps to check partail link presence
	 */
	@Then("^link having partial text \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
	public void check_partial_element_presence(String accessValue, String present) throws TestCaseFailed, Exception {
		assertion_Obj.checkElementPresence("partialLinkText", accessValue, present.isEmpty());
	}

	/**
	 * Step to assert javascript pop-up alert text
	 */
	@Then("^I should\\s*((?:not)?)\\s+see alert text as \"(.*?)\"$")
	public void check_alert_text(String expectedText, String present) throws TestCaseFailed {
		assertion_Obj.checkAlertText(expectedText, present.isEmpty());
	}

	/**
	 * Step to select dropdown list
	 */
	@Then("^option \"(.*?)\" by (.+) from dropdown having (.+) \"(.*?)\" should be (selected|unselected)$")
	public void is_option_from_dropdown_selected(String option, String optionValue, String accessName,
			String accessValue, String elementState) throws Exception {
		misc_Obj.validateLocator(accessValue);
		boolean flag = elementState.equals("selected");
		assertion_Obj.isOptionFromDropdownSelected(accessName, accessValue, option, optionValue, flag);
	}

}
