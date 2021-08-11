import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Producto } from '../domain/producto';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  constructor(private http: HttpClient) { }

  insertarProducto(producto:Producto): Observable<any>{
    const url =environment.WS_PATH+"/admin/registrarProducto"
    return this.http.put<any>(url,producto)
}

getProductos(): Observable<any>{
  const url= environment.WS_PATH+ "/personas/recuperar-productos";
  return this.http.get<any>(url);
}
}
