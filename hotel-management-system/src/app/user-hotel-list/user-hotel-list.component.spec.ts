import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHotelListComponent } from './user-hotel-list.component';

describe('UserHotelListComponent', () => {
  let component: UserHotelListComponent;
  let fixture: ComponentFixture<UserHotelListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserHotelListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserHotelListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
