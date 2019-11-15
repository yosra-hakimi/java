import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { InterviewService } from '../services/interview.service';
import { AuthService } from '../services/auth.service';
import { Interview } from '../models/Interview';
import { Application } from '../models/Application';
import { User } from '../models/User';
import { Candidat } from '../models/Candidat';
import { Router } from '@angular/router';


@Component({
  selector: 'app-evaluation',
  templateUrl: './evaluation.component.html',
  styleUrls: ['./evaluation.component.css']
})
export class EvaluationComponent implements OnInit {


  applications: Application[] = [];
  users: User[] = [];
  candidates : Candidat[]=[];
  interviews: Interview[];

  constructor(private interviewService: InterviewService, private authService: AuthService, private formBuilder: FormBuilder,private route:Router) { }

  ngOnInit() {

    this.getInterviewsByUser();
  }
  //Get interview By Connected User
  getInterviewsByUser() {
    this.interviewService.getInterviewsByUser(this.authService.mail).subscribe(data => {
      data.forEach(candidates => {

        candidates.application.interview.forEach(inter=>{
          if(!inter.statut) inter.statut ="En cours";
        })
        this.candidates.push(candidates)
        
      })})
  } 
 
  toggleAppearence(i: number, k: number) {
    this.candidates[i].application.interview[k].showInterview = ! this.candidates[i].application.interview[k].showInterview;
  }

  updateEvaluationInterview(i: number, k: number) {


    if(this.candidates[i].application.interview[k].interviewType=='Propal'){
      this.candidates[i].statut="accepted";
      this.candidates[i].application.nextStep="accepted";
      this.interviewService.updatePropal(this.candidates[i]).subscribe(data =>
        console.log(data))
    }else{
      this.candidates[i].statut="interviewEvaluated";
      this.candidates[i].application.nextStep="boEval";
    this.interviewService.updateEvaluation(this.candidates[i]).subscribe(data =>{
      this.route.navigate(['/recrutement/accueil']);
      });}

}   
rejeter(i,k){

  if(this.candidates[i].application.interview[k].interviewType=='Propal'){
    this.candidates[i].statut="rejected";
    this.candidates[i].application.nextStep="rejected";
    this.interviewService.updatePropal(this.candidates[i]).subscribe(data =>
      console.log(data))
  }else{
    this.candidates[i].statut="rejected";
    this.candidates[i].application.nextStep="rejected";
  this.interviewService.updateEvaluation(this.candidates[i]).subscribe(data =>
    {
    console.log(data)
    this.route.navigate(['/recrutement/accueil']);

    }
    );}

}
  
}