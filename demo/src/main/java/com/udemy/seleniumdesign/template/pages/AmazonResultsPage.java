package com.udemy.seleniumdesign.template.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonResultsPage {
    
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "h2 a.a-link-normal")
    private WebElement productName;


    public AmazonResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);

    }

    public void selectProduct() {
        this.wait.until((d) -> this.productName.isDisplayed());
        this.productName.click();
    }

}
