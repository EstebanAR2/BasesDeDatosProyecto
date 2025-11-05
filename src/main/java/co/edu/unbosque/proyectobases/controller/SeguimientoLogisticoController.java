package co.edu.unbosque.proyectobases.controller;

import co.edu.unbosque.proyectobases.model.SeguimientoLogistico;
import co.edu.unbosque.proyectobases.service.SeguimientoLogisticoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguimientos-logisticos")
@CrossOrigin(origins = "*")
public class SeguimientoLogisticoController {

    private final SeguimientoLogisticoService seguimientoLogisticoService;

    public SeguimientoLogisticoController(SeguimientoLogisticoService seguimientoLogisticoService) {
        this.seguimientoLogisticoService = seguimientoLogisticoService;
    }

    @GetMapping
    public List<SeguimientoLogistico> listarSeguimientos() {
        return seguimientoLogisticoService.listarSeguimientos();
    }

    // Obtener un seguimiento por su ID
    @GetMapping("/{id}")
    public ResponseEntity<SeguimientoLogistico> obtenerPorId(@PathVariable String id) {
        SeguimientoLogistico seguimiento = seguimientoLogisticoService.buscarPorId(id);
        return (seguimiento != null)
                ? ResponseEntity.ok(seguimiento)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/proveedor/{idProveedor}")
    public ResponseEntity<List<SeguimientoLogistico>> listarPorProveedor(@PathVariable String idProveedor) {
        List<SeguimientoLogistico> seguimientos = seguimientoLogisticoService.listarPorProveedor(idProveedor);
        if (seguimientos == null || seguimientos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(seguimientos);
    }

    // Crear un nuevo seguimiento logístico
    @PostMapping
    public ResponseEntity<SeguimientoLogistico> crearSeguimiento(@RequestBody SeguimientoLogistico seguimiento) {
        SeguimientoLogistico nuevo = seguimientoLogisticoService.guardarSeguimiento(seguimiento);
        return ResponseEntity.ok(nuevo);
    }

    // Actualizar un seguimiento existente
    @PutMapping("/{id}")
    public ResponseEntity<SeguimientoLogistico> actualizarSeguimiento(@PathVariable String id, @RequestBody SeguimientoLogistico seguimiento) {
        SeguimientoLogistico existente = seguimientoLogisticoService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        seguimiento.setId(id);
        SeguimientoLogistico actualizado = seguimientoLogisticoService.guardarSeguimiento(seguimiento);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar un seguimiento logístico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSeguimiento(@PathVariable String id) {
        SeguimientoLogistico existente = seguimientoLogisticoService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        seguimientoLogisticoService.eliminarSeguimiento(id);
        return ResponseEntity.noContent().build();
    }
}
