package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.exception.ResourceNotFoundException;
import utn.frc.backend.pruebas.model.Interesado;
import utn.frc.backend.pruebas.repository.InteresadoRepository;

import java.util.Optional;

@Service
public class InteresadoService {

    private final InteresadoRepository interesadoRepository;

    @Autowired
    public InteresadoService(InteresadoRepository interesadoRepository) {
        this.interesadoRepository = interesadoRepository;
    }

    public Interesado obtenerInteresadoPorId(Long id) {
        return interesadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El interesado no existe"));
    }

    public Interesado guardarInteresado(Interesado interesado) {
        return interesadoRepository.save(interesado);
    }

    public void restringirInteresado(long idInteresado) {
        Interesado interesado = interesadoRepository.findById(idInteresado)
                .orElseThrow(() -> new ResourceNotFoundException("El interesado no existe"));
        interesado.setRestringido(true);
        interesadoRepository.save(interesado);
    }
}
