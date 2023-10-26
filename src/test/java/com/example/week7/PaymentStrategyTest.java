package com.example.week7;

import com.example.week7.payments.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PaymentStrategyTest {

    private CreditCardPaymentStrategy creditCardPayment;
    private PayPalPaymentStrategy payPalPayment;

    @BeforeEach
    public void setUp() {
        creditCardPayment = new CreditCardPaymentStrategy();
        payPalPayment = new PayPalPaymentStrategy();
    }

    @Test
    public void testInitialBalance() {
        Assertions.assertEquals(0.0, creditCardPayment.getBalance(), 0.001);
        Assertions.assertEquals(0.0, payPalPayment.getBalance(), 0.001);
    }

    @Test
    public void testPutMoney() {
        creditCardPayment = new CreditCardPaymentStrategy(100.0);
        payPalPayment = new PayPalPaymentStrategy(50.0);

        creditCardPayment.putMoney(25.0);
        payPalPayment.putMoney(30.0);

        Assertions.assertEquals(125.0, creditCardPayment.getBalance(), 0.001);
        Assertions.assertEquals(80.0, payPalPayment.getBalance(), 0.001);
    }

    @Test
    public void testTakeMoney() {
        creditCardPayment = new CreditCardPaymentStrategy(100.0);
        payPalPayment = new PayPalPaymentStrategy(50.0);

        double takenFromCreditCard = creditCardPayment.takeMoney(25.0);
        double takenFromPayPal = payPalPayment.takeMoney(30.0);

        Assertions.assertEquals(25.0, takenFromCreditCard, 0.001);
        Assertions.assertEquals(30.0, takenFromPayPal, 0.001);
        Assertions.assertEquals(75.0, creditCardPayment.getBalance(), 0.001);
        Assertions.assertEquals(20.0, payPalPayment.getBalance(), 0.001);
    }

    @Test
    public void testPay() {
        creditCardPayment = new CreditCardPaymentStrategy(100.0);
        payPalPayment = new PayPalPaymentStrategy(50.0);

        boolean creditCardPaymentResult = creditCardPayment.pay(75.0);
        boolean payPalPaymentResult = payPalPayment.pay(40.0);

        Assertions.assertTrue(creditCardPaymentResult);
        Assertions.assertTrue(payPalPaymentResult);

        Assertions.assertFalse(creditCardPayment.pay(110.0));
        Assertions.assertFalse(payPalPayment.pay(70.0));
    }
}
