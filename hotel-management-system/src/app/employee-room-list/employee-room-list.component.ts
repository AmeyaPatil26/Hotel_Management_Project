import { Component, OnInit } from '@angular/core';
import { RoomService } from '../room.service';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-room-list',
  templateUrl: './employee-room-list.component.html',
  styleUrls: ['./employee-room-list.component.css']
})
export class EmployeeRoomListComponent implements OnInit {

  getData: any;
  roomList: [];
  userDetails = JSON.parse(localStorage.getItem('token'));
  profileData: any;
  constructor(public employeeService: EmployeeService) {
    this.employeeRoomList();
  }

  ngOnInit() {
  }

  employeeRoomList() {
    this.profileData = this.userDetails.adminEmployeeUserBean;
    this.employeeService.employeeRoomList(this.profileData).subscribe((data) => {
      console.log(data);
      this.getData = data;
      this.roomList = this.getData.roomList;
      this.employeeService.employeeRoomListData(this.roomList);
    },
      err => {
        console.log(err);
      }
    );
  }

}
