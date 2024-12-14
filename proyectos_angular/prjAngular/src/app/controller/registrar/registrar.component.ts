import { Router } from '@angular/router';
import { Usuario } from '../../model/Usuario';
import { RegistrarService } from './../../service/registrar.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-registrar',
  standalone: false,

  templateUrl: './registrar.component.html',
  styleUrl: './registrar.component.css'
})
export class RegistrarComponent {
  usuario:Usuario=new Usuario();
  constructor(private registrarService:RegistrarService,
    private router:Router){

  }

  // este metodo es para gestionar las opciones del "formulario" registrar, una vez registrado, manda el boton a la pagina portada
  registrar(){
    this.registrarService.registrar(this.usuario).subscribe({
      next:data=>this.router.navigate(["/login"]),
      error:err=>alert("Usuario ya existente, no se pudo registrar!")
    });
  }

}
