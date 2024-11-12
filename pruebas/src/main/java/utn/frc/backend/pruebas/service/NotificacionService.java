package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.dto.EmpleadoDTO;
import utn.frc.backend.pruebas.model.Notificacion;
import utn.frc.backend.pruebas.repository.NotificacionRepository;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public void crearNotificacion(long idEmpleado, long idInteresado, long idVehiculo) {
        Notificacion notificacion = new Notificacion(idEmpleado, idInteresado, idVehiculo);

        notificacionRepository.save(notificacion);
    }
    
}
