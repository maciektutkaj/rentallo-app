import {Component, OnInit} from '@angular/core';
import {CarService} from "../../services/car/car.service";
import {Car} from "../../models/car";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: Array<Car> = []
  carForm = new FormGroup({
    id:new FormControl(null),
    model:new FormControl(''),
    brand: new FormControl(''),
    fuelType: new FormControl(''),
    engineType: new FormControl(''),
    bodyType: new FormControl(''),
    numberOfSeat: new FormControl(4),
    trunkCapacityInLitres: new FormControl(200),
    combustionPer100km: new FormControl(''),
    pricePerDayInPolishGrosz: new FormControl(0),
    availability: new FormControl(true),
    rangeInKm: new FormControl(300),
    pictures: new FormGroup({
      mainPictureUrl: new FormControl(''),
      picturesUrl: new FormControl(Array<string>)
    }),
  })

  value: any;
  get pictures(){
    return this.carForm.controls.pictures.controls.mainPictureUrl
  }
  get rangeInKm(){
    return this.carForm.controls.rangeInKm
  }

  get availability(){
    return this.carForm.controls.availability
  }
  get pricePerDayInPolishGrosz(){
    return this.carForm.controls.pricePerDayInPolishGrosz
}
  get combustionPer100km(){
    return this.carForm.controls.combustionPer100km
  }
  get trunkCapacityInLitres(){
    return this.carForm.controls.trunkCapacityInLitres
  }

  get numberOfSeat(){
    return this.carForm.controls.numberOfSeat
  }
  get bodyType(){
    return this.carForm.controls.bodyType
  }
  get engineType(){
    return this.carForm.controls.engineType
  }

  get fuelType(){
    return this.carForm.controls.fuelType
  }
  get brand(){
    return this.carForm.controls.brand
  }

  get model() {
    return this.carForm.controls.model
  }

  constructor(private carService: CarService) {
  }

  ngOnInit(): void {
    this.carService
      .getCars()
      .subscribe(carsFromServer => {
        console.log("data from server: " + JSON.stringify(carsFromServer, null, 2))
        this.cars = carsFromServer
      })
  }

  sendCar() {
    console.log("data submitted")
    this.value = this.carForm.value
    //this.carService.sendCar(this.carForm.value as Car)
  }

}
