package utn.frc.backend.empleados.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.empleados.exception.EmpleadoNotFoundException;
import utn.frc.backend.empleados.model.Empleado;
import utn.frc.backend.empleados.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoService.class);

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Empleado crearEmpleado(Empleado empleado) {
        logger.info("Intentando crear un empleado con legajo: {}", empleado.getLegajo());
        if (empleadoRepository.existsById(empleado.getLegajo())) {
            logger.warn("El empleado con legajo {} ya existe. Lanzando excepción.", empleado.getLegajo());
            throw new IllegalArgumentException("El empleado ya existe");
        }
        logger.info("Empleado creado exitosamente con legajo: {}", empleado.getLegajo());
        return empleadoRepository.save(empleado);
    }

    public Empleado obtenerEmpleadoPorId(Long id) {
        logger.info("Buscando empleado con ID: {}", id);
        return empleadoRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Empleado con ID {} no encontrado. Lanzando excepción.", id);
                    return new EmpleadoNotFoundException("Empleado no encontrado");
                });
    }

    public void eliminarEmpleado(long legajo) {
        logger.info("Intentando eliminar el empleado con legajo: {}", legajo);

        if (!empleadoRepository.existsById(legajo)) {
            logger.warn("El empleado con legajo {} no existe. Lanzando excepción.", legajo);
            throw new IllegalArgumentException("El empleado con legajo " + legajo + " no existe");
        }

        empleadoRepository.deleteById(legajo);
        logger.info("Empleado con legajo {} eliminado exitosamente.", legajo);
    }
}
