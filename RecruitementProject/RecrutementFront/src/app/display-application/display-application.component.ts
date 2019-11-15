import { Component, OnInit } from '@angular/core';
import { Candidat } from '../models/Candidat';
import { SearchService } from '../services/search.service';
import { Diploma } from '../models/Diploma';
import { Application } from '../models/Application';
@Component({
  selector: 'app-display-application',
  templateUrl: './display-application.component.html',
  styleUrls: ['./display-application.component.css']
})
export class DisplayApplicationComponent implements OnInit {

  constructor(private searchService:SearchService) { }
private candidat:Candidat
private application : Application
  ngOnInit() {
    this.searchService.getCandidatToDisplay().subscribe(res=>this.candidat=res);
  }

}
