package com.example.parqueadero.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "clientes")
public class Cliente {
    @Id
    private String id;
    private String nombre;
    private String placaVehiculo;
    private String colorVehiculo;
}
