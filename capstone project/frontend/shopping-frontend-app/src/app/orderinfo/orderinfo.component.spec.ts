import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderinfoComponent } from './orderinfo.component';

describe('OrderinfoComponent', () => {
  let component: OrderinfoComponent;
  let fixture: ComponentFixture<OrderinfoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OrderinfoComponent]
    });
    fixture = TestBed.createComponent(OrderinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
