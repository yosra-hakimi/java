import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Interview } from 'src/app/models/Interview';
import { FormGroup } from '@angular/forms';


@Component({
  selector: 'app-create-interview',
  templateUrl: './create-interview.component.html',
  styleUrls: ['./create-interview.component.css']
})
export class CreateInterviewComponent implements OnInit {

appear:boolean =false;
appearInterview:boolean=true;
appearPropal:boolean=false;
enableInterview:boolean=true;

enablePropal:boolean=false;
@Input() interviewsParent:Interview[]
@Input() formInterview: FormGroup;
@Output() changes = new EventEmitter();

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
    val.forEach(inter => {
      if(inter.interviewType =='Propal')
      this.appearPropal =true;
      this.interviews.push(inter)
      
    }); 
    this.changes.emit(val);
    
  }

}
