import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-productview',
  templateUrl: './productview.component.html',
  styleUrls: ['./productview.component.css']
})
export class ProductviewComponent implements OnInit{

  products:Array<Product>=[];
  productRef = new FormGroup({
    pid:new FormControl(),
    pname:new FormControl(),
    price:new FormControl(),
    qty:new FormControl(),
    imageurl:new FormControl()
  });
  msg:string ="";
  buttonMsg:string ="Add Product";
  constructor(public productService:ProductService) {

  }
  ngOnInit(): void {
      this.retrieveProduct();
  }

  retrieveProduct(): void {
    this.productService.viewAllProducts().subscribe({
      next:(result:any)=> {
          this.products=result;
      },
      error:(error:any)=> {
          console.log(error)
      },
      complete:()=> {
        console.log("data loaded..")
      }
    })
  }
  storeProduct(): void {
    let product = this.productRef.value;
    //console.log(product);
    if(this.buttonMsg=="Add Product"){
    this.productService.storeProduct(product).subscribe({
      next:(result:any)=> {
            this.msg=result;
      },
      error:(error:any)=> {
            console.log(error)
      },
      complete:()=> {
          console.log("store done!")
          this.retrieveProduct();
      }
    })
  }else {
     this.productService.updateProduct(product).subscribe({
      next:(result:any)=> {
        this.msg=result
      },
      error:(error:any)=> {
        console.log(error)
      },
      complete:()=> {
        console.log("update done!")
        this.retrieveProduct();
        this.buttonMsg="Add Product"
      }
     })
  }
  this.productRef.reset();
  }

  deleteProduct(pid:number): void {
    //
    console.log("delete event fired "+pid)
    this.productService.deleteProduct(pid).subscribe({
      next:(result:any)=> {
          this.msg=result;
      },
      error:(error:any)=> {
          console.log(error)
      },
      complete:()=> {
          this.retrieveProduct();
      }
    })
  }

  updateProduct(product:any): void {
    //console.log("update event fired")
    console.log(product)
    this.buttonMsg="Update Product";
    this.productRef.get("pid")?.setValue(product.pid);
    this.productRef.get("pname")?.setValue(product.pname);
    this.productRef.get("price")?.setValue(product.price);
    this.productRef.get("qty")?.setValue(product.qty);
    this.productRef.get("imageurl")?.setValue(product.imageurl);
  }

}


