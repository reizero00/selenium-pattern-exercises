package com.udemy.seleniumdesign.command;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    // Buttons
    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoButton;

    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement warningButton;

    @FindBy(css = "div.button-box button.btn-success")
    private WebElement successButton;

    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement dangerButton;

    // Notifications
    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warningAlert;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-icon-error")
    private WebElement dangerAlert;

    // Dismiss Alerts
    @FindBy(xpath = "//h4[@class='card-title'][contains(text(), 'Dissmissal Alert')]/following-sibling::div[contains(@class, 'alert-info')]")
    private WebElement dismissInfoAlert;

    @FindBy(xpath = "//h4[@class='card-title'][contains(text(), 'Dissmissal Alert')]/following-sibling::div[contains(@class, 'alert-success')]")
    private WebElement dismissSuccessAlert;

    @FindBy(xpath = "//h4[@class='card-title'][contains(text(), 'Dissmissal Alert')]/following-sibling::div[contains(@class, 'alert-danger')]")
    private WebElement dismissDangerAlert;

    @FindBy(xpath = "//h4[@class='card-title'][contains(text(), 'Dissmissal Alert')]/following-sibling::div[contains(@class, 'alert-warning')]")
    private WebElement dismissWarningAlert;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ElementValidator> getElementValidators() {
        return Arrays.asList(
            new NotificationValidator(infoButton, infoAlert),
            new NotificationValidator(successButton, successAlert),
            new NotificationValidator(warningButton, warningAlert),
            new NotificationValidator(dangerButton, dangerAlert),
            new DismissalAlertValidator(dismissSuccessAlert),
            new DismissalAlertValidator(dismissDangerAlert),
            new DismissalAlertValidator(dismissWarningAlert),
            new DismissalAlertValidator(dismissInfoAlert)
        );
    }

}
