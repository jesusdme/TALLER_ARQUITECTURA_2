import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Servicio } from '../models/servicio';

@Injectable({
    providedIn: 'root'
})
export class ServicioService {
    private apiUrl = 'http://localhost:8080/api/servicios';  // Asegúrate de que coincida con el backend

    constructor(private http: HttpClient) { }

    // Obtener todos los servicios
    getServicios(): Observable<Servicio[]> {
        return this.http.get<Servicio[]>(this.apiUrl);
    }

    // Obtener un servicio por ID
    getServicioById(id: string): Observable<Servicio> {
        return this.http.get<Servicio>(`${this.apiUrl}/${id}`);
    }

    // Crear un nuevo servicio
    createServicio(servicio: Servicio): Observable<Servicio> {
        return this.http.post<Servicio>(this.apiUrl, servicio);
    }

    // Actualizar un servicio existente
    updateServicio(id: string, servicio: Servicio): Observable<Servicio> {
        return this.http.put<Servicio>(`${this.apiUrl}/${id}`, servicio);
    }

    // Eliminar un servicio por ID
    deleteServicio(id: string): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
