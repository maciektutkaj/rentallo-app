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

        Car mercedes = Car.builder()
                .model("X")
                .brand("Mercedes-Benz")
                .fuelType(FuelType.OIL)
                .engineType(EngineType.V8)
                .bodyType(BodyType.PICKUP)
                .numberOfSeats(5)
                .trunkCapacityInLitres(1000)
                .consumptionPer100km("10.0/100")
                .vin("455654789654")
                .pricePerDayInPolishGrosz(30000)
                .availability(true)
                .rangeInKm(700)
                .pictures(new Pictures("https://www.autocentrum.pl/OWYzLmpwYDY4GDpeXwxtIntAbkIRFGIxMBYpQhMWPXovHz4eGRgheGwZKFREFioyOk14D0NCfDZpGX4MRU4pZHcQPApSCg", List.of()))
                .build();

        Car ford = Car.builder()
                .model("Mondeo")
                .brand("Ford")
                .fuelType(FuelType.GAS)
                .engineType(EngineType.R4)
                .bodyType(BodyType.COMBI)
                .numberOfSeats(5)
                .trunkCapacityInLitres(537)
                .consumptionPer100km("7.0/100")
                .vin("785654123254")
                .pricePerDayInPolishGrosz(18000)
                .availability(true)
                .rangeInKm(880)
                .pictures(new Pictures("https://comfortcar.pl/images/thumbnails/765/408/detailed/2/3913971782.webp", List.of()))
                .build();

        Car fiat = Car.builder()
                .model("500")
                .brand("Fiat")
                .fuelType(FuelType.GAS)
                .engineType(EngineType.R4)
                .bodyType(BodyType.HATCHBACK)
                .numberOfSeats(4)
                .trunkCapacityInLitres(185)
                .consumptionPer100km("6.0/100")
                .vin("53218762254")
                .pricePerDayInPolishGrosz(12000)
                .availability(true)
                .rangeInKm(580)
                .pictures(new Pictures("https://ocdn.eu/pulscms-transforms/1/68lk9kpTURBXy83ZjkyODhjM2Y0NGQ3ZjFlYjI5NGI3NWE2ZmJiMTdiZi5qcGeSlQMIN80Dy80CI5MFzQSwzQKk3gACoTABoTEA", List.of()))
                .build();

        Car bmw = Car.builder()
                .model("X5")
                .brand("BMW")
                .fuelType(FuelType.HYBRID)
                .engineType(EngineType.ELECTRIC_MOTOR)
                .bodyType(BodyType.SUV)
                .numberOfSeats(5)
                .trunkCapacityInLitres(650)
                .consumptionPer100km("12.0/100")
                .vin("7818763544")
                .pricePerDayInPolishGrosz(40000)
                .availability(true)
                .rangeInKm(758)
                .pictures(new Pictures("https://media.autoweek.nl/m/t9lytakbwzub_800.jpg", List.of()))
                .build();

        Car tesla = Car.builder()
                .model("3")
                .brand("Tesla")
                .fuelType(FuelType.ELECTRIC)
                .engineType(EngineType.ELECTRIC_MOTOR)
                .bodyType(BodyType.SEDAN)
                .numberOfSeats(5)
                .trunkCapacityInLitres(425)
                .consumptionPer100km("21 kWh")
                .vin("7818763544")
                .pricePerDayInPolishGrosz(30000)
                .availability(true)
                .rangeInKm(490)
                .pictures(new Pictures("https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/2019_Tesla_Model_3_Performance_AWD_Front.jpg/640px-2019_Tesla_Model_3_Performance_AWD_Front.jpg", List.of()))
                .build();



        carRepository.save(audi);
        carRepository.save(mercedes);
        carRepository.save(ford);
        carRepository.save(fiat);
        carRepository.save(bmw);
        carRepository.save(tesla);


    }

}
