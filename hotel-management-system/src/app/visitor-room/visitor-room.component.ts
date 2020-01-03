import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-visitor-room',
  templateUrl: './visitor-room.component.html',
  styleUrls: ['./visitor-room.component.css']
})
export class VisitorRoomComponent implements OnInit {

  roomList: [];

  constructor(public hotelService: HotelService, private router: Router) {
    if (this.hotelService.roomList != null) {
      this.roomList = hotelService.roomList;
      console.log('........................', this.roomList);
    }
  }

  ngOnInit() {
  }

}
