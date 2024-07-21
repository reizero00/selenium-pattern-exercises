package com.udemy.seleniumdesign.test.factory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleEnglish extends GooglePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    @FindBy(css = "div.rc")
    private List<WebElement> results;

    public GoogleEnglish(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com/");
    }

    @Override
    public void search(String keyword) {
        this.searchBox.sendKeys(keyword);
        this.wait.until((driver) -> this.searchButton.isDisplayed());
        this.searchButton.click();
    }

    @Override
    public int getResultCount() {
        this.wait.until((driver) -> this.results.size() > 1);
        return this.results.size();
    }

}
