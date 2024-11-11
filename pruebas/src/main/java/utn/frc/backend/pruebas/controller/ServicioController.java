package utn.frc.backend.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utn.frc.backend.pruebas.service.GeofenceService;
import utn.frc.backend.pruebas.service.ServicioService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/informacion")
public class ServicioController {

    private final ServicioService servicioService;
    private final GeofenceService geofenceService;

    @Autowired
    public ServicioController(ServicioService servicioService, GeofenceService geofenceService) {
        this.servicioService = servicioService;
        this.geofenceService = geofenceService;
    }

    @GetMapping
    public Map<String, Object> obtenerConfiguracion() {
        servicioService.actualizarConfiguracion();
        Map<String, Object> response = new HashMap<>();
        response.put("coordenadasAgencia", servicioService.getCoordenadasAgencia());
        response.put("radioAdmitidoKm", servicioService.getRadioAdmitidoKm());
        response.put("zonasRestringidas", servicioService.getZonasRestringidas());
        geofenceService.actualizarGeofence(servicioService.getCoordenadasAgencia(),
                servicioService.getRadioAdmitidoKm(),
                servicioService.getZonasRestringidas());
        return response;
    }
}
