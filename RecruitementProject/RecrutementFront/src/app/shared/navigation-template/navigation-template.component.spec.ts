import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigationTemplateComponent } from './navigation-template.component';

describe('NavigationTemplateComponent', () => {
  let component: NavigationTemplateComponent;
  let fixture: ComponentFixture<NavigationTemplateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavigationTemplateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavigationTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
