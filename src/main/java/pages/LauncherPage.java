package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LauncherPage {
    private WebDriver webDriver;
    public LauncherPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public Boolean navigateTo(String url) {
        webDriver.get(url);
        return isSiteLoaded();
    }

    private Boolean isSiteLoaded() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
