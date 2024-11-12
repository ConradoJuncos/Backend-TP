package utn.frc.backend.pruebas.dto;

import utn.frc.backend.pruebas.dto.EmpleadoDTO;
import utn.frc.backend.pruebas.model.Interesado;
import utn.frc.backend.pruebas.model.Vehiculo;

import java.sql.Timestamp;

public class NotificacionDTO {

    private Long id;
    private EmpleadoDTO empleado;
    private Interesado interesado;
    private Vehiculo vehiculo;
    private Timestamp fechaHora;

    // Constructor que mapea la entidad Notificacion al DTO

    // todo - capaz es mejor mandarle una Notificacion y hacer this.interesado = notificacion.getInteresado()

    public NotificacionDTO(Long id, EmpleadoDTO empleado, Interesado interesado, Vehiculo vehiculo, Timestamp fechaHora) {
        this.id = id;
        this.empleado = empleado;
        this.interesado = interesado;
        this.vehiculo = vehiculo;
        this.fechaHora = fechaHora;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }
}
