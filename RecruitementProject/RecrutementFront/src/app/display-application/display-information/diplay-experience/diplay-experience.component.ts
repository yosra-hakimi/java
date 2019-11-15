import { Component, OnInit, Input } from '@angular/core';
import { Candidat } from 'src/app/models/Candidat';

@Component({
  selector: 'app-diplay-experience',
  templateUrl: './diplay-experience.component.html',
  styleUrls: ['./diplay-experience.component.css']
})
export class DiplayExperienceComponent implements OnInit {

  constructor() { }

  @Input() candidat :Candidat;
  
  ngOnInit() {

   
  }

}
