package utn.frc.backend.pruebas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frc.backend.pruebas.model.Posicion;

@Repository
public interface PosicionRepository extends JpaRepository<Posicion, Long> {
}
