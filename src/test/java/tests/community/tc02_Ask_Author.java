package tests.community;

import DriverSettings.DriverManager;
import Pages.P01_Login;
import Pages.P02_Community;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverSettings.DriverManager.*;
import static utilities.DataUtils.getJsonData;
import static utilities.DataUtils.getPropertyValue;


public class tc02_Ask_Author {

    @BeforeMethod
    public void setUp() throws IOException {
        String driverType = getPropertyValue("config", "driverType");
        WebDriver driver = DriverManager.createDriver(driverType);
        setDriver(driver);
        getDriver().get(getPropertyValue("config", "LOGIN_PAGE"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testAskAuthor() throws IOException {
        // TODO: Login
        P01_Login loginPage = new P01_Login(getDriver());
        loginPage.enterUsername(getJsonData("login", "username"))
                .enterPassword(getJsonData("login", "password"))
                .clickLogin();

        new P02_Community(getDriver())
                .openCommunityDropdown()
                .clickAskAuthor()
                .clickAsk()
                .enterQuestion(getJsonData("information", "ask"))
                .clickSubmit();

    }

    @AfterMethod
    public void tearDown() {
        // TODO: Close the browser
        // quitDriver();
    }
}
