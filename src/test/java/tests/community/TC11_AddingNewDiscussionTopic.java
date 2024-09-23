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

public class TC11_AddingNewDiscussionTopic {

    @BeforeMethod
    public void setUp() throws IOException {
        String driverType = getPropertyValue("config", "driverType");
        WebDriver driver = DriverManager.createDriver(driverType);
        setDriver(driver);
        getDriver().get(getPropertyValue("config", "LOGIN_PAGE"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testAddingNewDiscussionTopic() throws IOException, InterruptedException {
        P01_Login login = new P01_Login(getDriver());
        login.enterUsername(getJsonData("login", "username"))
                .enterPassword(getJsonData("login", "password"))
                .clickLogin();

        P02_Community newDiscussionTopic = new P02_Community(getDriver());
        newDiscussionTopic.openCommunityDropdown()
                .clickDiscussion()
                .clickNewBookDiscussion()
                .enterBookTopic(getJsonData("information", "bookTopic"))
                .enterTopic(getJsonData("information", "topic"))
                .enterComment(getJsonData("information", "comment"))
                .clickPost();

        Assert.assertTrue(newDiscussionTopic.assertDiscussion());

    }

    @AfterMethod
    public void tearDown() {
    quitDriver();
    }
}
