import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeUserRoomBookingComponent } from './employee-user-room-booking.component';

describe('EmployeeUserRoomBookingComponent', () => {
  let component: EmployeeUserRoomBookingComponent;
  let fixture: ComponentFixture<EmployeeUserRoomBookingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeUserRoomBookingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeUserRoomBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
