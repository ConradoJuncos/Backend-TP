package utn.frc.backend.pruebas;

//CREATE TABLE Vehiculos (
//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//PATENTE TEXT NOT NULL,
//ID_MODELO INTEGER NOT NULL, ANIO INTEGER DEFAULT (2019) NOT NULL,
//CONSTRAINT Vehiculos_Modelos_FK FOREIGN KEY (ID_MODELO) REFERENCES Modelos(ID)
//);

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
    private int id;
    private String patente;
    private int idModelo;
}
