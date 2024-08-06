import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerproductviewComponent } from './customerproductview.component';

describe('CustomerproductviewComponent', () => {
  let component: CustomerproductviewComponent;
  let fixture: ComponentFixture<CustomerproductviewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomerproductviewComponent]
    });
    fixture = TestBed.createComponent(CustomerproductviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
