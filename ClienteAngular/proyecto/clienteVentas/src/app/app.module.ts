import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IniciarSesionComponent } from './iniciar-sesion/iniciar-sesion.component';
import { CrearCuentaComponent } from './crear-cuenta/crear-cuenta.component';
import { CrearCategoriaComponent } from './crear-categoria/crear-categoria.component';
import { CrearProductoComponent } from './crear-producto/crear-producto.component';

@NgModule({
  declarations: [
    AppComponent,
    IniciarSesionComponent,
    CrearCuentaComponent,
    CrearCategoriaComponent,
    CrearProductoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
