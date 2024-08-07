package com.udemy.seleniumdesign.strategy;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchOneWay implements SearchOption {

     @FindBy(id = "ctl00_c_CtWNW_ltOneway")
    private WebElement returnRadioElement;

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom-suggest")
    private WebElement departureAirport;

    @FindBy(id = "txtDepartDate")
    private WebElement departureDate;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo-suggest")
    private WebElement arrivalAirport;

    @FindBy(xpath = "//td[contains(@class,'ui-datepicker-today')]")
    private WebElement selectDepartureDay;

    @FindBy(id = "chkFlexSearch")
    private WebElement flexSearchCheckBox;

    @Override
    public void enterSearchInformation(Map<String, String> searchDetails) {
        this.returnRadioElement.click();
        this.departureAirport.sendKeys(searchDetails.get("departureAirport"));
        this.arrivalAirport.sendKeys(searchDetails.get("arrivalAirport"));
        this.departureDate.click();
        this.selectDepartureDay.click();
        this.flexSearchCheckBox.click();

    }

}
