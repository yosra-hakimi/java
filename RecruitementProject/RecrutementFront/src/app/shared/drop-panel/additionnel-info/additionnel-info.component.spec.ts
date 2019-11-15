import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdditionnelInfoComponent } from './additionnel-info.component';

describe('AdditionnelInfoComponent', () => {
  let component: AdditionnelInfoComponent;
  let fixture: ComponentFixture<AdditionnelInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdditionnelInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdditionnelInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
