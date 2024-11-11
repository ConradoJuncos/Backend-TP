package utn.frc.backend.pruebas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ZonaRestringidaDTO {
    private CoordenadasDTO noroeste;
    private CoordenadasDTO sureste;
}
