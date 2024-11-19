package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.exception.ResourceNotFoundException;
import utn.frc.backend.pruebas.model.Modelo;
import utn.frc.backend.pruebas.repository.ModeloRepository;

import java.util.List;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;

    @Autowired
    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    public Modelo obtenerModeloPorId(Long id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Modelo con ID " + id + " no encontrado."));
    }

    public List<Modelo> obtenerTodosLosModelos() {
        return modeloRepository.findAll();
    }

    public void borrarModelo(Long id) {
        if (!modeloRepository.existsById(id)) {
            throw new IllegalArgumentException("Modelo con ID " + id + " no existe");
        }
        modeloRepository.deleteById(id);
    }
}
