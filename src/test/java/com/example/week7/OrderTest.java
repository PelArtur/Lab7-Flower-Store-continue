package com.example.week7;

import com.example.week7.Order;
import com.example.week7.delivery.*;
import com.example.week7.flower.*;
import com.example.week7.payments.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class OrderTest {

    private Order order;
    private Payment creditCardPayment;
    private Payment payPalPayment;
    private DHLDeliveryStrategy dhlDelivery;
    private PostDeliveryStrategy postDelivery;
    private Item item1;
    private Item item2;

    @BeforeEach
    public void setUp() {
        order = new Order();
        creditCardPayment = new CreditCardPaymentStrategy(100.0);
        payPalPayment = new PayPalPaymentStrategy(50.0);
        dhlDelivery = new DHLDeliveryStrategy();
        postDelivery = new PostDeliveryStrategy();
        item1 = new Flower(FlowerType.ROSE);
        item2 = new Flower(FlowerType.ROSE);
    }

    @Test
    public void testAddItem() {
        order.addItem(item1);
        Assertions.assertTrue(order.getItems().contains(item1));
    }

    @Test
    public void testRemoveItem() {
        order.addItem(item1);
        order.addItem(item2);
        order.removeItem(item1);
        Assertions.assertFalse(order.getItems().contains(item1));
    }

    @Test
    public void testCalculateTotalPrice() {
        order.setPaymentStrategy(creditCardPayment);
        order.setDeliveryStrategy(dhlDelivery);

        order.addItem(item1);
        order.addItem(item2);

        double expectedTotalPrice = item1.getPrice() + item2.getPrice() + dhlDelivery.getDeliverPrice();
        double actualTotalPrice = order.calculateTotalPrice();

        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice, 0.001);
    }

    @Test
    public void testProcessOrder() {
        order.setPaymentStrategy(creditCardPayment);
        order.setDeliveryStrategy(dhlDelivery);

        order.addItem(item1);
        order.addItem(item2);

        final StringBuilder stdout = new StringBuilder();
        System.setOut(new java.io.PrintStream(
                new java.io.OutputStream() {
                    public void write(int b) {
                        stdout.append((char) b);
                    }
                }
        ));

        order.processOrder();

        Assertions.assertTrue(stdout.toString().contains("Successfully delivered"));
        Assertions.assertTrue(order.getItems().isEmpty());

        stdout.setLength(0);
    }
}
