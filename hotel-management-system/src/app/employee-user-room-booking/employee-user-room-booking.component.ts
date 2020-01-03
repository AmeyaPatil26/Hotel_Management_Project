import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-user-room-booking',
  templateUrl: './employee-user-room-booking.component.html',
  styleUrls: ['./employee-user-room-booking.component.css']
})
export class EmployeeUserRoomBookingComponent implements OnInit {

  backendRespnse: any;
  singleHotel: any;
  licenceNumber: string;
  hotelName: string;
  userDetails = JSON.parse(localStorage.getItem('token'));
  profileData: any;
  fullDate = new Date();
  year = this.fullDate.getFullYear();
  month = this.fullDate.getMonth();
  date = this.fullDate.getDate();

  todaysDate = `${this.year}-${this.month + 1}-${this.date}`;
  constructor(public employeeService: EmployeeService) {
    console.log('...................user details store from token', this.userDetails);
    this.profileData = this.userDetails.adminEmployeeUserBean;
    console.log('............user details store in profile from token', this.profileData);
    this.employeeService.getHotelInfo(this.profileData).subscribe((data) => {
      console.log('..................response from back end for hotel', data);
      this.singleHotel = data;
      this.licenceNumber = this.singleHotel.hotelInformationBean.licenceNumber;
      console.log('.....................licenceNumber', this.licenceNumber);
      this.hotelName = this.singleHotel.hotelInformationBean.hotelName;
      console.log('..............name', this.hotelName);
    });
  }


  employeeBookRoom(bookRoom: NgForm) {
    console.log(bookRoom.value);
    this.employeeService.employeeBookRoom(bookRoom.value).subscribe(res => {
      console.log('........response', res);
      this.backendRespnse = res;
      console.log('.....backendresponse', this.backendRespnse);
      bookRoom.reset();
    },
      err => {
        console.log(err);
      });
  }
  ngOnInit() {
  }

}
