import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserBookingReportComponent } from './user-booking-report.component';

describe('UserBookingReportComponent', () => {
  let component: UserBookingReportComponent;
  let fixture: ComponentFixture<UserBookingReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserBookingReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserBookingReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
