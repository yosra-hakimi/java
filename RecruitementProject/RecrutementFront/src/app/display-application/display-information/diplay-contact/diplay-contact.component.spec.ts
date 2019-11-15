import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiplayContactComponent } from './diplay-contact.component';

describe('DiplayContactComponent', () => {
  let component: DiplayContactComponent;
  let fixture: ComponentFixture<DiplayContactComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiplayContactComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiplayContactComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
