import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor(private authService:AuthService) { }

  

  ngOnInit() {
    
  }

  getEnableApplicationManagement(){
    if(this.authService.profile=='backOfficeManager')
      return true;
    if(this.authService.profile=='collaborater')
      return true;
    return false;


  }

}
