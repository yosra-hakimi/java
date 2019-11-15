import { Component, OnInit, Output, EventEmitter, Input } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Candidat } from "src/app/models/Candidat";
import { Nationality } from '../../../../models/nationality'
import { CandidatServiceService } from 'src/app/services/candidat-service.service';
import { AbstractControl } from '@angular/forms';
@Component({
  selector: "app-contact",
  templateUrl: "./contact.component.html",
  styleUrls: ["./contact.component.css"]
})
export class ContactComponent implements OnInit {
  personalInformationForm: FormGroup;
  newCandidat: Candidat;
  @Output() contactEvent = new EventEmitter();
  @Input() contactFromParent: Candidat;
  @Output() checkMailExist = new EventEmitter();
  @Input() identityError: string;
  mailExist: boolean = false;
  @Input()  mailExisterror ;
  nationalities: string[];
  constructor(private formBuilder: FormBuilder, private candidatServiceService: CandidatServiceService) { }

  ngOnInit() {



    this.nationalities = Nationality;
    this.personalInformationForm = this.formBuilder.group({
      firstName: [
        this.contactFromParent.firstName,
        [
          Validators.required,
          Validators.pattern("^[a-zA-Z]*$")
        ]
      ],
      lastName: [
        this.contactFromParent.lastName,
        [
          Validators.required,
          Validators.required,
          Validators.pattern("^[a-zA-Z]*$")
        ]
      ],
      civility: [this.contactFromParent.civility, [Validators.required]],
      statut: ["a recevoir", [Validators.required]],
      nationality: [this.contactFromParent.nationality, [Validators.required]],
      dateOfBithday: [
        this.contactFromParent.dateOfBithday,
        [Validators.required]
      ],
      dateFirstExperience: [
        this.contactFromParent.dateFirstExperience,
        [Validators.required]
      ],
      typeIdentityPiece: [this.contactFromParent.typeIdentityPiece],
      expirationIdentityPiece: [this.contactFromParent.expirationIdentityPiece],
      numIdentityPiece: [this.contactFromParent.numIdentityPiece],
      entreprise: [this.contactFromParent.entreprise],
      mail: [
        this.contactFromParent.mail,
        [
          Validators.required,
          Validators.pattern(
            /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/
          )
        ]
      ],
      phoneNumber: [
        this.contactFromParent.phoneNumber,
        [Validators.required, Validators.pattern("^[0-9]*$")]
      ],
      experience: [this.contactFromParent.experience]

    }

    );
  }

  OnChanges() {
    this.contactEvent.emit(this.personalInformationForm);

  }


  experience() {

    let message: string;

    if (this.personalInformationForm.controls["dateFirstExperience"].valid) {
      let todayDate: Date = new Date();
      let firstExperience: Date = this.personalInformationForm.controls[
        "dateFirstExperience"
      ].value;
      let periode = todayDate.valueOf() - firstExperience.valueOf();
      let firstExperienceDate = new Date(firstExperience);

      let year = todayDate.getFullYear() - firstExperienceDate.getFullYear();

      let month = todayDate.getMonth() - firstExperienceDate.getMonth();

      let months = (12 - firstExperienceDate.getMonth()) + todayDate.getMonth()

      if (month > 0) {

        message = ` ${year} Ans et ${month} Mois`;


      }

      else {

        if (months == 12) {

          message = ` ${year} Ans`;

        }
        else { message = ` ${year - 1} Ans et ${months} Mois` }


      }

    }

    return this.personalInformationForm.controls["experience"].setValue(
      message
    );

  }



  checkMailExists() {



    this.candidatServiceService.getCandidateByMail(this.personalInformationForm.controls.mail.value).subscribe(

      (res => {
        if (res) {

          this.mailExist = true
          this.checkMailExist.emit(this.mailExist);

        }
      }),

      (err => {
        if (err) {
        this.mailExist = false
          this.checkMailExist.emit(this.mailExist);


        }
      })


    );


  }



}
