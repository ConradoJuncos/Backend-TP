package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.frc.backend.pruebas.model.Posicion;
import utn.frc.backend.pruebas.repository.PosicionRepository;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class PosicionService {

    @Autowired
    private PosicionRepository posicionRepository;

    public Posicion crearPosicion(long idVehiculo, double latitud, double longitud) {
        Posicion posicion = new Posicion();
        posicion.setIdVehiculo(idVehiculo);
        posicion.setFecha(new Timestamp(System.currentTimeMillis()));
        posicion.setLatitud(latitud);
        posicion.setLongitud(longitud);

        return posicionRepository.save(posicion);
    }

    public Optional<Posicion> obtenerPosicionPorId(long id) {
        return posicionRepository.findById(id);
    }
}
