package com.udemy.seleniumdesign.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderComponentReal implements OrderComponent {

    @FindBy(id = "buy")
    private WebElement buyNowButton;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public OrderComponentReal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    @Override
    public String placeOrder() {
        this.buyNowButton.click();
        return this.orderNumber.getText();
    }

}
