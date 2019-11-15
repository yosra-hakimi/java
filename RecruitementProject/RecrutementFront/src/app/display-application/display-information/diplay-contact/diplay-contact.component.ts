import { Component, OnInit, Input } from '@angular/core';
import { Candidat } from 'src/app/models/Candidat';

@Component({
  selector: 'app-diplay-contact',
  templateUrl: './diplay-contact.component.html',
  styleUrls: ['./diplay-contact.component.css']
})
export class DiplayContactComponent implements OnInit {

  constructor() { }

  @Input() candidat :Candidat;

  ngOnInit() {
  }

}
