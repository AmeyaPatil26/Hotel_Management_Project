import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-user-booking-report',
  templateUrl: './user-booking-report.component.html',
  styleUrls: ['./user-booking-report.component.css']
})
export class UserBookingReportComponent implements OnInit {
  userDetails = JSON.parse(localStorage.getItem('token'));
  userData: any;
  bookingList: any;
  constructor(public hotelService: HotelService) {

    // console.log(this.bookingList);
    // console.log('......................booking list from ts user..', this.hotelService.userBookingInfo);

    // console.log('.................booking report adminBookingReport', this.hotelService.userBookingInfo);
    // this.bookingList = this.hotelService.userBookingInfo;
    //  console.log('.................booking report', this.bookingList);


    this.userBookingReport();
  }



  userBookingReport() {
    this.userData = this.userDetails.adminEmployeeUserBean;
    this.hotelService.userBookingReport(this.userData).subscribe((response) => {
      console.log('.......userBookingReport', response);

      this.bookingList = response.bookingDetailsList;
      console.log('....bookingDetailsList', this.bookingList);

    },
      err => {
        console.log(err);
      }
    );
  }


  deleteRoomBooking(data){
    console.log(data);
    this.hotelService.deleteRoomBooking(data).subscribe(res => {
      console.log(res);
      console.log('delete');
      this.userBookingReport();
    },
      err => {
        console.log(err);
      });
  }
  ngOnInit() {
  }



}
