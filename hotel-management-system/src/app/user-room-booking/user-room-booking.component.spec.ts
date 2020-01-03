import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRoomBookingComponent } from './user-room-booking.component';

describe('UserRoomBookingComponent', () => {
  let component: UserRoomBookingComponent;
  let fixture: ComponentFixture<UserRoomBookingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserRoomBookingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserRoomBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
