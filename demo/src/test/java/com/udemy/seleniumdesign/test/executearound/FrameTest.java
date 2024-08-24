package com.udemy.seleniumdesign.test.executearound;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.udemy.seleniumdesign.executearound.MainPage;
import com.udemy.seleniumdesign.test.BaseTest;

public class FrameTest extends BaseTest{

    private MainPage mainPage;

    @BeforeTest
    public void setMainPage() {
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest() {

        this.mainPage.goTo();

        this.mainPage.onFrameA(a -> {
            a.inputFirstName("FirstA");
            a.inputLastName("LastA");
            a.inputAddress("AddressA");
            a.inputMessage("MessageA This is a great way to input");
        });

        this.mainPage.onFrameB(b -> {
            b.inputFirstName("FirstB");
            b.inputLastName("LastB");
            b.inputAddress("AddressB");
            b.inputMessage("MessageB This is a great way to input");
        });

        this.mainPage.onFrameC(c -> {
            c.inputFirstName("FirstC");
            c.inputLastName("LastC");
            c.inputAddress("AddressC");
            c.inputMessage("MessageC This is a great way to input");
        });

    }

}
