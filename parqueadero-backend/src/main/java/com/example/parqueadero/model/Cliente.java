package com.example.parqueadero.model;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection = "clientes")
public class Cliente {
    @Id
    private String id;
    private String nombre;
    private String placaVehiculo;
    private String colorVehiculo;
    private LocalDateTime horaIngreso;

}