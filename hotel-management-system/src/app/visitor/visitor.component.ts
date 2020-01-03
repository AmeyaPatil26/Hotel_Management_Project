import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-visitor',
  templateUrl: './visitor.component.html',
  styleUrls: ['./visitor.component.css']
})
export class VisitorComponent implements OnInit {
  hotelList: [];
  selectedHotelData: any;

  constructor(public hotelService: HotelService, private router: Router) {
    this.adminHotelList();

  }

  ngOnInit() {
  }
  adminHotelList() {
    this.hotelService.adminHotelList().subscribe((data) => {
      console.log(data.hotelList);
      this.hotelList = data.hotelList;
    },
      err => {
        console.log(err);
      }
    );
  }
  userRoomList(hotel) {
    this.selectedHotelData = hotel;
    this.hotelService.singleHotelDataForVisitor(hotel);
  }



}
