import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { CandidatServiceService } from 'src/app/services/candidat-service.service';
import { SearchService } from 'src/app/services/search.service';

import { Interview } from 'src/app/models/Interview';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';
import { Candidat } from 'src/app/models/Candidat';
import { FileUploadService } from 'src/app/services/file-upload.service';
import { ToastrService } from 'ngx-toastr';
import { UniversityServiceService } from 'src/app/services/university-service.service';
import { University } from 'src/app/models/university';

@Component({
  selector: 'app-update-application',
  templateUrl: './update-application.component.html',
  styleUrls: ['./update-application.component.css']
})
export class UpdateApplicationComponent implements OnInit {
  private candidatForm: FormGroup;
  private experienceForm: FormGroup;
  private folderForm: FormGroup;
  private interviewForm: FormGroup;
  private application;
  private applicationId;
  private candidat: Candidat;
  private processId;

  private universities: University[];

  file: File;
  error: string;
  uploadResponse = { status: "", message: "", filePath: "" };

  submited: boolean;
  identityError: string;

  documentsError: string;
  interviwError: string;

  manager: User[];
  interviews: Interview[] = [];

  interviewLength = 0;

  constructor(
    private candidatServiceService: CandidatServiceService,
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private fileUploadService: FileUploadService,
    private userService: UserService,
    private searchService: SearchService,
    private toastr: ToastrService,
    private route: Router,
    private universityServiceService: UniversityServiceService) { }


  ngOnInit() {

    this.getAlllUsers();
    this.getUniversities();


    this.submited = true;

    this.searchService.getCandidatToDisplay().subscribe(res => {
      this.candidat = res;
      this.applicationId = this.candidat.application.id;
      this.interviewLength = this.candidat.application.interview.length;
      this.processId = res.processId;
      console.log(this.processId);
      this.candidat.application.interview.forEach(inter => {
        this.interviews.push(inter);
      })



      this.folderForm = this.formBuilder.group({
        applicationDate: [new Date(res.application.applicationDate).toISOString().substring(0, 10)],
        cooptedBy: [res.application.cooptedBy ? res.application.cooptedBy.mail : null],
        disponibilityDate: [new Date(res.application.disponibilityDate).toISOString().substring(0, 10)],
        source: [res.application.source],
        manager: [res.application.manager.mail],
        geographicalWish: [res.application.geographicalWish],
        searchedPosition: [res.application.searchedPosition],
        curriculumVitae: []

      });

      this.experienceForm = this.formBuilder.group({
        actuelPost: [res.diploma.actuelPost],
        formation: [res.diploma.formation],
        university: [res.diploma.university.id]
      });


      this.candidatForm = this.formBuilder.group({
        firstName: [res.firstName],
        lastName: [res.lastName],
        civility: [res.civility],
        statut: [res.statut],
        nationality: [res.nationality],
        dateOfBithday: [new Date(res.dateOfBithday).toISOString().substring(0, 10)],
        dateFirstExperience: [new Date(res.dateFirstExperience).toISOString().substring(0, 10)],
        typeIdentityPiece: [res.typeIdentityPiece],
        expirationIdentityPiece: [res.expirationIdentityPiece ? new Date(res.expirationIdentityPiece).toISOString().substring(0, 10) : null],
        numIdentityPiece: [res.numIdentityPiece],
        entreprise: [res.entreprise],
        mail: [res.mail],
        phoneNumber: [res.phoneNumber],
        experience: [res.experience],
        application: [this.folderForm.value],
        diploma: [this.experienceForm.value]
      });


    })


  }


  onChangesCantact(value) {

    this.candidatForm = value;

  }

  onChangesExperience(value) {

    this.experienceForm = value;
  }
  onChangesFolder(value) {

    this.folderForm = value;
  }

