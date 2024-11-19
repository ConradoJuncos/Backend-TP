package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.exception.ResourceNotFoundException;
import utn.frc.backend.pruebas.model.Vehiculo;
import utn.frc.backend.pruebas.repository.VehiculoRepository;

import java.util.Optional;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Autowired
    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public Vehiculo obtenerVehiculoPorId(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El vehículo no existe"));
    }

    public Vehiculo guardarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public void borrarVehiculo(Long id) {
        if (!vehiculoRepository.existsById(id)) {
            throw new IllegalArgumentException("Vehículo con ID " + id + " no existe");
        }
        vehiculoRepository.deleteById(id);
    }
}
