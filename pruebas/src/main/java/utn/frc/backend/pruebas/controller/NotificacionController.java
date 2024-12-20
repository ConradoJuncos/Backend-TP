package utn.frc.backend.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.frc.backend.pruebas.dto.NotificacionDTO;
import utn.frc.backend.pruebas.service.NotificacionService;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public List<NotificacionDTO> obtenerTodasLasNotificaciones() {
        return notificacionService.obtenerTodasLasNotificaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionDTO> obtenerNotificacionPorId(@PathVariable long id) {
        return notificacionService.obtenerNotificacionPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/empleado/{idEmpleado}")
    public List<NotificacionDTO> obtenerNotificacionesPorEmpleado(@PathVariable long idEmpleado) {
        return notificacionService.obtenerNotificacionesPorEmpleado(idEmpleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarNotificacion(@PathVariable Long id) {
        notificacionService.borrarNotificacion(id);
        return ResponseEntity.ok("Notificación con ID " + id + " eliminada exitosamente.");
    }
}
