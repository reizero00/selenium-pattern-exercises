package com.udemy.seleniumdesign.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.util.concurrent.Uninterruptibles;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUpDriver() {
        String path = BaseTest.class.getResource("/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", path);
        this.driver = new org.openqa.selenium.chrome.ChromeDriver();
    }

    @AfterTest
    public void closeDriver() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.driver.quit();
    }

}