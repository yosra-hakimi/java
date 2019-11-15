import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Application } from 'src/app/models/Application';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-update-app-folder',
  templateUrl: './update-app-folder.component.html',
  styleUrls: ['./update-app-folder.component.css']
})
export class UpdateAppFolderComponent implements OnInit {
  folderForm: FormGroup;
  @Output() folderEvent = new EventEmitter();
  @Input() folderFromParent: Application;
  @Input() identityError: string;
  @Input() manager: User[];
  cooptedBy: User[] ;
  managerList: User[] = [];
  managerDefaultSelected = true;
  copterDefaultselected = true;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {

    this.folderForm = this.formBuilder.group({
      applicationDate: [
        this.folderFromParent.applicationDate,
        [Validators.required]
      ],
      cooptedBy: [this.folderFromParent.cooptedBy],
      disponibilityDate: [this.folderFromParent.disponibilityDate , [Validators.required]],
      source: [this.folderFromParent.source, [Validators.required]],

      manager: [this.folderFromParent.manager, [Validators.required]],
      geographicalWish: [this.folderFromParent.geographicalWish],
      searchedPosition: [
        this.folderFromParent.searchedPosition,
        [Validators.required]
      ] });
  }

  OnChanges() {
    this.folderEvent.emit(this.folderForm);
  }

}
