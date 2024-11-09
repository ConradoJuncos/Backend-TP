package utn.frc.backend.pruebas.controller;

import org.springframework.web.bind.annotation.*;
import utn.frc.backend.pruebas.dto.EmpleadoDTO;
import utn.frc.backend.pruebas.dto.PruebaRequest;
import utn.frc.backend.pruebas.model.Prueba;
import utn.frc.backend.pruebas.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import utn.frc.backend.pruebas.service.PruebaService;

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
    public Prueba obtenerPruebaPorId(@PathVariable Long id) {
        return pruebaService.obtenerPruebaPorId(id);
    }

    @PostMapping("/crear")
    public Prueba crearPrueba(@RequestBody PruebaRequest pruebaRequest) {
        // Llamar al servicio para crear la prueba con los datos proporcionados
        return pruebaService.crearPrueba(
                pruebaRequest.getIdVehiculo(),
                pruebaRequest.getIdInteresado(),
                pruebaRequest.getIdEmpleado()
        );
    }

//    @GetMapping("/empleado/{id}")
//    public EmpleadoDTO obtenerEmpleado(@PathVariable Long id) {
//        return empleadoService.obtenerEmpleadoPorId(id);
//    }
}
