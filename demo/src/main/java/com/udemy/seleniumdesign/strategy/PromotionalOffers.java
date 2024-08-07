package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PromotionalOffers {

    @FindBy(id = "ctl00_c_CtPrOffer_txtEnterCode")
    private WebElement promotionalCode;

    public void enterPromotionalCode(String code) {
        this.promotionalCode.sendKeys(code);
    }

}
