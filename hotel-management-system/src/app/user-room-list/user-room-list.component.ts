import { Component, OnInit, Input } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Room } from '../room-information';
import { Router } from '@angular/router';
import { Booking } from '../booking-information';

@Component({
  selector: 'app-user-room-list',
  templateUrl: './user-room-list.component.html',
  styleUrls: ['./user-room-list.component.css']
})
export class UserRoomListComponent implements OnInit {
  roomList: any;

  constructor(public hotelService: HotelService, private router: Router) {

    if (hotelService.roomList != null) {
      this.roomList = hotelService.roomList;
      console.log(this.roomList);
    }
  }

  ngOnInit() {
  }

  userRoomBook(room: Room) {
    if (room.roomStatus === 'Available' && room.roomCount > 0) {
      this.hotelService.userRoomBooking(room);

    }
  }


}
