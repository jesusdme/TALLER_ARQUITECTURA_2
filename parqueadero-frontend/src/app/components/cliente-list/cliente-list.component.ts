import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from '../../services/cliente.service';

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.css']
})
export class ClienteListComponent implements OnInit {
  clientes: Cliente[] = [];

  constructor(private clienteService: ClienteService) {}

  async ngOnInit(): Promise<void> {
    try {
      this.clientes = await this.clienteService.getClientes();
    } catch (error) {
      console.error('Error al obtener los clientes:', error);
    }
  }
}
