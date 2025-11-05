package co.edu.unbosque.proyectobases.controller;

import co.edu.unbosque.proyectobases.model.Componente;
import co.edu.unbosque.proyectobases.service.ComponenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/componentes")
@CrossOrigin(origins = "*")
public class ComponenteController {

    private final ComponenteService componenteService;

    public ComponenteController(ComponenteService componenteService) {
        this.componenteService = componenteService;
    }

    @GetMapping
    public List<Componente> listarComponentes() {
        return componenteService.listarComponentes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Componente> obtenerComponentePorId(@PathVariable Integer id) {
        Componente componente = componenteService.buscarPorId(id);
        return (componente != null)
                ? ResponseEntity.ok(componente)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Componente> crearComponente(@RequestBody Componente componente) {
        Componente nuevo = componenteService.guardarComponente(componente);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Componente> actualizarComponente(@PathVariable Integer id, @RequestBody Componente componente) {
        Componente existente = componenteService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        componente.setIdComponente(id);
        Componente actualizado = componenteService.guardarComponente(componente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComponente(@PathVariable Integer id) {
        Componente componente = componenteService.buscarPorId(id);
        if (componente == null) {
            return ResponseEntity.notFound().build();
        }
        componenteService.eliminarComponente(id);
        return ResponseEntity.noContent().build();
    }
}
