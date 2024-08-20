package com.udemy.seleniumdesign.test.template;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.udemy.seleniumdesign.template.ShoppingAmazon;
import com.udemy.seleniumdesign.template.ShoppingEbay;
import com.udemy.seleniumdesign.template.ShoppingTemplate;
import com.udemy.seleniumdesign.test.BaseTest;

public class ShoppingTest extends BaseTest{

    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate) {
        shoppingTemplate.shop();

    };

    @DataProvider
    public Object[] getData() {
        return new Object[] {
            new ShoppingAmazon(driver, "samsung galaxy"),
            new ShoppingEbay(driver, "samsung")
        };
    }

}
