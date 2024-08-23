package com.udemy.seleniumdesign.proxy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.WebDriver;

public class OrderComponentProxy implements OrderComponent {

    private static final List<String> EXCLUDED =  Arrays.asList("PROD", "STAGING");
    private OrderComponent orderComponent;

    public OrderComponentProxy(WebDriver driver) {
        String currentEnv = System.getProperty("env");
        if(!EXCLUDED.contains(currentEnv)) {
            this.orderComponent = new OrderComponentReal(driver);
        }
        
    }

    @Override
    public String placeOrder() {
        if(Objects.nonNull(this.orderComponent)) {
            return this.orderComponent.placeOrder();
        } else {
            return "SKIPPED";
        }
    }

}
