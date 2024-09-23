import { Component, OnInit } from '@angular/core';
import { Servicio } from '../../models/servicio';
import { ServicioService } from '../../services/servicio.service';

@Component({
  selector: 'app-servicio-list',
  templateUrl: './servicio-list.component.html',
  styleUrls: ['./servicio-list.component.css']
})
export class ServicioListComponent implements OnInit {
  servicios: Servicio[] = [];
  gananciasTotales: number = 0;
  puestosDisponibles: number = 0;

  constructor(private servicioService: ServicioService) {}

  async ngOnInit(): Promise<void> {
    try {
      // Obtener la lista de servicios
      this.servicios = await this.servicioService.getServicios();

      // Obtener las ganancias totales del parqueadero
      this.gananciasTotales = await this.servicioService.getGananciasTotales();

      // Obtener los puestos disponibles
      this.puestosDisponibles = await this.servicioService.getPuestosDisponibles();
    } catch (error) {
      console.error('Error al cargar los servicios o información adicional:', error);
    }
  }

  async deleteServicio(id: string): Promise<void> {
    try {
      await this.servicioService.deleteServicio(id);
      this.servicios = this.servicios.filter(s => s.id !== id);  // Eliminar el servicio de la lista local
    } catch (error) {
      console.error('Error al eliminar el servicio:', error);
    }
  }
}
