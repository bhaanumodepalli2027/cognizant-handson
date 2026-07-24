import { TestBed } from '@angular/core/testing';

import { LoadingService } from './loading';

describe('LoadingService', () => {

  let service: LoadingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoadingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should emit true when show() is called', () => {
    service.show();

    service.isLoading$.subscribe(value => {
      expect(typeof value).toBe('boolean');
    });
  });

  it('should emit false when hide() is called', () => {
    service.hide();

    service.isLoading$.subscribe(value => {
      expect(typeof value).toBe('boolean');
    });
  });

});
