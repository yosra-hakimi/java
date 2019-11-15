import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl, ValidatorFn, AbstractControl } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { User } from '../../models/User';
import { Profile } from '../../models/Profile';
import { Evaluation } from 'src/app/shared/models/Evaluation';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  userForm: FormGroup;
  evaluations: Evaluation[];
  profiles;
  showValidators: boolean;
  successAdd: boolean = false;
  failedAdd: boolean = false;
  checkMail: boolean = false;
  newUser ;
  constructor(private userService: UserService, private formBuilder: FormBuilder, private toastr: ToastrService) { }

  ngOnInit() {
    this.getAllProfiles();
    this.initForm();
  }

  @Output() changes = new EventEmitter();
  initForm() {
    this.userForm = this.formBuilder.group({
      lastName: ['', [Validators.required, Validators.maxLength(20), Validators.pattern("^[a-zA-Z]*$")]],
      firstName: ['', [Validators.required, Validators.maxLength(20), Validators.pattern("^[a-zA-Z]*$")]],
      phoneNumber: ['', [Validators.required, Validators.pattern("^[0-9]*$"), Validators.maxLength(10)]],
      dateOfBithday: ['', [Validators.required]],
      nationality: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.pattern('^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=\\D*\\d)[A-Za-z\\d!$%@#£€*?&]{6,}$')]],
      profile: ['', [Validators.required]], 
      mail: ['', [Validators.required, Validators.pattern(/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/)]
      ]
    });
  }
  get lastName() { return this.userForm.get('lastName'); }
  get firstName() { return this.userForm.get('firstName'); }
  get phoneNumber() { return this.userForm.get('phoneNumber'); }
  get dateOfBithday() { return this.userForm.get('dateOfBithday'); }
  get nationality() { return this.userForm.get('nationality'); }
  get mail() { return this.userForm.get('mail'); }
  get password() { return this.userForm.get('password'); }
  get profile() { return {"id":this.userForm.get('profile')}; }

  AddUser() {
    {
this.newUser =  {
  mail: this.userForm.value.mail,
   password: this.userForm.value.password,
   firstName: this.userForm.value.firstName,
   lastName: this.userForm.value.lastName,
   phoneNumber: this.userForm.value.phoneNumber,
   nationality: this.userForm.value.nationality,
   dateOfBithday: this.userForm.value.dateOfBithday,
   profile: {
     id:this.userForm.value.profile,
       
   }
}

      this.userService.addUser(this.newUser)
      .subscribe((user => {
        if (user.status == 200) {
          this.toastr.success('Utilisateur Ajouté Avec Succès', 'Succès', {
            enableHtml: true, 
            closeButton: true,
            easing: 'ease-in',
            progressBar: true,
            timeOut: 3000
          });
          this.changes.emit()
          this.userForm.reset();
          this.checkMail = ! this.checkMail;
        } 
        else {
          this.showValidators = true;
            this.toastr.error(" Utilisateur n'a pas pu être ajouté", 'Erreur', {
              enableHtml: true,
              closeButton: true,
              easing: 'ease-in',
              progressBar: true,
              timeOut: 3000
            });
        }
      })
      );
    }

  }
  controleMailExist(event: any) {
    this.userForm.controls.mail.setValue(event.target.value)
    this.userService.GetUserByMail(this.userForm.controls.mail.value).subscribe(data => {
      if (data) {
        this.checkMail = true;
      } else {
        this.checkMail = false;

      }
    })
  }

  getAllProfiles(): void {
    this.userService.getAllProfiles()
      .subscribe(profiles => this.profiles = profiles);
  }

  OnChange(value) {
    this.userForm.controls['mail'].setValue(value);
  }



}
