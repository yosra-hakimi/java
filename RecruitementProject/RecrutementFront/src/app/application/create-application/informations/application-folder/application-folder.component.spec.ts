import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicationFolderComponent } from './application-folder.component';

describe('ApplicationFolderComponent', () => {
  let component: ApplicationFolderComponent;
  let fixture: ComponentFixture<ApplicationFolderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApplicationFolderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplicationFolderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