  onChangesInterview(value) {
    this.interviewForm = value;
    this.interviews = value;
    console.log(this.interviews);
  }
  onSubmit() {




    if (this.candidatForm.invalid || this.experienceForm.invalid || this.folderForm.invalid) {

      this.submited = false
      this.identityError = "true";

      this.toastr.warning('Merci de vérifier que tous les champs sont bien renseignés et réessayer', 'Avertissement', {
        enableHtml: true,
        closeButton: true,
        easing: 'ease-in',
        progressBar: true,
        timeOut: 3000
      });
    } else { this.identityError = 'false' };




    if (this.candidatForm.valid && this.experienceForm.valid && this.folderForm.valid) {
      this.submited = true;
      this.application = {

        id: this.candidat.id,
        processId: this.processId,

        firstName: this.candidatForm.value.firstName,
        lastName: this.candidatForm.value.lastName,
        civility: this.candidatForm.value.civility,
        statut: this.candidatForm.value.statut,
        nationality: this.candidatForm.value.nationality,
        dateOfBithday: this.candidatForm.value.dateOfBithday,
        dateFirstExperience: this.candidatForm.value.dateFirstExperience,
        typeIdentityPiece: this.candidatForm.value.typeIdentityPiece,
        expirationIdentityPiece: this.candidatForm.value.expirationIdentityPiece,
        numIdentityPiece: this.candidatForm.value.numIdentityPiece,
        entreprise: this.candidatForm.value.entreprise,
        mail: this.candidatForm.value.mail,
        phoneNumber: this.candidatForm.value.phoneNumber,
        experience: this.candidatForm.value.experience,
        application: {
          id: this.applicationId,
          applicationDate: this.folderForm.value.applicationDate,
          disponibilityDate: this.folderForm.value.disponibilityDate,
          source: this.folderForm.value.source,
          searchedPosition: this.folderForm.value.searchedPosition,
          geographicalWish: this.folderForm.value.geographicalWish,
          curriculumVitae: null,
          cooptedBy: this.folderForm.value.cooptedBy ? { mail: this.folderForm.value.cooptedBy } : null,
          manager: { mail: this.folderForm.value.manager }

        },
        diploma: {
          actuelPost: this.experienceForm.value.actuelPost,
          formation: this.experienceForm.value.formation,
          university: { id: this.experienceForm.value.university }
        }

      };

      this.application.application.interview = this.interviews;


      if (this.authService.profile == "backOfficeManager" && this.interviewLength < this.interviews.length) {
        console.log(this.interviews);
        if (this.interviews[this.interviews.length - 1].interviewType == "Propal") {
          this.application.statut = "propalPlaned";
          this.application.application.nextStep = "propal";
        } else {

          this.application.statut = "interviewPlaned";
          this.application.application.nextStep = "interview";
        }

        this.candidatServiceService.hrEvaluation(this.application).subscribe(data => {

          this.submited = true;
          this.toastr.success('Candidat modifié Avec Succès', 'Succès', {
            enableHtml: true,
            closeButton: true,
            easing: 'ease-in',
            progressBar: true,
            timeOut: 3000
          });

          this.route.navigate(['/recrutement/rechercher']);
        }, err => {

          this.toastr.error("le candidat n'a pas pu être modifié", 'Erreur', {
            enableHtml: true,
            closeButton: true,
            easing: 'ease-in',
            progressBar: true,
            timeOut: 3000
          });

        });

      } else {
        this.candidatServiceService.updateCandidat(this.application).subscribe(data => {

          this.submited = true;
          this.toastr.success('Candidat modifié Avec Succès', 'Succès', {
            enableHtml: true,
            closeButton: true,
            easing: 'ease-in',
            progressBar: true,
            timeOut: 3000
          });

          this.route.navigate(['/recrutement/rechercher']);
        }, err => {

          this.toastr.error("le candidat n'a pas pu être modifié", 'Erreur', {
            enableHtml: true,
            closeButton: true,
            easing: 'ease-in',
            progressBar: true,
            timeOut: 3000
          });

        });
      }


    }
  }
  /*
    uploadFile() {
      const formData = new FormData();
      formData.append("files", this.file, this.file.name);
      this.fileUploadService
        .upload(formData)
        .subscribe(res => (this.uploadResponse = res), err => (this.error = err));
    }
    */

