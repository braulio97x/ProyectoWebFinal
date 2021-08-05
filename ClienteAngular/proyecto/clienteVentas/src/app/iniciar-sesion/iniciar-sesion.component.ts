import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { Sesion } from '../domain/sesion';
import { SesionesService } from '../services/sesiones.service';



@Component({
  selector: 'app-iniciar-sesion',
  templateUrl: './iniciar-sesion.component.html',
  styleUrls: ['./iniciar-sesion.component.scss'],
  
 
})
export class IniciarSesionComponent implements OnInit {
 // @Input() visible: boolean;
//Output close:EventEmitter<boolean> =new EventEmitter;
@Output() close:EventEmitter<boolean>=new EventEmitter();
  usuario: string= "Braulio Astudillo";
  sesion:Sesion=new Sesion();

  constructor( private router: Router, private SesionesService: SesionesService ) { }

  ngOnInit(): void {
  }

  closeModal(){
    this.close.emit(false);
  }

  iniciarSesion(){
    console.log(this.sesion);
    this.SesionesService.iniciarSesion(this.sesion).subscribe(data =>{
      console.log(data);
    });
    let params: NavigationExtras={
      queryParams:{
        sesion: this.sesion
      }
    }
    //this.router.navigate(['acercade'], params)

  }

}
