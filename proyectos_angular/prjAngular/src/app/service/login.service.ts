import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  login(correo:string, password:string):Observable<any>{
    let url="http://localhost:8000/autenticar";
    let params= new HttpParams();

    params=params.append("correo", correo);
    params=params.append("password", password);

    return this.http.get(url,{"params":params});
  }
}