  getAlllUsers() {

    this.userService.getAllUsers().subscribe(data => this.manager = data)
  }

  getUniversities() {
    this.universityServiceService.getUniversities().subscribe(data => this.universities = data);
  }

  rejectCanidat() {

    if (this.candidatForm.invalid || this.experienceForm.invalid || this.folderForm.invalid) {

      this.submited = false
      this.identityError = "true";

      this.toastr.warning('Merci de vérifier que tous les champs sont bien renseignés et réessayer', 'Avertissement', {
        enableHtml: true,
        closeButton: true,
        easing: 'ease-in',
        progressBar: true,
        timeOut: 3000
      });
    } else { this.identityError = 'false' };


    this.submited = true;
    this.application = {

      id: this.candidat.id,
      processId: this.processId,

      firstName: this.candidatForm.value.firstName,
      lastName: this.candidatForm.value.lastName,
      civility: this.candidatForm.value.civility,
      statut: 'rejected',
      nationality: this.candidatForm.value.nationality,
      dateOfBithday: this.candidatForm.value.dateOfBithday,
      dateFirstExperience: this.candidatForm.value.dateFirstExperience,
      typeIdentityPiece: this.candidatForm.value.typeIdentityPiece,
      expirationIdentityPiece: this.candidatForm.value.expirationIdentityPiece,
      numIdentityPiece: this.candidatForm.value.numIdentityPiece,
      entreprise: this.candidatForm.value.entreprise,
      mail: this.candidatForm.value.mail,
      phoneNumber: this.candidatForm.value.phoneNumber,
      experience: this.candidatForm.value.experience,
      application: {
        id: this.applicationId,
        applicationDate: this.folderForm.value.applicationDate,
        disponibilityDate: this.folderForm.value.disponibilityDate,
        source: this.folderForm.value.source,
        searchedPosition: this.folderForm.value.searchedPosition,
        geographicalWish: this.folderForm.value.geographicalWish,
        curriculumVitae: null,
        nextStep: 'rejected',
        cooptedBy: this.folderForm.value.cooptedBy ? { mail: this.folderForm.value.cooptedBy } : null,
        manager: { mail: this.folderForm.value.manager }

      },
      diploma: {
        actuelPost: this.experienceForm.value.actuelPost,
        formation: this.experienceForm.value.formation,
        university: { id: this.experienceForm.value.university }
      }

    };

    this.application.application.interview = this.interviews;


    if (this.authService.profile == "backOfficeManager" && this.interviewLength < this.interviews.length) {
      console.log(this.application.interview);
      if (this.interviews[this.interviews.length - 1].interviewType == "Propal") {
        this.application.statut = "propalPlaned";
        this.application.application.nextStep = "propal";
      } else {

        this.application.statut = "interviewPlaned";
        this.application.application.nextStep = "interview";
      }

      console.log(this.application)
      this.candidatServiceService.hrEvaluation(this.application).subscribe(data => {

        this.submited = true;
        this.toastr.success('Candidat Ajouté Avec Succès', 'Succès', {
          enableHtml: true,
          closeButton: true,
          easing: 'ease-in',
          progressBar: true,
          timeOut: 3000
        });

        this.route.navigate(['/recrutement/rechercher']);
      });

    }
    else {
      this.candidatServiceService.updateCandidat(this.application).subscribe(data => {

        this.submited = true;
        this.toastr.success('Candidat Ajouté Avec Succès', 'Succès', {
          enableHtml: true,
          closeButton: true,
          easing: 'ease-in',
          progressBar: true,
          timeOut: 3000
        });

        this.route.navigate(['/recrutement/rechercher']);
      }, err => {

        this.toastr.error("le candidat n'a pas pu être ajouté", 'Erreur', {
          enableHtml: true,
          closeButton: true,
          easing: 'ease-in',
          progressBar: true,
          timeOut: 3000
        });

      });
    }






    this.candidatServiceService.hrEvaluation(this.application).subscribe(data => { });
  }


}