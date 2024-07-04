import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseUrl:string ="http://localhost:8181/login";

  constructor(public http:HttpClient) { } // DI for HttpClient reference. 

  // signIn(login:any): void {
  //     this.http.post(this.baseUrl+"/signin",login,{responseType:'text'}).subscribe({
  //       next:(result)=>console.log(result),
  //       error:(error)=>console.log(error),
  //       complete:()=>console.log("signin done!")
  //     });
      
  // }

  signIn(login:any): Observable<string> {
    return this.http.post(this.baseUrl+"/signin",login,{responseType:'text'});
  }

  signUp(login:any): Observable<string> {
    return this.http.post(this.baseUrl+"/signup",login,{responseType:'text'});
  }

  
}


