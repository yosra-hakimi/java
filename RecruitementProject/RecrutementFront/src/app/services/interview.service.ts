import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Interview } from '../models/Interview';
import { Application } from '../models/Application';
import { Candidat } from '../models/Candidat';
@Injectable()
export class InterviewService {
  [x: string]: any;
  httpClient: any;
  constructor(private http: HttpClient) { }

  baseUrl = 'http://localhost:8080';

  getInterviewsByCandidateMail(mail: string) {
    return this.http.get<Application>(`${this.baseUrl}/applications/${mail}/interviews`);
  }

  saveInterview(data) {
    return this.http.post(`${this.baseUrl}/interviews`, data);
  }

  removeInterview(id) {
    return this.http.delete(`${this.baseUrl}/interviews/${id}`);
  }

  updateInterview(id, data) {
    return this.http.post(`${this.baseUrl}/interviews/${id}`, data);
  }

 /* getInterviewsByUser(mail: String) {

    return this.http.get<Application[]>('http://localhost:8080/applications/interviews/' + mail);
  }*/
  getInterviewsByUser(mail: String) {

    return this.http.get<Candidat[]>('http://localhost:8080/candidates/applications/interviews/' + mail);
  }

  getAllInterviews() {
    return this.http.get<Interview[]>(`http://localhost:8080/interviews`);
  }

  //Get All Evaluations
  getAllEvaluations() {
    return this.http.get('http://localhost:8080/evaluations');
  }

  // Add EvaluationToAnInterview
  updateEvaluation(app: Candidat) {
    return this.http.post('http://localhost:8080/candidates/evaluation', app);
  }

  updatePropal(app:Candidat){
    
    return this.http.post('http://localhost:8080/candidates/propal', app);
  }
 
}
