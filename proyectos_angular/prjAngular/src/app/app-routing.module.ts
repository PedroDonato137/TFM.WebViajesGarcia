import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './controller/login/login.component';
import { ConsultarReservasComponent } from './controller/consultar-reservas/consultar-reservas.component';
import { ProcesarPedidoComponent } from './controller/procesar-pedido/procesar-pedido.component';
import { RegistrarComponent } from './controller/registrar/registrar.component';
import { PortadaComponent } from './controller/portada/portada.component';
import { NoticiasComponent } from './controller/noticias/noticias.component';
import { BarcosComponent } from './controller/barcos/barcos.component';
import { RutasComponent } from './controller/rutas/rutas.component';

const routes: Routes = [
  {path:"login", component:LoginComponent},
  {path:"consultar", component:ConsultarReservasComponent},
  {path:"procesar", component:ProcesarPedidoComponent},
  {path:"registrar", component:RegistrarComponent},
  {path:"portada", component:PortadaComponent},
  {path:"noticias", component:NoticiasComponent},
  {path:"barcos", component:BarcosComponent},
  {path:"rutas", component:RutasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
