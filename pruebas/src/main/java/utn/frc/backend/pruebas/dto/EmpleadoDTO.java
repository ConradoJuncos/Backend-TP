package utn.frc.backend.pruebas.dto;

import lombok.Data;

@Data
public class EmpleadoDTO {
    private long legajo;
    private String nombre;
    private String apellido;
    private long telefonoContacto;
}
