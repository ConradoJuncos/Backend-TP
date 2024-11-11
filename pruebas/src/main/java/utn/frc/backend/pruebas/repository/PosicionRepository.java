package utn.frc.backend.pruebas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frc.backend.pruebas.model.Posicion;

import java.util.Optional;

@Repository
public interface PosicionRepository extends JpaRepository<Posicion, Long> {
    // Consulta para obtener la posición más reciente de un vehículo específico
    Optional<Posicion> findTopByIdVehiculoOrderByFechaDesc(long idVehiculo);
}
