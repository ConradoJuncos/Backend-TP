package utn.frc.backend.pruebas;

//CREATE TABLE Posiciones (
//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//ID_VEHICULO INTEGER NOT NULL,
//FECHA_HORA TIMESTAMP DEFAULT (CURRENT_TIMESTAMP) NOT NULL,
//LATITUD REAL NOT NULL,
//LONGITUD REAL NOT NULL,
//CONSTRAINT Posiciones_Vehiculos_FK FOREIGN KEY (ID_VEHICULO) REFERENCES Vehiculos(ID)
//);

import java.sql.Timestamp;

public class Posicion {
    private int id;
    private int idVehiculo;
    private Timestamp fecha;
    private double latitud;
    private double longitud;
}
