import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Announce } from '../models/announce.model';


@Injectable({
  providedIn: 'root'
})
export class AnnouncementServiceService {
public host : string="http://localhost:8080"



  constructor(private httpClient: HttpClient) { }

  public getAnnounce(){
    return this.httpClient.get(this.host+"/announcements");
  }
 /*
  public getAnnounceById(){
    return this.httpClient.get(this.host+"/announcement/1");
  }
 */


  public saveAnnounce(url,data) {
      return this.httpClient.post(url,data);
  }
}



