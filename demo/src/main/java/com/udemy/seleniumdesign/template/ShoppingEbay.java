package com.udemy.seleniumdesign.template;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingEbay extends ShoppingTemplate {

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    @FindBy(css = "s-item__title:nth-of-type(1)")
    private WebElement productName;

    @FindBy(id = "prcIsum")
    private WebElement productPrice;



    public ShoppingEbay(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.ebay.com");
    }

    @Override
    public void searchForProduct() {
        this.searchBox.sendKeys(this.product);
        this.searchButton.click();

    }

    @Override
    public void selectProduct() {
        this.wait.until((d) -> this.productName.isDisplayed());
        this.productName.click();

    }

    @Override
    public void buy() {
        this.wait.until((d) -> this.productPrice.isDisplayed());
        System.out.println(this.productPrice.getText());
    }

}
