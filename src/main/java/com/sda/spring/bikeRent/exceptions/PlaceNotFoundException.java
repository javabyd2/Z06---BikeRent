package com.sda.spring.bikeRent.exceptions;

public class PlaceNotFoundException extends RuntimeException {
    public PlaceNotFoundException(Long id) {super("Nie moge znalezc miejsca" +id);}
}
