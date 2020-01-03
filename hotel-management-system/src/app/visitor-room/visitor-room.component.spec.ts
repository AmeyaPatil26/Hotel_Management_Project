import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitorRoomComponent } from './visitor-room.component';

describe('VisitorRoomComponent', () => {
  let component: VisitorRoomComponent;
  let fixture: ComponentFixture<VisitorRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisitorRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisitorRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
