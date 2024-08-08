import { Component, OnInit } from '@angular/core';
import { OrderinfoService } from '../orderinfo.service';

@Component({
  selector: 'app-orderinfo',
  templateUrl: './orderinfo.component.html',
  styleUrls: ['./orderinfo.component.css']
})
export class OrderinfoComponent implements OnInit{
  ordersInfo:Array<Object>=[];
  constructor(public orderinfoService:OrderinfoService){}

  ngOnInit(): void {
      this.orderinfoService.viewAllOrders().subscribe({
        next:(result:any)=> {
            console.log(result);
            this.ordersInfo=result;
        },
        error:(error:any)=> {
          console.log(error)
        },
        complete:()=> {
            console.log("order view")
        }
      })
  }
}
