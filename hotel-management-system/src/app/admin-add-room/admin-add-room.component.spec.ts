import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddRoomComponent } from './admin-add-room.component';

describe('AdminAddRoomComponent', () => {
  let component: AdminAddRoomComponent;
  let fixture: ComponentFixture<AdminAddRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAddRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
