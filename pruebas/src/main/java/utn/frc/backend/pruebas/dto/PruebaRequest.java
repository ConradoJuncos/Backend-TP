package utn.frc.backend.pruebas.dto;

import utn.frc.backend.pruebas.model.Prueba;
import lombok.Data;

@Data
public class PruebaRequest {
    private Long idVehiculo;
    private Long idInteresado;
    private Long idEmpleado;
}
