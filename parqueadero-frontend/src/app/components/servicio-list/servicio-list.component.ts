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

  constructor(private servicioService: ServicioService) {}

  async ngOnInit(): Promise<void> {
    try {
      this.servicios = await this.servicioService.getServicios();
    } catch (error) {
      console.error('Error al cargar los servicios:', error);
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
