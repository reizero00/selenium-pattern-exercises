package com.udemy.seleniumdesign.template;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.udemy.seleniumdesign.template.pages.AmazonProductPage;
import com.udemy.seleniumdesign.template.pages.AmazonResultsPage;
import com.udemy.seleniumdesign.template.pages.AmazonSearchPage;

public class ShoppingAmazon extends ShoppingTemplate {

    private WebDriver driver;
    private String product;

    private AmazonSearchPage amazonSearchPage;
    private AmazonResultsPage amazonResultsPage;
    private AmazonProductPage amazonProductPage;

    public ShoppingAmazon(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
        this.amazonResultsPage = PageFactory.initElements(driver, AmazonResultsPage.class);
        this.amazonProductPage = PageFactory.initElements(driver, AmazonProductPage.class);

    }

    @Override
    public void launchSite() {
        this.amazonSearchPage.launchSite();
    }

    @Override
    public void searchForProduct() {
        this.amazonSearchPage.searchForProduct(this.product);

    }

    @Override
    public void selectProduct() {
        this.amazonResultsPage.selectProduct();
    }

    @Override
    public void buy() {
        this.amazonProductPage.buy();

    }

}
