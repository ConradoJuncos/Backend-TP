package utn.frc.backend.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frc.backend.pruebas.dto.CoordenadasDTO;
import utn.frc.backend.pruebas.exception.ResourceNotFoundException;
import utn.frc.backend.pruebas.model.Posicion;
import utn.frc.backend.pruebas.service.GeofenceService;
import utn.frc.backend.pruebas.service.InteresadoService;
import utn.frc.backend.pruebas.service.NotificacionService;
import utn.frc.backend.pruebas.service.PosicionService;

import java.util.Optional;

@RestController
@RequestMapping("/api/posiciones")
public class PosicionController {

    @Autowired
    private PosicionService posicionService;
    @Autowired
    private GeofenceService geofenceService;
    @Autowired
    private InteresadoService interesadoService;
    @Autowired
    private NotificacionService notificacionService;

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

    @GetMapping("/verificar/{idVehiculo}")
    public String verificarUbicacion(@PathVariable long idVehiculo) {
        Posicion posicionReciente = posicionService.obtenerPosicionMasReciente(idVehiculo)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró una posición para el vehículo"));

        if (posicionReciente == null) {
            return "No se encontró ninguna posición para el vehículo con ID " + idVehiculo;
        }

        CoordenadasDTO ubicacionVehiculo = new CoordenadasDTO(posicionReciente.getLatitud(),
                                                            posicionReciente.getLongitud());

        boolean estaDentroDelRadio = geofenceService.estaDentroDelRadio(ubicacionVehiculo);
        boolean estaEnZonaRestringida = geofenceService.estaEnZonaRestringida(ubicacionVehiculo);

        if (!estaDentroDelRadio) {
            long idInteresado = posicionService.obtenerIdInteresadoPorVehiculo(idVehiculo)
                    .orElseThrow(() -> new RuntimeException("No se encontró el interesado a restringir"));
            interesadoService.restringirInteresado(idInteresado);


            notificacionService.crearNotificacion(idEmpleado, idInteresado, idVehiculo, "Vehículo fuera del radio permitido");


            return "El vehículo está fuera del radio permitido de la agencia. \n" +
                    "Se ha restringido al interesado de id " + idInteresado;
        }

        if (estaEnZonaRestringida) {
            long idInteresado = posicionService.obtenerIdInteresadoPorVehiculo(idVehiculo)
                    .orElseThrow(() -> new RuntimeException("No se encontró el interesado a restringir"));
            interesadoService.restringirInteresado(idInteresado);


            notificacionService.crearNotificacion(idEmpleado, idInteresado, idVehiculo, "Vehículo fuera del radio permitido");


            return "El vehículo se encuentra en una zona restringida. \n" +
                    "Se ha restringido al interesado de id " + idInteresado;
        }
        return "El vehículo está dentro del radio permitido y fuera de las zonas restringidas.";
    }
}
