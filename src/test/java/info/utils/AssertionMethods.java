package info.utils;

import info.pom.AbstractPage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import info.config.*;

public class AssertionMethods extends AbstractPage {

	private final SelectElementByType selectElementByType = new SelectElementByType();

	private WebElement element = null;

	/**
	 * Method to get page title
	 * 
	 * @return String
	 */
	public String getPageTitle() {
		return getDriver().getTitle();
	}

	/**
	 * Method to get WebElement Text
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 * @return String
	 */
	public String getElementText(String accessType, String accessValue) {
		return getDriverWait().waitShort()
				.until(ExpectedConditions
						.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)))
				.getText();
	}

	/**
	 * Method to verify page title
	 * 
	 * @param expectedtitle : String : Expected title
	 * @param testCase      : Boolean : test case [true or false]
	 */
	public void checkTitle(String expectedtitle, boolean testCase) throws TestCaseFailed {
		if (testCase && !getPageTitle().equals(expectedtitle)) {
			throw new TestCaseFailed("Page Title Not Matched, Actual Page Title : " + getPageTitle());
		} else if (!testCase && getPageTitle().equals(expectedtitle)) {
			throw new TestCaseFailed("Page Title Matched, Actual Page Title : " + getPageTitle());
		}
	}

	/**
	 * Method to verify partial page title
	 * 
	 * @param partialTitle : String : partial title string
	 * @param testCase     : Boolean : test case [true or false]
	 */
	public void checkPartialTitle(String partialTitle, boolean testCase) throws TestCaseFailed {
		if (testCase && !getPageTitle().contains(partialTitle)) {
			throw new TestCaseFailed("Page Title Not Matched, Actual Page Title : " + getPageTitle());
		} else if (!testCase && getPageTitle().contains(partialTitle)) {
			throw new TestCaseFailed("Page Title Matched, Actual Page Title : " + getPageTitle());
		}
	}

	/**
	 * Method to check WebElement text
	 * 
	 * @param accessType   : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue  : String : Locator value
	 * @param expectedText : String : Expected element text
	 * @param testCase     : Boolean : test case [true or false]
	 */
	public void checkElementText(String accessType, String accessValue, String expectedText, boolean testCase)
			throws TestCaseFailed {
		if (testCase && !getElementText(accessType, accessValue).equals(expectedText)) {
			throw new TestCaseFailed("Text Not Matched");
		} else if (!testCase && getElementText(accessType, accessValue).equals(expectedText)) {
			throw new TestCaseFailed("Text Matched");
		}
	}

	/**
	 * Method to check partial element text
	 * 
	 * @param accessType   : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue  : String : Locator value
	 * @param expectedText : String : Expected element text
	 * @param testCase     : Boolean : test case [true or false]
	 */
	public void checkElementPartialText(String accessType, String accessValue, String expectedText, boolean testCase)
			throws info.config.TestCaseFailed {
		if (testCase && !getElementText(accessType, accessValue).contains(expectedText)) {
			throw new TestCaseFailed("Text Not Matched");
		} else if (!testCase && getElementText(accessType, accessValue).contains(expectedText)) {
			throw new TestCaseFailed("Text Matched");
		}
	}

	/**
	 * Method to return element status - enabled?
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 * @return boolean
	 */
	public boolean isElementEnabled(String accessType, String accessValue) {
		return getDriverWait().waitShort()
				.until(ExpectedConditions
						.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)))
				.isEnabled();
	}

	/**
	 * Method Element enabled checking
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 * @param testCase    : Boolean : test case [true or false]
	 */
	public void checkElementEnable(String accessType, String accessValue, boolean testCase) throws TestCaseFailed {
		if (testCase && !isElementEnabled(accessType, accessValue)) {
			throw new TestCaseFailed("Element Not Enabled");
		} else if (!testCase && isElementEnabled(accessType, accessValue)) {
			throw new TestCaseFailed("Element Enabled");
		}
	}

	/**
	 * Method to get attribute value
	 * 
	 * @param accessType    : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue   : String : Locator value
	 * @param attributeName : String : Attribute name
	 * @return String
	 */
	public String getElementAttribute(String accessType, String accessValue, String attributeName) {
		return getDriverWait().waitShort()
				.until(ExpectedConditions
						.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)))
				.getAttribute(attributeName);
	}

	/**
	 * 
	 * 
	 * @param accessType     : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue    : String : Locator value
	 * @param attributeName  : String : Attribute name
	 * @param attributeValue : String : attribute value
	 * @param testCase       : Boolean : test case [true or false]
	 */
	public void checkElementAttribute(String accessType, String accessValue, String attributeName,
			String attributeValue, boolean testCase) throws TestCaseFailed {
		if (testCase && !getElementAttribute(accessType, accessValue, attributeName).equals(attributeValue)) {
			throw new TestCaseFailed("Attribute Value Not Matched");
		} else if (!testCase && getElementAttribute(accessType, accessValue, attributeName).equals(attributeValue)) {
			throw new TestCaseFailed("Attribute Value Matched");
		}
	}

	/**
	 * Method to get element status - displayed?
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 * @return boolean
	 */
	public boolean isElementDisplayed(String accessType, String accessValue) {
		return getDriverWait().waitShort()
				.until(ExpectedConditions
						.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)))
				.isDisplayed();
	}

	/**
	 * Method to check element presence
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 * @param testCase    : Boolean : test case [true or false]
	 */
	public void checkElementPresence(String accessType, String accessValue, boolean testCase) throws TestCaseFailed {
		if (testCase && !isElementDisplayed(accessType, accessValue)) {
			throw new TestCaseFailed("Element Not Present");
		} else {

			try {
				if (!testCase && isElementDisplayed(accessType, accessValue)) {
					throw new Exception("Present");
				}
			} catch (Exception e) {
				if (e.getMessage().equals("Present")) {
					throw new TestCaseFailed("Element Present");
				}
			}

		}
	}
	
	/**
	 * Method to check if element is selcted
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 * @return boolean
	 */
	private boolean isElementSelected(String accessType, String accessName) {
		return getDriverWait()
				.waitShort()
				.until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessName)))
				.isSelected();
	}
	
	/**
	 * Method to assert checkbox check/uncheck
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 * @param testCase    : Boolean : test case [true or false]
	 */
	public void isCheckboxChecked(String accessType, String accessName, boolean testCase) throws TestCaseFailed {
		if (testCase && !isElementSelected(accessType, accessName)) {
			throw new TestCaseFailed("Radio Button not selected");
		}
		else if (!testCase && isElementSelected(accessType, accessName)) {
			throw new TestCaseFailed("Radio Button is selected");
		}
			}
	
	/**
	 * Method to assert radio button selected/unselected
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 * @param testCase    : Boolean : test case [true or false]
	 */
	public void isRadioButtonSelected(String accessType, String accessName, boolean testCase) throws TestCaseFailed {
		if (testCase && !isElementSelected(accessType, accessName)) {
			throw new TestCaseFailed("Radio Button not selected");
		}
		else if (!testCase && isElementSelected(accessType, accessName)) {
			throw new TestCaseFailed("Radio Button is selected");
		}
			}
	
	/**
	 * Method to assert option from radio button group is selected/unselected
	 * 
	 * @param accessType  : String  : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String  : Locator value
	 * @param byOption	  : String  : Option By (Value, visible text, index)
	 * @param option	  : String  : Value of byOption
	 * @param testCase    : Boolean : test case [true or false]
	 */
	public void isOptionFromRadioButtonGroupSelected(String accessType, String accessName, String byOption, String option, boolean testCase) throws TestCaseFailed {
		List<WebElement> element = getDriverWait()
				.waitShort().until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectElementByType.getElementByType(accessType, accessName)));
		for (int i = 0; i<element.size(); i++) {
			if (byOption.equals("value") && element.get(i).getAttribute("value").equals(option)) {
				if (testCase && !element.get(i).isSelected()) {
					throw new TestCaseFailed("Radio Button not selected");
				}
				else if (!testCase && element.get(i).isSelected()) {
					throw new TestCaseFailed("Radio Button is selected");
				}
			}
			else if (element.get(i).getText().equals(option)) {
				if (testCase && !element.get(i).isSelected()) {
					throw new TestCaseFailed("Radio Button not selected");
				}
				else if (!testCase && element.get(i).isSelected()) {
					throw new TestCaseFailed("Radio Button is selected");
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
