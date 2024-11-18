package utn.frc.backend.pruebas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frc.backend.pruebas.model.Posicion;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface PosicionRepository extends JpaRepository<Posicion, Long> {
    // Consulta para obtener la posición más reciente de un vehículo específico
    Optional<Posicion> findTopByIdVehiculoOrderByFechaDesc(long idVehiculo);
    // Consulta para obtener una lista de posiciones de un vehiculo en un periodo
    List<Posicion> findByIdVehiculoAndFechaBetweenOrderById(long idVehiculo, Timestamp fechaInicio, Timestamp fechaFin);
}
