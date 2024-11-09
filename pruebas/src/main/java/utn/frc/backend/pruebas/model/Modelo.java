package utn.frc.backend.pruebas.model;

//CREATE TABLE IF NOT EXISTS "Modelos" (
//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//ID_MARCA INTEGER NOT NULL,
//DESCRIPCION TEXT NOT NULL,
//CONSTRAINT Modelo_Marca_FK FOREIGN KEY (ID_MARCA) REFERENCES "Marcas"(ID)
//);

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Modelos")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "ID_MARCA")
    private long idMarca;
    @Column(name = "DESCRIPCION")
    private String descripcion;
}