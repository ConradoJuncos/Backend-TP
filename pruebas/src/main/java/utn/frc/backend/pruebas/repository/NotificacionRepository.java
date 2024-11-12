package utn.frc.backend.pruebas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utn.frc.backend.pruebas.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
