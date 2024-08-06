package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnableCookies {

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;

    public EnableCookies(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        this.acceptCookiesButton.click();
    }

}
