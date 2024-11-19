package utn.frc.backend.empleados.controller;

import org.springframework.http.ResponseEntity;
import utn.frc.backend.empleados.service.EmpleadoService;
import utn.frc.backend.empleados.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/crear")
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.crearEmpleado(empleado);
    }

    @GetMapping("/{id}")
    public Empleado obtenerEmpleadoPorId(@PathVariable Long id) {
        return empleadoService.obtenerEmpleadoPorId(id);
    }

    @DeleteMapping("/borrar/{legajo}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable long legajo) {
        empleadoService.eliminarEmpleado(legajo);
        return ResponseEntity.ok("Empleado con legajo " + legajo + " eliminado exitosamente.");
    }
}
