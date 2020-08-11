import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './Component/user/user.component';
import { AdminComponent } from './Component/admin/admin.component';
import { AdminLandComponent } from './Component/admin-land/admin-land.component';
import { LoginComponent } from './Component/login/login.component'
import {UserLandComponent } from './Component/user-land/user-land'

const routes: Routes = [
  {path:'',component:AdminComponent},
  {path:'signup',component:UserComponent},
  {path:'login',component:LoginComponent},
  {path:'admin_land',component:AdminLandComponent}
  {path:'user_land',component:UserLandComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
