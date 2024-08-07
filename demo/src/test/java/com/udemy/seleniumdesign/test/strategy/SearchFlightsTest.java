package com.udemy.seleniumdesign.test.strategy;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import com.udemy.seleniumdesign.strategy.InvalidProcessScreen;
import com.udemy.seleniumdesign.strategy.SearchFlightsAvailabilityScreen;
import com.udemy.seleniumdesign.strategy.SearchOneWay;
import com.udemy.seleniumdesign.strategy.SearchOption;
import com.udemy.seleniumdesign.strategy.SearchReturn;
import com.udemy.seleniumdesign.test.BaseTest;

public class SearchFlightsTest extends BaseTest{

    private InvalidProcessScreen invalidProcessScreen;
    private SearchFlightsAvailabilityScreen searchFlightsAvailabilityScreen;

    @BeforeTest
    public void setScreens() {
        this.invalidProcessScreen = new InvalidProcessScreen(this.driver);
        this.searchFlightsAvailabilityScreen = new SearchFlightsAvailabilityScreen(this.driver);
        this.invalidProcessScreen.goTo();
        this.invalidProcessScreen.getEnableCookies().acceptCookies();
        this.invalidProcessScreen.getStartNewSearch().newSearch();
    }

    @Test(dataProvider = "getData")
    public void searchFlightsTest(SearchOption searchOption, Map<String, String> searchDetails) {

        this.invalidProcessScreen.goTo();

        this.searchFlightsAvailabilityScreen.setSearchOption(searchOption);
        this.searchFlightsAvailabilityScreen.search(searchDetails);

        this.searchFlightsAvailabilityScreen.getSearchAvailabilityButton().clickSearchButton();

    }

    @DataProvider
    public Object[][] getData() {

        Map<String, String> returnOptions = Maps.newHashMap();
        returnOptions.put("departureAirport", "LAX");
        returnOptions.put("arrivalAirport", "NRT");

        Map<String, String> oneWayOptions = Maps.newHashMap();
        oneWayOptions.put("departureAirport", "LAX");
        oneWayOptions.put("arrivalAirport", "NRT");

        return new Object[][] {
            {new SearchReturn(), returnOptions},
            {new SearchOneWay(), oneWayOptions}
        };

    }

}
