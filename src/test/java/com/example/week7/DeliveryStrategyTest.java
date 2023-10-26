package com.example.week7;

import com.example.week7.delivery.*;
import com.example.week7.flower.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class DeliveryStrategyTest {

    private Delivery dhlDelivery;
    private Delivery postDelivery;
    private List<Item> items;

    @BeforeEach
    public void setUp() {
        dhlDelivery = new DHLDeliveryStrategy();
        postDelivery = new PostDeliveryStrategy();
        items = new ArrayList<>();
        items.add(new Flower(FlowerType.ROSE));
        items.add(new Flower(FlowerType.TULIP));
    }

    @Test
    public void testDeliverPrice() {
        Assertions.assertEquals(1.0, dhlDelivery.getDeliverPrice(), 0.001);
        Assertions.assertEquals(1.0, postDelivery.getDeliverPrice(), 0.001);
    }

    @Test
    public void testDeliver() {
        final StringBuilder stdout = new StringBuilder();
        System.setOut(new java.io.PrintStream(
                new java.io.OutputStream() {
                    public void write(int b) {
                        stdout.append((char) b);
                    }
                }
        ));

        dhlDelivery.deliver(items);
        Assertions.assertTrue(stdout.toString().contains("Items:"));
        Assertions.assertTrue(stdout.toString().contains("Successfully delivered"));

        stdout.setLength(0);

        postDelivery.deliver(items);
        Assertions.assertTrue(stdout.toString().contains("Items:"));
        Assertions.assertTrue(stdout.toString().contains("Successfully delivered"));
    }
}
