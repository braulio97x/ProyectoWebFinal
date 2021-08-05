import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'clienteVentas';

  myModal=false;
  mostrarModal(){
    this.myModal=true;
  }

  cerrarModal(){
    this.myModal=false;
  }
}
