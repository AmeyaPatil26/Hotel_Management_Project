import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUpdateHotelComponent } from './admin-update-hotel.component';

describe('AdminUpdateHotelComponent', () => {
  let component: AdminUpdateHotelComponent;
  let fixture: ComponentFixture<AdminUpdateHotelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminUpdateHotelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminUpdateHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
