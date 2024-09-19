package tests.login;

import DriverSettings.DriverManager;
import Pages.P01_Login;
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

public class TC03_IncorrectPassword {

    private static final String EXPECTED_URL;

    static {
        try {
            EXPECTED_URL = getPropertyValue("config", "BASE_URL");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void setUp() throws IOException {
        String driverType = getPropertyValue("config", "driverType");
        WebDriver driver = DriverManager.createDriver(driverType);
        setDriver(driver);
        getDriver().get(getPropertyValue("config", "LOGIN_PAGE"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testLogin() throws IOException {
        P01_Login loginPage = new P01_Login(getDriver());
        loginPage.enterUsername(getJsonData("login", "username"))
                .enterPassword(getJsonData("login", "WrongPassword"))
                .clickLogin();
        Assert.assertFalse(loginPage.assertLoginTc(EXPECTED_URL));
    }

    @AfterMethod
    public void tearDown() {
        // TODO: Close the browser
        quitDriver();
    }
}
