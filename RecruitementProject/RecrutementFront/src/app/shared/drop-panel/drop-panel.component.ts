import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-drop-panel',
  templateUrl: './drop-panel.component.html',
  styleUrls: ['./drop-panel.component.css']
})
export class DropPanelComponent implements OnInit {

  constructor() { }
  private appear;
  private appearForms;
  private contactAppear;
  private experienceAppear;
  private contact;
  private contactErrorNumber;
  private experience;
  private experienceErrorNumber;
  private errorNumber;

  private personalInfo;

  ngOnInit() {
    this.appear = false;
    this.appearForms=false;
    this.contactAppear=false;
    this.experienceAppear=false;
    this.contactErrorNumber=0;
    this.experienceErrorNumber=0;
    
  }

  toggleAppearence(){
    
    if(this.appear)
      this.appear =false;
      else this.appear = true;
  }

  toggleAppearenceForms(){

    if(this.appearForms)
      this.appearForms =false;
      else this.appearForms = true;
  }

  showContact(){
    this.contactAppear=true;
    this.experienceAppear=false;
  }

  showExsperience(){
    this.contactAppear=false;
    this.experienceAppear=true;
  }
 
  onChanges(val){
    this.personalInfo = val.pi;
    this.errorNumber=val.errorNumber;
  }

  onContactChanges(val){
    this.contact = val.pi;
    this.contactErrorNumber=val.errorNumber;
  }

  onExperienceChanges(val){
    this.experience = val.pi;
    this.experienceErrorNumber=val.errorNumber;
  }

}
