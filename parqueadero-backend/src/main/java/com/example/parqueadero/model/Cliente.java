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





    /*public void setHoraIngreso() {
        this.horaIngreso = LocalDateTime.now();  // Inicializa con la fecha y hora actuales
    }*/


    /*
    Duration duration = Duration.between(horaIngreso, LocalDateTime.now());
        double minutos = duration.toMinutes();
     *         this.cobro = new BigDecimal(167* this.minutos).setScale(2, RoundingMode.HALF_UP).doubleValue();

     */