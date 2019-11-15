import { Component, OnInit, Output, EventEmitter, Input } from "@angular/core";
import { Candidat } from "../../../models/Candidat";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { User } from 'src/app/models/User';
import { University } from 'src/app/models/university';
@Component({
  selector: "app-informations",
  templateUrl: "./informations.component.html",
  styleUrls: ["./informations.component.css"]
})
export class InformationsComponent implements OnInit {
  constructor() {}
  private appear: boolean = false;
  private appearContact: boolean = true;
  private appearExperience: boolean = false;
  private appearFolder: boolean = false;
 
  
  @Output() contactEvent = new EventEmitter();
  @Input() contactFromGrandParent: FormGroup;
  @Output() experienceEvent = new EventEmitter();
  @Input() experienceFromGrandParent: FormGroup;
  @Output() folderEvent = new EventEmitter();
  @Input() folderFromGrandParent: FormGroup;
  @Input() identityError : string;
  @Input() manager : User [] ;
  @Input() universities : University[];
  @Output() checkMailExist = new EventEmitter();
  @Input()  mailExist ;
  @Input() appearParent ;
  @Input() cooptantList : User [] ;

  ngOnInit() {}

  toggleAppearence() {
    this.appearParent = !this.appearParent;
 
  }

  toggleContact() {
    this.appearContact = !this.appearContact;
    this.appearExperience = false;
    this.appearFolder = false;
  }

  toggleExperience() {
    this.appearExperience = !this.appearExperience;
    this.appearFolder = false;
    this.appearContact = false;
  }

  toggleFolder() {
    this.appearFolder = !this.appearFolder;
    this.appearExperience = false;
    this.appearContact = false;
  }

  onChangesCantact(value) {
    this.contactEvent.emit(value);
  }

  onChangesExperience(value) {
    this.experienceEvent.emit(value);
  }
  onChangesFolder(value) {
    this.folderEvent.emit(value);
  }
  onChangescheckMailExist(value) {
    this.checkMailExist.emit(value);
  
  }

 

}
