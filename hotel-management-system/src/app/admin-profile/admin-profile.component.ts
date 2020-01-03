import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { User } from '../user-information';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {

  singleUsers: any;
  name: string;
  email: string;
  contactNumber: string;
  password: string;
  address: string;
  nationality: string;
  userDetails = JSON.parse(localStorage.getItem('token'));
  profile: any;
 // type: any;
  constructor(private auth: AuthService) {
    console.log('...................', this.userDetails);
    this.profile = this.userDetails.adminEmployeeUserBean;
    console.log('............', this.profile);
    this.auth.getProfileData(this.profile).subscribe((data) => {
      console.log('..................data', data);


      this.singleUsers = data;
      this.name = this.singleUsers.adminEmployeeUserBean.name;
      console.log('.....................name', this.name);
      this.email = this.singleUsers.adminEmployeeUserBean.email;
      this.contactNumber = this.singleUsers.adminEmployeeUserBean.contactNumber;
      this.password = this.singleUsers.adminEmployeeUserBean.password;
      this.address = this.singleUsers.adminEmployeeUserBean.address;
      this.nationality = this.singleUsers.adminEmployeeUserBean.nationality;
     // this.type = this.singleUsers.adminEmployeeUserBean.type;
      console.log('single user data', this.singleUsers);
    });
  }

  selectedUser: User = {
    id: null,
    type: null,
    name: null,
    email: null,
    contactNumber: null,
    password: null,
    address: null,
    nationality: null,


  };

  selectProfile() {
    this.auth.updateProfileInfo(this.singleUsers);
  }

  ngOnInit() {
  }

}
