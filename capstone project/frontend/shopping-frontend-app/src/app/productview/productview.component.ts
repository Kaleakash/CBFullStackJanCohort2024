import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-productview',
  templateUrl: './productview.component.html',
  styleUrls: ['./productview.component.css']
})
export class ProductviewComponent implements OnInit{

  products:Array<Product>=[];
  constructor(public productService:ProductService) {

  }
  ngOnInit(): void {
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
}
