import { Component, OnInit } from '@angular/core';
import {ApiService} from '../../servicios/api/api.service';
import{Router}from '@angular/router';

import {ListapersonI} from '../../modelos/listaperson.interface';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  
  personas:ListapersonI[]=[];
  constructor(private api:ApiService,private router:Router) { }

  

  ngOnInit(): void {
    this.api.getPersonas().subscribe(data=>{
      this.personas = data;
    })
  }

  editarPerson(idMercancia:number){
    this.router.navigate(['editar',idMercancia]);
  }
  
  registrarPerson(){
    this.router.navigate(['registrar']);
  }

  
  
}
