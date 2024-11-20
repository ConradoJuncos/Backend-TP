package utn.frc.backend.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frc.backend.pruebas.model.Interesado;
import utn.frc.backend.pruebas.service.InteresadoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/interesados")
public class InteresadoController {

    private final InteresadoService interesadoService;

    @Autowired
    public InteresadoController(InteresadoService interesadoService) {
        this.interesadoService = interesadoService;
    }

//  Endpoint para crear un nuevo interesado
//  JSON de ejemplo
//    {
//        "tipoDocumento": "DNI",
//            "documento": 32648795,
//            "nombre": "Pedro",
//            "apellido": "Uop",
//            "numeroLicencia": 85648,
//            "fechaVencimientoLicencia": "2025-12-31 23:59:59"
//    }
    @PostMapping("/crear")
    public Interesado crearInteresado(@RequestBody Interesado interesado) {
        return interesadoService.guardarInteresado(interesado);
    }

    // Endpoint para obtener un interesado por ID
    @GetMapping("/{id}")
    public Interesado obtenerInteresadoPorId(@PathVariable Long id) {
        return interesadoService.obtenerInteresadoPorId(id);
    }

    @GetMapping
    public List<Interesado> obtenerTodosLosInteresados() {
        return interesadoService.obtenerTodosLosInteresados();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarInteresado(@PathVariable Long id) {
        interesadoService.borrarInteresado(id);
        return ResponseEntity.ok("Interesado con ID " + id + " eliminado exitosamente.");
    }
}
