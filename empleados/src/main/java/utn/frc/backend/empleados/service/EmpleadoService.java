package utn.frc.backend.empleados.service;

import utn.frc.backend.empleados.exception.EmpleadoNotFoundException;
import utn.frc.backend.empleados.model.Empleado;
import utn.frc.backend.empleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }


    // todo - Revisar esto. En el peor caso, busca si el id ya existe, lo cual nunca pasa porque el id se gestiona automaticamente y es inutil

    public Empleado crearEmpleado(Empleado empleado) {
        if (empleadoRepository.existsById(empleado.getLegajo())) {
            throw new IllegalArgumentException("El empleado ya existe");
        }
        return empleadoRepository.save(empleado);
    }

    public Empleado obtenerEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new EmpleadoNotFoundException("Empleado no encontrado"));
    }
}
