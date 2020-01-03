import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminHotelListComponent } from './admin-hotel-list.component';

describe('AdminHotelListComponent', () => {
  let component: AdminHotelListComponent;
  let fixture: ComponentFixture<AdminHotelListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminHotelListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminHotelListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
