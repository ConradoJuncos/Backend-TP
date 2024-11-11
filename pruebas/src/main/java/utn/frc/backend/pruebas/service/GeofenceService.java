package utn.frc.backend.pruebas.service;

import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.dto.CoordenadasDTO;
import utn.frc.backend.pruebas.dto.ZonaRestringidaDTO;

import java.util.List;

@Service
public class GeofenceService {

    private final ServicioService servicioService;
    private List<ZonaRestringidaDTO> zonasRestringidas;
    private CoordenadasDTO coordenadasAgencia;
    private double radioAdmitidoKm;

    public GeofenceService(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    // Setter para actualizar coordenadas y zonas desde el servicio externo
    public void actualizarGeofence(CoordenadasDTO coordenadasAgencia,
                                   double radioAdmitidoKm,
                                   List<ZonaRestringidaDTO> zonasRestringidas) {
        this.coordenadasAgencia = coordenadasAgencia;
        this.radioAdmitidoKm = radioAdmitidoKm;
        this.zonasRestringidas = zonasRestringidas;
    }

    // Verifica si el vehículo está dentro del radio permitido
    public boolean estaDentroDelRadio(CoordenadasDTO ubicacionVehiculo) {
        double distancia = calcularDistanciaEuclidiana(ubicacionVehiculo, coordenadasAgencia);
        return distancia <= radioAdmitidoKm;
    }

    // Verifica si el vehículo está en una de las zonas restringidas
    public boolean estaEnZonaRestringida(CoordenadasDTO ubicacionVehiculo) {
        for (ZonaRestringidaDTO zona : zonasRestringidas) {
            if (ubicacionVehiculo.getLat() >= zona.getSureste().getLat()
                    &&
                    ubicacionVehiculo.getLat() <= zona.getNoroeste().getLat()
                    &&
                    ubicacionVehiculo.getLon() >= zona.getNoroeste().getLon()
                    &&
                    ubicacionVehiculo.getLon() <= zona.getSureste().getLon()) {
                return true;
            }
        }
        return false;
    }

    // Calcula la distancia euclidiana entre dos puntos
    private double calcularDistanciaEuclidiana(CoordenadasDTO punto1,
                                               CoordenadasDTO punto2) {
        if (punto2 == null) {
            servicioService.actualizarConfiguracion();
            actualizarGeofence(servicioService.getCoordenadasAgencia(),
                                servicioService.getRadioAdmitidoKm(),
                                servicioService.getZonasRestringidas());
            punto2 = servicioService.getCoordenadasAgencia();
        }
        double deltaX = punto1.getLat() - punto2.getLat();
        double deltaY = punto1.getLon() - punto2.getLon();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
