import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { Producto } from '../domain/producto';
import { ProductosService } from '../services/productos.service';

@Component({
  selector: 'app-crear-producto',
  templateUrl: './crear-producto.component.html',
  styleUrls: ['./crear-producto.component.scss']
})
export class CrearProductoComponent implements OnInit {
  @Output() close:EventEmitter<boolean>=new EventEmitter();
  usuario: string= "Braulio Astudillo";
  producto:Producto=new Producto();
  productos:any;
  constructor(private router: Router, private ProductosService: ProductosService) { }

  ngOnInit(): void {
    this.productos=this.ProductosService.getProductos();
  }

  closeModal(){
    this.close.emit(false);
  }

  insertar(){
    console.log(this.producto)
    
    this.ProductosService.insertarProducto(this.producto).subscribe(data =>{
      console.log(data);
    });
   this.productos=this.repurar();
  }

  repurar(){
    return this.productos=this.ProductosService.getProductos();
  }

  Nombre(){
    let l:string="Hola";
    console.log(l);
  }

}
