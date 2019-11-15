import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Interview } from 'src/app/models/Interview';

@Component({
  selector: 'app-update-interview',
  templateUrl: './update-interview.component.html',
  styleUrls: ['./update-interview.component.css']
})
export class UpdateInterviewComponent implements OnInit {

 
  appear:boolean =false;
  appearInterview:boolean=true;
  appearPropal:boolean=false;
  enableInterview:boolean=true;
  
  enablePropal:boolean=false;
  @Input() interviewsParent:Interview[];
  @Output() changes = new EventEmitter();
  @Output() interviewForm = new EventEmitter();
  private interviews:Interview[]=[];
   
    constructor() { }
  
    ngOnInit() {
      
    }
  
  
    toggleAppearence() {
      this.appear = !this.appear;
    }
  
    toggleInterview(){
      this.appearInterview = !this.appearInterview;
      this.appearPropal = false;
    }
  
    togglePropal() {
      this.interviews.forEach(inter => {
        if (inter.interviewType == 'Propal') {
          this.enablePropal = true;
        }
      });
  
      if (this.enablePropal) {
      this.appearPropal = !this.appearPropal;
      this.appearInterview = false;
      }
    }
  
    onChangesInterview(val) {
      val.forEach(inter => this.interviews.push(inter)); 
      this.changes.emit(val);
      
    }
  
    onChangesInterviewForm(val) {
  
      this.interviewForm.emit(val);
  
    }
  
  }
  