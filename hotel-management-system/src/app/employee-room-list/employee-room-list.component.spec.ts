import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeRoomListComponent } from './employee-room-list.component';

describe('EmployeeRoomListComponent', () => {
  let component: EmployeeRoomListComponent;
  let fixture: ComponentFixture<EmployeeRoomListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeRoomListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeRoomListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
