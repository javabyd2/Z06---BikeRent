package com.sda.spring.bikeRent.repository;

import com.sda.spring.bikeRent.model.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent,Long> {
}
