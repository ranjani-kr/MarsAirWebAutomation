package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MakeABooking {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/ranjani/Downloads/chromedriver-mac-arm64/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // 1. Go to the website
        driver.get("https://marsair.recruiting.thoughtworks.net/RanjaniRaveendra");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("departing")));

        // 2. Select Depart dropdown
        WebElement departDropdown = driver.findElement(By.id("departing"));
        Select departSelect = new Select(departDropdown);
        departSelect.selectByVisibleText("July");

        // 3. Select Return dropdown
        WebElement returnDropdown = driver.findElement(By.id("returning"));
        Select returnSelect = new Select(returnDropdown);
        returnSelect.selectByVisibleText("December (two years from now)");

        //WebElement promotionalCode = driver.findElement(By.id("promotional_code"));
        //promotionalCode.sendKeys("AF3-FJK-418");

        driver.findElement(By.xpath("//input[@value='Search']")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));



       // Find the element with id "content"
        WebElement contentDiv = driver.findElement(By.id("content"));

        // Locate all <p> elements within the content div
        java.util.List<WebElement> paragraphs = contentDiv.findElements(By.tagName("p"));

        // Create a StringBuilder to concatenate the text from all <p> elements
        List<String> successResult = new ArrayList<>();

        // Iterate through each <p> element and append its text to the StringBuilder
        for (WebElement paragraph : paragraphs) {
            successResult.add(paragraph.getText());
        }

        Assert.assertEquals("Seats available!", successResult.get(0));
        Assert.assertEquals("Call now on 0800 MARSAIR to book!", successResult.get(1));
        Assert.assertEquals("Back", successResult.get(2));

        // Print or use the result text as needed
        System.out.println(successResult);

        driver.findElement(By.linkText("Back")).click();
        driver.quit();

    }
}
