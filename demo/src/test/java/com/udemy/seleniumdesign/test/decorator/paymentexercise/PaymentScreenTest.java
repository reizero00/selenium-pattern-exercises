package com.udemy.seleniumdesign.test.decorator.paymentexercise;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.decorator.paymentexercise.PaymentScreen;
import com.udemy.seleniumdesign.test.BaseTest;

import static com.udemy.seleniumdesign.test.decorator.paymentexercise.Decorators.*;

public class PaymentScreenTest extends BaseTest{

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
        this.paymentScreen = new PaymentScreen(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTests(Consumer<PaymentScreen> consumer) {
        paymentScreen.goTo();
        consumer.accept(paymentScreen);

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
            enterValidPayment
            .andThen(isFullPrice)
            .andThen(clickBuyNow)
            .andThen(statusIsPass),

            enterDiscountCoupon
            .andThen(isDiscounted)
            .andThen(enterValidPayment)
            .andThen(clickBuyNow)
            .andThen(statusIsPass),

            enterFreeCoupon
            .andThen(isFree)
            .andThen(enterValidPayment)
            .andThen(clickBuyNow)
            .andThen(statusIsPass),

            enterDiscountCoupon
            .andThen(enterInvalidCreditCard)
            .andThen(clickBuyNow)
            .andThen(statusIsFail),

            enterInvalidYear
            .andThen(clickBuyNow)
            .andThen(statusIsFail),

            EnterEmptyPayment
            .andThen(clickBuyNow)
            .andThen(statusIsFail)
        };
    }

}
