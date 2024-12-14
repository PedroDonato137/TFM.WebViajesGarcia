import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './controller/login/login.component';
import { FormsModule } from '@angular/forms';
import { RegistrarComponent } from './controller/registrar/registrar.component';
import { ProcesarPedidoComponent } from './controller/procesar-pedido/procesar-pedido.component';
import { ConsultarReservasComponent } from './controller/consultar-reservas/consultar-reservas.component';
import { MenuComponent } from './controller/menu/menu.component';
import { PortadaComponent } from './controller/portada/portada.component';
import { NoticiasComponent } from './controller/noticias/noticias.component';
import { BarcosComponent } from './controller/barcos/barcos.component';
import { RutasComponent } from './controller/rutas/rutas.component';
import { FooterComponent } from './controller/footer/footer.component';

@NgModule({
  declarations: [
    LoginComponent,
    RegistrarComponent,
    ProcesarPedidoComponent,
    ConsultarReservasComponent,
    MenuComponent,
    PortadaComponent,
    NoticiasComponent,
    BarcosComponent,
    RutasComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [MenuComponent]
})
export class AppModule { }
