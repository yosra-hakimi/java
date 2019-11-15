import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiplayAppFolderComponent } from './diplay-app-folder.component';

describe('DiplayAppFolderComponent', () => {
  let component: DiplayAppFolderComponent;
  let fixture: ComponentFixture<DiplayAppFolderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiplayAppFolderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiplayAppFolderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
