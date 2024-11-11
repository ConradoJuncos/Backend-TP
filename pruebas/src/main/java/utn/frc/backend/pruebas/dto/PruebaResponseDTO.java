package utn.frc.backend.pruebas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utn.frc.backend.pruebas.model.Interesado;
import utn.frc.backend.pruebas.model.Vehiculo;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PruebaResponseDTO {
    private long id;
    private Vehiculo vehiculo;
    private Interesado interesado;
    private EmpleadoDTO empleado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fechaHoraInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fechaHoraFin;

    private String comentarios;
}
