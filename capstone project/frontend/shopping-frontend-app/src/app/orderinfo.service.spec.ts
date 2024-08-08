import { TestBed } from '@angular/core/testing';

import { OrderinfoService } from './orderinfo.service';

describe('OrderinfoService', () => {
  let service: OrderinfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrderinfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
