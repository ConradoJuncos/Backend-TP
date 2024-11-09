package utn.frc.backend.pruebas.model;

//CREATE TABLE Vehiculos (
//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//PATENTE TEXT NOT NULL,
//ID_MODELO INTEGER NOT NULL, ANIO INTEGER DEFAULT (2019) NOT NULL,
//CONSTRAINT Vehiculos_Modelos_FK FOREIGN KEY (ID_MODELO) REFERENCES Modelos(ID)
//);

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "PATENTE")
    private String patente;
    @Column(name = "ID_MODELO")
    private long idModelo;
}
