package com.example.parqueadero.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parqueadero.model.Cliente;
import com.example.parqueadero.model.Parqueadero;
import com.example.parqueadero.model.Servicio;
import com.example.parqueadero.repository.ClienteRepository;
import com.example.parqueadero.repository.ParqueaderoRepository;
import com.example.parqueadero.repository.ServicioRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

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
        // Verificar si hay espacio disponible en el parqueadero
        Parqueadero parqueadero = parqueaderoRepository.findAll().get(0); // Asumimos un solo parqueadero
        if (parqueadero.getEspacio() > 0) {
            // Reducir el espacio disponible
            parqueadero.setEspacio(parqueadero.getEspacio() - 1);
            parqueaderoRepository.save(parqueadero);

            // Establecer la hora de ingreso

            ZoneId colombiaZone = ZoneId.of("America/Bogota");

            // Establecer la hora de ingreso en la zona horaria de Colombia
            LocalDateTime horaIngreso = ZonedDateTime.now(colombiaZone).toLocalDateTime();
            cliente.setHoraIngreso(horaIngreso);
            
            Cliente clienteGuardado = clienteRepository.save(cliente);

            // Crear un registro de servicio con la acción "Entrada"
            Servicio servicio = new Servicio();
            servicio.setClienteId(clienteGuardado.getId());
            servicio.setHora(horaIngreso);
            servicio.setAccion("Entrada");
            servicio.setCobro(0.0); // Inicialmente sin cobro
            servicioRepository.save(servicio);

            return clienteGuardado;
        } else {
            // Si no hay espacio, no se guarda el cliente
            throw new RuntimeException("No hay espacio disponible en el parqueadero");
        }
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

            // Crear un registro de servicio con la acción "Salida" antes de eliminar al cliente
            if (cliente != null) {
                Servicio servicio = new Servicio();
                servicio.setClienteId(cliente.getId());
                ZoneId colombiaZone = ZoneId.of("America/Bogota");

                // Establecer la hora de ingreso en la zona horaria de Colombia
                LocalDateTime horaSalida = ZonedDateTime.now(colombiaZone).toLocalDateTime();

                servicio.setHora(horaSalida);
                servicio.setAccion("Salida");

                // Calcular la duración de la estancia
                Duration duration = Duration.between(cliente.getHoraIngreso(), horaSalida);
                double cobro = new BigDecimal(167 * duration.toMinutes()).doubleValue();
                servicio.setCobro(cobro);

                // Guardar el servicio en la base de datos
                servicioRepository.save(servicio);

                // Obtener el parqueadero y sumar el cobro a las ganancias
                Parqueadero parqueadero = parqueaderoRepository.findAll().get(0); // Asumimos un solo parqueadero
                parqueadero.setEspacio(parqueadero.getEspacio() + 1);
                parqueadero.setGanancias(parqueadero.getGanancias() + cobro);
                parqueaderoRepository.save(parqueadero);
            }

            // Eliminar el cliente
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
