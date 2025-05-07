import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Canje, Recompensas} from '../domain/recompensas';
import { RecompensaDetalle } from '../domain/recompensas';

@Injectable({ providedIn: 'root' })
export class RecompensasService {
  private apiUrl = 'http://localhost:8080/api/recompensas';

  constructor(private http: HttpClient) {}

  obtenerRecompensas(): Observable<Recompensas[]> {
    return this.http.get<Recompensas[]>(this.apiUrl);
  }

  canjearRecompensa(usuId: number, recId: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/canjear?usuId=${usuId}&recId=${recId}`, null);
  }


  obtenerPuntosUsuario(id: number): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/puntos/${id}`);
  }

  obtenerHistorialCanjes(usuId: number): Observable<Canje[]> {
    return this.http.get<Canje[]>(`${this.apiUrl}/historial/${usuId}`);
  }

  obtenerRecompensaPorId(recId: number): Observable<RecompensaDetalle> {
    return this.http.get<RecompensaDetalle>(`${this.apiUrl}/detalle/${recId}`);
  }





}
