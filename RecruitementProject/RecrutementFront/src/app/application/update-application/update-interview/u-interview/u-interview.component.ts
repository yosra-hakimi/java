import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Interview } from 'src/app/models/Interview';
import { FormGroup, FormArray, FormBuilder, Validators } from '@angular/forms';
import { User } from 'src/app/models/User';
import { InterviewService } from 'src/app/services/interview.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-u-interview',
  templateUrl: './u-interview.component.html',
  styleUrls: ['./u-interview.component.css']
})
export class UInterviewComponent implements OnInit {

  @Output() changes = new EventEmitter();
  @Output() interviewForm = new EventEmitter();
  @Input() interviewsChild:Interview[];

  formInterview: FormGroup;
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
    this.interviewForm.emit(this.formInterview);
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
