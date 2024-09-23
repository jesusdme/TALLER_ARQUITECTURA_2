import { Component, OnInit } from '@angular/core';
import { ServicioService } from './services/servicio.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  gananciasTotales: number = 0;
  puestosDisponibles: number = 0;

  constructor(private servicioService: ServicioService) {}

  async ngOnInit(): Promise<void> {
    try {
      // Obtener las ganancias totales
      this.gananciasTotales = await this.servicioService.getGananciasTotales();

      // Obtener los puestos disponibles
      this.puestosDisponibles = await this.servicioService.getPuestosDisponibles();
    } catch (error) {
      console.error('Error al cargar las ganancias o los puestos disponibles:', error);
    }
  }
}
