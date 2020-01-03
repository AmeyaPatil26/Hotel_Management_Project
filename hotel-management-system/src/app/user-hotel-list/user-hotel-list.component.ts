import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Hotel } from '../hotel-information';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-hotel-list',
  templateUrl: './user-hotel-list.component.html',
  styleUrls: ['./user-hotel-list.component.css']
})
export class UserHotelListComponent implements OnInit {
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
    this.hotelService.singleHotelData(hotel); 
  }

}
