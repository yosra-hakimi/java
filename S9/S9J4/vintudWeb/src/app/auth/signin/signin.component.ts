import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthServiceService } from '../../services/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
 
  private currentAnnounce : object ;
  signinForm: FormGroup;
  errorMessage: string;

  constructor(private formBuilder: FormBuilder,
              private authService: AuthServiceService,
              private router: Router) { }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.signinForm = this.formBuilder.group({
      mail: ['', [Validators.required, Validators.email]],
      userpassword: ['', [Validators.required, Validators.pattern(/[0-9a-zA-Z]{6,}/)]]
    });
  }

  onSubmit(data:any) {
    const mail = this.signinForm.get('mail').value;
    const userpassword = this.signinForm.get('userpassword').value;
    console.log(mail);
    console.log(userpassword);
    this.router.navigate(['/home']);
  

   console.log(data);
   this.authService.connexionUser(this.authService.host+"/signin", data)
   .subscribe(res=>{

      console.log(res);
      // this.router.navigateByUrl("/announces")

      this.currentAnnounce = res ; 
     
   },err=>{
      console.log(err);
   })
   
  }




}
