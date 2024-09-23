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

  constructor(private servicioService: ServicioService) { }

  ngOnInit(): void {
    this.servicioService.getServicios().subscribe(data => {
      this.servicios = data;
    });
  }

}
