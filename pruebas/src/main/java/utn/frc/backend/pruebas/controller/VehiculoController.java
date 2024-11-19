package utn.frc.backend.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utn.frc.backend.pruebas.service.VehiculoService;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @Autowired
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarVehiculo(@PathVariable Long id) {
        vehiculoService.borrarVehiculo(id);
        return ResponseEntity.ok("Vehículo con ID " + id + " eliminado exitosamente.");
    }
}
