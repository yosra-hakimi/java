import { Component, OnInit } from '@angular/core';
import { SearchService } from '../../services/search.service';
import { Candidat } from '../../models/Candidat';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-application',
  templateUrl: './search-application.component.html',
  styleUrls: ['./search-application.component.css']
})
export class SearchApplicationComponent implements OnInit {

  searchForm: FormGroup;
  candidats: Candidat[] = [];
  private pending: Candidat[] = [];
  private rejected: Candidat[] = [];
  private accepted: Candidat[] = [];
  private propalInProgress: Candidat[] = [];
  private interviewInProgress: Candidat[] = [];

  constructor(private router: Router, private formBuilder: FormBuilder, private searchService: SearchService) { }

  ngOnInit() {
    this.initCandidate();

    this.searchForm = this.formBuilder.group({
      university: [''],
      lastName: [''],
      statut: [''],
      experience: [''],
      source: [''],
      formation: ['']

    });


  }

  onSubmit() {
    this.searchCandidate();
  }
  searchCandidate() {
    let searchCriteria: string = this.buildSearchCriteria();

    this.searchService.searchCandidate(searchCriteria).subscribe(data => {
      this.clearCandidats();
      this.candidats = data;
      data.forEach(candida => this.sortCandidat(candida));

    });
  }

  initCandidate() {

    this.searchService.getAllCandidats().subscribe(data => {
      this.clearCandidats();
      

      data.forEach(candida => {
        this.sortCandidat(candida)
      });
    });
  }

  buildSearchCriteria(): string {
    let searchCriteria: string = "";
    for (let cle in this.searchForm.value) {
      if (this.searchForm.value[cle] != "") {
        searchCriteria = searchCriteria + cle + ":" + this.searchForm.value[cle] + ","
      }

    }

    return searchCriteria;
  }

  consulter(candidat: Candidat) {

    this.searchService.setCandidatToDisplay(candidat);
    this.router.navigate(['/recrutement/update']);
  }

  clearCandidats() {
    this.pending = [];
    this.rejected = [];
    this.accepted = [];
    this.propalInProgress = [];
  
    this.interviewInProgress = [];
  }


  sortCandidat(candidat: Candidat) {

    if (candidat.statut == 'pending'||candidat.statut=="a recevoir") { this.pending.push(candidat) }

    if (candidat.statut == 'rejected') { this.rejected.push(candidat) }

    if (candidat.statut == 'accepted') { this.accepted.push(candidat) }

    if (candidat.statut == 'propalPlaned'||candidat.statut == 'propalPassed') { this.propalInProgress.push(candidat) }

    if (candidat.statut == 'interviewPlaned'||candidat.statut == 'interviewPassed'||candidat.statut == 'interviewEvaluated') { this.interviewInProgress.push(candidat) }

  }
  
}

