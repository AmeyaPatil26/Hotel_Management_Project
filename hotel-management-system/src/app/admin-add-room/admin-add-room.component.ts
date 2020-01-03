import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-admin-add-room',
  templateUrl: './admin-add-room.component.html',
  styleUrls: ['./admin-add-room.component.css']
})
export class AdminAddRoomComponent implements OnInit {

  backendRespnse: any;
  constructor(public roomService: RoomService) { }
 
  ngOnInit() {
  }
  addNewRoom(addRoom: NgForm) {
    console.log(addRoom.value);
    this.roomService.addRoom(addRoom.value).subscribe(res => {
      console.log('........response', res);
      this.backendRespnse = res;
      console.log('.....backendresponse', this.backendRespnse);
      addRoom.reset();
    },
      err => {
        console.log(err);
      });
  }

}
