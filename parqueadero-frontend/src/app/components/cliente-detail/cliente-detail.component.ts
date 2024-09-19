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

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.clienteService.getClienteById(id).subscribe(cliente => {
        this.cliente = cliente;
      });
    }
  }

  deleteCliente(): void {
    if (this.cliente?.id) {
      this.clienteService.deleteCliente(this.cliente.id).subscribe(() => {
        this.router.navigate(['/clientes']);  // Redirige a la lista de clientes después de eliminar
      });
    }
  }
}
