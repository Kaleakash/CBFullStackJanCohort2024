import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { Orderinfo } from '../orderinfo';
import { OrderinfoService } from '../orderinfo.service';

@Component({
  selector: 'app-customerproductview',
  templateUrl: './customerproductview.component.html',
  styleUrls: ['./customerproductview.component.css']
})
export class CustomerproductviewComponent implements OnInit{
  payment_flag:boolean = false;
  total:number =0;
  emailid:string="";
  products:Array<Product>=[];
  carts:Array<Product>=[];
  constructor(public productService:ProductService,public orderInfoService:OrderinfoService){  }
flag:boolean = true;
  ngOnInit(): void {

    let obj = sessionStorage.getItem("user");
    if(obj!=null){
        this.emailid=obj;
    }

      this.productService.viewAllProducts().subscribe({
        next:(result:any)=> {
            this.products=result;
        },
        error:(error:any)=> {

        },
        complete:()=> {

        }
      })
  }

  addToCart(product:any,index:any): void {
    product.qty=1;
    let result = this.carts.find(c=>c.pid==product.pid);
    if(result==undefined){
    this.carts.push(product);
    this.total=this.total+this.carts[index].price;
    }else {
      alert("Product already present in cart")
    }
   
  }

  calculateTotalAmount() {
  this.total = this.carts.reduce((previousValue:any,currentValue:any)=> {
      console.log(previousValue+" "+currentValue.price+" "+currentValue.qty)
      return previousValue+currentValue.qty*currentValue.price;
    },0)
  }

  removeItemFromCart(index:any){
    console.log(index)
    this.total=this.total-this.carts[index].price;
    this.carts.splice(index,1);  // 
  }
  viewCart(): void {
    this.flag=false;
  }
  continueShopping(): void {
    this.flag=true;

  }

  incrementQty(index:any){
    //console.log("increment "+index)
    this.carts[index].qty=this.carts[index].qty+1
    this.calculateTotalAmount();
  }
  decrementQty(index:any){
    //console.log("decrement "+index)
    this.carts[index].qty=this.carts[index].qty-1
    this.calculateTotalAmount();
  }
  processedForPayment(): void {
      this.payment_flag=true;
  }
  payment(): void {
  let orderinfo = new Orderinfo(this.emailid,this.carts,this.total);  
  console.log(orderinfo); 
  this.orderInfoService.placeOrder(orderinfo).subscribe({
    next:(result:any)=> {
        console.log(result)
    },
    error:(error:any)=> {
        console.log(error)
    },
    complete:()=> {
        console.log("order done successfully")
    }
  }) 
  }
}
