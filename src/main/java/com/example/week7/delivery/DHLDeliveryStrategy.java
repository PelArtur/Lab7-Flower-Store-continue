package com.example.week7.delivery;

import com.example.week7.flower.Item;
import lombok.Getter;

import java.util.List;

public class DHLDeliveryStrategy implements Delivery{
    @Getter
    double deliverPrice;

    public DHLDeliveryStrategy(){
        this.deliverPrice = 1;
    }

    public DHLDeliveryStrategy(double deliverPrice){
        this.deliverPrice = deliverPrice;
    }

    @Override
    public void deliver(List<Item> items) {
        System.out.println("Items:");
        for(Item item : items){
            System.out.println(item.toString());
        }
        System.out.println("Successfully delivered");
    }
}
