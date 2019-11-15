import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UInterviewComponent } from './u-interview.component';

describe('UInterviewComponent', () => {
  let component: UInterviewComponent;
  let fixture: ComponentFixture<UInterviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UInterviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UInterviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
