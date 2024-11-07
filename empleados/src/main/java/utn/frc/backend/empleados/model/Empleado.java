package utn.frc.backend.empleados.model;

//CREATE TABLE Empleados (
//LEGAJO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//NOMBRE TEXT(30) NOT NULL,
//APELLIDO TEXT(50) NOT NULL,
//TELEFONO_CONTACTO INTEGER NOT NULL
//);

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long legajo;
    private String nombre;
    private String apellido;
    private int telefonoContacto;
}
