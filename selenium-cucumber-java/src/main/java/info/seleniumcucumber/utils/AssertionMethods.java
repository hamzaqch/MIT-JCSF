package info.seleniumcucumber.utils;

import info.seleniumcucumber.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AssertionMethods extends AbstractPage implements BaseTest {
    // This file contains assertion methods which are called from
    // predefinedStepDefinitions

    private final SelectElementByType selectElementByType = new SelectElementByType();
    // SelectElementByType eleType= new SelectElementByType();
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
     * Method to verify page title
     *
     * @param title    : String : expected title
     * @param testCase : Boolean : test case [true or false]
     */
    public void checkTitle(String title, boolean testCase) throws TestCaseFailed {
        String pageTitle = getPageTitle();

        if (testCase) {
            if (!pageTitle.equals(title))
                throw new TestCaseFailed("Page Title Not Matched, Actual Page Title : " + pageTitle);
        } else {
            if (pageTitle.equals(title))
                throw new TestCaseFailed("Page Title Matched, Actual Page Title : " + pageTitle);
        }
    }

    /**
     * Method to verify partial page title
     *
     * @param partialTitle : String : partial title string
     * @param testCase     : Boolean : test case [true or false]
     */
    public void checkPartialTitle(String partialTitle, boolean testCase) throws TestCaseFailed {
        String pageTitle = getPageTitle();
        if (testCase) {
            if (!pageTitle.contains(partialTitle))
                throw new TestCaseFailed("Partial Page Title Not Present, Actual Page Title : " + pageTitle);
        } else {
            if (pageTitle.contains(partialTitle))
                throw new TestCaseFailed("Partial Page Title Present, Actual Page Title : " + pageTitle);
        }
    }

    /**
     * Method to get element text
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     * @return String
     */
    public String getElementText(String accessType, String accessName) {
        element = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(accessType, accessName)));
        return element.getText();

    }

    /**
     * Method to check element text
     *
     * @param accessType  : String : Locator type (id, name, class, xpath, css)
     * @param actualValue : String : Expected element text
     * @param accessName  : String : Locator value
     * @param testCase    : Boolean : test case [true or false]
     */
    public void checkElementText(String accessType, String actualValue, String accessName, boolean testCase)
            throws TestCaseFailed {
        String elementText = getElementText(accessType, accessName);

        if (testCase) {
            if (!elementText.equals(actualValue))
                throw new TestCaseFailed("Text Not Matched");
        } else {
            if (elementText.equals(actualValue))
                throw new TestCaseFailed("Text Matched");
        }
    }

    /**
     * Method to check partial element text
     *
     * @param accessType  : String : Locator type (id, name, class, xpath, css)
     * @param actualValue : String : Expected element text
     * @param accessName  : String : Locator value
     * @param testCase    : Boolean : test case [true or false]
     */
    public void checkElementPartialText(String accessType, String actualValue, String accessName, boolean testCase)
            throws TestCaseFailed {
        String elementText = getElementText(accessType, accessName);

        if (testCase) {
            if (!elementText.contains(actualValue))
                throw new TestCaseFailed("Text Not Matched");
        } else {
            if (elementText.contains(actualValue))
                throw new TestCaseFailed("Text Matched");
        }
    }

    /**
     * Method to return element status - enabled?
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     * @return Boolean
     */
    public boolean isElementEnabled(String accessType, String accessName) {
        element = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(accessType, accessName)));
        return element.isEnabled();
    }

    /**
     * Element enabled checking
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     * @param testCase   : Boolean : test case [true or false]
     */
    public void checkElementEnable(String accessType, String accessName, boolean testCase) throws TestCaseFailed {
        boolean result = isElementEnabled(accessType, accessName);
        if (testCase) {
            if (!result)
                throw new TestCaseFailed("Element Not Enabled");
        } else {
            if (result)
                throw new TestCaseFailed("Element Enabled");
        }
    }

    /**
     * method to get attribute value
     *
     * @param accessType    : String : Locator type (id, name, class, xpath, css)
     * @param accessName    : String : Locator value
     * @param attributeName : String : attribute name
     * @return String
     */
    public String getElementAttribute(String accessType, String accessName, String attributeName) {
        element = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(accessType, accessName)));
        return element.getAttribute(attributeName);
    }

    /**
     * method to check attribute value
     *
     * @param accessType     : String : Locator type (id, name, class, xpath, css)
     * @param attributeName  : String : attribute name
     * @param attributeValue : String : attribute value
     * @param accessName     : String : Locator value
     * @param testCase       : Boolean : test case [true or false]
     */
    public void checkElementAttribute(String accessType, String attributeName, String attributeValue, String accessName,
                                      boolean testCase) throws TestCaseFailed {
        String attrVal = getElementAttribute(accessType, accessName, attributeName);
        if (testCase) {
            if (!attrVal.equals(attributeValue))
                throw new TestCaseFailed("Attribute Value Not Matched");
        } else {
            if (attrVal.equals(attributeValue))
                throw new TestCaseFailed("Attribute Value Matched");
        }
    }

    /**
     * method to get element status - displayed?
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     * @return Boolean
     */
    public boolean isElementDisplayed(String accessType, String accessName) {
        element = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(accessType, accessName)));
        return element.isDisplayed();
    }

    /**
     * method to check element presence
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     * @param testCase   : Boolean : test case [true or false]
     */
    public void checkElementPresence(String accessType, String accessName, boolean testCase) throws TestCaseFailed {
        if (testCase) {
            if (!isElementDisplayed(accessType, accessName))
                throw new TestCaseFailed("Element Not Present");
        } else {
            try {
                if (isElementDisplayed(accessType, accessName))
                    throw new Exception("Present"); // since it is negative test
                // and we found element
            } catch (Exception e) {
                if (e.getMessage().equals("Present")) // only raise if it
                    // presents
                    throw new TestCaseFailed("Element Present");
            }
        }
    }

    /**
     * method to assert checkbox check/uncheck
     *
     * @param accessType      : String : Locator type (id, name, class, xpath, css)
     * @param accessName      : String : Locator value
     * @param shouldBeChecked : Boolean : test case [true or false]
     */
    public void isCheckboxChecked(String accessType, String accessName, boolean shouldBeChecked) throws TestCaseFailed {
        WebElement checkbox = getDriverWait().waitShort()
                .until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(accessType, accessName)));
        if ((!checkbox.isSelected()) && shouldBeChecked)
            throw new TestCaseFailed("Checkbox is not checked");
        else if (checkbox.isSelected() && !shouldBeChecked)
            throw new TestCaseFailed("Checkbox is checked");
    }

    /**
     * method to assert radio button selected/unselected
     *
     * @param accessType : String : Locator type (id, name, class, xpath, css)
     * @param accessName : String : Locator value
     */
    public void isRadioButtonSelected(String accessType, String accessName, boolean shouldBeSelected)
            throws TestCaseFailed {
        WebElement radioButton = getDriverWait().waitShort()
                .until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(accessType, accessName)));
        if ((!radioButton.isSelected()) && shouldBeSelected)
            throw new TestCaseFailed("Radio Button not selected");
        else if (radioButton.isSelected() && !shouldBeSelected)
            throw new TestCaseFailed("Radio Button is selected");
    }

    // method to assert option from radio button group is selected/unselected
    public void isOptionFromRadioButtonGroupSelected(String accessType, String by, String option, String accessName,
                                                     boolean shouldBeSelected) throws TestCaseFailed {
        List<WebElement> radioButtonGroup = getDriverWait().waitShort()
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectElementByType.getelementbytype(accessType, accessName)));

        for (WebElement rb : radioButtonGroup) {
            if (by.equals("value")) {
                if (rb.getAttribute("value").equals(option)) {
                    if ((!rb.isSelected()) && shouldBeSelected)
                        throw new TestCaseFailed("Radio Button not selected");
                    else if (rb.isSelected() && !shouldBeSelected)
                        throw new TestCaseFailed("Radio Button is selected");
                }
            } else if (rb.getText().equals(option)) {
                if ((!rb.isSelected()) && shouldBeSelected)
                    throw new TestCaseFailed("Radio Button not selected");
                else if (rb.isSelected() && !shouldBeSelected)
                    throw new TestCaseFailed("Radio Button is selected");
            }
        }
    }

    /**
     * method to get javascript pop-up alert text
     *
     * @return String
     */
    public String getAlertText() {
        return getDriver().switchTo().alert().getText();
    }

    /**
     * method to check javascript pop-up alert text
     *
     * @param text : String : Text to verify in Alert
     */
    public void checkAlertText(String text) throws TestCaseFailed {
        if (!getAlertText().equals(text))
            throw new TestCaseFailed("Text on alert pop up not matched");
    }

    /**
     * Method to verify if the particular option is Selected from Dropdown
     *
     * @param accessType       : String : Locator type (id, name, class, xpath, css)
     * @param by               : String : Select element from dropdown by text or value
     * @param option           : String : Element to select from dropdown
     * @param accessName       : String : Locator value
     * @param shouldBeSelected : Boolean : test case [true or false]
     */
    public void isOptionFromDropdownSelected(String accessType, String by, String option, String accessName,
                                             boolean shouldBeSelected) throws TestCaseFailed {
        Select selectList = null;
        WebElement dropdown = getDriverWait().waitShort()
                .until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(accessType, accessName)));
        selectList = new Select(dropdown);

        String actualValue = "";
        if (by.equals("text"))
            actualValue = selectList.getFirstSelectedOption().getText();
        else
            actualValue = selectList.getFirstSelectedOption().getAttribute("value");

        if ((!actualValue.equals(option)) && (shouldBeSelected))
            throw new TestCaseFailed("Option Not Selected From Dropdown");
        else if ((actualValue.equals(option)) && (!shouldBeSelected))
            throw new TestCaseFailed("Option Selected From Dropdown");
    }
}
