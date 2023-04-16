package info.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import info.config.*;

public abstract class AbstractPage implements Base{

	private final DriverManager driverManager = new DriverManager();
	private final DriverWait driverWait = new DriverWait(driverManager);

	protected AbstractPage() {
		PageFactory.initElements(driverManager.getDriver(), this);
	}

	public WebDriver getDriver() {
		return driverManager.getDriver();
	}
	
	public DriverWait getDriverWait() {
		return driverWait;
	}
	
	public void wait(String time) throws InterruptedException {
		Thread.sleep(Integer.parseInt(time));
	}

}
