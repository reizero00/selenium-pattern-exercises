package com.udemy.seleniumdesign.srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;


public class NavigationBar extends AbstractComponent {

    @FindBy(id = "hdtb")
    private WebElement bar;

    @FindBy(linkText = "Images")
    private WebElement imagesLink;

    @FindBy(linkText = "News")
    private WebElement newsLink;

    @FindBy(id = "hdtb-tls")
    private WebElement toolsButton;

    public void goToImages() {
        this.imagesLink.click();
    }

    public void goToNews() {
        this.newsLink.click();
    }

    public void goToTools() {
        this.toolsButton.click();
    }

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) -> this.bar.isDisplayed());
    }

}
