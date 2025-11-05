package co.edu.unbosque.proyectobases.controller;

import co.edu.unbosque.proyectobases.model.OrdenCompra;
import co.edu.unbosque.proyectobases.service.OrdenCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes-compra")
@CrossOrigin(origins = "*")
public class OrdenCompraController {

    private final OrdenCompraService ordenService;

    public OrdenCompraController(OrdenCompraService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping
    public List<OrdenCompra> listarOrdenes() {
        return ordenService.listarOrdenes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompra> obtenerOrdenPorId(@PathVariable Integer id) {
        OrdenCompra orden = ordenService.buscarPorId(id);
        return (orden != null)
                ? ResponseEntity.ok(orden)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/proveedor/{idProveedor}")
    public ResponseEntity<List<OrdenCompra>> listarPorProveedor(@PathVariable Integer idProveedor) {
        List<OrdenCompra> ordenes = ordenService.listarPorProveedor(idProveedor);
        if (ordenes == null || ordenes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ordenes);
    }

    @PostMapping
    public ResponseEntity<OrdenCompra> crearOrden(@RequestBody OrdenCompra orden) {
        OrdenCompra nueva = ordenService.guardarOrden(orden);
        return ResponseEntity.ok(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenCompra> actualizarOrden(@PathVariable Integer id, @RequestBody OrdenCompra orden) {
        OrdenCompra existente = ordenService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        orden.setIdOrden(id);
        OrdenCompra actualizada = ordenService.guardarOrden(orden);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable Integer id) {
        OrdenCompra existente = ordenService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        ordenService.eliminarOrden(id);
        return ResponseEntity.noContent().build();
    }
}
