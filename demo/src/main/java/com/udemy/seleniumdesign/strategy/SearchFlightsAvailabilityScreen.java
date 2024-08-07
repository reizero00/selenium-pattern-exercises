package com.udemy.seleniumdesign.strategy;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchFlightsAvailabilityScreen {

    private WebDriver driver;
    private SearchOption searchOption;
    private Passengers passengers;
    private PromotionalOffers promotionalOffers;
    private SearchAvailabilityButton searchAvailabilityButton;

    public SearchFlightsAvailabilityScreen(final WebDriver driver) {
        this.driver = driver;
        this.passengers = PageFactory.initElements(driver, Passengers.class);
        this.promotionalOffers = PageFactory.initElements(driver, PromotionalOffers.class);
        this.searchAvailabilityButton = PageFactory.initElements(driver, SearchAvailabilityButton.class);
    }

    public Passengers getPassengers() {
        return passengers;
    }

    public PromotionalOffers getPromotionalOffers() {
        return promotionalOffers;
    }

    public SearchAvailabilityButton getSearchAvailabilityButton() {
        return searchAvailabilityButton;
    }

    public void setSearchOption(SearchOption searchOption) {
        this.searchOption = searchOption;
        PageFactory.initElements(driver, searchOption);
    }

    public void search(Map<String, String> searchDetails) {
        this.searchOption.enterSearchInformation(searchDetails);
    }

}
