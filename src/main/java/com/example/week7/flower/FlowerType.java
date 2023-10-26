package com.example.week7.flower;

import lombok.Getter;

public enum FlowerType {
    CHAMOMILE(9.5, FlowerColor.WHITE, 2.79),
    ROSE(13.1, FlowerColor.RED, 4.99),
    TULIP(12.5, FlowerColor.YELLOW, 1.99);

    @Getter
    private final double sepalLength;
    @Getter
    private final FlowerColor color;
    @Getter
    private final double price;

    FlowerType(double sepalLength, FlowerColor color, double price) {
        this.sepalLength = sepalLength;
        this.color = color;
        this.price = price;
    }
}
