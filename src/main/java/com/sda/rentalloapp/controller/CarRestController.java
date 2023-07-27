package com.sda.rentalloapp.controller;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.dto.CarDto;
import com.sda.rentalloapp.mapper.CarMapper;
import com.sda.rentalloapp.service.CarService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class CarRestController {

    private final CarMapper carMapper;
    private final CarService carService;

    public CarRestController(CarMapper carMapper, CarService carService) {
        this.carMapper = carMapper;
        this.carService = carService;
    }
    @GetMapping("/cars")
     public List<CarDto> allCars(){
        log.info("all cars request");

        return carService.getAllCars()
                .stream()
                .map(car -> carMapper.fromEntityToDto(car))
                .toList();

    }
    @GetMapping("/cars/{id}")
    public CarDto getCarById(@PathVariable("id") Long carId){
     log.info("trying to find car with id: [{}]", carId);
     return carMapper.fromEntityToDto(carService.findCarById(carId));

    }
    @PostMapping("/cars")
    public void addCar(@RequestBody @Valid CarDto toSave){
        log.info("adding new car [{}]", toSave);
    }
}
