import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { Candidat} from '../models/Candidat';


@Injectable({
  providedIn: 'root'
})
export class CandidatServiceService {

nationality : string[] ;

  constructor(private http: HttpClient ) { 

   
    };




  createCandidat(candidat : Candidat) {
    return this.http.post <Candidat>('http://localhost:8080/candidates',  candidat ,{observe: 'response'});
    
  }


  updateCandidat(candidat : Candidat) {
    return this.http.post <Candidat>('http://localhost:8080/candidates/update',  candidat );
    
  }

 getCandidateByMail (mail :string): Observable<any> {

  return this.http.get <Candidat> (`http://localhost:8080/candidates/${mail}`)

 }

 hrEvaluation(candidat: Candidat){
  return this.http.post <Candidat>('http://localhost:8080/candidates/bo/status/update',  candidat );
 }



}
