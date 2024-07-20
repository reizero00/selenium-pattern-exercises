package com.udemy.seleniumdesign.srp.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.udemy.seleniumdesign.srp.common.SearchSuggestion;
import com.udemy.seleniumdesign.srp.common.SearchWidget;

public class GoogleMainPage {

    private WebDriver driver;
    private SearchSuggestion searchSuggestion;
    private SearchWidget searchWidget;

    public GoogleMainPage(final WebDriver driver){
        this.driver = driver;
        this.searchSuggestion = PageFactory.initElements(this.driver, SearchSuggestion.class);
        this.searchWidget = PageFactory.initElements(this.driver, SearchWidget.class);
    }
    
    public void goTo(){
        this.driver.get("https://www.google.com/");
    }

    public SearchSuggestion getSearchSuggestion(){
        return searchSuggestion;
    }
    
    public SearchWidget getSearchWidget(){
        return searchWidget;
    }
}
