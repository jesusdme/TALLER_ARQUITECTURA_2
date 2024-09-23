import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServicioService } from 'src/app/services/servicio.service';
import { Servicio } from '../../models/servicio';

@Component({
  selector: 'app-servicio-form',
  templateUrl: './servicio-form.component.html',
  styleUrls: ['./servicio-form.component.css']
})
export class ServicioFormComponent implements OnInit {
  servicio: Servicio = {
    clienteId: '',
    hora: '',
    accion: '',
    cobro: 0
  };
  isEditMode = false;

  constructor(
    private servicioService: ServicioService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  async ngOnInit(): Promise<void> {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      try {
        this.servicio = await this.servicioService.getServicioById(id);
      } catch (error) {
        console.error('Error al obtener el servicio:', error);
      }
    }
  }

  async onSubmit(): Promise<void> {
    try {
      if (this.isEditMode) {
        // Actualizar servicio
        await this.servicioService.updateServicio(this.servicio.id!, this.servicio);
      } else {
        // Crear nuevo servicio
        await this.servicioService.createServicio(this.servicio);
      }
      this.router.navigate(['/servicios']);
    } catch (error) {
      console.error('Error al guardar el servicio:', error);
    }
  }
}
