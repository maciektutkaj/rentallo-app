package com.sda.rentalloapp.controller;

import com.sda.rentalloapp.dto.CarBookingDto;
import com.sda.rentalloapp.dto.CarBookingRequestDto;
import com.sda.rentalloapp.service.CarBookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class CarBookingController {

    private final CarBookingService carBookingService;

    public CarBookingController(CarBookingService carBookingService) {
        this.carBookingService = carBookingService;
    }

    @PostMapping("/car-bookings")
    public CarBookingDto bookCar(@RequestBody CarBookingRequestDto bookingDto) {
        log.info("Car booking request: [{}]", bookingDto);
        carBookingService.bookCar(bookingDto);
        //TODO: finish implementation
        throw new RuntimeException("Not finished");
    }

}
