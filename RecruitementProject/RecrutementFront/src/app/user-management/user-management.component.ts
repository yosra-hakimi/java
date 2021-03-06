import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.css']
})
export class UserManagementComponent implements OnInit {
private users:User[]=[];
  constructor(private userService: UserService,) { }

  ngOnInit() {
    this.users=this.userService.getAllUser();
  
  }

  onChange(){
    this.users=this.userService.getAllUser();

  }

}
