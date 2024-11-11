package utn.frc.backend.pruebas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utn.frc.backend.pruebas.dto.CoordenadasDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZonaRestringida {
    private CoordenadasDTO noroeste;
    private CoordenadasDTO sureste;
}
