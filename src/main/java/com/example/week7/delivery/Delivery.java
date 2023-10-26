package com.example.week7.delivery;

import com.example.week7.flower.Item;

import java.util.List;

public interface Delivery {
    void deliver(List<Item> items);
    double deliverPrice = 0;
    double getDeliverPrice();
}
