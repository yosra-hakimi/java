import { Component, OnInit, Input } from '@angular/core';
import { FileUploadService } from 'src/app/services/file-upload.service';

import { saveAs } from 'file-saver';
import { Candidat } from 'src/app/models/Candidat';

@Component({
  selector: 'app-update-documents',
  templateUrl: './update-documents.component.html',
  styleUrls: ['./update-documents.component.css']
})
export class UpdateDocumentsComponent implements OnInit {


  private appear: boolean = false;
  
  @Input() candidat: Candidat;
  CvUploadsByMail:any;
  constructor(private uploadService: FileUploadService) { }
  

  ngOnInit() {
  }


  toggleAppearence(){
    
    this.appear = !this.appear;
  
}




downloadFileByMail() {
  this.uploadService.downloadCvByMail(this.candidat.mail).subscribe(data => { 

    this.CvUploadsByMail = data 
   saveAs(data);

  })
}

}
