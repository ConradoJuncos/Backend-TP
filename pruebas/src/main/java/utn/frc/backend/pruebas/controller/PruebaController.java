package utn.frc.backend.pruebas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import utn.frc.backend.pruebas.dto.EmpleadoDTO;
import utn.frc.backend.pruebas.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pruebas")
public class PruebaController {

    private final EmpleadoService empleadoService;

    @Autowired
    public PruebaController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/empleado/{id}")
    public EmpleadoDTO obtenerEmpleado(@PathVariable Long id) {
        return empleadoService.obtenerEmpleadoPorId(id);
    }
}
