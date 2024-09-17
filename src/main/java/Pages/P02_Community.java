package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.Utility.*;

public class P02_Community {

    // TODO: Define the locators
    private  final  By communityButton = By.xpath("//*[@id=\"bodycontainer\"]/div/div[2]/div/header/div[3]/div/nav/ul/li[4]/div/a");
    private final  By askAuthorButton = By.xpath("//*[@id=\"bodycontainer\"]/div/div[2]/div/header/div[3]/div/nav/ul/li[4]/div/div/ul/li[4]/a");
    private final  By askbutton = By.xpath("//*[@id=\"bodycontainer\"]/div[3]/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div[3]/a");
    private final  By askInput = By.id("qaTextArea");
    private final  By submitButton = By.xpath("//*[@id=\"bodycontainer\"]/div[3]/div[1]/div[1]/div[2]/div[2]/form/div[1]/div[2]/button");

    private final WebDriver driver;

    // TODO: Create a constructor
    public P02_Community(WebDriver driver) {
        this.driver = driver;
    }

    // TODO: Open the community Dropdown
    public P02_Community openCommunityDropdown() {
        clickingOnElement(driver, communityButton);
        return this;
    }

    // TODO: Click on the Ask the Author button
    public P02_Community clickAskAuthor() {
        clickingOnElement(driver, askAuthorButton);
        return this;
    }

    // TODO: Click on the Ask button
    public P02_Community clickAsk() {
        clickingOnElement(driver, askbutton);
        return this;
    }

    // TODO: Enter the question
    public P02_Community enterQuestion(String question) {
        enterData(driver, askInput, question);
        return this;
    }

    // TODO: Click on the submit button
    public void clickSubmit() {
        clickingOnElement(driver, submitButton);
    }


}
