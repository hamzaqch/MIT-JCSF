package info.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import info.config.*;

public abstract class AbstractPage implements Base{

	private final DriverManager driverManager = new DriverManager();
	private final DriverWait driverWait = new DriverWait(driverManager);
	private final Browser dbrowser = Browser.CHROME;

	protected AbstractPage() {
		PageFactory.initElements(driverManager.selectDriver(dbrowser, false), this);
	}

	public WebDriver getDriver() {
		return driverManager.getDriver();
	}
	
	public DriverWait getDriverWait() {
		return driverWait;
	}

}
