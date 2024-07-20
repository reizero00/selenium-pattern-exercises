package com.udemy.seleniumdesign.srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.udemy.seleniumdesign.srp.common.SearchSuggestion;
import com.udemy.seleniumdesign.srp.common.SearchWidget;

public class GoogleResultPage {

    private WebDriver driver;
    private NavigationBar navigationBar;
    private ResultStat resultStat;
    private SearchSuggestion searchSuggestion;
    private SearchWidget searchWidget;

    public GoogleResultPage(final WebDriver driver) {
        this.driver = driver;
        this.navigationBar = PageFactory.initElements(this.driver, NavigationBar.class);
        this.resultStat = PageFactory.initElements(this.driver, ResultStat.class);
        this.searchSuggestion = PageFactory.initElements(this.driver, SearchSuggestion.class);
        this.searchWidget = PageFactory.initElements(this.driver, SearchWidget.class);
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }

    public SearchSuggestion getSearchSuggestion(){
        return searchSuggestion;
    }
    
    public SearchWidget getSearchWidget(){
        return searchWidget;
    }
}
