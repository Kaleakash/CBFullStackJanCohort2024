import { Product } from "./product";

export class Orderinfo {
    constructor(public emailid:string,public products:Array<Product>,public totalamount:number){}
}
