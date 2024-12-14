import { MenuComponent } from './../menu/menu.component';

import { ProcesarPedidoService } from './../../service/procesar-pedido.service';
import { Component, OnInit } from '@angular/core';
import { Viajes } from '../../model/Viajes';
import { CestaViajes } from '../../model/CestaViajes';
import { Continentes } from '../../model/Continentes';



@Component({
  selector: 'app-procesar-pedido',
  standalone: false,

  templateUrl: './procesar-pedido.component.html',
  styleUrl: './procesar-pedido.component.css'
})
export class ProcesarPedidoComponent implements OnInit{
  continentes:Continentes[];
  viajes:Viajes[];
  idContinenteSel:number;
  cesta:CestaViajes[];

  constructor(private procesarPedidoService:ProcesarPedidoService,
    private menuComponent:MenuComponent){

  }
  ngOnInit(): void {
    this.procesarPedidoService.continentes().subscribe(c=>this.continentes=c);
    this.cesta=[];
  }

  viajesContinentes(){
    this.procesarPedidoService.viajesContinentes(this.idContinenteSel).subscribe(p=>{this.viajes=p;
    this.actualizarCapaciad();
  });
  }

  actualizarCapaciad(){
    this.viajes.forEach(p=>{
      this.cesta.forEach(c=>{
        // Para cada viaje del continente seleccionada
        // recorremos la cesta de reservas y si encontramos el producto en la cesta
        // debemos actualizar su capaciad
        if(p.id_viajes==c.viajes.id_viajes){
          p.capacidad=p.capacidad - c.unidades;
          p.unidades = c.unidades;
          c.viajes.unidades = c.unidades;
        }
      })
    });
  }

  agregarViajesCesta(viajes:Viajes){
    if(viajes.unidades<=viajes.capacidad){
      let item=new CestaViajes();
      item.viajes=viajes;
      item.unidades=viajes.unidades;
      // Actualizar capacidad
      viajes.capacidad=viajes.capacidad-viajes.unidades;
      this.cesta.push(item);
    }else{
      alert("No quedan plazas en el viaje");
    }
  }

  eliminarViajeCesta(pos:number){
    let item=new CestaViajes();
    item=this.cesta[pos];
    this.cesta.splice(pos,1);
    // Localizamos el producto para actualizar cantidad
    let viajes=this.viajes.find(p=>p.id_viajes==item.viajes.id_viajes);
    viajes.capacidad=Number(viajes.capacidad) + Number(item.unidades);
  }

  procesarReserva(){
    let idn = this.menuComponent.usuario.idUsuario;
    this.procesarPedidoService.enviarPedido(this.cesta, 1).subscribe({  // AQUI ESTA EL ERROR //this.menuComponent.usuario.idUsuario
      next:r=>alert("Pedido procesado"),
      error:e=>alert("El pedido no se ha procesado")});

  }

}
