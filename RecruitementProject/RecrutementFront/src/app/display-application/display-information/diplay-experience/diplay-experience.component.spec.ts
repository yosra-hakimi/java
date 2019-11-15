import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiplayExperienceComponent } from './diplay-experience.component';

describe('DiplayExperienceComponent', () => {
  let component: DiplayExperienceComponent;
  let fixture: ComponentFixture<DiplayExperienceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiplayExperienceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiplayExperienceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
