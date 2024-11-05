package utn.frc.backend.pruebas;

//ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
//TIPO_DOCUMENTO TEXT(3) DEFAULT ('"DNI"') NOT NULL,
//DOCUMENTO TEXT(10) NOT NULL,
//NOMBRE TEXT(50) NOT NULL,
//APELLIDO TEXT(50) NOT NULL,
//RESTRINGIDO BOOLEAN DEFAULT (FALSE) NOT NULL,
//NRO_LICENCIA INTEGER NOT NULL,
//FECHA_VENCIMIENTO_LICENCIA TIMESTAMP NOT NULL

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interesado {
    private int id;
    private String tipoDocumento;
    private String documento; // String por si el tipo de documento es cuit 20-12345678-9
    private String nombre;
    private String apellido;
    private boolean restringido;
    private int numeroLicencia;
    private Timestamp fechaVencimientoLicencia;
}
