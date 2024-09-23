package com.example.parqueadero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parqueadero.model.Parqueadero;
import com.example.parqueadero.repository.ParqueaderoRepository;

@Service
public class ParqueaderoService {

    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    // Obtener todos los parqueaderos
    public List<Parqueadero> obtenerParqueaderos() {
        return parqueaderoRepository.findAll();
    }

    // Obtener parqueadero por ID
    public Parqueadero obtenerParqueaderoPorId(String id) {
        return parqueaderoRepository.findById(id).orElse(null);
    }

    // Guardar parqueadero
    public Parqueadero guardarParqueadero(Parqueadero parqueadero) {
        return parqueaderoRepository.save(parqueadero);
    }

    // Actualizar parqueadero existente
    public Parqueadero actualizarParqueadero(String id, Parqueadero detallesParqueadero) {
        Optional<Parqueadero> parqueaderoOpt = parqueaderoRepository.findById(id);
        if (parqueaderoOpt.isPresent()) {
            Parqueadero parqueadero = parqueaderoOpt.get();
            parqueadero.setEspacio(detallesParqueadero.getEspacio());
            parqueadero.setGanancias(detallesParqueadero.getGanancias());
            return parqueaderoRepository.save(parqueadero);
        } else {
            return null;
        }
    }

    // Eliminar parqueadero por ID
    public boolean eliminarParqueadero(String id) {
        if (parqueaderoRepository.existsById(id)) {
            parqueaderoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
