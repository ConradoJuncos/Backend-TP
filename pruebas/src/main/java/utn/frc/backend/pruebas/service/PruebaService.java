package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.dto.EmpleadoDTO;
import utn.frc.backend.pruebas.exception.ResourceNotFoundException;
import utn.frc.backend.pruebas.model.Interesado;
import utn.frc.backend.pruebas.model.Prueba;
import utn.frc.backend.pruebas.model.Vehiculo;
import utn.frc.backend.pruebas.repository.PruebaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Prueba> obtenerPruebasEnCurso() {
        return pruebaRepository.findByFechaHoraFinIsNull();
    }

    public boolean esVehiculoEnUso(Long vehiculoId) {
        // Buscar pruebas activas para el vehículo
        List<Prueba> pruebasActivas = pruebaRepository.findByVehiculoIdAndFechaHoraFinIsNull(vehiculoId);
        return !pruebasActivas.isEmpty();
    }

    public void buscarYFinalizar(long idPrueba, String comentarios) {
        Prueba prueba = pruebaRepository.findById(idPrueba)
                .orElseThrow(() -> new RuntimeException("Prueba no encontrada"));
        prueba.finalizarPrueba(comentarios);
        pruebaRepository.save(prueba);
    }

    public Prueba crearPrueba(long idVehiculo, long idInteresado, long idEmpleado) {

        // Validación de que el vehículo no esté en uso
        if (esVehiculoEnUso(idVehiculo)) {
            throw new RuntimeException("El vehículo está en uso en otra prueba");
        }

        // Obtener el Vehículo
        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(idVehiculo);

        // Obtener el Interesado
        Interesado interesado = interesadoService.obtenerInteresadoPorId(idInteresado);

        // Validación de la licencia del interesado
        if (interesado.isRestringido()) {
            throw new RuntimeException("El interesado está restringido");
        }

        // Validación de la licencia del interesado
        if (interesado.isVencida()) {
            throw new RuntimeException("La licencia está vencida");
        }

        // Llamada al microservicio Empleados para obtener los detalles del empleado
        EmpleadoDTO empleado = empleadoService.obtenerEmpleadoPorId(idEmpleado);
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no existe.");
        }

        Prueba prueba = new Prueba(vehiculo, interesado, empleado);

        return pruebaRepository.save(prueba);
    }

    public List<Prueba> obtenerPruebasPorVehiculo(long idVehiculo) {
        return pruebaRepository.findAll().stream()
                .filter(prueba -> prueba.getVehiculo().getId() == idVehiculo)
                .collect(Collectors.toList());
    }
}
