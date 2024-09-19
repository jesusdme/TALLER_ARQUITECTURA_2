package com.example.parqueadero.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "servicios")
public class Servicio {
    @Id
    private String id;
    private String clienteId;
    private String horaEntrada;
    private String horaSalida;
    private String espacioAsignado;
}
