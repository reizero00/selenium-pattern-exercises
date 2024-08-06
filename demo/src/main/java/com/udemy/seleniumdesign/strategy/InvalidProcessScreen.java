package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InvalidProcessScreen {

    private WebDriver driver;
    private StartNewSearch startNewSearch;
    private EnableCookies enableCookies;

    public InvalidProcessScreen(final WebDriver driver) {
        this.driver = driver;
        this.startNewSearch = PageFactory.initElements(driver, StartNewSearch.class);
        this.enableCookies = PageFactory.initElements(driver, EnableCookies.class);
    }

    public void goTo() {
        this.driver.get("https://fly4.emirates.com/CAB/IBE/SearchAvailability.aspx");
    }

    public EnableCookies getEnableCookies() {
        return enableCookies;
    }

    public StartNewSearch getStartNewSearch() {
        return startNewSearch;
    }

}
