import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../domain/Usuario';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  insertarUsuario(usuario:Usuario): Observable<any>{
    const url =environment.WS_PATH+"/personas/registrarUsuario"
    return this.http.put<any>(url,usuario)
}
}
