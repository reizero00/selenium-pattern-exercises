package com.udemy.seleniumdesign.decorator.paymentexercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentScreen {

    private WebDriver driver;

    @FindBy(id = "coupon")
    private WebElement couponInput;

    @FindBy(id = "couponbtn")
    private WebElement couponButton;

    @FindBy(id = "cc")
    private WebElement creditCardInput;

    @FindBy(id = "year")
    private WebElement yearInput;

    @FindBy(id = "cvv")
    private WebElement cvvInput;

    @FindBy(id = "price")
    private WebElement price;

    @FindBy(id = "status")
    private WebElement status;

    @FindBy(id = "buy")
    private WebElement buyButton;

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

    public PaymentScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterCoupon(String coupon) {
        this.couponInput.sendKeys(coupon);
        this.couponButton.click();
    }

    public String getPrice() {
        return this.price.getText();
    }

    public void enterPaymentInformation(String creditCard, String year, String cvv) {
        this.creditCardInput.sendKeys(creditCard);
        this.yearInput.sendKeys(year);
        this.cvvInput.sendKeys(cvv);
    }

    public void clickBuyNow() {
        this.buyButton.click();
    }

    public String getStatus() {
        return this.status.getText();
    }

}
