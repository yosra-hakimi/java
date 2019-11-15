import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DropPanelComponent } from './drop-panel.component';

describe('DropPanelComponent', () => {
  let component: DropPanelComponent;
  let fixture: ComponentFixture<DropPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DropPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DropPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
