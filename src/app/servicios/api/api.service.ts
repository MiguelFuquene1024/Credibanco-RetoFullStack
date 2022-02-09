import { Injectable } from '@angular/core';

import {ListapersonI}from '../../modelos/listaperson.interface';
import {PersonI}from '../../modelos/person.interface';
import{ResponseI}from '../../modelos/response.interface';

import {HttpClient,HttpHeaders} from '@angular/common/http';

import {from, Observable}from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ApiService {
  url:string = "http://localhost:8081/api/person/";
  constructor(private http:HttpClient) { }

  getPersonas():Observable<ListapersonI[]>{
    let direccion = this.url 
    return this.http.get<ListapersonI[]>(direccion);
  }

  getPerson(id:string):Observable<PersonI>{
    let direccion =this.url+id;
    return this.http.get<PersonI>(direccion);

  }

  putPerson(form:PersonI,idPerson:string):Observable<ResponseI>{
    let direccion = this.url+idPerson;
    return this.http.put<ResponseI>(direccion,form); 
  }
  deletePerson(form:PersonI):Observable<ResponseI>{
    let direccion = this.url;
    let options={
      headers: new HttpHeaders({
        'conten-type':'application/json'
      }),
      body:form
    }
    return this.http.delete<ResponseI>(direccion,options);
  }

  postPerson(form:PersonI):Observable<ResponseI>{
    let direccion = this.url;
    return this.http.post<ResponseI>(direccion,form);
  }
}