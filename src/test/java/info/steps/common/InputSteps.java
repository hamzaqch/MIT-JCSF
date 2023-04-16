package info.steps.common;

import info.pom.AbstractPage;
import io.cucumber.java.en.Then;

public class InputSteps extends AbstractPage {

	/**
	 * Step to enter text into input field steps
	 */
	@Then("^I enter \"([^\"]*)\" into input field having (.+) \"([^\"]*)\"$")
	public void enter_text(String text, String accessName, String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		input_Obj.enterText(accessName, accessValue, text);
	}

	/**
	 * Step to clear input field steps
	 */
	@Then("^I clear input field having (.+) \"([^\"]*)\"$")
	public void clear_text(String accessName, String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		input_Obj.clearText(accessName, accessValue);
	}

	/**
	 * Step to select option by text/value from dropdown
	 */
	@Then("^I select \"(.*?)\" option by (.+) from dropdown having (.+) \"(.*?)\"$")
	public void select_option_from_dropdown(String optionValue, String optionBy, String accessName, String accessValue)
			throws Exception {
		misc_Obj.validateLocator(accessName);
		misc_Obj.validateOptionBy(optionBy);
		input_Obj.selectOptionFromDropdown(accessName, accessValue, optionBy, optionValue);
	}

	/**
	 * Step to select option by index from dropdown
	 */
	@Then("^I select (\\d+) option by index from dropdown having (.+) \"(.*?)\"$")
	public void select_option_from_dropdown_by_index(String option, String accessName, String accessValue)
			throws Exception {
		misc_Obj.validateLocator(accessName);
		input_Obj.selectOptionFromDropdown(accessName, accessValue, "selectByIndex", option);
	}

	/**
	 * Step to select option by text/value from multiselect
	 */
	@Then("^I select \"(.*?)\" option by (.+) from multiselect dropdown having (.+) \"(.*?)\"$")
	public void select_option_from_multiselect_dropdown(String option, String optionBy, String accessName,
			String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		misc_Obj.validateOptionBy(optionBy);
		input_Obj.selectOptionFromDropdown(accessName, accessValue, optionBy, option);
	}

	/**
	 * Step to select option by index from multiselect
	 */
	@Then("^I select (\\d+) option by index from multiselect dropdown having (.+) \"(.*?)\"$")
	public void select_option_from_multiselect_dropdown_by_index(String option, String accessName, String accessValue)
			throws Exception {
		misc_Obj.validateLocator(accessName);
		input_Obj.selectOptionFromDropdown(accessName, accessValue, "selectByIndex", option);
	}

	/**
	 * Step to deselect option by text/value from multiselect
	 */
	@Then("^I deselect \"(.*?)\" option by (.+) from multiselect dropdown having (.+) \"(.*?)\"$")
	public void deselect_option_from_multiselect_dropdown(String option, String optionBy, String accessName,
			String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		misc_Obj.validateOptionBy(optionBy);
		input_Obj.deselectOptionFromDropDown(accessName, accessValue, optionBy, option);
	}

	/**
	 * Step todeselect option by index from multiselect
	 */
	@Then("^I deselect (\\d+) option by index from multiselect dropdown having (.+) \"(.*?)\"$")
	public void deselect_option_from_multiselect_dropdown_by_index(String option, String accessName, String accessValue)
			throws Exception {
		misc_Obj.validateLocator(accessName);
		input_Obj.deselectOptionFromDropDown(accessName, accessValue, "selectByIndex", option);
	}

	/**
	 * Step to unselect option from mutliselect dropdown list
	 */
	@Then("^I deselect all options from multiselect dropdown having (.+) \"(.*?)\"$")
	public void unselect_all_option_from_multiselect_dropdown(String accessName, String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		input_Obj.unselectAllOptionFromMultiSelectDropDown(accessName, accessValue);
	}

	/**
	 * Step to check checkbox steps
	 */
	@Then("^I check the checkbox having (.+) \"(.*?)\"$")
	public void check_checkbox(String accessName, String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		input_Obj.checkCheckBox(accessName, accessValue);
	}

	/**
	 * Step to uncheck checkbox steps
	 */
	@Then("^I uncheck the checkbox having (.+) \"(.*?)\"$")
	public void uncheck_checkbox(String accessName, String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		input_Obj.uncheckCheckBox(accessName, accessValue);
	}

	/**
	 * Steps to toggle checkbox
	 */
	@Then("^I toggle checkbox having (.+) \"(.*?)\"$")
	public void toggle_checkbox(String accessName, String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		input_Obj.toggleCheckbox(accessName, accessValue);
	}

	/**
	 * Step to select radio button
	 */
	@Then("^I select radio button having (.+) \"(.*?)\"$")
	public void select_radio_button(String accessName, String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		input_Obj.selectRadioButton(accessName, accessValue);
	}

	/**
	 * Steps to select option by text from radio button group
	 */
	@Then("^I select \"(.*?)\" option by (.+) from radio button group having (.+) \"(.*?)\"$")
	public void select_option_from_radio_btn_group(String option, String optionBy, String accessName,
			String accessValue) throws Exception {
		misc_Obj.validateLocator(accessName);
		input_Obj.selectOptionFromRadioButtonGroup(accessName, accessValue, optionBy, option);
	}

}
