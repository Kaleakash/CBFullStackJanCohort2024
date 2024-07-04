import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customerdashboard',
  templateUrl: './customerdashboard.component.html',
  styleUrls: ['./customerdashboard.component.css']
})
export class CustomerdashboardComponent implements OnInit{
  emailid:string ="";
  
  ngOnInit(): void {
    let obj = sessionStorage.getItem("user");
    if(obj!=null){
        this.emailid=obj;
    }
  }
}
