import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { LoginService } from '../login.service';

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

constructor(public ls:LoginService){}  // DI for service layer. 
signin(): void {

  let login = this.loginRef.value;
  console.log(login);   // in the form of json 

  // coding 
  //this.ls.signIn(login);   // calling service layer.
  this.ls.signIn(login).subscribe({
    next:(result:any)=> {
          this.msg=result;
    },
    error:(error:any)=> {
        console.log(error);
    },
    complete:()=>console.log("signin done!")

  }) 
  this.loginRef.reset();
}

}
