package info.utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import info.pom.AbstractPage;
import info.config.*;

public class InputMethods extends AbstractPage implements Base {

	private WebElement dropdown, checkbox = null;
	private Select selectList = null;

	/**
	 * Method to enter text into text field
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 * @param text        : String : Text value to enter in filed
	 */
	public void enterText(String accessType, String accessValue, String text) {
		getDriverWait().waitShort().until(ExpectedConditions
				.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)));
		getDriver().findElement(selectElementByType.getElementByType(accessType, accessValue)).sendKeys(text);
	}

	/**
	 * Method to clear text of text filed
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 */
	public void clearText(String accessType, String accessValue) {
		getDriverWait().waitShort().until(ExpectedConditions
				.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)));
		getDriver().findElement(selectElementByType.getElementByType(accessType, accessValue)).clear();
	}
	
	/**
     * Method to select option from dropdown list
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param option     : String : Option to select
     * @param accessName : String : Locator value
     */
    public void selectOptionFromDropdown(String accessType, String accessValue, String optionBy, String option) {
        dropdown = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)));
        selectList = new Select(dropdown);

        if (optionBy.equals("selectByIndex"))
            selectList.selectByIndex(Integer.parseInt(option) - 1);
        else if (optionBy.equals("value"))
            selectList.selectByValue(option);
        else if (optionBy.equals("text"))
            selectList.selectByVisibleText(option);
    }

	/**
	 * Method to select element from Dropdown by type
	 *
	 * @param select_list : Select : Select variable
	 * @param optionBy    : String : Name of by type (selectByIndex, value, text)
	 * @param option      : String : Option to select
	 */
	public void selectElementFromDropDownByType(Select select_list, String optionBy, String option) {
		if (optionBy.equals("selectByIndex")) {
			int index = Integer.parseInt(option);
			select_list.selectByIndex(index - 1);
		} else if (optionBy.equals("value"))
			select_list.selectByValue(option);
		else if (optionBy.equals("text"))
			select_list.selectByVisibleText(option);
	}
	
	/**
	 * Method to select element from Dropdown Generic
	 * 
	 * @param <T>         : Generic : Can accept String or Integer
	 * @param select_list : Select  : Select variable
	 * @param arg 		  : String  : Option value (index, value or Visible text)
	 */
	public <T extends Comparable<T>> void genericSelectElementFromDropDownByType(Select select_list, T arg) {
	    if (arg != null) {
	        if (arg instanceof String) {
	            String argStr = (String) arg;
	            if (argStr.equals("value")) {
	                select_list.selectByValue(argStr);
	            } else {
	                select_list.selectByVisibleText(argStr);
	            }
	        } else if (arg instanceof Integer) {
	            int argInt = (Integer) arg;
	            if (argInt > 0) {
	                select_list.selectByIndex(argInt - 1);
	            } else {
	                throw new IllegalArgumentException("Index must be a positive integer");
	            }
	        } else {
	            throw new IllegalArgumentException("Argument type not supported");
	        }
	    } else {
	        throw new NullPointerException("Argument cannot be null");
	    }
	}

	/**
	 * Method to unselect option from dropdwon list
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 * @param optionBy    : String : Name of by type (selectByIndex, value, text)
	 * @param option      : String : Option to select
	 */
	public void deselectOptionFromDropDown(String accessType, String accessValue, String optionBy, String option) {
		dropdown = getDriverWait().waitShort().until(ExpectedConditions
				.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)));
		selectList = new Select(dropdown);

		if (optionBy.equals("selectByIndex"))
			selectList.deselectByIndex(Integer.parseInt(option) - 1);
		else if (optionBy.equals("value"))
			selectList.deselectByValue(option);
		else if (optionBy.equals("text"))
			selectList.deselectByVisibleText(option);
	}
	
	/**
	 * Method to unselect all option from dropdwon list
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 */
	public void unselectAllOptionFromMultiSelectDropDown(String accessType, String accessValue) {
		dropdown = getDriverWait().waitShort().until(ExpectedConditions
				.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)));
		selectList = new Select(dropdown);
		selectList.deselectAll();
	}

	/**
	 * Method to check check-box
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 */
	public void checkCheckBox(String accessType, String accessValue) {
		checkbox = getDriverWait().waitShort().until(ExpectedConditions
				.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)));
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	/**
	 * Method to uncheck check-box
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
	 * @param accessValue : String : Locator value
	 */
	public void uncheckCheckBox(String accessType, String accessValue) {
		checkbox = getDriverWait().waitShort().until(ExpectedConditions
				.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)));
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}
	
	/**
	 * Method to toggle check-box status
	 * 
	 * @param accessType  : String : Locator type (id, name, class, xpath, css)
     * @param accessValu)e : String : Locator value
	 */
	public void toggleCheckbox(String accessType, String accessValue) {
		getDriverWait().waitShort().until(ExpectedConditions
				.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue))).click();
	}
	
	/**
     * Method to select radio button
     *
     * @param accessType  : String : Locator type (id, name, class, xpath, css)
     * @param accessValue : String : Locator value
     */
    public void selectRadioButton(String accessType, String accessValue) {
        WebElement radioButton = getDriverWait().waitShort()
                .until(ExpectedConditions
                		.presenceOfElementLocated(selectElementByType.getElementByType(accessType, accessValue)));
        if (!radioButton.isSelected())
            radioButton.click();
    }
	
    /**
     * Method to select option from radio button group
     *
     * @param accessType  : String : Locator type (id, name, class, xpath, css)
     * @param accessValue : String : Locator value
     * @param by          : String : Name of by type
     * @param option      : String : Option to select
     */
    public void selectOptionFromRadioButtonGroup(String accessType, String accessValue, String by, String option) {
        List<WebElement> radioButtonGroup = getDriver()
        		.findElements(selectElementByType.getElementByType(accessType, accessValue));
        for (WebElement rb : radioButtonGroup) {
            if (by.equals("value")) {
                if (rb.getAttribute("value").equals(option) && !rb.isSelected())
                    rb.click();
            } else if (by.equals("text")) {
                if (rb.getText().equals(option) && !rb.isSelected())
                    rb.click();
            }
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
