import { DeclareFunctionStmt, NONE_TYPE } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonI } from '../../modelos/person.interface';
import {ResponseI}from '../../modelos/response.interface';
import {AlertasService}from '../../servicios/alertas/alertas.service';
import { ApiService } from '../../servicios/api/api.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  constructor(private activerouter: ActivatedRoute, private router: Router, private api: ApiService,private alertas:AlertasService) { }

  /*datosProducto =():MercanciaI=>({
    id:'',
    nombreProducto:'',
    cantidad:'',
    fechaIngreso:'',
    usuario:''
  });*/
  datosPerson: PersonI = {} as PersonI;


  editarForm = new FormGroup({
    id:new FormControl(''),
    fullname: new FormControl(''),
    birth: new FormControl(''),
    mother: new FormControl(''),
    father: new FormControl(''),
    child: new FormControl('')
  });

  ngOnInit(): void {
    let personid = this.activerouter.snapshot.paramMap.get('id');
    if (personid) {
      this.api.getPerson(personid).subscribe(data => {
        this.datosPerson = data;
        this.editarForm.setValue({
          'id':this.activerouter.snapshot.paramMap.get('id'),
          'fullname': this.datosPerson.fullname,
          'birth': this.datosPerson.birth,
          'mother': this.datosPerson.mother,
          'father': this.datosPerson.father,
          'child': this.datosPerson.child

        });
      })
    }
  }
  postForm(form: PersonI) {

    let personid = this.activerouter.snapshot.paramMap.get('id');
    if (personid) {
      this.api.putPerson(form, personid).subscribe(data => {
      let respuesta:ResponseI = data;
      console.log(data)
      console.log(respuesta.status);
      
      if(data){
        this.alertas.showSuccess('Datos modificados correctamente','Hecho');
      }else{
        this.alertas.showError('El nombre de la persona debe ser unico','Error');
      }
      
      })
    }
  }
  eliminarPerson() {
      let datos: PersonI = this.editarForm.value;
      this.api.deletePerson(datos).subscribe(data => {
        console.log(data)
        console.log(data.status)
        let respuesta:ResponseI = data;
      if(data){
        this.alertas.showSuccess('Persona eliminada','Hecho');
        this.router.navigate(['home']);
      }else{
        this.alertas.showError('Solo puede eliminarlo el usuario que registro el producto','Error');
      }
      })
  }

  salir(){
    this.router.navigate(['home'])
  }
}
