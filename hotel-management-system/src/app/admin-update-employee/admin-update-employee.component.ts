import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee-information';
import { NgForm } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-update-employee',
  templateUrl: './admin-update-employee.component.html',
  styleUrls: ['./admin-update-employee.component.css']
})
export class AdminUpdateEmployeeComponent implements OnInit {
  employeeInfoForUpdate: any;

  constructor(public employeeService: EmployeeService, public router: Router) {
    this.employeeInfoForUpdate = this.employeeService.upadateEmployeeInformation;
  }


  updateEmployeeInfo(updateEmployee: NgForm) {
    this.employeeService.updateEmployeeInfo(updateEmployee.value).subscribe(
      res => {
        console.log(res);
        if (res != null) {
          this.router.navigateByUrl('/vertical-header/admin-employee-list');
        }
      },
      err => {
        console.log(err);
      }
    );
  }

  ngOnInit() {
  }


}

