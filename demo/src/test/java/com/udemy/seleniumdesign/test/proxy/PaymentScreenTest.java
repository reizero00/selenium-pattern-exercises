package com.udemy.seleniumdesign.test.proxy;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import com.udemy.seleniumdesign.proxy.Banking;
import com.udemy.seleniumdesign.proxy.CreditCard;
import com.udemy.seleniumdesign.proxy.PaymentOption;
import com.udemy.seleniumdesign.proxy.PaymentOptionFactory;
import com.udemy.seleniumdesign.proxy.PaymentScreen;
import com.udemy.seleniumdesign.test.BaseTest;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen(){
        System.setProperty("env", "PROD");
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(PaymentOption paymentOption, Map<String, String> paymentDetails) {

        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails(
            "FirstName",
            "LastName",
            "TestEmail@email.com"
        );

        this.paymentScreen.setPaymentOption(paymentOption);
        this.paymentScreen.pay(paymentDetails);

        String orderNumber = this.paymentScreen.getOrder().placeOrder();

        System.out.println(
            "Order Number: " + orderNumber
        );
    }

    @Test(dataProvider = "getFactoryData")
    public void paymentFactoryTest(String paymentType, Map<String, String> paymentDetails) {

        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails(
            "FirstName",
            "LastName",
            "TestEmail@email.com"
        );

        this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(paymentType));
        this.paymentScreen.pay(paymentDetails);

        String orderNumber = this.paymentScreen.getOrder().placeOrder();

        System.out.println(
            "Order Number: " + orderNumber
        );
    }

    @DataProvider
    public Object[][] getData() {

        Map<String, String> creditCard = Maps.newHashMap();
        creditCard.put("cc", "1234 5678 1234 5678");
        creditCard.put("year", "2020");
        creditCard.put("cvv", "123");

        Map<String, String> netBank = Maps.newHashMap();
        netBank.put("bank", "WELLS FARGO");
        netBank.put("account", "0123456789");
        netBank.put("pin", "1234");


        return new Object[][]{
            {new CreditCard(), creditCard},
            {new Banking(), netBank},
        };
    }

    @DataProvider
    public Object[][] getFactoryData() {

        Map<String, String> creditCard = Maps.newHashMap();
        creditCard.put("cc", "1234 5678 1234 5678");
        creditCard.put("year", "2020");
        creditCard.put("cvv", "123");

        Map<String, String> netBank = Maps.newHashMap();
        netBank.put("bank", "WELLS FARGO");
        netBank.put("account", "0123456789");
        netBank.put("pin", "1234");


        return new Object[][]{
            {"CC", creditCard},
            {"NB", netBank},
        };
    }



}
