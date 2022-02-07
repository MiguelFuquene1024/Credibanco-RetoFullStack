import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomeComponent} from './vistas/home/home.component';
import {RegistrarComponent} from './vistas/registrar/registrar.component';
import {EditarComponent}from './vistas/editar/editar.component';

const routes:Routes = [
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'home',component:HomeComponent},
  {path:'registrar',component:RegistrarComponent},
  {path:'editar/:id',component:EditarComponent}

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [HomeComponent,RegistrarComponent,EditarComponent]
