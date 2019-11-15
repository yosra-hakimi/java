import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AnnouncementServiceService } from 'src/app/services/announcement-service.service';

@Component({
  selector: 'app-announces',
  templateUrl: './announces.component.html',
  styleUrls: ['./announces.component.css']
})
export class AnnouncesComponent implements OnInit {
  
  public announces:any;
  

  constructor(private announceService : AnnouncementServiceService) { }



  ngOnInit() {
  }

  
  onGetAnnounce(){
    this.announceService.getAnnounce().subscribe(data=>{
      console.log(data)

     this.announces = data
     
     console.log(this.announces)

    },err => {
      console.log(err);
    })
  }
}
