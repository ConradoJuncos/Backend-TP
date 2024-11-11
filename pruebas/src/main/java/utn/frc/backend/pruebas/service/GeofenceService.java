package utn.frc.backend.pruebas.service;

//public class GeofenceService {
//
//    // Verifica si el vehículo está dentro del radio permitido
//    public boolean estaDentroDelRadio(Coordenadas ubicacionVehiculo, Coordenadas coordenadasAgencia, double radioAdmitidoKm) {
//        double distancia = calcularDistanciaEuclidiana(ubicacionVehiculo, coordenadasAgencia);
//        return distancia <= radioAdmitidoKm;
//    }
//
//    // Verifica si el vehículo está en una de las zonas restringidas
//    public boolean estaEnZonaRestringida(Coordenadas ubicacionVehiculo, List<ZonaRestringida> zonasRestringidas) {
//        for (ZonaRestringida zona : zonasRestringidas) {
//            if (ubicacionVehiculo.lat >= zona.getSureste().lat && ubicacionVehiculo.lat <= zona.getNoroeste().lat
//                    && ubicacionVehiculo.lon >= zona.getNoroeste().lon && ubicacionVehiculo.lon <= zona.getSureste().lon) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // Calcula la distancia euclidiana entre dos puntos
//    private double calcularDistanciaEuclidiana(Coordenadas punto1, Coordenadas punto2) {
//        double deltaX = punto1.lat - punto2.lat;
//        double deltaY = punto1.lon - punto2.lon;
//        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
//    }
//}
