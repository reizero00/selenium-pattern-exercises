package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleFrench extends GoogleEnglish {

    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
    private WebElement languageSelector;
    
    @FindBy(xpath = "(//input[@value='Recherche Google'])[2]")
    private WebElement searchButton;

    public GoogleFrench(final WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.fr/");
        this.languageSelector.click();
        this.wait.until((driver) -> this.searchButton.isDisplayed());

    }

}
