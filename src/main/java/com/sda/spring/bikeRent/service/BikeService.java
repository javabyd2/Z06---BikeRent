package com.sda.spring.bikeRent.service;

import com.sda.spring.bikeRent.model.Bike;
import com.sda.spring.bikeRent.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {

    private BikeRepository bikeRepository;

    @Autowired
    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public Iterable<Bike> getBike(){
        return bikeRepository.findAll();
    }

    public Bike save(Bike bike){
        return bikeRepository.save(bike);
    }

}
