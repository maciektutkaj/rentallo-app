package com.sda.rentalloapp.domain;

import com.sda.rentalloapp.domain.enumeration.BodyType;
import com.sda.rentalloapp.domain.enumeration.EngineType;
import com.sda.rentalloapp.domain.enumeration.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String model;

    String brand;

    @Enumerated(EnumType.STRING)
    FuelType fuelType;

    @Enumerated(EnumType.STRING)
    EngineType engineType;

    @Enumerated(EnumType.STRING)
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
