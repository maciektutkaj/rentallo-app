import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app/app.component';
import {CarsComponent} from './cars/cars.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from "@angular/common/http";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {TopBarComponent} from "./top-bar/top-bar.component";
import {NavigationBarComponent} from "./navigation-bar/navigation-bar.component";
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {ClientsComponent} from './clients/clients.component';
import {AboutComponent} from './about/about.component';
import {RentsHistoryComponent} from './rents-history/rents-history.component';
import {Route, RouterModule, Routes} from "@angular/router";
import {aboutUrl, carsUrl, clientsUrl, homePageUrl, myRentsHistoryUrl, notFoundPageUrl} from "../models/urls";
import {HomePageComponent} from './home-page/home-page.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {MatIconModule} from "@angular/material/icon";
import {MatInputModule} from "@angular/material/input";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatSortModule} from "@angular/material/sort";
import {ReactiveFormsModule} from "@angular/forms";

const routingTable: Routes = [
    {path: homePageUrl, component: HomePageComponent},
    {path: myRentsHistoryUrl, component: RentsHistoryComponent},
    {path: carsUrl, component: CarsComponent},
    {path: clientsUrl, component: ClientsComponent},
    {path: aboutUrl, component: AboutComponent},
    {path: notFoundPageUrl, component: NotFoundComponent}
  ]
@NgModule({
  declarations: [
    AppComponent,
    CarsComponent,
    TopBarComponent,
    NavigationBarComponent,
    ClientsComponent,
    AboutComponent,
    RentsHistoryComponent,
    HomePageComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatCardModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatIconModule,
    RouterModule.forRoot(routingTable),
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {
}
