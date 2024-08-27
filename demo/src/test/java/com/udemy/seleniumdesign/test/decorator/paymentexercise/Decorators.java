package com.udemy.seleniumdesign.test.decorator.paymentexercise;

import java.util.function.Consumer;

import org.testng.Assert;

import com.udemy.seleniumdesign.decorator.paymentexercise.PaymentScreen;

public class Decorators {

    // Actions

    public static final Consumer<PaymentScreen> enterEmptyCoupon = (p) -> p.enterCoupon("");
    public static final Consumer<PaymentScreen> enterFreeCoupon = (p) -> p.enterCoupon("FREEUDEMY");
    public static final Consumer<PaymentScreen> enterDiscountCoupon = (p) -> p.enterCoupon("PARTIALUDEMY");

    public static final Consumer<PaymentScreen> enterValidPayment = (p) -> p.enterPaymentInformation("4111111111111111", "2024", "123");
    public static final Consumer<PaymentScreen> enterInvalidCreditCard = (p) -> p.enterPaymentInformation("4111111111111112", "2024", "123");
    public static final Consumer<PaymentScreen> enterInvalidYear = (p) -> p.enterPaymentInformation("4111111111111111", "2022", "123");
    public static final Consumer<PaymentScreen> enterInvalidCvv = (p) -> p.enterPaymentInformation("4111111111111111", "2022", "111");
    public static final Consumer<PaymentScreen> EnterEmptyPayment = (p) -> p.enterPaymentInformation("", "", "");

    public static final Consumer<PaymentScreen> clickBuyNow = (p) -> p.clickBuyNow();

    // Asserts

    public static final Consumer<PaymentScreen> isFullPrice = (p) -> Assert.assertEquals(p.getPrice(), "999");
    public static final Consumer<PaymentScreen> isDiscounted = (p) -> Assert.assertEquals(p.getPrice(), "299");
    public static final Consumer<PaymentScreen> isFree = (p) -> Assert.assertEquals(p.getPrice(), "0");
    public static final Consumer<PaymentScreen> statusIsPass = (p) -> Assert.assertEquals(p.getStatus(), "PASS");
    public static final Consumer<PaymentScreen> statusIsFail = (p) -> Assert.assertEquals(p.getStatus(), "FAIL");

}
