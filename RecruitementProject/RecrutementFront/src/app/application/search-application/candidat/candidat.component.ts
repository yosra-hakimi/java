import { Component, OnInit, Input } from '@angular/core';
import { Candidat } from 'src/app/models/Candidat';
@Component({
  selector: 'app-candidat',
  templateUrl: './candidat.component.html',
  styleUrls: ['./candidat.component.css']
})
export class CandidatComponent implements OnInit {

  
  @Input() pending: Candidat[] ;
  @Input() rejected: Candidat[] ;
  @Input() accepted: Candidat[] ;
  @Input() propalInProgress: Candidat[] ;
  @Input() interviewInProgress: Candidat[];

  
  private appear: boolean = false;

  private pendingAppear =false;
  private evaluatedAppear = false;
  private acceptedAppear = false;
  private rejectedAppear = false;
  private interviewAppear = false;
  private propalAppear = false;
  private interviewPlanedAppear =false;
  private propalPlanedAppear = false;

  private displayPending: boolean = true;
  private displayAccepted: boolean = true;
  private displayRejected: boolean = true;
  private displayPropalPlaned: boolean = true;
  private displayPropalPassed: boolean = true;
  private displayInterviewPlaned: boolean = true;
  private displayInterviewPassed: boolean = true;
  private displayInterviewEvaluated: boolean = true;



  constructor() { }

  ngOnInit() {
    
    

      if(this.pending.length == 0) this.displayPending=false;

      if(this.rejected.length == 0) this.displayRejected=false;

      if(this.accepted.length ==0) this.displayAccepted = false;

      if(this.propalInProgress.length == 0) this.displayPropalPlaned = false;


      if(this.interviewInProgress.length == 0) this.displayInterviewPlaned = false;
      


      //console.log(this.pending);

    
  }

  toggleAppearence(){
    
    this.appear = !this.appear;
  
}

togglePendingAppearence(){
  this.pendingAppear=!this.pendingAppear;
}

toggleEvaluatedAppearence(){
  this.evaluatedAppear=!this.evaluatedAppear;
}

toggleAcceptedAppearence(){

this.acceptedAppear=!this.acceptedAppear;

}
toggleRejectedAppearence(){

  this.rejectedAppear=!this.rejectedAppear;
  
  }

toggleInterviewAppearence(){

this.interviewAppear=!this.interviewAppear;

}

togglePropalAppearence(){

  this.propalAppear=!this.propalAppear;
}

toggleInterview(){

  this.interviewPlanedAppear=!this.interviewPlanedAppear;
}

togglePropal(){

  this.propalPlanedAppear=!this.propalPlanedAppear;
}


}
