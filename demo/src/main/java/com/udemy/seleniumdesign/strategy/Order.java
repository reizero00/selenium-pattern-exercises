package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order {

    @FindBy(id = "buy")
    private WebElement buyNowButton;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public Order(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String placeOrder() {
        this.buyNowButton.click();
        return this.orderNumber.getText();
    }

}
