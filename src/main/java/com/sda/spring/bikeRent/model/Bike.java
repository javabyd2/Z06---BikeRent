package com.sda.spring.bikeRent.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bikeName;

    @Enumerated(EnumType.STRING)
    private BikeType bikeType;

    public Bike() {
    }

    public Bike(String bikeName, BikeType bikeType) {
        this.bikeName = bikeName;
        this.bikeType = bikeType;
    }

}
