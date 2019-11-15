import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PannelsComponent } from './pannels.component';

describe('PannelsComponent', () => {
  let component: PannelsComponent;
  let fixture: ComponentFixture<PannelsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PannelsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PannelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
