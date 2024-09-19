package tests.community;

import DriverSettings.DriverManager;
import Pages.P01_Login;
import Pages.P02_Community;
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

public class TC06_Join_popular_group {
    @BeforeMethod
    public void setUp() throws IOException {
        String driverType = getPropertyValue("config", "driverType");
        WebDriver driver = DriverManager.createDriver(driverType);
        setDriver(driver);
        getDriver().get(getPropertyValue("config", "LOGIN_PAGE"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testJoinPopularGroup() throws IOException {
        P01_Login login = new P01_Login(getDriver());
        login.enterUsername(getJsonData("login", "username"))
                .enterPassword(getJsonData("login", "password"))
                .clickLogin();

        P02_Community joinPopularGroup = new P02_Community(getDriver());
        joinPopularGroup.openCommunityDropdown()
                .clickPopularGroup()
                .scrollGroup()
                .selectGroup()
                .joinGroup()
                .clickJoinGroup();

        // TODO: Add an assertion
        Assert.assertTrue(joinPopularGroup.assertNotification());
    }

    @AfterMethod
    public void tearDown() {
        // TODO: Close the browser
        quitDriver();
    }
}
