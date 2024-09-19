package com.example.parqueadero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parqueadero.model.Servicio;
import com.example.parqueadero.repository.ServicioRepository;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    // Obtener todos los servicios
    public List<Servicio> obtenerServicios() {
        return servicioRepository.findAll();
    }

    // Obtener un servicio por ID
    public Servicio obtenerServicioPorId(String id) {
        return servicioRepository.findById(id).orElse(null);
    }

    // Guardar un servicio
    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    // Actualizar un servicio existente
    public Servicio actualizarServicio(String id, Servicio detallesServicio) {
        Servicio servicio = servicioRepository.findById(id).orElse(null);
        if (servicio != null) {
            servicio.setClienteId(detallesServicio.getClienteId());
            servicio.setHoraEntrada(detallesServicio.getHoraEntrada());
            servicio.setHoraSalida(detallesServicio.getHoraSalida());
            servicio.setEspacioAsignado(detallesServicio.getEspacioAsignado());
            return servicioRepository.save(servicio);
        } else {
            return null;
        }
    }

    // Eliminar un servicio por ID
    public boolean eliminarServicio(String id) {
        if (servicioRepository.existsById(id)) {
            servicioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
