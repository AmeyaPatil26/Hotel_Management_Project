import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { VerticalHeaderComponent } from './vertical-header/vertical-header.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { AdminAddHotelComponent } from './admin-add-hotel/admin-add-hotel.component';
import { AdminHotelListComponent } from './admin-hotel-list/admin-hotel-list.component';
import { AdminAddRoomComponent } from './admin-add-room/admin-add-room.component';
import { AdminRoomListComponent } from './admin-room-list/admin-room-list.component';
import { AdminAddEmployeeComponent } from './admin-add-employee/admin-add-employee.component';
import { AdminEmployeeListComponent } from './admin-employee-list/admin-employee-list.component';
import { EmployeeRoomListComponent } from './employee-room-list/employee-room-list.component';
import { EmployeeHotelInfoComponent } from './employee-hotel-info/employee-hotel-info.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserHotelListComponent } from './user-hotel-list/user-hotel-list.component';
import { UserRoomListComponent } from './user-room-list/user-room-list.component';
import { UserRoomBookingComponent } from './user-room-booking/user-room-booking.component';
import { EmployeeUserRoomBookingComponent } from './employee-user-room-booking/employee-user-room-booking.component';

// tslint:disable-next-line: max-line-length
import { MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule, MatFormFieldModule, MatInputModule, MatRippleModule, MatDialogModule } from '@angular/material';
import { MatTabsModule } from '@angular/material/tabs';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import { AdminUpdateHotelComponent } from './admin-update-hotel/admin-update-hotel.component';
import { AdminUpdateEmployeeComponent } from './admin-update-employee/admin-update-employee.component';
import { AdminUpdateRoomComponent } from './admin-update-room/admin-update-room.component';
import { AdminUpdateProfileComponent } from './admin-update-profile/admin-update-profile.component';
import { LocationSearchPipe } from './location-search.pipe';
import { AdminBookingReportComponent } from './admin-booking-report/admin-booking-report.component';
import { UserBookingReportComponent } from './user-booking-report/user-booking-report.component';
import { VisitorComponent } from './visitor/visitor.component';
import { VisitorRoomComponent } from './visitor-room/visitor-room.component';
@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    HomeComponent,
    HeaderComponent,
    VerticalHeaderComponent,
    AdminProfileComponent,
    AdminAddHotelComponent,
    AdminHotelListComponent,
    AdminAddRoomComponent,
    AdminRoomListComponent,
    AdminAddEmployeeComponent,
    AdminEmployeeListComponent,
    EmployeeRoomListComponent,
    EmployeeHotelInfoComponent,
    LoginComponent,
    RegisterComponent,
    UserHotelListComponent,
    UserRoomListComponent,
    UserRoomBookingComponent,
    EmployeeUserRoomBookingComponent,
    AdminUpdateHotelComponent,
    AdminUpdateEmployeeComponent,
    AdminUpdateRoomComponent,
    AdminUpdateProfileComponent,
    LocationSearchPipe,
    AdminBookingReportComponent,
    UserBookingReportComponent,
    VisitorComponent,
    VisitorRoomComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatTabsModule,
    RouterModule,
    FormsModule,
    LayoutModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatRippleModule,
    MatDialogModule,
    HttpClientModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
