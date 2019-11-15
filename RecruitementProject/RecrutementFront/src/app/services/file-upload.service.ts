import { Injectable } from '@angular/core';
import { HttpClient, HttpEventType ,HttpParams ,HttpResponse , HttpHeaders } from  '@angular/common/http';
import { map, tap } from  'rxjs/operators';
import {Observable} from "rxjs";
import { saveAs } from 'file-saver';
import { Candidat } from '../models/Candidat';

@Injectable({
  providedIn: 'root'
})
export class FileUploadService {
  

  constructor(private http: HttpClient) { }



  public uploadCurriculemVitae(data: FormData,mail){

    return this.http.post<Candidat>('http://localhost:8080/uploadCvByMail/'+ mail,data)

  }



  uploadFile(data: FormData): Observable<any> {
    //debugger
    return this.http.post<any>('http://localhost:8080/uploadMultipleFiles', data);
  }




uploadDoc(dataDoc: FormData): Observable<any> {
  //debugger
  return this.http.post<any>('http://localhost:8080/uploadMultipleDoc', dataDoc);
}

   





  downloadCv(id)  {
 
  return this.http.get('http://localhost:8080/downloadCv/4', { responseType: 'blob' })
}

downloadFile(id)  {
 
  return this.http.get('http://localhost:8080/downloadDocument/3', { responseType: 'blob' })
}



downloadCvByMail(mail)  {
 
  return this.http.get('http://localhost:8080/downloadCvByMail/'+mail, { responseType: 'blob' })
}


























}
