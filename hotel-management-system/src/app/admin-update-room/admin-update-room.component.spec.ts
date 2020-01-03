import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUpdateRoomComponent } from './admin-update-room.component';

describe('AdminUpdateRoomComponent', () => {
  let component: AdminUpdateRoomComponent;
  let fixture: ComponentFixture<AdminUpdateRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminUpdateRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminUpdateRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
