package utn.frc.backend.pruebas.repository;

import utn.frc.backend.pruebas.model.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long> {

}
