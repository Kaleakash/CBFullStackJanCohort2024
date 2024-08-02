import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  baseUrl:string ="http://localhost:8282/product";

  constructor(public http:HttpClient) { }

  viewAllProducts():Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl+"/find");
  }
}
