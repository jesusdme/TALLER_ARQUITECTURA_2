package com.example.parqueadero.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.parqueadero.model.Cliente;
import com.example.parqueadero.model.Servicio;
import com.example.parqueadero.repository.ClienteRepository;
import com.example.parqueadero.repository.ServicioRepository;

@Component
public class DBInitializer implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verificar si ya hay clientes en la base de datos para evitar duplicados
        if (clienteRepository.count() == 0) {
            // Crear clientes de prueba solo si no hay ninguno en la base de datos
            Cliente cliente1 = new Cliente();
            cliente1.setNombre("Juan Pérez");
            cliente1.setPlacaVehiculo("XYZ123");
            cliente1.setColorVehiculo("Rojo");

            Cliente cliente2 = new Cliente();
            cliente2.setNombre("Maria López");
            cliente2.setPlacaVehiculo("ABC456");
            cliente2.setColorVehiculo("Azul");

            // Guardar clientes en la base de datos
            clienteRepository.save(cliente1);
            clienteRepository.save(cliente2);

            // Crear servicios de prueba
            Servicio servicio1 = new Servicio();
            servicio1.setClienteId(cliente1.getId());
            servicio1.setHoraEntrada("10:00");
            servicio1.setHoraSalida("12:00");
            servicio1.setEspacioAsignado("A1");

            Servicio servicio2 = new Servicio();
            servicio2.setClienteId(cliente2.getId());
            servicio2.setHoraEntrada("11:00");
            servicio2.setHoraSalida("13:00");
            servicio2.setEspacioAsignado("B2");

            // Guardar servicios en la base de datos
            servicioRepository.save(servicio1);
            servicioRepository.save(servicio2);

            System.out.println("Datos iniciales cargados en la base de datos.");
        } else {
            System.out.println("La base de datos ya tiene datos, no se cargaron nuevos datos.");
        }
    }
}
