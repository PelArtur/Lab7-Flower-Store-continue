package com.example.week7;

import com.example.week7.flower.*;
import com.example.week7.delivery.*;
import com.example.week7.payments.*;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Item> items = new ArrayList<>();;
    private Payment payment;
    private Delivery delivery;

    public void setPaymentStrategy(Payment payment){
        this.payment = payment;
    }
    public void setDeliveryStrategy(Delivery delivery){
        this.delivery = delivery;
    }
    public double calculateTotalPrice(){
        double totalPrice = 0;
        for(Item item : items){
            totalPrice += item.getPrice();
        }
        if (delivery != null) {
            totalPrice += delivery.getDeliverPrice();
        }
        return totalPrice;
    }
    public void processOrder(){
        if (payment == null){
            System.out.println("Please choose payment method");
            return;
        }
        if (delivery == null){
            System.out.println("Please choose delivery method");
            return;
        }
        if(payment.pay(calculateTotalPrice())){
            delivery.deliver(items);
            items.clear();
        }
    }
    public void addItem(Item item){
        this.items.add(item);
        System.out.println(item.toString() + " successfully added to list");
    }
    public void removeItem(Item item){
        this.items.remove(item);
    }

}
