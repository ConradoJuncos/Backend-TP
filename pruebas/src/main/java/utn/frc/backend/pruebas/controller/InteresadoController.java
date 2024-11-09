package utn.frc.backend.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import utn.frc.backend.pruebas.model.Interesado;
import utn.frc.backend.pruebas.service.InteresadoService;

import java.util.Optional;

@RestController
@RequestMapping("/api/interesados")
public class InteresadoController {

    private final InteresadoService interesadoService;

    @Autowired
    public InteresadoController(InteresadoService interesadoService) {
        this.interesadoService = interesadoService;
    }

    // Endpoint para crear un nuevo interesado
    @PostMapping("/crear")
    public Interesado crearInteresado(@RequestBody Interesado interesado) {
        return interesadoService.guardarInteresado(interesado);
    }

    // Endpoint para obtener un interesado por ID
    @GetMapping("/{id}")
    public Interesado obtenerInteresadoPorId(@PathVariable Long id) {
        return interesadoService.obtenerInteresadoPorId(id);
    }
}
