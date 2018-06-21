package com.sda.spring.bikeRent.repository;

import com.sda.spring.bikeRent.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent,Long> {
}
