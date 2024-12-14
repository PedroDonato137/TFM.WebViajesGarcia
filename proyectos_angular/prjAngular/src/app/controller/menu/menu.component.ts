import { Router } from '@angular/router';
import { Usuario } from '../../model/Usuario';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu',
  standalone: false,

  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent implements OnInit{

  enabled:boolean=false;
  usuario:Usuario;
  constructor(private router:Router){

  }

  ngOnInit(): void {
    this.router.navigate(["/portada"]);
  }
}
