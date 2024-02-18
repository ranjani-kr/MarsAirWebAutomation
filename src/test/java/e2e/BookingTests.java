package e2e;

import drivers.DriverCreator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BookingResultPage;
import pages.HomePage;
import pages.LauncherPage;

import java.util.List;

public class BookingTests {
    private final WebDriver webDriver = new DriverCreator().create("chrome");

    @BeforeTest
    public void setUp() {
        // Arrange
        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://marsair.recruiting.thoughtworks.net/RanjaniRaveendra");
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void verifyUserIsAbleToMakeSuccessfulBooking() {
        //Act
        //Go to website
        HomePage homePage = new HomePage(webDriver);

        //Select Depart Value
        //Select Return
        //Click on search button
        homePage.selectBookingDetails("July", "December (two years from now)");
        homePage.clickOnSearchButton();


        //Assert
        //Seats available!
        //Call now on 0800 MARSAIR to book!
        //Back
        BookingResultPage bookingResultPage = new BookingResultPage(webDriver);
        List<String> bookingMessage = bookingResultPage.getBookingMessage();

        Assert.assertEquals("Seats available!", bookingMessage.get(0));
        Assert.assertEquals("Call now on 0800 MARSAIR to book!", bookingMessage.get(1));
        Assert.assertEquals("Back", bookingMessage.get(2));

        bookingResultPage.goBackToHomePage();
    }

    @Test
    public void verifyUserNotAbleToMakeASuccessfulBooking() {
        //Act
        //Go to website
        HomePage homePage = new HomePage(webDriver);

        //Select Depart Value
        //Select Return
        //Click on search button
        homePage.selectBookingDetails("July", "December");
        homePage.clickOnSearchButton();


        BookingResultPage bookingResultPage = new BookingResultPage(webDriver);
        List<String> bookingMessage = bookingResultPage.getBookingMessage();
        Assert.assertEquals("Unfortunately, this schedule is not possible. Please try again.", bookingMessage.get(0));

        bookingResultPage.goBackToHomePage();
    }
}
