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
    colorVehiculo: ''
  };
  isEditMode = false;

  constructor(
    private clienteService: ClienteService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      this.clienteService.getClienteById(id).subscribe(cliente => {
        this.cliente = cliente;
      });
    }
  }

  onSubmit(): void {
    if (this.isEditMode) {
      // Actualizar cliente
      this.clienteService.updateCliente(this.cliente.id!, this.cliente).subscribe(() => {
        this.router.navigate(['/clientes']);
      });
    } else {
      // Crear nuevo cliente
      this.clienteService.createCliente(this.cliente).subscribe(() => {
        this.router.navigate(['/clientes']);
      });
    }
  }
}
