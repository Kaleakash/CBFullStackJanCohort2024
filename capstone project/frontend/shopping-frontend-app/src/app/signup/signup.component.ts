import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {


  signup(loginref:NgForm): void {
    let login = loginref.value;
    console.log(login);

    loginref.reset();
  }
}
