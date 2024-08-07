package com.udemy.seleniumdesign.strategy;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchReturn implements SearchOption {

    @FindBy(id = "ctl00_c_CtWNW_ltReturn")
    private WebElement returnRadioElement;

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom-suggest")
    private WebElement departureAirport;

    @FindBy(id = "txtDepartDate")
    private WebElement departureDate;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo-suggest")
    private WebElement arrivalAirport;

    @FindBy(id = "txtarrivaldate")
    private WebElement arrivalDate;

    @FindBy(id = "chkFlexSearch")
    private WebElement flexSearchCheckBox;

    @FindBy(id = "ctl00_c_CtWNW_flightClass")
    private WebElement flightClass;

    @FindBy(xpath = "//td[contains(@class,'ui-datepicker-today')]")
    private WebElement selectDepartureDay;

    @FindBy(xpath = "//td[contains(@class,' return-date-selected-hover')][1]")
    private WebElement selectReturnDay;

    @Override
    public void enterSearchInformation(Map<String, String> searchDetails) {

        this.returnRadioElement.click();
        this.departureAirport.sendKeys(searchDetails.get("departureAirport"));
        this.departureDate.click();
        this.selectDepartureDay.click();
        this.arrivalAirport.sendKeys(searchDetails.get("arrivalAirport"));
        this.arrivalDate.click();
        this.selectReturnDay.click();
        this.flexSearchCheckBox.click();

    }

}
