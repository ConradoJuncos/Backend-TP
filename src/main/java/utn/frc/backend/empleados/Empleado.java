package utn.frc.backend.empleados;

//CREATE TABLE Empleados (
//LEGAJO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//NOMBRE TEXT(30) NOT NULL,
//APELLIDO TEXT(50) NOT NULL,
//TELEFONO_CONTACTO INTEGER NOT NULL
//);

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    private int legajo;
    private String nombre;
    private String apellido;
    private int telefonoContacto;
}
