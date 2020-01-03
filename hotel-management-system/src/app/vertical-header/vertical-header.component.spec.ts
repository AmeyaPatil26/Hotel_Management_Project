import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VerticalHeaderComponent } from './vertical-header.component';

describe('VerticalHeaderComponent', () => {
  let component: VerticalHeaderComponent;
  let fixture: ComponentFixture<VerticalHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VerticalHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VerticalHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
