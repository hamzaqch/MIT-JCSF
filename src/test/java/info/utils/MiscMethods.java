package info.utils;

import java.util.Arrays;

import info.pom.AbstractPage;

public class MiscMethods extends AbstractPage {

	/**
	 * Method to validate Locator type
	 * 
	 * @param type : String : Locator type (id, name, class, xpath, css)
	 * @return boolean
	 */
	private boolean valid_locator_type(String type) {
		return Arrays.asList("id", "class", "css", "name", "xpath").contains(type);
	}

	/**
	 * Method to verify locator type
	 *
	 * @param type : String : Locator type (id, name, class, xpath, css)
	 */
	public void validateLocator(String type) throws Exception {
		if (!valid_locator_type(type))
			throw new Exception("Invalid locator type - " + type);
	}

	/**
	 * Method to validate Locator type
	 * 
	 * @param option_by : String : optionBy type ("text", "value", "index")
	 * @return boolean
	 */
	private boolean valid_option_by(String option_by) {
		return Arrays.asList("text", "value", "index").contains(option_by);
	}

	/**
	 * Method to verify dropdown selector (text, value or index)
	 * 
	 * @param optionBy : String : optionBy type ("text", "value", "index")
	 * @throws Exception
	 */
	public void validateOptionBy(String optionBy) throws Exception {
		if (!valid_option_by(optionBy))
			throw new Exception("Invalid option by - " + optionBy);
	}

}
