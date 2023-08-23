package com.sda.rentalloapp.config;

import com.sda.rentalloapp.domain.Address;
import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.domain.Client;
import com.sda.rentalloapp.domain.Pictures;
import com.sda.rentalloapp.domain.enumeration.BodyType;
import com.sda.rentalloapp.domain.enumeration.EngineType;
import com.sda.rentalloapp.domain.enumeration.FuelType;
import com.sda.rentalloapp.repository.AddressRepository;
import com.sda.rentalloapp.repository.CarRepository;
import com.sda.rentalloapp.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
@Profile("develop")
public class DataInitializer implements CommandLineRunner {

    private final CarRepository carRepository;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    public DataInitializer(CarRepository carRepository, ClientRepository clientRepository, AddressRepository addressRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createCars();
        createClientsWithAddresses();


    }

    private void createClientsWithAddresses() {
        log.info("let's create some locations");

        Address miodowa = Address.builder()
                .street("Miodowa")
                .zipCode("24-100")
                .city("Pulawy")
                .houseNumber("1")
                .voivodeship("Lubelskie")
                .country("Poland")
                .build();
        addressRepository.save(miodowa);

        Address rozana = Address.builder()
                .street("Rozana")
                .zipCode("24-100")
                .city("Pulawy")
                .houseNumber("25")
                .voivodeship("Lubelskie")
                .country("Poland")
                .build();
        addressRepository.save(rozana);

        Address centralna = Address.builder()
                .street("Centralna")
                .zipCode("24-100")
                .city("Pulawy")
                .houseNumber("125")
                .voivodeship("Lubelskie")
                .country("Poland")
                .build();
        addressRepository.save(centralna);

        Address slowackiego = Address.builder()
                .street("Slowackeigo")
                .zipCode("24-100")
                .city("Pulawy")
                .houseNumber("75")
                .voivodeship("Lubelskie")
                .country("Poland")
                .build();
        addressRepository.save(slowackiego);

        Address cyprysowa = Address.builder()
                .street("Cyprysowa")
                .zipCode("24-100")
                .city("Pulawy")
                .houseNumber("2")
                .voivodeship("Lubelskie")
                .country("Poland")
                .build();
        addressRepository.save(cyprysowa);

        log.info("let's create some clients");

        Client janK = Client.builder()
                .name("Jan")
                .surname("K.")
                .pesel("89120405935")
                .email("jan.k@ex.com")
                .dateOfBirth(LocalDate.of(1989,12,4))
                .phone("555-123-789")
                .address(miodowa)
                .build();
        clientRepository.save(janK);

        Client tomaszB = Client.builder()
                .name("Tomasz")
                .surname("B.")
                .pesel("99011103625")
                .email("tomasz.b@ex.com")
                .dateOfBirth(LocalDate.of(1999,1,11))
                .phone("565-623-689")
                .address(centralna)
                .build();
        clientRepository.save(tomaszB);

        Client annaN = Client.builder()
                .name("Anna")
                .surname("N.")
                .pesel("93061412721")
                .email("anna.n@ex.com")
                .dateOfBirth(LocalDate.of(1993,6,14))
                .phone("535-173-759")
                .address(cyprysowa)
                .build();
        clientRepository.save(annaN);

        Client zofiaW = Client.builder()
                .name("Zofia")
                .surname("W.")
                .pesel("61052116941")
                .email("zofia.w@ex.com")
                .dateOfBirth(LocalDate.of(1961,5,21))
                .phone("551-121-719")
                .address(slowackiego)
                .build();
        clientRepository.save(zofiaW);

        Client jacekM = Client.builder()
                .name("Jacek")
                .surname("M.")
                .pesel("73081905952")
                .email("jacek.m@ex.com")
                .dateOfBirth(LocalDate.of(1973,8,19))
                .phone("651-621-716")
                .address(rozana)
                .build();
        clientRepository.save(jacekM);


    }


    private void createCars() {
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
                .vin("78358763544")
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
