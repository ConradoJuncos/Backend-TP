package utn.frc.backend.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utn.frc.backend.pruebas.service.ModeloService;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    private final ModeloService modeloService;

    @Autowired
    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarModelo(@PathVariable Long id) {
        modeloService.borrarModelo(id);
        return ResponseEntity.ok("Modelo con ID " + id + " eliminado exitosamente.");
    }
}
