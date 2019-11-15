import { TestBed } from '@angular/core/testing';

import { UniversityServiceService } from './university-service.service';

describe('UniversityServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UniversityServiceService = TestBed.get(UniversityServiceService);
    expect(service).toBeTruthy();
  });
});
