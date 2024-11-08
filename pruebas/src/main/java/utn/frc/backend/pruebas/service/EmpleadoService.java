package utn.frc.backend.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import utn.frc.backend.pruebas.dto.EmpleadoDTO;

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

    public EmpleadoDTO obtenerEmpleadoPorId(int idEmpleado) {
        String url = empleadosServiceUrl + "/empleados/" + idEmpleado;
        return restTemplate.getForObject(url, EmpleadoDTO.class);
    }
}
