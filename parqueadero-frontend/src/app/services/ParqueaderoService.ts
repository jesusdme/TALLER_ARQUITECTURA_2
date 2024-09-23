import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Parqueadero } from '../models/Parqueadero';

@Injectable({
  providedIn: 'root'
})
export class ParqueaderoService {
  private apiUrl = 'http://localhost:8080/api/parqueaderos';  // Reemplaza con tu URL correcta

  constructor(private http: HttpClient) {}

  // Obtener el primer parqueadero del array
  getParqueadero(): Observable<Parqueadero> {
    return this.http.get<Parqueadero[]>(`${this.apiUrl}`).pipe(
      map(parqueaderos => parqueaderos[0])  // Tomar el primer parqueadero del array
    );
  }
}
