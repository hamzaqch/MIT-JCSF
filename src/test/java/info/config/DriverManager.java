package info.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	
	private static ThreadLocal<WebDriver> thread_driver_instance = new ThreadLocal<>();
	private static WebDriver driver;
	private static ChromeOptions chromeOptions = new ChromeOptions();
	private static FirefoxOptions ffOptions = new FirefoxOptions();
	
	private static final Thread CLOSE_THREAD = new Thread() {
		@Override
		public void run() {
			driver.quit();
		}
	};
	
	/**
	 * Method to select the Browser
	 * @param  dBrowser : Browser : select the browser from enum class
	 * @param headless  : Boolean : true for headless and false if not
	 * @return WedDriver
	 */
	public WebDriver selectDriver(Browser dBrowser, Boolean headless ) {
		switch (dBrowser) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			chromeOptions.addArguments("--remote-allow-origins=*");
			chromeOptions.addArguments("window-size=1920,1080");
            chromeOptions.addArguments("-incognito");
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--no-sandbox");
            if (headless) {
            setHeadLess(dBrowser);
            }
			driver = new ChromeDriver(chromeOptions);
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			if (headless) {
			setHeadLess(dBrowser);
			}
			driver = new FirefoxDriver(ffOptions);
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
		setWebDriver(driver);
		Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
		return getDriver();
	}
	
	/**
	 * Method to get the current Driver
	 * @return WebDriver
	 */
	public WebDriver getDriver() {
		return thread_driver_instance.get();
	}
	
	private static void setWebDriver(WebDriver driver) {
		thread_driver_instance.set(driver);
	} 
	
	@SuppressWarnings("deprecation")
	private static void setHeadLess(Browser dBrowser) {
		switch (dBrowser) {
		case CHROME:
			 chromeOptions.addArguments("--headless");
			 break;
		case FIREFOX:
			ffOptions.setHeadless(true);
			break;
		case EDGE:
			break;
		case SAFARI:
			break;
		default:
			break;
		}
	}
}
