import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DispCandidatComponent } from './disp-candidat.component';

describe('DispCandidatComponent', () => {
  let component: DispCandidatComponent;
  let fixture: ComponentFixture<DispCandidatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DispCandidatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DispCandidatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
