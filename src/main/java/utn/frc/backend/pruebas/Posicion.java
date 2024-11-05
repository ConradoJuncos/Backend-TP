package utn.frc.backend.pruebas;

//CREATE TABLE Posiciones (
//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//ID_VEHICULO INTEGER NOT NULL,
//FECHA_HORA TIMESTAMP DEFAULT (CURRENT_TIMESTAMP) NOT NULL,
//LATITUD REAL NOT NULL,
//LONGITUD REAL NOT NULL,
//CONSTRAINT Posiciones_Vehiculos_FK FOREIGN KEY (ID_VEHICULO) REFERENCES Vehiculos(ID)
//);

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Posicion {
    private int id;
    private int idVehiculo;
    private Timestamp fecha;
    private double latitud;
    private double longitud;
}
