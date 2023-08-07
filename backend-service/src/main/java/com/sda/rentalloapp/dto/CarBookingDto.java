package com.sda.rentalloapp.dto;

import com.sda.rentalloapp.domain.Address;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CarBookingDto(
        Long id,
        CarDto car,
        ClientDto client,
        LocalDate startDate,
        LocalDate endDate,
        int totalPriceInPolishGrosz,
        AddressDto startLocation,
        AddressDto endLocation,
        LocalDateTime creationTimestamp,
        LocalDateTime updateTimestamp

) {
}
