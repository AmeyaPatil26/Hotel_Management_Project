import { Component, OnInit } from '@angular/core';
import { Booking } from '../booking-information';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-user-room-booking',
  templateUrl: './user-room-booking.component.html',
  styleUrls: ['./user-room-booking.component.css']
})
export class UserRoomBookingComponent implements OnInit {
  bookingInfo: any;
  userInfo: any;
  licenceNumber: string;
  hotelName: string;
  roomType: string;
  roomCapacity: string;
  email: string;
  name: string;
  address: string;
  contactNumber: string;
  nationality: string;
  bookingAmount: string;
  backendRespnse: any;
  totalBillOfRoom: number;
  roomId: number;
  roomBookingStatus: any;
  dateInfo: any;
  userDetails = JSON.parse(localStorage.getItem('token'));
  fullDate = new Date();
  year = this.fullDate.getFullYear();
  month = this.fullDate.getMonth();
  date = this.fullDate.getDate();

  todaysDate = `${this.year}-${this.month + 1}-${this.date}`;
  constructor(public hotelService: HotelService) {
    this.bookingInfo = hotelService.singleRoomInfo;
    this.licenceNumber = hotelService.singleRoomInfo.licenceNumber;
    this.hotelName = hotelService.singleRoomInfo.hotelName;
    this.roomType = hotelService.singleRoomInfo.roomType;
    this.roomCapacity = hotelService.singleRoomInfo.roomCapacity;
    this.roomId = hotelService.singleRoomInfo.roomId;
    this.bookingAmount = hotelService.singleRoomInfo.roomAmount;
    console.log('....................', this.bookingAmount);
    console.log(this.userDetails);
    this.userInfo = this.userDetails.adminEmployeeUserBean;
    this.email = this.userDetails.adminEmployeeUserBean.email;
    this.name = this.userDetails.adminEmployeeUserBean.name;
    this.address = this.userDetails.adminEmployeeUserBean.address;
    this.contactNumber = this.userDetails.adminEmployeeUserBean.contactNumber;
    this.nationality = this.userDetails.adminEmployeeUserBean.nationality;

    this.totalBillOfRoom = this.hotelService.totalBill;
  }

  addUserBooking(bookUserRoom: NgForm) {
    console.log(bookUserRoom.value);
    this.hotelService.addUserBooking(bookUserRoom.value).subscribe(res => {
      console.log('........response', res);
      this.backendRespnse = res;
      console.log('.....backendresponse', this.backendRespnse);
      this.roomBookingStatus = 'Payement Done Sucessfully... Room is Booked';
      bookUserRoom.reset();
    },
      err => {
        console.log(err);
      });
  }

  calculateTotalDays(totalDays: NgForm) {
    this.hotelService.calculateTotalDays(totalDays.value);
    this.dateInfo = totalDays.value;
    console.log('...date info........................', this.dateInfo);

  }

  ngOnInit() {
  }

}
