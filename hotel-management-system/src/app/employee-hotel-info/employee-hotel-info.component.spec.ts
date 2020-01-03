import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeHotelInfoComponent } from './employee-hotel-info.component';

describe('EmployeeHotelInfoComponent', () => {
  let component: EmployeeHotelInfoComponent;
  let fixture: ComponentFixture<EmployeeHotelInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeHotelInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeHotelInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
