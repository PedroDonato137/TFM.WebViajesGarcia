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
  reservas:Reserva[];
  usuarioLogin:Usuario;
  constructor(private consultarReservasService:ConsultarReservasService,
    private menuComponent:MenuComponent){
      this.usuarioLogin = menuComponent.usuario;
  }
  ngOnInit(): void {
    let idn = this.menuComponent.usuario.correo;
    this.consultarReservasService.consultarReservas(1).subscribe(r=> this.reservas=r); // AQUI ESTA EL ERROR!!!
  }
}
