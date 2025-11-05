package co.edu.unbosque.proyectobases.controller;

import co.edu.unbosque.proyectobases.model.Contrato;
import co.edu.unbosque.proyectobases.service.ContratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
@CrossOrigin(origins = "*")
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @GetMapping
    public List<Contrato> listarContratos() {
        return contratoService.listarContratos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> obtenerContratoPorId(@PathVariable Integer id) {
        Contrato contrato = contratoService.buscarPorId(id);
        return (contrato != null)
                ? ResponseEntity.ok(contrato)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Contrato> crearContrato(@RequestBody Contrato contrato) {
        Contrato nuevo = contratoService.guardarContrato(contrato);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> actualizarContrato(@PathVariable Integer id, @RequestBody Contrato contrato) {
        Contrato existente = contratoService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        contrato.setIdContrato(id);
        Contrato actualizado = contratoService.guardarContrato(contrato);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContrato(@PathVariable Integer id) {
        Contrato contrato = contratoService.buscarPorId(id);
        if (contrato == null) {
            return ResponseEntity.notFound().build();
        }
        contratoService.eliminarContrato(id);
        return ResponseEntity.noContent().build();
    }
}
