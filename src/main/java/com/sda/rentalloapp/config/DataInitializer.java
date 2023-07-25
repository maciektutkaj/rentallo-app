package com.sda.rentalloapp.config;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.domain.Pictures;
import com.sda.rentalloapp.domain.enumeration.BodyType;
import com.sda.rentalloapp.domain.enumeration.EngineType;
import com.sda.rentalloapp.domain.enumeration.FuelType;
import com.sda.rentalloapp.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@Profile("develop")
public class DataInitializer implements CommandLineRunner {

    private final CarRepository carRepository;

    public DataInitializer(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("let's create some cars");
        Car audi = Car.builder()
                .model("A6")
                .brand("Audi")
                .fuelType(FuelType.OIL)
                .engineType(EngineType.V6)
                .bodyType(BodyType.SEDAN)
                .numberOfSeats(5)
                .trunkCapacityInLitres(500)
                .consumptionPer100km("8.0/100")
                .vin("123654789654")
                .pricePerDayInPolishGrosz(25000)
                .availability(true)
                .rangeInKm(800)
                .pictures(new Pictures("https://www.tuningblog.eu/wp-content/uploads/2017/01/Audi-A6-C7-Limousine-af-Vossen-Wheels-VFS-2-Felgen-Tuning-3.jpg", List.of()))
                .build();

        carRepository.save(audi);
    }

}
