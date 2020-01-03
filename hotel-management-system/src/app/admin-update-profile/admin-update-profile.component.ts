import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-update-profile',
  templateUrl: './admin-update-profile.component.html',
  styleUrls: ['./admin-update-profile.component.css']
})
export class AdminUpdateProfileComponent implements OnInit {
  employeeInfo: any;
  constructor(private auth: AuthService, public router: Router) {
    this.employeeInfo = this.auth.updateProfileInformation.adminEmployeeUserBean;
    console.log(',,,,,,,,,,,,,,',this.employeeInfo);
  }

  ngOnInit() {
  }
  updateProfileForm(updateProfile: NgForm) {
    this.auth.updateProfileForm(updateProfile.value).subscribe(
      res => {
        console.log(res);
        if (res != null) {
          this.router.navigateByUrl('/vertical-header/admin-profile');
        }
      },
      err => {
        console.log(err);
      }
    );
  }
}
