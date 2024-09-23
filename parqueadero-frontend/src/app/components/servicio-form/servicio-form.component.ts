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

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      this.servicioService.getServicioById(id).subscribe(servicio => {
        this.servicio = servicio;
      });
    }
  }

  onSubmit(): void {
    if (this.isEditMode) {
      // Actualizar servicio
      this.servicioService.updateServicio(this.servicio.id!, this.servicio).subscribe(() => {
        this.router.navigate(['/servicios']);
      });
    } else {
      // Crear nuevo servicio
      this.servicioService.createServicio(this.servicio).subscribe(() => {
        this.router.navigate(['/servicios']);
      });
    }
  }
}
