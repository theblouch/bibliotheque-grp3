import { TestBed } from '@angular/core/testing';

import { CollexionService } from './collexion-service';

describe('CollexionService', () => {
  let service: CollexionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CollexionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
