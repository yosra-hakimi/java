import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypographieComponent } from './typographie.component';

describe('TypographieComponent', () => {
  let component: TypographieComponent;
  let fixture: ComponentFixture<TypographieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypographieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypographieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
