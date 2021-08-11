import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Categoria } from '../domain/categoria';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoriasService {

  constructor(private http: HttpClient) { }

  insertarCategoria(categoria:Categoria): Observable<any>{
    const url =environment.WS_PATH+"/admin/registrarCategoria"
    return this.http.put<any>(url,categoria)
}

getCategorias(): Observable<any>{
  const url= environment.WS_PATH+ "/personas/recuperar-categorias";
  return this.http.get<any>(url);
}
}
