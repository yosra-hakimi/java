import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { PersonalInformation } from '../../models/PersonalInformation';

@Component({
  selector: 'app-contact-information',
  templateUrl: './contact-information.component.html',
  styleUrls: ['./contact-information.component.css']
})
export class ContactInformationComponent implements OnInit {

  constructor(private fb:FormBuilder) { }

  @Output() changes = new EventEmitter<{pi:PersonalInformation,errorNumber:Number}>();

  ngOnInit() {
  }
  contactForm = this.fb.group({
    civility :[''],
    firstName:['',Validators.required],
    lastName:['',Validators.required],
    phone:[],
    email:['',Validators.email],
    dateOfBirth:[]
  });

  formChange(){
    let errNumber=0;
    if(this.contactForm.get('civility').invalid) errNumber++;
    if(this.contactForm.get('firstName').invalid) errNumber++;
    if(this.contactForm.get('lastName').invalid) errNumber++;
    if(this.contactForm.get('phone').invalid) errNumber++;
    if(this.contactForm.get('email').invalid) errNumber++;

    this.changes.emit({pi:this.contactForm.value,errorNumber:errNumber})

  }

}
