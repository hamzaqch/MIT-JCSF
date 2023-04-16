package info.pom;

import java.util.LinkedList;
import java.util.List;
import info.config.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.google.common.collect.Ordering;

public class MainPageObjects extends AbstractPage{

	
	/*
	 * WebElements
	 */
	
	@CacheLookup
	//@FindBy(xpath = "//*[@id=\"nav\"]/ol/li[1]/a")
	@FindBy(how = How.XPATH, using =  "//*[@id=\"nav\"]/ol/li[1]/a")
	private WebElement mobileMenu;
	
	@CacheLookup
	@FindBy(xpath = "h2")
	private WebElement titleOfThePage;
	
	@CacheLookup
	//@FindBy(xpath = "*//*[@title=\"Sort By\"]")
	@FindBy(how = How.XPATH, using =  "*//*[@title=\\\"Sort By\\\"]")
	private WebElement sortedBy;
	
	@CacheLookup
	@FindBy(xpath = "*//h2")
	private List<WebElement> listOfProduct;
	
	/**
	 * Action method
	 */
	
	public void allProductAreSortedByName(boolean testCase) throws TestCaseFailed {
		LinkedList<String> listOfName = new LinkedList<>();
		for (int i = 0 ; i < listOfProduct.size() ; i ++) {
			String name = listOfProduct.get(i).getText();
			listOfName.add(name);
		}
		if (testCase && !Ordering.natural().isOrdered(listOfName)) 
			throw new TestCaseFailed("All products are not sorted by name ");
	}
	
	public void pageTitleShouldBe(String text) {
		getDriver().getPageSource().contains(text);
	}
	
}
