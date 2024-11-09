package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.dto.EmpleadoDTO;
import utn.frc.backend.pruebas.exception.ResourceNotFoundException;
import utn.frc.backend.pruebas.model.Interesado;
import utn.frc.backend.pruebas.model.Prueba;
import utn.frc.backend.pruebas.model.Vehiculo;
import utn.frc.backend.pruebas.repository.PruebaRepository;

import java.util.Optional;

@Service
public class PruebaService {

    private final PruebaRepository pruebaRepository;
    private final InteresadoService interesadoService;
    private final VehiculoService vehiculoService;
    private final EmpleadoService empleadoService;

    @Autowired
    public PruebaService(PruebaRepository pruebaRepository,
                         InteresadoService interesadoService,
                         VehiculoService vehiculoService,
                         EmpleadoService empleadoService) {
        this.pruebaRepository = pruebaRepository;
        this.interesadoService = interesadoService;
        this.vehiculoService = vehiculoService;
        this.empleadoService = empleadoService;
    }

    public Prueba obtenerPruebaPorId(Long id) {
        return pruebaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prueba no encontrada con ID: " + id));
    }

    public Prueba crearPrueba(long idVehiculo, long idInteresado, long idEmpleado) {
        // Obtener el Vehiculo
        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(idVehiculo);

        // Obtener el Interesado
        Interesado interesado = interesadoService.obtenerInteresadoPorId(idInteresado);

        // Llamada al microservicio Empleados para obtener los detalles del empleado
        EmpleadoDTO empleado = empleadoService.obtenerEmpleadoPorId(idEmpleado);
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no existe.");
        }

        Prueba prueba = new Prueba(vehiculo, interesado, empleado);

        return pruebaRepository.save(prueba);
    }
}
