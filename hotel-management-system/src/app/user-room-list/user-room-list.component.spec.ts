import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRoomListComponent } from './user-room-list.component';

describe('UserRoomListComponent', () => {
  let component: UserRoomListComponent;
  let fixture: ComponentFixture<UserRoomListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserRoomListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserRoomListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
