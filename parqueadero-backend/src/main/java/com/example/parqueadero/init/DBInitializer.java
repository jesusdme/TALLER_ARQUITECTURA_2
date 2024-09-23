package com.example.parqueadero.init;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.parqueadero.model.Cliente;
import com.example.parqueadero.model.Parqueadero;
import com.example.parqueadero.model.Servicio;
import com.example.parqueadero.repository.ClienteRepository;
import com.example.parqueadero.repository.ParqueaderoRepository;
import com.example.parqueadero.repository.ServicioRepository;

@Component
public class DBInitializer implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verificar si ya hay parqueaderos en la base de datos para evitar duplicados
        if (parqueaderoRepository.count() == 0) {
            // Crear un parqueadero de prueba
            Parqueadero parqueadero = new Parqueadero();
            parqueadero.setEspacio(48);  // Espacios disponibles
            parqueadero.setGanancias(0.0);  // Ganancias iniciales
            parqueaderoRepository.save(parqueadero);

            // Verificar si ya hay clientes en la base de datos para evitar duplicados
            if (clienteRepository.count() == 0) {
                // Crear clientes de prueba solo si no hay ninguno en la base de datos
                Cliente cliente1 = new Cliente();
                cliente1.setNombre("Juan Pérez");
                cliente1.setPlacaVehiculo("XYZ123");
                cliente1.setColorVehiculo("Rojo");
                cliente1.setHoraIngreso(LocalDateTime.now());  // Hora de ingreso actual

                Cliente cliente2 = new Cliente();
                cliente2.setNombre("Maria López");
                cliente2.setPlacaVehiculo("ABC456");
                cliente2.setColorVehiculo("Azul");
                cliente2.setHoraIngreso(LocalDateTime.now().minusHours(1));  // Hora de ingreso hace 1 hora

                // Guardar clientes en la base de datos
                clienteRepository.save(cliente1);
                clienteRepository.save(cliente2);

                // Crear servicios de prueba
                Servicio servicio1 = new Servicio();
                servicio1.setClienteId(cliente1.getId());
                servicio1.setHora(LocalDateTime.now());
                servicio1.setAccion("Entrada");
                servicio1.setCobro(0.0);  // Inicialmente sin cobro

                Servicio servicio2 = new Servicio();
                servicio2.setClienteId(cliente2.getId());
                servicio2.setHora(LocalDateTime.now());
                servicio2.setAccion("Entrada");
                servicio2.setCobro(0.0);  // Inicialmente sin cobro

                // Guardar servicios en la base de datos
                servicioRepository.save(servicio1);
                servicioRepository.save(servicio2);

                System.out.println("Datos iniciales cargados en la base de datos.");
            } else {
                System.out.println("La base de datos ya tiene datos de clientes, no se cargaron nuevos datos.");
            }
        } else {
            System.out.println("La base de datos ya tiene parqueaderos, no se cargaron nuevos datos.");
        }
    }
}
