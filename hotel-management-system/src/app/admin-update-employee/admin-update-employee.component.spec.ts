import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUpdateEmployeeComponent } from './admin-update-employee.component';

describe('AdminUpdateEmployeeComponent', () => {
  let component: AdminUpdateEmployeeComponent;
  let fixture: ComponentFixture<AdminUpdateEmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminUpdateEmployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminUpdateEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
