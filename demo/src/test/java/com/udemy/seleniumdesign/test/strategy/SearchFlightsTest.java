package com.udemy.seleniumdesign.test.strategy;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.udemy.seleniumdesign.strategy.InvalidProcessScreen;
import com.udemy.seleniumdesign.test.BaseTest;

public class SearchFlightsTest extends BaseTest{

    private InvalidProcessScreen invalidProcessScreen;

    @BeforeTest
    public void setScreens() {
        this.invalidProcessScreen = new InvalidProcessScreen(this.driver);
    }

    @Test
    public void searchFlightsTest() {

        this.invalidProcessScreen.goTo();
        this.invalidProcessScreen.getEnableCookies().acceptCookies();
        this.invalidProcessScreen.getStartNewSearch().newSearch();

    }

}
