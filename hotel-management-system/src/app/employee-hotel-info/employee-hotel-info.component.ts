import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-hotel-info',
  templateUrl: './employee-hotel-info.component.html',
  styleUrls: ['./employee-hotel-info.component.css']
})
export class EmployeeHotelInfoComponent implements OnInit {

  singleHotel: any;
  licenceNumber: string;
  hotelName: string;
  hotelAddress: string;
  hotelContactNumber: string;
  hotelImageURL: string;

  userDetails = JSON.parse(localStorage.getItem('token'));
  profileData: any;

  constructor(public employeeService: EmployeeService) {


    console.log('...................user details store from token', this.userDetails);
    this.profileData = this.userDetails.adminEmployeeUserBean;
    console.log('............user details store in profile from token', this.profileData);
    this.employeeService.getHotelInfo(this.profileData).subscribe((data) => {
      console.log('..................response from back end for hotel', data);
      this.singleHotel = data;
      this.licenceNumber = this.singleHotel.hotelInformationBean.licenceNumber;
      console.log('.....................name', this.licenceNumber);
      this.hotelName = this.singleHotel.hotelInformationBean.hotelName;
      this.hotelAddress = this.singleHotel.hotelInformationBean.hotelAddress;
      this.hotelContactNumber = this.singleHotel.hotelInformationBean.hotelContactNumber;
      this.hotelImageURL = this.singleHotel.hotelInformationBean.hotelImageURL;
      console.log('single user data', this.singleHotel);

    });
  }

  ngOnInit() {
  }

}
