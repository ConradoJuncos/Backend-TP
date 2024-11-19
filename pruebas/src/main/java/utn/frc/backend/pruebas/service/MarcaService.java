package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.exception.ResourceNotFoundException;
import utn.frc.backend.pruebas.model.Marca;
import utn.frc.backend.pruebas.repository.MarcaRepository;

import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca obtenerMarcaPorId(Long id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Marca con ID " + id + " no encontrada."));
    }

    public List<Marca> obtenerTodasLasMarcas() {
        return marcaRepository.findAll();
    }

    public void borrarMarca(Long id) {
        if (!marcaRepository.existsById(id)) {
            throw new IllegalArgumentException("Marca con ID " + id + " no existe");
        }
        marcaRepository.deleteById(id);
    }
}
