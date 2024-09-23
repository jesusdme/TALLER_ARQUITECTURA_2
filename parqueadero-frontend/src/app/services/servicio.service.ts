import { Injectable } from '@angular/core';
import axios from 'axios';
import { Servicio } from '../models/servicio';

@Injectable({
    providedIn: 'root'
})
export class ServicioService {
    private apiUrl = 'http://localhost:8080/api/servicios';

    constructor() { }

    // Obtener todos los servicios
    async getServicios(): Promise<Servicio[]> {
        const response = await axios.get<Servicio[]>(this.apiUrl);
        return response.data;
    }

    // Crear un nuevo servicio
    async createServicio(servicio: Servicio): Promise<Servicio> {
        const response = await axios.post<Servicio>(this.apiUrl, servicio);
        return response.data;
    }

    // Obtener un servicio por ID
    async getServicioById(id: string): Promise<Servicio> {
        const response = await axios.get<Servicio>(`${this.apiUrl}/${id}`);
        return response.data;
    }

    // Actualizar un servicio existente
    async updateServicio(id: string, servicio: Servicio): Promise<Servicio> {
        const response = await axios.put<Servicio>(`${this.apiUrl}/${id}`, servicio);
        return response.data;
    }

    // Eliminar un servicio
    async deleteServicio(id: string): Promise<void> {
        await axios.delete(`${this.apiUrl}/${id}`);
    }
}
