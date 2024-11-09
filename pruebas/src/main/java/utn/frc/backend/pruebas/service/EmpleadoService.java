package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import utn.frc.backend.pruebas.dto.EmpleadoDTO;

// Comunicación con el microservicio Empleados
@Service
public class EmpleadoService {

    private final RestTemplate restTemplate;
    private final String empleadosServiceUrl;

    @Autowired
    public EmpleadoService(RestTemplate restTemplate,
                           @Value("${empleados.service.url}") String empleadosServiceUrl) {
        this.restTemplate = restTemplate;
        this.empleadosServiceUrl = empleadosServiceUrl;
    }

    public EmpleadoDTO obtenerEmpleadoPorId(long idEmpleado) {
        String url = empleadosServiceUrl + "/" + idEmpleado;
        return restTemplate.getForObject(url, EmpleadoDTO.class);
    }
}
