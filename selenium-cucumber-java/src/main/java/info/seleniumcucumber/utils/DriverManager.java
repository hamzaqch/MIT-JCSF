package info.seleniumcucumber.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public DriverManager() {
        // Private constructor to prevent instantiation
    }

    public WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            WebDriver driver = createDesktopDriver();
            driverThreadLocal.set(driver);
            Runtime.getRuntime().addShutdownHook(new Thread(DriverManager::quitDriver));
        }
        return driverThreadLocal.get();
    }

    private static WebDriver createDesktopDriver() {
        String browser = ConfigurationReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigurationReader.getProperty("headless"));

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                String chromeDriverPath = "src/main/resources/drivers/chromedriver";
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);

                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("window-size=1920,1080");
                chromeOptions.addArguments("-incognito");
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--no-sandbox");
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }
                return new FirefoxDriver(firefoxOptions);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "safari":
                return new SafariDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}