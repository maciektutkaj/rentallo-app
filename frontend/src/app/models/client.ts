import {Address} from "./address";

export interface Client {
  id:number;
  name:string;
  surname:string;
  pesel:string;
  email:string;
  dateOfBirth:string;
  phone:string;
  //TODO:change name
  addressDto: Address;
  accountCreated:string
}
