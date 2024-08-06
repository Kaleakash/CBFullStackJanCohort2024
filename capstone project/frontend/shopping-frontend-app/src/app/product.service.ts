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

  storeProduct(product:any):Observable<string>{
    return this.http.post(`${this.baseUrl}/store`,product,{responseType:'text'});
  }

  deleteProduct(pid:number):Observable<string> {
    return this.http.delete(`${this.baseUrl}/delete/${pid}`,{responseType:'text'});
  }

  updateProduct(product:any):Observable<string>{
    return this.http.put(`${this.baseUrl}/update`,product,{responseType:'text'});
  }
}





