import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import {University} from '../models/university'
@Injectable({
  providedIn: 'root'
})
export class UniversityServiceService {

  constructor(private http: HttpClient) { }



  getUniversities (): Observable<any> {

    return this.http.get <University> (`http://localhost:8080/university`)
  
   }

}
