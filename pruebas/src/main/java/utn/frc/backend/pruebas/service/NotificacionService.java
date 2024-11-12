package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.dto.EmpleadoDTO;
import utn.frc.backend.pruebas.dto.NotificacionDTO;
import utn.frc.backend.pruebas.model.Notificacion;
import utn.frc.backend.pruebas.repository.NotificacionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private InteresadoService interesadoService;
    @Autowired
    private VehiculoService vehiculoService;

    public void crearNotificacion(long idEmpleado, long idInteresado, long idVehiculo) {
        Notificacion notificacion = new Notificacion(idEmpleado, idInteresado, idVehiculo);

        notificacionRepository.save(notificacion);
    }

    public List<NotificacionDTO> obtenerTodasLasNotificaciones() {
        return notificacionRepository.findAll().stream()
                .map(this::convertirANotificacionDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotificacionDTO> obtenerNotificacionPorId(long id) {
        return notificacionRepository.findById(id)
                .map(this::convertirANotificacionDTO);
    }

    private NotificacionDTO convertirANotificacionDTO(Notificacion notificacion) {
        return new NotificacionDTO(
                notificacion.getId(),
                empleadoService.obtenerEmpleadoPorId(notificacion.getIdEmpleado()),
                interesadoService.obtenerInteresadoPorId(notificacion.getIdInteresado()),
                vehiculoService.obtenerVehiculoPorId(notificacion.getIdVehiculo()),
                notificacion.getFechaHora()
        );
    }

}
