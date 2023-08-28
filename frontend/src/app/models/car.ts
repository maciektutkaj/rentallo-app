export interface Pictures {
  mainPictureUrl: string,
  picturesUrls: Array<string>
}

//TODO: align with backend types
export interface Car {
  id: number,
  model: string,
  brand: string,
  fuelType: string,
  engineType: string,
  bodyType: string,
  numberOfSeats: number,
  trunkCapacityInLitres: number,
  combustionPer100km: string,
  pricePerDayInPolishGrosz: number,
  availability: boolean,
  rangeInKm: number,
  pictures: Pictures,


}
