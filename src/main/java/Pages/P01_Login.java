package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.Utility.*;


public class P01_Login {
    // TODO: Define the locators
    private final By usernameInput = By.id("ap_email");
    private final By passwordInput = By.id("ap_password");
    private final By loginButton = By.id("signInSubmit");

    private final WebDriver driver;

    // TODO: Create a constructor
    public P01_Login(WebDriver driver) {
        this.driver = driver;
    }

    // TODO: Create a method to send the username
    public P01_Login enterUsername(String username) {
        enterData(driver, usernameInput, username);
        return this;
    }

    // TODO: Create a method to send the password
    public P01_Login enterPassword(String password) {
        enterData(driver, passwordInput, password);
        return this;
    }

    // TODO: Create a method to click on the login button
    public void clickLogin() {
        clickingOnElement(driver, loginButton);
    }

    // TODO: Create a method to assert the login
    public boolean assertLoginTc(String expectedUrl) {
        return driver.getCurrentUrl().equals(expectedUrl);
    }
}
