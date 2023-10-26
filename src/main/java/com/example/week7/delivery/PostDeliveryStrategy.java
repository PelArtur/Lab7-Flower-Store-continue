package com.example.week7.delivery;

import com.example.week7.flower.Item;
import lombok.Getter;

import java.util.List;

public class PostDeliveryStrategy implements Delivery{
    @Getter
    double deliverPrice;
    public PostDeliveryStrategy(){
        this.deliverPrice = 1;
    }

    public PostDeliveryStrategy(double deliverPrice){
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
