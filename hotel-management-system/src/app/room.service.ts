import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class RoomService {

  upadateRoomInformation: any;
  constructor(private http: HttpClient, public router: Router) { }



  adminRoomList() {
    return this.http.get<any>('http://localhost:8080/getRoomList');

  }

  deleteRoomInfo(data) {
    console.log(data);
    return this.http.delete(`http://localhost:8080/deleteRoom/${data.roomId}`);
  }

  updateRoomInfo(data) {
    console.log(data);
    return this.http.put('http://localhost:8080/updateRoomInforamtion', data);
  }

  addRoom(data): Observable<any> {
    console.log(data);
    return this.http.put<any>('http://localhost:8080/addRoomInformation', data);
  }

  roomInfoForUpdation(roomInfo) {
    console.log('...........in hotel service..........', roomInfo);
    this.upadateRoomInformation = roomInfo;

    console.log('.......updateHotelInfo.......', this.upadateRoomInformation);
    this.router.navigateByUrl('/vertical-header/admin-update-room');
  }

}
