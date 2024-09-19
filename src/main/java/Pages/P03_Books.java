package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.Utility.*;

public class P03_Books {
    private final WebDriver driver;
    private final By dropdown = By.xpath("//*[@id=\"bodycontainer\"]/div/div[4]/main/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div[1]/div[2]/button");
    private final By currentlyReading = By.xpath("//*[@id=\"bodycontainer\"]/div/div[4]/main/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div[1]/div[2]/div/div/div/li[2]/button");
    private final By read = By.xpath("//*[@id=\"bodycontainer\"]/div/div[4]/main/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div[1]/div[1]/span/div");
    private final By defaultButton = By.xpath("//*[@id=\"bodycontainer\"]/div/div[4]/main/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div[1]/div[1]/button");

    public P03_Books(WebDriver driver) {
        this.driver = driver;
    }

    // TODO: Click on the shelves list
    public P03_Books clickShelvesList() {
        clickingOnElement(driver, dropdown);
        return this;
    }

    // TODO: Click on the currently reading option
    public P03_Books clickCurrentlyReading() {
        clickingOnElement(driver, currentlyReading);
        return this;
    }

    // TODO: Assert the book is added to the currently reading shelf
    public boolean assertCurrentlyReading() {
        return checkElementExist(driver, read);
    }

    // TODO: handle the alert
    public void handleAlert() {
        driver.switchTo().alert().accept();
    }

    // TODO: Assert the book is removed from the currently reading shelf
    public boolean assertCurrentlyReadingRemoved() {
        return checkElementExist(driver, defaultButton);
    }
}
