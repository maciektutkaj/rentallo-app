package com.sda.rentalloapp.domain;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
public class CarBooking {

    Car bookedCar;
    Client client;
    LocalDate startDate;
    LocalDate endDate;
    int totalPriceInPolishGrosz;
    Address startLocation;
    Address endLocation;

}
