import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminBookingReportComponent } from './admin-booking-report.component';

describe('AdminBookingReportComponent', () => {
  let component: AdminBookingReportComponent;
  let fixture: ComponentFixture<AdminBookingReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminBookingReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminBookingReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
