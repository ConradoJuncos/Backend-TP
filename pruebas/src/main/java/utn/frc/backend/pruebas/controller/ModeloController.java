package utn.frc.backend.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frc.backend.pruebas.model.Modelo;
import utn.frc.backend.pruebas.service.ModeloService;

import java.util.List;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    private final ModeloService modeloService;

    @Autowired
    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping("/{id}")
    public Modelo obtenerModeloPorId(@PathVariable Long id) {
        return modeloService.obtenerModeloPorId(id);
    }

    @GetMapping
    public List<Modelo> obtenerTodosLosModelos() {
        return modeloService.obtenerTodosLosModelos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarModelo(@PathVariable Long id) {
        modeloService.borrarModelo(id);
        return ResponseEntity.ok("Modelo con ID " + id + " eliminado exitosamente.");
    }
}
