package com.sda.spring.bikeRent.model;

import javax.persistence.*;

@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bikeName;

    @ManyToOne (cascade = CascadeType.MERGE)
    private BikeType bikeType;

    public Bike() {
    }

    public Bike(String bikeName, BikeType bikeType) {
        this.bikeName = bikeName;
        this.bikeType = bikeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

}
