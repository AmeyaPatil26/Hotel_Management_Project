import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUpdateProfileComponent } from './admin-update-profile.component';

describe('AdminUpdateProfileComponent', () => {
  let component: AdminUpdateProfileComponent;
  let fixture: ComponentFixture<AdminUpdateProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminUpdateProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminUpdateProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
