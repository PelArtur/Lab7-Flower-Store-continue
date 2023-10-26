package com.example.week7;

import com.example.week7.delivery.DHLDeliveryStrategy;
import com.example.week7.delivery.PostDeliveryStrategy;
import com.example.week7.flower.Flower;
import com.example.week7.payments.CreditCardPaymentStrategy;
import com.example.week7.payments.PayPalPaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlowerController {
    private  final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService){
        this.flowerService = flowerService;
    }

    @GetMapping("/flower/")
    public List<Flower> getFlowers() {
        return flowerService.getFlowers();
    }

    @GetMapping("/paypal/")
    public List<PayPalPaymentStrategy> getPaypal() {
        return flowerService.getPayPal();
    }

    @GetMapping("/credit/")
    public List<CreditCardPaymentStrategy> getCreditCard() {
        return flowerService.getCreditCard();
    }

    @GetMapping("/dhl/")
    public List<DHLDeliveryStrategy> getDHL() {
        return flowerService.getDHL();
    }

    @GetMapping("/postdelivery/")
    public List<PostDeliveryStrategy> getPostDelivery() {
        return flowerService.getPostDelivery();
    }
}
