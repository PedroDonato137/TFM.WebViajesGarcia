import { MenuComponent } from './../menu/menu.component';
import { LoginService } from './../../service/login.service';
import { Component } from '@angular/core';
import { Usuario } from '../../model/Usuario';

@Component({
  selector: 'app-login',
  standalone: false,

  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  correo:string;
  password:string;
  usuario:Usuario;
  constructor(private loginService:LoginService,
    private menuComponent:MenuComponent){

  }

  login(){
    this.loginService.login(this.correo, this.password).subscribe(data=>{
      this.usuario=data;
      if(this.usuario!=null){
        this.menuComponent.usuario=this.usuario;
        this.menuComponent.enabled=true;
        alert("Usuario autenticado");
      }else{
        alert("Usuario no autenticado");
      }
    });


  }

}
