package com.sda.spring.bikeRent.service;

import com.sda.spring.bikeRent.model.Bike;
import com.sda.spring.bikeRent.model.Rent;
import com.sda.spring.bikeRent.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {

    private RentRepository rentRepository;

    @Autowired
    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public Rent save(Rent rent){
        return rentRepository.save(rent);
    }

    public List<Rent> getRents(){
        return rentRepository.findAll();
    }

    public Rent getRentById(Long id){return rentRepository.findById(id).get();}

    public void deleteRent(Long id){rentRepository.delete(getRentById(id));}

    public void editRent(Long id, Rent rent){
        Rent editingRent = new Rent();
        editingRent.setStartDate(editingRent.getStartDate());
        editingRent.setEndDate(editingRent.getEndDate());
        editingRent.setBike(editingRent.getBike());
        editingRent.setCity(editingRent.getCity());
        editingRent.setPrice(editingRent.getPrice());
    }



}
