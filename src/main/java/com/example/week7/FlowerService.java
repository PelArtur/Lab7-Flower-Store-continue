package com.example.week7;

import java.util.List;

import com.example.week7.delivery.DHLDeliveryStrategy;
import com.example.week7.delivery.PostDeliveryStrategy;
import com.example.week7.flower.Flower;
import com.example.week7.flower.FlowerType;
import com.example.week7.payments.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
public class FlowerService {
//    private final FlowerRepository flowerRepository;
//
//    @Autowired
//    public FlowerService(FlowerRepository flowerRepository) {
//        this.flowerRepository = flowerRepository;
//    }

    public List<Flower> getFlowers() {
        return List.of(new Flower(FlowerType.ROSE));
    }

    public List<PayPalPaymentStrategy> getPayPal() {
        return List.of(new PayPalPaymentStrategy(100));
    }

    public List<CreditCardPaymentStrategy> getCreditCard() {
        return List.of(new CreditCardPaymentStrategy(100));
    }

    public List<PostDeliveryStrategy> getPostDelivery() {
        return List.of(new PostDeliveryStrategy(5));
    }

    public List<DHLDeliveryStrategy> getDHL() {
        return List.of(new DHLDeliveryStrategy(5));
    }
}