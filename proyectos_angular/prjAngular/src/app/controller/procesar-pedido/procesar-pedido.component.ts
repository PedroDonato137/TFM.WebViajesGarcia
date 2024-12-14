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

// El metodo procesar pedido esta con la implementacion OnInit para que se ejecute na mas entrar al html
export class ProcesarPedidoComponent implements OnInit{

  //Variables del metodo
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
          p.unidades = c.unidades; // Esta asignacion es para que se la añadan los pasajeros e los viajes
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
    // Error: dentro de losparentesis de consultarReserva dedveria de tener realmeten la variable idn,
    // para que almacenara el id del usuario, pero tiene un conflicto con la base de datos, ya que no se llama igual
    // el campo, he intentado arreglarlo, pero la unica solucion seria modifiacar la tabla usuarios de la base de datos
    // haciendo que tenga que cambiar tambien todos metodos del spring book repositorios 01 y 02
    this.procesarPedidoService.enviarPedido(this.cesta, 1).subscribe({
      next:r=>alert("Pedido procesado"),
      error:e=>alert("El pedido no se ha procesado")});

  }

}
