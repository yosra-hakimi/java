import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AnnouncementServiceService } from 'src/app/services/announcement-service.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-create-announce',
  templateUrl: './create-announce.component.html',
  styleUrls: ['./create-announce.component.css']
})
export class CreateAnnounceComponent implements OnInit {


private currentAnnounce : object ;

  
announceForm : FormGroup;
errorMessage: string;

constructor(private formBuilder: FormBuilder,
            private announceService: AnnouncementServiceService,
            private router: Router) { }

ngOnInit() {
  this.initForm();
}

initForm() {
  this.announceForm = this.formBuilder.group({
    title: ['', [Validators.required]],
    price: ['', [Validators.required]],
    Categorie:['', [Validators.required]],
    localisation:['', [Validators.required]],
    description :['', [Validators.required]]
  });
}



  onSaveAnnounce(data:any){
      console.log(data);
     this.announceService.saveAnnounce(this.announceService.host+"/announcement/add", data)
     .subscribe(res=>{

        console.log(res);
         this.router.navigateByUrl("/announces")

        this.currentAnnounce = res ;
       
     },err=>{
        console.log(err);
     })
   
    
  }



}

