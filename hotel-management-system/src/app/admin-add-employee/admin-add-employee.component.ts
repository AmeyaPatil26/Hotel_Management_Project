import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-admin-add-employee',
  templateUrl: './admin-add-employee.component.html',
  styleUrls: ['./admin-add-employee.component.css']
})
export class AdminAddEmployeeComponent implements OnInit {

  backendRespnse: any;
  constructor(public employeeService: EmployeeService) { }

  ngOnInit() {
  }





  addNewEmployee(addEmployee: NgForm) {
    console.log(addEmployee.value);
    this.employeeService.addEmployee(addEmployee.value).subscribe(res => {
      console.log('........response', res);
      this.backendRespnse = res;
      console.log('.....backendresponse', this.backendRespnse);
      addEmployee.reset();
    },
      err => {
        console.log(err);
      });
  }
}
