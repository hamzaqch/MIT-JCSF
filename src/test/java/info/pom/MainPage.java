package info.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{

	
	/*
	 * WebElements
	 */
	@CacheLookup
	@FindBy(xpath = "//*[@id=\"nav\"]/ol/li[1]/a")
	public WebElement mobileMenu;
	
	@CacheLookup
	@FindBy(xpath = "h2")
	public WebElement titleOfThePage;
	
	@CacheLookup
	@FindBy(xpath = "*//*[@title=\"Sort By\"]")
	public WebElement sortedBy;
	
	@CacheLookup
	@FindBy(xpath = "*//h2")
	public List<WebElement> listMenu;
	
}
