import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';

@Component({
  selector: 'app-customerproductview',
  templateUrl: './customerproductview.component.html',
  styleUrls: ['./customerproductview.component.css']
})
export class CustomerproductviewComponent implements OnInit{
  total:number =0;
  products:Array<Product>=[];
  carts:Array<Product>=[];
  constructor(public productService:ProductService){  }
flag:boolean = true;
  ngOnInit(): void {
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

  addToCart(product:any): void {
    product.qty=1;
    let result = this.carts.find(c=>c.pid==product.pid);
    if(result==undefined){
    this.carts.push(product);
    }else {
      alert("Product already present in cart")
    }
   
  }

  findTotal(price:number,qty:number): void {

  }

  removeItemFromCart(index:any){
    console.log(index)
    this.carts.splice(index,1);  // 
  }
  viewCart(): void {
    this.flag=false;
    for(let i=0;i<this.carts.length;i++){
      this.total= this.total+this.carts[i].price;
    }
  }
  continueShopping(): void {
    this.flag=true;
    this.total=0;
  }

  incrementQty(index:any){
    //console.log("increment "+index)
    this.carts[index].qty=this.carts[index].qty+1
  }
  decrementQty(index:any){
    //console.log("decrement "+index)
    this.carts[index].qty=this.carts[index].qty-1
  }

}
