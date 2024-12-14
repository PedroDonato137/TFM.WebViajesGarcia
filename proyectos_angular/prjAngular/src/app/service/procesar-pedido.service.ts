import { CestaViajes } from '../model/CestaViajes';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProcesarPedidoService {

  constructor(private http:HttpClient) { }

  continentes():Observable<any>{
    let url="http://localhost:8001/continentes";
    return this.http.get(url);
  }

  viajesContinentes(idContinente:number):Observable<any>{
    let url="http://localhost:8001/viajes";
    let params=new HttpParams();

    params=params.append("idContinente", idContinente);

    return this.http.get(url, {"params":params});

  }

  enviarPedido(cesta:CestaViajes[], idUsuario:number):Observable<any>{
    let url="http://localhost:8002/reserva";
    let params=new HttpParams();
    params = params.append("idUsuario", idUsuario);

    return this.http.post(url, cesta, {"params":params});

  }


}
