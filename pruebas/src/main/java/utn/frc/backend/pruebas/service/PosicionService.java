package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.model.Posicion;
import utn.frc.backend.pruebas.model.Prueba;
import utn.frc.backend.pruebas.repository.PosicionRepository;
import utn.frc.backend.pruebas.repository.PruebaRepository;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class PosicionService {

    @Autowired
    private PosicionRepository posicionRepository;
    @Autowired
    private PruebaRepository pruebaRepository;
    @Autowired
    private PruebaService pruebaService;

    public Posicion crearPosicion(long idVehiculo, double latitud, double longitud) {
        Posicion posicion = new Posicion(idVehiculo,
                new Timestamp(System.currentTimeMillis()),
                latitud,
                longitud);

        return posicionRepository.save(posicion);
    }

    public Optional<Posicion> obtenerPosicionPorId(long id) {
        return posicionRepository.findById(id);
    }

    public Optional<Posicion> obtenerPosicionMasReciente(long idVehiculo) {
        return posicionRepository.findTopByIdVehiculoOrderByFechaDesc(idVehiculo);
    }

    public Optional<Long> obtenerIdInteresadoPorVehiculo(long idVehiculo) {
        // Busca la prueba más reciente sin fecha de finalización para el vehículo dado
        Optional<Prueba> pruebaOpt = pruebaRepository.
                findFirstByVehiculo_IdAndFechaHoraFinIsNullOrderByFechaHoraInicioDesc(idVehiculo);

        // Si existe una prueba activa, devuelve el ID del interesado asociado a esa prueba
        return pruebaOpt.map(prueba -> prueba.getInteresado().getId());
    }

    // Método para obtener el id del empleado (o el empleado) con el id del vehiculo
    public Optional<Long> obtenerIdEmpleadoPorVehiculo(long idVehiculo) {
        // Busca la prueba más reciente sin fecha de finalización para el vehículo dado
        Optional<Prueba> pruebaOpt = pruebaRepository.
                findFirstByVehiculo_IdAndFechaHoraFinIsNullOrderByFechaHoraInicioDesc(idVehiculo);

        // Si existe una prueba activa, devuelve el ID del interesado asociado a esa prueba
        return pruebaOpt.map(Prueba::getIdEmpleado);
    }

}
