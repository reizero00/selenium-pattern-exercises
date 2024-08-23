package com.udemy.seleniumdesign.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {

    private static final Supplier<PaymentOption> CREDIT_CARD = () -> new CreditCard();
    private static final Supplier<PaymentOption> BANKING = () -> new Banking();

    private static final Map<String, Supplier<PaymentOption>> MAP = new HashMap<>();

    static {
        MAP.put("CC", CREDIT_CARD);
        MAP.put("NB", BANKING);
    }

    public static PaymentOption get(String paymentType) {
        return MAP.get(paymentType).get();
    }

}
