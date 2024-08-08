import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { CustomerdashboardComponent } from './customerdashboard/customerdashboard.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { ProductviewComponent } from './productview/productview.component';
import { Orderinfo } from './orderinfo';
import { OrderinfoComponent } from './orderinfo/orderinfo.component';

// http://localhost:4200/

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"customer",component:CustomerdashboardComponent},
  
  {path:"admin",component:AdmindashboardComponent,children:[
    {path:"",component:ProductviewComponent},
    {path:"orders",component:OrderinfoComponent}
  ]},

  {path:"login",redirectTo:"/",pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
