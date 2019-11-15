import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { User } from '../../models/User';
import { UserService } from '../../services/user.service';
import { Profile } from '../../models/Profile';
@Component({
  selector: 'app-consult-user',
  templateUrl: './consult-user.component.html',
  styleUrls: ['./consult-user.component.css'],
})
export class ConsultUserComponent implements OnInit {

  @Input() users: User[];
  appear = true;
  detailsAppear = false;

  profiles: Profile[] = [];
  consultUserForm: FormGroup;
  userForm: FormGroup;
  constructor(private userService: UserService, private formBuilder: FormBuilder) { this.initForm(); }

  ngOnInit() {
    this.getAllProfiles();

  }
  toggleAppearence(i) {
    this.appear = !this.appear
  }
  onAppearDetails(i: number) {

    this.users[i].detailsAppear = !this.users[i].detailsAppear

  }

  getAllProfiles(): void {
    this.userService.getAllProfiles()
      .subscribe(profiles => this.profiles = profiles);
  }

  initForm() {
    this.consultUserForm = this.formBuilder.group({
      lastName: ['', [Validators.required, Validators.maxLength(20), Validators.pattern("^[a-zA-Z]*$")]],
      firstName: ['', [Validators.required, Validators.maxLength(20), Validators.pattern("^[a-zA-Z]*$")]],
      phoneNumber: ['', [Validators.required, Validators.pattern("^[0-9]*$"), Validators.maxLength(10)]],
      dateOfBithday: ['', [Validators.required]],
      nationality: ['', [Validators.required]],
      mail: ['', [Validators.required, Validators.pattern(/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/)]],
      password: [''],
      profile: this.formBuilder.group({
        profileName: ['']
      })
    });

  }

  get lastName() { return this.consultUserForm.get('lastName'); }
  get firstName() { return this.consultUserForm.get('firstName'); }
  get phoneNumber() { return this.consultUserForm.get('phoneNumber'); }
  get dateOfBithday() { return this.consultUserForm.get('dateOfBithday'); }
  get nationality() { return this.consultUserForm.get('nationality'); }
  get mail() { return this.consultUserForm.get('mail'); }
  get password() { return this.consultUserForm.get('password'); }
  get profile() { return this.consultUserForm.get('profile'); }

  updateUser() {
    console.log(this.consultUserForm.value)
    this.userService.updateUser(this.consultUserForm.value)
      .subscribe(user => this.users.push(user));
  }
  deleteUser(mail) {
    /*To be implimented*/
  }
}
