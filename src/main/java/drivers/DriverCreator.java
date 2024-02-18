package drivers;

import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
public class DriverCreator {
    public WebDriver create(String browser) {
        browser = setDefaultBrowser(browser);
        switch (browser.toLowerCase()) {
            case "firefox":
                return new FirefoxDriverManager().create();
            case "edge":
                return new EdgeDriverManager().create();
            default:
                //WebDriverManager.chromedriver().driverVersion("121.0.6167.184").setup();
                // Initialize ChromeDriver
                //return new ChromeDriverManager().create();
                System.setProperty("webdriver.chrome.driver", "/Users/ranjani/Downloads/chromedriver-mac-arm64/chromedriver");
                return new ChromeDriver();
        }
    }
    private String setDefaultBrowser(String browser) {
        if(Objects.isNull(browser) || browser.isEmpty()) {
            browser = "chrome";
        }
        return browser;
    }
}