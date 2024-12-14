import { Usuario } from '../../model/Usuario';
import { MenuComponent } from './../menu/menu.component';
import { Reserva } from '../../model/Reserva';
import { ConsultarReservasService } from './../../service/consultar-reservas.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-consultar-reservas',
  standalone: false,

  templateUrl: './consultar-reservas.component.html',
  styleUrl: './consultar-reservas.component.css'
})
export class ConsultarReservasComponent implements OnInit{

  // Variables del metodo
  reservas:Reserva[];
  usuarioLogin:Usuario;
  // Constructor
  constructor(private consultarReservasService:ConsultarReservasService,
    private menuComponent:MenuComponent){
      this.usuarioLogin = menuComponent.usuario;
  }

  // Metodo que se inicia con el contructor
  ngOnInit(): void {
    let idn = this.menuComponent.usuario.correo;
    // Error: dentro de losparentesis de consultarReserva dedveria de tener realmeten la variable idn,
    // para que almacenara el id del usuario, pero tiene un conflicto con la base de datos, ya que no se llama igual
    // el campo, he intentado arreglarlo, pero la unica solucion seria modifiacar la tabla usuarios de la base de datos
    // haciendo que tenga que cambiar tambien todos metodos del spring book repositorios 01 y 02
    this.consultarReservasService.consultarReservas(1).subscribe(r=> this.reservas=r);
  }
}
