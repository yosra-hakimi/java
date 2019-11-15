import { Component, OnInit, Input } from '@angular/core';
import { Diploma } from 'src/app/models/Diploma';
import { Application } from 'src/app/models/Application';
import { Candidat } from 'src/app/models/Candidat';

@Component({
  selector: 'app-diplay-app-folder',
  templateUrl: './diplay-app-folder.component.html',
  styleUrls: ['./diplay-app-folder.component.css']
})
export class DiplayAppFolderComponent implements OnInit {

  constructor() { }

  @Input() candidat : Candidat;
  
  ngOnInit() {
  }

}
