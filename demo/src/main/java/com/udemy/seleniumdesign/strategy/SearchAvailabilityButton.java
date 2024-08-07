package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchAvailabilityButton {

    @FindBy(id = "ctl00_c_IBE_PB_FF")
    private WebElement searchButton;

    public void clickSearchButton() {
        this.searchButton.click();
    }

}
