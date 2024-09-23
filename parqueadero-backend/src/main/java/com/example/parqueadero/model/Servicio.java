package com.example.parqueadero.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "servicios")
public class Servicio {
    @Id
    private String id;
    private String clienteId;
    private LocalDateTime hora;
    private String accion;
    private double cobro;

}
