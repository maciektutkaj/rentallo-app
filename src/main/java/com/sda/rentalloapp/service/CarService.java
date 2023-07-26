package com.sda.rentalloapp.service;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.exception.WrongCarIdException;
import com.sda.rentalloapp.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        log.info("getting all cars");
         var cars = carRepository.findAll();

         log.info("number of cars: [{}]", cars.size());
         log.debug("all cars {}", cars);
         return cars;
    }

    public Car findCarById(Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new WrongCarIdException("No car with id: " + carId));
    }
}
