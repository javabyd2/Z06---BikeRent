package com.sda.spring.bikeRent.service;

import com.sda.spring.bikeRent.model.Bike;
import com.sda.spring.bikeRent.model.Rent;
import com.sda.spring.bikeRent.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService {

    private RentRepository rentRepository;

    @Autowired
    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public Iterable<Rent> getRent(){
        return rentRepository.findAll();
    }

    public Rent save(Rent rent){
        return rentRepository.save(rent);
    }
}
