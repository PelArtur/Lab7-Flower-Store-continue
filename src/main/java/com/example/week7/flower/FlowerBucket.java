package com.example.week7.flower;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket extends Item{
    private final List<FlowerPack> flowerPacks = new ArrayList<>();

    public void addFlowerPack(FlowerPack flowerPack){
        flowerPacks.add(flowerPack);
    }

    public double getPrice(){
        double price = 0;
        for(FlowerPack flowerPack : flowerPacks){
            price += flowerPack.getPrice();
        }
        return price;
    }
}