package com.udemy.seleniumdesign.template.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductPage {

    private WebDriver driver;
    private WebDriverWait wait;
    
    public AmazonProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#corePriceDisplay_desktop_feature_div span.aok-offscreen")
    private WebElement productPrice;

    public void buy() {
        this.wait.until((d) -> this.productPrice.isDisplayed());
        System.out.println(this.productPrice.getText());
    }

}
