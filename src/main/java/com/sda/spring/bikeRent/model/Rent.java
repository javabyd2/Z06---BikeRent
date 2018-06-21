package com.sda.spring.bikeRent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp startDate;
    private Timestamp endDate;
    private double price;

    @Enumerated(EnumType.STRING)
    private City city;


    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name = "bike_id",nullable = false)
    private Bike bike;
}
