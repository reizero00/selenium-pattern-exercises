package com.udemy.seleniumdesign.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;

public class GoogleFactory {
    
    private static final Function<WebDriver, GooglePage> ENG = (driver) -> new GoogleEnglish(driver);
    private static final Function<WebDriver, GooglePage> ES = (driver) -> new GoogleSpanish(driver);
    private static final Function<WebDriver, GooglePage> FR = (driver) -> new GoogleFrench(driver);
    private static final Function<WebDriver, GooglePage> SA = (driver) -> new GoogleArabic(driver);

    private static final Map<String, Function<WebDriver, GooglePage>> MAP = new HashMap<>();

    static {
        MAP.put("ENG", ENG);
        MAP.put("ES", ES);
        MAP.put("FR", FR);
        MAP.put("SA", SA);
    }
        
    public static GooglePage get(String language, WebDriver driver) {

        return MAP.get(language).apply(driver);

    }

}
