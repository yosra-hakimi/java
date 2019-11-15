import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAppFolderComponent } from './update-app-folder.component';

describe('UpdateAppFolderComponent', () => {
  let component: UpdateAppFolderComponent;
  let fixture: ComponentFixture<UpdateAppFolderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateAppFolderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateAppFolderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
