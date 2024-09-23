package tests.books;

import DriverSettings.DriverManager;
import Pages.P01_Login;
import Pages.P03_Books;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverSettings.DriverManager.*;
import static utilities.DataUtils.getJsonData;
import static utilities.DataUtils.getPropertyValue;

public class TC10_RemovingBookToCurrentlyReading {

    @BeforeMethod
    public void setUp() throws IOException {
        String driverType = getPropertyValue("config", "driverType");
        WebDriver driver = DriverManager.createDriver(driverType);
        setDriver(driver);
        getDriver().get(getPropertyValue("config", "LOGIN_PAGE"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
    }


    @Test
    public void testAddingBookToCurrentlyReading() throws IOException {
        // TODO: Login
        P01_Login loginPage = new P01_Login(getDriver());
        loginPage.enterUsername(getJsonData("login", "username"))
                .enterPassword(getJsonData("login", "password"))
                .clickLogin();

        P03_Books addBookToCurrentlyReading = new P03_Books(getDriver());
        addBookToCurrentlyReading.clickShelvesList().clickCurrentlyReading().handleAlert();

        Assert.assertTrue(addBookToCurrentlyReading.assertCurrentlyReadingRemoved());
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
