import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import {FileUploader} from "ng2-file-upload";
import {Observable} from "rxjs";
import {HttpClient } from "@angular/common/http";
import { FileUploadService } from 'src/app/services/file-upload.service';
import { saveAs } from 'file-saver';
import { CandidatServiceService } from 'src/app/services/candidat-service.service';


@Component({
  selector: 'app-documents',
  templateUrl: './documents.component.html',
  styleUrls: ['./documents.component.css']
})


export class DocumentsComponent implements OnInit {
  private appear: boolean = false;
  uploadForm: FormGroup;
  @Output() changes = new EventEmitter();



 
  public uploader:FileUploader = new FileUploader({
    isHTML5: true
  });

  public uploaderdoc:FileUploader = new FileUploader({
    isHTML5: true
  });

  title: string = 'Angular File Upload';
  constructor(private fb: FormBuilder, private http: HttpClient , private uploadService: FileUploadService, private candidatServiceService : CandidatServiceService ) { }

  uploadSubmit(){

        for (var i = 0; i < this.uploader.queue.length; i++) {
          let fileItem = this.uploader.queue[i]._file;
          if(fileItem.size > 10000000){
            alert("Each File should be less than 10 MB of size.");
            return;
          }
        }

        for (var j = 0; j < this.uploader.queue.length; j++) {
          let data = new FormData();
          let fileItem = this.uploader.queue[j]._file;
          console.log(fileItem.name);
         // data.append('files', fileItem);
          data.append('file', fileItem);
          data.append('fileSeq', 'seq'+j);
          this.changes.emit(data);
          
       //   data.append( 'dataType', this.uploadForm.controls.type.value);
        //  this.uploadService.uploadFile(data).subscribe(data => alert('cv uploaded successfully.'));
        
        }

        




        for (var f = 0; f < this.uploaderdoc.queue.length; f++) {
          let fileItemdoc = this.uploaderdoc.queue[f]._file;
          if(fileItemdoc.size > 10000000){
            alert("Each File should be less than 10 MB of size.");
            return;
          }
        }
        
        for (var k = 0; k < this.uploaderdoc.queue.length; k++) {
          let dataDoc = new FormData();
          let fileItemdoc = this.uploaderdoc.queue[k]._file;
          console.log(fileItemdoc.name);
          dataDoc.append('docs', fileItemdoc);
          dataDoc.append('fileSeq', 'seq'+k);
          
       //   data.append( 'dataType', this.uploadForm.controls.type.value);
          this.uploadService.uploadDoc(dataDoc).subscribe(dataDoc => alert('Doc uploaded successfully.'));
        }
      

        this.uploader.clearQueue();
        this.uploaderdoc.clearQueue();
      
  }



  ngOnInit() {

  //this.candidatServiceService.getCandidateByMail("farouk.kammoun@yahoo.com")
    this.uploadForm = this.fb.group({
      document: [null, null],
     // type:  [null, Validators.compose([Validators.required])]
     
    });

  }

  toggleAppearence(){
    
    this.appear = !this.appear;
  
}




CvUploadsByMail:any;

downloadFileByMail(mail:String) {
  console.log("mail : " + mail);
  this.uploadService.downloadCvByMail({mail}).subscribe(data => { 
    console.log(data)

    this.CvUploadsByMail = data 
   saveAs(data);

  })
}




fileUploads:any;

downloadFile(id: number) {
  console.log("id : " + id);
  this.uploadService.downloadFile({id}).subscribe(data => { 
    console.log(data)

    this.fileUploads = data 
   saveAs(data);

  })
}








  CvUploads:any;

 downloadCv(id: number) {
  console.log("id : " + id);
  this.uploadService.downloadCv({id}).subscribe(data => { 
    console.log(data)

    this.CvUploads = data 
   saveAs(data);

  })
}





}


