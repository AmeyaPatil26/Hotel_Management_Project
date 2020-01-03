import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-admin-booking-report',
  templateUrl: './admin-booking-report.component.html',
  styleUrls: ['./admin-booking-report.component.css']
})
export class AdminBookingReportComponent implements OnInit {

  bookingList: any;
  constructor(public hotelService: HotelService) {
    // console.log('.................booking report adminBookingReport', this.hotelService.adminBookingReport.bookingDetails);
    // this.bookingList = this.hotelService.adminBookingReport;
    // console.log('.................booking report', this.bookingList);
    this.adminBookingReport();
  }

  adminBookingReport() {
    this.hotelService.adminBookingReport().subscribe((data) => {
      console.log('...........data',data.bookingDetailsList);
      this.bookingList = data.bookingDetailsList;
    },
      err => {
        console.log(err);
      }
    );
  }
  ngOnInit() {
  }

}
