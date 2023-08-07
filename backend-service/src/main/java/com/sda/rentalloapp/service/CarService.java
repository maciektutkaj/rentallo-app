package com.sda.rentalloapp.service;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.dto.CarDto;
import com.sda.rentalloapp.exception.WrongCarIdException;
import com.sda.rentalloapp.repository.CarRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
                .map(car -> {
                    log.info("found car: [{}]",car);
                    return car;
                })
                .orElseThrow(() -> new WrongCarIdException("No car with id: " + carId));
    }

    public Car addCar(Car car) {
        Car saved = carRepository.save(car);
        log.info("saved car [{}]" , saved);
        return saved;
    }

    @Transactional
    public void deleteCarById(Long carId) {
        log.info("delete car by id[{}]",carId);
        boolean exist = carRepository.existsById(carId);
        if(exist) {
            carRepository.deleteById(carId);
        } else {
            throw new WrongCarIdException("Wrong id: " + carId);
        }

    }

    @Transactional
    public Car replaceCar(Long carId, Car entityToReplace) {
        log.info("replacing car with id [{}] with content [{}]", carId, entityToReplace);
        boolean exist = carRepository.existsById(carId);

        if(!exist){
            throw new WrongCarIdException("Wrong car id: " + carId);
        }
        if(!carId.equals(entityToReplace.getId())){
            throw new WrongCarIdException("Ids mismatch: [%d] vs [%d]".formatted(carId, entityToReplace.getId()));
        }

        return carRepository.save(entityToReplace);
    }
}
