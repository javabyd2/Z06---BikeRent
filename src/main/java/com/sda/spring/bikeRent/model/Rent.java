package com.sda.spring.bikeRent.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date startDate;
    private Date endDate;
    private double price;

    @Enumerated(EnumType.STRING)
    private City city;


    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name = "bike_id",nullable = false)
    private Bike bike;
}
