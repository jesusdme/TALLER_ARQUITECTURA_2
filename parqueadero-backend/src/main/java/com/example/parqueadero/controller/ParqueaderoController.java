package com.example.parqueadero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parqueadero.model.Parqueadero;
import com.example.parqueadero.service.ParqueaderoService;

@CrossOrigin(origins = "http://localhost:4200") // Permitir acceso desde el frontend en Angular
@RestController
@RequestMapping("/api/parqueaderos")
public class ParqueaderoController {

    @Autowired
    private ParqueaderoService parqueaderoService;

    // Obtener todos los parqueaderos
    @GetMapping
    public List<Parqueadero> obtenerParqueaderos() {
        return parqueaderoService.obtenerParqueaderos();
    }

    // Obtener parqueadero por ID
    @GetMapping("/{id}")
    public Parqueadero obtenerParqueaderoPorId(@PathVariable String id) {
        return parqueaderoService.obtenerParqueaderoPorId(id);
    }

    // Crear un nuevo parqueadero
    @PostMapping
    public Parqueadero crearParqueadero(@RequestBody Parqueadero parqueadero) {
        return parqueaderoService.guardarParqueadero(parqueadero);
    }

    // Actualizar parqueadero existente
    @PutMapping("/{id}")
    public Parqueadero actualizarParqueadero(@PathVariable String id, @RequestBody Parqueadero parqueadero) {
        return parqueaderoService.actualizarParqueadero(id, parqueadero);
    }

    // Eliminar parqueadero por ID
    @DeleteMapping("/{id}")
    public boolean eliminarParqueadero(@PathVariable String id) {
        return parqueaderoService.eliminarParqueadero(id);
    }
}
