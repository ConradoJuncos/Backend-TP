package utn.frc.backend.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frc.backend.pruebas.model.Posicion;
import utn.frc.backend.pruebas.service.PosicionService;

import java.util.Optional;

@RestController
@RequestMapping("/api/posiciones")
public class PosicionController {

    @Autowired
    private PosicionService posicionService;

//  localhost:8081/api/posiciones/nueva?idVehiculo=1&latitud=42.509&longitud=1.534
    @PostMapping("/nueva")
    public Posicion crearPosicion(@RequestParam long idVehiculo,
                                  @RequestParam double latitud,
                                  @RequestParam double longitud) {
        return posicionService.crearPosicion(idVehiculo, latitud, longitud);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posicion> obtenerPosicionPorId(@PathVariable long id) {
        Optional<Posicion> posicion = posicionService.obtenerPosicionPorId(id);

        if (posicion.isPresent()) {
            return ResponseEntity.ok(posicion.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/vehiculo/{idVehiculo}/ultima")
    public ResponseEntity<Posicion> obtenerUltimaPosicion(@PathVariable long idVehiculo) {
        Optional<Posicion> posicionOpt = posicionService.obtenerPosicionMasReciente(idVehiculo);

        if (posicionOpt.isPresent()) {
            return ResponseEntity.ok(posicionOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
