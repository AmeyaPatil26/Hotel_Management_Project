import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddHotelComponent } from './admin-add-hotel.component';

describe('AdminAddHotelComponent', () => {
  let component: AdminAddHotelComponent;
  let fixture: ComponentFixture<AdminAddHotelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAddHotelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
