import { Injectable } from '@angular/core';
import axios from 'axios';
import { Cliente } from '../models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private apiUrl = 'http://localhost:8080/api/clientes';

  constructor() {}

  // Obtener todos los clientes
  async getClientes(): Promise<Cliente[]> {
    const response = await axios.get<Cliente[]>(this.apiUrl);
    return response.data;
  }

  // Crear un cliente nuevo
  async createCliente(cliente: Cliente): Promise<Cliente> {
    const response = await axios.post<Cliente>(this.apiUrl, cliente);
    return response.data;
  }

  // Obtener un cliente por ID
  async getClienteById(id: string): Promise<Cliente> {
    const response = await axios.get<Cliente>(`${this.apiUrl}/${id}`);
    return response.data;
  }

  // Actualizar un cliente existente
  async updateCliente(id: string, cliente: Cliente): Promise<Cliente> {
    const response = await axios.put<Cliente>(`${this.apiUrl}/${id}`, cliente);
    return response.data;
  }

  // Eliminar un cliente
  async deleteCliente(id: string): Promise<void> {
    await axios.delete(`${this.apiUrl}/${id}`);
  }
}
