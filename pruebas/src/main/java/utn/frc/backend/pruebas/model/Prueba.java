package utn.frc.backend.pruebas.model;

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

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pruebas")
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "ID_VEHICULO", referencedColumnName = "ID", nullable = false)
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "ID_INTERESADO", referencedColumnName = "ID", nullable = false)
    private Interesado interesado;

    @ManyToOne
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "LEGAJO", nullable = false)
    private Empleado empleado;

    @Column(name = "FECHA_HORA_INICIO", nullable = false)
    private Timestamp fechaHoraInicio;

    @Column(name = "FECHA_HORA_FIN")
    private Timestamp fechaHoraFin;

    @Column(name = "COMENTARIOS", length = 500)
    private String comentarios;
}