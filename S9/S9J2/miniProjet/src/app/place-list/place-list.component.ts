import { Component, OnInit } from '@angular/core';
      
import { FormArray } from '@angular/forms';
import { Place } from '../models/place.model';
import { PlacesService } from '../services/places.service';
@Component({
  selector: 'app-place-list',
  templateUrl: './place-list.component.html',
  styleUrls: ['./place-list.component.css']
})
export class PlaceListComponent implements OnInit {
  places : Place[] = [];

  constructor(private placeService:PlacesService) { }

  ngOnInit() {
  
    this.getPlaces();

  }

  getPlaces():void{
    this.placeService.getPlaces().subscribe(places => this.places = places);
  }

}



