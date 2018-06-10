package com.sda.spring.bikeRent.repository;

import com.sda.spring.bikeRent.model.Bike;
import org.springframework.data.repository.CrudRepository;

public interface BikeRepository extends CrudRepository<Bike,Long> {
}
