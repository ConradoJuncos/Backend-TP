package utn.frc.backend.pruebas;

//CREATE TABLE IF NOT EXISTS "Pruebas" (
//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//ID_VEHICULO INTEGER NOT NULL,
//ID_INTERESADO INTEGER NOT NULL,
//ID_EMPLEADO INTEGER NOT NULL,
//FECHA_HORA_INICIO TIMESTAMP DEFAULT (CURRENT_TIMESTAMP) NOT NULL,
//FECHA_HORA_FIN TIMESTAMP,
//COMENTARIOS TEXT(500),
//CONSTRAINT Pruebas_Interesados_FK FOREIGN KEY (ID_INTERESADO) REFERENCES Interesados(ID),
//CONSTRAINT Pruebas_Vehiculos_FK FOREIGN KEY (ID_VEHICULO) REFERENCES Vehiculos(ID),
//CONSTRAINT Pruebas_Empleados_FK FOREIGN KEY (ID_EMPLEADO) REFERENCES Empleados(LEGAJO)
//);

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prueba {
    private int id;
    private int idInteresado;
    private int idEmpleado;
    private int idVehiculo;
    private Timestamp fechaHoraInicio;
    private Timestamp fechaHoraFin;
    private String comentarios;
}