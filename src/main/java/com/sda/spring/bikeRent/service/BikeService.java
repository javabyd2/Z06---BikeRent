package com.sda.spring.bikeRent.service;

import com.sda.spring.bikeRent.model.Bike;
import com.sda.spring.bikeRent.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    private BikeRepository bikeRepository;

    @Autowired
    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public Bike save(Bike bike){
        return bikeRepository.save(bike);
    }

    public List<Bike> getBike(){
        return bikeRepository.findAll();
    }

    public Bike getBikeById(Long id){
        return bikeRepository.findById(id).get();
    }

    public void deleteBike(Long id){
        bikeRepository.delete(getBikeById(id));
    }

    public void editBike(Long id, Bike bike){
        Bike editingBike = new Bike();
        editingBike.setBikeName(editingBike.getBikeName());
        editingBike.setBikeType(editingBike.getBikeType());
        save(editingBike);
    }


}
