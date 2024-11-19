package utn.frc.backend.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utn.frc.backend.pruebas.service.MarcaService;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarMarca(@PathVariable Long id) {
        marcaService.borrarMarca(id);
        return ResponseEntity.ok("Marca con ID " + id + " eliminada exitosamente.");
    }
}
