package utn.frc.backend.pruebas;

//CREATE TABLE IF NOT EXISTS "Marcas" (
//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//NOMBRE TEXT(30) NOT NULL
//);

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marca {
    private int id;
    private String nombre;
}
