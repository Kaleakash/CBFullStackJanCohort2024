import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

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

signin(): void {

  let login = this.loginRef.value;
  console.log(login);   // in the form of json 

  // coding 

  this.loginRef.reset();
}

}
