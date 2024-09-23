import { Injectable } from '@angular/core';
import axios from 'axios';
import { Servicio } from '../models/servicio';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {
  private apiUrl = 'http://localhost:8080/api/servicios';
  private parqueaderoApiUrl = 'http://localhost:8080/api/parqueaderos'; // URL para parqueaderos

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

  // Obtener las ganancias totales
  async getGananciasTotales(): Promise<number> {
    const response = await axios.get<{ ganancias: number }>(`${this.parqueaderoApiUrl}/ganancias`);
    return response.data.ganancias;
  }

  // Obtener los puestos disponibles
  async getPuestosDisponibles(): Promise<number> {
    const response = await axios.get<{ puestosDisponibles: number }>(`${this.parqueaderoApiUrl}/puestos-disponibles`);
    return response.data.puestosDisponibles;
  }
}
