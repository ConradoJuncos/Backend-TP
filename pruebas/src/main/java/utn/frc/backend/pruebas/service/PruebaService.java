package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.dto.EmpleadoDTO;
import utn.frc.backend.pruebas.model.Prueba;

@Service
public class PruebaService {

    private final EmpleadoService empleadoService;

    @Autowired
    public PruebaService(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    public Prueba crearPruebaConEmpleado(int idEmpleado) {
        // Llamada al microservicio Empleados para obtener los detalles del empleado
        EmpleadoDTO empleado = empleadoService.obtenerEmpleadoPorId(idEmpleado);

        // Lógica para crear una prueba, usando el Empleado obtenido
        // todo - NO CREAR LAS PRUEBAS CON SETS, SINO CON EL CONSTRUCTOR QUE LO HACE CON this.atr = ññññ
        // todo - Crear el constructor de prueba correcto, con Empleado, Interesado y Auto creo
        Prueba prueba = new Prueba();
//        prueba.setIdEmpleado(idEmpleado);
        prueba.setComentarios("Prueba asignada a: " + empleado.getNombre() + " " + empleado.getApellido());

        // Guardar la prueba o realizar otras operaciones
        // Por ejemplo: pruebaRepository.save(prueba);

        return prueba;
    }
}
