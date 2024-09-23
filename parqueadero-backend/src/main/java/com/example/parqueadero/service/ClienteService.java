package com.example.parqueadero.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parqueadero.model.Cliente;
import com.example.parqueadero.model.Servicio;
import com.example.parqueadero.repository.ClienteRepository;
import com.example.parqueadero.repository.ServicioRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    // Obtener todos los clientes
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por ID
    public Cliente obtenerClientePorId(String id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Guardar un cliente (Entrada al parqueadero)
    public Cliente guardarCliente(Cliente cliente) {
        // Establecer la hora de ingreso
        cliente.setHoraIngreso(LocalDateTime.now());
        Cliente clienteGuardado = clienteRepository.save(cliente);

        // Crear un registro de servicio con la acción "Entrada"
        Servicio servicio = new Servicio();
        servicio.setClienteId(clienteGuardado.getId());
        servicio.setHora(LocalDateTime.now());
        servicio.setAccion("Entrada");
        servicio.setCobro(0.0); // Inicialmente sin cobro
        servicioRepository.save(servicio);

        return clienteGuardado;
    }

    // Actualizar un cliente existente
    public Cliente actualizarCliente(String id, Cliente detallesCliente) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNombre(detallesCliente.getNombre());
            cliente.setPlacaVehiculo(detallesCliente.getPlacaVehiculo());
            cliente.setColorVehiculo(detallesCliente.getColorVehiculo());
            cliente.setHoraIngreso(detallesCliente.getHoraIngreso());
            return clienteRepository.save(cliente);
        } else {
            return null;
        }
    }

    // Eliminar un cliente (Salida del parqueadero)
    public boolean eliminarCliente(String id) {
        if (clienteRepository.existsById(id)) {
            Cliente cliente = clienteRepository.findById(id).orElse(null);

            // Crear un registro de servicio con la acción "Salida" antes de eliminar al
            // cliente
            if (cliente != null) {
                Servicio servicio = new Servicio();
                servicio.setClienteId(cliente.getId());
                servicio.setHora(LocalDateTime.now());
                servicio.setAccion("Salida");

                Duration duration = Duration.between(cliente.getHoraIngreso(), LocalDateTime.now());
                System.out.println("duracion   "+ duration);
                System.out.println("duracion  minutos "+  duration.toMinutes());

                System.out.println(167 * duration.toMinutes());

                servicio.setCobro(
                        new BigDecimal(167 * duration.toMinutes()).doubleValue());

                servicioRepository.save(servicio);
            }

            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
