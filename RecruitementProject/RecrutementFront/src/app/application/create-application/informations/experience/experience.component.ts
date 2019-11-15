import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Diploma } from 'src/app/models/Diploma';
import { University } from 'src/app/models/university';


@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {

  ExperienceForm: FormGroup;
  @Output() experienceEvent = new EventEmitter(); 
  @Input() experienceFromParent : Diploma;
  @Input() identityError : string;
  @Input() universities : University [] ;


  constructor(private formBuilder: FormBuilder ) { }

  ngOnInit() {
  
    this.ExperienceForm = this.formBuilder.group({
      actuelPost: [this.experienceFromParent.actuelPost, [Validators.required]],
      formation : [this.experienceFromParent.formation, [Validators.required]],
      university: [this.experienceFromParent.university,[Validators.required]], 
    }) 

    
  }

  OnChanges() {
   
    this.experienceEvent.emit(this.ExperienceForm);
  }
  



}
