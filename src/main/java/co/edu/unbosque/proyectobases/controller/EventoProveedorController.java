package co.edu.unbosque.proyectobases.controller;

import co.edu.unbosque.proyectobases.model.EventoProveedor;
import co.edu.unbosque.proyectobases.service.EventoProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos-proveedor")
@CrossOrigin(origins = "*")
public class EventoProveedorController {

    private final EventoProveedorService eventoProveedorService;

    public EventoProveedorController(EventoProveedorService eventoProveedorService) {
        this.eventoProveedorService = eventoProveedorService;
    }

    @GetMapping
    public List<EventoProveedor> listarEventos() {
        return eventoProveedorService.listarEventos();
    }

    @GetMapping("/proveedor/{idProveedor}")
    public ResponseEntity<List<EventoProveedor>> listarEventosPorProveedor(@PathVariable Integer idProveedor) {
        List<EventoProveedor> eventos = eventoProveedorService.buscarPorProveedor(idProveedor);
        if (eventos == null || eventos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(eventos);
    }

    @PostMapping
    public ResponseEntity<EventoProveedor> crearEvento(@RequestBody EventoProveedor evento) {
        EventoProveedor nuevo = eventoProveedorService.guardarEvento(evento);
        return ResponseEntity.ok(nuevo);
    }
}
