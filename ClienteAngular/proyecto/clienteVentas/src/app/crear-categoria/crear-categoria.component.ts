import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { Categoria } from '../domain/categoria';
import { CategoriasService } from '../services/categorias.service';

@Component({
  selector: 'app-crear-categoria',
  templateUrl: './crear-categoria.component.html',
  styleUrls: ['./crear-categoria.component.scss']
})
export class CrearCategoriaComponent implements OnInit {
  @Output() close:EventEmitter<boolean>=new EventEmitter();
  usuario: string= "Braulio Astudillo";
  categoria:Categoria=new Categoria();
  categorias:any;
  constructor(private router: Router, private CategoriasService: CategoriasService) { }

  ngOnInit(): void {
    this.categorias=this.CategoriasService.getCategorias();
  }

  closeModal(){
    this.close.emit(false);
  }

  insertar(){
    console.log(this.categoria)
    this.categorias=this.CategoriasService.getCategorias();
    this.CategoriasService.insertarCategoria(this.categoria).subscribe(data =>{
      console.log(data);
    });

  }

  Nombre(){
    let l:string="Hola";
    console.log(l);
  }

  
}
