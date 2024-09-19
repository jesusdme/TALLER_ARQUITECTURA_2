package com.example.parqueadero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parqueadero.model.Servicio;
import com.example.parqueadero.service.ServicioService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    // Obtener todos los servicios
    @GetMapping
    public List<Servicio> obtenerServicios() {
        return servicioService.obtenerServicios();
    }

    // Obtener un servicio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Servicio> obtenerServicioPorId(@PathVariable String id) {
        Servicio servicio = servicioService.obtenerServicioPorId(id);
        if (servicio != null) {
            return ResponseEntity.ok(servicio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo servicio
    @PostMapping
    public Servicio crearServicio(@RequestBody Servicio servicio) {
        return servicioService.guardarServicio(servicio);
    }

    // Actualizar un servicio existente
    @PutMapping("/{id}")
    public ResponseEntity<Servicio> actualizarServicio(@PathVariable String id, @RequestBody Servicio detallesServicio) {
        Servicio servicioActualizado = servicioService.actualizarServicio(id, detallesServicio);
        if (servicioActualizado != null) {
            return ResponseEntity.ok(servicioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un servicio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable String id) {
        boolean fueEliminado = servicioService.eliminarServicio(id);
        if (fueEliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
