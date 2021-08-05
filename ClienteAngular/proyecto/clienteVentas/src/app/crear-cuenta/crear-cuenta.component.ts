import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/domain/Usuario';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-crear-cuenta',
  templateUrl: './crear-cuenta.component.html',
  styleUrls: ['./crear-cuenta.component.scss']
})
export class CrearCuentaComponent implements OnInit {

  usuario:Usuario = new Usuario();
  constructor(private router:Router, 
  private usuarioService: UsuarioService) { }

  ngOnInit(): void {
  }


insertar(){
    console.log(this.usuario)
    this.usuarioService.insertarUsuario(this.usuario).subscribe(data =>{
      console.log(data);
    });

  }


}
