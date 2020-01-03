import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Room } from '../room-information';
import { RoomService } from '../room.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-update-room',
  templateUrl: './admin-update-room.component.html',
  styleUrls: ['./admin-update-room.component.css']
})
export class AdminUpdateRoomComponent implements OnInit {
  roomInfoForUpdate: any;

  constructor(public roomService: RoomService,public router: Router) {

    this.roomInfoForUpdate = roomService.upadateRoomInformation;
  }
 
  updateRoomInfo(updateRoom: NgForm) {
    this.roomService.updateRoomInfo(updateRoom.value).subscribe(
      res => {
        console.log(res);
        if (res != null) {
          this.router.navigateByUrl('/vertical-header/admin-room-list');
        }
      },
      err => {
        console.log(err);
      }
    );
  }
  ngOnInit() {
  }

}
