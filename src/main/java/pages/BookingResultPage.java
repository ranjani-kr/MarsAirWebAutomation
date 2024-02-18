package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BookingResultPage {

    WebDriver webDriver;
    By backLink = By.linkText("Back");
    By bookingResultMessage = By.id("content");
    public BookingResultPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public List<String> getBookingMessage(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));

        // Find the element with id "content"
        WebElement contentDiv = webDriver.findElement(By.id("content"));

        // Locate all <p> elements within the content div
        java.util.List<WebElement> paragraphs = contentDiv.findElements(By.tagName("p"));

        // Create a StringBuilder to concatenate the text from all <p> elements
        List<String> bookingMessage = new ArrayList<>();

        // Iterate through each <p> element and append its text to the StringBuilder
        for (WebElement paragraph : paragraphs) {
            bookingMessage.add(paragraph.getText());
        }

        return bookingMessage;
    }

    public void goBackToHomePage() {
        webDriver.findElement(backLink).click();
    }
}
