import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Candidat } from '../models/Candidat';
import { Observable, of } from 'rxjs';





@Injectable({ providedIn: 'root' })
export class SearchService {

  
  constructor(private http: HttpClient) { }
  private candidatToDisplay;

getCandidatToDisplay():Observable<Candidat>{

  return of(this.candidatToDisplay);

}

setCandidatToDisplay(candidat:Candidat){


   this.candidatToDisplay=candidat;

}

  searchCandidate(searchCriteria: string) {
    return this.http.get<Candidat[]>(`http://localhost:8080/candidates?search=${searchCriteria}`);
  }

  getAllCandidats(){

    return this.http.get<Candidat[]>('http://localhost:8080/candidates/all');



  }




}





