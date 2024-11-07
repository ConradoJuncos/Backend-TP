package utn.frc.backend.empleados.exception;

public class EmpleadoNotFoundException extends RuntimeException {
    public EmpleadoNotFoundException(String message) {
        super(message);
    }
}
