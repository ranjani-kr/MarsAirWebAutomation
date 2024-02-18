package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    WebDriver webDriver;
    By depart = By.id("departing");
    By returnId = By.id("returning");
    By promoCode = By.id("promotional_code");
    By searchButton = By.xpath("//input[@value='Search']");
    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage selectBookingDetails(String departValue, String returnValue ){
        WebElement departDropdown = webDriver.findElement(depart);
        Select departDD= new Select(departDropdown);
        departDD.selectByVisibleText(departValue);

        WebElement returnDropdown = webDriver.findElement(returnId);
        Select returnDD= new Select(returnDropdown);
        returnDD.selectByVisibleText(returnValue);
        return this;
    }

    public BookingResultPage clickOnSearchButton(){
        webDriver.findElement(searchButton).click();
        return new BookingResultPage(webDriver);
    }
}
