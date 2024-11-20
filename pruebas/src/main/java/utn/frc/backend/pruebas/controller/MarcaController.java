package utn.frc.backend.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frc.backend.pruebas.model.Marca;
import utn.frc.backend.pruebas.service.MarcaService;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping("/{id}")
    public Marca obtenerMarcaPorId(@PathVariable Long id) {
        return marcaService.obtenerMarcaPorId(id);
    }

    @GetMapping
    public List<Marca> obtenerTodasLasMarcas() {
        return marcaService.obtenerTodasLasMarcas();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarMarca(@PathVariable Long id) {
        marcaService.borrarMarca(id);
        return ResponseEntity.ok("Marca con ID " + id + " eliminada exitosamente.");
    }
}
