package utn.frc.backend.pruebas.model;

//CREATE TABLE Posiciones (
//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//ID_VEHICULO INTEGER NOT NULL,
//FECHA_HORA TIMESTAMP DEFAULT (CURRENT_TIMESTAMP) NOT NULL,
//LATITUD REAL NOT NULL,
//LONGITUD REAL NOT NULL,
//CONSTRAINT Posiciones_Vehiculos_FK FOREIGN KEY (ID_VEHICULO) REFERENCES Vehiculos(ID)
//);

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Posiciones")
public class Posicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "ID_VEHICULO", nullable = false)
    private long idVehiculo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "FECHA_HORA", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fecha;

    @Column(name = "LATITUD", nullable = false)
    private double latitud;

    @Column(name = "LONGITUD", nullable = false)
    private double longitud;
}
