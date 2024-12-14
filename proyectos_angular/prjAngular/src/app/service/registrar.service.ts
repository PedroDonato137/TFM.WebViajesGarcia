import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../model/Usuario';

@Injectable({
  providedIn: 'root'
})
export class RegistrarService {

  constructor(private http:HttpClient) { }

  registrar(usuario:Usuario):Observable<any>{
    let url="http://localhost:8000/registrar";
    return this.http.post(url, usuario);
  }
}
