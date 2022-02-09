import { Component, OnInit } from '@angular/core';
import { PersonI } from '../../modelos/person.interface';
import {ResponseI}from '../../modelos/response.interface';
import { ActivatedRoute, Router } from '@angular/router';
import {AlertasService}from '../../servicios/alertas/alertas.service';
import { ApiService } from '../../servicios/api/api.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-registrar',
  templateUrl: './registrar.component.html',
  styleUrls: ['./registrar.component.css']
})
export class RegistrarComponent implements OnInit {

  registroForm = new FormGroup({
    id:new FormControl(''),
    fullname: new FormControl(''),
    birth: new FormControl(''),
    mother: new FormControl(''),
    father: new FormControl(''),
    child: new FormControl('')
  });

  constructor(private api:ApiService,private router:Router,private alert:AlertasService) { }

  postForm(form:PersonI){
    this.api.postPerson(form).subscribe(data=>{
      console.log(data);
    })
  }
  ngOnInit(): void {
  }

  salir(){
    this.router.navigate(['home'])
  }
  
}
