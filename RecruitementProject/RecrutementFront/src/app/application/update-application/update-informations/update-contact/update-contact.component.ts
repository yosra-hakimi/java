import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Candidat } from 'src/app/models/Candidat';
import { CandidatServiceService } from 'src/app/services/candidat-service.service';
import { Nationality } from 'src/app/models/nationality';

@Component({
  selector: 'app-update-contact',
  templateUrl: './update-contact.component.html',
  styleUrls: ['./update-contact.component.css']
})
export class UpdateContactComponent implements OnInit {

  personalInformationForm: FormGroup;
  newCandidat: Candidat;
  @Output() contactEvent = new EventEmitter();
  @Input() contactFromParent: Candidat;
  @Input() identityError: string;
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





}
