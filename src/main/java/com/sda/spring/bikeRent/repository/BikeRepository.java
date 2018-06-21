package com.sda.spring.bikeRent.repository;

import com.sda.spring.bikeRent.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike,Long> {
}
