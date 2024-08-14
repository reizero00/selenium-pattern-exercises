package com.udemy.seleniumdesign.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator{

    private final WebElement dismissalAlert;

    public DismissalAlertValidator(final WebElement element) {
        this.dismissalAlert = element;
    }

    @Override
    public boolean validate() {
        boolean appearanceState = this.dismissalAlert.isDisplayed();
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();

        boolean disappearanceState = false;

        try{
            disappearanceState = this.dismissalAlert.isDisplayed();
        } catch(Exception e){}

        return appearanceState && (!disappearanceState);
    }

}
