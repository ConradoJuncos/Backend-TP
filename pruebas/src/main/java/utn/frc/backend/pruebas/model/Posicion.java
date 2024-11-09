package utn.frc.backend.pruebas.model;

//CREATE TABLE Posiciones (
//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//ID_VEHICULO INTEGER NOT NULL,
//FECHA_HORA TIMESTAMP DEFAULT (CURRENT_TIMESTAMP) NOT NULL,
//LATITUD REAL NOT NULL,
//LONGITUD REAL NOT NULL,
//CONSTRAINT Posiciones_Vehiculos_FK FOREIGN KEY (ID_VEHICULO) REFERENCES Vehiculos(ID)
//);

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
    @Column(name = "ID_VEHICULO")
    private long idVehiculo;
    @Column(name = "FECHA_HORA")
    private Timestamp fecha;
    @Column(name = "LATITUD")
    private double latitud;
    @Column(name = "LONGITUD")
    private double longitud;
}
