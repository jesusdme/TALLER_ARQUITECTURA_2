package com.example.parqueadero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.parqueadero.model.Parqueadero;

@Repository
public interface ParqueaderoRepository extends MongoRepository<Parqueadero, String> {
}
