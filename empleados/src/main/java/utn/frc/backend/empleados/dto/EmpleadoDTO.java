package utn.frc.backend.empleados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {
    private long legajo;
    private String nombre;
    private String apellido;
    private int telefonoContacto;
}
