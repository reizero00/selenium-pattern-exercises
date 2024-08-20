package com.udemy.seleniumdesign.template.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    public AmazonSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void launchSite() {
        this.driver.get("https://www.amazon.com/");
    }

    public void searchForProduct(String product) {
        this.wait.until((d) -> this.searchBox.isDisplayed());
        this.searchBox.sendKeys(product);
        this.searchButton.click();
    }

}
