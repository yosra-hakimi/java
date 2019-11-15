import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AuthGuardService {
 
  public host : string="http://localhost:8080"
  
  constructor(private httpClient: HttpClient) { }
  
   
  public getuser() {
    return this.httpClient.get(this.host+"/user/mail/johnyPirate@Cara.com");

  }

  public getuserByphone() {
    return this.httpClient.get(this.host+"/user/phone/1563214561");

  }


  createNewUser(url, data) {
    return this.httpClient.post(url,data);
  }


}
