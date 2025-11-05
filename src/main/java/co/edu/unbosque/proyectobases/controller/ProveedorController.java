package co.edu.unbosque.proyectobases.controller;

import co.edu.unbosque.proyectobases.model.Proveedor;
import co.edu.unbosque.proyectobases.service.ProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "*")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public List<Proveedor> listarProveedores() {
        return proveedorService.listarProveedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable Integer id) {
        Proveedor proveedor = proveedorService.obtenerProveedorPorId(id);
        return (proveedor != null)
                ? ResponseEntity.ok(proveedor)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor proveedor) {
        Proveedor nuevo = proveedorService.guardarProveedor(proveedor);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        Proveedor existente = proveedorService.obtenerProveedorPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        proveedor.setIdProveedor(id);
        Proveedor actualizado = proveedorService.guardarProveedor(proveedor);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Integer id) {
        Proveedor proveedor = proveedorService.obtenerProveedorPorId(id);
        if (proveedor == null) {
            return ResponseEntity.notFound().build();
        }
        proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }
}
