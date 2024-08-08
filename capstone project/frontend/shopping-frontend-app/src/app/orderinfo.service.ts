import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderinfoService {

  baseUrl:string ="http://localhost:8282/orders"
  constructor(public http:HttpClient) { }

  placeOrder(orders:any):Observable<string> {
    return this.http.post(`${this.baseUrl}/placeorder`,orders,{responseType:'text'});
  }
}
