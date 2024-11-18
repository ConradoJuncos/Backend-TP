package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.model.Posicion;
import utn.frc.backend.pruebas.model.Prueba;
import utn.frc.backend.pruebas.repository.PosicionRepository;
import utn.frc.backend.pruebas.repository.PruebaRepository;

import java.sql.Timestamp;
import java.util.List;
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

    public double calcularKilometrosRecorridos(long idVehiculo, Timestamp fechaInicio, Timestamp fechaFin) {
        // Obtener las posiciones en el período
        List<Posicion> posiciones = posicionRepository.findByIdVehiculoAndFechaBetweenOrderById(idVehiculo, fechaInicio, fechaFin);

        if (posiciones.size() < 2) {
            return 0; // No hay suficiente información para calcular distancias
        }

        double distanciaTotal = 0.0;

        // Calcular distancias entre pares consecutivos
        for (int i = 1; i < posiciones.size(); i++) {
            Posicion p1 = posiciones.get(i - 1);
            Posicion p2 = posiciones.get(i);

            double distancia = calcularDistanciaHaversine(
                    p1.getLatitud(), p1.getLongitud(),
                    p2.getLatitud(), p2.getLongitud()
            );
            distanciaTotal += distancia;
        }

        return distanciaTotal;
    }

    private double calcularDistanciaHaversine(double lat1, double lon1, double lat2, double lon2) {
        final double RADIO_TIERRA_KM = 6371.0;

        // Convertir grados a radianes
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Diferencias entre las coordenadas
        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        // Fórmula de haversine
        double a = Math.pow(Math.sin(deltaLat / 2), 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distancia en kilómetros
        return RADIO_TIERRA_KM * c;
    }

}
