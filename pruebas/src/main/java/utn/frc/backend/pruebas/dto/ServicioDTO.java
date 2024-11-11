package utn.frc.backend.pruebas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ServicioDTO {
    private CoordenadasDTO coordenadasAgencia;
    private double radioAdmitidoKm;
    private List<ZonaRestringidaDTO> zonasRestringidas;
}
