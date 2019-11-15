import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthGuardService } from '../../services/auth-guard.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  private currentAnnounce : object ;
  signupForm: FormGroup;
  errorMessage: string;
  public users:any;

  constructor(private formBuilder: FormBuilder,
              private authGuardService: AuthGuardService,
              private router: Router) { }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.signupForm = this.formBuilder.group({
      address:['', [Validators.required]],
      firstname:['', [Validators.required]],
      mail: ['', [Validators.required, Validators.email]],
      name:['', [Validators.required]],
      userpassword: ['', [Validators.required, Validators.pattern(/[0-9a-zA-Z]{6,}/)]], 
     phone:['', [Validators.required]],
     pseudo:['', [Validators.required]],
     
     roleid:['', [Validators.required]]
    
    });
  }


  onSaveUsers(data:any) {

    const address = this.signupForm.get('address').value;
    const firstname = this.signupForm.get('firstname').value;
    const mail = this.signupForm.get('mail').value;
    const name = this.signupForm.get('name').value;
    const userpassword = this.signupForm.get('userpassword').value;
    const phone = this.signupForm.get('phone').value;
    const pseudo = this.signupForm.get('pseudo').value;
    const roleid = this.signupForm.get('roleid').value;
/*
    console.log(address)
    console.log(mail);
    console.log(userpassword);
    console.log(name);
*/
    this.router.navigate(['/auth/signin']);

   console.log(data);

   this.authGuardService.createNewUser(this.authGuardService.host+"/signup", data)
   .subscribe(res=>{

      console.log(res);
      // this.router.navigateByUrl("/announces")

      this.currentAnnounce = res ;  
     
   },err=>{
      console.log(err);
   })
 


  }

 

  
  onGetUser(){
    this.authGuardService.getuser().subscribe(data=>{
      console.log(data)

     this.users = data
     
     console.log(this.users)

    },err => {
      console.log(err);
    })
  }


   
  onGetUserByphone(){
    this.authGuardService.getuserByphone().subscribe(data=>{
      console.log(data)

     this.users = data
     
     console.log(this.users)

    },err => {
      console.log(err);
    })
  }



}