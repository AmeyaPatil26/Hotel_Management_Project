import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { AdminHotelListComponent } from './admin-hotel-list/admin-hotel-list.component';
import { AuthGuard } from './auth.guard';
import { UserHotelListComponent } from './user-hotel-list/user-hotel-list.component';
import { VerticalHeaderComponent } from './vertical-header/vertical-header.component';
import { EmployeeHotelInfoComponent } from './employee-hotel-info/employee-hotel-info.component';
import { AdminAddHotelComponent } from './admin-add-hotel/admin-add-hotel.component';
import { AdminRoomListComponent } from './admin-room-list/admin-room-list.component';
import { AdminAddRoomComponent } from './admin-add-room/admin-add-room.component';
import { AdminEmployeeListComponent } from './admin-employee-list/admin-employee-list.component';
import { AdminAddEmployeeComponent } from './admin-add-employee/admin-add-employee.component';
import { EmployeeRoomListComponent } from './employee-room-list/employee-room-list.component';
import { EmployeeUserRoomBookingComponent } from './employee-user-room-booking/employee-user-room-booking.component';
import { UserRoomListComponent } from './user-room-list/user-room-list.component';
import { UserRoomBookingComponent } from './user-room-booking/user-room-booking.component';
import { AdminUpdateHotelComponent } from './admin-update-hotel/admin-update-hotel.component';
import { AdminUpdateRoomComponent } from './admin-update-room/admin-update-room.component';
import { AdminUpdateEmployeeComponent } from './admin-update-employee/admin-update-employee.component';
import { AdminUpdateProfileComponent } from './admin-update-profile/admin-update-profile.component';
import { UserBookingReportComponent } from './user-booking-report/user-booking-report.component';
import { AdminBookingReportComponent } from './admin-booking-report/admin-booking-report.component';
import { VisitorComponent } from './visitor/visitor.component';
import { VisitorRoomComponent } from './visitor-room/visitor-room.component';


const routes: Routes = [

  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'visitor', component: VisitorComponent },
  { path: 'visitorroom', component: VisitorRoomComponent},
  {
    path: 'vertical-header',
    component: VerticalHeaderComponent,

    children: [                          // <---- child components declared here
      {
        path: 'admin-profile',
        component: AdminProfileComponent

      },
      {
        path: 'admin-update-profile',
        component: AdminUpdateProfileComponent

      },
      {
        path: 'admin-hotel-list',
        component: AdminHotelListComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Admin']
        }
      },
      {
        path: 'admin-add-hotel',
        component: AdminAddHotelComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Admin']
        }
      },
      {
        path: 'admin-update-hotel',
        component: AdminUpdateHotelComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Admin']
        }
      },
      {
        path: 'admin-room-list',
        component: AdminRoomListComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Admin']
        }
      },
      {
        path: 'admin-add-room',
        component: AdminAddRoomComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Admin']
        }
      },
      {
        path: 'admin-update-room',
        component: AdminUpdateRoomComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Admin']
        }
      },
      {
        path: 'admin-employee-list',
        component: AdminEmployeeListComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Admin']
        }
      },
      {
        path: 'admin-update-employee',
        component: AdminUpdateEmployeeComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Admin']
        }
      },
      {
        path: 'admin-add-employee',
        component: AdminAddEmployeeComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Admin']
        }
      },
      {
        path: 'admin-booking-report',
        component: AdminBookingReportComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Admin']
        }
      },
      {
        path: 'user-hotel-list',
        component: UserHotelListComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['User']
        }
      },
      {
        path: 'user-room-list',
        component: UserRoomListComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['User']
        }
      },
      {
        path: 'user-booking-report',
        component: UserBookingReportComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['User']
        }
      },
      {
        path: 'user-room-booking',
        component: UserRoomBookingComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['User']
        }
      },
      {
        path: 'employee-hotel-info',
        component: EmployeeHotelInfoComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Employee']
        }
      },
      {
        path: 'employee-room-list',
        component: EmployeeRoomListComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Employee']
        }
      },
      {
        path: 'employee-user-booking',
        component: EmployeeUserRoomBookingComponent,
        canActivate: [AuthGuard], data: {
          expectedRole: ['Employee']
        }
      },

    ]

  }
  ,
  { path: '**', component: PageNotFoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
