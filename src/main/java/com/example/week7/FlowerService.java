package com.example.week7;

import java.util.List;

import com.example.week7.flower.Flower;
import com.example.week7.flower.FlowerType;
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
}