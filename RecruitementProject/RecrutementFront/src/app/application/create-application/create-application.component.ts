import { Component, OnInit } from "@angular/core";
import { CandidatServiceService } from "src/app/services/candidat-service.service";
import { FormGroup, FormBuilder, Validators, FormArray } from "@angular/forms";
import { AuthService } from "src/app/services/auth.service";
import { FileUploadService } from "src/app/services/file-upload.service";
import {UserService} from '../../services/user.service'
import { User } from 'src/app/models/User';

import { ToastrService } from 'ngx-toastr';
import { UniversityServiceService  } from '../../services/university-service.service';
import { University } from 'src/app/models/university';
import { Interview } from 'src/app/models/Interview';


@Component({
  selector: "app-create-application",
  templateUrl: "./create-application.component.html",
  styleUrls: ["./create-application.component.css"]
})
export class CreateApplicationComponent implements OnInit {
  candidatForm: FormGroup;
  experienceForm: FormGroup;
  folderForm: FormGroup;
  fileForm: FormGroup;
  formInterview : FormGroup;
  uploadForm: FormGroup;
  application;
  file: File;
  error: string;
  uploadResponse = { status: "", message: "", filePath: "" };
  manager : User[];
  submited :boolean;
  identityError : string;
  universities : University [] ;
  documentsError :  string;
  interviews:Interview[];
  mailExist : boolean ;
  notification ;
  interviewError : string;
  appearParent : boolean = false;
  cv : FormData;

  cooptantList : User[] ;
  constructor(
    private uploadService: FileUploadService,
    private candidatServiceService: CandidatServiceService,
    private formBuilder: FormBuilder,
    private authService: AuthService,

    private userService : UserService ,
    private toastr: ToastrService, 
    private  universityServiceService :UniversityServiceService ,
  ) {}

  ngOnInit() {

    this.formInterview= this.formBuilder.group({
      interviewDate: ['', [Validators.required]],
      interviewWith: this.formBuilder.group({
        mail: ['', [Validators.required]]
      }),
      interviewType: ['', [Validators.required]],
      jobOffer: '',
      businessUnit: [''],

    });

    this.formInterview.valueChanges.subscribe(newVal => console.log(newVal));

   this.submited=false;
   this.getAlllUsers();
   this.getUniversities ();
   this. getCooptantList() ;

    this.uploadForm = this.formBuilder.group({
      document: [""]})
   
 
  

    this.experienceForm = this.formBuilder.group({
      actuelPost: [""],
      university: [""],
      formation: [""]
    });

    this.folderForm = this.formBuilder.group({
      applicationDate: [""],
      disponibilityDate: [""],
      source: [""],
      cooptedBy: [""],
      manager: [""],
      geographicalWish: [""],
      searchedPosition: [""],
      curriculumVitae: [""]
    });
    this.candidatForm = this.formBuilder.group({
      firstName: [""],
      lastName: [""],
      civility: ["M"],
      statut: [""],
      nationality: [""],
      dateOfBithday: [""],
      dateFirstExperience: [""],
      typeIdentityPiece: [""],
      expirationIdentityPiece: [""],
      numIdentityPiece: [""],
      entreprise: [""],
      mail: [""],
      phoneNumber: [""],
      experience: [""],
      application: [this.folderForm.value],
      diploma: [this.experienceForm.value]
    });

    this.candidatForm.setErrors({ firstName: true });
    this.experienceForm.setErrors({ actuelPost: true });
    this.folderForm.setErrors({ applicationDate: true });
    this.uploadForm.setErrors({ document: true });

    this.interviews=[];
  }
  onChangesDocument(value){

    this.cv = value;
    console.log(this.cv);
  }

  onChangesCantact(value) {
    this.candidatForm = value;
  }

  onChangesExperience(value) {
    this.experienceForm = value;
  }

  onChangesFolder(value) {
    this.folderForm = value;
    console.log("folder",value)
  }

  onChangescheckMailExist(value) {
    this.mailExist = value;
  
  }


  


  /*
    onChangesFile(value) {
      this.file = value;
    }
  
    onChangesFileForm(value) {
      this.fileForm = value;
    } */

  onChangesInterview(value){

    this.interviews=value;

  }

  onSubmit() {

let nextStep="pending";
let status="pending";
if(this.interviews.length!=0){
status="interviewPlaned";
  if(this.interviews[this.interviews.length-1].interviewType=="Propal"){nextStep="propal"}
  else nextStep="interview";
}


    if (this.candidatForm.invalid || this.experienceForm.invalid || this.folderForm.invalid || this.mailExist ) {

      this.submited = false
      this.identityError = "true";
      
      this.toastr.warning('Merci de vérifier que tous les champs sont bien renseignés et réessayer','Avertissement',{
        enableHtml :  true,
        closeButton : true,
        easing :'ease-in',
        progressBar : true,
        timeOut : 3000
      });
    }
    
    else { 
      this.identityError = "false"
      // this.interviewError = 'false'
    }

    if (this.uploadForm.invalid) {

      this.submited = false
      this.documentsError = "true";
    }

    else { this.documentsError = "false" }

    if (this.candidatForm.valid && this.experienceForm.valid && this.folderForm.valid && !this.mailExist) {
      this.submited=true;

      this.application = {
      firstName: this.candidatForm.value.firstName,
      lastName: this.candidatForm.value.lastName,
      civility: this.candidatForm.value.civility,
      statut: status,
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
      user: {mail :this.authService.mail},

      application: {
        applicationDate: this.folderForm.value.applicationDate,
        disponibilityDate: this.folderForm.value.disponibilityDate,
        source: this.folderForm.value.source,
        searchedPosition: this.folderForm.value.searchedPosition,
        geographicalWish : this.folderForm.value.geographicalWish,
        curriculumVitae: null,
        cooptedBy: this.authService.profile=='collaborater'? {mail :this.authService.mail} : this.folderForm.value.cooptedBy ? {mail:this.folderForm.value.cooptedBy}:null,
        manager:{mail:this.folderForm.value.manager},
        interview:this.interviews,
        nextStep:nextStep,
        
      },
      diploma: {
        actuelPost: this.experienceForm.value.actuelPost,
        formation: this.experienceForm.value.formation,
        university: { id: this.experienceForm.value.university }
      }
    };
   
    
    this.candidatServiceService.createCandidat(this.application).subscribe((data=>{
      this.uploadService.uploadCurriculemVitae(this.cv,data.body.mail).subscribe(res=>{
        if (data.status==200) {
          this.toastr.success('Candidat Ajouté Avec Succès','Succès',{
            enableHtml :  true,
            closeButton : true,
            easing :'ease-in',
            progressBar : true,
            timeOut : 3000
          });
    
         
        this.candidatForm.reset();
        this.experienceForm.reset();
        this.folderForm.reset();
        this.appearParent=false;
         }
      })
     
  
    } ) , 
  
    (err =>{ if (err) {

        this.toastr.error("le candidat n'a pas pu être ajouté",'Erreur',{
        enableHtml :  true,
        closeButton : true,
        easing :'ease-in',
        progressBar : true, 
        timeOut : 3000
      });

    }}  )
    
    );                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
  }
 

}


  getAlllUsers() {
    this.userService.getAllUsers()
                     .subscribe(data=>{this.manager=data.filter(el=>el.profile.profileName=="backOfficeManager")})

    }


    getCooptantList() {
      this.userService.getAllUsers()
                       .subscribe(data=>this.cooptantList=data)
  
      }
  

    getUniversities ()  {

      this.universityServiceService.getUniversities()
                                   .subscribe(data=>this.universities=data)
       

      
       }
      
    
}
 