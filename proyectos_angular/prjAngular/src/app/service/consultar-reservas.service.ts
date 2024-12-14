import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConsultarReservasService {

  constructor(private http:HttpClient) { }

  consultarReservas(idUsuario:number):Observable<any>{
    let url="http://localhost:8002/reservas";
    let params=new HttpParams();

    params = params.append("idUsuario", idUsuario);

    return this.http.get(url, {"params":params});

  }
}
