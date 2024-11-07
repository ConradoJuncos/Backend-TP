package utn.frc.backend.empleados.repository;

import utn.frc.backend.empleados.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
