import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { CredentialInput } from '../models/CredentialInput';
import { throwError } from 'rxjs/internal/observable/throwError';
import { catchError } from 'rxjs/operators';
import { error } from 'util';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _loginUrl = 'http://localhost:8080/login';

  private _firstName;
  private _lastName;
  private _mail;
  private _profile;

  get firstName(){
    this.setUser();
    return this._firstName;
  }

  get lastName(){
    this.setUser();
    return this._lastName;
  }
  

  get mail(){
    this.setUser();
    return this._mail;
  }

  get profile(){
    this.setUser();
    return this._profile;
  }


  setUser(){
    const helper = new JwtHelperService();
    let myRawToken=localStorage.getItem('token');

    const decodedToken = helper.decodeToken(myRawToken).sub;
    let tab =decodedToken.split(' ');
    this._firstName = tab[0];
    this._lastName=tab[1];
    this._mail=tab[2];
    this._profile=tab[3];

  }
  

  

  constructor(private http:HttpClient) { }

  loginUser(credential :CredentialInput){
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json','Authorization': '' }),
      observe: 'response' as 'response'
    };

    return this.http.post(this._loginUrl,credential,httpOptions).pipe(
      catchError(this.handleError)
    );
  }

  public loggedIn() {
    if (localStorage.getItem('token')) { return true }
    else { return false }
  }

  public logout(){
    localStorage.removeItem('token');
  }

  public getRole(){
    return "USER";
  }
  testUserAuth(){
    return this.http.get('http://localhost:8080/test/auth').pipe(
      catchError(this.handleError)
    );
  }
  testUserAdmin(){
    return this.http.get('http://localhost:8080/test/admin');
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };

}
