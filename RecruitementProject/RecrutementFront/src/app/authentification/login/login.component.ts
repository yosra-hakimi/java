import { Component, OnInit } from '@angular/core';
import { CredentialInput } from 'src/app/models/CredentialInput';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private cred :CredentialInput;

  constructor(private fb:FormBuilder,private authService :AuthService,private route:Router) { }

  private testAuthentication;
  private testAdminn;
  private errorPresent;

  ngOnInit() {
    this.testAuthentication="";
    this.errorPresent=false;
  }
  loginForm = this.fb.group({
    username:[,[Validators.required]],
    password:[,[Validators.required]]
  });

  onSubmit(){
    this.cred = this.loginForm.value;
    this.authService.loginUser(this.cred).subscribe((res:HttpResponse<any>)=>{

      if(res.headers.get('Authorization')){
      

        localStorage.setItem('token',res.headers.get('Authorization') );
        let myRawToken = res.headers.get('Authorization').split(' ')[1];

        const helper = new JwtHelperService();


      
        const decodedToken = helper.decodeToken(myRawToken);

        this.authService.setUser();



        this.route.navigate(['/recrutement/accueil']);
      
      }
    
    },err=>this.errorPresent=true)
    };

    testAuth(){
      this.authService.testUserAuth().subscribe(res=> {

        this.testAuthentication=res;

      })


    }

    testAdmin(){
      this.authService.testUserAdmin().subscribe(res=> {
        this.testAdminn=res;
      })
    }

}
