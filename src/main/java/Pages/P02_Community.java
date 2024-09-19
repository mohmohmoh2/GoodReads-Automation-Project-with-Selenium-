package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static utilities.Utility.*;

public class P02_Community {

    // TODO: Define the locators
    private  final  By communityButton = By.xpath("//*[@id=\"bodycontainer\"]/div/div[2]/div/header/div[3]/div/nav/ul/li[4]/div/a");
    private final  By askAuthorButton = By.xpath("//*[@id=\"bodycontainer\"]/div/div[2]/div/header/div[3]/div/nav/ul/li[4]/div/div/ul/li[4]/a");
    private final  By askButton = By.xpath("//*[@id=\"bodycontainer\"]/div[3]/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div[3]/a");
    private final  By askInput = By.id("qaTextArea");
    private final  By submitButton = By.xpath("//*[@id=\"bodycontainer\"]/div[3]/div[1]/div[1]/div[2]/div[2]/form/div[1]/div[2]/button");
    private final By displayedDialog = By.xpath("//*[@id=\"bodycontainer\"]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div");
    private final WebDriver driver;
    private final By groupsButton = By.xpath("//div[3]/div/nav/ul/li[4]/div/div/ul/li[1]/a");
    private  final By selectGroup = By.xpath("//*[@id=\"bodycontainer\"]/div/div[3]/div[1]/div[6]/div[2]/div/div/a");
    private final By joinGroup = By.xpath("//*[@id=\"bodycontainer\"]/div[3]/div[1]/div[2]/div[3]/div[2]/a");
    private  final By joinGroupButton = By.xpath("//*[@id=\"bodycontainer\"]/div[3]/div[1]/div[1]/form/div/a[1]");
    private final  By notification = By.xpath("//*[@id=\"header_notice_container\"]/div");
    private final By quotesButton = By.xpath("//*[@id=\"bodycontainer\"]/div/div[2]/div/header/div[3]/div/nav/ul/li[4]/div/div/ul/li[3]/a");
    private final By likeButton = By.id("add_quote_button8630");
    private final By viewQuote = By.xpath("//*[@id=\"quote_added8630\"]/div[1]/a");
    private final By myQuotes = By.xpath("//*[@id=\"bodycontainer\"]/div[3]/div[1]/div[2]/div[2]/div[4]/div[3]/div[2]/div[1]/a");
    private final By unLikeButton = By.xpath("//*[@id=\"bodycontainer\"]/div[3]/div[1]/div[2]/div[4]/div[3]/div/a");

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
        clickingOnElement(driver, askButton);
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

    // TODO: Assert the dialog is displayed
    public boolean assertDialog() {
        // Check if the item is displayed
        return checkElementExist(driver, displayedDialog);
    }

    // TODO: Click on groups button
    public P02_Community clickPopularGroup() {
        clickingOnElement(driver, groupsButton);
        return this;
    }

    // TODO: scroll to the group
    public P02_Community scrollGroup() {
        scrolling(driver, selectGroup);
        return this;
    }

    // TODO: Select a group
    public P02_Community selectGroup() {
        clickingOnElement(driver, selectGroup);
        return this;
    }

    // TODO: Join a group
    public P02_Community joinGroup() {
        clickingOnElement(driver, joinGroup);
        return this;
    }

    // TODO: Click on the join group button
    public void clickJoinGroup() {
        clickingOnElement(driver, joinGroupButton);
    }

    // TODO: Assert the notification is displayed
    public boolean assertNotification() {
        // Check if the item is displayed
        return checkElementExist(driver, notification);
    }

    // TODO: Click on the quotes button
    public P02_Community clickQuotes() {
        clickingOnElement(driver, quotesButton);
        return this;
    }

    // TODO: Click on the like button
    public void clickLike() {
        clickingOnElement(driver, likeButton);
    }

    // TODO: Click in my quotes
    public P02_Community clickMyQuotes() {
        clickingOnElement(driver, myQuotes);
        return this;
    }

    // TODO: Click on the unlike button
    public P02_Community clickUnLike() {
        clickingOnElement(driver, unLikeButton);
        return this;
    }

    // TODO: Handle the alert
    public void handleAlert() {
        driver.switchTo().alert().accept();
    }

    // TODO: Assert the View Quote is displayed
    public boolean assertViewQuote() {
        // Check if the item is displayed
        return checkElementExist(driver, viewQuote);
    }

    // TODO: Assert redirect to the quotes page
    public boolean assertQuotesPage() {
        return Objects.equals(driver.getCurrentUrl(), "https://www.goodreads.com/quotes/list/182014228");
    }
}
