import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlaceListComponent } from './place-list/place-list.component';
import { PlaceFormComponent } from './place-list/place-form/place-form.component';
import { HeaderComponent } from './header/header.component';
import { PlacesService } from './services/places.service';
import {FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {  RouterModule,Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { MaterialModule } from './material/material.module';




const appRoutes : Routes = [
  {path:'places',component:PlaceListComponent},
  {path:'place/new',component:PlaceFormComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    PlaceListComponent,
    PlaceFormComponent,
    HeaderComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,  
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    MatButtonModule,
    MaterialModule
   
  ],
  providers: [
    PlacesService
  ],
  bootstrap: [AppComponent],
  entryComponents : [PlaceFormComponent]
})
export class AppModule { }


