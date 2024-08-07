package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Passengers {

    @FindBy(id = "ctl00_c_CtNoOfTr_numberAdults_chosen")
    private WebElement adultsDropdown;

    @FindBy(id = "ctl00_c_CtNoOfTr_numberChildren_chosen")
    private WebElement childrenDropdown;

    @FindBy(id = "ctl00_c_CtNoOfTr_numberinfants_chosen")
    private WebElement infantsDropdown;

    public void selectNumberofAdults(int number) {
        Select dropdown = new Select(adultsDropdown);
        dropdown.selectByValue(String.valueOf(number));
    }

    public void selectNumberofChildren(int number) {
        Select dropdown = new Select(childrenDropdown);
        dropdown.selectByValue(String.valueOf(number));
    }

    public void selectNumberofInfants(int number) {
        Select dropdown = new Select(infantsDropdown);
        dropdown.selectByValue(String.valueOf(number));
    }

}
