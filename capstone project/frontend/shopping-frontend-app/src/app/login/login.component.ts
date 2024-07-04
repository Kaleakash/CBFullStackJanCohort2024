import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
loginRef = new FormGroup({
emailid:new FormControl(),
password:new FormControl(),
typeofuser:new FormControl()
});
msg:string ="";

constructor(public ls:LoginService,public router:Router){}  // DI for service layer. 
signin(): void {

  let login = this.loginRef.value;
  console.log(login);   // in the form of json 

  // coding 
  //this.ls.signIn(login);   // calling service layer.
  this.ls.signIn(login).subscribe({
    next:(result:any)=> {
          this.msg=result;
          if(this.msg=="Admin login successfully"){
              this.router.navigate(["admin"],{skipLocationChange:true});
          }else if(this.msg=="Customer login successfully"){
            sessionStorage.setItem("user",login.emailid);  
            this.router.navigate(["customer"],{skipLocationChange:true});
          }else {

          }
    },
    error:(error:any)=> {
        console.log(error);
    },
    complete:()=>console.log("signin done!")

  }) 
  this.loginRef.reset();
}

}
