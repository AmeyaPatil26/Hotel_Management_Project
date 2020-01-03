import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Hotel } from '../hotel-information';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-update-hotel',
  templateUrl: './admin-update-hotel.component.html',
  styleUrls: ['./admin-update-hotel.component.css']
})
export class AdminUpdateHotelComponent implements OnInit {

  hotelInfoForUpdate: any;
  constructor(public hotelService: HotelService, public router: Router) {
 
    this.hotelInfoForUpdate = this.hotelService.upadateHotelInformation;
    console.log('........hotelInfoForUpdate..............', this.hotelInfoForUpdate);
  }
  hotelList: [];
  selectedHotel: Hotel = {
    hotelId: null,
    licenceNumber: null,
    hotelName: null,
    hotelAddress: null,
    hotelContactNumber: null,
    hotelImageURL: null,

  };


  updateHotelInfo(updateHotel: NgForm) {
    console.log('....................admin update hotel....', updateHotel.value);
    this.hotelService.updateHotelInfo(updateHotel.value).subscribe(
      res => {
        console.log(res);
        if (res != null) {
          this.router.navigateByUrl('/vertical-header/admin-hotel-list');
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
