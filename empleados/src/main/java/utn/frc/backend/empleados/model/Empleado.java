package utn.frc.backend.empleados.model;

//CREATE TABLE Empleados (
//LEGAJO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//NOMBRE TEXT(30) NOT NULL,
//APELLIDO TEXT(50) NOT NULL,
//TELEFONO_CONTACTO INTEGER NOT NULL
//);

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEGAJO")
    private long legajo;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "TELEFONO_CONTACTO")
    private long telefonoContacto;
}
