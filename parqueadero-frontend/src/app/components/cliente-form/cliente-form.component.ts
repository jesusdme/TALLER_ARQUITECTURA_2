import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from '../../models/cliente';
import { ClienteService } from '../../services/cliente.service';

@Component({
  selector: 'app-cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.css']
})
export class ClienteFormComponent implements OnInit {
  cliente: Cliente = {
    nombre: '',
    placaVehiculo: '',
    colorVehiculo: '',
    horaIngreso: '', // Puedes establecerlo como `undefined` ya que será generado en el backend
  };
  isEditMode = false;

  constructor(
    private clienteService: ClienteService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  async ngOnInit(): Promise<void> {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      try {
        this.cliente = await this.clienteService.getClienteById(id);
      } catch (error) {
        console.error('Error al obtener el cliente:', error);
      }
    }
  }

  async onSubmit(): Promise<void> {
    try {
      if (this.isEditMode) {
        // Actualizar cliente
        await this.clienteService.updateCliente(this.cliente.id!, this.cliente);
      } else {
        // Crear nuevo cliente
        await this.clienteService.createCliente(this.cliente);
      }
      this.router.navigate(['/clientes']);
    } catch (error) {
      console.error('Error al guardar el cliente:', error);
    }
  }
}
