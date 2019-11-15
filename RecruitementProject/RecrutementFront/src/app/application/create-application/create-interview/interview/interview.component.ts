import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';


import { Application } from 'src/app/models/Application';
import { UserService } from 'src/app/services/user.service';
import { Interview } from 'src/app/models/Interview';
import { User } from 'src/app/models/User';
import { InterviewService } from 'src/app/services/interview.service';

@Component({
  selector: 'app-interview',
  templateUrl: './interview.component.html',
  styleUrls: ['./interview.component.css']
})
export class InterviewComponent implements OnInit {

  @Output() changes = new EventEmitter();
  @Output() interviewEvent = new EventEmitter(); 

  @Input() interviewsChild:Interview[];
  @Input() formInterview:  FormGroup;

  //formInterview: FormGroup;
  items: FormArray;
  isEmpty = true;
  appear = false;
  appearInfo = false;
  apperSave = false;
  appearInterview = [];
  interviews: Interview[] = [];
  users: User[] = [];
  selectedMail = true;
  selectedType = true;
  validInterview = false;
  


  constructor(private interviewService: InterviewService, private userService: UserService, private formBuilder: FormBuilder) { }


  ngOnInit() {
    this.initForm();
  }

  initForm(){

    this.mailList();
    this.formInterview = this.formBuilder.group({
      items: this.formBuilder.array([])
    });
    let items = this.formInterview.get('items') as FormArray;

    this.interviewsChild.forEach(nestedIterview => {

      items.push(this.initInterviewChild(nestedIterview));
  });
}

  createInterviewItem(interview?: Interview) {
   


    return this.formBuilder.group({
      interviewDate: [interview ? new Date(interview.interviewDate).toISOString().substring(0, 10) : '', [Validators.required]],
      interviewWith: this.formBuilder.group({
        mail: [interview ? interview.interviewWith.mail : '', [Validators.required]]
      }),
      interviewType: [interview ? interview.interviewType : '', [Validators.required]],
      jobOffer: [interview ? interview.jobOffer : ''],
      businessUnit: [interview ? interview.businessUnit : ''],
    });
  }

  initInterviewChild(interview: Interview){
    return this.formBuilder.group({
      id: interview.id,
      interviewDate: [interview ? new Date(interview.interviewDate).toISOString().substring(0, 10) : '', [Validators.required]],
      interviewWith: this.formBuilder.group({
        mail: [interview ? interview.interviewWith.mail : '', [Validators.required]]
      }),
      interviewType: [interview ? interview.interviewType : '', [Validators.required]],
      jobOffer: [interview ? interview.jobOffer : ''],
      businessUnit: [interview ? interview.businessUnit : ''],
    });
  }


  createNewItem(): FormGroup {
    return this.formBuilder.group({
      interviewDate: ['', [Validators.required]],
      interviewWith: this.formBuilder.group({
        mail: ['', [Validators.required]]
      }),
      interviewType: ['', [Validators.required]],
      jobOffer: '',
      businessUnit: [''],

    });

  }

  onSave(idx: number) {
    let items = this.formInterview.get('items') as FormArray;
    let interview = items.value[idx];
    

    this.interviewService.saveInterview(interview).subscribe(
      data => {
        
      },
      error => {
        
      },

    );

    this.initForm();


    }

  onDelete(i) {
    let items = this.formInterview.get('items') as FormArray;
 
   
 
      items.removeAt(i);

    

  }

  addItem(): void {
    if (this.interviews[0]) {
      this.items = this.formInterview.get('items') as FormArray;
      this.items.push(this.createNewItem());
    } else {
      this.formInterview = this.formBuilder.group({
        items: this.formBuilder.array([this.createNewItem()])
      });
      this.isEmpty = false;
    }
 

  }


  toggleAppearence() {
    this.appear = !this.appear;
  }

  onAppear() {
    this.appear = !this.appear;
  }

  onAppearInterview(i) {

    if (this.appearInterview[i]) {
      this.appearInterview[i] = false;
    } else {
      this.appearInterview[i] = true;
 
    }
  }

  onAppearInfoMore() {
    this.appearInfo = true;
  }
  onAppearInfoLess() {
    this.appearInfo = false;
  }
  onAddInterview() {
    let items = this.formInterview.get('items') as FormArray;
    items.push(this.createInterviewItem());
  }

  

  onItemsChange(){
    this.changes.emit(this.formInterview.get('items').value);
  }

  OnChanges() {
    this.interviewEvent.emit(this.formInterview);

  }

  mailList(){
    
    this.userService.getAllUsers().subscribe(
      data => {
      
        data.forEach(user => {
              if (user.profile.id == 4)
              this.users.push(user);

          })
          
          
      },
      error => {

      }
      
     )
  }

}
