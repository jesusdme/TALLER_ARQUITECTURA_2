import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
    private router: Router
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
        this.router.navigate(['/clientes']);  // Redirige a la lista de clientes después de eliminar
      } catch (error) {
        console.error('Error al eliminar el cliente:', error);
      }
    }
  }
}
