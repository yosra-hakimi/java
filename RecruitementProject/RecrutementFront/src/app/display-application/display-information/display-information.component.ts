import { Component, OnInit, Input } from '@angular/core';
import { Candidat } from 'src/app/models/Candidat';
@Component({
  selector: 'app-display-information',
  templateUrl: './display-information.component.html',
  styleUrls: ['./display-information.component.css']
})
export class DisplayInformationComponent implements OnInit {

  constructor() { }
  private appear: boolean = false;
  private appearContact: boolean = true;
  private appearExperience: boolean = false;
  private appearFolder: boolean = false;

  @Input() candidat;


 

  ngOnInit() {
  }
  toggleAppearence() {
    this.appear = !this.appear;
  }


  toggleContact() {
    this.appearContact = !this.appearContact;
    this.appearExperience = false;
    this.appearFolder = false;
  }

  toggleExperience() {
    this.appearExperience = !this.appearExperience;
    this.appearFolder = false;
    this.appearContact= false;
  }

  toggleFolder() {
    this.appearFolder = !this.appearFolder;
    this.appearExperience = false;
    this.appearContact= false;
  }

  
}
