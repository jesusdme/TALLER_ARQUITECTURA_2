package com.example.parqueadero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.parqueadero.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
