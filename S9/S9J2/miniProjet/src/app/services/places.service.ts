import { Injectable } from '@angular/core';
import { Place } from '../models/place.model';
import { Observable, of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PlacesService {


places : Place[] =[];

addPlace(place :Place):void{
this.places.push(place)
  
  }

  getPlaces():Observable<Place[]>{
    return of(this.places)
  }

  

  

}

