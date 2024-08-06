package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartNewSearch {

    @FindBy(xpath = "(//a[normalize-space()='New search'])")
    private WebElement newSearchButton;

    public StartNewSearch(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void newSearch() {
        this.newSearchButton.click();
    }

}
