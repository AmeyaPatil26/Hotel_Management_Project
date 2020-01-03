import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Room } from '../room-information';
import { NgForm } from '@angular/forms';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-admin-room-list',
  templateUrl: './admin-room-list.component.html',
  styleUrls: ['./admin-room-list.component.css']
})
export class AdminRoomListComponent implements OnInit {

  constructor(public roomService: RoomService) {
    this.adminRoomList();
  }
  roomList: [];

  selectRoom(roomInfo: Room) {
    this.roomService.roomInfoForUpdation(roomInfo);
  }
  adminRoomList() {
    this.roomService.adminRoomList().subscribe((data) => {
      console.log(data.roomList);
      this.roomList = data.roomList;
    },
      err => {
        console.log(err);
      }
    );
  }
  deleteRoomInfo(deleteRoom: Room) {
    console.log(deleteRoom);
    this.roomService.deleteRoomInfo(deleteRoom).subscribe(res => {
      console.log(res);
      console.log('delete');
      this.adminRoomList();
    },
      err => {
        console.log(err);
      });
  }

  updateRoomInfo(updateRoom: NgForm) {
    this.roomService.updateRoomInfo(updateRoom.value).subscribe(
      res => {
        console.log(res);
      },
      err => {
        console.log(err);
      }
    );
  }
  ngOnInit() {
  }

}
