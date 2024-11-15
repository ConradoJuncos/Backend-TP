package utn.frc.backend.pruebas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frc.backend.pruebas.dto.EmpleadoDTO;
import utn.frc.backend.pruebas.dto.PruebaRequest;
import utn.frc.backend.pruebas.dto.PruebaResponseDTO;
import utn.frc.backend.pruebas.model.Prueba;
import utn.frc.backend.pruebas.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import utn.frc.backend.pruebas.service.PruebaService;

import java.util.List;

@RestController
@RequestMapping("/api/pruebas")
public class PruebaController {

    private final EmpleadoService empleadoService;
    private final PruebaService pruebaService;

    @Autowired
    public PruebaController(EmpleadoService empleadoService, PruebaService pruebaService) {
        this.empleadoService = empleadoService;
        this.pruebaService = pruebaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PruebaResponseDTO> getPruebaById(@PathVariable long id) {
        Prueba prueba = pruebaService.obtenerPruebaPorId(id);

        if (prueba == null) {
            return ResponseEntity.notFound().build();
        }

        // Obtener datos del empleado
        EmpleadoDTO empleado = empleadoService.obtenerEmpleadoPorId(prueba.getIdEmpleado());

        // Crear el DTO de respuesta
        PruebaResponseDTO pruebaResponseDTO = new PruebaResponseDTO(
                prueba.getId(),
                prueba.getVehiculo(),
                prueba.getInteresado(),
                empleado,
                prueba.getFechaHoraInicio(),
                prueba.getFechaHoraFin(),
                prueba.getComentarios()
        );

        return ResponseEntity.ok(pruebaResponseDTO);
    }

    @GetMapping("/en-curso")
    public List<Prueba> obtenerPruebasEnCurso() {
        return pruebaService.obtenerPruebasEnCurso();
    }

    @PatchMapping("/{id}/finalizar")
    public ResponseEntity<String> finalizarPrueba(
            @PathVariable Long id,
            @RequestBody String comentarios) {
        pruebaService.buscarYFinalizar(id, comentarios);
        return ResponseEntity.ok("Prueba finalizada exitosamente.");
    }

//  Ejemplo JSON
//  {
//      "idVehiculo": 2,
//      "idInteresado": 1,
//      "idEmpleado": 1
//  }
    @PostMapping("/crear")
    public Prueba crearPrueba(@RequestBody PruebaRequest pruebaRequest) {
        // Llamar al servicio para crear la prueba con los datos proporcionados
        return pruebaService.crearPrueba(
                pruebaRequest.getIdVehiculo(),
                pruebaRequest.getIdInteresado(),
                pruebaRequest.getIdEmpleado()
        );
    }

    // Nuevo endpoint para listar todas las pruebas de un vehículo específico
    @GetMapping("/vehiculo/{idVehiculo}")
    public List<Prueba> obtenerPruebasPorVehiculo(@PathVariable long idVehiculo) {
        return pruebaService.obtenerPruebasPorVehiculo(idVehiculo);
    }

//    @GetMapping("/empleado/{id}")
//    public EmpleadoDTO obtenerEmpleado(@PathVariable Long id) {
//        return empleadoService.obtenerEmpleadoPorId(id);
//    }
}
