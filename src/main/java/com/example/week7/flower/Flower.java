package com.example.week7.flower;

import lombok.Getter;
import lombok.Setter;

@Setter
public class Flower extends Item{
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter
    private double price;
    @Getter
    private FlowerType flowerType;

    public Flower(){
        sepalLength = FlowerType.TULIP.getSepalLength();
        color = FlowerType.TULIP.getColor();
        price = FlowerType.TULIP.getPrice();
        flowerType = FlowerType.TULIP;
    }

    public Flower(FlowerType flowerType){
        this.sepalLength = flowerType.getSepalLength();
        this.color = flowerType.getColor();
        this.price = flowerType.getPrice();
        this.flowerType = flowerType;
    }
    public Flower(Flower flower){
        this.price = flower.price;
        this.color = flower.color;
        this.sepalLength = flower.sepalLength;
        this.flowerType = flower.flowerType;
    }

    public String getColor() {
        return color.toString();
    }
}