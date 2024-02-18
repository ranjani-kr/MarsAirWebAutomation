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
                // Initialize ChromeDriver
                // Load chromedriver from the resources folder
                String chromedriverPath = getClass().getClassLoader().getResource("chromedriver").getPath();
                System.setProperty("webdriver.chrome.driver", chromedriverPath);
                return new ChromeDriver();
                // This is to initiate chrome from webdriver manager
                // return new ChromeDriverManager().create();
        }
    }
    private String setDefaultBrowser(String browser) {
        if(Objects.isNull(browser) || browser.isEmpty()) {
            browser = "chrome";
        }
        return browser;
    }
}