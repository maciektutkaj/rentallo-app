package com.sda.rentalloapp.domain;

import com.sda.rentalloapp.domain.enumeration.BodyType;
import com.sda.rentalloapp.domain.enumeration.EngineType;
import com.sda.rentalloapp.domain.enumeration.FuelType;
import lombok.Data;

@Data
public class Car {
    String model;
    String brand;
    FuelType fuelType;
    EngineType engineType;
    BodyType bodyType;
    int numberOfSeats;
    int trunkCapacityInLitres;
    String consumptionPer100km;
    String vin;
    int pricePerDayInPolishGrosz;
    boolean availability;
    int rangeInKm;
    Pictures pictures;

}
