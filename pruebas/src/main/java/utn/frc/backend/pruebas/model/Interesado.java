package utn.frc.backend.pruebas.model;

//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//TIPO_DOCUMENTO TEXT(3) DEFAULT ('"DNI"') NOT NULL,
//DOCUMENTO TEXT(10) NOT NULL,
//NOMBRE TEXT(50) NOT NULL,
//APELLIDO TEXT(50) NOT NULL,
//RESTRINGIDO BOOLEAN DEFAULT (FALSE) NOT NULL,
//NRO_LICENCIA INTEGER NOT NULL,
//FECHA_VENCIMIENTO_LICENCIA TIMESTAMP NOT NULL

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Interesados")
public class Interesado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Column(name = "DOCUMENTO")
    private String documento; // String por si el tipo de documento es cuit 20-12345678-9
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "RESTRINGIDO")
    private boolean restringido;
    @Column(name = "NRO_LICENCIA")
    private int numeroLicencia;
    @Column(name = "FECHA_VENCIMIENTO_LICENCIA")
    private Timestamp fechaVencimientoLicencia;
}
