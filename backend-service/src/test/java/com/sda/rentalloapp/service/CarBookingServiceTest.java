package com.sda.rentalloapp.service;

import com.sda.rentalloapp.exception.WrongDateInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CarBookingServiceTest {

    @Autowired
    CarBookingService carBookingService;

    @Test
    void checkInjectionBean(){
        Assertions.assertNotNull(carBookingService,"Should not be null");
    }
    @Test
    void calculateFinalBookingPricePositiveCase() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);
        long pricePerDayInPolishGrosz = 10_000L;
        long calculatedPriceInPolishGrosz = carBookingService.calculateFinalBookingPrice(startDate,
                endDate,pricePerDayInPolishGrosz);
        Assertions.assertEquals(30_000, calculatedPriceInPolishGrosz);
    }
    @Test
    void calculateFinalBookingPriceWithWrongRange(){
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.minusDays(3);
        long pricePerDayInPolishGrosz = 10_000L;

        Assertions.assertThrows(WrongDateInputException.class, () -> carBookingService.calculateFinalBookingPrice(startDate,endDate,pricePerDayInPolishGrosz));
    }

    @Test
    void calculateFinalBookingPriceWithWrongRange_endDateEqualsStartDay(){
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(0);
        long pricePerDayInPolishGrosz = 10_000L;

        Assertions.assertThrows(WrongDateInputException.class, () -> carBookingService.calculateFinalBookingPrice(startDate,endDate,pricePerDayInPolishGrosz));
    }
}