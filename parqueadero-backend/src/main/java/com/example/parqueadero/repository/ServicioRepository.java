package com.example.parqueadero.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.parqueadero.model.Servicio;

public interface ServicioRepository extends MongoRepository<Servicio, String> {
}