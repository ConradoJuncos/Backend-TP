package utn.frc.backend.pruebas.repository;

import utn.frc.backend.pruebas.model.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long> {
    // Encontrar pruebas activas de un vehículo específico
    List<Prueba> findByVehiculoIdAndFechaHoraFinIsNull(Long vehiculoId);

    // Obtener todas las pruebas en curso (fechaHoraFin es null)
    List<Prueba> findByFechaHoraFinIsNull();
}
