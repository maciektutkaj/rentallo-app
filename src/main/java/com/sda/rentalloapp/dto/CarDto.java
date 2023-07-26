package com.sda.rentalloapp.dto;

import com.sda.rentalloapp.domain.enumeration.BodyType;
import com.sda.rentalloapp.domain.enumeration.EngineType;
import com.sda.rentalloapp.domain.enumeration.FuelType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CarDto(
        Long id,
        @NotNull
        @Size(min = 2)
        String model,
        @NotNull
        @Size(min = 2)
        String brand,
        FuelType fuelType,
        EngineType engineType,
        BodyType bodyType,
        int numberOfSeats,

        int trunkCapacityInLitres,

        String consumptionPer100km,

        String vin,

        int pricePerDayInPolishGrosz,

        boolean availability,

        int rangeInKm,

        @NotNull
        PicturesDto pictures
        )
{}

