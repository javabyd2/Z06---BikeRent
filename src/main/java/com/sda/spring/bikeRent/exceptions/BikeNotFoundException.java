package com.sda.spring.bikeRent.exceptions;

public class BikeNotFoundException extends RuntimeException {
    public BikeNotFoundException(Long id) {super("Nie moge znalezc roweru: "+id);}


}
