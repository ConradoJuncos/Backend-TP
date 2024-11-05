package utn.frc.backend.pruebas;

//CREATE TABLE IF NOT EXISTS "Modelos" (
//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//ID_MARCA INTEGER NOT NULL,
//DESCRIPCION TEXT NOT NULL,
//CONSTRAINT Modelo_Marca_FK FOREIGN KEY (ID_MARCA) REFERENCES "Marcas"(ID)
//);

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modelo {
    private int id;
    private int idMarca;
    private String descripcion;
}
