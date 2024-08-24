package com.udemy.seleniumdesign.executearound;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameB {

    @FindBy(name = "fn")
    private WebElement firstName;

    @FindBy(name = "ln")
    private WebElement lastName;

    @FindBy(name = "addr")
    private WebElement address;

    @FindBy(id = "area")
    private WebElement message;

    public void inputFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void inputAddress(String address) {
        this.address.sendKeys(address);
    }

    public void inputMessage(String message) {
        this.message.sendKeys(message);
    }

}
