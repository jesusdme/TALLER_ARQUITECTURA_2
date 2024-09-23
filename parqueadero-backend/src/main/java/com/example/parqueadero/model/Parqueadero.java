package com.example.parqueadero.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "parqueadero")
public class Parqueadero {

    @Id
    private String id;
    private long espacio;
    private double ganancias;
}
