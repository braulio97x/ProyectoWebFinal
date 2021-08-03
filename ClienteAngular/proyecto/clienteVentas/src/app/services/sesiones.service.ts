import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sesion } from '../domain/sesion';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SesionesService {

  constructor(private http: HttpClient) { }
  iniciarSesion(sesion:Sesion): Observable<any>{
    const url= environment.WS_PATH+'/personas/iniciarSesion'
    return this.http.put<any>(url, sesion)
  }
}
