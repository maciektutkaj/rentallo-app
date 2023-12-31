package com.sda.rentalloapp.mapper;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.dto.CarDto;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements Mapper<Car, CarDto>{

    private final PicturesMapper picturesMapper;

    public CarMapper(PicturesMapper picturesMapper) {
        this.picturesMapper = picturesMapper;
    }

    @Override
    public CarDto fromEntityToDto(Car entity) {
        return CarDto.builder()
                .id(entity.getId())
                .model(entity.getModel())
                .brand(entity.getBrand())
                .fuelType(entity.getFuelType())
                .engineType(entity.getEngineType())
                .bodyType(entity.getBodyType())
                .numberOfSeats(entity.getNumberOfSeats())
                .trunkCapacityInLitres(entity.getTrunkCapacityInLitres())
                .consumptionPer100km(entity.getConsumptionPer100km())
                .vin(entity.getVin())
                .pricePerDayInPolishGrosz(entity.getPricePerDayInPolishGrosz())
                .availability(entity.isAvailability())
                .rangeInKm(entity.getRangeInKm())
                .pictures(picturesMapper.fromEntityToDto(entity.getPictures()))
                .build();
    }

    @Override
    public Car fromDtoToEntity(CarDto dto) {
        return Car.builder()
                .id(dto.id())
                .model(dto.model())
                .brand(dto.brand())
                .fuelType(dto.fuelType())
                .engineType(dto.engineType())
                .bodyType(dto.bodyType())
                .numberOfSeats(dto.numberOfSeats())
                .trunkCapacityInLitres(dto.trunkCapacityInLitres())
                .consumptionPer100km(dto.consumptionPer100km())
                .vin(dto.vin())
                .pricePerDayInPolishGrosz(dto.pricePerDayInPolishGrosz())
                .availability(dto.availability())
                .rangeInKm(dto.rangeInKm())
                .pictures(picturesMapper.fromDtoToEntity(dto.pictures()))
                .build();
    }
}
