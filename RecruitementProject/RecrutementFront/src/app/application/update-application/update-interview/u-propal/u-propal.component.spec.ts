import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UPropalComponent } from './u-propal.component';

describe('UPropalComponent', () => {
  let component: UPropalComponent;
  let fixture: ComponentFixture<UPropalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UPropalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UPropalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
