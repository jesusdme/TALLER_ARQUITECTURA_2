import { Component, OnInit } from '@angular/core';
import { EventEmitterService } from './services/EventEmitterService';
import { ParqueaderoService } from './services/ParqueaderoService';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  gananciasTotales: number = 0;
  puestosDisponibles: number = 0;

  constructor(
    private parqueaderoService: ParqueaderoService,
    private eventEmitterService: EventEmitterService  // Inyectar el servicio de eventos
  ) {}

  ngOnInit(): void {
    this.loadParqueaderoData();

    // Escuchar el evento para actualizar los datos del parqueadero
    this.eventEmitterService.updateParqueadero$.subscribe(() => {
      this.loadParqueaderoData();
    });
  }

  async loadParqueaderoData(): Promise<void> {
    try {
      const parqueadero = await this.parqueaderoService.getParqueadero().toPromise();

      if (parqueadero) {
        this.gananciasTotales = parqueadero.ganancias;
        this.puestosDisponibles = parqueadero.espacio;
      } else {
        console.error('El parqueadero no está disponible.');
      }
    } catch (error) {
      console.error('Error al cargar los datos del parqueadero:', error);
    }
  }
}
