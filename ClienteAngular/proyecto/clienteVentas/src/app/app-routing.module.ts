import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IniciarSesionComponent } from './iniciar-sesion/iniciar-sesion.component';
import { CrearCuentaComponent } from './crear-cuenta/crear-cuenta.component';

const routes: Routes = [
  {path: "iniciarSesion", component:IniciarSesionComponent},
  {path: "crearCuenta", component: CrearCuentaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
