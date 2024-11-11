package utn.frc.backend.pruebas.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import utn.frc.backend.pruebas.dto.CoordenadasDTO;
import utn.frc.backend.pruebas.dto.ServicioDTO;
import utn.frc.backend.pruebas.dto.ZonaRestringidaDTO;

import java.util.List;

@Service
public class ServicioService {

    private final String CONFIG_URL = "https://labsys.frc.utn.edu.ar/apps-disponibilizadas/backend/api/v1/configuracion/";
    private final RestTemplate restTemplate;

    // Variables para almacenar la configuración actual
    @Getter
    private CoordenadasDTO coordenadasAgencia;
    @Getter
    private double radioAdmitidoKm;
    @Getter
    private List<ZonaRestringidaDTO> zonasRestringidas;

    public ServicioService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void actualizarConfiguracion() {
        ServicioDTO informacion = restTemplate.getForObject(CONFIG_URL, ServicioDTO.class);
        if (informacion != null) {
            this.coordenadasAgencia = informacion.getCoordenadasAgencia();
            this.radioAdmitidoKm = informacion.getRadioAdmitidoKm();
            this.zonasRestringidas = informacion.getZonasRestringidas();
        } else {
            throw new RuntimeException("Error al obtener la información desde el servicio externo");
        }
    }

}