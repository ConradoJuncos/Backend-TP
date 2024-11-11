package utn.frc.backend.pruebas.repository;

import utn.frc.backend.pruebas.model.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long> {
    // Encontrar pruebas activas de un vehículo específico
    List<Prueba> findByVehiculoIdAndFechaHoraFinIsNull(Long vehiculoId);

    // Obtener todas las pruebas en curso (fechaHoraFin es null)
    List<Prueba> findByFechaHoraFinIsNull();

    // Busca la prueba más reciente sin fecha de finalización para el vehículo dado
    Optional<Prueba> findFirstByVehiculo_IdAndFechaHoraFinIsNullOrderByFechaHoraInicioDesc(long idVehiculo);
}
