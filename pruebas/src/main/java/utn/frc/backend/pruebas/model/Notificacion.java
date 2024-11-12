package utn.frc.backend.pruebas.model;

//CREATE TABLE IF NOT EXISTS Notificaciones (
//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//ID_EMPLEADO INTEGER NOT NULL,
//ID_INTERESADO INTEGER NOT NULL,
//ID_VEHICULO INTEGER NOT NULL,
//FECHA_HORA TIMESTAMP DEFAULT (CURRENT_TIMESTAMP) NOT NULL,
//CONSTRAINT Notificaciones_Empleados_FK FOREIGN KEY (ID_EMPLEADO) REFERENCES Empleados(LEGAJO),
//CONSTRAINT Notificaciones_Interesados_FK FOREIGN KEY (ID_INTERESADO) REFERENCES Interesados(ID),
//CONSTRAINT Notificaciones_Vehiculos_FK FOREIGN KEY (ID_VEHICULO) REFERENCES Vehiculos(ID)
//);


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Notificaciones")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "ID_EMPLEADO", nullable = false)
    private long idEmpleado;

    @Column(name = "ID_INTERESADO", nullable = false)
    private long idInteresado;

    @Column(name = "ID_VEHICULO", nullable = false)
    private long idVehiculo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "FECHA_HORA", nullable = false)
    private Timestamp fechaHora;

    public Notificacion(long idEmpleado, long idInteresado, long idVehiculo) {
        this.idEmpleado = idEmpleado;
        this.idInteresado = idInteresado;
        this.idVehiculo = idVehiculo;
        this.fechaHora = new Timestamp(System.currentTimeMillis());
    }
}
