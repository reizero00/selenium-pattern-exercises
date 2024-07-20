package com.udemy.seleniumdesign.srp.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchWidget extends AbstractComponent{

    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver){
        super(driver);
    }

    public void enter(String keywordString){
        this.searchBox.clear();
        this.searchBox.sendKeys(keywordString);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) -> this.searchBox.isDisplayed());
    }

}
