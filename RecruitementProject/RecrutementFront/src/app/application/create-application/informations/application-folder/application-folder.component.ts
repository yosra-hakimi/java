import { Component, OnInit, Output, Input, EventEmitter } from "@angular/core";
import { Validators, FormBuilder, FormGroup } from "@angular/forms";
import { Application } from "src/app/models/Application";
import {CooptedBy} from "../../../../models/cooptantList"
import { User } from 'src/app/models/User';
import { Console } from '@angular/core/src/console';
import { AuthService } from 'src/app/services/auth.service';
@Component({
  selector: "app-application-folder",
  templateUrl: "./application-folder.component.html",
  styleUrls: ["./application-folder.component.css"]
})
export class ApplicationFolderComponent implements OnInit {
  folderForm: FormGroup;
  @Output() folderEvent = new EventEmitter();
  @Input() folderFromParent: Application;
  @Input() identityError: string;
  @Input() manager: User[];
  @Input() cooptantList : User [] ;
  cooptedBy :User[] ;
  managerList: User[] = [];
  managerDefaultSelected = true;
  copterDefaultselected = true;
  logUser : string;
  constructor(private formBuilder: FormBuilder , private authService:AuthService) { }

  ngOnInit() {
    this.getUserConncted() ;

    this.folderForm = this.formBuilder.group({
      applicationDate: [
        this.folderFromParent.applicationDate,
        [Validators.required]
      ],
      cooptedBy: this.getProfile()? this.logUser:[this.folderFromParent.cooptedBy, this.folderFromParent.source=="Interne"?[Validators.required]:""],
      disponibilityDate: [this.folderFromParent.disponibilityDate , [Validators.required]],
      source: this.getProfile()? "Interne" : [this.folderFromParent.source, [Validators.required]],
      manager: [this.folderFromParent.manager, [Validators.required]],
      geographicalWish: [this.folderFromParent.geographicalWish],
      searchedPosition: [
        this.folderFromParent.searchedPosition,
        [Validators.required]
      ], 
      
    });
   
  }

  OnChanges() {
    this.folderEvent.emit(this.folderForm);
  }

  getProfile(){
    if(this.authService.profile=='collaborater'){ return true;}
    return false;
  }

getUserConncted() {

this.logUser= `${this.authService.firstName} ${this.authService.lastName} `

}
}


