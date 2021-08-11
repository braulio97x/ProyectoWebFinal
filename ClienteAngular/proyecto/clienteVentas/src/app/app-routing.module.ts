import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IniciarSesionComponent } from './iniciar-sesion/iniciar-sesion.component';
import { CrearCuentaComponent } from './crear-cuenta/crear-cuenta.component';
import { CrearCategoriaComponent } from './crear-categoria/crear-categoria.component';
import { CrearProductoComponent } from './crear-producto/crear-producto.component';

const routes: Routes = [
  {path: "iniciarSesion", component:IniciarSesionComponent},
  {path: "crearCuenta", component: CrearCuentaComponent},
  {path: "crearCategoria", component: CrearCategoriaComponent},
  {path: "crearProducto", component: CrearProductoComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
