import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EventEmitterService } from 'src/app/services/EventEmitterService';
import { Cliente } from '../../models/cliente';
import { ClienteService } from '../../services/cliente.service';

@Component({
  selector: 'app-cliente-detail',
  templateUrl: './cliente-detail.component.html',
  styleUrls: ['./cliente-detail.component.css']
})
export class ClienteDetailComponent implements OnInit {
  cliente: Cliente | undefined;

  constructor(
    private clienteService: ClienteService,
    private route: ActivatedRoute,
    private router: Router,
    private eventEmitterService: EventEmitterService  // Inyectar el servicio de eventos
  ) {}

  async ngOnInit(): Promise<void> {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      try {
        this.cliente = await this.clienteService.getClienteById(id);
      } catch (error) {
        console.error('Error al obtener el cliente:', error);
      }
    }
  }

  async deleteCliente(): Promise<void> {
    if (this.cliente?.id) {
      try {
        await this.clienteService.deleteCliente(this.cliente.id);

        // Emitir el evento para actualizar el parqueadero
        this.eventEmitterService.emitUpdateParqueadero();

        // Redirigir a la lista de clientes después de eliminar
        this.router.navigate(['/clientes']);
      } catch (error) {
        console.error('Error al eliminar el cliente:', error);
      }
    }
  }
}
