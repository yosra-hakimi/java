import { Component, OnInit, Input } from '@angular/core';
import { Candidat } from 'src/app/models/Candidat';
import { SearchService } from 'src/app/services/search.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-disp-candidat',
  templateUrl: './disp-candidat.component.html',
  styleUrls: ['./disp-candidat.component.css']
})
export class DispCandidatComponent implements OnInit {
  @Input() private candidats: Candidat[]; 
  constructor( private searchService: SearchService,private router: Router) { }

  ngOnInit() {
  }

  consulter(candidat: Candidat) {

    this.searchService.setCandidatToDisplay(candidat);
    this.router.navigate(['/recrutement/update']);
  }

}
