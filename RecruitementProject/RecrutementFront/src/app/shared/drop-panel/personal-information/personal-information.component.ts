import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { PersonalInformation } from '../../models/PersonalInformation';

@Component({
  selector: 'app-personal-information',
  templateUrl: './personal-information.component.html',
  styleUrls: ['./personal-information.component.css']
})
export class PersonalInformationComponent implements OnInit {

  personalInformationForm = this.fb.group({
    civility :[''],
    firstName:['',Validators.required],
    lastName:['',Validators.required],
    phone:[],
    email:['',Validators.email]
  });

  constructor(private fb:FormBuilder) { }

  ngOnInit() {
  }
  
  @Output() changes = new EventEmitter<{pi:PersonalInformation,errorNumber:Number}>();
  



  formChange(){
    let errNumber=0;
    if(this.personalInformationForm.get('civility').invalid) errNumber++;
    if(this.personalInformationForm.get('firstName').invalid) errNumber++;
    if(this.personalInformationForm.get('lastName').invalid) errNumber++;
    if(this.personalInformationForm.get('phone').invalid) errNumber++;
    if(this.personalInformationForm.get('email').invalid) errNumber++;

    this.changes.emit({pi:this.personalInformationForm.value,errorNumber:errNumber})

  }

}
