import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  msg:string ="";
  constructor(public ls:LoginService){} // DI for login service 

  signup(loginref:NgForm): void {
    let login = loginref.value;
    console.log(login);

    this.ls.signUp(login).subscribe({
      next:(result:any)=> {
        this.msg=result
      },
      error:(error:any)=> {
        console.log(error)
      },
      complete:()=> {
        console.log("signup done!")
      }
    })

    loginref.reset();
  }
}
