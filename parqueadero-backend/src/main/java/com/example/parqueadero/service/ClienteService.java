package com.example.parqueadero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parqueadero.model.Cliente;
import com.example.parqueadero.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por ID
    public Cliente obtenerClientePorId(String id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Guardar un cliente
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public Cliente actualizarCliente(String id, Cliente detallesCliente) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNombre(detallesCliente.getNombre());
            cliente.setPlacaVehiculo(detallesCliente.getPlacaVehiculo());
            cliente.setColorVehiculo(detallesCliente.getColorVehiculo());
            return clienteRepository.save(cliente);
        } else {
            return null;
        }
    }

    // Eliminar un cliente por ID
    public boolean eliminarCliente(String id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
