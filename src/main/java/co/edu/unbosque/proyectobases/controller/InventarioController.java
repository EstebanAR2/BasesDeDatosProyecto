package co.edu.unbosque.proyectobases.controller;

import co.edu.unbosque.proyectobases.model.Inventario;
import co.edu.unbosque.proyectobases.service.InventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
@CrossOrigin(origins = "*")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public List<Inventario> obtenerTodos() {
        return inventarioService.obtenerTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Inventario> obtenerPorId(@PathVariable int id) {
        return inventarioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/proveedor/{proveedorId}")
    public List<Inventario> obtenerPorProveedor(@PathVariable int proveedorId) {
        return inventarioService.obtenerPorProveedor(proveedorId);
    }

    @PostMapping
    public ResponseEntity<Inventario> crear(@RequestBody Inventario inventario) {
        Inventario nuevo = inventarioService.guardar(inventario);
        return ResponseEntity.ok(nuevo);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Inventario> actualizar(@PathVariable int id, @RequestBody Inventario inventario) {
        try {
            Inventario actualizado = inventarioService.actualizar(id, inventario);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        inventarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}